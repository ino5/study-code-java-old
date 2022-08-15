package javastudy.temp.annotation.company;

import java.lang.annotation.Annotation;

public class Main {
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException { // getMethod에 대한 Exception
		/* employee 생성 */
		Employee employee = new Employee(1, "John Doe"); // id: 1, name: John Doe
		
		/* employee 정보 출력 */
		employee.getEmployeeDetails(); // 출력: 1, John Doe
		
		/* employee의 어노테이션 Company 가져오기 */
		Annotation companyAnnotation = employee.getClass().getAnnotation(Company.class); // 클래스의 Company 어노테이션 가져오기
		Company company = (Company) companyAnnotation;
		
		/* employee의 어노테이션 Company에 지정한 값 가져오기 */
		System.out.println("Company Name: " + company.name()); // Jack
		System.out.println("Company City: " + company.city()); // XYZ
		
		/* employee의 어노테이션 Star 가져오기 */
		Annotation starAnnotation = employee.getClass().getMethod("getEmployeeDetails", int.class).getAnnotation(Star.class); // 메소드의 Star 어노테이션 가져오기
		Star star = (Star) starAnnotation;
		
		/* employee의 어노테이션 Star에 지정한 값 가져오기 */
		int starNum = star.value();
		employee.getEmployeeDetails(starNum);
	}
	
}
