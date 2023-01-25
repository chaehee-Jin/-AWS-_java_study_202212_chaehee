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
				user.setUserId(resultSet.getInt(1));

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

		try {
			connection = pool.getConnection();
			List<Integer> roles = (List<Integer>) map.get("roles");
			User user = (User) map.get("user");

			sql = "insert into role_dtl values";

			for (int i = 0; i < roles.size(); i++) {
				sql += "(0, ?, ?) ";
				if (i < roles.size() - 1) {
					sql += ',';

				}
			}

			preparedStatement = connection.prepareStatement(sql);

			for (int i = 0; i < roles.size(); i++) {
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
		System.out.println(user);
		/* ================================================================ */

		List<Integer> roleIdList = new ArrayList<>();

		roleIdList.add(2);
		roleIdList.add(3);
		Map<String, Object> map = new HashMap<>();
		map.put("user", user);
		map.put("roles", roleIdList);

		successCount = userInsert.saveRoles(map);
		System.out.println(map);
		System.out.println("쿼리 실행 성공: " + successCount + "건");
	}
}
