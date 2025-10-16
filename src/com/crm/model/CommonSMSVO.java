package com.crm.model;

import java.util.Date;

public class CommonSMSVO {
	
	private int commonSMSNo;
	private String employeeId;
	private String employeeName;
	private int patientNo;
	private String patientName;
	private String phone;
	private String datetime;
	private String templateName;
	private String content;
	
	public CommonSMSVO(){};
	
	public CommonSMSVO(int commonSMSNo, String employeeId, String employeeName, int patientNo, String patientName,
			String phone, String datetime, String content) {
		setCommonSMSNo(commonSMSNo);
		setEmployeeId(employeeId);
		setEmployeeName(employeeName);
		setPatientNo(patientNo);
		setPatientName(patientName);
		setPhone(phone);
		setDatetime(datetime);
		setContent(content);
	}
	public int getCommonSMSNo() {
		return commonSMSNo;
	}
	public void setCommonSMSNo(int commonSMSNo) {
		this.commonSMSNo = commonSMSNo;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "CommonSMSVO [commonSMSNo=" + commonSMSNo + ", employeeId=" + employeeId + ", employeeName="
				+ employeeName + ", patientNo=" + patientNo + ", patientName=" + patientName + ", phone=" + phone
				+ ", datetime=" + datetime + ", content=" + content + "]\n";
	}
	
	
}