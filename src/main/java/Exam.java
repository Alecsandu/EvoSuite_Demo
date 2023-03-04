public class Exam {

    public int grade(boolean cheated, int points) {
        if (points < 0 || points > 100) {
            throw new IllegalArgumentException("invalid points");
        }
        if (cheated) {
            return 5;
        }
        if (points >= 90) {
            return 1;
        }
        else if (points >= 75) {
            return 2;
        }
        else if (points >= 60) {
            return 3;
        }
        else if (points >= 50) {
            return 4;
        }
        else return 5;
    }

}
