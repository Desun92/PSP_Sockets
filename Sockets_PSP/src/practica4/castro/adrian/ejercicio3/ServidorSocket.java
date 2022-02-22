package practica4.castro.adrian.ejercicio3;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorSocket {

	public static void main(String[] args) {
		
		try {
			System.out.println("Creando socket Servidor");
			ServerSocket serverSocket = new ServerSocket();
			
			System.out.println("Realizando el bind");
			InetSocketAddress addr = new InetSocketAddress("localhost",5555);
			serverSocket.bind(addr);
			
			File fichero = new File("C:\\Users\\Adri\\Desktop\\holaMundo.txt");
			
			FileInputStream inF = new FileInputStream(fichero);
			
			System.out.println("Aceptando conexiones");
			Socket socket = serverSocket.accept();
			System.out.println("Conexion aceptada");
			
			System.out.println("Transfiriendo el fichero");
			OutputStream out = socket.getOutputStream();
			inF.transferTo(out);
			
			System.out.println("Cerrando el socket cliente");
			socket.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
