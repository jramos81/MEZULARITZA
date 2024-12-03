import java.io.IOException;

//Bezero bat konektatzen den bakoitzean sortuko den haria.
public class BezeroenKonexioa extends Thread{

    private Bezeroa bezero;
    private Zerbitzaria zerbitzaria;

    public BezeroenKonexioa(Bezeroa bezero, Zerbitzaria zerbitzaria) {
        this.bezero = bezero;
        this.zerbitzaria = zerbitzaria;
    }
    @Override
    public void run() {
        //bezero bat konektatzen den bakoitzean
        bezero.out.println("Kaixo ongi etorri gure mezularitza zerbitzura!");
        try{
            while(bezero.konektatutaDago()){
                String mezua= bezero.in.readLine();//entzuten dut bezero horrek esandakoa
                zerbitzaria.bidaliMezuaDenei(mezua);//zerbitzariak bidaltzen du
                                                    //entzundako mezua bezero guztiei.
            }
        }catch (IOException ioe){
            ioe.printStackTrace();
        }


    }
}
