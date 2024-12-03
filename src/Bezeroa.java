import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Bezeroa {

    private Socket socket;
    BufferedReader in; //sarrerko fluxua
    PrintWriter out; //irteerako fluxua

    public Bezeroa(Socket socket) throws IOException {
        this.socket = socket;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);//autoFlush zuzenean bidaltzen du mezua.
    }

    public boolean konektatutaDago(){
        return !socket.isClosed();
    }

}
