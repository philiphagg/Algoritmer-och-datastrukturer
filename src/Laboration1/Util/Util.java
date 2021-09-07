package Laboration1.Util;

import Laboration1.Uppgift4.CircularLinkedList;

public class Util {

    public static void printInfoCll(CircularLinkedList cll){
        if(cll.isEmpty()) {
            printEmptyListInfo(cll);
        }else{
            printListInfo(cll);
        }
    }

    private static void printListInfo(CircularLinkedList cll) {
        StringBuilder sb = new StringBuilder();
        sb.append("First: " + cll.getFirstData() + " Last: " + cll.getLastData() + " Size: " + cll.getSize());
        System.out.println(sb.toString());
    }

    private static void printEmptyListInfo(CircularLinkedList cll) {
        StringBuilder sb = new StringBuilder();
        sb.append("First: null" + " Last: null Size: " + cll.getSize());
        System.out.println(sb.toString());
    }


}
