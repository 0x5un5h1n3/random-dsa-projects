package dsa_day_03;

import java.util.ArrayList;

public class B {

    public static void main(String[] args) {

        ArrayList list1 = new ArrayList();
        list1.add("User1");
        list1.add("User2");
        list1.add("User3");

        ArrayList list2 = new ArrayList();
        list2.add("User1");
        list2.add("User2");
        list2.add("User3");
        
        //Equalance Testing on List
        
        if(list1.equals(list2)){
            System.out.println("List.equals True");
        }else{
            System.out.println("List.equals False");
        }
    }
}
