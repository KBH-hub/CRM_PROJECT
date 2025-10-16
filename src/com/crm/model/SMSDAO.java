package com.crm.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class SMSDAO {
	public List<ReserveSMSVO> getReserveRecipient(List<Integer> reserveNo){
		List<ReserveSMSVO> list = null;
		SqlSession conn = DBCP.getSqlSessionFactory().openSession();
		list = conn.selectList("SMSMapper.getReserveRecipient", reserveNo);
		conn.close();
		return list;
	}
	public List<CommonSMSVO> getCommonRecipient(List<Integer> patientNo){
		List<CommonSMSVO> list = null;
		SqlSession conn = DBCP.getSqlSessionFactory().openSession();
		list = conn.selectList("SMSMapper.getCommonRecipient", patientNo);
		conn.close();
		return list;
	}
	public List<ReserveSMSVO> getTemplate(String templateName){
		List<ReserveSMSVO> list = null;
		SqlSession conn = DBCP.getSqlSessionFactory().openSession();
		Map<String, Object> map = new HashMap<>();
		map.put("templateName", templateName);
		list = conn.selectList("SMSMapper.getTemplate", map);
		conn.close();
		return list;
	}
	
	public List<ReserveSMSVO> getReserveSMS(Map<String, Object> map){
		List<ReserveSMSVO> list = null;
		SqlSession conn = DBCP.getSqlSessionFactory().openSession();
		list = conn.selectList("SMSMapper.getReserveSMS", map);
		conn.close();
		return list;
	}
	
    public int getReserveSMSCount() {
        SqlSession session = DBCP.getSqlSessionFactory().openSession();
        int count = session.selectOne("SMSMapper.getReserveSMSCount");
        session.close();
        return count;
    }
    
    public int getCommonSMSCount() {
        SqlSession session = DBCP.getSqlSessionFactory().openSession();
        int count = session.selectOne("SMSMapper.getCommonSMSCount");
        session.close();
        return count;
    }
	
	public int addReserveSMS(int reserveNo, String employeeId, String templateName){
		int result = 0;
		SqlSession conn = DBCP.getSqlSessionFactory().openSession();
		Map<String, Object> map = new HashMap<>();
		map.put("reserveNo", reserveNo);
		map.put("employeeId", employeeId);
		map.put("templateName", templateName);
		result = conn.insert("SMSMapper.addReserveSMS", map);
		if (result>0){
			conn.commit();
		} else {
			conn.rollback();
		}
		conn.close();
		return result;
	}
	
	public List<CommonSMSVO> getCommonSMS(Map<String, Object> map){
		List<CommonSMSVO> list = null;
		SqlSession conn = DBCP.getSqlSessionFactory().openSession();
		list = conn.selectList("SMSMapper.getCommonSMS", map);
		conn.close();
		return list;
	}
	
    
	public int addCommonSMS(int patientNo, String employeeId, String content){
		int result = 0;
		SqlSession conn = DBCP.getSqlSessionFactory().openSession();
		Map<String, Object> map = new HashMap<>();
		map.put("patientNo", patientNo);
		map.put("employeeId", employeeId);
		map.put("content", content);
		result = conn.insert("SMSMapper.addCommonSMS", map);
		if (result>0){
			conn.commit();
		} else {
			conn.rollback();
		}
		conn.close();
		return result;
	}
	
	public CommonSMSVO getCommonSMSDetail(int commonSMSNo){
		CommonSMSVO vo = null;
		SqlSession conn = DBCP.getSqlSessionFactory().openSession();
		vo = conn.selectOne("SMSMapper.getCommonSMSDetail", commonSMSNo);
		conn.close();
		return vo;
	}
}
