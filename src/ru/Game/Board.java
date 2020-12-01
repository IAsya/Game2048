package ru.Game;

import java.util.*;
 public abstract class Board <K,V>{
    int weight;
    int height;
    Map  <K, V> board = new LinkedHashMap<>();
    
    Board(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }

    public abstract void fillBoard(List<V> list);
    
    public abstract List<K> availableSpace();
    
    public abstract void addItem(K key, V value);
    
    public abstract K getKey(int i, int j);
    
    public abstract V getValue(K key);
    
    public abstract List<K> getColumn(int j);
    
    public abstract List<K> getRow(int i);
    
    public abstract boolean hasValue(V value);
    
    public abstract List<V> getValues(List<K> keys);




 }
