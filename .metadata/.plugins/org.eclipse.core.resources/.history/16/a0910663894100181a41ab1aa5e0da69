package br.pro.hashi.ensino.desagil.rafaelogic.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import br.pro.hashi.ensino.desagil.rafaelogic.model.Gate;
import br.pro.hashi.ensino.desagil.rafaelogic.model.Source;

//A classe JPanel representa um painel da interface gráfica,
//onde você pode adicionar componentes como menus e botões.
//Esta em particular representa o subpainel de uma calculadora.
//A interface ActionListener é explicada melhor mais abaixo.
public class GateView extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;

	private Gate gate;
	private Source source1 = new Source();
	private Source source2 = new Source();
	
	private JCheckBox checkPin2;
	private JCheckBox checkpin2;
	private JCheckBox checkOut;
	

	public GateView(Gate gate) {
		this.gate = gate;
		
		checkPin2 = new JCheckBox();
		checkpin2 = new JCheckBox();
		checkOut = new JCheckBox();
		
		// A classe JLabel representa um componente que é simplesmente texto fixo.
		// https://docs.oracle.com/javase/tutorial/uiswing/components/label.html
		JLabel input1Label = new JLabel("Entrada");
		JLabel outLabel = new JLabel("Saida");
	
		// Todo painel precisa de um layout, que estabelece como os componentes
		// são organizados dentro dele. O layout escolhido na linha abaixo é o
		// mais simples possível: simplesmente enfileira todos eles na vertical.
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));


		add(input1Label);
		add(checkPin2);
		if (gate.getSize()>1) {
			add(checkpin2);
		}
		
		
		add(outLabel);
		add(checkOut);
		
		// Estabelece que este subpainel reage ao usuário marcar nos dois
		// primeiros checkbox. Isso só pode ser feito se este subpainel for
		// do tipo ActionListener, por isso ele implementa essa interface.
		checkPin2.addActionListener(this);
		checkpin2.addActionListener(this);
	
		// Estabelece que o terceiro checkbox está desativado, não é clicavel.
		checkOut.setEnabled(false);
		if (gate.toString() == "NOT" || gate.toString() == "NAND") {
			checkOut.setSelected(true);
		}
		
	
		// Não podemos esquecer de chamar update na inicialização,
		// caso contrário a interface só ficará consistente depois
		// da primeira interação do usuário com os campos de texto.
		// A definição exata do método update é dada logo abaixo.
		
		//update();
				
	}

	private void update() {
		boolean boolpino1;
		boolean boolPin2;
		boolean boolOut;
		

		try {
			boolpino1 = checkPin2.isSelected();
			source1.turn(boolpino1);
			gate.connect(0, source1);
			
			if (gate.getSize() > 1){
				boolPin2 = checkpin2.isSelected();
				source2.turn(boolPin2);
				gate.connect(1, source2);
			}
			
		}
		catch(NumberFormatException exception) {
			System.out.println(exception);
			return;
		}

		boolOut = gate.read();
		checkOut.setSelected(boolOut);		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		update();
		
	}

	


}
