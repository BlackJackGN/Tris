package Tris.packages.logical;
import Tris.packages.tools.*;

import java.util.*;
public class Game{
    private Board board;

    public Game() {
        this.board = new Board();
        SetNewGame();
    }

    private void SetNewGame(){
        Scanner s=new Scanner(System.in);
        String name,ans;
        System.out.println("Inserire il nome del giocatore: ");
        name=s.nextLine();
        System.out.println("Se si desidera giocare da secondo inserire una risposta: ");
        ans=s.nextLine();
        PlayableItem hItem=null,botItem=null;
        if(ans.isEmpty()){
            hItem=new PlayableItem("Cross", true);
            botItem=new PlayableItem("Circle",false);
        }else{
            botItem=new PlayableItem("Cross", true);
            hItem=new PlayableItem("Circle",false);
        }
        AbstractPlayer playerOne=new HumanPlayer(name,hItem);
        AbstractPlayer playerTwo=new BotPlayer("Bot",botItem);
        int turncount=0;
        while(turncount<9&&checkWinner(playerOne,playerTwo)==0){
            makeTurn(turncount,ans.isEmpty(),playerOne,playerTwo);
            turncount++;
        }
        System.out.println("La partita si conclude con un pareggio, grazie per aver giocato!");
    }

    private void makeTurn(int turncount,boolean ans, AbstractPlayer playerOne, AbstractPlayer playerTwo){
        if(ans){
            if(turncount%2==0){
                System.out.println("E' il tuo turno, ora devi fare una mossa!");
                board=actTurn(playerOne,board);
            }else{
                System.out.println("E' il turno del Bot, tocca a lui fare una mossa!");
                board=actTurn(playerTwo,board);
            }
        }else{
            if(turncount%2==0){
                System.out.println("E' il turno del Bot, tocca a lui fare una mossa!");
                board=actTurn(playerTwo,board);
            }else{
                System.out.println("E' il tuo turno, ora devi fare una mossa!");
                board=actTurn(playerOne,board);
            }
        }
    }
    private Board actTurn(AbstractPlayer player, Board board){
        Turn turn=new Turn(player,board);
        return turn.placeItem();
    }

    private int checkWinner(AbstractPlayer playerOne, AbstractPlayer playerTwo){
        if(winningPosition(playerOne)){
            System.out.println("Complimenti, hai vinto battendo il bot con un tris!");
            return 1;
        }
        if(winningPosition(playerTwo)){
            System.out.println("Vittoria del bot, ha fatto tris prima di te!");
            return -1;
        }
        return 0;
    }

    private boolean winningPosition(AbstractPlayer player){
        PlayableItem[][] items=board.getBoard();
        if(items[0][0].isAssigned()==items[0][1].isAssigned()==items[0][2].isAssigned()==player.getSymbol().isAssigned()){
            return true;
        }
        if(items[1][0].isAssigned()==items[1][1].isAssigned()==items[1][2].isAssigned()==player.getSymbol().isAssigned()){
            return true;
        }
        if(items[2][0].isAssigned()==items[2][1].isAssigned()==items[2][2].isAssigned()==player.getSymbol().isAssigned()){
            return true;
        }
        if(items[0][0].isAssigned()==items[1][0].isAssigned()==items[2][0].isAssigned()==player.getSymbol().isAssigned()){
            return true;
        }
        if(items[0][1].isAssigned()==items[1][1].isAssigned()==items[2][1].isAssigned()==player.getSymbol().isAssigned()){
            return true;
        }
        if(items[0][2].isAssigned()==items[1][2].isAssigned()==items[2][2].isAssigned()==player.getSymbol().isAssigned()){
            return true;
        }
        if(items[0][0].isAssigned()==items[1][1].isAssigned()==items[2][2].isAssigned()==player.getSymbol().isAssigned()){
            return true;
        }
        if(items[0][2].isAssigned()==items[1][1].isAssigned()==items[2][0].isAssigned()==player.getSymbol().isAssigned()){
            return true;
        }
        return false;
    }
}