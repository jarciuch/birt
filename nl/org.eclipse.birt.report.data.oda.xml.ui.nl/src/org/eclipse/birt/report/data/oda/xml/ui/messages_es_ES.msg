# wizard dialog messages
wizard.title.selectFolder=Fuente de datos XML
wizard.defaultMessage.selectFolder=Defina las URL al archivo XML y la informaci�n de esquema.
wizard.title.newDataSet=Nuevo conjunto de datos
wizard.title.selectXmlFile=Seleccionar datos XML para la vista previa
wizard.defaultMessage.selectFile=Seleccione una fuente de XML de muestra para activar la vista previa de datos en esta secci�n.
wizard.title.xPathChoose=Definir asignaci�n de tablas
wizard.defaultMessage.selectXPath=Defina el elemento que se va a utilizar como tabla seleccionando el elemento en la estructura XML y a�adi�ndolo a la asignaci�n de tablas. S�lo puede haber una asignaci�n de tablas por cada conjunto de datos XML.
wizard.title.selectColumn=Definir asignaci�n de columnas
wizard.title.defineColumnMapping=Defina la asignaci�n de columnas seleccionando un elemento o un atributo en la estructura XML y a�adi�ndolo a la asignaci�n de columnas. 

#preference
designer.preview.preference.numberOfElementPassedToGetSchema=N�mero de elementos con acceso en el an�lisis de �rbol de esquema XML.
designer.preview.preference.numberOfElementPassedToGetSchema.errormessage=Introduzca un n�mero entre 0 y {0}.
designer.preview.preference.columnMappingPage.group.title=P�gina de asignaci�n de columnas

#table mapping page messages
xPathChoosePage.messages.rowMapping=Asignaci�n de tablas
xPathChoosePage.messages.xPathExpression=Expresi�n &XPath
xPathChoosePage.messages.xmlStructure=Estructura XML
xPathChoosePage.messages.xmlColumnMapping=Asignaci�n de columnas

#sample xml data file page messages
xmlDataSetSelectionPage.messages.lineofdata=l�neas de fuente de datos
xmlDataSetSelectionPage.warning.errorReadXMLFile=Error al leer los datos XML del archivo [{0}]\n{1}. �Desea continuar?

#column mapping page messages
button.refresh=Actualizar
menu.menuItem.removeAll=Quitar todos
menu.menuItem.remove=Quitar
lable.selectXmlFile=Introduzca la URL de la fuente &XML o busque el archivo que contiene los datos:
lable.selectXmlSchmaFile=Introduzca la URL del esquema X&ML o busque el archivo que contiene el\n esquema. D�jelo vac�o si no hay ning�n esquema disponible:
label.preview=&Previsualizar primero
label.useXMLFileFromDataSource=Utilizar el archivo XML definido en la fuente de datos
RowMappingDialog.title=Seleccione o edite la expresi�n XPath.
RowMappingDialog.info=Seleccione una de las expresiones XPath predefinidas para el nodo que ha seleccionado o\n introduzca otra expresi�n:
ColumnMappingDialog.info.columnName=Nombre de columna:
ColumnMappingDialog.info.xPath=Expresi�n XPath:
ColumnMappingDialog.info.dataType=Tipo de datos:
ColumnMappingDialog.info.dataPreview=Vista previa de tablas
ColumnMappingDialog.prompt.new=Nueva asignaci�n aqu�...
ColumnMappingDialog.prompt.maxRow=Los datos fuente tienen m�s de 500 l�neas. La vista previa s�lo mostrar� las primeras 500 l�neas en esta p�gina.
ColumnMappingDialog.prompt.dialog.title=Vista previa de resultados

dataset.editor.columnName=Nombre
dataset.editor.xpathexpression=XPath
dataset.editor.datatype=Tipo
dataset.editor.rowelement=Elemento de fila
dataset.error.populateXMLTree=No se puede recuperar la fuente de datos XML. El archivo de fuente de datos XML no es v�lido o no existe.

error.label=Error
error.selectFolder=La URL de archivo seleccionada no es v�lida o el archivo no existe.
error.emptyPath=La URL del archivo est� vac�a.
error.xpath.canNotContainAttribute=No se puede asignar la expresi�n XPath a un atributo XML.
error.dataset.maxRowNumberError=La fila m�xima debe ser un n�mero.
error.columnMapping.noMappingColumn=Asigne al menos una columna.
error.file.null=Todas las URL est�n vac�as, lo que significa que no ha seleccionado ninguna fuente de datos. �Seguro que desea conservarlo?
error.columnMapping.sameColumnName=El nombre de la columna [{0}] ya existe. Utilice otro nombre.
error.invalidXpath=La expresi�n XPath  "{0}" no es v�lida.

#data types for column mapping
datatypes.dateTime=Fecha/hora
datatypes.decimal=Decimal largo
datatypes.float=Doble
datatypes.integer=Entero
datatypes.string=String
datatypes.date=Fecha
datatypes.time=Hora

#column name in column mapping table
columnName.name=Nombre
columnName.xPathName=XPath
columnName.typeName=Tipo

dataset.new=Nuevo conjunto de datos
file.choose=&Examinar...
title.warning=Advertencia

datasource.propertyPage.tooltip=Fuente de datos XML
