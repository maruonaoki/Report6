package jp.ac.uryukyu.ie.e235712;

import java.util.Map;
import java.util.Scanner;

public class ScoreCalculation {

    // 点数を保存したMap
    private static Map<Integer, String> OyaOneMap = Map.of(
        30, "500オール",40, "700オール",50, "800オール",60, "1000オール",70, "1200オール",80, "1300オール",90, "1500オール",100, "1600オール",110, "1800オール"
    );

    private static Map<Integer, String> OyaTwoMap = Map.of(
        20, "700オール", 30, "1000オール",40, "1300オール",50, "1600オール",60, "2000オール",70, "2300オール",80, "2600オール",90, "2900オール",100, "3200オール",110, "3600オール"
    );

    private static Map<Integer, String> OyaThreeMap = Map.of(
        20, "1300オール",30, "2000オール",40, "2600オール",50, "3200オール",60, "3900オール"
    );

    private static Map<Integer, String> OyaFourMap = Map.of(
        20, "2600オール",30, "3900オール"
    );

    private static Map<Integer, String> OyaOverFiveMap = Map.of(
        5, "満貫4000オール",6, "跳満6000オール",7, "跳満6000オール",8, "倍満8000オール",9, "倍満8000オール",10, "倍満8000オール",11, "三倍満12000オール",12, "三倍満12000オール",13, "数え役満16000オール"
    );

    private static Map<Integer, String> OyaTitoiMap = Map.of(
        2, "800オール",3, "1600オール",4, "3200オール"
    );

    private static Map<Integer, String> KoOneMap = Map.of(
        30, "300・500",40, "400・700",50, "400・800",60, "500・1000",70, "600・1200",80, "700・1300",90, "800・1500",100, "800・1600",110, "900・1800"
    );

    private static Map<Integer, String> KoTwoMap = Map.of(
        20, "400・700", 30, "500・1000",40, "700・1300",50, "800・1600",60, "1000・2000",70, "1200・2300",80, "1300・2600",90, "1500・2900",100, "1600・3200",110, "1800・3600"
    );

    private static Map<Integer, String> KoThreeMap = Map.of(
        20, "700・1300",30, "1000・2000",40, "1300・2600",50, "1600・3200",60, "2000・3900"
    );

    private static Map<Integer, String> KoFourMap = Map.of(
        20, "1300・2600",30, "2000・3900"
    );

    private static Map<Integer, String> KoOverFiveMap = Map.of(
        5, "満貫2000・4000",6, "跳満3000・6000",7, "跳満3000・6000",8, "倍満4000・8000",9, "倍満4000・8000",10, "倍満4000・8000",11, "三倍満6000・12000",12, "三倍満6000・12000オール",13, "数え役満8000・16000"
    );

    private static Map<Integer, String> KoTitoiMap = Map.of(
        2, "400・800",3, "800・1600",4, "1600・3200"
    );

    public static void main(String[] args) {
        // 飜数と符の入力を受け取る
        Scanner scanner = new Scanner(System.in);
        System.out.print("親か子か入力してください（親なら0子なら1と入力）: ");
        int ork = scanner.nextInt();
        System.out.print("飜数を入力してください: ");
        int han = scanner.nextInt();
        System.out.print("符を入力してください: ");
        int fu = scanner.nextInt();

        // 得点計算
        String totalPoints = calculatePoints(ork, han, fu);

        // 結果を出力
        System.out.println("得点: " + totalPoints);
    }

    // 得点計算メソッド
    private static String calculatePoints(int ork, int han, int fu) {
        // 飜数と符に対応する得点を格納したMap
   

        // 得点の計算
        String basePoints = "i";
        if (ork == 0 & han == 1) {
            // 親の一飜の場合
            basePoints = OyaOneMap.get(fu);
        } else if (ork == 0 & han == 2) {
            // 親の二飜の場合
            basePoints = OyaTwoMap.get(fu);
        } else if (ork == 0 & han == 3) {
            // 親の三飜の場合
            basePoints = OyaThreeMap.get(fu);
        } else if (ork == 0 & han == 4) {
            // 親の四飜の場合
            basePoints = OyaFourMap.get(fu);
        } else if (ork == 0 & han >= 5) {
            // 親の五飜以上の場合
            basePoints = OyaOverFiveMap.get(han);
        } else if (ork == 0 & fu == 25) {
            // 親の七対子を含む場合
            basePoints = OyaTitoiMap.get(han);
        } else if (ork == 1 & han == 1) {
            // 子の一飜の場合
            basePoints = KoOneMap.get(fu);
        } else if (ork == 1 & han == 2) {
            // 子の二飜の場合
            basePoints = KoTwoMap.get(fu);
        } else if (ork == 1 & han == 3) {
            // 子の三飜の場合
            basePoints = KoThreeMap.get(fu);
        } else if (ork == 1 & han == 4) {
            // 子の四飜の場合
            basePoints = KoFourMap.get(fu);
        } else if (ork == 1 & han >= 5) {
            // 子の五飜以上の場合
            basePoints = KoOverFiveMap.get(han);
        } else if (ork == 1 & fu == 25) {
            // 親の七対子を含む場合
            basePoints = OyaTitoiMap.get(han);
        }


        return basePoints;
    }
}