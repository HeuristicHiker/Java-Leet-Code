public class Palindrome {
    public static void main (String[] args) {
//        System.out.println("-9669 isPalindrome? " + isPalindrome(-9669)); //true
//        System.out.println("707 isPalindrome? " + isPalindrome(707)); // true
//        System.out.println("3112213 isPalindrome? " + isPalindrome(3112213)); //false
//        System.out.println("1000 isPalindrome? " + isPalindrome(1000)); //false
//        System.out.println("log: "+Math.log10(1000));
//        System.out.println("24: "+sumFirstAndLastDigit(24));
        String answer = longestPalindromicSubstring("babab");
//        String answer2 = returnLongestPalindrome("a", 4);
        System.out.println("Answer: " + answer + " " + answer.length());
    }

    public static String longestPalindromicSubstring(String s) {
        if(s.length() < 1 || s == null) {
            return "";
        }
        String longestStr = "";
        int start = 0, end = 0;

        for(int i = 0; i < s.length(); i++) {
            int oddCheck = expandAroundCenter(s, i, i);
            int evenCheck = expandAroundCenter(s, i, i + 1);
            int len = Math.max(oddCheck, evenCheck);
            if (len > end - start) {
                start = i - (len -1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    public static int expandAroundCenter(String s, int left, int right) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static String returnLongestPalindrome(String s, int index) {
        if (index > s.length() - 1) return s;
        StringBuilder longestPalBuilder = new StringBuilder();
        longestPalBuilder.append(s.charAt(index));

        for(int i = 1; (index - i) >= 0 && (index + i) < s.length(); i++) {
            char leftMost = s.charAt(index - i);
            char middle = s.charAt(index);
            char rightMost = s.charAt(index + i);
            if(leftMost == rightMost) {
                longestPalBuilder.insert(0, leftMost).append(rightMost);
            } else if (i == 1 && leftMost == middle) {
                longestPalBuilder.insert(0, leftMost);
            } else {
                return longestPalBuilder.toString();
            }
            System.out.println("=== " + i + " ===");
            System.out.println(leftMost + " " + middle + " " + rightMost);
            System.out.println("--- " + s + " ---");
        }
        String longestPalStr = longestPalBuilder.toString();
        System.out.println("Found longest pal: " + longestPalStr);
        return longestPalStr;
    }

    public static int sumFirstAndLastDigit(int number) {
        if(number == 0) return 0;
        if (number < 0) return -1;
        int first = number % 10;
        int digits = (int) Math.log10(number);
        int divisor = (int) Math.pow(10,digits);
//        System.out.println("digits: "+digits+" divisor: "+divisor);
        int last = number / divisor;
        return first + last;
    }

    public static boolean isPalindrome(int number) {
        number = Math.abs(number);

        while(number > 0) {
            int latestDigit = number % 10;
            int numDigitsMin1 = (int) Math.log10(number);
            int divisor = (int) Math.pow(10,numDigitsMin1);
            int firstDigit = number / divisor;
            System.out.println(
                    "number: "+number+
                    " log10: "+firstDigit+
                    " digit: "+latestDigit+
                    " divisor "+divisor
            );
            if(latestDigit != firstDigit) return false;
            number -= firstDigit * divisor;
            number /= 10;
        }

        return true;
    }

    public static boolean isPalindromeBak(int number) {
//        int mod = 1;
        int reversedNumber = 0;
        number = Math.abs(number);
        if(number < 0 ) return false;
        while(number != 0) {
            int digit = number % 10;
            reversedNumber = reversedNumber * 10 + digit;
            System.out.println("digit: "+digit+" reversedNumber: " + reversedNumber);
            number /= 10;
        }
//        for (int mod = 10; mod < number; mod *= 10) {
//            int place = number / mod;
//            System.out.println("mod: " + mod + " place: " + place);
//
////            System.out.println(place);
//        }
        return false;
    }
}
