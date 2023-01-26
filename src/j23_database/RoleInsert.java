package j23_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;



public class RoleInsert {
	
	private DBConnectionMgr pool;
	
	public RoleInsert() {
		pool = DBConnectionMgr.getInstance();
		
		
	}
	public int saveRole(String roleName) {
		int successCount = 0;
		
		String sql = null;
		//sql에서 무엇이 들어 올지 모르니 널로 지정
		Connection con = null;
		// 자바와 디비를 연결하기 위한 객체생성 
		PreparedStatement pstmt = null; // preparedStatement는 복잡한 식을 간단하게 해주는역할 
		// 이 객체(PreparedStatement) 에서만 ?을 사용가능 , 나머지는 값을 넣어야함 
		ResultSet rs =null;
		
		try {// try ~ catch를 이용해서 예외처리를 함 , 커넥션을 했을 때 연결안될수도 있기 때문에 예외처리
			con = pool.getConnection(); // 가져온 데이터를 저장 , 근데 무슨데이터를 ?? 키값을??? 
			sql =  "insert into role_mst values(0, ?)";
			// 값이 무엇이 들어올지 모르니 ?으로 지정, 후에 ?에 값을 넣어준다 
			pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			// statment. reurn_geenrrated_keys 이게 있어야지 제너레이트 키를 가지고 올수 있음 
			// 커넥션 다음순서, 커넥션이 없으면 안됨
			pstmt.setString(1, roleName);
			// set을 사용하여 첫번째에 문자열이 들어감을 알림 
			//미완성된 sql을 먼저 받고 후에 ?을 채움, 첫번째 물음표에 이값으로 채워라
			
			
			successCount = pstmt.executeUpdate(); // sql문에서 수정(update, delete,insert) 을 하니 executeUpdate을 사용
			//int 반환으로 적용, 물음표에 값을채워주는 역할, 고정해서 사용할 수는 없음
			//serect는 쿼리문을 사용
			int newKey = 0;
			rs = pstmt.getGeneratedKeys(); // 방금 만들어진 키들을 가지고 있음 
			//자동완성된 키값들(value들을 한꺼번에 땅땅땅 가지고 을수 있기때문에) 들고온다
			// resultset은 set이니까 데이터 중복은 이루어질수 없음, rs = .next메소드를 호출하는 것 이것을 호출하면 커서가 내려감, 커서와 비슷한 존재
			// sql을 실행할때 나오는 표와 같음 
			if(rs.next()) { // 커서가 처음에는 아무것도 없는 값에 있는데 넥스트를 해야 열로 들어옴 
				newKey = rs.getInt(1);
				// 1을 넣은이유는 rs의 열의 위치를 지정하기 때문 
				//get은 들고오는 것이니 들고온 값을 List에 넣음
				// 근데 우리가 한 것에는 List가 없는딩..?
				
			}
			
			// 새로운 키값 뽑아내기
			System.out.println(newKey !=0 ? "새로운 키값: " + newKey : "키가 생성되지 않음 ");
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally { // exception에서 반드시 실행되어야하는 경우 
			pool.freeConnection(con, pstmt, rs );
		}
		return successCount;
	
	}
	public static void main(String[] args) {
		RoleInsert roleInsert  =new RoleInsert();
		
		int successCount = roleInsert.saveRole("ROLE_TESTER");
		System.out.println("insert 성공 건수: "+ successCount);
		
		//JDBC는 디비랑 자바를 연결하는 커넥션역할 
	}

}
