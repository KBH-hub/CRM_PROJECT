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
	/** 예약 모달 (월/주/일/시간) 별 리스트 조회*/
	//@Test
	public void getReserveListMonthTest() {
        List<ReserveVO> list = dao.getReserveList("2025-09", null, null, null, null);
        assertTrue(list.size()>0);
		System.out.println("[월간 예약 리스트(모달)]");
        for (ReserveVO r : list) {
            System.out.printf("예약 번호: %s | 예약자 이름: %s | 예약일: %s | 예약 시간: %s | 진료과: %s | 담당의사: %s %n",
            		r.getReserveNo(), r.getPatientName(), r.getReserveDay(), r.getReserveTime(), r.getDepartment(), r.getEmployeeName());
        }
	}
	
	//@Test
	public void getReserveListWeekTest() {
		List<ReserveVO> list = dao.getReserveList("2025-09", "15", "21", null, null);
		assertTrue(list.size()>0);
		System.out.println("[주간 예약 리스트(모달)]");
        for (ReserveVO r : list) {
            System.out.printf("예약 번호: %s | 예약자 이름: %s | 예약일: %s | 예약 시간: %s | 진료과: %s | 담당의사: %s %n",
            		r.getReserveNo(), r.getPatientName(), r.getReserveDay(), r.getReserveTime(), r.getDepartment(), r.getEmployeeName());
        }
	}
	
	//@Test
	public void getReserveListDayTest() {
		List<ReserveVO> list = dao.getReserveList("2025-09", "15", "21", "17", null);
		assertTrue(list.size()>0);
		System.out.println("[일간 예약 리스트(모달)]");
        for (ReserveVO r : list) {
            System.out.printf("예약 번호: %s | 예약자 이름: %s | 예약일: %s | 예약 시간: %s | 진료과: %s | 담당의사: %s %n",
            		r.getReserveNo(), r.getPatientName(), r.getReserveDay(), r.getReserveTime(), r.getDepartment(), r.getEmployeeName());
        }
	}
	
	//@Test
	public void getReserveListTimeTest() {
		List<ReserveVO> list = dao.getReserveList("2025-09", "15", "21", "17", "13");
		assertTrue(list.size()>0);
		System.out.println("[시간 별 예약 리스트(모달)]");
        for (ReserveVO r : list) {
            System.out.printf("예약 번호: %s | 예약자 이름: %s | 예약일: %s | 예약 시간: %s | 진료과: %s | 담당의사: %s %n",
            		r.getReserveNo(), r.getPatientName(), r.getReserveDay(), r.getReserveTime(), r.getDepartment(), r.getEmployeeName());
        }
	}
	
	/** 예약 캘린더 (월/주/일)별 예약 건수 조회*/
//	@Test
	public void countReserveMonthTest() {
		List<ReserveVO> list = dao.countReserveMonth("2025-09");
        assertTrue(list.size() > 0);

        System.out.println("[월별 예약 건수(캘린더)]");
        for (ReserveVO r : list) {
            System.out.printf("%s : %d건%n", r.getReserveDay(), r.getReserveCount());
        }
	}
	
