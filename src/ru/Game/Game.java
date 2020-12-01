package ru.Game;

interface Game {
    public void init();
    
    public boolean canMove();
    
    public void move(Direction direction) throws GameOverException;
    
    public void addItem() throws GameOverException;
    
    public Board getGameBoard();
    
    public boolean hasWin();

}
