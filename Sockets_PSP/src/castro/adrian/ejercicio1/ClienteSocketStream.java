package castro.adrian.ejercicio1;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClienteSocketStream {

	public static void main(String[] args) {
		try {
			Socket clientSocket = new Socket();
			InetSocketAddress addr = new InetSocketAddress("localhost",6666);
			clientSocket.connect(addr);
			
			OutputStream os = clientSocket.getOutputStream();
			InputStream in = clientSocket.getInputStream();
			
			String resultado = new String(in.readAllBytes());
			System.out.println(resultado);
			
			clientSocket.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
