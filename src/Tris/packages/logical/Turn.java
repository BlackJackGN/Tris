package Tris.packages.logical;
import Tris.packages.tools.*;
public class Turn {
    private final AbstractPlayer player;
    private Board board;

    public Turn(AbstractPlayer player, Board board) {
        this.player = player;
        this.board=board;
    }
    public Board placeItem(){
        int[] pos=player.getMove();
        while(!checkPos(pos)){
            System.out.println("Questa posizione non è selezionabile perchè è già piena!");
            pos=player.getMove();
        }
        board.fillPos(pos[0],pos[1],player.getSymbol());
        return board;
    }
    private boolean checkPos(int[] pos){
        for(int rows=0;rows<3;rows++){
            for(int cols=0;cols<3;cols++){
                if(board.posEmpty(pos[0],pos[1])){
                    return true;
                }
            }
        }
        return false;
    }
}