package test.com.crm.model;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.crm.model.MedicalRecordVO;
import com.crm.model.PatientListDAO;
import com.crm.model.PatientVO;

public class PatientListDAOTest {

	static PatientListDAO dao;
	
	@BeforeClass
	public static void start() throws Exception {
		dao = new PatientListDAO();
	}
	//@Test
	public void getPatientListTest(){
		List<PatientVO> list = dao.getPatientList("", "", "", "", "");
		System.out.println(list);
		assertTrue(list.size()>0);
	}
	//@Test
	public void getPatientDetailTest(){
		PatientVO vo = dao.getPatientDetail(6072);
		System.out.println(vo.getPatientName());
		assertEquals("김병만", vo.getPatientName());
	}
	//@Test
	public void getMedicalRecordTest(){
		List<MedicalRecordVO> list = dao.getMedicalRecord(6071);
		System.out.println(list);
		assertTrue(list.size()>0);
	}
	//@Test
	public void addPatientTest() {
        int result = dao.addPatient("김테스트","010-1111-1111");
        assertTrue("insert 실패", result>0);
	}
	//@Test
	public void editPatientTest() {
		int result = dao.editPatient("tt","010-2222-2222","서울특별시 금천구 가산동","880301","남","인터넷 검색",21);
		assertTrue("insert 실패", result>0);
	}
	//@Test
	public void deletePatientTest() {
		int result = dao.deletePatient(21);
        assertTrue("insert 실패", result>0);
	}

}
