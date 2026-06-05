/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.GestionarEquipo;
import modelo.Equipo;
/**
 *
 * @author apaga bien la pc
 */
@WebServlet(name = "ControladorInsEquipo", urlPatterns = {"/ControladorInsEquipo"})
public class ControladorInsEquipo extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String nombre = request.getParameter("nombre");
        String pais = request.getParameter("pais");
        String localidad = request.getParameter("localidad");
        int puntos = Integer.parseInt(request.getParameter("puntos"));
        int pj = Integer.parseInt(request.getParameter("partjugados"));
        int pg = Integer.parseInt(request.getParameter("partganados"));
        int pp = Integer.parseInt(request.getParameter("partperdidos"));
        
        //creamos un equipo con la informacion que viene del formulario
        Equipo t = new Equipo();
        t.setNombre(nombre);
        t.setPais(pais);
        t.setLocalidad(localidad);
        t.setPuntos(puntos);
        t.setPartJugados(pj);
        t.setPartGanados(pg);
        t.setPartPerdidos(pp);
        //guardamos en la base de datos al equipo.
        GestionarEquipo gt = new GestionarEquipo();
        boolean b = gt.insertarEquipo(t);
        //seteamos la informacion que queremos enviar a la vista
        request.setAttribute("t", t);
        request.setAttribute("b", b);
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            RequestDispatcher a = request.getRequestDispatcher("resultadoEquipo.jsp");
            a.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}