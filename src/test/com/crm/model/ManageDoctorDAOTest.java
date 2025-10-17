package test.com.crm.model;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.crm.model.ManageDoctorDAO;
import com.crm.model.ManageDoctorVO;

public class ManageDoctorDAOTest {
	
static ManageDoctorDAO dao;
	
	@BeforeClass
	public static void start() throws Exception {
		dao = new ManageDoctorDAO();
	}
	@Test
	public void getDoctorScheduleTest(){
		List<ManageDoctorVO> list = dao.getDoctorSchedule("2025-09-15", "2025-09-15");
		System.out.println(list);
		assertTrue(list.size()>0);
	}
	@Test
	public void getDoctorNameTest(){
		List<ManageDoctorVO> list = dao.getDoctorName("2025-09-01", "2025-09-25");
		System.out.println(list);
		assertTrue(list.size()>0);
	}
	@Test
	public void addDoctorScheduleTest(){
		int result = dao.addDoctorSchedule("DA001", "2025-09-25");
		assertTrue("실패", result>0);
	}
	@Test
	public void editDoctorScheduleTest(){
		int result = dao.editDoctorSchedule(14, 'Y', 'Y');
		assertTrue("실패", result>0);
	}
	@Test
	public void deleteDoctorScheduleTest(){
		int result = dao.deleteDoctorSchedule("30");
		assertTrue("실패", result>0);
	}
	@Test
	public void getDoctorListTest(){
		List<ManageDoctorVO> list = dao.getDoctorList();
		System.out.println(list);
		assertTrue(list.size()>0);
	}
}
