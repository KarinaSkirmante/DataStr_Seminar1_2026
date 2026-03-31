package model;

//modelu klase
public class Student {
	//1. mainigie
	private long studId;
	private String name;
	private String surname;
	private String personCode;
	
	//palgmainigais, kam nevajag ne set, ne get
	private static long counter = 0;
	
	//2. get funkcijas
	public long getStudId() {
		return studId;
	}
	
	public String getName() {
		return name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public String getPersonCode() {
		return personCode;
	}
	
	//3. set funkcijas
	public void setStudId() {
		studId = counter;
		counter++;
	}

	public void setName(String inputName) {
		if((inputName != null) && (!inputName.isEmpty()) && (inputName.matches("[A-Z]{1}[a-z]{2,15}([ ]{1}[A-Z]{1}[a-z]{2,15})?"))    )
		{
			name = inputName;
		}
		else
		{
			name = "Unknown";
		}
	}
	
	
	public void setSurname(String inputSurname) {
		if((inputSurname != null) && (!inputSurname.isEmpty()) 
				&& (inputSurname.matches("[A-Z]{1}[a-z]{2,15}([-]{1}[A-Z]{1}[a-z]{2,15})?"))    )
		{
			surname = inputSurname;
		}
		else
		{
			surname = "Unknown";
		}
	}
	
	public void setPersonCode(String inputPersonCode) {
		//TODO regex masku paskatities, lai ir atbilstosi dienu skaitam konkreta menesi
		if((inputPersonCode != null) && (!inputPersonCode.isEmpty()) 
				&& (inputPersonCode.matches("[0-9]{6}[-]{1}[0-9]{5}")) ) {
			personCode = inputPersonCode;
		}
		else
		{
			personCode = "Unknown";
		}
	}
	
	//4.1. bezargumenta konstruktors
	public Student() {
		setStudId();
		setName("Janis");
		setSurname("Berzins-Kalnins");
		setPersonCode("121212-12345");
	}
	//4.2. argumuneta konstruktors
	public Student(String inputName, String inputSurname, String inputPersonCode) {
		setStudId();
		setName(inputName);
		setSurname(inputSurname);
		setPersonCode(inputPersonCode);
	}
	//5. toString funkcija
	//@Override //var so nerakstit, bet tapat no bkect kalses toString funkcija tiks parrakstita
	public String toString() {
		// Piemers, 1: Karina Skirmante (121212-12345)
		String result = studId + ": " + name + " " + surname + " (" + personCode + ")";
		return result;
	}
	
	
	//6. visas parejas funkcijas pec nepieciesamibas
}
