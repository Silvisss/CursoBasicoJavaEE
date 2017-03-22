package tema4;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="FormularioServlet", urlPatterns={"/formulario"})
public class FormulariotServlet extends HttpServlet {
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)//el metodo es mas largo hace todo,request.response
    throws ServletException, IOException {
//recogemos los parametros
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        //el parametro es el nombtre del select
        String edad = request.getParameter("edad");
        String[] hobbies = request.getParameterValues("hobbies");//[]array de string..son estaticas
        //cuando queremos recoger mas de un parametro se utiliza getParametresValues
        //utilizamos el metodo getParameterValue--ver formulariohobbies.html
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet que procesa un formulario basico</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>" + "Hola " + nombre + " " + apellidos+  "</h1>");
            out.println("Tu Franja de edad es " + edad + " y tus hobbies son:");

            out.println("<ul>");
            //recorro el String
            for (String hobby : hobbies) {
                out.println("<li>" + hobby + "</li>");
            }
            out.println("</ul>");
            out.println("Este formulario ha sido invocado con Los siguientes parametros:<br/>");
            out.println(request.getQueryString());

            out.println("</body>");
            out.println("</html>");
          //cerrar objeto  
        } finally { 
            out.close();
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

}
