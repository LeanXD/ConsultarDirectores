package Controlador;

import Acciones.AccionIndex;

public abstract class FactoriaAcciones {
	
	public static Accion newAccion(){
		Accion accion = new AccionIndex();
		return accion;
	}

}
