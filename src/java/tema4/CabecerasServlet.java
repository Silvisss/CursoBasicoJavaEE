package tema4;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//Declara el Servlet
@WebServlet(name="CabecerasServlet", urlPatterns={"/cabeceras"})
public class CabecerasServlet extends HttpServlet {

    protected void procesaPeticion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CabecerasServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Cabeceras: </h1>");

            out.println("<ul>");
            //recuperamos las cabeceras de la peticion, primero con el metodo getHeaderNames
            //y lo recorremos
            Enumeration<String> nombresDeCabeceras = request.getHeaderNames();
            //forma tipica de recorrer una enumeration con el while
            while (nombresDeCabeceras.hasMoreElements()) {
                //recuperamos el nombre
                String cabecera = nombresDeCabeceras.nextElement();//guarda en el Strin
                out.println("<li><b>" + cabecera + ": </b>"//lo pinta
                        //en esta linea recuperamos el valor de la cabecera
                        //atraves del nombre, que es String cabecera y q hemos recuperado con GetHeaderName
                        + request.getHeader(cabecera) + "</li>");
            }
            
            out.println("</ul>");
            out.println("</body>");
            out.println("</html>");

        } finally {
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        procesaPeticion(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        procesaPeticion(request, response);
    }
}
