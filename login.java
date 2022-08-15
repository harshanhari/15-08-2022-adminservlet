package demo;
import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
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
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String n=request.getParameter("user");
		String p=request.getParameter("password");
		switch(n) {
		case "admin":{
			if(p.equals("admin123"))
			{ 
				RequestDispatcher rd=request.getRequestDispatcher("adminhome.html");
				rd.forward(request,response); 
				}
			 else {
				 out.print("Invalid password"); 
				 RequestDispatcher rd=request.getRequestDispatcher("login.html"); 
				 rd.forward(request, response);
			  }
			break;
		}
		case "user":{
			if(p.equals("user123"))
			{ 
				RequestDispatcher rd=request.getRequestDispatcher("userhome.html");
				rd.forward(request,response); 
				}
			 else {
				 out.print("Invalid password"); 
				 RequestDispatcher rd=request.getRequestDispatcher("login.html"); 
				 rd.forward(request, response);
			  }
			break;
		}
		default : {
			out.print("Invalid user id");
			 RequestDispatcher rd=request.getRequestDispatcher("login.html"); 
			 rd.forward(request, response);
		}
		}
		/*
		 * if(n.equals("admin")) { if(p.equals("admin123")) { RequestDispatcher
		 * rd=request.getRequestDispatcher("adminhome.html"); rd.forward(request,
		 * response); } else { out.print("Invalid password"); RequestDispatcher
		 * rd=request.getRequestDispatcher("login.html"); rd.forward(request, response);
		 * }
		 * 
		 * } else { out.print("Invalid username"); RequestDispatcher
		 * rd=request.getRequestDispatcher("login.html"); rd.forward(request, response);
		 * }
		 */
		
	}

}
