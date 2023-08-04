package tw.com.eeit.virusgene.init;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import tw.com.eeit.virusgene.util.ConnectionFactory;

@WebListener
public class initialize implements ServletContextListener {

	public void contextInitialized(ServletContextEvent sce) {

		try (Connection conn = ConnectionFactory.getConnection()) {

			InsertData(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void InsertData(Connection conn) throws Exception {

		String Path = "C:\\midtermReport\\EnterovirusInfluenzaGene.csv";
		if (!conn.createStatement().executeQuery("SELECT　[vID] FROM [virusgene].[dbo].[EnterovirusInfluenzaGene]")
				.next()) {

			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(Path), "Big5"));

			String line;
//            String csvDelimiter = ",";
//            List<EnterovirusInfluenzaGene> dataToInsert = new ArrayList<>();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			String SQL = "INSERT INTO [virusgene].[dbo].[EnterovirusInfluenzaGene] ([CaseNumber], [Age], [Gender], [City], [ComfirmedDate], [SymptomsDate], [CollaboratingLab], [VirusType], [VirusSubtype], [NucleicAcidSequence]) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preState = conn.prepareStatement(SQL);
			br.readLine(); // skip header line
			while ((line = br.readLine()) != null) {
				String[] data = line.split(",");

				preState.setString(1, data[0]);
				preState.setInt(2, Integer.valueOf(data[1]));
				
				preState.setString(3, data[2]);
				preState.setString(4, data[3]);
//				preState.setString(5, data[4]);
//				preState.setString(6, data[5]);

				java.util.Date utilDateC = dateFormat.parse(data[4]);
				java.sql.Date sqlDateC = new java.sql.Date(utilDateC.getTime());
				java.util.Date utilDateS = dateFormat.parse(data[5]);
				java.sql.Date sqlDateS = new java.sql.Date(utilDateS.getTime());

				preState.setDate(5, sqlDateC);
				preState.setDate(6, sqlDateS);
				preState.setString(7, data[6]);
				preState.setString(8, data[7]);
				preState.setString(9, data[8]);
				preState.setString(10, data[9]);

				preState.addBatch();
			}
			preState.executeBatch();
			preState.close();
		}

	}

	public void contextDestroyed(ServletContextEvent sce) {
	}

}
