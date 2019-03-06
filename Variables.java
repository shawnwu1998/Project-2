import java.util.HashSet;

public class Variables {

	public String name;
	public String assign=null;
	public HashSet<String> dm = null;
	public int value=0;
	public HashSet<Integer> dmj=null;
	public int col;
	public int row;
	
	public Variables(String name, String assignment, HashSet<String> domain) {
		this.name=name;
		this.assign=assignment;
		this.dm=domain;
	}
	
	public Variables(String name, int value, HashSet<Integer> domain) {
		this.name=name;
		this.value=0;
		this.dmj=domain;
	}
	
	//Variables for nQueens
	public Variables(String name, int col, int row, HashSet<Integer> domain) {
		this.col=col;
		this.row=row;
		this.dmj=domain;
		this.name = name;
	}
}
