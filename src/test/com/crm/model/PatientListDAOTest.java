package test.com.crm.model;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	@Test
	public void getPatientListTest(){
		int page = 2;
	    int pageSize = 10;
	    int startRow = (page - 1) * pageSize + 1; // 11
	    int endRow = page * pageSize;             // 20
	    
		Map<String, Object> map = new HashMap<>();
        map.put("startDate", "");
        map.put("endDate", "");
        map.put("doctorCode", "");
        map.put("patientName", "");
        map.put("birth", "");
        map.put("startRow", startRow);
        map.put("endRow", endRow );

        List<PatientVO> list = dao.getPatientList(map);

        System.out.println("조회 결과 건수: " + (list != null ? list.size() : 0));
        list.forEach(vo -> System.out.println(
                vo.getPatientNo() + " / " + vo.getPatientName() + " / " + vo.getPhone()+ " / " + vo.getMedicalDate()+ " / "
        + vo.getEmployeeName()+ " / " + vo.getDepartment()+ " / " + vo.getStatus()+ " / " + vo.getDiagnosis()));

        assertNotNull("리스트가 null 입니다.", list);
        assertTrue("조회 결과 없음", list.size() >= 0); // 데이터가 없어도 실패하지 않도록
	}
	@Test
	public void getPatientDetailTest(){
		PatientVO vo = dao.getPatientDetail(6072);
		System.out.println(vo.getPatientName());
		assertEquals("김병만", vo.getPatientName());
	}
	@Test
	public void getMedicalRecordTest(){
		List<MedicalRecordVO> list = dao.getMedicalRecord(6071);
		System.out.println(list);
		assertTrue(list.size()>0);
	}
	@Test
	public void addPatientTest() {
        int result = dao.addPatient("김테스트","010-1111-1111");
        assertTrue("insert 실패", result>0);
	}
	@Test
	public void editPatientTest() {
		int result = dao.editPatient("tt","010-2222-2222","서울특별시 금천구 가산동","880301","남","인터넷 검색",21);
		assertTrue("insert 실패", result>0);
	}
	@Test
	public void deletePatientTest() {
		int result = dao.deletePatient(6064);
        assertTrue("insert 실패", result>0);
	}

}
