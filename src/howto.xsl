<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                              xmlns:fo="http://www.w3.org/1999/XSL/Format" >
<xsl:output method="text" omit-xml-declaration="yes" indent="no"/>

<xsl:template match="/">
shop,user,date,transaction,itemtype,itemid,description,price,totalprice

<xsl:for-each select="//shop">
   <xsl:value-of select="@id" />
   <xsl:value-of select="concat(',' , user, ',' , date,',' , transaction, ',' ,itemtype,',' ,itemid, ',' ,description, ',' ,price, ',' ,totalprice, '  ')"/> 
 <xsl:variable name="newline">
<xsl:text>
</xsl:text>
</xsl:variable>
<xsl:value-of select="$newline"/>
</xsl:for-each>
</xsl:template>
</xsl:stylesheet>