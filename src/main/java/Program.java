import java.util.ArrayList;
import java.util.List;

class Program {

    /**
     * Method which checks the amount of interesting words from an array.
     * A word is interesting if there are no other words which contain it as a subsequence.
     *
     * @param K     number of interesting words which is expected.
     * @param N     number of words from the array.
     * @param words array containing the words which will be checked.
     * @return one of "HIGHER", LOWER", "EQUAL", "INVALID VALUE FOR N" or "INVALID VALUE FOR K".
     */
    public String checkForInterestingWords(int N, int K, List<String> words) {
        int amount = 0;
        if (N < 1 || N != words.size() || N > 10) {
            return "INVALID VALUE FOR N";
        }

        if (K < 0 || K > N) {
            return "INVALID VALUE FOR K";
        }
        List<String> interestingWords = new ArrayList<>();
        for (int current = 0; current < N; ++current) {
            boolean isInteresting = true;
            for (int next = 0; next < N; ++next) {
                if (isSubsequence(words.get(next), words.get(current)) && current != next) {
                    isInteresting = false;
                    break;
                }
            }
            if (isInteresting) {
                interestingWords.add(words.get(current));
            }
        }

        amount = interestingWords.size();

        if (K < amount) {
            return "HIGHER";
        }
        if (K > amount) {
            return "LOWER";
        }
        return "EQUAL";
    }

    private boolean isSubsequence(String word, String subsequence) {
        int i = 0;
        int j = 0;

        while (i < word.length() && j < subsequence.length()) {
            if (word.charAt(i) == subsequence.charAt(j)) {
                j++;
            }
            i++;
        }

        return j == subsequence.length();
    }

}