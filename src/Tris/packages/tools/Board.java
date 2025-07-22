package Tris.packages.tools;

public class Board {
    private PlayableItem[][] board;

    public Board() {
        board=new PlayableItem[3][3];
        createBoard();
    }

    public PlayableItem[][] getBoard() {
        return board;
    }

    private void createBoard(){
        for(int rows=0;rows<3;rows++){
            for(int cols=0;cols<3;cols++){
                board[rows][cols]=null;
            }
        }
    }

    public boolean posEmpty(int x, int y){
        return board[x][y] == null;
    }

    public void fillPos(int x, int y, PlayableItem item){
        item.row=x;
        item.col=y;
        board[x][y]=item;
    }
}