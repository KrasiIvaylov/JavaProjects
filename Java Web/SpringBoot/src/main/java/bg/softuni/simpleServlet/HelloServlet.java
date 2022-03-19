package bg.softuni.simpleServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    private String greeting;

    @Override
    public void init() throws ServletException {
        super.init();
        greeting = "Zdrasti banda!";

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter pw =  resp.getWriter();

        pw.println("<html><body>");
        pw.println("<h1>" + greeting +  "</h1>");
        pw.println("</body></html>");
        pw.flush();
    }
}