package com.crm.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class PatientListDAO {
	
	public List<PatientVO> getPatientList(String startDate, String endDate, String doctorCode, String patientName, String birth){
		List<PatientVO> list = null;
		SqlSession conn = DBCP.getSqlSessionFactory().openSession();
		Map<String, Object> map = new HashMap<>();
		map.put("startDate", startDate);
		map.put("endDate", endDate);
		map.put("doctorCode", doctorCode);
		map.put("patientName", patientName);
		map.put("birth", birth);
		list = conn.selectList("patientMapper.getPatientList", map);
		conn.close();
		return list;
	}

	public PatientVO getPatientDetail(int patientNo){
		PatientVO vo = null;
		SqlSession conn = DBCP.getSqlSessionFactory().openSession();
		vo = conn.selectOne("patientMapper.getPatientDetail", patientNo);
		conn.close();
		return vo;
	}
	public List<MedicalRecordVO> getMedicalRecord(int patientNo){
		List<MedicalRecordVO> list = null;
		SqlSession conn = DBCP.getSqlSessionFactory().openSession();
		list = conn.selectList("patientMapper.getMedicalRecord", patientNo);
		conn.close();
		return list;
	}
	
	public int addPatient(String patientName, String phone){
		int result = 0;
		SqlSession conn = DBCP.getSqlSessionFactory().openSession();
		Map<String, Object> map = new HashMap<>();
		map.put("patientName", patientName);
		map.put("phone", phone);
		result = conn.insert("patientMapper.addPatient", map);
		if (result > 0){
			conn.commit();
		} else {
			conn.rollback();
		}
		conn.close();
		return result;
	}
	
	public int deletePatient(int patientNo){
		int result = 0;
		SqlSession conn = DBCP.getSqlSessionFactory().openSession();
		result = conn.update("patientMapper.deletePatient", patientNo);
		if (result > 0){
			conn.commit();
		} else {
			conn.rollback();
		}
		conn.close();
		return result;
	}
	
	public int editPatient(String patientName, String phone, String address, String birth, String gender, String path, int patientNo){
		int result = 0;
		SqlSession conn = DBCP.getSqlSessionFactory().openSession();
		Map<String, Object> map = new HashMap<>();
		map.put("patientName", patientName);
		map.put("phone", phone);
		map.put("address", address);
		map.put("birth", birth);
		map.put("gender", gender);
		map.put("path", path);
		map.put("patientNo", patientNo);
		result = conn.update("patientMapper.editPatient", map);
		if (result>0){
			conn.commit();
		} else {
			conn.rollback();
		}
		conn.close();
		return result;
	}
}
