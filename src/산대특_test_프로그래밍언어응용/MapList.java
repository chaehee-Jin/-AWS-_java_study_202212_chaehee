package 산대특_test_프로그래밍언어응용;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import j19_컬렉션.Student;

public class MapList {

	public static void main(String[] args) {

		List<Map<String, Object>> customers = new ArrayList<Map<String, Object>>();
		Map<String, Object> customer1 = new HashMap<String, Object>();
		customer1.put("name", "홍길동");
		customer1.put("rating", "Vip");
		customer1.put("age", 30);

		customers.add(customer1);

		Map<String, Object> customer2 = new HashMap<String, Object>();
		customer2.put("name", "김기영");
		customer2.put("rating", "Gold");
		customer2.put("age", 35);

		customers.add(customer2);
		for (Map<String, Object> customer : customers) {
			for (Map.Entry<String, Object> entry : customer.entrySet()) {
				System.out.println(entry);

			}

		}

	}
}

//		List<customer> list = new ArrayList<>();
//		list.add(new customer(30, "홍길동", "Vip"));
//		list.add(new customer(35, "김기영", "Gold"));
//		List<Map<String, String>> customers = new ArrayList<Map<String, String>>();
//		
//		for(Map<String, String> customer : customers) {
//			
//		}
//
//	}

//			if(customer.getName().equals(searchName))

//				boolean flag = true;
//		for (int i = 0; i < students.size(); i++) {
//			Student student = students.get(i);
//			if (student.getName().equals(searchName)) {
//				student.setYear(4);
//				flag = false;
//				break;

//}
