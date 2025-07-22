package Tris.packages.tools;

public class PlayableItem {
    String s;
    boolean assigned;
    int row;
    int col;

    public PlayableItem(String s, boolean assigned) {
        this.s = s;
        this.assigned = assigned;
        this.row=-1;
        this.col=-1;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public String getS() {
        return s;
    }

    public boolean isAssigned() {
        return assigned;
    }
}