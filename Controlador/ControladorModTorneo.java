package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.GestionarTorneo;
import modelo.Torneo;

@WebServlet(name = "ControladorModTorneo", urlPatterns = {"/ControladorModTorneo"})
public class ControladorModTorneo extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int idTorneo = Integer.parseInt(request.getParameter("IdTorneo"));
        String nombre = request.getParameter("Nombre");
        String pais = request.getParameter("Pais");
        String fecha = request.getParameter("Fecha");
        
        Torneo p = new Torneo();
        p.setIdTorneo(idTorneo);
        p.setNombre(nombre);
        p.setPais(pais);
        p.setFecha(fecha);
        
        GestionarTorneo gp = new GestionarTorneo();
        boolean b = gp.modificarTorneo(p);
        
        request.setAttribute("p", p);
        request.setAttribute("b", b);
        try (PrintWriter out = response.getWriter()) {
            RequestDispatcher a = request.getRequestDispatcher("resultado.jsp");
            a.forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}