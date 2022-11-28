package vista;

import java.awt.event.ActionListener;

public interface IVista {
	void setActionListener(ActionListener actionListener);
	void esconder();
	void mostrar();
}
