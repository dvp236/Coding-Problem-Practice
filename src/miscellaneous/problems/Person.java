package miscellaneous.problems;


public class Person {
	private final String firstName;
	private final String lastName;
	
	private final String state;
	private final String country;
	private final int phoneNum;
	
	public static class Builder{
		private final String firstName;
		private final String lastName;
		
		private String state = "";
		private String country ="";
		private int phoneNum=0;
		
		public Builder(String firstName,String lastName){
			this.firstName=firstName;
			this.lastName= lastName;
		}
		
		public Builder state(String state){
			this.state=state;
			return this;
		}
		
		public Builder country(String country){
			this.country=country;
			return this;
		}
		
		public Builder phoneNum(int num){
			this.phoneNum = num;
			return this;
		}
		
		public Person build(){
			return new Person(this);
		}
		
	}
	
	private Person(Builder builder){
		firstName = builder.firstName;
		lastName = builder.lastName;
		state = builder.state;
		country = builder.country;
		phoneNum = builder.phoneNum;
		
	}
	
	public String getCountry(){
		return country;
	}
	
	public String getName(){
		return firstName;
	}
	
	public String getState(){
		return state;
	}
	public int getPhoneNum(){
		return phoneNum;
	}
}