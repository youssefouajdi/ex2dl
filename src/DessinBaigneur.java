import java.io.IOException;
import java.io.Reader;

public class DessinBaigneur implements Runnable{
    private Reader in;
    private int fin;
    public DessinBaigneur(Reader in) {
        this.in= in;
        fin=0;
    }

    @Override
    public void run() {
        //recuperer les informations du baigneur
        String information="";
        while(fin==0){
            //afficher l ensemble des informations
            try {
                information=information+"\n"+ AutreInfo();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                System.out.println("information sur les baigneur "+"\n"+"le baigneur n°"+in.read()+" est dans l etat "+in.read());
            } catch (IOException e) {
                System.out.println("fin de la transmission des information pour ce baigneur");
            }
        }
    }

    private String AutreInfo() throws IOException {
        char c='.';
        String s="";
        do{
            try {
                c=(char) in.read();
            }catch (Exception e){
                System.out.println("toute les informations sont transmises");
                fin=1;
                return "fin";
            }
            if(c!='.'){
                s=s+c;
            }

        }while(c!='.');
        try{
            return "message"+in.read();
        }catch (Exception e){
            e.getMessage();
            return "fin";
        }
    }
}
