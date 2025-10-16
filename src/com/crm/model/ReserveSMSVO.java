package com.crm.model;

public class ReserveSMSVO {

	private int reserveSMSNo;
	private String employeeId;
	private String employeeName;
	private int reserveNo;
	private String patientName;
	private String phone;
	private String datetime;
	private String templateName;
	private String templateContent;
	
	
	public ReserveSMSVO(){};
	
	public ReserveSMSVO(int reserveSMSNo, String employeeId, String employeeName, int reserveNo, String patientName,
			String phone, String datetime, String templateName, String templateContent) {
		setReserveSMSNo(reserveSMSNo);
		setEmployeeId(employeeId);
		setEmployeeName(employeeName);
		setReserveNo(reserveNo);
		setPatientName(patientName);
		setPhone(phone);
		setDatetime(datetime);
		setTemplateName(templateName);
		setTemplateContent(templateContent);
	}
	
	public int getReserveSMSNo() {
		return reserveSMSNo;
	}
	public void setReserveSMSNo(int reserveSMSNo) {
		this.reserveSMSNo = reserveSMSNo;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public int getReserveNo() {
		return reserveNo;
	}
	public void setReserveNo(int reserveNo) {
		this.reserveNo = reserveNo;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public String getTemplateName() {
		return templateName;
	}
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
	public String getTemplateContent() {
		return templateContent;
	}
	public void setTemplateContent(String templateContent) {
		this.templateContent = templateContent;
	}
	
	@Override
	public String toString() {
		return "ReserveSMSVO [reserveSMSNo=" + reserveSMSNo + ", employeeId=" + employeeId + ", employeeName="
				+ employeeName + ", reserveNo=" + reserveNo + ", patientName=" + patientName + ", phone=" + phone
				+ ", datetime=" + datetime + ", templateName=" + templateName + ", templateContent=" + templateContent + "]\n";
	}
	
	
}
