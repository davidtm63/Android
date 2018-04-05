import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Random;

public class ExamenHilo extends Thread {
	Random rn = new Random();
	Socket sc;
	double lat = 00.00;
	double lon = 00.00;
	
	public ExamenHilo(Socket soc) {
		this.sc = soc;
	}

	@Override
	public void run() {
		double maxLat = 90,minLat = -90, maxLon = 180, minLon = -180;
		PrintStream salida = null;
		
		try {
			salida = new PrintStream(sc.getOutputStream());
			StringBuilder sb = new StringBuilder();
			
			sb.append("[");
				lat = Math.random() * (maxLat-minLat)+minLat; 
				lon = Math.random() * (maxLon-minLon)+minLon; 
				sb.append(lat+","+lon);
			sb.append("]");
			
			salida.println(sb.toString());
			salida.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				sc.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	

}
