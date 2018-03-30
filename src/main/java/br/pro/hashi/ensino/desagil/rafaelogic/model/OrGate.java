package br.pro.hashi.ensino.desagil.rafaelogic.model;

public class OrGate extends Gate {
	private NandGate nand1 = new NandGate();
	private NandGate nand2 = new NandGate();
	private NandGate nandout = new NandGate();

	public OrGate(){
		nandout.connect(0, nand1);
		nandout.connect(1, nand2);
	}

	public void connect(int pinIndex, Emitter emitter) {
		if(pinIndex==0){
			nand1.connect(0, emitter);
			nand1.connect(1, emitter);
		}
		else if(pinIndex ==1){
			nand2.connect(0, emitter);
			nand2.connect(1, emitter);
		}
		else{
		}
		
		
	}
	@Override
	public boolean read() {
		return nandout.read();
	}
	
}
