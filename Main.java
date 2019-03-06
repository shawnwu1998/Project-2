import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("Please choose your game:");
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.println("1. Australia Map    2.  Job-Shop Scheduling   3. N-Queens ");
			System.out.println("Enter 0 to quit");
			int x = scan.nextInt();
			if(x==1) {
				System.out.println("Australia Map");
				AustraliaCSP map = new AustraliaCSP();
				map.amaptraliaMap(); 	
			}
			if(x==2) {
				System.out.println("Job Shop");
				JobShop job = new JobShop();
				job.jobshop();
			}
			if(x==3){
				System.out.println("N Queens");
				nQueens queen = new nQueens();
				System.out.println("Enter the number of queens (maximum is 8): ");
				int num = scan.nextInt();
				queen.queenPlacement(num);
			}
			if(x==0) {
				break;
			}
		}
	}

}
