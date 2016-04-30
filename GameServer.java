import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
public class GameServer extends Thread{
private InetAddress ipAddress;
private DatagramSocket socket;
private Tennis tennis;
public GameServer(Tennis tennis){
this.tennis=tennis;
try {
this.socket=new DatagramSocket(1331);
} catch (SocketException e) {
// TODO Auto-generated catch block
e.printStackTrace();
} 
}
public void run() {
while (true) {
byte[] data = new byte[1024];
DatagramPacket packet = new DatagramPacket(data,data.length);
try {
socket.receive(packet);
//System.out.println(new String(packet.getData()));
} catch (IOException e) {
e.printStackTrace();
}
String message = new String(packet.getData());
System.out.println("CLIENT> "+message); 
double d = Double.parseDouble(message);
this.tennis.p3.x=d;
sendData(("bx"+this.tennis.b1.x).getBytes(),packet.getAddress(),packet.getPort());
sendData(("by"+this.tennis.b1.y).getBytes(),packet.getAddress(),packet.getPort());
sendData(("px"+this.tennis.p4.x).getBytes(),packet.getAddress(),packet.getPort());
}
}
public void sendData(byte[] data, InetAddress ipAddress, int port) {
DatagramPacket packet = new DatagramPacket(data, data.length, ipAddress, port); //any port above 1024
try {
socket.send(packet);
} catch (IOException e) {
e.printStackTrace();
}
}

}