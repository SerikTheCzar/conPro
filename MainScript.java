/*
/ MainScript created by Jonathan Gerraughty
*/

import java.util.Random;

public class MainScript {

	// Initialize Instruction Queue
	public Queue<Instruction> instructionQueue = new Queue<Instruction>(10);
	
	// Created pseudo instructions, loosely based after Brainfuck language
	public String[] instructions = {"<<", ">>", "++", "--", "/", "*"};
	
	public boolean stopInstructions = false;
	
	public MainScript() {
		//Add some random cycle rates
		Random rng = new Random();
		
		int pc = 0;
		
		while(true) {
			//Halting condition
			if(stopInstructions == false && !instructionQueue.isFull()) {
				String testInst = instructions[rng.nextInt(instructions.length)];
				instructionQueue.Add(new InstructionScript(testInst, rng.nextInt(8)));
			} else if(instructionQueue.isFull()) {
				stopInstructions = true;
			}
			
			//Get the current instruction, and cycle it
			Instruction p = instructionQueue.Get();
			System.out.println(p.toString());
			p.Cycle();
			
			//If the PCCount is below 0, then it can leave the Queue
			if(p.PCCount < 0) {
				instructionQueue.Remove();
			}
			
			//Exit the loop if there are no more instructions
			if(instructionQueue.isEmpty()) {
				break;
			}
			
			//Program counter, how many times do we have to run a program count?
			pc++;
			
			//Threading interrupts, using 1/10th of a second for visibiltiy
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("Program Count: " + pc);
	}
	
	public static void main(String[] args) {
		new MainScript();
	}

}
