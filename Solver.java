public class Solver {

	public CSP backtrack(CSP c) {
		if (Assignment.isComplete(c)) {
			return c;
		}

		// check if each var has a assignment
		// if does not have assignment, set index to it
		int index = 0;
		for (int i = 0; i < c.var.length; i++) {
			if (c.var[i].assign == null) {
				index = i;
				break;
			}
		}

		// set value to the var's domain when the assignment is consistent
		for (String values : c.var[index].dm) {
			if (Assignment.Consistent(c, index, values)) {
				c.var[index].assign = values;
				CSP result = backtrack(c);
				if (result != null) {
					return result;
				}
			}
		}

		return null;

	}

	public CSP backtrackQ(CSP c) {
		if (Assignment.isQueenComplete(c)) {
			return c;
		}
		
		int exception1 = -10;
		int exception2 = -10;

		// check if each var has a assignment
		// if does not have assignment, set index to it
		int index = 0;
		for (int i = 0; i < c.variables.size(); i++) {
			if (c.variables.get(i).row == -1) {
				index = i;
				exception1 = c.variables.get(index).row;
				exception2 = Math.abs(c.variables.get(index).row - c.variables.get(index).col);

				break;
			}
		}

		//for the future unassigned variables
		for(int i = index + 1; i < c.variables.size(); i++) {
			if(c.variables.get(i).dmj.contains(exception1)) {
				c.variables.get(i).dmj.remove(exception1);
			}
			for(int num = 0; num < c.variables.get(i).dmj.size(); num++) {
				if(Math.abs(c.variables.get(i).row - c.variables.get(i).col) == exception2) {
					c.variables.get(i).dmj.remove(c.variables.get(i).row);
				}
			}
		}
		
		// set value to the var's domain when the assignment is consistent
		for (Integer number : c.variables.get(index).dmj) {
			
			if (Assignment.ConsistentQueen(c, index, number)) {
				c.variables.get(index).row = number;
				CSP result = backtrackQ(c);
				if (result != null) {
					return result;
				}
			}
		}

		return null;
	}

	public CSP backtrack(CSP c, int value) {
		if (Assignment.isComplete(c, 0)) {
			return c;
		}
		int index = 0;
		for (int i = 0; i < c.var.length; i++) {
			if (c.var[i].value == 0) {
				index = i;
				break;
			}
		}

		for (Integer values : c.var[index].dmj) {

			if (Assignment.Consistent(c, index, values)) {

				c.var[index].value = values;
				CSP result = backtrack(c, 0);
				if (result != null) {
					return result;
				}
			}
		}
		return null;

	}

}
