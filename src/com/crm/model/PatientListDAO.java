package com.crm.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class PatientListDAO {
	
//	public List<PatientVO> getPatientList(String startDate, String endDate, String doctorCode, String patientName, String birth){
//		List<PatientVO> list = null;
//		SqlSession conn = DBCP.getSqlSessionFactory().openSession();
//		Map<String, Object> map = new HashMap<>();
//		map.put("startDate", startDate);
//		map.put("endDate", endDate);
//		map.put("doctorCode", doctorCode);
//		map.put("patientName", patientName);
//		map.put("birth", birth);
//		
//		// ✅ 페이징 기본값
//	    int page = 1;
//	    int pageSize = 10;
//	    int startRow = (page - 1) * pageSize + 1;
//	    int endRow = page * pageSize;
//	    map.put("startRow", startRow);
//	    map.put("endRow", endRow);
//		
//		list = conn.selectList("patientMapper.getPatientList", map);
//		conn.close();
//		return list;
//	}
	
	// ✅ AJAX 호출용 Map 버전
    public List<PatientVO> getPatientList(Map<String, Object> map) {
        SqlSession conn = DBCP.getSqlSessionFactory().openSession();
        List<PatientVO> list = conn.selectList("patientMapper.getPatientList", map);
        conn.close();
        return list;
    }
	
	// ✅ 전체 건수 조회
    public int getTotalCount(Map<String, Object> params) {
        SqlSession session = DBCP.getSqlSessionFactory().openSession();
        int count = session.selectOne("patientMapper.getTotalCount", params);
        session.close();
        return count;
    }
    
    public List<ManageDoctorVO> getDoctorName(String startDate, String endDate){
		List<ManageDoctorVO> list = null;
		SqlSession conn = DBCP.getSqlSessionFactory().openSession();
		Map<String, Object> map = new HashMap<>();
		map.put("startDate", startDate);
		map.put("endDate", endDate);
		list = conn.selectList("patientMapper.getDoctorName", map);
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
