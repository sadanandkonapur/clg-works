import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Sample username and password (In real apps, validate against DB)
    private final String USERNAME = "student";
    private final String PASSWORD = "password123";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (USERNAME.equals(username) && PASSWORD.equals(password)) {
            // Login success - set session attribute
            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            // Redirect to welcome page
            response.sendRedirect("welcome.jsp");
        } else {
            // Login failed - redirect back to login with error
            request.setAttribute("errorMessage", "Invalid username or password");
            request.getRequestDispatcher("login.html").forward(request, response);
        }
    }
}
