package test.com.crm.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import com.crm.model.ReserveListDAO;
import com.crm.model.ReserveVO;

public class ReserveListDAOTest {
	static ReserveListDAO dao;
	
	@BeforeClass
	public static void start() throws Exception {
		dao = new ReserveListDAO();
	}
	/** �삁�빟 紐⑤떖 (�썡/二�/�씪/�떆媛�) 蹂� 由ъ뒪�듃 議고쉶*/
	@Test
	public void getReserveListMonthTest() {
        List<ReserveVO> list = dao.getReserveList("2025-09", null, null, null, null);
        assertTrue(list.size()>0);
		System.out.println("[�썡媛� �삁�빟 由ъ뒪�듃(紐⑤떖)]");
        for (ReserveVO r : list) {
            System.out.printf("�삁�빟 踰덊샇: %s | �삁�빟�옄 �씠由�: %s | �삁�빟�씪: %s | �삁�빟 �떆媛�: %s | 吏꾨즺怨�: %s | �떞�떦�쓽�궗: %s %n",
            		r.getReserveNo(), r.getPatientName(), r.getReserveDay(), r.getReserveTime(), r.getDepartment(), r.getEmployeeName());
        }
	}
	
	@Test
	public void getReserveListWeekTest() {
		List<ReserveVO> list = dao.getReserveList("2025-09", "15", "21", null, null);
		assertTrue(list.size()>0);
		System.out.println("[二쇨컙 �삁�빟 由ъ뒪�듃(紐⑤떖)]");
        for (ReserveVO r : list) {
            System.out.printf("�삁�빟 踰덊샇: %s | �삁�빟�옄 �씠由�: %s | �삁�빟�씪: %s | �삁�빟 �떆媛�: %s | 吏꾨즺怨�: %s | �떞�떦�쓽�궗: %s %n",
            		r.getReserveNo(), r.getPatientName(), r.getReserveDay(), r.getReserveTime(), r.getDepartment(), r.getEmployeeName());
        }
	}
	
	@Test
	public void getReserveListDayTest() {
		List<ReserveVO> list = dao.getReserveList("2025-09", "15", "21", "17", null);
		assertTrue(list.size()>0);
		System.out.println("[�씪媛� �삁�빟 由ъ뒪�듃(紐⑤떖)]");
        for (ReserveVO r : list) {
            System.out.printf("�삁�빟 踰덊샇: %s | �삁�빟�옄 �씠由�: %s | �삁�빟�씪: %s | �삁�빟 �떆媛�: %s | 吏꾨즺怨�: %s | �떞�떦�쓽�궗: %s %n",
            		r.getReserveNo(), r.getPatientName(), r.getReserveDay(), r.getReserveTime(), r.getDepartment(), r.getEmployeeName());
        }
	}
	
	@Test
	public void getReserveListTimeTest() {
		List<ReserveVO> list = dao.getReserveList("2025-09", "15", "21", "17", "13");
		assertTrue(list.size()>0);
		System.out.println("[�떆媛� 蹂� �삁�빟 由ъ뒪�듃(紐⑤떖)]");
        for (ReserveVO r : list) {
            System.out.printf("�삁�빟 踰덊샇: %s | �삁�빟�옄 �씠由�: %s | �삁�빟�씪: %s | �삁�빟 �떆媛�: %s | 吏꾨즺怨�: %s | �떞�떦�쓽�궗: %s %n",
            		r.getReserveNo(), r.getPatientName(), r.getReserveDay(), r.getReserveTime(), r.getDepartment(), r.getEmployeeName());
        }
	}
	
	/** �삁�빟 罹섎┛�뜑 (�썡/二�/�씪)蹂� �삁�빟 嫄댁닔 議고쉶*/
    public void countReserveWeekByTimeTest() {
        List<ReserveVO> list = dao.countReserveWeekByTime("2025-09-15", "2025-09-21");
        assertTrue(list.size() > 0);

        System.out.println("[二쇨컙 �삁�빟 嫄댁닔1 (�씪�옄+�떆媛� 湲곗�)(罹섎┛�뜑)]");
        for (ReserveVO r : list) {
            System.out.printf("%s %s : %d嫄�%n", r.getReserveDay(), r.getReserveTime(), r.getReserveCount());
        }
    }