//	@Test
    public void countReserveWeekByTimeTest() {
        List<ReserveVO> list = dao.countReserveWeekByTime("2025-09-15", "2025-09-21");
        assertTrue(list.size() > 0);

        System.out.println("[주간 예약 건수1 (일자+시간 기준)(캘린더)]");
        for (ReserveVO r : list) {
            System.out.printf("%s %s : %d건%n", r.getReserveDay(), r.getReserveTime(), r.getReserveCount());
        }
    }

    //@Test
    public void countReserveWeekByDayTest() {
        List<ReserveVO> list = dao.countReserveWeekByDay("2025-09-15", "2025-09-21");
        assertTrue(list.size() > 0);

        System.out.println("[주간 예약 건수2 (일자 기준)(캘린더)]");
        for (ReserveVO r : list) {
            System.out.printf("%s : %d건%n", r.getReserveDay(), r.getReserveCount());
        }
    }
    
    //@Test
    public void getReserveDayTest() {
        List<ReserveVO> list = dao.getReserveDay("2025-09-17");
        assertTrue(list.size() > 0);
        System.out.println("[일별 예약 상세(캘린더)]");
        for (ReserveVO r : list) {
            System.out.printf(
                "예약번호:%d | 예약자 이름:%s | 진료과:%s | 담당의사:%s | 예약일시:%s %s%n",
                r.getReserveNo(), r.getPatientName(), r.getDepartment(), r.getEmployeeName(), r.getReserveDay(), r.getReserveTime()
            );
        }
    }
    
    /**예약 상세*/
    //@Test
    public void getReserveDetailTest() {
        int reserveNo = 21;
        ReserveVO vo = dao.getReserveDetail(reserveNo);
        assertEquals(reserveNo, vo.getReserveNo());

        System.out.println("[예약 상세 조회]");
        System.out.printf(
            "예약번호: %d%n환자명: %s%n연락처: %s%n예약일자: %s%n예약시간: %s%n진료과: %s%n담당의: %s%n사유: %s%n",
            vo.getReserveNo(), vo.getPatientName(), vo.getPhone(), vo.getReserveDay(), vo.getReserveTime(), vo.getDepartment(),
            vo.getEmployeeName(), vo.getReason()
        );
    }
    
    /**예약 등록*/
    //@Test
    public void getPatientNameTest() {
        List<ReserveVO> list = dao.getPatientName("이승희");
        assertTrue(list.size() > 0);
        for (ReserveVO r : list) {
        	System.out.printf("환자번호:%d | 이름:%s | 연락처:%s | 최근진료:%s%n",
                    r.getPatientNo(), r.getPatientName(), r.getPhone(), r.getReserveDay());
        }
    }

    //@Test
    public void getPossibleDoctor() {
        List<ReserveVO> list = dao.getPossibleDoctor("2025-10-13", "2025-10-13 13:30");
        assertTrue(list.size() > 0);
        for (ReserveVO r : list) {
        	System.out.printf("스케줄번호:%d | 진료과:%s | 의사명:%s%n",
        			r.getDoctorScheduleNo(), r.getDepartment(), r.getEmployeeName());
        }
    }

    //@Test
    public void addReserveTest() {
        ReserveVO vo = new ReserveVO();
        vo.setDoctorScheduleNo(86);        
        vo.setPatientNo(6063);      
        vo.setReserveDay("2025-10-13");
        vo.setReserveTime("14:30");
        vo.setReason("발목부상");

        int res = dao.addReserve(vo);
        assertTrue(res > 0);
    }
    
    //@Test
    public void addReserveFailTest() {
    	ReserveVO vo = new ReserveVO();
    	vo.setDoctorScheduleNo(86);        
    	vo.setPatientNo(6080);      
    	vo.setReserveDay("2025-10-13");
    	vo.setReserveTime("16:00");
    	vo.setReason("손목부상");
    	
    	int res = dao.addReserve(vo);
    	assertFalse(res > 0);
    }

    /**예약 수정*/
    //@Test
    public void editReserveTest() {
        ReserveVO vo = new ReserveVO();
        vo.setReserveNo(26);    
        vo.setDoctorScheduleNo(86);   
        vo.setReserveDay("2025-10-13");
        vo.setReserveTime("17:30");
        vo.setReason("발목부상");

        int res = dao.editReserve(vo);
        assertTrue(res > 0);
    }

    /**예약 삭제*/
   // @Test
    public void deleteReserveTest() {
    	List<Integer> list = Arrays.asList(10001, 10003, 10005);
        int res = dao.deleteReserve(list);
        assertTrue(res > 0);
    }
    
    /**금일 총 예약 건수*/
    //@Test
    public void getDailyReserveCount() {
    	List<ReserveVO> list = dao.countDailyAllReserve();
    	assertTrue(list.size() > 0);
    	System.out.println("[금일 총 예약 건수(사이드바)]");
    	for (ReserveVO r : list) {
    		System.out.printf("일자:%s | 건수:%d%n", r.getReserveDay(), r.getReserveCount());
    	}
    }
    
    /**금일 본인 예약 건수*/
    //@Test
    public void getDoctorOwnDailyReserveCount() {
    	List<ReserveVO> list = dao.countDailyMyReserve("kimus01");
    	assertTrue(list.size() > 0);
    	System.out.println("[금일 본인 예약 건수(사이드바)]");
    	for (ReserveVO r : list) {
    		System.out.printf("일자:%s | 건수:%d%n", r.getReserveDay(), r.getReserveCount());
    	}
    }
    
	/**월간 본인 예약 건수(캘린더)*/
    //@Test
    public void countMyReserveMonthTest() {
    	List<ReserveVO> list = dao.countMyReserveMonth("kimus01","2025-09");
    	assertTrue(list.size() > 0);
    	System.out.println("[의료진 본인 월간 예약 (캘린더)]");
    	for (ReserveVO r : list) {
    		System.out.printf("일자:%s | 건수:%d%n", r.getReserveDay(), r.getReserveCount());
    	}
    }
    
	/**주간1 - 본인 예약 건수(캘린더)*/
    //@Test
    public void countMyReserveWeekTest() {
    	List<ReserveVO> list = dao.getMyReserveList(
    			"kimus01", "2025-09", "2025-09-15", "2025-09-21", null, null
    			);
    	assertTrue(list.size() > 0);
    	System.out.println("[의료진 주간 본인 예약 (캘린더)]");
    	for (ReserveVO r : list) {
    		System.out.printf(
    				"예약번호:%s | 이름:%s | 방문 예정 일:%s | 방문 예정 시간: %s | 사유: %s%n",
    				r.getReserveNo(), r.getPatientName(), r.getReserveDay(), r.getReserveTime(), r.getReason()
    				);
    	}
    }
    
    /**주간2 - 일별 본인 예약 건수(캘린더)*/
    //@Test
    public void countMyReserveWeekByDayTest() {
    	List<ReserveVO> list = dao.countMyReserveWeek(
    			"kimus01", "2025-09", "2025-09-15", "2025-09-21"
    			);
    	assertTrue(list.size() > 0);
    	System.out.println("[의료진 주간 -일별 본인 예약 건수(캘린더)]");
    	for (ReserveVO r : list) {
    		System.out.printf("일자:%s | 건수:%d%n", r.getReserveDay(), r.getReserveCount());
    	}
    }
    
    /**일간 본인 예약 건수(캘린더)*/
    //@Test
    public void getMyReserveList() {
    	List<ReserveVO> list = dao.getMyReserveList(
    			"kimus01", "2025-09", "2025-09-15", "2025-09-21", "2025-09-16", "15"
    			);
    	assertTrue(list.size() > 0);
    	System.out.println("[의료진 본인 일간 예약 (캘린더)]");
    	for (ReserveVO r : list) {
    		System.out.printf(
    				"예약번호:%s | 이름:%s  | 방문 예정 시간: %s | 사유: %s%n",
    				r.getReserveNo(), r.getPatientName(), r.getReserveTime(), r.getReason()
    				);
    	}
    }
    
	/** 예약 모달 (월/주/일/시간) 별 본인 리스트 조회*/
    //@Test
    public void getMyReserveListMonthTest() {
    	List<ReserveVO> list = dao.getMyReserveList(
    			"kimus01", "2025-09", null, null, null, null 
    			);
    	assertTrue(list.size() > 0);
    	System.out.println("[의료진 본인 예약 목록(월간)(모달)]");
    	for (ReserveVO r : list) {
    		System.out.printf(
    				"예약번호:%d | 이름:%s | 방문 예정 일:%s | 방문 예정 시간: %s | 담당 의사: %s | 진료과: %s%n",
    				r.getReserveNo(), r.getPatientName(), r.getReserveDay(), r.getReserveTime(), r.getEmployeeName(), r.getDepartment()
    				);
    	}
    }
    //@Test
    public void getMyReserveListWeekTest() {
    	List<ReserveVO> list = dao.getMyReserveList(
    			"kimus01", "2025-09", "2025-09-15", "2025-09-21", null, null
    			);
    	assertTrue(list.size() > 0);
    	System.out.println("[의료진 본인 예약 목록(주간)(모달)]");
    	for (ReserveVO r : list) {
    		System.out.printf(
    				"예약번호:%d | 이름:%s | 방문 예정 일:%s | 방문 예정 시간: %s | 담당 의사: %s | 진료과: %s%n",
    				r.getReserveNo(), r.getPatientName(), r.getReserveDay(), r.getReserveTime(), r.getEmployeeName(), r.getDepartment()
    				);
    	}
    }
    //@Test
    public void getMyReserveListDayTest() {
    	List<ReserveVO> list = dao.getMyReserveList(
    			"kimus01", "2025-09", "2025-09-15", "2025-09-21", "2025-09-16", null 
    			);
    	assertTrue(list.size() > 0);
    	System.out.println("[의료진 본인 예약 목록(일간)(모달)]");
    	for (ReserveVO r : list) {
    		System.out.printf(
    				"예약번호:%d | 이름:%s | 방문 예정 일:%s | 방문 예정 시간: %s | 담당 의사: %s | 진료과: %s%n",
    				r.getReserveNo(), r.getPatientName(), r.getReserveDay(), r.getReserveTime(), r.getEmployeeName(), r.getDepartment()
    				);
    	}
    }
    //@Test
    public void getMyReserveListTimeTest() {
        List<ReserveVO> list = dao.getMyReserveList(
            "kimus01", "2025-09", "2025-09-15", "2025-09-21", "2025-09-16", "15" 
        );
        assertTrue(list.size() > 0);
        System.out.println("[의료진 본인 예약 목록(시간 별)(모달)]");
        for (ReserveVO r : list) {
            System.out.printf(
                "예약번호:%d | 이름:%s | 방문 예정 일:%s | 방문 예정 시간: %s | 담당 의사: %s | 진료과: %s%n",
                r.getReserveNo(), r.getPatientName(), r.getReserveDay(), r.getReserveTime(), r.getEmployeeName(), r.getDepartment()
            );
        }
    }
    
}
