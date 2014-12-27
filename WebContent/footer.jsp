<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<br/>
<footer>
<%Date d= new Date(); SimpleDateFormat ladate = new SimpleDateFormat("dd/MM/yyyy");%>
<p style="text-align:center">Nous sommes le <%=ladate.format(d) %> - Application développée par Baptiste BILLY</p>
</footer>
</body>

</html>