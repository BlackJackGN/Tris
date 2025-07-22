package Tris.packages.tools;
import java.util.Random;
public class BotPlayer extends AbstractPlayer{
    public BotPlayer(String name, PlayableItem p) {
        super(name, p);
    }
    public int[] getMove(){
        Random r=new Random();
        int x=r.nextInt(3);
        int y=r.nextInt(3);
        return new int[]{x,y};
    }
}