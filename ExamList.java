package 객체.ex1.메소드화;

import java.util.Scanner;

public class ExamList {
	private Exam[] exams;   // Exam타입의 exams 배열참조변수 선언( Exam클래스를 이용할 참조배열변수)
	private int current;    
	
	// private
	// private 안쓸때 - ExamList list = new ExamList(); 를 선언후, list.current로 변수의 값을 바꿀 수 있음.
	//							 즉, 캡슐화의 의미가 사라짐.  따라서 private로 데이터를 보호해야함.
	// public
	// 사용자가 쓰도록 원하는 것을 public을 사용함
		// 출력 메서드
		public void printList() {
			printList(current);
		}
		
		// 메서드 오버로딩
		public void printList(int size) {
				System.out.println("┌──────────────────┐");
				System.out.println("│     성적 출력            │");
				System.out.println("└──────────────────┘");
				System.out.println();
				
			
				Exam[] exams = this.exams;
				
				for(int i=0; i<size; i++) {
				Exam exam = exams[i]; 
				int kor = exam.getKor(); // exam.kor;
				int eng = exam.getEng(); // exam.eng;
				int math = exam.getMath(); // exam.math;
				
				int total = exam.total(); 	//.getKor()+exam.getEng()+exam.getMath();
				float avg = exam.avg();	    //total/3.0f;
				
				System.out.printf("국어 %d\n", kor);
				System.out.printf("영어 %d\n", eng);
				System.out.printf("수학 %d\n", math);
			
				System.out.printf("총점 : %3d\n", total);
				System.out.printf("평균 : %6.2f\n", avg);
				System.out.println("────────────────────────");
				}
		}

		  // 입력 메서드
		public void inputList() {
			Scanner scan = new Scanner(System.in);
			System.out.println("┌──────────────────┐");
			System.out.println("│     성적 입력            │");
			System.out.println("└──────────────────┘");
			System.out.println();
			
			
			int kor, eng, math;
			
			do 
			{
				System.out.printf("국어: ");
				kor = scan.nextInt();
				
				if(kor < 0 || 100 < kor)
				{
					System.out.println("국어성적은 0~100까지의 범위만 입력이 가능합니다.");
				}
			}while(kor<0 || 100 < kor);
			
			do 
			{
				System.out.printf("영어: ");
				eng = scan.nextInt();
				
				if(eng < 0 || 100 < eng)
				{
					System.out.println("영어성적은 0~100까지의 범위만 입력이 가능합니다.");
				}
			}while(eng<0 || 100 < eng);
			
			do 
			{
				System.out.printf("수학: ");
				math = scan.nextInt();
				
				if(math < 0 || 100 < math)
				{
					System.out.println("수학성적은 0~100까지의 범위만 입력이 가능합니다.");
				}
			}while(math<0 || 100 < math);
			
			//Exam exam = new Exam(); //지역적인 exam클래스 변수 선언후에 국,영,수 성적 집어넣기
			//exam.setKor(kor);  	     	// exam.kor =  kor;
			//exam.setEng(eng);    		// exam.eng =  eng;
			//exam.setMath(math);    // exam.math =  math;
			Exam exam = new Exam(kor, eng,math);
			
			Exam[] exams = this.exams;
			int size = this.current;
			
			
			if(exams.length == size) {
				// 1. 크기가 5개 정도 더 큰 새로운 배열을 생성
				Exam[] temp = new Exam[size + 5];
				// 2. 값을 이주시키기
				for(int i=0; i<size; i++) {
					temp[i] = exams[i];
				}
				this.exams  = temp;
			}
			System.out.println("현재 길이" + this.exams.length);
			
			this.exams[current] = exam;   // 국영수가 들어있는 배열을 참조하도록 변경
			current++;  
			
		}
		  
		
		// 변수값 초기화 함수
		// 문제점 - 아무때나 계속 호출이 가능하다.
		
		//생성자의 조건
		// 1. 객체가 생성되자마자 무조건 제일 먼저 실행되어야만 한다.
		// 2. 생성될 때 단 한번만 실행되어야만 한다.
		
		//생성자가 없으면 
		//		privateExam[] exams = *null*
		//     private int current = *0*         으로 컴파일러가 자동으로 생성해줌.
		
		public ExamList() {  
			//exams = new Exam[3];        
			//current = 0;
			this(3);
		}
		
		// 생성자 오버로드
		//주의할 점: ExamList()가 없으면 program.java에서 ExamList list = new ExamList(); 호출시 오류
		public ExamList(int size) {  
			exams = new Exam[size];        
			current = 0;
		}
}
