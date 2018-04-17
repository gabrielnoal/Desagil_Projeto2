package br.pro.hashi.ensino.desagil.rafaelogic.view;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
//import javax.swing.JTextField;
import javax.swing.JCheckBox;

import br.pro.hashi.ensino.desagil.rafaelogic.model.Gate;
import br.pro.hashi.ensino.desagil.rafaelogic.model.Source;

//A classe JPanel representa um painel da interface gr�fica,
//onde voc� pode adicionar componentes como menus e bot�es.

public class GateView extends SimplePanel implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;

	private Gate gate;
	
	// CheckBoxs (Quadradinhos com check)
	private JCheckBox checkPin1;
	private JCheckBox checkPin2;
	
	// Cores e Imagens
	private Color color;
	private Image image;

	public GateView(Gate gate) {
		
		// Tamanho da Janela
		super(480, 400);
		
		this.gate = gate;
		
		checkPin1 = new JCheckBox();
		checkPin2 = new JCheckBox();
		
		// A classe JLabel representa um componente que é simplesmente texto fixo.
		// https://docs.oracle.com/javase/tutorial/uiswing/components/label.html
		JLabel input1Label = new JLabel("Entrada");
	
		
		// Portas com uma entrada
		if (gate.getSize()==1) {
			add(input1Label, 0, 0, 60, 30);
			add(checkPin1, 0, 80, 30, 30);
		}
		
		// Portas com duas entradas
		if (gate.getSize()==2) {
			add(input1Label, 0, 0, 60, 30);
			add(checkPin1, 0, 50, 30, 30);
			add(checkPin2, 0, 120, 30, 30);
		}
		

		// Estabelece que este subpainel reage ao usuário marcar nos dois
		// primeiros checkbox. Isso só pode ser feito se este subpainel for
		// do tipo ActionListener, por isso ele implementa essa interface.
		checkPin1.addActionListener(this);
		checkPin2.addActionListener(this);
	
	
		// Chamando update na inicializa��o
		// caso contrário a interface só ficará consistente depois
		// da primeira interação do usuário com os campos de texto.
		
		update();
		
		// Abrindo imagens
		String path = "/" + gate.toString() + ".png";
		URL url = getClass().getResource(path);
		image = new ImageIcon(url).getImage();
		
		addMouseListener(this);				
	}
	
		// Update - Atualiza��o da janela

	private void update() {
		
		Source source1 = new Source();
		Source source2 = new Source();
		
		boolean boolPin1;
		boolean boolPin2;
		boolean boolOut;
		

		try {
			boolPin1 = checkPin1.isSelected();
			boolPin2 = checkPin2.isSelected();
			if(boolPin1){ 
				source1.turn(true);
			}
			else{
				source1.turn(false);
			}
			if(boolPin2){ 
				source2.turn(true);
			}
			else{
				source2.turn(false);
			}	
			if (gate.getSize() == 1){
				gate.connect(0, source1);
			}
			if (gate.getSize() == 2){
				gate.connect(1, source2);
				gate.connect(0, source1);
			}
		}
		catch(NumberFormatException exception) {
			System.out.println(exception);
			return;
		}
		
		// Sa�da
		
		boolOut = gate.read();
		
		//Se � 1 - Veremlho
		if (boolOut == true){
			color = Color.RED;
			repaint();
		}
		// Se � 0 - Preto
		if (boolOut == false){
			color = Color.BLACK;
			repaint();
		}
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		update();
		
	}

	@Override
	public void mouseClicked(MouseEvent event) {
		// Descobre em qual posi��o o clique ocorreu.
		int x = event.getX();
		int y = event.getY();
		double distancia = Math.sqrt(Math.pow(212-x, 2)+Math.pow(105-y, 2));

		// Se o clique foi dentro do c�rculo vermelho...
		if(distancia <= 12 && color == Color.RED) {

			// abrir o seletor de cor
			color = JColorChooser.showDialog(this, null, color);

			// pinta a tela
			repaint();
		}

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void paintComponent(Graphics g) {

		// N�o podemos esquecer desta linha, pois n�o somos os
		// �nicos respons�veis por desenhar o painel, como era
		// o caso no Projeto 1. Agora � preciso desenhar tamb�m
		// componentes internas, e isso � feito pela superclasse.
		super.paintComponent(g);

		// Desenha a imagem passando posi��o e tamanho.
		// O �ltimo par�metro pode ser sempre null.
		g.drawImage(image, 40, 35, 165, 145, null);

		// Desenha um C�rculo Oval cheio.
		g.setColor(color);
		g.fillOval(200, 93, 24, 24);

		// Evita bugs visuais em alguns sistemas operacionais.
		getToolkit().sync();
    }
}
