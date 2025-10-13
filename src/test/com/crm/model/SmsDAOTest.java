package test.com.crm.model;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import com.crm.model.CommonSmsVO;
import com.crm.model.ReserveSmsVO;
import com.crm.model.SmsDAO;


public class SmsDAOTest {
	
	static SmsDAO dao;
	
	@BeforeClass
	public static void start() throws Exception {
		dao = new SmsDAO();
	}
	//@Test
	public void getReserveRecipient() {
		List<Integer> reserveNo = Arrays.asList(10001, 10003); 
        List<ReserveSmsVO> smsList = dao.getReserveRecipient(reserveNo);
        System.out.println(smsList);
		assertTrue(smsList.size()>0);
	}
	//@Test
	public void getCommonRecipient() {
		List<Integer> reserveNo = Arrays.asList(6071,6072,6073);
		List<CommonSmsVO> smsList = dao.getCommonRecipient(reserveNo);
		System.out.println(smsList);
		assertTrue(smsList.size()>0);
		}
	//@Test
	public void getTemplateTest(){
		List<ReserveSmsVO> templateList = dao.getTemplate("");
        System.out.println(templateList);
        assertTrue(templateList.size()>0);
	}
	//@Test
	public void getReserveSmsTest(){
		List<ReserveSmsVO> smsList = dao.getReserveSms();
		System.out.println(smsList);
		assertTrue(smsList.size()>0);
	}
	//@Test
	public void addReserveSmsTest(){
		int result = dao.addReserveSms(10020,"honggd01","시술 예약");
		assertTrue("insert 실패", result>0);
		}
	//@Test
	public void getCommonSmsTest() {
        List<CommonSmsVO> smsList = dao.getCommonSms();
        System.out.println(smsList);
        assertTrue(smsList.size()>0);
	}

	//@Test
	public void addCommonSmsTest(){
        int result = dao.addCommonSms(6072,"honggd01","gd");
        assertTrue("insert 실패", result>0);
	}
	
	//@Test
	public void getCommonSmsDetailTest(){
	    CommonSmsVO smsDetail = dao.getCommonSmsDetail(10);
	    System.out.println(smsDetail);
	    assertEquals("010-2233-4455", smsDetail.getPhone());
	}
}
