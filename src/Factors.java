public class Factors {
    public static void main(String args[]) {
        printFactors(10);
    }

    public static void printFactors(int number) {
        if(number < 1) {
            System.out.println("Invalid Value");
        }
        int divisor = 1;
        String answer = "";
        while (divisor <= number) {
            int remainder = number % divisor == 0 ? number / divisor : 0;
            if(remainder == 0) {
                divisor++;
                continue;
            }
            System.out.println(divisor + " " + remainder);
            answer += String.valueOf(divisor) + " ";
            divisor++;
        }
        System.out.println(answer);
    }
}
