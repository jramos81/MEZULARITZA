import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

//bezeroekin konexioa mantentzeko zerbitzaria
public class Zerbitzaria {

    private ServerSocket socket;//es la clase JAVA que permite establecer un servicio que reciba
                                //conexiones a taves de otros sockets cliente.
    private int puerto;//entzuteko erabiliko dugun portua.
    private ArrayList<Bezeroa> bezeroak; //Bezeroak gordetzen joateko arrayList bat.

    public Zerbitzaria(int puerto){
        this.puerto = puerto;
        bezeroak=new ArrayList<>();
    }
    public void hasi() throws IOException {
        socket=new ServerSocket(puerto);//Establecemos el socket en el puerto indicado.
    }
    public void itxi() throws IOException {
        socket.close(); //itxi socketa.
    }
    public boolean konektatuta(){
        return !socket.isClosed();//Socket itxita edo irekita dagoen bueltatuko dugu.
    }
    public Socket onartuKonexioa() throws IOException {
        return socket.accept();//entzuten ditu bezeroekin konexioak eta bat jasotzerakoan bueltzatzen du Socketa bezero horrekin.

    }
    public void gehituBezeroa(Bezeroa bezero) {
        bezeroak.add(bezero);
    }
    public void bidaliMezuaDenei(String mezua){
        for(Bezeroa bezeroa:bezeroak){
            bezeroa.out.println(mezua);
        }
    }
}
