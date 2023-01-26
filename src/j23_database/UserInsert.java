package j23_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.cj.PerConnectionLRUFactory;
import com.mysql.cj.jdbc.JdbcConnection;
import com.mysql.cj.xdevapi.PreparableStatement;

import usermanagement.entity.User;

public class UserInsert {

	private DBConnectionMgr pool;

	public UserInsert() {
		pool = DBConnectionMgr.getInstance();
		// pool은 하나만 있어야함 , 그래서 싱글톤으로 만들어둠, pool이 여러개있으면 소용이 없음 
		// 싱글톤이라 객체를 가져와도 되지만 매번선언하기 귀찮아서 전역으로 빼둠
		//pool을 끊어내는 방법은 close를 사용해야함
		
	}

	public int saveUser(User user) {

		int successCount = 0;

		String sql = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = pool.getConnection();

			sql = "insert into user_mst\r\n" + "values (0, ?, ?, ?, ?)";

			preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getName());
			preparedStatement.setString(4, user.getEmail());

			successCount = preparedStatement.executeUpdate(); // insert, update, delete 명령실행

			resultSet = preparedStatement.getGeneratedKeys(); // 여러개의 키값들을 다 들고 있음
			if (resultSet.next()) {
				System.out.println("이번에 만들어진 usr_id Key값: " + resultSet.getInt(1));
				user.setUserId(resultSet.getInt(1)); // 방금 만든 키값을 유저 아이디 변수에 넣겠다

			}

			System.out.println("쿼리 실행 성공: " + successCount + "건");

		} catch (Exception e) {

			e.printStackTrace();

		}
		return successCount;
	}

	public int saveRoles(Map<String, Object> map) {
		int successCount = 0;

		String sql = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		// 권한을 부여하겠다는 로직 
		try {
			connection = pool.getConnection();
			
			//pool은 데이터 저장소, 동시에 접속할 수 있는 인원을 제한하는 저장소 = 수심이 100m이상인 수영장
			// 트래픽이 이것을 관리 = 튜브 대여소 , 수심이 깊으니 튜브를 대여해야만 들어갈수 있음 
			// 스레드는 양쪽이 같아질수 있도록 동기화하는 작업
			// A가 다 쓰고 반납을 해줘야지 B가 쓸수 있음 , 반납을 하지 않고 동시에 값을 가져갈 경우 데드락이 걸리면서 프로그램이 멈춤
			// 이때 락을 걸어야하는데 락이 들어가 있는 것이 vector임
			// 백터는 동기화 작업이 기본적으로 들어가있음
			// vector와 arraylist는 99% 똑같음
			// 백터에는 remove가 있음 이것은 튜브를 반납하는 행위와 유사함 
			// 프리커넥션은 3개의 객체(?, ?, ?)를 소멸 시켜 백터에서 공간을 확보함, remove하는 행위
			// remove를 하지않으면 과부하가 걸리면서 서버가 닫혀버림
			
			List<Integer> roles = (List<Integer>) map.get("roles");
			// 다운 캐스팅을 해야함 
			//왜...?
			
			User user = (User) map.get("user");
			// 맵을 사용하면 키값이 명확함 

			sql = "insert into role_dtl values";

			// 리스트의 사이즈만큼 반복 , insert하기 위해서, 쿼리문을 완성
			// 쿼리문의 양식이 완성되어야지 prepareStatement에 주어야함 
			for (int i = 0; i < roles.size(); i++) {
				sql += "(0, ?, ?) ";
				if (i < roles.size() - 1) {
					sql += ',';

				}
			}

			preparedStatement = connection.prepareStatement(sql);

			for (int i = 0; i < roles.size(); i++) {
				// (1, 2), (3,4),(5,6) 이런식으로 데이터가 들어가야함 
				preparedStatement.setInt((i * 2) + 1, roles.get(i));
				preparedStatement.setInt((i * 2) + 2, user.getUserId());
			}

			successCount = preparedStatement.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return successCount;

	}

	public static void main(String[] args) {

		UserInsert userInsert = new UserInsert();

		User user = User.builder().username("fff").password("1234").name("fff").email("fff@gmail.com").build();

		int successCount = userInsert.saveUser(user);

		System.out.println("쿼리 실행 성공: " + successCount + "건");
		System.out.println(user); // 주소를 참조하는 것이니 return이랑은 상관없음 
		/* ================================================================ */
// << 반복문과 list를 사용하여 만든 방법>>//
// 유저의 여러권한이 주어질수 있어서 saveroles는  반복문을 통해서 값을 대입한다
		List<Integer> roleIdList = new ArrayList<>();

		roleIdList.add(2);
		roleIdList.add(3);
		Map<String, Object> map = new HashMap<>();
		map.put("user", user); 
		map.put("roles", roleIdList);

		successCount = userInsert.saveRoles(map);
		System.out.println(map);
		System.out.println("쿼리 실행 성공: " + successCount + "건");
		
		// 리스트는 삭제하고, 옮기고 하다보면 섞여서 내가원하는 값을 도출하기 어려움 
		// 순서대로 반복을 돌려 꺼내야 할때 리스트를 사용
		// 맵은 반복을위해서는 안씀, 임시객체 
		// 해당 키값으로 바로 조회하고 싶을 때 맵을 사용 ex. 유저를 사용하고 싶어서 바로 유저를 조회하고 싶을 때
		// 맵에서 리스트 작성한것을 들고옴
	}
}
