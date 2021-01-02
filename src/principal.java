import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.Scanner;

public class principal {
    static final  int place  = 3;
    public static void main(String args[]){
        try{
        //Creation du tube;
        PipedWriter out= new PipedWriter();
        PipedReader in ;
        //le nombre de panier de cabine dans votre la piscine de RockAndRollKhamlichi XD
            //une cabine pour se doucher qui est pleinne = un panier qui est plein
        Scanner sc = new Scanner(System.in);
        System.out.println("la piscine de RockAndRollKhamlichi dispose de : " + place+" panier est de "+place+" cabine");
        //et maitenant les meilleurs baigneurs
            // pour la meilleur piscine  :)
        System.out.println("Combien de Baigneur vou avez ");
        int baigneur  = sc.nextInt();
        in = new PipedReader(out);
        Baigneur[] b= new Baigneur[baigneur];
        DessinBaigneur[] db = new DessinBaigneur[baigneur];
        Thread[] thread_baigneur= new Thread[baigneur];
        Thread[] thread_dessinbaigneur= new Thread[baigneur];
        for (int i = 0; i < baigneur; i++) {
            b[i] = new Baigneur(i,out);
            db[i] = new DessinBaigneur(in);
            thread_baigneur[i]= new Thread(b[i]);
            thread_dessinbaigneur[i]= new Thread(db[i]);
            thread_baigneur[i].start();
            thread_dessinbaigneur[i].start();
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
