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

@WebServlet(name = "ControladorBorrTorneo", urlPatterns = {"/ControladorBorrTorneo"})
public class ControladorBorrTorneo extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int idTorneo = Integer.parseInt(request.getParameter("IdTorneo"));
        
        GestionarTorneo gp = new GestionarTorneo();
        boolean b = gp.eliminarTorneo(idTorneo);
        
        request.setAttribute("b", b);
        try (PrintWriter out = response.getWriter()) {
            // CAMBIO: Ahora vuelve a cargar la pantalla de eliminarTorneo.jsp
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