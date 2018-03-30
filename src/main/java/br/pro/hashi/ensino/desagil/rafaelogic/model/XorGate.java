package br.pro.hashi.ensino.desagil.rafaelogic.model;

public class XorGate {
	private NandGate nand1 = new NandGate();
	private NandGate nand2 = new NandGate();
	private NandGate nand3 = new NandGate();
	private NandGate nand4 = new NandGate();
	
	
	public void connect(int pinIndex, Emitter emitter) {
		nand1.connect(0, emitter);
		nand1.connect(1, emitter);
		
		
		nand2.connect(0, emitter);
		nand2.connect(1, nand1);
		
		nand3.connect(0, nand1);
		nand3.connect(1, emitter);
		
		nand4.connect(0, nand2);
		nand4.connect(1, nand3);
	}
	
	public boolean read(){
		return nand4.read();
	}
}
