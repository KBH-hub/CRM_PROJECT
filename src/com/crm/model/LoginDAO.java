package com.crm.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class LoginDAO {

	public String login(String employeeId, String pw, String loginIp) {
        SqlSession session = DBCP.getSqlSessionFactory().openSession();
        Map<String, Object> login = new HashMap<>();
        login.put("employeeId", employeeId);
        login.put("pw", pw);
        String authority = session.selectOne("loginMapper.selectLogin", login);
        
        if (authority != null) {
            Map<String, Object> logMap = new HashMap<>();
            logMap.put("employeeId", employeeId);
            logMap.put("loginIp", loginIp);

            int inserted = session.insert("loginMapper.insertLoginLog", logMap);
            if (inserted==0) System.out.println("로그 기록 실패");
            session.commit();
        }
        session.close();
        return authority;
    }
	
	public Map<String, Object> getEmployeeInfo(String employeeId) {
        try (SqlSession session = DBCP.getSqlSessionFactory().openSession()) {
            Map<String, Object> res = session.selectOne("loginMapper.sideBarInfo", employeeId);
            return res;
        }
    }
	
}
