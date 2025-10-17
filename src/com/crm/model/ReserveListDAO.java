package com.crm.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class ReserveListDAO {
	/** ���� 紐⑤�� (��/二�/��/��媛�) 蹂� 由ъ�ㅽ�� 議고��*/
	public List<ReserveVO> getReserveList(String month, String weekStart, String weekEnd, String day, String hour) {
		SqlSession session = DBCP.getSqlSessionFactory().openSession();
		Map<String, Object> map = new HashMap<>();
		map.put("month", month);
		map.put("weekStart", weekStart);
		map.put("weekEnd", weekEnd);
		map.put("day", day);
		map.put("hour", hour);
		
		List<ReserveVO> list = session.selectList("reserveMapper.getReserveList", map);
		session.close();
		return list;
	}
	/** ���� 罹�由곕�� (��/二�/��)蹂� ���� 嫄댁�� 議고��*/
	public List<ReserveVO> countReserveMonth(String month) {
		SqlSession session = DBCP.getSqlSessionFactory().openSession();
		List<ReserveVO> list = session.selectList("reserveMapper.countReserveMonth", month);
		session.close();
		return list;
	}

	public List<ReserveVO> countReserveWeekByTime(String startDate, String endDate) {
		SqlSession session = DBCP.getSqlSessionFactory().openSession();
		Map<String, String> map = new HashMap<>();
		map.put("startDate", startDate);
		map.put("endDate", endDate);
		List<ReserveVO> list = session.selectList("reserveMapper.countReserveWeekByTime", map);
		session.close();
		return list;
	}

	public List<ReserveVO> countReserveWeekByDay(String startDate, String endDate) {
		SqlSession session = DBCP.getSqlSessionFactory().openSession();
		Map<String, String> map = new HashMap<>();
		map.put("startDate", startDate);
		map.put("endDate", endDate);
		List<ReserveVO> list = session.selectList("reserveMapper.countReserveWeekByDay", map);
		session.close();
		return list;
	}

	public List<ReserveVO> getReserveDay(String targetDate) {
		SqlSession session = DBCP.getSqlSessionFactory().openSession();
		List<ReserveVO> list = session.selectList("reserveMapper.getReserveDay", targetDate);
		session.close();
		return list;
	}

	/**���� ����*/
	public ReserveVO getReserveDetail(int reserveNo) {
		SqlSession session = DBCP.getSqlSessionFactory().openSession();
		ReserveVO vo = session.selectOne("reserveMapper.getReserveDetail", reserveNo);
		session.close();
		return vo;
	}
	
	/**���� �깅�(���� �대� 議고��)*/
	public List<ReserveVO> getPatientName(String patientName) {
		SqlSession session = DBCP.getSqlSessionFactory().openSession();
		List<ReserveVO> list = session.selectList("reserveMapper.getPatientName", patientName);
		session.close();
		return list;
	}
	/**���� �깅� (���� ��媛��� 洹쇰Т ���� 議고��)*/
	public List<ReserveVO> getPossibleDoctor(String workDate, String reserveDateTime) {
		SqlSession session = DBCP.getSqlSessionFactory().openSession();
		Map<String, String> map = new HashMap<>();
		map.put("workDate", workDate);
		map.put("reserveDateTime", reserveDateTime);
		List<ReserveVO> list = session.selectList("reserveMapper.getPossibleDoctor", map);
		session.close();
		return list;
	}
	/**���� �깅�*/
	public int addReserve(ReserveVO vo) {
		SqlSession session = DBCP.getSqlSessionFactory().openSession();
		Map<String, Object> reserveCheck = new HashMap<>();
		
		reserveCheck.put("doctorScheduleNo", vo.getDoctorScheduleNo());
		reserveCheck.put("reserveDay", vo.getReserveDay());
		reserveCheck.put("reserveTime", vo.getReserveTime());
		int result = session.selectOne("reserveMapper.reserveCheck", reserveCheck);
		int res = 0;
		if (result == 0){
			res = session.insert("reserveMapper.addReserve", vo);
			session.commit();
			session.close();
		}
		return res;
	}

	/**���� ����*/
	public int editReserve(ReserveVO vo) {
		SqlSession session = DBCP.getSqlSessionFactory().openSession();
		Map<String, Object> reserveCheck = new HashMap<>();
		
		reserveCheck.put("doctorScheduleNo", vo.getDoctorScheduleNo());
		reserveCheck.put("reserveDay", vo.getReserveDay());
		reserveCheck.put("reserveTime", vo.getReserveTime());
		int result = session.selectOne("reserveMapper.reserveCheck", reserveCheck);
		int res = 0;
		if (result == 0){
			res = session.update("reserveMapper.editReserve", vo);
			session.commit();
			session.close();
		}
		return res;
	}

    /**���� ����*/
	public int deleteReserve(List<Integer> reserveNoList) {
		SqlSession session = DBCP.getSqlSessionFactory().openSession();
		int res = session.update("reserveMapper.deleteReserve", reserveNoList);
		session.commit();
		session.close();
		return res;
	}
	
	/**湲��� 珥� ���� 嫄댁��(�ъ�대��諛�)*/
	public List<ReserveVO> countDailyAllReserve() {
		SqlSession session = DBCP.getSqlSessionFactory().openSession();
		List<ReserveVO> list = session.selectList("reserveMapper.countDailyReserve");
		session.close();
		return list;
	}
	
	/**湲��� 蹂몄�� ���� 嫄댁��(�ъ�대��諛�)*/
	public List<ReserveVO> countDailyMyReserve(String employeeId) {
		SqlSession session = DBCP.getSqlSessionFactory().openSession();
		Map<String, Object> map = new HashMap<>();
		map.put("employeeId", employeeId);
		
		List<ReserveVO> list = session.selectList("reserveMapper.countDailyReserve", map);
		session.close();
		return list;
	}
	
	/**��媛� 蹂몄�� ���� 嫄댁��(罹�由곕��)*/
	public List<ReserveVO> countMyReserveMonth(String employeeId, String month) {
		SqlSession session = DBCP.getSqlSessionFactory().openSession();
		Map<String, Object> map = new HashMap<>();
		map.put("employeeId", employeeId);
		map.put("month", month);
		
		
		
		List<ReserveVO> list = session.selectList("reserveMapper.countMyReserve", map);
		session.close();
		return list;
	}
	
	/**二쇨� 蹂몄�� ���� 嫄댁��(罹�由곕��)*/
	public List<ReserveVO> countMyReserveWeek(String employeeId, String month, String weekStart, String weekEnd) {
		SqlSession session = DBCP.getSqlSessionFactory().openSession();
		Map<String, Object> map = new HashMap<>();
		map.put("employeeId", employeeId);
		map.put("month", month);
		map.put("weekStart", weekStart);
		map.put("weekEnd", weekEnd);

		List<ReserveVO> list = session.selectList("reserveMapper.countMyReserve", map);
		session.close();
		return list;
	}
	
	/**蹂몄�� ���� 由ъ�ㅽ��(紐⑤��)*/
	public List<ReserveVO> getMyReserveList(String employeeId, String month, String weekStart, String weekEnd, String targetDate, String targetHour) {
		SqlSession session = DBCP.getSqlSessionFactory().openSession();
		Map<String, Object> map = new HashMap<>();
		map.put("employeeId", employeeId);
		map.put("month", month);
		map.put("weekStart", weekStart);
		map.put("weekEnd", weekEnd);
		map.put("targetDate", targetDate);
		map.put("targetHour", targetHour);

		List<ReserveVO> list = session.selectList("reserveMapper.getMyReserveList", map);
		session.close();
		return list;
	}
	
	public List<ReserveVO> getMyReserveListDay(String employeeId, String targetDate) {
		SqlSession session = DBCP.getSqlSessionFactory().openSession();
		Map<String, Object> map = new HashMap<>();
		map.put("employeeId", employeeId);
		map.put("targetDate", targetDate);

		List<ReserveVO> list = session.selectList("reserveMapper.getMyReserveListDay", map);
		session.close();
		return list;
	}
	
}
