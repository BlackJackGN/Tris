import Tris.packages.logical.Game;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("Ciao, vuoi giocare una partita a Tris?");
        String risp=s.nextLine();
        if(risp.equalsIgnoreCase("si")||risp.equalsIgnoreCase("ok")){
            do{
                Game game=new Game();
            }while(risp.equalsIgnoreCase("si")||risp.equalsIgnoreCase("ok"));
        }
    }
}