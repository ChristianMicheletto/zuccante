<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>File Upload</title>
</head>
<body>
<%
  String firstName = request.getParameter("first_name");
  session.setAttribute("first_name", firstName);
  String lastName = request.getParameter("last_name");
  session.setAttribute("last_name", lastName);
  String schoolClass = request.getParameter("school_class");
  session.setAttribute("school_class", schoolClass);
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

<h1>File Upload</h1>
<form method="post" action="upload"
        enctype="multipart/form-data">
        Testo della verifica compilato: <input type="file" name="testo" size="60" /><br />
        Allegato zip: <input type="file" name="testo" size="60" /><br />
        <br /> <input type="submit" value="Submit" />
</form>
</body>
</html>
