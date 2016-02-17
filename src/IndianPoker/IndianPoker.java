/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IndianPoker;

import java.util.ArrayList;

/**
 *
 * @author monoitatsuya
 */
public class IndianPoker {

    public static void main(String[] args) {
        
        //人数を取得
        int peopleNum = args.length;
        
        //引数を環境クラスにセットする。
        for(int i=0; i<peopleNum; i++){
            String name = args[i].substring(0, 1);
            String num = args[i].substring(2,3);
            Global.answer.put(name, Integer.parseInt(num));
            Global.members.add(name);
        }
        
        //人オブジェクトを一人ずつ作成する
        ArrayList<Human> humans = new ArrayList<>();
        for (int i=0; i<peopleNum; i++){
            Human human = new Human();
            String myName = Global.members.get(i);
            
            human.setName(myName);
            
            //自分が見ている状況をインプットする
            for (String key : Global.answer.keySet()) {
                //自分以外をviewマップに代入
                if (key != myName){
                    human.getMyViewList().set( Global.answer.get(key), key );
                }
            }
            
            humans.add(human);
        }
        
        //一人ずつ回答を考える
        String result = "?";
        int limit = 0;
        for (int i=0; "?".equals(result); i++){
            
            if ( i == humans.size() ){
                i = 0;
                limit++;
                if (limit == 2){
                    break;
                }
            }
            
//            System.out.println("--------" + humans.get(i).getName() + "のターン--------");
            result = humans.get(i).think();
            Global.answeredList.add( humans.get(i).getName() );
            System.out.println(humans.get(i).getName() + " =>" + result + " ");
        }

    }
    
}
