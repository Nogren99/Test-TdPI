package vista;

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.border.TitledBorder;
import javax.swing.text.JTextComponent;

import capaDeDatos.Mesa;
import capaDeDatos.Mozo;
import capaDeNegocios.Local;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTextField;

public class VentanaMozoModificar extends JFrame implements IVista {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnVolver;
	private JPanel panelVolver;
	private JList<Mozo> listMozos;
	private JLabel lblEstado;
	private JButton btnActivo;
	private JButton btnDeFranco;
	private JPanel panelMesas;
	private DefaultListModel <Mozo> mozos= new DefaultListModel<Mozo>();
	private JButton btnAusente;
	private JLabel lblCanthijos;
	private JTextField txtHijos;
	private JPanel panelVacio3;
	private JPanel panelVacio5;
	private JPanel panelVacio4;
	private JPanel panelVacio2;
	private JPanel panelVacio6;
	private JPanel panelVacio7;
	private JPanel panelVacio8;
	private JPanel panelVacio9;
	private JButton btnGuardar;

	public VentanaMozoModificar() {
		
		mozos.addAll(Local.getInstance().getMozos());
		
		getContentPane().setLayout(new GridLayout(2, 0, 0, 0));
		setBounds(100, 100, 800, 700);
		panelMesas = new JPanel();
		panelMesas.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Mozos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		getContentPane().add(panelMesas);
		
		listMozos = new JList<Mozo>();
		listMozos.setModel(mozos);
		panelMesas.add(listMozos);
		
		panelVolver = new JPanel();
		getContentPane().add(panelVolver);
		panelVolver.setLayout(new GridLayout(4, 5, 0, 0));
		
		lblCanthijos = new JLabel("Cantidad de Hijos:");
		panelVolver.add(lblCanthijos);
		
		txtHijos = new JTextField();
		panelVolver.add(txtHijos);
		txtHijos.setColumns(10);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setActionCommand("GUARDAR");
		panelVolver.add(btnGuardar);
		
		panelVacio2 = new JPanel();
		panelVolver.add(panelVacio2);
		
		lblEstado = new JLabel("Estado:");
		panelVolver.add(lblEstado);
		
		btnActivo = new JButton("Activo");
		btnActivo.setActionCommand("ACTIVO");
		panelVolver.add(btnActivo);
		
		
		btnDeFranco = new JButton("De Franco");
		btnDeFranco.setActionCommand("DE FRANCO");
		panelVolver.add(btnDeFranco);
		
		btnAusente = new JButton("Ausente");
		btnAusente.setActionCommand("AUSENTE");
		panelVolver.add(btnAusente);
		
		panelVacio3 = new JPanel();
		panelVolver.add(panelVacio3);
		
		panelVacio4 = new JPanel();
		panelVolver.add(panelVacio4);
		
		panelVacio5 = new JPanel();
		panelVolver.add(panelVacio5);
		
		panelVacio6 = new JPanel();
		panelVolver.add(panelVacio6);
		
		panelVacio7 = new JPanel();
		panelVolver.add(panelVacio7);
		
		panelVacio8 = new JPanel();
		panelVolver.add(panelVacio8);
		
		panelVacio9 = new JPanel();
		panelVolver.add(panelVacio9);
		
		btnVolver = new JButton("Volver");
		btnVolver.setActionCommand("VOLVER");
		panelVolver.add(btnVolver);
		
		
		this.setVisible(true);
	}


	@Override
	public void setActionListener(ActionListener actionListener) {
		btnGuardar.addActionListener(actionListener);
		btnActivo.addActionListener(actionListener);
		btnDeFranco.addActionListener(actionListener);
		btnAusente.addActionListener(actionListener);
		btnVolver.addActionListener(actionListener);
	}

	public void actualizaLista() {
		this.validate();
	}
	
	@Override
	public void esconder() {
		this.setVisible(false);
	}

	@Override
	public void mostrar() {
		this.setVisible(true);		
	}


	public Mozo getMozoSeleccionada() {
		return this.listMozos.getSelectedValue();
	}


	public JTextField getTxtHijos() {
		return txtHijos;
	}

}
