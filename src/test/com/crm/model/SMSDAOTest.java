package test.com.crm.model;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import com.crm.model.CommonSMSVO;
import com.crm.model.ReserveSMSVO;
import com.crm.model.SMSDAO;


public class SMSDAOTest {
	
	static SMSDAO dao;
	
	@BeforeClass
	public static void start() throws Exception {
		dao = new SMSDAO();
	}
	@Test
	public void getReserveRecipient() {
		List<Integer> reserveNo = Arrays.asList(10001, 10003); 
        List<ReserveSMSVO> SMSList = dao.getReserveRecipient(reserveNo);
        System.out.println(SMSList);
		assertTrue(SMSList.size()>0);
	}
	@Test
	public void getCommonRecipient() {
		List<Integer> reserveNo = Arrays.asList(6071,6072,6073);
		List<CommonSMSVO> SMSList = dao.getCommonRecipient(reserveNo);
		System.out.println(SMSList);
		assertTrue(SMSList.size()>0);
		}
	@Test
	public void getTemplateTest(){
		List<ReserveSMSVO> templateList = dao.getTemplate("");
        System.out.println(templateList);
        assertTrue(templateList.size()>0);
	}
	@Test
	public void getReserveSMSTest(){
		int page = 2;
	    int pageSize = 10;
	    int startRow = (page - 1) * pageSize + 1; // 11
	    int endRow = page * pageSize;             // 20
	    
		Map<String, Object> map = new HashMap<>();
        map.put("startRow", startRow);
        map.put("endRow", endRow );

		List<ReserveSMSVO> SMSList = dao.getReserveSMS(map);
		System.out.println(SMSList);
		assertTrue(SMSList.size()>0);
	}
	@Test
	public void addReserveSMSTest(){
		int result = dao.addReserveSMS(10020,"honggd01","시술 예약");
		assertTrue("insert 실패", result>0);
		}
	@Test
	public void getCommonSMSTest() {
		int page = 2;
	    int pageSize = 10;
	    int startRow = (page - 1) * pageSize + 1; // 11
	    int endRow = page * pageSize;             // 20
	    
		Map<String, Object> map = new HashMap<>();
        map.put("startRow", startRow);
        map.put("endRow", endRow );

        List<CommonSMSVO> SMSList = dao.getCommonSMS(map);
        System.out.println(SMSList);
        assertTrue(SMSList.size()>0);
	}

	@Test
	public void addCommonSMSTest(){
        int result = dao.addCommonSMS(6072,"honggd01","gd");
        assertTrue("insert 실패", result>0);
	}
	
	@Test
	public void getCommonSMSDetailTest(){
	    CommonSMSVO SMSDetail = dao.getCommonSMSDetail(10);
	    System.out.println(SMSDetail);
	    assertEquals("010-2233-4455", SMSDetail.getPhone());
	}
}
