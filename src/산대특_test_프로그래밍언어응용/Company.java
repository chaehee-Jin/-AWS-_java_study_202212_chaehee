package 산대특_test_프로그래밍언어응용;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import lombok.AllArgsConstructor;

@AllArgsConstructor

class Company {

	private int companyId;

	private String companyName;

	private String address;

	private String city;

	private String state;

	private String zipCode;

}

class CompanyMain {

	public static void main(String[] args) {

		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		Company company = new Company(100, "Apple", "Apple Computer Inc. 1 infinite Loop", "Cupertino", "CA", "95014");

		System.out.println(gson.toJson(company));

	}
}

//		String   company =  "{\"companyId\" : 100", "
//		  +  "\"companyName\" : "\Apple\","
//		  +"\address\" : "\Apple Computer Inc. 1 infinite Loop\","
//		  +"\city\" : "\Conpertino\" ,"
//		  +"\state\" : "\CA\","
//		  +"\zipCode\" : "95014"
//		  +"}"
//		  +"};"
