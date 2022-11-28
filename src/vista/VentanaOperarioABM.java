package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class VentanaOperarioABM extends JFrame implements IVista{

	private JPanel contentPane;
	private JButton btnNuevoOperario;
	private JButton btnModificarOperario;
	private JButton btnEliminarOperario;
	private JButton btnVolver;
	private JPanel panel;
	private ActionListener actionListener;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	
	public VentanaOperarioABM() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 2, 0, 0));
		
		this.panel_1 = new JPanel();
		this.contentPane.add(this.panel_1);
		
		btnNuevoOperario = new JButton("Nuevo Operario");
		this.panel_1.add(this.btnNuevoOperario);
		this.btnNuevoOperario.setActionCommand("NUEVA");
		
		this.panel_2 = new JPanel();
		this.contentPane.add(this.panel_2);
		
		btnModificarOperario = new JButton("Modificar Operario");
		this.panel_2.add(this.btnModificarOperario);
		this.btnModificarOperario.setActionCommand("MODIFICAR");
		
		this.panel_3 = new JPanel();
		this.contentPane.add(this.panel_3);
		
		btnEliminarOperario = new JButton("Eliminar Operario");
		this.panel_3.add(this.btnEliminarOperario);
		this.btnEliminarOperario.setActionCommand("ELIMINAR");
		
		panel = new JPanel();
		contentPane.add(panel);
		
		btnVolver = new JButton("Volver");
		this.btnVolver.setActionCommand("VOLVER");
		panel.add(btnVolver);
		
		this.setVisible(true);
	}

	@Override
	public void setActionListener(ActionListener actionListener) {
		this.btnNuevoOperario.addActionListener(actionListener);
		this.btnModificarOperario.addActionListener(actionListener);
		this.btnEliminarOperario.addActionListener(actionListener);
		this.btnVolver.addActionListener(actionListener);
		this.actionListener = actionListener;
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
