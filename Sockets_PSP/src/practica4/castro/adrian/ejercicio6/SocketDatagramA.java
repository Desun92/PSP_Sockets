package practica4.castro.adrian.ejercicio6;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class SocketDatagramA {

	public static void main(String[] args) {

		try(DatagramSocket datagramServer = new DatagramSocket(new InetSocketAddress("localhost",5555))) {
			
			String mensaje = "Testigo";
			InetSocketAddress direccionDestino = new InetSocketAddress("localhost",6666);
			DatagramPacket datagrama = new DatagramPacket(mensaje.getBytes(),mensaje.getBytes().length,direccionDestino);
			
			System.out.println("Enviando mensaje");
			datagramServer.send(datagrama);
			
			byte[] mensajeRecibido = new byte[25];
			DatagramPacket datagramaRecibido = new DatagramPacket(mensajeRecibido,mensajeRecibido.length);
			datagramServer.receive(datagramaRecibido);
			byte[] mensajeCifrado = datagramaRecibido.getData();
			
			System.out.println(new String(mensajeCifrado).trim());
			
			System.out.println("Cerrando Socket...");
			datagramServer.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
