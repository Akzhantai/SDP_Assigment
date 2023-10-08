class WinCounter implements Move {
    private final Move strategy;
    private int wins = 0;

    public WinCounter(Move strategy) {
        this.strategy = strategy;
    }

    public int getWins() {
        return wins;
    }

    @Override
    public String makeMove() {
        String move = strategy.makeMove();
        return move;
    }

    public void incrementWins() {
        wins++;
    }
}