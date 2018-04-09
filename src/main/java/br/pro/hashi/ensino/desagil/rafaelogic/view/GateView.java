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

	// Não é necessário entender esta linha, mas se você estiver curioso
	// pode ler http://blog.caelum.com.br/entendendo-o-serialversionuid/.
	private static final long serialVersionUID = 1L;

	private Gate gate;
	private Source font1 = new Source();
	private Source font2 = new Source();
	
	private JCheckBox checkPino1;
	private JCheckBox checkPino2;
	private JCheckBox checkSaida;
	

	public GateView(Gate gate) {
		this.gate = gate;
		
		checkPino1 = new JCheckBox();
		checkPino2 = new JCheckBox();
		checkSaida = new JCheckBox();
		
		// A classe JLabel representa um componente que é simplesmente texto fixo.
		// https://docs.oracle.com/javase/tutorial/uiswing/components/label.html
		JLabel entrada1Label = new JLabel("Entrada");
		JLabel saidaLabel = new JLabel("Saida");
	
		// Todo painel precisa de um layout, que estabelece como os componentes
		// são organizados dentro dele. O layout escolhido na linha abaixo é o
		// mais simples possível: simplesmente enfileira todos eles na vertical.
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));


		add(entrada1Label);
		add(checkPino1);
		if (gate.getSize()>1) {
			add(checkPino2);
		}
		
		
		add(saidaLabel);
		add(checkSaida);
		
		// Estabelece que este subpainel reage ao usuário marcar nos dois
		// primeiros checkbox. Isso só pode ser feito se este subpainel for
		// do tipo ActionListener, por isso ele implementa essa interface.
		checkPino1.addActionListener(this);
		checkPino2.addActionListener(this);
	
		// Estabelece que o terceiro checkbox está desativado, não é clicavel.
		checkSaida.setEnabled(false);
		if (gate.toString() == "NOT" || gate.toString() == "NAND") {
			checkSaida.setSelected(true);
		}
		
	
		// Não podemos esquecer de chamar update na inicialização,
		// caso contrário a interface só ficará consistente depois
		// da primeira interação do usuário com os campos de texto.
		// A definição exata do método update é dada logo abaixo.
		
		//update();
				
	}

	private void update() {
		boolean boolpino1;
		boolean boolpino2;
		boolean boolsaida;
		

		try {
			boolpino1 = checkPino1.isSelected();
			font1.turn(boolpino1);
			gate.connect(0, font1);
			
			if (gate.getSize() > 1){
				boolpino2 = checkPino2.isSelected();
				font2.turn(boolpino2);
				gate.connect(1, font2);
			}
			
		}
		catch(NumberFormatException exception) {
			System.out.println(exception);
			return;
		}

		boolsaida = gate.read();
		checkSaida.setSelected(boolsaida);		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		update();
		
	}

	


}
