package com.crm.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class PatientListDAO {
	
	/** 환자 이름 부분 검색d용으로 추가 */
    public List<PatientVO> searchPatientsByName(String keyword) {
        SqlSession session = DBCP.getSqlSessionFactory().openSession();
       
        List<PatientVO> list = session.selectList("patientMapper.searchByName", "%" + keyword + "%"); 
        session.close();
        return list;
    }
	
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
		int patientNo = 0;
		SqlSession conn = DBCP.getSqlSessionFactory().openSession();
		Map<String, Object> map = new HashMap<>();
		map.put("patientName", patientName);
		map.put("phone", phone);
		result = conn.insert("patientMapper.addPatient", map);
		if (result > 0){
			patientNo = conn.selectOne("patientMapper.getCurrentPatientNo");
			conn.commit();
		} else {
			conn.rollback();
		}
		conn.close();
		return patientNo;
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
