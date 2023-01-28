public class Challenge4 {

    static boolean gameOver;
    static int levelCompleted = 0;
    static int bonus  = 0;
    static int score = 0;

    public static void main(String[] args) {
        if(gameOver){
            int finalScore = score + (levelCompleted * bonus);
            System.out.println("Your final score was "+ finalScore);
        }

        levelCompleted = 8;
        bonus  = 200;
        score = 10000;

    }
}
