package tw.com.eeit.virusgene.model.bean;

import java.sql.Date;

public class EnteroInfluGene {

   
	private int vID;
    private String CaseNumber; 
    private int Age;
    private String Gender;
    private String City;
    private Date ComfirmedDate;
    private Date SymptomsDate;
    private String CollaboratingLab;
    private String VirusType;
    private String VirusSubtype;
    private String NucleicAcidSequence;
    private Date UpdateTime;
//	public EnteroInfluGene(String casenumber, Integer age, String gender, String city, Date comfirmedDate,
//			Date symptomsDate, String collaboratingLab, String virusType, String virusSubtype,
//			String nucleicAcidSequence) {
//		// TODO Auto-generated constructor stub
//	}
     
	public EnteroInfluGene() {}
	public EnteroInfluGene( String caseNumber, int age, String gender, String city, Date comfirmedDate,
		Date symptomsDate, String collaboratingLab, String virusType, String virusSubtype, String nucleicAcidSequence
		) {
	super();
	
	CaseNumber = caseNumber;
	Age = age;
	Gender = gender;
	City = city;
	ComfirmedDate = comfirmedDate;
	SymptomsDate = symptomsDate;
	CollaboratingLab = collaboratingLab;
	VirusType = virusType;
	VirusSubtype = virusSubtype;
	NucleicAcidSequence = nucleicAcidSequence;
	
}

	
	
	public EnteroInfluGene(int vID, String caseNumber, int age, String gender, String city, Date comfirmedDate,
			Date symptomsDate, String collaboratingLab, String virusType, String virusSubtype, String nucleicAcidSequence) {
		super();
		this.vID = vID;
		CaseNumber = caseNumber;
		Age = age;
		Gender = gender;
		City = city;
		ComfirmedDate = comfirmedDate;
		SymptomsDate = symptomsDate;
		CollaboratingLab = collaboratingLab;
		VirusType = virusType;
		VirusSubtype = virusSubtype;
		NucleicAcidSequence = nucleicAcidSequence;
	}
	
	
	
	public int getvID() {
		return vID;
	}
	public void setvID(int vID) {
		this.vID = vID;
	}
	public String getCaseNumber() {
		return CaseNumber;
	}
	public void setCaseNumber(String caseNumber) {
		CaseNumber = caseNumber;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public Date getComfirmedDate() {
		return ComfirmedDate;
	}
	public void setComfirmedDate(Date comfirmedDate) {
		ComfirmedDate = comfirmedDate;
	}
	public Date getSymptomsDate() {
		return SymptomsDate;
	}
	public void setSymptomsDate(Date symptomsDate) {
		SymptomsDate = symptomsDate;
	}
	public String getCollaboratingLab() {
		return CollaboratingLab;
	}
	public void setCollaboratingLab(String collaboratingLab) {
		CollaboratingLab = collaboratingLab;
	}
	public String getVirusType() {
		return VirusType;
	}
	public void setVirusType(String virusType) {
		VirusType = virusType;
	}
	public String getVirusSubtype() {
		return VirusSubtype;
	}
	public void setVirusSubtype(String virusSubtype) {
		VirusSubtype = virusSubtype;
	}
	public String getNucleicAcidSequence() {
		return NucleicAcidSequence;
	}
	public void setNucleicAcidSequence(String nucleicAcidSequence) {
		NucleicAcidSequence = nucleicAcidSequence;
	}
	public Date getUpdateTime() {
		return UpdateTime;
	}
	public void setUpdateTime(Date updateTime) {
		UpdateTime = updateTime;
	}
	@Override
	public String toString() {
		return "EnteroInfluGene [vID=" + vID + ", CaseNumber=" + CaseNumber + ", Age=" + Age + ", Gender=" + Gender
				+ ", City=" + City + ", ComfirmedDate=" + ComfirmedDate + ", SymptomsDate=" + SymptomsDate
				+ ", CollaboratingLab=" + CollaboratingLab + ", VirusType=" + VirusType + ", VirusSubtype="
				+ VirusSubtype + ", NucleicAcidSequence=" + NucleicAcidSequence + ", UpdateTime=" + UpdateTime + "]";
	}
	
	
	
	
}
