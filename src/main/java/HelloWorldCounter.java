/**
 * Created by canidmars on 6/6/17.
 */
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloWorldServlet", urlPatterns = "/count")
public class HelloWorldCounter extends HttpServlet {

    int count = 0;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String c2 = request.getParameter("c2");

        if (c2 != null){
            count = 0;
        }

        count++;

        out.println("<h1>Page Count: "+ count +" !</h1>");


    }
}
