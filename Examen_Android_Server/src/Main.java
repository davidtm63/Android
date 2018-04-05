import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(9999);
			System.out.println("Esperando que alguien se connecte . . . . .");
			System.out.println("Pos ya esta . . . . . .");
			while(true) {
				Socket sc = server.accept();
				System.out.println("Pues alguien se ha conectado . . . . :-)");
				new ExamenHilo(sc).start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
