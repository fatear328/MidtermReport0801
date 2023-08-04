package tw.com.eeit.virusgene.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tw.com.eeit.virusgene.model.bean.EnteroInfluGene;
import tw.com.eeit.virusgene.model.dao.EnteroInfluGeneDAO;
import tw.com.eeit.virusgene.util.ConnectionFactory;

@WebServlet("/ToShowGeneByID.do")
public class ToShowGeneByID extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	Integer id = Integer.valueOf(request.getParameter("vID"));
	try(Connection conn = ConnectionFactory.getConnection()) {
		System.out.println("123");
		 EnteroInfluGeneDAO geneDAO = new EnteroInfluGeneDAO(conn);
		response.setCharacterEncoding("UTF-8"); 
		EnteroInfluGene data = geneDAO.findAllEnteroInfuByvID(id);
	System.out.println(data);
		
//		request.setAttribute("vId", vId);
		request.getSession().setAttribute("data", data);
		response.sendRedirect("UpdateGene.jsp");
		
	} catch (Exception e) {
		e.printStackTrace();
	}
		
	
	
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
