package Acciones;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import Controlador.Accion;
import Beans.BeansFotogramas;

public class AccionIndex implements Accion {

	public String vista = "index.jsp";
	public ServletContext sc;
	public DataSource datSc;
	public HttpSession sesion;
	public ArrayList<BeansFotogramas> modelo;
	
	@Override
	public boolean ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean resultado = false;
		modelo = new ArrayList<BeansFotogramas>();
		Connection conexion = null;
		Statement st = null;
		ResultSet rt = null;
		String director = request.getParameter("director");
		try {
			conexion = datSc.getConnection();
			st = conexion.createStatement();
			rt =  st.executeQuery("SELECT * FROM fotogramas WHERE director = '"+director+"'");
			if(rt!=null){
				while(rt.next()){
					modelo.add(new BeansFotogramas(rt.getInt("idFotograma"),rt.getString("archivo"),rt.getString("titPelicula"),rt.getString("anyoEstreno"),rt.getString("director"), rt.getString("genero")));
				}
				resultado = true;
				setModelo(modelo);
			}else{
				resultado = false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(resultado){
			vista =  "index.jsp";
		}
		
		return resultado;
	}

	@Override
	public void setDS(DataSource ds) {
		// TODO Auto-generated method stub
		this.datSc = ds;
	}

	@Override
	public void setSc(ServletContext sc) {
		// TODO Auto-generated method stub
		this.sc = sc;
	}

	@Override
	public void setSession(HttpSession sesion) {
		this.sesion = sesion;
	}

	@Override
	public void setVista(String vista) {
		this.vista = vista;
	}

	@Override
	public void setModelo(Object modelo) {
		this.modelo = (ArrayList<BeansFotogramas>) modelo;
	}

	@Override
	public DataSource getDS() {
		// TODO Auto-generated method stub
		return this.datSc;
	}

	@Override
	public ServletContext getSc() {
		// TODO Auto-generated method stub
		return this.sc;
	}

	@Override
	public HttpSession getSession() {
		// TODO Auto-generated method stub
		return this.sesion;
	}

	@Override
	public String getVista() {
		// TODO Auto-generated method stub
		return this.vista;
	}

	@Override
	public Object getModelo() {
		// TODO Auto-generated method stub
		return this.modelo;
	}

	
}
