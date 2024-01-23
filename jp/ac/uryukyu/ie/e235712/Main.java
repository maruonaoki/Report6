package jp.ac.uryukyu.ie.e235712;

public class Main {
    public static void main(String[] args) {
        // ScoreCalculationクラスのインスタンスを作成
        ScoreCalculation scoreCalculation = new ScoreCalculation();

        // 質問Aの呼び出し
        int ork = scoreCalculation.questionA(args);

        // 質問Bの呼び出し
        String result = scoreCalculation.questionB(args, ork);

    }
}