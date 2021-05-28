

import java.util.Scanner;

import com.javalec.abstractLec_ex.Child1;
import com.javalec.abstractLec_ex.Child2;
import com.javalec.abstractLec_ex.Child3;
import com.javalec.abstractLec_ex.Lunch;
import com.javalec.abstractLec_ex.Price;
import com.javalec.ingeritance2.Shop1;
import com.javalec.ingeritance2.Shop2;
import com.javalec.ingeritance2.Shop3;
import com.javalec.ingeritance2.StoreHQ;
import com.javalec.inheritance.DmbCellPhone;
import com.javalec.inheritance.ex2.ThrowsClass;
import com.javalec.staticLec.FirstSon;
import com.javalec.staticLec.SecondSon;

public class Main {
	
	public static void main(String[] args) {
		runClass rc = new runClass();
		rc.abstract_base();
	}

}

class runClass{
	Scanner sc = new Scanner(System.in);
	
	void abstract_base() {
		Lunch c1 = new Child1(Price.RICE, Price.BULGOGI, Price.BANANA, 
				Price.MILK, Price.ALMOND);
		Lunch c2 = new Child2(Price.RICE, Price.BULGOGI, Price.BANANA, 
				Price.MILK, Price.ALMOND);
		Lunch c3 = new Child3(Price.RICE, Price.BULGOGI, Price.BANANA, 
				Price.MILK, Price.ALMOND);
		
		System.out.println("학생1의 식대는 : " + c1.calc());
		System.out.println("학생2의 식대는 : " + c2.calc());
		System.out.println("학생3의 식대는 : " + c3.calc());
		
	}
	
	void static_base() {
		FirstSon fs = new FirstSon();
		SecondSon ss = new SecondSon();
		
		fs.takeChoco();
		ss.takeChoco();
	}
	
	void exception_base() {
		ThrowsClass tc = new ThrowsClass();
	}
	
	void ex_1() {
		StoreHQ hq = new StoreHQ();
		StoreHQ s1 = new Shop1();
		StoreHQ s2 = new Shop2();
		StoreHQ s3 = new Shop3();
		
		hq.print();
		s1.print();
		s2.print();
		s3.print();
		
		//or
		StoreHQ[] arr = {new StoreHQ(), new Shop1(), new Shop2(), new Shop3()};
		
		
	}
	
	void base_1() {
		DmbCellPhone dcp = new DmbCellPhone("자바폰", "색상", 10);
		System.out.println("모델 : " + dcp.model);
		System.out.println("색상 : " + dcp.color);
		System.out.println("채널 : " + dcp.channel);
		dcp.powerOn();
		dcp.bell();
		dcp.sendVoice("여보세요");
		dcp.receiveVoice("안녕하세요! 저는 홍길동인데요");
		dcp.sendVoice("아! 반갑습니다. 그럼 안녕히~~~");
		dcp.turnOnDmb();
		dcp.changeChannelDmb(12);
		dcp.turnOffDmb();
	}
}