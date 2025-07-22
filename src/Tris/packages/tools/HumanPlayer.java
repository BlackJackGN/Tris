package Tris.packages.tools;

import java.util.Scanner;

public class HumanPlayer extends AbstractPlayer{
    public HumanPlayer(String name, PlayableItem p) {
        super(name, p);
    }

    public int[] getMove(){
        Scanner s=new Scanner(System.in);
        int x=-1,y=-1;
        boolean test=false;
        while(!test){
            try{
                System.out.println("Inserire una posizione: x ed y");
                x=Integer.parseInt(s.nextLine());
                y=Integer.parseInt(s.nextLine());
                test=true;
            }catch(NumberFormatException ignored){
                System.out.println("Errore nella posizione!");
            }
        }
        return new int[]{x,y};
    }
}