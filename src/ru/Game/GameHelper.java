package ru.Game;

import java.util.*;
 
 public class GameHelper {

    public List<Integer> moveAndMergeEqual(List<Integer> list) {
        int nullCount = 0;
        ArrayList <Integer> changedList = new ArrayList <Integer>(list);

        Comparator<Integer> cmp=new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 != null && o2 == null) return -1;
                else if (o1 == null && o2 != null) return 1;
                else return 0;
            }
        };

        Collections.sort(changedList, cmp);
       for (int i = 0; i < changedList.size() - 1 ; i ++) {
           if (changedList.get(i) != null) {
               if (changedList.get(i).equals(changedList.get(i + 1))) {
                   changedList.set(i, changedList.get(i) * 2);
                   changedList.set(i + 1, null);
                   i++;
               }
           }

        }
        Collections.sort(changedList, cmp);

        return changedList;
    }
 }
