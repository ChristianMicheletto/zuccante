<%@ page contentType="text/html" %>
<%@ page import="java.sql.*" %>
<html>
<head>
  <title>SQLitetest</title>
  <style>


    td {
        border: 1px solid #98bf21;
        padding: 3px 7px 2px 7px;
        color: #000000;
        background-color: #EAF2D3;
    }
    h3 {
        color: #98bf21;
        padding: 3px 7px 2px 7px;
    }

</style>
</head>
<body>
  <h3>QUERR Y SELECT</h3>
  <table>
  <%
  ResultSet rs = (ResultSet)request.getAttribute("resultSet");
  while (rs.next()) {
  %>
    <tr>
      <td><%=String.valueOf(rs.getInt("_id"))%></td>
      <td><%=rs.getString("name")%></td>
      <td><%=rs.getString("description")%></td>
      <td><%=String.valueOf(rs.getFloat("price"))%> &#x20AC</td>
    </tr>
  <%
  }
  %>
  </table>
</body>
</html>
