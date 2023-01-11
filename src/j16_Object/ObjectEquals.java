package j16_Object;

public class ObjectEquals {

	public static void main(String[] args) {

		String name1 = "김준일";
		String name2 = "김준일";
		String name3 = new String("김준일");

		System.out.println(name1);
		System.out.println(name2);

		System.out.println(name1 == name2);
		System.out.println(name1.equals(name3));

		Student s1 = new Student("박은빈", 24);
		Student s2 = new Student("박은빈", 24);
		SubStudent s3 = new SubStudent("박은빈", 24);

		System.out.println(s1.equals(s3));
		
		

	}

}
