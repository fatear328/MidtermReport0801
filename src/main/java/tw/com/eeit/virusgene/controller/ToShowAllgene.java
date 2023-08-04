package tw.com.eeit.virusgene.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tw.com.eeit.virusgene.model.bean.EnteroInfluGene;
import tw.com.eeit.virusgene.model.dao.EnteroInfluGeneDAO;
import tw.com.eeit.virusgene.util.ConnectionFactory;

@WebServlet("/ToShowAllGene.do")
public class ToShowAllgene extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try (Connection conn = ConnectionFactory.getConnection()) {

			EnteroInfluGeneDAO geneDAO = new EnteroInfluGeneDAO(conn);
			List<EnteroInfluGene> aList = geneDAO.findAllEnteroInfluGene();
//			System.out.println(aList);
			HttpSession session = request.getSession();
			session.setAttribute("aList", aList);

			request.getRequestDispatcher("/ShowAllGene.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
