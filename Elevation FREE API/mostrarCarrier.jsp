<%-- 
    Document   : mostrar
    Created on : 04-dic-2019, 7:54:36
    Author     : Melissa
--%>
<%@page import="java.awt.TrayIcon.MessageType"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        
        <%
       //CONECTANOD A LA BASE DE DATOS:
       Connection con;
       String url="jdbc:mysql://localhost:3306/proyecto?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
       String Driver="com.mysql.jdbc.Driver";
       String user="root";
       String clave="";
       Class.forName(Driver);
       con=DriverManager.getConnection(url,user,clave);
       PreparedStatement ps;
       ps=con.prepareStatement("select * from transportista");
       ResultSet rs=ps.executeQuery();
       
%>
<div class="container">
    <table  class="table table-bordered"  id="tablaDatos">
        <tr>
            <th class="text-center">Nombre</th>
            <th class="text-center">Identificacion</th>
            <th class="text-center">Direccion</th>
            <th class="text-center">Teléfono</th>
            <th class="text-center">Correo</th>
            <th class="text-center">Placa</th>
            <th class="text-center">Zona</th>
        </tr>
        <%while(rs.next()){
         %>
         <tr>
             <td class="text-center"><%=rs.getString("identificacion")%></td>
            <td class="text-center"><%=rs.getString("nombre")%></td>
            <td class="text-center"><%=rs.getString("direccion")%></td>
            <td class="text-center"><%=rs.getString("telefono")%></td>
            <td class="text-center"><%=rs.getString("correo")%></td>
            <td class="text-center"><%=rs.getString("placa")%></td>
            <td class="text-center"><%=rs.getString("zona")%></td>
         </tr>
         <%}%>
    </table>
</div>
    </body>
</html>
