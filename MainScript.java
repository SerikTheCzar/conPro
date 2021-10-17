/*
/ MainScript created by Jonathan Gerraughty
*/

import java.util.Random;

public class MainScript {

	public Queue<Instruction> instructionQueue = new Queue<Instruction>();
	
	public String[] instructions = {"<<", ">>", "++", "--", "/", "*"};
	
	public boolean stopInstructions = false;
	
	public MainScript() {
		Random rng = new Random();
    //Begin cycle
		while(true) {
      //Halt adding instructions?
			if(stopInstructions == false) {
				String testInst = instructions[rng.nextInt(instructions.length)];
				instructionQueue.Add(new Instruction(testInst, rng.nextInt(8)));
			} else if(instructionQueue.isFull()) {
				stopInstructions = true;
			}
			
      //Get synchronization
			Instruction p = instructionQueue.Get();
			System.out.println(p.toString());
			p.Cycle();
			
      //Check if can remove from queue
			if(p.PCCount <= 0) {
				instructionQueue.Remove();
			}
      
      //Threading halt, using 1/10th of a second for visibility
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new MainScript();
	}

}
