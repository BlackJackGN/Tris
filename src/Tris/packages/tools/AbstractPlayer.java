package Tris.packages.tools;

public abstract class AbstractPlayer{
    protected String name;
    protected PlayableItem symbol;

    public AbstractPlayer(String name, PlayableItem symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public PlayableItem getSymbol() {
        return symbol;
    }

    public abstract int[] getMove();
}