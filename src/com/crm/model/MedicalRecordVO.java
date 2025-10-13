package com.crm.model;

public class MedicalRecordVO {
	
	private String medicalNo;
	private String medicalDate;
	private String diagnosis;
	private String firstCome;
	private String employeeName;
	private String department;
	private String content;
	private String insurance;
	
	public MedicalRecordVO(){};
	
	public MedicalRecordVO(String medicalNo, String medicalDate, String diagnosis, String firstCome, String employeeName,
			String department, String content, String insurance) {
		setMedicalNo(medicalNo);
		setMedicalDate(medicalDate);
		setDiagnosis(diagnosis);
		setFirstCome(firstCome);
		setEmployeeName(employeeName);
		setDepartment(department);
		setContent(content);
		setInsurance(insurance);
	}
	
	
	public String getMedicalNo() {
		return medicalNo;
	}
	public void setMedicalNo(String medicalNo) {
		this.medicalNo = medicalNo;
	}
	public String getMedicalDate() {
		return medicalDate;
	}
	public void setMedicalDate(String medicalDate) {
		this.medicalDate = medicalDate;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public String getFirstCome() {
		return firstCome;
	}
	public void setFirstCome(String firstCome) {
		this.firstCome = firstCome;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getInsurance() {
		return insurance;
	}
	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}

	@Override
	public String toString() {
		return "MedicalRecordVO [medicalNo=" + medicalNo + ", medicalDate=" + medicalDate + ", diagnosis=" + diagnosis
				+ ", firstCome=" + firstCome + ", employeeName=" + employeeName + ", department=" + department
				+ ", content=" + content + ", insurance=" + insurance + "]\n";
	}
	
	
	
}
