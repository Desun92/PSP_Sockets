package castro.adrian.ejercicio5;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class ClienteSocketDatagram {

	public static void main(String[] args) {
		
		try (DatagramSocket datagramSocket = new DatagramSocket(null)) {
			
			InetSocketAddress addr = new InetSocketAddress("192.168.106.16",7777);
			datagramSocket.bind(addr);
			
			String mensaje = "Hola";
			InetSocketAddress direccionDestino = new InetSocketAddress("192.168.106.16",5555);
			DatagramPacket datagrama = new DatagramPacket(mensaje.getBytes(),mensaje.getBytes().length,direccionDestino);
			datagramSocket.send(datagrama);
			System.out.println("Envia mensaje -> "+mensaje);
			
			byte[] respuesta = new byte[25];
			DatagramPacket datagramaRespuesta = new DatagramPacket(respuesta,respuesta.length);
			datagramSocket.receive(datagramaRespuesta);
			System.out.println("Respuesta -> "+new String(respuesta));
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
