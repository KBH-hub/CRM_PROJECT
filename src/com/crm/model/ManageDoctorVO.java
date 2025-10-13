package com.crm.model;

public class ManageDoctorVO {

	private int doctorScheduleNo;
	private String doctorCode;
	private String employeeName;
	private String department;
	private String workDate;
	private char am;
	private char pm;
	private String delFlag;

	public ManageDoctorVO(){};
	
	public ManageDoctorVO(int doctorScheduleNo, String doctorCode, String employeeName, String department,
			String workDate, char am, char pm, String delFlag) {
		setDoctorScheduleNo(doctorScheduleNo);
		setDoctorCode(doctorCode);
		setEmployeeName(employeeName);
		setDepartment(department);
		setWorkDate(workDate);
		setAm(am);
		setPm(pm);
		setDelFlag(delFlag);
	}
	
	public int getDoctorScheduleNo() {
		return doctorScheduleNo;
	}
	public void setDoctorScheduleNo(int doctorScheduleNo) {
		this.doctorScheduleNo = doctorScheduleNo;
	}
	public String getDoctorCode() {
		return doctorCode;
	}
	public void setDoctorCode(String doctorCode) {
		this.doctorCode = doctorCode;
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
	public String getWorkDate() {
		return workDate;
	}
	public void setWorkDate(String workDate) {
		this.workDate = workDate;
	}
	public char getAm() {
		return am;
	}
	public void setAm(char am) {
		this.am = am;
	}
	public char getPm() {
		return pm;
	}
	public void setPm(char pm) {
		this.pm = pm;
	}
	public String getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
	
	@Override
	public String toString() {
		return "manageDoctorVO [doctorScheduleNo=" + doctorScheduleNo + ", doctorCode=" + doctorCode + ", employeeName="
				+ employeeName + ", department=" + department + ", workDate=" + workDate + ", am=" + am + ", pm=" + pm
				+ ", delFlag=" + delFlag + "]\n";
	}
	
}
