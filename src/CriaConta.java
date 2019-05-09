

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CriaConta
 */
@WebServlet("/CriaConta")
public class CriaConta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CriaConta() {
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
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/twitterlookalike?useTimezone=true&serverTimezone=UTC","root","");
			PreparedStatement st = con.prepareStatement("insert into usuario values(?,?,?,?,?)");
			st.setString(1, request.getParameter("Email"));
			st.setString(2, request.getParameter("Nome completo"));
			st.setString(3, request.getParameter("Nome de usuário"));
			st.setString(4, request.getParameter("Senha"));
			st.setString(5, request.getParameter("radio"));
			st.executeUpdate();
			//Statement stmt = con.createStatement();
			//PreparedStatement rs = con.prepareStatement("insert into usuario values('"+email+"','"+nomecompleto+"','"+nomeusuario+"','"+senha+"','"+icone+"')");

			out.println("<html><body><b>Successfully Inserted"
                    + "</b></body></html>"); 
			//if(st.next()) {
		      //  response.sendRedirect("http://localhost:8080/TwitterLookAlike/sucessocriaconta.jsp?name="+rs.getString("nomecompleto"));
		        //HttpSession session = request.getSession();
		        //session.setAttribute("uname", name);
			//}else {
				//out.println("Falhou :(");
			//}			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
