package br.pro.hashi.ensino.desagil.rafaelogic.model;

public class AndGate {
	private NotGate not = new NotGate();
	private NandGate nand = new NandGate();
	
	public void connect(int pinIndex, Emitter emitter) {
		nand.connect(pinIndex, emitter);
		not.connect(pinIndex, nand);
	}
	
	public boolean read(){
		return not.read();
	}
	
}
