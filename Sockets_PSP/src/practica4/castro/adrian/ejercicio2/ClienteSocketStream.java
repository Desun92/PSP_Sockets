package practica4.castro.adrian.ejercicio2;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClienteSocketStream {

	public static void main(String[] args) {
		try {
			System.out.println("Creando socket Cliente");
			Socket clientSocket = new Socket();
			
			System.out.println("Estableciendo la conexion");
			InetSocketAddress addr = new InetSocketAddress("localhost",6666);
			clientSocket.connect(addr);
			
			//OutputStream os = clientSocket.getOutputStream();
			InputStream in = clientSocket.getInputStream();
			
			System.out.println("Recibiendo el numero de conexiones");
			String resultado = new String(in.readAllBytes());
			System.out.println(resultado);
			
			System.out.println("Cerrando el socket cliente");
			clientSocket.close();
			System.out.println("Terminado");
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
