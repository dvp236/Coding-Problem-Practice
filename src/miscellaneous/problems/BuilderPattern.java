package miscellaneous.problems;

public class BuilderPattern {
	
	public static void main(String[] args){
		Person p = new Person.Builder("dharmik","Patel").country("india").phoneNum(9090909).build();
		System.out.println(p.getCountry());
		System.out.println(p.getPhoneNum());
	}
}
