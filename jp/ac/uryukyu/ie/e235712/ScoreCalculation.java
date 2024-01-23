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

    public static int ork = -1;

    public static Integer questionA(String[] args) {
        
        while (ork != 0 && ork != 1) {
            Scanner scannerOrk = new Scanner(System.in);
            System.out.print("親か子か入力してください（親なら0、子なら1と入力）: ");
            ork = scannerOrk.nextInt();
            if (ork != 0 && ork != 1) {
                System.out.println("正しい値を入力してください。");
            }
        }
        return ork;
    }
    public static String questionB(String[] args, int ork) {
        // 飜数と符の入力を受け取る
        Scanner scanner = new Scanner(System.in);
        int han = 0;
        int fu = 20;
        int pinfu = 0;
        int titoi = 0;
        int kron = 0;
        int ron = 0;
        int kmati = 0;
        int mati = 0;
        int zyanto = 0;
        int kzyanto = 0;
        int n_minko = 0;
        int y_minko = 0;
        int n_anko = 0;
        int y_anko = 0;
        int n_minkan = 0;
        int y_minkan = 0;
        int n_ankan = 0;
        int y_ankan = 0;

        // 得点計算
        String totalPoints = null;
        while (totalPoints == null) {
            System.out.print("飜数を入力してください: ");
            han = scanner.nextInt();
            if (han >= 5){
                totalPoints = calculatePoints(ork, han, fu);
                System.out.println("得点: " + totalPoints);
            }else if(han <= 4){
                System.out.print("平和を含みますか？（含むなら1と入力、含まないならそれ以外の数字を入力）: ");
                pinfu = scanner.nextInt();
                if (pinfu == 1){
                    fu += 0;
                    totalPoints = calculatePoints(ork, han, fu);
                    System.out.println("得点: " + totalPoints);
                } else if(pinfu != 1) {
                    System.out.print("七対子を含みますか？（含むなら1と入力、含まないならそれ以外の数字を入力）: ");
                    titoi = scanner.nextInt();
                    if (titoi == 1){
                        fu += 5;
                        totalPoints = calculatePoints(ork, han, fu);
                        System.out.println("得点: " + totalPoints);
                    } else if (pinfu != 1 & titoi != 1){
                        System.out.print("どうアガリましたか？:(数字を入力):1 門前ロン / 2 門前ツモ / 3 副露ロン / 4 副露ツモ:");
                        kron = scanner.nextInt();
                        if(kron == 1){
                        ron = 10;
                        } else if(kron == 2){
                        ron = 2;
                        } else if(kron == 3){
                        ron = 0;
                        } else if(kron == 4){
                        ron = 2;
                        }
                        System.out.print("待ち牌は両面・双碰待ち以外ですか？(両面・双碰待ち以外なら1と入力、そうでないならそれ以外の数字を入力): ");
                        kmati = scanner.nextInt();
                        if (kmati == 1){
                            mati += 2;
                        }
                        System.out.print("雀頭は役牌ですか？(役牌なら1と入力、そうでないならそれ以外の数字を入力): ");
                        kmati = scanner.nextInt();
                        if (kzyanto == 1){
                            zyanto += 2;
                        }
                        System.out.print("中張牌の明刻は何個ですか？: ");
                        n_minko = scanner.nextInt() * 2;
                        System.out.print("么九牌の明刻は何個ですか？: ");
                        y_minko = scanner.nextInt() * 4;
                        System.out.print("中張牌の暗刻は何個ですか？: ");
                        n_anko = scanner.nextInt() * 4;
                        System.out.print("么九牌の暗刻は何個ですか？: ");
                        y_anko = scanner.nextInt() * 8;
                        System.out.print("中張牌の明槓は何個ですか？: ");
                        n_minkan = scanner.nextInt() * 8;
                        System.out.print("么九牌の明槓は何個ですか？: ");
                        y_minkan = scanner.nextInt() * 16;
                        System.out.print("中張牌の暗槓は何個ですか？: ");
                        n_ankan = scanner.nextInt() * 16;
                        System.out.print("么九牌の暗槓は何個ですか？: ");
                        y_ankan = scanner.nextInt() * 32;
                        int Fu = fu + ron + mati + zyanto + n_minko + y_minko + n_anko + y_anko + n_minkan + y_minkan + n_ankan + y_ankan;
                        int lastfu = ((Fu + 9) / 10) * 10;
                        totalPoints = calculatePoints(ork, han, lastfu);
                        System.out.println("得点: " + totalPoints);
                    }
                }
            }
        }return totalPoints; 
    }
    
  

    // 得点計算メソッド
    private static String calculatePoints(int ork, int han, int fu) {
           // 得点の計算
        String basePoints = "null";
        if (ork == 0 & han == 1 & fu == 20) {
            // 親の平和のみ一飜の場合
            basePoints = OyaOneMap.get(30);
        } else if (ork == 1 & han == 1 & fu == 20) {
            // 子の平和のみ一飜の場合
            basePoints = KoOneMap.get(30);
        } else if (ork == 0 & fu == 25) {
            // 親の七対子を含む場合
            basePoints = OyaTitoiMap.get(han);
        } else if (ork == 1 & fu == 25) {
            // 子の七対子を含む場合
            basePoints = KoTitoiMap.get(han);
        }else if (ork == 0 & han == 1) {
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
        }

        return basePoints;
    }
}
