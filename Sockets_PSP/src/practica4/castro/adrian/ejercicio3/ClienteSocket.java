package practica4.castro.adrian.ejercicio3;

import java.io.File;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClienteSocket {

	public static void main(String[] args) {

		try {
			System.out.println("Creando Socket cliente");
			Socket socketCliente = new Socket();
			
			System.out.println("Realizando la conexion");
			InetSocketAddress addr = new InetSocketAddress("localhost",5555);
			socketCliente.connect(addr);
			
			InputStream in = socketCliente.getInputStream();

			byte[] mensaje = in.readAllBytes();
			
			System.out.println("Imprimiendo contenido del archivo");
			System.out.println(new String(mensaje));
			
			System.out.println("Cerrando socket...");
			socketCliente.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
