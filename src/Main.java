import java.io.IOException;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        Zerbitzaria zerbitzaria=new Zerbitzaria(5555);//zerbitzaria sortzen dugu. Nahi dugun portuarekin
        try{
            zerbitzaria.hasi();
            //escuchar conexiones mientras este conectado el servidor. Por cada conexion que reciba,
            //lanzo un hilo y volvemos a empezar-
            while(zerbitzaria.konektatuta()){
                Socket bezeroarenSocketa =zerbitzaria.onartuKonexioa();
                Bezeroa bezero=new Bezeroa(bezeroarenSocketa);
                zerbitzaria.gehituBezeroa(bezero);
                BezeroenKonexioa konexioa=new BezeroenKonexioa(bezero,zerbitzaria);
                konexioa.start();
            }
        }catch(IOException ioe){
            ioe.printStackTrace();//Hobe sortzen den akatsa kudeatzea.
        }
    }
}
