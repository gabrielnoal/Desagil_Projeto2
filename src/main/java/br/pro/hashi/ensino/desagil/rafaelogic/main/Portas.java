package br.pro.hashi.ensino.desagil.rafaelogic.main;

import java.util.LinkedList;

import javax.swing.JFrame;

import br.pro.hashi.ensino.desagil.rafaelogic.model.AndGate;
import br.pro.hashi.ensino.desagil.rafaelogic.model.Gate;
import br.pro.hashi.ensino.desagil.rafaelogic.model.NandGate;
import br.pro.hashi.ensino.desagil.rafaelogic.model.NotGate;
import br.pro.hashi.ensino.desagil.rafaelogic.model.OrGate;
import br.pro.hashi.ensino.desagil.rafaelogic.model.XorGate;
import br.pro.hashi.ensino.desagil.rafaelogic.view.View;


public class Portas {
	public static void main(String[] args) {

		// Estrutura básica de um programa Swing, já usada no Projeto 1.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {

				// Constrói o modelo.
				LinkedList<Gate> model = new LinkedList<>();
				model.add(new NotGate());
				model.add(new AndGate());
				model.add(new NandGate());
				model.add(new OrGate());
				model.add(new XorGate());
				//model.add(new CFCCalculator());

				// Constrói a visão.
				View view = new View(model);

				// Configuração básica de uma janela Swing, já usada no Projeto 1.
				JFrame frame = new JFrame();
				frame.setContentPane(view);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setResizable(true);
				frame.pack();
				frame.setVisible(true);
			}
		});
	}

}
