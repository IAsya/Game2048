package ru.Game;

import java.util.*;

public class SquareBoard<V> extends Board <Key, V> {
    int size;
    
    SquareBoard(int size) {
        super(size, size);
        this.size = size;
    }
    
    public void fillBoard(List<V> list)  {
        if (list.size() != size*size)
            throw new IllegalArgumentException();
        for (int i = 0; i < size; i++) {
            for (int j =0; j < size; j++)
                board.put(new Key(i,j),list.get(i*size+j));
        }
    }
    
    public List<Key> availableSpace() {
        ArrayList <Key> freeSpace = new ArrayList <Key>();
        Iterator<Map.Entry<Key, V>> entries = board.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<Key, V> entry = entries.next();
            if (entry.getValue() == null)
                freeSpace.add(entry.getKey());
        }
        return freeSpace;
    }
    
    public void addItem(Key key, V value) {
        board.put(key, value);
    }
    
    public Key getKey(int i, int j) {
        Iterator<Map.Entry<Key, V>> entries = board.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<Key, V> entry = entries.next();
            if ((entry.getKey().getI() == i) && (entry.getKey().getJ() == j)) {
                return entry.getKey();
            }
        }
        return null;
    }
    
    public V getValue(Key key) {
        return board.get(key);
    }
    
    public List<Key> getColumn(int j) {
        ArrayList <Key> column = new ArrayList <Key>();
        Iterator<Map.Entry<Key, V>> entries = board.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<Key, V> entry = entries.next();
            if (entry.getKey().getJ() == j)
                column.add(entry.getKey());
        }
        return column;
    }
    
    public List<Key> getRow(int i) {
        ArrayList <Key> raw = new ArrayList <Key>();
        Iterator<Map.Entry<Key, V>> entries = board.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<Key, V> entry = entries.next();
            if (entry.getKey().getI() == i)
                raw.add(entry.getKey());
        }
        return raw;
    }
    
    public boolean hasValue(V value) {
        return board.containsValue(value);
    }
    
    public List<V> getValues(List<Key> keys) {
        ArrayList <V> boardValues = new ArrayList <>();
        Iterator<Key> keyIterator = keys.iterator();
        while(keyIterator.hasNext()){
            Key iterationKey = keyIterator.next();
            if (board.containsKey(iterationKey)) {
                boardValues.add(board.get(iterationKey));
            }
        }
        return boardValues;
    }
}
