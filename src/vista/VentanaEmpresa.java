package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VentanaEmpresa extends JFrame {

	private JPanel contentPane;
	private JLabel lblNombreEmpresa;
	private JTextField txtNombreEmpresa;
	private JLabel lblSueldoMinimo;
	private JTextField txtSueldo;
	private JPanel panelVacio;
	private JButton btnVolver;
	private JPanel panelVolver;
	private JPanel panelSueldoMinimo;
	private JPanel panelTxtSueldo;
	private JPanel panelNombreEmpresa;
	private JPanel panelTxtNombreEmpresa;
	private JButton btnConfirmar;
	
	private ActionListener actionListener;

	public VentanaEmpresa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		panelNombreEmpresa = new JPanel();
		contentPane.add(panelNombreEmpresa);
		
		lblNombreEmpresa = new JLabel("Nuevo Nombre Empesa:");
		panelNombreEmpresa.add(lblNombreEmpresa);
		
		panelTxtNombreEmpresa = new JPanel();
		contentPane.add(panelTxtNombreEmpresa);
		
		txtNombreEmpresa = new JTextField();
		panelTxtNombreEmpresa.add(txtNombreEmpresa);
		txtNombreEmpresa.setColumns(10);
		
		panelSueldoMinimo = new JPanel();
		contentPane.add(panelSueldoMinimo);
		
		lblSueldoMinimo = new JLabel("Sueldo Minimo:");
		panelSueldoMinimo.add(lblSueldoMinimo);
		
		panelTxtSueldo = new JPanel();
		contentPane.add(panelTxtSueldo);
		
		txtSueldo = new JTextField();
		panelTxtSueldo.add(txtSueldo);
		txtSueldo.setColumns(10);
		
		panelVacio = new JPanel();
		contentPane.add(panelVacio);
		
		btnConfirmar = new JButton("Confirmar");
		this.btnConfirmar.setActionCommand("CONFIRMAR");
		panelVacio.add(btnConfirmar);
		
		panelVolver = new JPanel();
		contentPane.add(panelVolver);
		
		btnVolver = new JButton("Volver");
		this.btnVolver.setActionCommand("VOLVER");
		panelVolver.add(btnVolver);
		
		this.setVisible(true);
	}
	
	public void setActionListener(ActionListener actionListener) {
		this.btnConfirmar.addActionListener(actionListener);
		this.btnVolver.addActionListener(actionListener);
		this.actionListener = actionListener;
	}
	
	public void esconder() {
		this.setVisible(false);
	}

	public void mostrar() {
		this.setVisible(true);		
	}

	public JTextField getTxtNombreEmpresa() {
		return txtNombreEmpresa;
	}

	public JTextField getTxtSueldo() {
		return txtSueldo;
	}
	
	

}
