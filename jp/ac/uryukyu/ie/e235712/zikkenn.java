package jp.ac.uryukyu.ie.e235712;

import java.util.Map;

public class zikkenn {
    public static void main(String[] args) {
        //Mapを作成
        Map<Integer, String> OneMap = Map.of(
                30, "300・500",40, "400・700",50, "400・800",60, "500・1000",70, "600・1200",80, "700・1300",90, "800・1500",100, "800・1600",110, "900・1800"
        );
    

    
        // 結果を出力
        System.out.println(OneMap.get(30));
    }

    
}
