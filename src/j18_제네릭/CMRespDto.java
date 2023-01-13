package j18_제네릭;

//Commit Message Response Data Transfer Object

//클라이언트가 서버에서 요청을 날리면 동일한 형식으로 응답해주는 응답인터페이스
public class CMRespDto<T> {

	private String messge;
	private int code;
	private T data;

	public CMRespDto(int code, String messge, T data) {
		super();
		this.messge = messge;
		this.code = code;
		this.data = data;

	}

	@Override
	public String toString() {
		return "CMResDto [messge=" + messge + ", code=" + code + ", data=" + data + "]";
	}

}
