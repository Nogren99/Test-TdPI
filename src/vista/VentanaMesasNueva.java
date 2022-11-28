package vista;

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;

public class VentanaMesasNueva extends JFrame implements IVista {
	private JButton btnCreacion;
	private JButton btnVolver;
	private JPanel panelCreacion;
	private JPanel panelVolver;
	private JLabel lblInforme;

	public VentanaMesasNueva() {
		getContentPane().setLayout(new GridLayout(2, 0, 0, 0));
		setBounds(100, 100, 800, 700);
		panelCreacion = new JPanel();
		getContentPane().add(panelCreacion);
		
		btnCreacion = new JButton("Creación");
		panelCreacion.add(btnCreacion);
		btnCreacion.setActionCommand("CREAR");
		
		lblInforme = new JLabel("Se creo correctamente");
		panelCreacion.add(lblInforme);
		lblInforme.setVisible(false);
		
		panelVolver = new JPanel();
		getContentPane().add(panelVolver);
		
		btnVolver = new JButton("Volver");
		panelVolver.add(btnVolver);
		btnVolver.setActionCommand("VOLVER");
		
		this.setVisible(true);
	}

	public JLabel getLblInforme() {
		return lblInforme;
	}

	@Override
	public void setActionListener(ActionListener actionListener) {
		btnCreacion.addActionListener(actionListener);
		btnVolver.addActionListener(actionListener);
		
	}

	@Override
	public void esconder() {
		this.setVisible(false);
	}

	@Override
	public void mostrar() {
		this.setVisible(true);		
	}
}
