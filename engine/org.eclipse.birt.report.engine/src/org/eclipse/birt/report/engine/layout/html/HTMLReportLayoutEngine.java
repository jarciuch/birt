/***********************************************************************
 * Copyright (c) 2004, 2008 Actuate Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Actuate Corporation - initial API and implementation
 ***********************************************************************/

package org.eclipse.birt.report.engine.layout.html;

import java.util.HashMap;
import java.util.Locale;

import org.eclipse.birt.report.engine.api.IEngineTask;
import org.eclipse.birt.report.engine.api.IPDFRenderOption;
import org.eclipse.birt.report.engine.api.impl.EngineTask;
import org.eclipse.birt.report.engine.content.IContent;
import org.eclipse.birt.report.engine.content.IReportContent;
import org.eclipse.birt.report.engine.emitter.IContentEmitter;
import org.eclipse.birt.report.engine.executor.IReportExecutor;
import org.eclipse.birt.report.engine.extension.IReportItemExecutor;
import org.eclipse.birt.report.engine.internal.executor.dom.DOMReportItemExecutor;
import org.eclipse.birt.report.engine.layout.ILayoutManager;
import org.eclipse.birt.report.engine.layout.ILayoutPageHandler;
import org.eclipse.birt.report.engine.layout.IReportLayoutEngine;
import org.eclipse.birt.report.engine.layout.html.buffer.DummyPageBuffer;
import org.eclipse.birt.report.engine.layout.html.buffer.HTMLPageBuffer;
import org.eclipse.birt.report.engine.layout.html.buffer.IPageBuffer;
import org.eclipse.birt.report.engine.presentation.IPageHint;

public class HTMLReportLayoutEngine implements IReportLayoutEngine
{

	/**
	 * context used to layout the report. each engine will have the only one
	 * context.
	 */
	protected HTMLLayoutContext context;

	/**
	 * factory used to store the layout manager. each engine will have its own
	 * factory.
	 */
	protected HTMLLayoutManagerFactory factory;

	protected ILayoutPageHandler pageHandler;

	/**
	 * executor used to create the master page
	 */
	protected IReportExecutor executor;
	
	protected HashMap options;
	
	protected Locale locale;
	
	protected IPageHint pageHint;

	protected long pageCount;
	
	protected long totalPage;
	
	public HTMLReportLayoutEngine( )
	{
		options = new HashMap();
		context = new HTMLLayoutContext( this );
		factory = new HTMLLayoutManagerFactory( this );
	}

	HTMLLayoutContext getContext( )
	{
		return context;
	}

	HTMLLayoutManagerFactory getFactory( )
	{
		return factory;
	}

	public void layout( IReportExecutor executor, IReportContent report, IContentEmitter emitter, boolean pagination )
	{
		this.executor = executor;
		
		context.setAllowPageBreak( pagination );
		setupLayoutOptions();		

		context.setFinish(  false );
		if(pageHint!=null)
		{
			context.setLayoutPageHint( pageHint );
		}
		IPageBuffer bufferMgr = null; 
		if(pagination)
		{
			bufferMgr = new HTMLPageBuffer(context);
		}
		else
		{
			bufferMgr = new DummyPageBuffer(context, executor);
		}
		context.setPageBufferManager( bufferMgr );
		HTMLPageLM pageLM = new HTMLPageLM( this, report, executor, emitter );

		boolean finished = false;
		do
		{
			pageLM.layout( );
			finished = pageLM.isFinished( );
		} while ( !finished );
		
		pageLM.close( );

		context.setFinish(  true );
		if ( pageHandler != null )
		{
			pageHandler.onPage( context.getPageNumber( ), context );
		}
		executor.close( );
		pageCount += context.getPageCount( );
		context.reset( );
		pageHint = null;
	}

	public void layout( ILayoutManager parent, IReportItemExecutor executor, IContentEmitter emitter )
	{
		IContent content = executor.execute( );
		ILayoutManager layoutManager = factory.createLayoutManager(
				(HTMLAbstractLM) parent, content, executor, emitter );
		boolean hasNext = layoutManager.layout( );
		while ( hasNext )
		{
			hasNext = layoutManager.layout( );
		}
		layoutManager.close( );
	}

	public void layout( ILayoutManager parent, IContent content, IContentEmitter output )
	{
		IReportItemExecutor executor = new DOMReportItemExecutor( content );
		layout( parent, executor, output );
		executor.close( );
	}

	ILayoutManager createLayoutManager( HTMLAbstractLM parent,
			IContent content, IReportItemExecutor executor,
			IContentEmitter emitter )
	{
		return factory.createLayoutManager( parent, content, executor, emitter );
	}
	
	protected void setupLayoutOptions( )
	{
		Object outputDisplayNone = options
				.get( IPDFRenderOption.OUTPUT_DISPLAY_NONE );
		if ( outputDisplayNone instanceof Boolean )
		{
			if ( ( (Boolean) outputDisplayNone ).booleanValue( ) )
			{
				context.setOutputDisplayNone( true );
			}
		}
		
		Object taskType = options.get( EngineTask.TASK_TYPE );
		if ( taskType instanceof Integer )
		{
			int type = ( (Integer) taskType ).intValue( );
			if ( type == IEngineTask.TASK_RUN )
			{
				context.setLayoutPageContent( false );
			}
		}
		
	}

	public void setPageHandler( ILayoutPageHandler handler )
	{
		this.pageHandler = handler;
	}

	public ILayoutPageHandler getPageHandler( )
	{
		return this.pageHandler;
	}
	
	public void cancel()
	{
		if(context!=null)
		{
			context.setCancelFlag( true );
		}
	}
	
	
	public void setOption(String name, Object value)
	{
		options.put(name, value);
	}
	
	public Object getOption(String name)
	{
		return options.get(name);
	}
	
	public void setLocale(Locale locale)
	{
		this.locale = locale;
	}

	public void setLayoutPageHint( IPageHint pageHint )
	{
		this.pageHint = pageHint;
	}

	public long getPageCount( )
	{
		return pageCount;
	}

	public void close( )
	{
		// TODO Auto-generated method stub
		
	}

	public void setTotalPageCount( long totalPage )
	{
		this.totalPage = totalPage;
		
	}

}
