package com.javalet.base;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Base base = new Base(sc);
		Exersise ex = new Exersise(sc);
		Exersise_re ex_re = new Exersise_re(sc);
		
		ex.exercise_4();
		
	}
}

class Exersise_re{
	Scanner sc;
	
	Exersise_re(Scanner sc){
		this.sc = sc;
	}

	void exersise_1_1(){
		String[] names = {"James", "Cathy", "Kenny", "Martin", "Crystal"};
		int[] height = new int[names.length];
		int heightestIndex = 0;
		int smallestIndex = 0;
		int tot = 0;
		
		for (int i = 0; i < names.length; i++) {
			System.out.print(names[i] + "의 신장을 입력하세요!");
			int input = sc.nextInt();
			height[i] = input;
			tot += input;
		}
		
		for (int i = 1; i < height.length; i++) {
			if (height[heightestIndex] < height[i]) {
				heightestIndex = i;
			} else if (height[smallestIndex] > height[i]) {
				smallestIndex = i;
			}
		}
		
		System.out.println("평균신장 : " + tot / names.length * 1.0 );
		
		System.out.println("가장 큰 학생은 " + names[heightestIndex]+ 
				"이고 그 학생의 키는 " + height[heightestIndex]);
		
		System.out.println("가장 작 학생은 " + names[smallestIndex]+ 
				"이고 그 학생의 키는 " + height[smallestIndex]);
		
	}
}

class Exersise{
	Scanner sc;
	static int tot = 0;
	
	Exersise(Scanner sc){
		this.sc = sc;
	}
	
	void exercise_4() {
		String[] obj = {"Korean", "English", "Mathematics"};
		String[] students = {"no1", "no2", "no3", "no4"};
		int[][] score = new int[students.length][obj.length + 2];
		
		for (int i = 0; i < obj.length; i++) {
			System.out.println(obj[i] + "의 성적을 입력");
			for (int j = 0; j < students.length; j++) {
				System.out.print(students[j] + "의 성적은 :");
				score[j][i] = sc.nextInt();
			}
		}
		
		for (int i = 0; i < students.length; i++) {
			int sum = 0;
			for (int j = 0; j < score[i].length; j++) {
				if(j == score[i].length - 2) {
					score[i][j] = sum;
					continue;
				}else if( j == score[i].length - 1) {
					score[i][j] = sum / obj.length;
				}
				sum += score[i][j];
			}
		}
		
		for (String s : obj)
			System.out.print("\t" + s + "\t");
		System.out.print("Total\t\tAverage");
		for (int i = 0; i < score.length; i++) {
			System.out.printf("\n%s\t", students[i]);
			for (int j = 0; j < score[i].length; j++) {
				System.out.printf("%3d\t\t", score[i][j]);
			}
		}
		
		
	}
	
	//사용자가 입력한만큼의 숫자를 받아 최대값가 최대값이 몇번째로 입력되었는지 출력합니다.
	void exercise_3() {
		int inputCount = 0;
		int[] numArr;
		int maxNum = 0;
		int maxIndex = 0;
		
		System.out.print("입력할 숫자의 갯수?(100개 미만):");
		inputCount = sc.nextInt();
		numArr = new int[inputCount];
		
		System.out.println(inputCount + "개의 숫자를 입력하세요!");
		for (int i = 0; i < numArr.length; i++) {
			numArr[i] = sc.nextInt();
			if (numArr[i] > maxNum) {
				maxNum = numArr[i];
				maxIndex = i;
			}
		}
		
		System.out.println("입력한 숫자중 최대값은 " + maxNum +" 이고 "
				+ (maxIndex + 1) + "번째 값 입니다.");
	}
	
	//10^0~ 10^10까지의 제승을 출력하라 단, 가지런하게!
	void exersise_2() {
		for (int i = 0; i < 11; i++) {
			double pow = Math.pow(10, i);
			System.out.println("10^" + String.format("%2d", i) + 
					" = " + String.format("%11.0f", pow));
		}
	}
	
