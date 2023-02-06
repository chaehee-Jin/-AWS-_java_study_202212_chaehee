package usermanagement.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;

import j23_database.DBConnectionMgr;
import usermanagement.entity.RoleDtl;
import usermanagement.entity.RoleMst;
import usermanagement.entity.User;

/*
 * UserDao
 */
public class UserRepository {
	private static UserRepository instance;

	public static UserRepository getInstance() {

		if (instance == null) {
			instance = new UserRepository();

		}
		return instance;

	}

	private DBConnectionMgr pool;

	private UserRepository() {
		pool = DBConnectionMgr.getInstance();
	}

	public int saveUser(User user) {
		int successCount = 0;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = pool.getConnection(); //객체를 가지고 와야한다
			// 객체를 가지고 온후 담아야함 , 쿼리문 필요
			String sql = "insert into user_mst values(0, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getEmail());
			// 자료형에 따라서 set이 정해진다
			// userId는 아직까지 값이 0인 상태 , saveUser을 하면 그뒤부터 값이 들어가면서 사용가능

			successCount = pstmt.executeUpdate();
			// 몇건이 성공했는지 

			// 권한등록을 해주어야함
			rs = pstmt.getGeneratedKeys(); //키값을 바로 알수 없으니 getGeneratedKey를 사용
			if (rs.next()) {
				user.setUserId(rs.getInt(1));
				// 제너레이트에서 가져온 키값을 set해라
			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs); // 3가지를 다 사용했으니 반환 
		}

		return successCount;
	}

	public int saveRoleDtl(RoleDtl roleDtl) {
		int successCount = 0;

		Connection con = null;
		PreparedStatement pstmt = null;
		

		try {
			con = pool.getConnection();
			String sql = "insert into role_dtl values(0, ?, ?) ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, roleDtl.getRoleId());
			pstmt.setInt(2, roleDtl.getUserId());

			successCount = pstmt.executeUpdate(); // insert 끝

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			pool.freeConnection(con, pstmt);
		}
		return successCount;

	}

	public User findUserByUsername(String username) {

		User user = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = pool.getConnection();
			String sql = "select \r\n" + "um.user_id,\r\n" + "um.username,\r\n" + "um.password,\r\n" + "um.name,\r\n"
					+ "um.email,\r\n" + "rd.role_dtl_id,\r\n" + "rd.role_id,\r\n" + "rd.user_id,\r\n"
					+ "rm.role_id,\r\n" + "rm.role_name\r\n" + "\r\n" + "\r\n" + "from\r\n" + "user_mst um\r\n"
					+ "left outer join role_dtl rd on(rd.user_id = um.user_id)\r\n"
					+ "left outer join role_mst rm on(rm.role_id = rd.role_id)\r\n" + "\r\n" + "where \r\n"
					+ "um.username = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);

			rs = pstmt.executeQuery();

			List<RoleDtl> roleDtls = new ArrayList<>();
			int i = 0;

			while (rs.next()) {
				if (i == 0) {
					user = User.builder().userId(rs.getInt(1)).username(rs.getString(2)).password(rs.getString(3))
							.name(rs.getString(4)).email(rs.getNString(5)).build();

				}
				RoleMst roleMst = RoleMst.builder().roleId(rs.getInt(9)).roleName(rs.getString(10)).build();

				RoleDtl roleDtl = RoleDtl.builder().roleDtlId(rs.getInt(6)).roleId(rs.getInt(7)).userId(rs.getInt(8))
						.roleMst(roleMst).build();

				roleDtls.add(roleDtl);

				i++;
			}
			if (user != null) {
				user.setRoleDtls(roleDtls);
			}

		} catch (Exception e) {
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return user;
	}

	public User findUserByEmail(String email) {

		User user = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = pool.getConnection();
			String sql = "select \r\n" + "um.user_id,\r\n" + "um.username,\r\n" + "um.password,\r\n" + "um.name,\r\n"
					+ "um.email,\r\n" + "rd.role_dtl_id,\r\n" + "rd.role_id,\r\n" + "rd.user_id,\r\n"
					+ "rm.role_id,\r\n" + "rm.role_name\r\n" + "\r\n" + "\r\n" + "from\r\n" + "user_mst um\r\n"
					+ "left outer join role_dtl rd on(rd.user_id = um.user_id)\r\n"
					+ "left outer join role_mst rm on(rm.role_id = rd.role_id)\r\n" + "\r\n" + "where \r\n"
					+ "um.emil = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);

			rs = pstmt.executeQuery();

			List<RoleDtl> roleDtls = new ArrayList<>();
			int i = 0;

			while (rs.next()) {
				if (i == 0) {
					user = User.builder().userId(rs.getInt(1)).username(rs.getString(2)).password(rs.getString(3))
							.name(rs.getString(4)).email(rs.getNString(5)).build();

				}
				RoleMst roleMst = RoleMst.builder().roleId(rs.getInt(9)).roleName(rs.getString(10)).build();

				RoleDtl roleDtl = RoleDtl.builder().roleDtlId(rs.getInt(6)).roleId(rs.getInt(7)).userId(rs.getInt(8))
						.roleMst(roleMst).build();

				roleDtls.add(roleDtl);

				i++;
			}
			if (user != null) {
				user.setRoleDtls(roleDtls);
			}

		} catch (Exception e) {
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return user;
	}

}
