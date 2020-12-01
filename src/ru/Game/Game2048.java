package ru.Game;

import java.util.*;

public class Game2048 implements Game {
    public static final int GAME_SIZE = 4;
    public static final int WIN_NUMBER = 2048;

    GameHelper helper = new GameHelper();
    
    private final Board<Key, Integer> board = new SquareBoard<>(GAME_SIZE);


    Random random = new Random();
    
    //Game2048(Board initBoard) {
     //   this.board = initBoard;
    //}
    
    public void init() {
        List<Integer> values = new ArrayList(GAME_SIZE * GAME_SIZE);
        for (int i = 0; i < GAME_SIZE * GAME_SIZE; i++) values.add(null);
        board.fillBoard(values);
        try {
            addItem();
            addItem();
        }
        catch (GameOverException e) {
            return;
        }

    }
    
    public boolean canMove() {

        return board.availableSpace().size() > 0;
    }
    
    public void move(Direction direction) throws GameOverException {
        if (!canMove())
            throw new GameOverException("There is no available space");
        switch (direction) {
            case DOWN:
                moveDown();
                addItem();
                break;
            case UP:
                moveUp();
                addItem();
                break;
            case RIGHT:
                moveRight();
                addItem();
                break;
            case LEFT:
                moveLeft();
                addItem();
                break;
        }
    }

    private void moveLeft() {
        GameHelper gameHelper = new GameHelper();
        for (int i = 0 ; i < GAME_SIZE; i++) {
            List <Key> boardRowsKeys = board.getRow(i);
            List <Integer> mergedValues = gameHelper.moveAndMergeEqual(board.getValues(boardRowsKeys));
            for (int j = 0; j < mergedValues.size(); j ++) {
                board.addItem(board.getKey(i,j),mergedValues.get(j));
            }
        }
    }

    private void moveRight() {
        GameHelper gameHelper = new GameHelper();
        for (int i = 0 ; i < GAME_SIZE; i++) {
            List <Key> boardRowsKeys = board.getRow(i);
            List<Integer> boardRowsValues = board.getValues(boardRowsKeys);
            Collections.reverse(boardRowsValues);
            List <Integer> mergedValues = gameHelper.moveAndMergeEqual(boardRowsValues);
            Collections.reverse(mergedValues);
            for (int j = 0; j < mergedValues.size(); j ++) {
                board.addItem(board.getKey(i,j),mergedValues.get(j));
            }
        }
    }

    private void moveUp() {
        GameHelper gameHelper = new GameHelper();
        for (int j = 0 ; j < GAME_SIZE; j++) {
            List <Key> boardColumnKeys = board.getColumn(j);
            List <Integer> mergedValues = gameHelper.moveAndMergeEqual(board.getValues(boardColumnKeys));
            for (int i = 0; i < mergedValues.size(); i ++) {
                board.addItem(board.getKey(i,j),mergedValues.get(i));
            }
        }
    }

    private void moveDown() {
        GameHelper gameHelper = new GameHelper();
        for (int j = 0 ; j < GAME_SIZE; j++) {
            List <Key> boardColumnKeys = board.getColumn(j);
            List <Integer> boardColumnValues = board.getValues(boardColumnKeys);
            Collections.reverse(boardColumnValues);
            List <Integer> mergedValues = gameHelper.moveAndMergeEqual(boardColumnValues);
            Collections.reverse(mergedValues);
            for (int i = 0; i < mergedValues.size(); i ++) {
                board.addItem(board.getKey(i,j),mergedValues.get(i));
            }
        }
    }

    public void addItem() throws GameOverException {
        if (!canMove()) {
            throw new GameOverException("There is no available space before checking");
        }
        final Random random = new Random();
        int newItem = random.nextInt(10) > 0 ? 2 : 4;
        List <Key> availableSpace = board.availableSpace();
        int newIndex = random.nextInt(availableSpace.size());
        board.addItem(availableSpace.get(newIndex),newItem);
    }
    
    public Board getGameBoard() {
        return board;
    }
    
    public boolean hasWin() {
        return board.hasValue(WIN_NUMBER);
    }
    
}
