package 객체.ex1.메소드화;

import java.util.Scanner;

public class program {

		
	public static void main(String[] args) {
		
		ExamList list = new ExamList();  // Exam[] exams와 current 변수 사용가능.
															 // 생성자 초기화(한번만)
		
		
		int menu;
		boolean keepLoop = true;
		
		while(keepLoop)
		{
			menu = inputMenu();

			switch(menu)
			{
			case 1:
				//ExamList.inputList(list);
				list.inputList(); 
				break;
			case 2:
				//ExamList.printList(list);
				list.printList();
				break;
			case 3:
				System.out.println("Bye~~");
	
				keepLoop = false;
				break;
				
			default:
				System.out.println("잘못된 값을 입력하셨습니다. 메뉴는 1~3까지입니다.");
			}
		}
	}
	
	

	static int inputMenu() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("┌──────────────────┐");
		System.out.println("│     메인 메뉴            │");
		System.out.println("└──────────────────┘");
		System.out.println("\t1. 성적입력 ");
		System.out.println("\t2. 성적출력 ");
		System.out.println("\t3. 종료 ");
		System.out.println("\t선택> ");
		int menu = scan.nextInt();
		
		return menu;
	}

}
