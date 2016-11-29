<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <body>
                <h2>Characters</h2>
                <table border="1">
                    <tr bgcolor="#9acd32">
                        <th>journalist</th>
                        <th>editor</th>
                        <th>chief-editor</th>
                    </tr>
                        <tr>
                            <td><xsl:value-of select="Root/Characters/Jurnolist"/></td>
                            <td><xsl:value-of select="Root/Characters/Editor"/></td>
                            <td><xsl:value-of select="Root/Characters/Chief"/></td>
                        </tr>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>