package j19_컬렉션.복습;

import java.util.HashMap;
import java.util.Map;

public class SearchData {

	public static void main(String[] args) {

		Map<String, String> searchData = new HashMap<>();
		
		searchData.put("category", "소설");
		searchData.put("searchValue", "불편한 편의점");
		
		System.out.println(searchData);
		
		System.out.println(searchData.get("category"));
		System.out.println(searchData.get("searchValue"));
		
		// 키값만 뽑을 수 있음 
		System.out.println(searchData.keySet());
		// value만 뽑을 수 있음 
		System.out.println(searchData.values());
		// 키와 벨류 둘다 뽑을 수 있음 
		System.out.println(searchData.entrySet());
		
//		for(int i=0; i< searchData.size(); i++) {
//			System.out.println(searchData.get(null));
//		}
		
		for(String key: searchData.keySet()) {
			System.out.println(searchData.get(key));
			
		}
		
		

	}

}
