package com.student_app.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;

import com.student_app.model.DAO;
import com.student_app.model.DAOimpl;


public class DelRegController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DelRegController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String email = request.getParameter("email");
		System.out.println(email);
		
		DAO dao = new DAOimpl();
		dao.connectDB();
		
		dao.DeleteRegistration(email);
		ResultSet result = dao.getAllRegistrations();
		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/showReg.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
