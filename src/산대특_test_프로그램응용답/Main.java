package 산대특_test_프로그램응용답;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import lombok.AllArgsConstructor;

@AllArgsConstructor
class Product1 {

	private int serialNumber;
	private String productType;
	private String productName;
	private int price;




	}

public class Main {
	
	public static void main(String[] args) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		Product1 product = new Product1(2001, "laptop", "Samsung GalaxyBook", 1400000);
		System.out.println(gson.toJson(product));
		
	}
 
}
