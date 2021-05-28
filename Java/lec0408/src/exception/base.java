package exception;

public class base {
	
	
	
	void exbase() {
		
		int i = 0;
		int j = 0;
		
		try {
			System.out.println("Div : " + (i/j));
		} catch (Exception e) {
			System.out.println("유효하지 않은 입력입니다.");
		} 
		
	}
}
