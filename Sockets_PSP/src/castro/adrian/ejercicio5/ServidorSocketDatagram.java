package castro.adrian.ejercicio5;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class ServidorSocketDatagram {

	public static void main(String[] args) {
		
		try (DatagramSocket datagramServer = new DatagramSocket(new InetSocketAddress("192.168.106.16",5555))){
			
			byte[] mensaje = new byte[25];
			DatagramPacket datagrama = new DatagramPacket(mensaje,mensaje.length);
			datagramServer.receive(datagrama);
			
			byte[] mensajeCifrado = datagrama.getData();
			String mensajeDescifrado = new String(mensajeCifrado).trim();
			
			if("Hola".equals(mensajeDescifrado)) {
				InetSocketAddress direccionDestino = (InetSocketAddress) datagrama.getSocketAddress();
				DatagramPacket datagramaEnviar = new DatagramPacket("Que tal".getBytes(),"Que tal".getBytes().length,direccionDestino);
				datagramServer.send(datagramaEnviar);
			}
			else {
				System.out.println("No respondo");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