    @Test
    public void countReserveWeekByDayTest() {
        List<ReserveVO> list = dao.countReserveWeekByDay("2025-09-15", "2025-09-21");
        assertTrue(list.size() > 0);

        System.out.println("[二쇨컙 �삁�빟 嫄댁닔2 (�씪�옄 湲곗�)(罹섎┛�뜑)]");
        for (ReserveVO r : list) {
            System.out.printf("%s : %d嫄�%n", r.getReserveDay(), r.getReserveCount());
        }
    }
    
    @Test
    public void getReserveDayTest() {
        List<ReserveVO> list = dao.getReserveDay("2025-09-17");
        assertTrue(list.size() > 0);
        System.out.println("[�씪蹂� �삁�빟 �긽�꽭(罹섎┛�뜑)]");
        for (ReserveVO r : list) {
            System.out.printf(
                "�삁�빟踰덊샇:%d | �삁�빟�옄 �씠由�:%s | 吏꾨즺怨�:%s | �떞�떦�쓽�궗:%s | �삁�빟�씪�떆:%s %s%n",
                r.getReserveNo(), r.getPatientName(), r.getDepartment(), r.getEmployeeName(), r.getReserveDay(), r.getReserveTime()
            );
        }
    }
    
    /**�삁�빟 �긽�꽭*/
    @Test
    public void getReserveDetailTest() {
        int reserveNo = 21;
        ReserveVO vo = dao.getReserveDetail(reserveNo);
        assertEquals(reserveNo, vo.getReserveNo());

        System.out.println("[�삁�빟 �긽�꽭 議고쉶]");
        System.out.printf(
            "�삁�빟踰덊샇: %d%n�솚�옄紐�: %s%n�뿰�씫泥�: %s%n�삁�빟�씪�옄: %s%n�삁�빟�떆媛�: %s%n吏꾨즺怨�: %s%n�떞�떦�쓽: %s%n�궗�쑀: %s%n",
            vo.getReserveNo(), vo.getPatientName(), vo.getPhone(), vo.getReserveDay(), vo.getReserveTime(), vo.getDepartment(),
            vo.getEmployeeName(), vo.getReason()
        );
    }
    
    /**�삁�빟 �벑濡�*/
    @Test
    public void getPatientNameTest() {
        List<ReserveVO> list = dao.getPatientName("�씠�듅�씗");
        assertTrue(list.size() > 0);
        for (ReserveVO r : list) {
        	System.out.printf("�솚�옄踰덊샇:%d | �씠由�:%s | �뿰�씫泥�:%s | 理쒓렐吏꾨즺:%s%n",
                    r.getPatientNo(), r.getPatientName(), r.getPhone(), r.getReserveDay());
        }
    }

    @Test
    public void getPossibleDoctor() {
        List<ReserveVO> list = dao.getPossibleDoctor("2025-10-13", "2025-10-13 13:30");
        assertTrue(list.size() > 0);
        for (ReserveVO r : list) {
        	System.out.printf("�뒪耳�以꾨쾲�샇:%d | 吏꾨즺怨�:%s | �쓽�궗紐�:%s%n",
        			r.getDoctorScheduleNo(), r.getDepartment(), r.getEmployeeName());
        }
    }

    @Test
    public void addReserveTest() {
        ReserveVO vo = new ReserveVO();
        vo.setDoctorScheduleNo(86);        
        vo.setPatientNo(6063);      
        vo.setReserveDay("2025-10-13");
        vo.setReserveTime("14:30");
        vo.setReason("諛쒕ぉ遺��긽");

        int res = dao.addReserve(vo);
        assertTrue(res > 0);
    }
    
    @Test
    public void addReserveFailTest() {
    	ReserveVO vo = new ReserveVO();
    	vo.setDoctorScheduleNo(86);        
    	vo.setPatientNo(6080);      
    	vo.setReserveDay("2025-10-13");
    	vo.setReserveTime("16:00");
    	vo.setReason("�넀紐⑸��긽");
    	
    	int res = dao.addReserve(vo);
    	assertFalse(res > 0);
    }

    /**�삁�빟 �닔�젙*/
    @Test
    public void editReserveTest() {
        ReserveVO vo = new ReserveVO();
        vo.setReserveNo(26);    
        vo.setDoctorScheduleNo(86);   
        vo.setReserveDay("2025-10-13");
        vo.setReserveTime("17:30");
        vo.setReason("諛쒕ぉ遺��긽");

        int res = dao.editReserve(vo);
        assertTrue(res > 0);
    }

