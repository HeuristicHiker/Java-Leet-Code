public class Sums {
    public static void main (String[] args) {
        System.out.println("123456789: "+getEvenDigitSum(123456789));
    }

    public static int getEvenDigitSum(int number){
        int sum = 0;
        if(number < 0) return -1;
        int i = 2;
        while(number > 0) {
            int digit = number % 10;
            System.out.println(digit);
            if(digit % 2 == 0) {
                sum += digit;
            }
            number /= 10;
        }
        return sum;
    }
}
