package br.pro.hashi.ensino.desagil.rafaelogic.model;

public class AndGate extends Gate{
	private NotGate not = new NotGate();
	private NandGate nand = new NandGate();
	
	public AndGate() {
		super(2, "AndGate");
	}

	public void connect(int pinIndex, Emitter emitter) {
		nand.connect(pinIndex, emitter);
		not.connect(pinIndex, nand);
	}
	
	public boolean read(){
		return not.read();
	}
	
}
