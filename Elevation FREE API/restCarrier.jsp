<%-- 
    Document   : restCarrier
    Created on : 04-dic-2019, 10:32:42
    Author     : Melissa
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="ec.edu.espe.clientes.model.transportistaVO"%>
<%@page import="ec.edu.espe.clientes.model.transportistaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="restAgregarCarrier.jsp" method="POST">
            <input type="submit" value="Volver a formularios" />
        </form>
        <%
            //las variables que nos llegan son: txt1, txt2, radio1, ck1, select1, textarea1
           String identificacion, nombre, direccion, telefono, correo, placa, zona;
               identificacion = request.getParameter("cedula");
               nombre = request.getParameter("nombre");
               direccion = request.getParameter("direccion");
               telefono = request.getParameter("telefono");
               correo = request.getParameter("correo");
               placa = request.getParameter("placa");
               zona = request.getParameter("zona");
               transportistaDAO dao=new transportistaDAO();
               transportistaVO vo=new transportistaVO();
               vo.setIdentificacion(identificacion);
               vo.setNombre(nombre);
               vo.setDireccion(direccion);
               vo.setTelefono(telefono);
               vo.setCorreo(correo);
               vo.setPlaca(placa);
               vo.setZona(zona);
               dao.setServices(vo); 
out.println(vo.toString());
        %>
       
    </body>
</html>
