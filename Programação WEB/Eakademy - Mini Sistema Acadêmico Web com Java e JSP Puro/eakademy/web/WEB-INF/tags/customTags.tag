<%-- 
    Document   : customTags
    Created on : 23/05/2019, 20:09:06
    Author     : Pedro Davi
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="message"%>

<%-- any content can be specified here e.g.: --%>
 <% response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");%>