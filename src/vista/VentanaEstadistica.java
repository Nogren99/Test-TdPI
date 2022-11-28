package vista;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import capaDeDatos.Mozo;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.BorderLayout;

public class VentanaEstadistica extends JFrame implements IVista {

	private JPanel contentPane;
	private ActionListener actionListener;
	private JPanel panel_12;
	private JButton btnVolver;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel lblMaxVentas;
	private JPanel panel_3;
	private JLabel areaMaxVentas;
	private JPanel panel_4;
	private JPanel panel_5;
	private JLabel lblMaxPromedio;
	private JPanel panel_6;
	private JLabel areaMaxPromedio;
	private JPanel panel_7;
	private JPanel panel_8;
	private JLabel lblMinVentas;
	private JPanel panel_9;
	private JLabel areaMinVentas;
	private JPanel panel_10;
	private JPanel panel_11;
	private JLabel lblMinPromedio;
	private JPanel panel_13;
	private JLabel areaMinPromedio;

	public VentanaEstadistica() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		this.contentPane.setLayout(new BorderLayout(0, 0));

		this.panel_12 = new JPanel();
		this.contentPane.add(this.panel_12, BorderLayout.SOUTH);

		this.btnVolver = new JButton("Volver");
		this.btnVolver.setActionCommand("VOLVER");
		this.panel_12.add(this.btnVolver);

		this.panel = new JPanel();
		this.contentPane.add(this.panel, BorderLayout.CENTER);
		this.panel.setLayout(new GridLayout(0, 2, 0, 0));

		this.panel_1 = new JPanel();
		this.panel.add(this.panel_1);
		this.panel_1.setLayout(new GridLayout(2, 1, 0, 0));

		this.panel_2 = new JPanel();
		this.panel_1.add(this.panel_2);

		this.lblMaxVentas = new JLabel("Mayor Cantidad de ventas");
		this.panel_2.add(this.lblMaxVentas);

		this.panel_3 = new JPanel();
		this.panel_1.add(this.panel_3);

		this.areaMaxVentas = new JLabel();
		this.panel_3.add(this.areaMaxVentas);

		this.panel_4 = new JPanel();
		this.panel.add(this.panel_4);
		this.panel_4.setLayout(new GridLayout(2, 1, 0, 0));

		this.panel_5 = new JPanel();
		this.panel_4.add(this.panel_5);

		this.lblMaxPromedio = new JLabel("Mayor Consumo promedio");
		this.panel_5.add(this.lblMaxPromedio);

		this.panel_6 = new JPanel();
		this.panel_4.add(this.panel_6);

		this.areaMaxPromedio = new JLabel();
		this.panel_6.add(this.areaMaxPromedio);

		this.panel_7 = new JPanel();
		this.panel.add(this.panel_7);
		this.panel_7.setLayout(new GridLayout(2, 1, 0, 0));

		this.panel_8 = new JPanel();
		this.panel_7.add(this.panel_8);

		this.lblMinVentas = new JLabel("Menor cantidad de ventas");
		this.panel_8.add(this.lblMinVentas);

		this.panel_9 = new JPanel();
		this.panel_7.add(this.panel_9);

		this.areaMinVentas = new JLabel();
		this.panel_9.add(this.areaMinVentas);

		this.panel_10 = new JPanel();
		this.panel.add(this.panel_10);
		this.panel_10.setLayout(new GridLayout(2, 1, 0, 0));

		this.panel_11 = new JPanel();
		this.panel_10.add(this.panel_11);

		this.lblMinPromedio = new JLabel("Menor Consumo promedio");
		this.panel_11.add(this.lblMinPromedio);

		this.panel_13 = new JPanel();
		this.panel_10.add(this.panel_13);

		this.areaMinPromedio = new JLabel();
		this.panel_13.add(this.areaMinPromedio);

		this.setVisible(true);
	}

	@Override
	public void setActionListener(ActionListener actionListener) {
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

	public void setMaxVentas(Mozo mozo) {
		String cadena;
		if (mozo == null)
			cadena = "No Disponible";
		else
			cadena = mozo.toString();
		this.areaMaxVentas.setText(cadena);
	}

	public void setMinVentas(Mozo mozo) {
		String cadena;
		if (mozo == null)
			cadena = "No Disponible";
		else
			cadena = mozo.toString();
		this.areaMinVentas.setText(cadena);
	}

	public void setMaxPromedio(Mozo mozo) {
		String cadena;
		if (mozo == null)
			cadena = "No Disponible";
		else
			cadena = mozo.toString();
		this.areaMaxPromedio.setText(cadena);
	}

	public void setMinPromedio(Mozo mozo) {
		String cadena;
		if (mozo == null)
			cadena = "No Disponible";
		else
			cadena = mozo.toString();
		this.areaMinPromedio.setText(cadena);
	}

}
