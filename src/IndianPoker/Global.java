/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IndianPoker;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author monoitatsuya
 */
public class Global {
    
    //参加者がキーで、持っている数字がバリューとなっているマップ
    public static HashMap<String, Integer> answer = new HashMap<>();
    
    //回答する順番に参加者が格納された配列
    public static ArrayList<String> members = new ArrayList<>();
    
    //回答した人が格納された配列
    public static ArrayList<String> answeredList = new ArrayList<>();
}
