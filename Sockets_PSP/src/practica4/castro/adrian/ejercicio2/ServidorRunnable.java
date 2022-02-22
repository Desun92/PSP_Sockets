package practica4.castro.adrian.ejercicio2;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ServidorRunnable implements Runnable {

	private Socket socketCliente;
	private Integer contador;
	
	public ServidorRunnable(Socket socket,int contador) {
		this.socketCliente = socket;
		this.contador=contador;
	}
	@Override
	public void run() {
		try {
			System.out.println("Conexion aceptada");
			
			OutputStream out = socketCliente.getOutputStream();
			out.write(contador.toString().getBytes());
			
			socketCliente.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				socketCliente.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
