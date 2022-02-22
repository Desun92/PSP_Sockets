package practica4.castro.adrian.ejercicio6;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class SocketDatagramB {

	public static void main(String[] args) {
		
		try(DatagramSocket datagramCliente = new DatagramSocket(new InetSocketAddress("localhost",6666))) {
			
			byte[] mensajeCifrado = new byte[25];
			DatagramPacket datagrama = new DatagramPacket(mensajeCifrado,mensajeCifrado.length);
			
			System.out.println("Esperando a recibir mensaje");
			datagramCliente.receive(datagrama);
			
			String mensaje = "Recibido";
			InetSocketAddress direccionEnvio = new InetSocketAddress("localhost",5555);
			DatagramPacket datagramaEnvio = new DatagramPacket(mensaje.getBytes(),mensaje.getBytes().length,direccionEnvio);
			
			System.out.println("Enviando mensaje");
			datagramCliente.send(datagramaEnvio);
			
			System.out.println("Cerrando socket...");
			datagramCliente.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}