    /**�삁�빟 �궘�젣*/
    @Test
    public void deleteReserveTest() {
    	List<Integer> list = Arrays.asList(10001, 10003, 10005);
        int res = dao.deleteReserve(list);
        assertTrue(res > 0);
    }
    
    /**湲덉씪 珥� �삁�빟 嫄댁닔*/
    @Test
    public void getDailyReserveCount() {
    	List<ReserveVO> list = dao.countDailyAllReserve();
    	assertTrue(list.size() > 0);
    	System.out.println("[湲덉씪 珥� �삁�빟 嫄댁닔(�궗�씠�뱶諛�)]");
    	for (ReserveVO r : list) {
    		System.out.printf("�씪�옄:%s | 嫄댁닔:%d%n", r.getReserveDay(), r.getReserveCount());
    	}
    }
    
    /**湲덉씪 蹂몄씤 �삁�빟 嫄댁닔*/
    @Test
    public void getDoctorOwnDailyReserveCount() {
    	List<ReserveVO> list = dao.countDailyMyReserve("kimus01");
    	assertTrue(list.size() > 0);
    	System.out.println("[湲덉씪 蹂몄씤 �삁�빟 嫄댁닔(�궗�씠�뱶諛�)]");
    	for (ReserveVO r : list) {
    		System.out.printf("�씪�옄:%s | 嫄댁닔:%d%n", r.getReserveDay(), r.getReserveCount());
    	}
    }
    
	/**�썡媛� 蹂몄씤 �삁�빟 嫄댁닔(罹섎┛�뜑)*/
    @Test
    public void countMyReserveMonthTest() {
    	List<ReserveVO> list = dao.countMyReserveMonth("kimus01","2025-09");
    	assertTrue(list.size() > 0);
    	System.out.println("[�쓽猷뚯쭊 蹂몄씤 �썡媛� �삁�빟 (罹섎┛�뜑)]");
    	for (ReserveVO r : list) {
    		System.out.printf("�씪�옄:%s | 嫄댁닔:%d%n", r.getReserveDay(), r.getReserveCount());
    	}
    }
    
	/**二쇨컙1 - 蹂몄씤 �삁�빟 嫄댁닔(罹섎┛�뜑)*/
    @Test
    public void countMyReserveWeekTest() {
    	List<ReserveVO> list = dao.getMyReserveList(
    			"kimus01", "2025-09", "2025-09-15", "2025-09-21", null, null
    			);
    	assertTrue(list.size() > 0);
    	System.out.println("[�쓽猷뚯쭊 二쇨컙 蹂몄씤 �삁�빟 (罹섎┛�뜑)]");
    	for (ReserveVO r : list) {
    		System.out.printf(
    				"�삁�빟踰덊샇:%s | �씠由�:%s | 諛⑸Ц �삁�젙 �씪:%s | 諛⑸Ц �삁�젙 �떆媛�: %s | �궗�쑀: %s%n",
    				r.getReserveNo(), r.getPatientName(), r.getReserveDay(), r.getReserveTime(), r.getReason()
    				);
    	}
    }
    
    /**二쇨컙2 - �씪蹂� 蹂몄씤 �삁�빟 嫄댁닔(罹섎┛�뜑)*/
    @Test
    public void countMyReserveWeekByDayTest() {
    	List<ReserveVO> list = dao.countMyReserveWeek(
    			"kimus01", "2025-09", "2025-09-15", "2025-09-21"
    			);
    	assertTrue(list.size() > 0);
    	System.out.println("[�쓽猷뚯쭊 二쇨컙 -�씪蹂� 蹂몄씤 �삁�빟 嫄댁닔(罹섎┛�뜑)]");
    	for (ReserveVO r : list) {
    		System.out.printf("�씪�옄:%s | 嫄댁닔:%d%n", r.getReserveDay(), r.getReserveCount());
    	}
    }
    
    /**�씪媛� 蹂몄씤 �삁�빟 嫄댁닔(罹섎┛�뜑)*/
    @Test
    public void getMyReserveList() {
    	List<ReserveVO> list = dao.getMyReserveList(
    			"kimus01", "2025-09", "2025-09-15", "2025-09-21", "2025-09-16", "15"
    			);
    	assertTrue(list.size() > 0);
    	System.out.println("[�쓽猷뚯쭊 蹂몄씤 �씪媛� �삁�빟 (罹섎┛�뜑)]");
    	for (ReserveVO r : list) {
    		System.out.printf(
    				"�삁�빟踰덊샇:%s | �씠由�:%s  | 諛⑸Ц �삁�젙 �떆媛�: %s | �궗�쑀: %s%n",
    				r.getReserveNo(), r.getPatientName(), r.getReserveTime(), r.getReason()
    				);
    	}
    }
    
