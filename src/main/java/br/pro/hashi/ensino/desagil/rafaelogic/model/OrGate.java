package br.pro.hashi.ensino.desagil.rafaelogic.model;

public class OrGate extends Gate {
	private NandGate nand1 = new NandGate();
	private NandGate nand2 = new NandGate();
	private NandGate nandout = new NandGate();


	@Override
	public void connect(int pinIndex, Emitter emitter) {
		nand1.connect(pinIndex, emitter);
		nand2.connect(pinIndex, nand1);
		
		nandout.connect(0, nand1);
		nandout.connect(1, nand2);
	}
	@Override
	public boolean read() {
		return nandout.read();
	}
	
}