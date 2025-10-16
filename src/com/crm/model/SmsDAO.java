package com.crm.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class SmsDAO {
	public List<ReserveSmsVO> getReserveRecipient(List<Integer> reserveNo){
		List<ReserveSmsVO> list = null;
		SqlSession conn = DBCP.getSqlSessionFactory().openSession();
		list = conn.selectList("smsMapper.getReserveRecipient", reserveNo);
		conn.close();
		return list;
	}
	public List<CommonSmsVO> getCommonRecipient(List<Integer> patientNo){
		List<CommonSmsVO> list = null;
		SqlSession conn = DBCP.getSqlSessionFactory().openSession();
		list = conn.selectList("smsMapper.getCommonRecipient", patientNo);
		conn.close();
		return list;
	}
	public List<ReserveSmsVO> getTemplate(String templateName){
		List<ReserveSmsVO> list = null;
		SqlSession conn = DBCP.getSqlSessionFactory().openSession();
		Map<String, Object> map = new HashMap<>();
		map.put("templateName", templateName);
		list = conn.selectList("smsMapper.getTemplate", map);
		conn.close();
		return list;
	}
	
	public List<ReserveSmsVO> getReserveSms(Map<String, Object> map){
		List<ReserveSmsVO> list = null;
		SqlSession conn = DBCP.getSqlSessionFactory().openSession();
		list = conn.selectList("smsMapper.getReserveSms", map);
		conn.close();
		return list;
	}
	
    public int getReserveSmsCount() {
        SqlSession session = DBCP.getSqlSessionFactory().openSession();
        int count = session.selectOne("smsMapper.getReserveSmsCount");
        session.close();
        return count;
    }
    
    public int getCommonSmsCount() {
        SqlSession session = DBCP.getSqlSessionFactory().openSession();
        int count = session.selectOne("smsMapper.getCommonSmsCount");
        session.close();
        return count;
    }
	
	public int addReserveSms(int reserveNo, String employeeId, String templateName){
		int result = 0;
		SqlSession conn = DBCP.getSqlSessionFactory().openSession();
		Map<String, Object> map = new HashMap<>();
		map.put("reserveNo", reserveNo);
		map.put("employeeId", employeeId);
		map.put("templateName", templateName);
		result = conn.insert("smsMapper.addReserveSms", map);
		if (result>0){
			conn.commit();
		} else {
			conn.rollback();
		}
		conn.close();
		return result;
	}
	
	public List<CommonSmsVO> getCommonSms(Map<String, Object> map){
		List<CommonSmsVO> list = null;
		SqlSession conn = DBCP.getSqlSessionFactory().openSession();
		list = conn.selectList("smsMapper.getSMSCount", map);
		conn.close();
		return list;
	}
	
    
	public int addCommonSms(int patientNo, String employeeId, String content){
		int result = 0;
		SqlSession conn = DBCP.getSqlSessionFactory().openSession();
		Map<String, Object> map = new HashMap<>();
		map.put("patientNo", patientNo);
		map.put("employeeId", employeeId);
		map.put("content", content);
		result = conn.insert("smsMapper.addCommonSms", map);
		if (result>0){
			conn.commit();
		} else {
			conn.rollback();
		}
		conn.close();
		return result;
	}
	
	public CommonSmsVO getCommonSmsDetail(int commonSmsNo){
		CommonSmsVO vo = null;
		SqlSession conn = DBCP.getSqlSessionFactory().openSession();
		vo = conn.selectOne("smsMapper.getCommonSmsDetail", commonSmsNo);
		conn.close();
		return vo;
	}
}
