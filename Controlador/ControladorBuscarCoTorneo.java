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

@WebServlet(name = "ControladorBuscarCoTorneo", urlPatterns = {"/ControladorBuscarCoTorneo"})
public class ControladorBuscarCoTorneo extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String idTxt = request.getParameter("IdTorneo");
        GestionarTorneo gp = new GestionarTorneo();
        
        int idTorneo = Integer.parseInt(idTxt);
        Torneo p = null;
        
        // Usamos tu método existente que no da error en NetBeans
        ArrayList<Torneo> lista = gp.BuscarColeccionTorneo();
        
        // Filtramos en la lista para encontrar el ID ingresado
        for (Torneo t : lista) {
            if (t.getIdTorneo() == idTorneo) {
                p = t;
                break;
            }
        }
        
        request.setAttribute("p", p);
        
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