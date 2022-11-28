package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import capaDeDatos.AsignacionDiaria;
import capaDeDatos.Mesa;
import capaDeDatos.Mozo;
import capaDeDatos.PromocionTemporal;
import capaDeNegocios.Local;

import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class VentanaMozoMesa extends JFrame {

	private JPanel contentPane;
	private JList<Mesa> listMesa;
	private DefaultListModel<Mesa> mesas = new DefaultListModel<Mesa>();
	private JList<Mozo> listMozo;
	private DefaultListModel<Mozo> mozos = new DefaultListModel<Mozo>();
	private JButton btnCrear;
	private JButton btnCancelar;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private ActionListener actionListener;

	public VentanaMozoMesa() {
		
		ArrayList<Mesa> mesasAsignadas = new ArrayList<Mesa>();
		for (AsignacionDiaria asignacionDiariaActual: Local.getInstance().getAsignacionDiaria()) {
			mesasAsignadas.add(asignacionDiariaActual.getMesa());
		}
		
		for (Mesa mesaActual : Local.getInstance().getMesas()) {
			if (! mesasAsignadas.contains(mesaActual)) {
				mesas.addElement(mesaActual); //añado solo las mesas no asignadas
			}
		}
			
		mozos.addAll(Local.getInstance().getMozos());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		this.contentPane.setLayout(new GridLayout(2, 2, 0, 0));
		
		this.panel = new JPanel();
		this.panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Mesa", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		this.contentPane.add(this.panel);
		
		this.listMesa = new JList<Mesa>();
		listMesa.setModel(mesas);
		this.panel.add(this.listMesa);
		
		this.panel_1 = new JPanel();
		this.panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Mozo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		this.contentPane.add(this.panel_1);
		
		this.listMozo = new JList<Mozo>();
		listMozo.setModel(mozos);
		this.panel_1.add(this.listMozo);
		
		this.panel_2 = new JPanel();
		this.contentPane.add(this.panel_2);
		
		this.btnCrear = new JButton("Crear");
		this.panel_2.add(this.btnCrear);
		this.btnCrear.setActionCommand("CREAR");
		
		this.panel_3 = new JPanel();
		this.contentPane.add(this.panel_3);
		
		this.btnCancelar = new JButton("Volver");
		this.btnCancelar.setActionCommand("VOLVER");
		this.panel_3.add(this.btnCancelar);
		
		this.setVisible(true);
	}

	public void setActionListener(ActionListener actionListener) {
		this.btnCrear.addActionListener(actionListener);
		this.btnCancelar.addActionListener(actionListener);
		this.actionListener = actionListener;
	}

	public void esconder() {
		this.setVisible(false);
	}

	public Mesa getListaMesaSeleccionada() {
		return this.listMesa.getSelectedValue();
	}

	public Mozo getListaMozoSeleccionada() {
		return this.listMozo.getSelectedValue();
	}

	public void mostrar() {
		this.setVisible(true);
	}

	public void actualizaLista() {
		this.validate();
	}

	public void removeMozo(Mozo mozo) {
		this.mozos.removeElement(mozo);
	}

	public void removeMesa(Mesa mesa) {
		this.mesas.removeElement(mesa);
	}

}
