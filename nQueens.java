import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class nQueens {
	
	//constraints: be in different columns
	//be in different rows
	//|row - col| != |row - col|

	static CSP queenCsp = new CSP();
	static ArrayList<Integer> colNum = new ArrayList<Integer>();
	static ArrayList<Variables> variables = new ArrayList<Variables>();
	static Random random = new Random();
	static HashSet<Integer> domain = new HashSet();
	
	public static void queenPlacement(int num) {
		
		for(int i = 0; i < 8; i++) {
			domain.add(i);
		}
		
		for(int i = 0; i < num; i++) {
			//generate a random number from 0-7
			//int x = random.nextInt(8);
			
			//if(!colNum.contains(x)) {
				//colNum.add(x);
				String name = "Q" + i;
				variables.add(new Variables(name, i, -1, domain));
			//}
		}
		
		queenCsp.variables = variables;
		
		Solver solve= new Solver();
		queenCsp = solve.backtrackQ(queenCsp);
		
		System.out.println(queenCsp.variables.size());
		
		for(int i=0; i<queenCsp.variables.size(); i++){//print result
			//Variables current = queenCsp.variables.get(i);
			System.out.println(queenCsp.variables.get(i).name + " has a row of " + queenCsp.variables.get(i).row + " and a column of " + queenCsp.variables.get(i).col);
		}
		
	}
}
