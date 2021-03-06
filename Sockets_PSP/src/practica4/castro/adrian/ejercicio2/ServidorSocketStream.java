package practica4.castro.adrian.ejercicio2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorSocketStream {
	public static void main(String[] args) {
		int contador = 0;
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket();
			InetSocketAddress addr = new InetSocketAddress("localhost",6666);
			serverSocket.bind(addr);
			
			while(true) {
				System.out.println("Aceptando conexiones");
				Socket socket = serverSocket.accept();
				contador++;

				Runnable socketCliente = new ServidorRunnable(socket,contador);
				Thread hilo = new Thread(socketCliente);
				hilo.start();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(serverSocket!=null) {
				try {
					serverSocket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
