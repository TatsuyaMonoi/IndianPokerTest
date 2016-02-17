/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IndianPoker;

import java.util.ArrayList;
import java.util.HashMap;
import org.junit.Test;

/**
 *
 * @author monoitatsuya
 */
public class IndianPokerTest {
    
    public IndianPokerTest() {
    }

    @Test
    public void testMain1() {
        Env.MAX_NUMBER = 5;
        Global.answer = new HashMap<>();
        Global.answeredList = new ArrayList<>();
        Global.members = new ArrayList<>();
        
        String[] args = {"A=1", "B=4", "C=5"};
        for (String arg : args) {
            System.out.print(arg + " ");
        }
        System.out.println("");
        IndianPoker.main(args);
        System.out.println("\n");
    }
    
    @Test
    public void testMain2() {
        Env.MAX_NUMBER = 5;
        Global.answer = new HashMap<>();
        Global.answeredList = new ArrayList<>();
        Global.members = new ArrayList<>();
        
        String[] args = {"A=1", "B=2", "C=4"};
        for (String arg : args) {
            System.out.print(arg + " ");
        }
        System.out.println("");
        IndianPoker.main(args);
        System.out.println("\n");
    }
    
    @Test
    public void testMain3() {
        Env.MAX_NUMBER = 7;
        Global.answer = new HashMap<>();
        Global.answeredList = new ArrayList<>();
        Global.members = new ArrayList<>();
        
        String[] args = {"A=1", "B=4", "C=5"};
        for (String arg : args) {
            System.out.print(arg + " ");
        }
        System.out.println("");
        IndianPoker.main(args);
    }
    
}
