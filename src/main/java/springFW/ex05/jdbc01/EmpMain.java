package springFw.ex05.jdbc01;

import java.util.Date;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class EmpMain {

	public static void main(String[] args) {
		AbstractApplicationContext context = new GenericXmlApplicationContext("classpath:config/jdbc01/application-config.xml");
		
		IEmpService empService = context.getBean(IEmpService.class);
		
		System.out.println("-- 사원수");
		System.out.println(empService.getEmpCount());
		System.out.println(empService.getEmpCount(50));
		
		System.out.println("-- 사원 리스트");
		System.out.println(empService.getEmpList());

		System.out.println("-- 사원 정보");
		System.out.println(empService.getEmpInfo(200));
		
		System.out.println("-- 사원 수정");
		EmpVO emp = new EmpVO();
		emp.setFirstName("fn");
		emp.setLastName("ln");
		emp.setEmail("email");
		emp.setPhoneNumber("pn");
		emp.setJobId("AD_PRES");
		emp.setSalary(10000);
		emp.setCommissionPct(0.0);
		emp.setManagerId(100);
		emp.setDepartmentId(90);
		emp.setEmployeeId(200);
		
		empService.updateEmp(emp);
		System.out.println(empService.getEmpInfo(200));
		
		System.out.println("-- 사원번호가 210번인 사원 등록/확인");
		emp = new EmpVO();
		emp.setEmployeeId(210);
		emp.setFirstName("fn");
		emp.setLastName("ln");
		emp.setEmail("email1");
		emp.setPhoneNumber("pn");
		emp.setJobId("AD_PRES");
		emp.setSalary(10000);
		emp.setCommissionPct(0.0);
		emp.setManagerId(100);
		emp.setDepartmentId(90);
		
		empService.insertEmp(emp);
		System.out.println(empService.getEmpInfo(210));
		
		
		System.out.println("-- 사원번호가 210번인 사원의 급여를 10% 인상/확인");
		EmpVO emp210 = empService.getEmpInfo(210);
		emp210.setSalary(emp210.getSalary() * 1.1);
		System.out.println(empService.getEmpInfo(210));
		
		System.out.println("-- 사원번호가 210번인 사원 삭제/확인");
		empService.deleteEmp(210, "email1");
		System.out.println("삭제되었습니다.");
		
		System.out.println("-- 부서 데이터 출력");
		System.out.println(empService.getAllDeptId());
		
		System.out.println("-- 직무 데이터 출력");
		System.out.println(empService.getAllDeptId());
		
		System.out.println("-- 매니저id와 이름 출력");
		System.out.println(empService.getAllManagerId());
		
	}

}
