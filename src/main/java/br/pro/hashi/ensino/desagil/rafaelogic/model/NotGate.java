package br.pro.hashi.ensino.desagil.rafaelogic.model;

public class NotGate extends Gate {
	public NotGate() {
		super(1, "NOT");
	}

	// Importa e cria uma variavel do tipo NandGate chanamemada nand
	private NandGate nand = new NandGate();
	
	@Override
	public void connect(int pinIndex, Emitter emitter) {
		nand.connect(0, emitter);
		nand.connect(1, emitter);
	}

	@Override
	public boolean read() {
		return nand.read();
	}
}
