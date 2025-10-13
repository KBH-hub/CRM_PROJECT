package com.crm.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class ManageDoctorDAO {
	
	public List<ManageDoctorVO> getDoctorSchedule(String startDate, String endDate){
		List<ManageDoctorVO> list = null;
		SqlSession conn = DBCP.getSqlSessionFactory().openSession();
		Map<String, Object> map = new HashMap<>();
		map.put("startDate", startDate);
		map.put("endDate", endDate);
		list = conn.selectList("doctorMapper.getDoctorSchedule", map);
		conn.close();
		return list;
	}
	
	public List<ManageDoctorVO> getDoctorName(String startDate, String endDate){
		List<ManageDoctorVO> list = null;
		SqlSession conn = DBCP.getSqlSessionFactory().openSession();
		Map<String, Object> map = new HashMap<>();
		map.put("startDate", startDate);
		map.put("endDate", endDate);
		list = conn.selectList("doctorMapper.getDoctorName", map);
		conn.close();
		return list;
	}
	
	public int addDoctorSchedule(String doctorCode, String workDate){
		int result = 0;
		SqlSession conn = DBCP.getSqlSessionFactory().openSession();
		Map<String, Object> map = new HashMap<>();
		map.put("doctorCode", doctorCode);
		map.put("workDate", workDate);
		result = conn.update("doctorMapper.addDoctorSchedule", map);
		if (result>0){
			conn.commit();
		} else {
			conn.rollback();
		}
		conn.close();
		return result;
	}
	
	public int editDoctorSchedule(int doctorScheduleNo, char am, char pm){
		int result = 0;
		SqlSession conn = DBCP.getSqlSessionFactory().openSession();
		Map<String, Object> map = new HashMap<>();
		map.put("doctorScheduleNo", doctorScheduleNo);
		map.put("am", am);
		map.put("pm", pm);		
		result = conn.update("doctorMapper.editDoctorSchedule", map);
		if (result>0){
			conn.commit();
		} else {
			conn.rollback();
		}
		conn.close();
		return result;
	}
	
	public int deleteDoctorSchedule(int doctorScheduleNo){
		int result = 0;
		SqlSession conn = DBCP.getSqlSessionFactory().openSession();
		result = conn.update("doctorMapper.deleteDoctorSchedule", doctorScheduleNo);
		if (result>0){
			conn.commit();
		} else {
			conn.rollback();
		}
		conn.close();
		return result;
	}
	
	public List<ManageDoctorVO> getDoctorList(){
		List<ManageDoctorVO> list = null;
		SqlSession conn = DBCP.getSqlSessionFactory().openSession();
		list = conn.selectList("doctorMapper.getDoctorList");
		conn.close();
		return list;
	}

}
