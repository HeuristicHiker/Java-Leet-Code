import java.util.HashSet;
import java.util.Set;

public class SubString {
    public static void main(String[] args) {
        String example = "abcabcbb";
        lengthOfLongestSubstring(example);
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;

        Set<Character> setOfCharacters = new HashSet<>();
        int left = 0;

        for(int right = 0; right < n; right++) {
            setOfCharacters.add(s.charAt(right));
            System.out.println(setOfCharacters);
        }

        return setOfCharacters.toArray().length;

    }

    public static int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        int maxLength = 0;
        Set<Character> charSet = new HashSet<>();
        int left = 0;

        for (int right = 0; right < n; right++) {
            System.out.println(charSet);
            if (!charSet.contains(s.charAt(right))) {
                charSet.add(s.charAt(right));
                maxLength = Math.max(maxLength, right - left + 1);
            } else {
                while (charSet.contains(s.charAt(right))) {
                    charSet.remove(s.charAt(left));
                    left++;
                }
                charSet.add(s.charAt(right));
            }
        }

        return maxLength;
    }
}
