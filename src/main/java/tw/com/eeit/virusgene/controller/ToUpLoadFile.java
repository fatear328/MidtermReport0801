package tw.com.eeit.virusgene.controller;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import tw.com.eeit.virusgene.util.ConnectionFactory;

@MultipartConfig
@WebServlet("/ToUpLoadFile.do")
public class ToUpLoadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext context = request.getServletContext();
		String realPath = context.getRealPath("META-INF/");
		Part part = request.getPart("EnteroInfluGeneFile");
		InputStream inputStream = part.getInputStream();
		byte[] bytes = inputStream.readAllBytes();
		inputStream.close();
		File file = new File(realPath + part.getName() + ".csv");
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(bytes);
		fos.close();

		String SQL = "INSERT INTO [virusgene].[dbo].[EnterovirusInfluenzaGene] ([CaseNumber], [Age], [Gender], [City], [ComfirmedDate], [SymptomsDate], [CollaboratingLab], [VirusType], [VirusSubtype], [NucleicAcidSequence]) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try (Connection conn = ConnectionFactory.getConnection()) {
			PreparedStatement pStmt = conn.prepareStatement(SQL);
			BufferedReader br = new BufferedReader(
					new InputStreamReader(new FileInputStream(realPath + part.getName() + ".csv"),"Big5"));
			String line;
			br.readLine(); // skip header line
			while ((line = br.readLine()) != null) {
				String[] data = line.split(",");

				pStmt.setString(1, data[0]);
				pStmt.setInt(2, Integer.valueOf(data[1]));

				pStmt.setString(3, data[2]);
				pStmt.setString(4, data[3]);
//				pStmt.setString(5, data[4]);
//				pStmt.setString(6, data[5]);
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
				java.util.Date utilDateC = dateFormat.parse(data[4]);
				java.sql.Date sqlDateC = new java.sql.Date(utilDateC.getTime());
				java.util.Date utilDateS = dateFormat.parse(data[5]);
				java.sql.Date sqlDateS = new java.sql.Date(utilDateS.getTime());

				pStmt.setDate(5, sqlDateC);
				pStmt.setDate(6, sqlDateS);
				pStmt.setString(7, data[6]);
				pStmt.setString(8, data[7]);
				pStmt.setString(9, data[8]);
				pStmt.setString(10, data[9]);

				pStmt.addBatch();
			}
			pStmt.executeBatch();
			pStmt.close();
			request.getRequestDispatcher("/CreateVirusGene.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
