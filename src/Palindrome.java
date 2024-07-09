public class Palindrome {
    public static void main (String[] args) {
//        System.out.println("-9669 isPalindrome? " + isPalindrome(-9669)); //true
//        System.out.println("707 isPalindrome? " + isPalindrome(707)); // true
//        System.out.println("3112213 isPalindrome? " + isPalindrome(3112213)); //false
//        System.out.println("1000 isPalindrome? " + isPalindrome(1000)); //false
//        System.out.println("log: "+Math.log10(1000));
        System.out.println("24: "+sumFirstAndLastDigit(24));
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
