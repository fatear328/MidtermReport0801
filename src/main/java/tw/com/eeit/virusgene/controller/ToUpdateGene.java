package tw.com.eeit.virusgene.controller;

import java.io.IOException;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tw.com.eeit.virusgene.model.bean.EnteroInfluGene;
import tw.com.eeit.virusgene.model.dao.EnteroInfluGeneDAO;
import tw.com.eeit.virusgene.util.ConnectionFactory;

@WebServlet("/ToUpdateGene.do")
public class ToUpdateGene extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		System.out.println("123");
		Integer id = Integer.valueOf(request.getParameter("vID"));
		String casenumber = request.getParameter("vCasenumber");
		Integer age = Integer.valueOf(request.getParameter("pAge"));
		String gender = request.getParameter("pGender");
		String city = request.getParameter("pCity");
		String comfirmedDate = request.getParameter("pComfirmedDate");
		String symptomsDate = request.getParameter("pSymptomsDate");
		String collaboratingLab = request.getParameter("vCollaboratingLab");
		String virusType = request.getParameter("vVirusType");
		String virusSubtype = request.getParameter("vVirusSubtype");
		String nucleicAcidSequence = request.getParameter("vNucleicAcidSequence");
		
        System.out.println(nucleicAcidSequence);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		java.sql.Date comfirmedDate1 = null;
		java.sql.Date symptomsDate1 = null;
		try {
			comfirmedDate1 = new java.sql.Date(sdf.parse(comfirmedDate).getTime());

			symptomsDate1 = new java.sql.Date(sdf.parse(symptomsDate).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(id+casenumber+age+gender+city+comfirmedDate1+symptomsDate1+collaboratingLab+virusType+virusSubtype+nucleicAcidSequence);
	
	EnteroInfluGene eig = new EnteroInfluGene(id, casenumber, age, gender, city, comfirmedDate1, symptomsDate1, collaboratingLab, virusType, virusSubtype, nucleicAcidSequence);
	
	try (Connection conn = ConnectionFactory.getConnection()){
		EnteroInfluGeneDAO geneDAO = new EnteroInfluGeneDAO(conn);
		geneDAO.upDateEnteroInfluGene(eig);
		request.getRequestDispatcher("/ToShowAllGene.do").forward(request, response);
		
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
