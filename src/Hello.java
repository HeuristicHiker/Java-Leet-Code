public class Hello {
    public static void main(String[] args) {
//        System.out.println("First: " + convertToCentimeters(68));
//        System.out.println("Second: " + convertToCentimeters(5, 8));
//        System.out.println(area(5));
//        printYearsAndDays(525600);
//        repeatedSubstringPattern("abab");
        int number = 4111;
        isPrimeNumber(number);
        System.out.println(number+" isPrime? "+isPrimeNumber(number));
    }


    public static boolean repeatedSubstringPattern(String s) {
        // get sub string
        int maxLen = s.length();
        int hLen = maxLen / 2;
        int subLength = 1;
        for (int i = 0; i < maxLen; i++) {
            String subStr = s.substring(i, subLength);
            System.out.println("Sub with "+subLength+" subStr: "+subStr);
//            if(subLength > hLen) {
//                System.out.println("Too much");
//                return false;
//            }
        }
        return true;
    }

    public static boolean isPrimeNumber(int wholeNumber) {
        int test = 2;
        boolean isPrime = false;

        if(wholeNumber <= 2) return true;

        for (int divisor = 2; divisor < wholeNumber; divisor++) {
            if(wholeNumber % divisor == 0) return false;
        }
        return true;
    }

    public static void displayHighScorePosition(String name, int position) {
        System.out.println(name + " managed to get into position " + position + " on the high score list");
    }

    public static double convertToCentimeters(int inches) {
        double cent = inches * 2.54;
        return cent;
    }

    public static double convertToCentimeters(int feet, int inches) {
//        double cent = convertToCentimeters(heightFt) + convertToCentimeters(heightIn / 12);
//        double cent = ((feet * 12) + inches) * 2.54;
        double cent = convertToCentimeters(feet * 12) + convertToCentimeters(inches);
        return cent;
    }

    public static int calculateHighScorePosition(int score) {
        if (score >= 1000) return 1;
        else if (score >= 500 && score < 1000) return 2;
        else if (score >= 100 && score < 500) return 3;
        else return 4;
    }

    public static double area (double radius) {
        return radius > 0 ? Math.PI * Math.pow(radius, 2) : -1.0;
    }

    public static void printYearsAndDays(long minutes) {
        if (minutes < 0)
            System.out.println("Invalid Value");
        System.out.println(minutes + " min");
        System.out.println(minutes / 525600 + " d");
        System.out.println(minutes % 525600 * 24 + " y");
    }

    public static void printEqual(int a, int b, int c) {
        if(a < 0 || b < 0 || c < 00) {
            System.out.println("Invalid Value");
            return;
        }
        if(a == b && b == c) {
            System.out.println("All numbers are equal");
            return;
        }

    }
}
