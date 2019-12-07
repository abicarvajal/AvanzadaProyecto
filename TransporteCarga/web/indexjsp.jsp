<%-- 
    Document   : indexjsp
    Created on : 4/12/2019, 12:36:33 AM
    Author     : Abi
--%>

<%@page import="ec.edu.espe.transportecarga.model.Conexion"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="static/css/index.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/solid.css">
    <script src="https://use.fontawesome.com/releases/v5.0.7/js/all.js"></script>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <!-- Nuestro css-->
    <link rel="stylesheet" type="text/css" href="static/css/index.css" th:href="@{/css/index.css}">
        <title>Clientes</title>
    </head>
    <body>
        <%
        //Conexión a la BD
      
        Conexion con=new Conexion();
        Connection acceso = con.obtenerConexion();
        PreparedStatement ps;
        ResultSet rs;
        String sql = "select * from cliente";
        
        ps=acceso.prepareStatement(sql);
        rs=ps.executeQuery();
        %>
        <div class="modal-dialog text-center">
        <div class="main-section">
        <div class="modal-content">
        <div class="col-12 user-img">
                    <img src="static/img/user.png" th:src="@{/img/user.png}" /><br>
                    <label for="carga">CARGA PESADA ACME</label><br><br>
                    <label for="client">Mostrar Clientes</label>
        </div>

        <hr>
        <table class="table table-bordered">
            <tr>
                <th>ID</th>
                <th>NOMBRE</th>
                <th>TELEFONO</th>
                <th>CORREO</th>
                <th>CIUDAD</th>
                <th>ZONA</th>
                <th>CALLE PRINCIPAL</th>
                <th>CALLE SECUNDARIA</th>
                <th>LOTE</th>
            </tr>
            <%
                while(rs.next()){
                    
            %>
            <tr>
                <td><%=rs.getString("identificacion")%> </td>
                <td><%=rs.getString("nombre")%> </td>
                <td><%=rs.getString("telefono")%> </td>
                <td><%=rs.getString("correo")%> </td>
                <td><%=rs.getString("ciudad")%> </td>
                <td><%=rs.getString("zona")%> </td>
                <td><%=rs.getString("calleP")%> </td>
                <td><%=rs.getString("calleS")%> </td>
                <td><%=rs.getString("lote")%> </td>
                
            </tr>
            <%}%>
        </table>
        </div>
        </div>
        </div>
    </body>
</html>
