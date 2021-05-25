package com.example.ProyectoConcesionario.OwnerServlet;

import Servicios.OwnerService;
import cliente.controller.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
@WebServlet(urlPatterns = "/addOwner.do")
public class AddOwnerServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    private OwnerService ownerServices = new OwnerService();



    public AddOwnerServlet() {
        super();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            int cedula = Integer.parseInt(request.getParameter("cedula")) ;
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            long telefono = Long.parseLong(request.getParameter("telefono")) ;
            String email = request.getParameter("email");

            OwnerService.addOwner(cedula, nombre, apellido, telefono, email);

        } catch (Exception e)
        {
            //Excepción de traducción de fecha
            e.printStackTrace();
        }

    }

}
