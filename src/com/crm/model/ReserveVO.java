package com.crm.model;

public class ReserveVO {
	private int reserveNo;
	private String patientName;
	private String reserveDay;
	private String reserveTime;
	private String department;
	private String employeeName;
	private String phone;
	private String reason;
	private int reserveCount;
	private int patientNo;
	private int doctorScheduleNo;

	public ReserveVO() {}

	public ReserveVO(String reserveDay, String reserveTime) {
		setReserveDay(reserveDay);
		setReserveTime(reserveTime);
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

	public String getReserveDay() {
		return reserveDay;
	}

	public void setReserveDay(String reserveDay) {
		this.reserveDay = reserveDay;
	}

	public String getReserveTime() {
		return reserveTime;
	}

	public void setReserveTime(String reserveTime) {
		this.reserveTime = reserveTime;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
	public int getReserveCount() {
		return reserveCount;
	}

	public void setReserveCount(int reserveCount) {
		this.reserveCount = reserveCount;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
	public int getPatientNo() {
		return patientNo;
	}

	public void setPatientNo(int patientNo) {
		this.patientNo = patientNo;
	}

	public int getDoctorScheduleNo() {
		return doctorScheduleNo;
	}

	public void setDoctorScheduleNo(int doctorScheduleNo) {
		this.doctorScheduleNo = doctorScheduleNo;
	}

	@Override
	public String toString() {
		return "ReserveVO [reserveNo=" + reserveNo + ", patientName=" + patientName + ", reserveDay=" + reserveDay
				+ ", reserveTime=" + reserveTime + ", department=" + department + ", employeeName=" + employeeName
				+ ", reserveCount=" + reserveCount + ", phone=" + phone + ", reason=" + reason + ", patientNo="
				+ patientNo + ", doctorScheduleNo=" + doctorScheduleNo + "]\n";
	}

}