	void exersise_1() {
		String[] names = {"James", "Cathy", "Kenny", "Martin", "Crystal"};
		int[] height;
		int heightest;
		int heightestIndex;
		int smallest;
		int smallestIndex;
		
		
		height = inputHeight(names);
		heightestIndex = findHeightest(height);
		smallestIndex = findSmallest(height);
		
		System.out.println("평균신장 : " + tot / names.length * 1.0 );
		
		System.out.println("가장 큰 학생은 " + names[heightestIndex]+ 
				"이고 그 학생의 키는 " + height[heightestIndex]);
		
		System.out.println("가장 작 학생은 " + names[smallestIndex]+ 
				"이고 그 학생의 키는 " + height[smallestIndex]);
	}
	
	int findSmallest(int[] height) {
		int smallest = height[0];
		int smallestIndex = 0;
		
		for (int i = 1; i < height.length; i++) {
			if (height[i] < smallest) {
				smallest = height[i];
				smallestIndex = i;
			}
		}
		return smallestIndex;
	}
	
	int findHeightest(int[] height) {
		int heightest = 0;
		int heightestIndex = 0;
		
		for (int i = 0; i < height.length; i++) {
			if (height[i] > heightest) {
				heightest = height[i];
				heightestIndex = i;
			}
		}
		return heightestIndex;
	}
	
	int[] inputHeight(String[] names) {
		int length = names.length;
		int[] height = new int[length];
		
		for (int i = 0; i < length; i++) {
			System.out.print(names[i] + "의 신장을 입력하세요!");
			int input = sc.nextInt();
			height[i] = input;
			tot += input;
		}
		return height;
	}
}

class Base{
	
	Scanner sc;
	
	Base(Scanner sc){
		this.sc = sc;
	}
	
	//call by reference, call by data. 
	void lec_3() {
		int[] arr1 = {10, 20, 30, 40, 50};
		int[] arr2;
		int[] arr3;
		
		//call by reference
		arr2 = arr1;
		//arr2 값 변경
		changeArr(arr2, 100);
		
		//call by data
		arr3 = new int[5];
		for (int i = 0; i < arr1.length; i++) {
			arr3[i] = arr1[i];
		}
		//arr3 값 변경
		changeArr(arr3, 1000);
		
		//출력
		System.out.println("arr1    arr2");
		System.out.println("--------------");
		printArr(arr1, arr2);
		System.out.println("==============");
		System.out.println("arr1    arr3");
		System.out.println("--------------");
		printArr(arr1, arr3);
	}
	
	void changeArr(int[] arr, int num) {
		int temp = num;
		for (int i = 0; i < arr.length; i ++) {
			temp += 100;
			arr[i] = temp;
		}
	}
	
	void printArr(int[] arr1, int[] arr2) {
		for (int i = 0; i<arr1.length; i++) {
			System.out.println(arr1[i] + "\t" + arr2[i]);
		}
	}
	
	//사용자로부터 입력받은 숫자로 합계, 평균을 구해 출력한다.
	void lec_2() {
		//선언
		int[] arr = new int[5];
		int sum = 0;
		double mean = 0;
		
		System.out.println("계산할 숫자 "  + arr.length + "개를 넣으세요");
		//입력
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		//합계
		for (int i : arr) {
			sum += i;
		}
		//평균
		mean = sum / arr.length;
		
		//출력
		System.out.println("-----------------------------------");
		System.out.println("당신이 입력한 숫자는 다음과 같습니다.");
		for (int i : arr) {
			System.out.print(i + "\t");
		}
		System.out.println("\n----------------------------------");
		System.out.println("입력한 숫자의 총 합은 " +sum + 
				"이고 평균은 " + String.format("%.3f",mean) + "입니다.");
		
	}
	
	void lec_1() {
		String[] str = new String[7];
		
		str[0] = "일요일";
		str[1] = "월요일";
		str[2] = "화요일";
		str[3] = "수요일";
		str[4] = "목요일";
		str[5] = "금요일";
		str[6] = "토요일";
		
		for (String i : str) {
			System.out.println(i);
		}
	}
}