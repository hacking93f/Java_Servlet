package com;




/*simple login system coded by NeoZeroHacker all right Reserved
 * for more info contact me at : hacking93f@gmail.com
 * Login system without password encryption in the next release i will provide to apply them.
 * enjoy ;)
 * lgn_sys v0.1
 * 
 * suggest for you:
 * 
 * if u are trying to do your first login system
 * use the preparedstatement to provide sqlinject;
 * 
 * sorry my english 
 */

import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String name = request.getParameter("uname");
		String ps = request.getParameter("psw");
		
		try {
			Class.forName("org.postgresql.Driver");
	
		Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/usr_lgn", "db", "falsarone");
		
		
		String qr = "select * from usr_lgn where username=? and passwo=?";
		
		PreparedStatement s = conn.prepareStatement(qr);
		
		s.setString(1, name);
		s.setString(2, ps);
		ResultSet rs = s.executeQuery();
		if(rs.next()) {
			
			response.sendRedirect("Welcome.jsp");
			System.out.println("logged");
			
			
		}else {
			System.out.println("no user or password find");
			//inserisci il redirect di errore qui ;)
		}
		
			
		
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
