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
		assertEquals("�躴��", vo.getPatientName());
	}
	//@Test
	public void getMedicalRecordTest(){
		List<MedicalRecordVO> list = dao.getMedicalRecord(6071);
		System.out.println(list);
		assertTrue(list.size()>0);
	}
	//@Test
	public void addPatientTest() {
        int result = dao.addPatient("���׽�Ʈ","010-1111-1111");
        assertTrue("insert ����", result>0);
	}
	//@Test
	public void editPatientTest() {
		int result = dao.editPatient("tt","010-2222-2222","����Ư���� ��õ�� ���굿","880301","��","���ͳ� �˻�",21);
		assertTrue("insert ����", result>0);
	}
	//@Test
	public void deletePatientTest() {
		int result = dao.deletePatient(21);
        assertTrue("insert ����", result>0);
	}

}
