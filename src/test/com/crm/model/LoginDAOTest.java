package test.com.crm.model;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import com.crm.model.LoginDAO;

public class LoginDAOTest {
	static LoginDAO dao;

	@BeforeClass
	public static void start() throws Exception {
		dao = new LoginDAO();
	}

	@Test
	public void loginTest() {
		String employeeId = "kimus01";
		String pw = "kus002";
		String loginIp = "127.0.0.25";
		String authority = dao.login(employeeId, pw, loginIp);

		assertNotNull(authority);
		assertEquals("의료진", authority);
		System.out.println(authority);
	}
	
	@Test
	public void loginFailTest() {
		String employeeId = "kimusxx";
		String pw = "kusxxx";
		String loginIp = "127.0.0.1";
		String authority = dao.login(employeeId, pw, loginIp);
		
		assertNull(authority);
	}

	@Test
	public void sideBarTest() {
		Map<String, Object> res = dao.getEmployeeInfo("kimus01");
		assertNotNull(res);
		assertEquals("김의사",res.get("EMPLOYEE_NAME"));
		assertEquals("원장",res.get("POSITION"));
		System.out.println("이름: " + res.get("EMPLOYEE_NAME"));
		System.out.println("직급: " + res.get("POSITION"));
		System.out.println("IP: " + res.get("LOGIN_IP"));
		System.out.println("로그인 시간: " + res.get("LOGIN_DATE"));

	}

}
