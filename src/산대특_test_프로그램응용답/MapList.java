package 산대특_test_프로그램응용답;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapList {

	public static void main(String[] args) {
		List<String> color = new ArrayList<>();
		color.add("red");
		color.add("green");
		color.add("bule");

		List<String> sizes = new ArrayList<>();
		sizes.add("SS");
		sizes.add("S");
		sizes.add("M");
		sizes.add("L");
		sizes.add("XL");

		Map<String, List<String>> options = new HashMap<>();
		options.put("색상", color);
		options.put("사이즈", sizes);

		for (Map.Entry<String, List<String>> entry : options.entrySet()) {
			System.out.println(entry);

		}

	}

}
