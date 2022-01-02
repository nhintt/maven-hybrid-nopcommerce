package utilities;

import com.github.javafaker.Faker;

public class DataUtil {
	private Faker faker;

	public static DataUtil getData() {
		return new DataUtil();
	}

	public DataUtil() {
		faker = new Faker();
	}

	public String getFirstName() {
		return faker.name().firstName();
	}

	public String getLastName() {
		return faker.name().lastName();
	}

	public String getUserName() {
		return faker.name().username();
	}

	public String getPassword() {
		return faker.internet().password();
	}
	
	public String getEmailAddress() {
		return faker.internet().emailAddress();
	}
	
	public String getAddress() {
		return faker.address().buildingNumber() + faker.address().streetName();
	}
	
	public String getCityName() {
		return faker.address().cityName();
	}
	
	public String getZipcode() {
		return faker.address().zipCode();
	}
	
	public String getPhoneNumber() {
		return faker.phoneNumber().cellPhone();
	}
}
