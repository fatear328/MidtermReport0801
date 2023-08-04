package tw.com.eeit.virusgene.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tw.com.eeit.virusgene.model.dao.EnteroInfluGeneDAO;
import tw.com.eeit.virusgene.util.ConnectionFactory;

@WebServlet("/ToDeleteGene.do")
public class ToDeleteGene extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.valueOf(request.getParameter("vID"));
		try(Connection conn = ConnectionFactory.getConnection()) {
			 EnteroInfluGeneDAO geneDAO = new EnteroInfluGeneDAO(conn);
			 geneDAO.deleteEnteroInfluGene(id);
			 request.getRequestDispatcher("/ToShowAllGene.do").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	
	
	
	
	
	
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
