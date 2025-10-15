package com.crm.model;

public class PatientVO {

	private int patientNo;
	private String patientName;
	private String address;
	private String birth;
	private String gender;
	private String path;
	private String phone;
	private String inDate;
	private String status;

	private String medicalDate;
	private String employeeName;
	private String department;
	private String diagnosis;

	public PatientVO() {
	};

	public PatientVO(int patientNo, String patientName, String address, String birth, String gender, String path,
			String phone, String inDate, String status) {
		setPatientNo(patientNo);
		setPatientName(patientName);
		setAddress(address);
		setBirth(birth);
		setGender(gender);
		setPath(path);
		setPhone(phone);
		setInDate(inDate);
		setStatus(status);
	}

	public int getPatientNo() {
		return patientNo;
	}

	public void setPatientNo(int patientNo) {
		this.patientNo = patientNo;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getInDate() {
		return inDate;
	}

	public void setInDate(String inDate) {
		this.inDate = inDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMedicalDate() {
		return medicalDate;
	}

	public void setMedicalDate(String medicalDate) {
		this.medicalDate = medicalDate;
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

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	@Override
	public String toString() {
		return "PatientVO [patientNo=" + patientNo + ", patientName=" + patientName + ", address=" + address
				+ ", birth=" + birth + ", gender=" + gender + ", path=" + path + ", phone=" + phone + ", inDate="
				+ inDate + ", status=" + status + ", medicalDate=" + medicalDate + ", employeeName=" + employeeName
				+ ", department=" + department + ", diagnosis=" + diagnosis + "]";
	}

}