public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if (s == null) return 0;

        s = s.trim();
        String[] words = s.split(" ");
        if (words.length == 0) return 0;
        return words[words.length - 1].length();
    }
}