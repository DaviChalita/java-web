

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connect.TryConnection;

/**
 * Servlet implementation class TentativaLogin
 */
@WebServlet("/TentativaLogin")
public class TentativaLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TentativaLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		PrintWriter out = response.getWriter();
		
		String email = request.getParameter("Email");
		String senha = request.getParameter("Senha");
		
		try {
			Connection con = TryConnection.tryConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select email, senha from usuario where email = '"+email+"' and senha = '"+senha+"'");
			
			if(rs.next()) {
		        response.sendRedirect("http://localhost:8080/TwitterLookAlike/home.jsp?email="+rs.getString("email"));
		        HttpSession session = request.getSession();
		        session.setAttribute("email", email);
			}else {
				out.println("Wrong username or password");
			}			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
