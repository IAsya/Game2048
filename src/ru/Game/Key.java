package ru.Game;

import java.util.Objects;

public class Key {
    int i; 
    int j; 
    
    Key (int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Key key = (Key) o;
        return i == key.i &&
                j == key.j;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i, j);
    }

    @Override
    public String toString() {
        return i + ":" + j;
    }
    public void setI (int i) {
        this.i = i;
    }
    
    public int getI () {
        return i;
    }
    
    public void setJ (int j) {
        this.j = j;
    }
    
    public int getJ () {
        return j;
    }
    
}
