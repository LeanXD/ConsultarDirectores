package Controlador;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

public interface Accion {

	public boolean ejecutar (HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException;
	
	public void setDS(DataSource ds);
	
	public void setSc(ServletContext sc);
	
	public void setSession(HttpSession sesion);
	
	public void setVista(String vista);
	
	public void setModelo(Object modelo);
	
	public DataSource getDS();
	
	public ServletContext getSc();
	
	public HttpSession getSession();
	
	public String getVista();
	
	public Object getModelo();
}
