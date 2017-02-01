package Controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public class AyudaSolicitud {

	HttpServletRequest request;
	
	public AyudaSolicitud(HttpServletRequest request) throws IOException, ServletException {
		this.request = request;
	}
	
	public Accion getAccion(){
		String accion = request.getParameter("accion");
		return FactoriaAcciones.newAccion();
	}
}
