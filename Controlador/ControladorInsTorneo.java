package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.GestionarTorneo;
import modelo.Torneo;

@WebServlet(name = "ControladorInsTorneo", urlPatterns = {"/ControladorInsTorneo"})
public class ControladorInsTorneo extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String nombre = request.getParameter("Nombre");
        String pais = request.getParameter("Pais");
        String fecha = request.getParameter("Fecha");
        
        Torneo p = new Torneo();
        p.setNombre(nombre);
        p.setPais(pais);
        p.setFecha(fecha);
        
        GestionarTorneo gp = new GestionarTorneo();
        boolean b = gp.insertarTorneo(p);
        if (b) {
            ArrayList<Torneo> lista = gp.BuscarColeccionTorneo();
            if (lista != null && !lista.isEmpty()) {
                Torneo ultimo = lista.get(lista.size() - 1);
                p.setIdTorneo(ultimo.getIdTorneo());
            }
        }
        
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