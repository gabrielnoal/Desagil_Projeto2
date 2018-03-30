package br.pro.hashi.ensino.desagil.rafaelogic.model;

public class XorGate extends Gate{
	private NandGate nand1 = new NandGate();
	private NandGate nand2 = new NandGate();
	private NandGate nand3 = new NandGate();
	private NandGate nand4 = new NandGate();
	
	public XorGate(){
		nand2.connect(1, nand1);
		nand3.connect(1,nand1);
		nand4.connect(0, nand2);
		nand4.connect(1,nand3);
	}
	
	@Override
	public void connect(int pinIndex, Emitter emitter) {
		nand1.connect(pinIndex, emitter);
		
		if(pinIndex==0){
			nand2.connect(0,emitter);
		}
		else if (pinIndex==1){
			nand3.connect(0,emitter);
		}
		else{
			
		}
	}
	@Override 
	public boolean read(){
		return nand4.read();
	}
}
