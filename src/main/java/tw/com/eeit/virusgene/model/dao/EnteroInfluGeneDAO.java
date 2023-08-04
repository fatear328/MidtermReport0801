package tw.com.eeit.virusgene.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tw.com.eeit.virusgene.model.bean.EnteroInfluGene;

public class EnteroInfluGeneDAO {

	private Connection conn;

	public EnteroInfluGeneDAO(Connection conn) {
		this.conn = conn;
	}

	public List<EnteroInfluGene> findAllEnteroInfluGene() throws SQLException{
		String SQL = "SELECT * FROM [virusgene].[dbo].[EnterovirusInfluenzaGene] ORDER BY [vID]";
		PreparedStatement ptsmt = conn.prepareStatement(SQL);
		ResultSet rs = ptsmt.executeQuery();
		List<EnteroInfluGene> aList = new ArrayList<EnteroInfluGene>();
		while (rs.next()) {
			
			EnteroInfluGene eig = new EnteroInfluGene();
			eig.setvID(rs.getInt("vID"));
			eig.setCaseNumber(rs.getString("CaseNumber"));
			eig.setAge(rs.getInt("Age"));
			eig.setGender(rs.getString("Gender"));
			eig.setCity(rs.getString("City"));
			eig.setComfirmedDate(rs.getDate("ComfirmedDate"));
			eig.setSymptomsDate(rs.getDate("SymptomsDate"));
			eig.setCollaboratingLab(rs.getString("CollaboratingLab"));
			eig.setVirusType(rs.getString("VirusType"));
			eig.setVirusSubtype(rs.getString("VirusSubtype"));
			eig.setNucleicAcidSequence(rs.getString("NucleicAcidSequence"));
			eig.setUpdateTime(rs.getDate("UpdateTime"));
			
			aList.add(eig);
			
			
		}
		
		rs.close();
		ptsmt.close();
		return aList;
	}
	public EnteroInfluGene findAllEnteroInfuByvID(int vID) throws SQLException {
		String SQL = "SELECT * FROM [virusgene].[dbo].[EnterovirusInfluenzaGene] WHERE [vID] = ? ";
		PreparedStatement pstmt = conn.prepareStatement(SQL);
		pstmt.setInt(1,vID);
		ResultSet rs = pstmt.executeQuery();
//		EnteroInfluGene eig = null;
		EnteroInfluGene eig = new EnteroInfluGene();
		if(rs.next()) {
			eig.setvID(rs.getInt("vID"));
			eig.setCaseNumber(rs.getString("CaseNumber"));
			eig.setAge(rs.getInt("Age"));
			eig.setGender(rs.getString("Gender"));
			eig.setCity(rs.getString("City"));
			eig.setComfirmedDate(rs.getDate("ComfirmedDate"));
			eig.setSymptomsDate(rs.getDate("SymptomsDate"));
			eig.setCollaboratingLab(rs.getString("CollaboratingLab"));
			eig.setVirusType(rs.getString("VirusType"));
			eig.setVirusSubtype(rs.getString("VirusSubtype"));
			eig.setNucleicAcidSequence(rs.getString("NucleicAcidSequence"));
			eig.setUpdateTime(rs.getDate("UpdateTime"));
			
		}
		rs.close();
		pstmt.close();
		
		return eig;
	}

	public List<EnteroInfluGene> findEnteroInfluGeneByLab(String collaboratingLab, String virustype ) throws SQLException {
		String SQL = "SELECT * FROM [virusgene].[dbo].[EnterovirusInfluenzaGene] WHERE [CollaboratingLab] = ? AND [VirusType] = ?";
		PreparedStatement ptsmt = conn.prepareStatement(SQL);
		ptsmt.setString(1, collaboratingLab);
		ptsmt.setString(2, virustype);
		ResultSet rs = ptsmt.executeQuery();
		List<EnteroInfluGene> aList = new ArrayList<EnteroInfluGene>();
	
		
		while (rs.next()) {
			 EnteroInfluGene eig = new EnteroInfluGene();
			eig.setvID(rs.getInt("vID"));
			eig.setCaseNumber(rs.getString("CaseNumber"));
			eig.setAge(rs.getInt("Age"));
			eig.setGender(rs.getString("Gender"));
			eig.setCity(rs.getString("City"));
			eig.setComfirmedDate(rs.getDate("ComfirmedDate"));
			eig.setSymptomsDate(rs.getDate("SymptomsDate"));
			eig.setCollaboratingLab(rs.getString("CollaboratingLab"));
			eig.setVirusType(rs.getString("VirusType"));
			eig.setVirusSubtype(rs.getString("VirusSubtype"));
			eig.setNucleicAcidSequence(rs.getString("NucleicAcidSequence"));
			eig.setUpdateTime(rs.getDate("UpdateTime"));
			aList.add(eig);
			
		}
		

		rs.close();
		ptsmt.close();

		return aList ;
	}
	
	

