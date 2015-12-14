<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consegna</title>
</head>
<body>
<%
  String firstName = (String) session.getAttribute("first_name");
  String lastName = (String) session.getAttribute("last_name");
  String schoolClass = (String) session.getAttribute("school_class");
%>
<h1>Dati</h1>
<form>
  <fieldset style="width: 200px; height: 100px">
    <legend>nome, cognome e classe</legend>
    Cognome: <input type="text" value="<%= lastName%>" maxlength="12" size="12">
    <br />
    Nome: <input type="text" value="<%= firstName%>" maxlength="12" size="12"/>
    <br />
    Classe: <input type="text" value="<%= schoolClass%>" maxlength="3" size="3">
    <br />
    <br />
  </fieldset>
</form>
<h1>Consegnato</h1>
<% session.invalidate();%>
</body>
</html>
