package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class VentanaMesas extends JFrame implements IVista{

	private JPanel contentPane;
	private JButton btnNuevaMesa;
	private JButton btnModificaMesa;
	private JButton btnEliminarMesa;
	private JButton btnVolver;
	private JPanel panel;
	private ActionListener actionListener;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	
	public VentanaMesas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 2, 0, 0));
		
		this.panel_1 = new JPanel();
		this.contentPane.add(this.panel_1);
		
		btnNuevaMesa = new JButton("Nueva Mesa");
		this.panel_1.add(this.btnNuevaMesa);
		this.btnNuevaMesa.setActionCommand("NUEVA");
		
		this.panel_2 = new JPanel();
		this.contentPane.add(this.panel_2);
		
		btnModificaMesa = new JButton("Modificar Mesa");
		this.panel_2.add(this.btnModificaMesa);
		this.btnModificaMesa.setActionCommand("MODIFICAR");
		
		this.panel_3 = new JPanel();
		this.contentPane.add(this.panel_3);
		
		btnEliminarMesa = new JButton("Eliminar Mesa");
		this.panel_3.add(this.btnEliminarMesa);
		this.btnEliminarMesa.setActionCommand("ELIMINAR");
		
		panel = new JPanel();
		contentPane.add(panel);
		
		btnVolver = new JButton("Volver");
		this.btnVolver.setActionCommand("VOLVER");
		panel.add(btnVolver);
		
		this.setVisible(true);
	}

	@Override
	public void setActionListener(ActionListener actionListener) {
		this.btnNuevaMesa.addActionListener(actionListener);
		this.btnModificaMesa.addActionListener(actionListener);
		this.btnEliminarMesa.addActionListener(actionListener);
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
