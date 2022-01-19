package castro.adrian.ejercicio1;

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
				Socket socket = serverSocket.accept();
				contador++;
				
				//InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();
				
				os.write(Integer.toString(contador).getBytes());
				socket.close();
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
