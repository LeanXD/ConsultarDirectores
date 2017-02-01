package Controlador;

import java.io.IOException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.security.sasl.SaslServer;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet(name="controlador", urlPatterns="/comprobar")
public class controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DataSource dataSc;
	private ServletContext sc;
	
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
		try{
			InitialContext initCnx = new InitialContext();
			setDataSource((DataSource) initCnx.lookup("java:jboss/datasources/bdfotogramas"));
			if(getDataSource()==null){
				System.out.println("Error en la conexión");
			}
			sc = config.getServletContext();
			sc.setAttribute("DataSources", getDataSource());
		}catch(NamingException ne){
		
		}	      

		
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		AyudaSolicitud ayudaS = new AyudaSolicitud(request);
		Accion accion = ayudaS.getAccion();
		accion.setSc(sc);
		accion.setDS(dataSc);
		if(accion.ejecutar(request, response)){
			String vista = accion.getVista();
			request.setAttribute("modelo", accion.getModelo());
			RequestDispatcher rd = request.getRequestDispatcher(vista);
			rd.forward(request, response);
		}else{
			
		}
	}
	
	public void setDataSource(DataSource data){
		this.dataSc = data; 
	}
	
	public void setServletContext(ServletContext sc){
		this.sc = sc;
	}
	
	public ServletContext getServletContext(){
		return this.sc;
	}
	
	public DataSource getDataSource(){
		return this.dataSc;
	}
	
	
	
	
}
