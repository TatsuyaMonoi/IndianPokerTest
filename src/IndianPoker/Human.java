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
public class Human {
    
    private String name;
    
    /**
     * 自分から見える他の人の数字を格納した配列
     * 自分の可能性がある箇所はnull
     * 自分の可能性がない箇所は"empty"
     */
    private ArrayList<String> myViewList;
    
    public Human() {
        //リストを初期化
        myViewList = new ArrayList<>();
        for (int i=0; i<=Env.MAX_NUMBER; i++){
            myViewList.add(null);
        }
    }
    
    //自分の場所を考える
    public String think() {

        //消去法で考える
        eliminateMyNumber( Global.answeredList.size() );
        
//        System.out.println("＜最終的な視界＞");
//        for (int i=1; i<=Env.MAX_NUMBER; i++){
//            System.out.print( myViewList.get(i) + " ");
//        }
//        System.out.println();

        //結論を出す
        return makeDecision();
    }
    
    //消去法で自分の位置を減らしていく
    public void eliminateMyNumber(int answeredNum) {
        
        //最初の回答者から順に考えを追う
        for (int j=0; j<answeredNum; j++) {
            String hisName = Global.answeredList.get(j);
            Human human = new Human();
            human.setName(hisName);
            
            //その人が見ている状況をインプットする
            for (int i=1; i<myViewList.size(); i++) {
                //その人以外をviewListに代入
                String humanName = myViewList.get(i);
                if (humanName != null && !humanName.equals(hisName) && !"empty".equals(humanName)){
                    human.getMyViewList().set(i, humanName);
                }
            }

            for (int i=1; i<=Env.MAX_NUMBER; i++){

                //i番目の数字を持っている人がすでにいる場合は飛ばす。
                if (myViewList.get(i) == null){
                    human.getMyViewList().set(i, name);
//                    System.out.println("view by" + hisName + " " + name + "=" + i);
                    human.eliminateMyNumber(j);
                    String result = human.makeDecision();
                    if (!"?".equals(result)) {
                        myViewList.set(i, "empty");
                    }
                    human.getMyViewList().set(i, null);
                }
            }
        }
    }
    
    //結論を出す
    public String makeDecision() {
        ArrayList<Integer> checkList = new ArrayList<>();
        
        //nullの箇所を0 それ以外は1
        for (int i=1; i<=Env.MAX_NUMBER; i++){
            if( myViewList.get(i) == null){
                checkList.add(0);
            } else if ( !"empty".equals( myViewList.get(i) ) ){
                checkList.add(1);
            }
        }
        
//        for (int i=0; i<checkList.size(); i++){
//            System.out.print(checkList.get(i));
//        }
//        System.out.println("");
        
        //0と1が連続している場合まとめる
        for (int i=1; i<checkList.size(); i++){
            if ( checkList.get(i-1) == checkList.get(i) ){
                checkList.remove(i);
                i--;
            }
        }
        
//        for (int i=0; i<checkList.size(); i++){
//            System.out.print(checkList.get(i));
//        }
//        System.out.println("");
        
        //nullがひとつの場所に固まっていれば自分の順位がわかる。
        if ( checkList.size() == 2 ) {
            if ( checkList.get(0) == 0 ) {
                return "MIN";
            }
            if ( checkList.get(0) == 1 ) {
                return "MAX";
            }
        }
        else if ( checkList.size() == 3 ) {
            if ( checkList.get(0) == 1 ) {
                return "MID";
            }
        }
        
        return "?";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public ArrayList<String> getMyViewList() {
        return myViewList;
    }

    public void setMyViewList(ArrayList<String> myViewList) {
        this.myViewList = myViewList;
    }
    
    
}
