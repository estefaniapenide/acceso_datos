<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html> <xsl:apply-templates/> </html>
    </xsl:template>
    <xsl:template match="ListaLibrosBiblioteca">
        <head><title>LISTADO DE LIBROS</title></head>
        <body>
        <h1>LISTADO DE LIBROS</h1>
        <table border="1" width="50%">
        <tr><th>Título</th><th>Autor</th><th>Precio</th></tr>
        <xsl:apply-templates select='DatosLibro'/>
        </table>
        </body>
    </xsl:template>
    <xsl:template match='DatosLibro'>
        <tr><xsl:apply-templates /></tr>
    </xsl:template>
    <xsl:template match='titulo|autor|precio'>
        <td><xsl:apply-templates /></td>
    </xsl:template>
</xsl:stylesheet>