	/** �삁�빟 紐⑤떖 (�썡/二�/�씪/�떆媛�) 蹂� 蹂몄씤 由ъ뒪�듃 議고쉶*/
    @Test
    public void getMyReserveListMonthTest() {
    	List<ReserveVO> list = dao.getMyReserveList(
    			"kimus01", "2025-09", null, null, null, null 
    			);
    	assertTrue(list.size() > 0);
    	System.out.println("[�쓽猷뚯쭊 蹂몄씤 �삁�빟 紐⑸줉(�썡媛�)(紐⑤떖)]");
    	for (ReserveVO r : list) {
    		System.out.printf(
    				"�삁�빟踰덊샇:%d | �씠由�:%s | 諛⑸Ц �삁�젙 �씪:%s | 諛⑸Ц �삁�젙 �떆媛�: %s | �떞�떦 �쓽�궗: %s | 吏꾨즺怨�: %s%n",
    				r.getReserveNo(), r.getPatientName(), r.getReserveDay(), r.getReserveTime(), r.getEmployeeName(), r.getDepartment()
    				);
    	}
    }
    @Test
    public void getMyReserveListWeekTest() {
    	List<ReserveVO> list = dao.getMyReserveList(
    			"kimus01", "2025-09", "2025-09-15", "2025-09-21", null, null
    			);
    	assertTrue(list.size() > 0);
    	System.out.println("[�쓽猷뚯쭊 蹂몄씤 �삁�빟 紐⑸줉(二쇨컙)(紐⑤떖)]");
    	for (ReserveVO r : list) {
    		System.out.printf(
    				"�삁�빟踰덊샇:%d | �씠由�:%s | 諛⑸Ц �삁�젙 �씪:%s | 諛⑸Ц �삁�젙 �떆媛�: %s | �떞�떦 �쓽�궗: %s | 吏꾨즺怨�: %s%n",
    				r.getReserveNo(), r.getPatientName(), r.getReserveDay(), r.getReserveTime(), r.getEmployeeName(), r.getDepartment()
    				);
    	}
    }
    @Test
    public void getMyReserveListDayTest() {
    	List<ReserveVO> list = dao.getMyReserveList(
    			"kimus01", "2025-09", "2025-09-15", "2025-09-21", "2025-09-16", null 
    			);
    	assertTrue(list.size() > 0);
    	System.out.println("[�쓽猷뚯쭊 蹂몄씤 �삁�빟 紐⑸줉(�씪媛�)(紐⑤떖)]");
    	for (ReserveVO r : list) {
    		System.out.printf(
    				"�삁�빟踰덊샇:%d | �씠由�:%s | 諛⑸Ц �삁�젙 �씪:%s | 諛⑸Ц �삁�젙 �떆媛�: %s | �떞�떦 �쓽�궗: %s | 吏꾨즺怨�: %s%n",
    				r.getReserveNo(), r.getPatientName(), r.getReserveDay(), r.getReserveTime(), r.getEmployeeName(), r.getDepartment()
    				);
    	}
    }
    @Test
    public void getMyReserveListTimeTest() {
        List<ReserveVO> list = dao.getMyReserveList(
            "kimus01", "2025-09", "2025-09-15", "2025-09-21", "2025-09-16", "15" 
        );
        assertTrue(list.size() > 0);
        System.out.println("[�쓽猷뚯쭊 蹂몄씤 �삁�빟 紐⑸줉(�떆媛� 蹂�)(紐⑤떖)]");
        for (ReserveVO r : list) {
            System.out.printf(
                "�삁�빟踰덊샇:%d | �씠由�:%s | 諛⑸Ц �삁�젙 �씪:%s | 諛⑸Ц �삁�젙 �떆媛�: %s | �떞�떦 �쓽�궗: %s | 吏꾨즺怨�: %s%n",
                r.getReserveNo(), r.getPatientName(), r.getReserveDay(), r.getReserveTime(), r.getEmployeeName(), r.getDepartment()
            );
        }
    }
    
}
