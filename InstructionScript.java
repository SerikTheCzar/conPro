//InstructionScript
/*
/ Created by: Jonathan Gerraughty
*/


public class InstructionScript {

	public String name = "";
	public int PCCount = 0;
	
	//Cycle lowers PCCount by 1,
	public void Cycle() {
		PCCount --;
	}
	
	public InstructionScript(String name, int PCCount) {
		this.name = name;
		this.PCCount = PCCount;
	}
	
	public String toString() {
		return name + ": " + PCCount;
	}
	
}