	public EnteroInfluGene addEnteroInfluGene(EnteroInfluGene gene) throws SQLException {
		String SQL = "INSERT INTO [virusgene].[dbo].[EnterovirusInfluenzaGene](CaseNumber, Age, Gender, City, ComfirmedDate, SymptomsDate, CollaboratingLab, VirusType, VirusSubtype, NucleicAcidSequence ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(SQL);
		
		pstmt.setString(1, gene.getCaseNumber());
		pstmt.setInt(2, gene.getAge());
		pstmt.setString(3, gene.getGender());
		pstmt.setString(4, gene.getCity());
		pstmt.setDate(5, gene.getComfirmedDate());
		pstmt.setDate(6, gene.getSymptomsDate());

//		java.util.Date ComfirmedDate = gene.getComfirmedDate();
//		if (ComfirmedDate != null) {
//			long time = ComfirmedDate.getTime();
//			pstmt.setDate(5, new java.sql.Date(time));
//		} else {
//			pstmt.setDate(5, null);
//		}
//
//		java.util.Date SymptomsDate = gene.getSymptomsDate();
//		if (SymptomsDate != null) {
//			long time = SymptomsDate.getTime();
//			pstmt.setDate(6, new java.sql.Date(time));
//		} else {
//			pstmt.setDate(6, null);
//		}

		pstmt.setString(7, gene.getCollaboratingLab());
		pstmt.setString(8, gene.getVirusType());
		pstmt.setString(9, gene.getVirusSubtype());
		pstmt.setString(10, gene.getNucleicAcidSequence());
		

		pstmt.execute();
		pstmt.close();
		;
		return gene;
	}
	
	public String findEvLastGene() throws SQLException  {
		String SQL = "SELECT [CaseNumber] FROM [virusgene].[dbo].[EnterovirusInfluenzaGene] WHERE [CaseNumber] LIKE 'EV-16-%' ORDER BY [CaseNumber]";
		PreparedStatement ptsmt = conn.prepareStatement(SQL);
		ResultSet rs = ptsmt.executeQuery();
		String ev = "";
		while(rs.next()) {
			 ev = rs.getString("CaseNumber");
		}
		
		rs.close();
		ptsmt.close();
				
		return ev;
	}
	public String findInfLastGene() throws SQLException  {
		String SQL = "SELECT [CaseNumber] FROM [virusgene].[dbo].[EnterovirusInfluenzaGene] WHERE [CaseNumber] LIKE 'INF-16-%' ORDER BY [CaseNumber]";
		PreparedStatement ptsmt = conn.prepareStatement(SQL);
		ResultSet rs = ptsmt.executeQuery();
		String inf = "";
		while(rs.next()) {
			inf = rs.getString("CaseNumber");
		}
		
		rs.close();
		ptsmt.close();
		
		return inf;
	}

	public void upDateEnteroInfluGene(EnteroInfluGene gene) throws SQLException {
		String SQL = "UPDATE [virusgene].[dbo].[EnterovirusInfluenzaGene] SET CaseNumber=?, Age=?, Gender=?, City=?, ComfirmedDate=?, SymptomsDate=?, CollaboratingLab=?, VirusType=?, VirusSubtype=?, NucleicAcidSequence=?, UpdateTime=getDate() where vID=?";
		PreparedStatement pstmt = conn.prepareStatement(SQL);
		pstmt.setString(1, gene.getCaseNumber());
		pstmt.setInt(2, gene.getAge());
		pstmt.setString(3, gene.getGender());
		pstmt.setString(4, gene.getCity());
		pstmt.setDate(5, gene.getComfirmedDate());
		pstmt.setDate(6, gene.getSymptomsDate());
		

//		java.util.Date ComfirmedDate = gene.getComfirmedDate();
//		if (ComfirmedDate != null) {
//			long time = ComfirmedDate.getTime();
//			pstmt.setDate(5, new java.sql.Date(time));
//		} else {
//			pstmt.setDate(5, null);
//		}
//
//		java.util.Date SymptomsDate = gene.getSymptomsDate();
//		if (SymptomsDate != null) {
//			long time = SymptomsDate.getTime();
//			pstmt.setDate(6, new java.sql.Date(time));
//		} else {
//			pstmt.setDate(6, null);
//		}

		pstmt.setString(7, gene.getCollaboratingLab());
		pstmt.setString(8, gene.getVirusType());
		pstmt.setString(9, gene.getVirusSubtype());
		pstmt.setString(10, gene.getNucleicAcidSequence());
		
		pstmt.setInt(11, gene.getvID());

	    pstmt.execute();
	
		pstmt.close();
	}

	public void deleteEnteroInfluGene(int EnteroInfluGeneID) throws SQLException {
		String SQL = "DELETE FROM [virusgene].[dbo].[EnterovirusInfluenzaGene] where vID=?";
		PreparedStatement pstmt = conn.prepareStatement(SQL);
		pstmt.setInt(1, EnteroInfluGeneID);

		pstmt.execute();
		pstmt.close();
	}
	
	public void truncateTable() throws SQLException {
		String SQL = "TRUNCATE TABLE [virusgene].[dbo].[EnterovirusInfluenzaGene]";
		PreparedStatement pstmt = conn.prepareStatement(SQL);
		pstmt.execute();
		pstmt.close();
	}
}
