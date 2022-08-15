package javastudy.temp.annotation.company;

@Company(name = "Jack")
public class Employee {
	
	private int id;
	private String name;
	
	/**
	 * 생성자
	 * @param id
	 * @param name
	 */
	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	/**
	 * employee 정보 출력
	 */
	public void getEmployeeDetails() {
		System.out.println("Employee Id: " + id);
		System.out.println("Employee Name: " + name);
	}
	
	/**
	 * employee 정보 출력
	 * @param starNum 정보출력될 "*"의 개수
	 */
	@Star(10) // 어노테이션의 value 필드의 경우 지정할 때 "value = 10" 대신 value를 생략해서 지정 가능
	public void getEmployeeDetails(int starNum) {
		/* "*" 출력 */
		for (int i = 0; i < starNum; i++) {
			System.out.print("*");
		}
		System.out.println("");
		
		/* employe 정보 출력 */
		getEmployeeDetails(); 
	}
	

}
