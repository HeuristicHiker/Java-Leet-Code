import java.util.Arrays;

public class Playground {
    public static void main(String[] args) {
        int[] inputs = {0,1,0,3,12};

        for (int i = 0; i < inputs.length; i++) {
            System.out.println("---");
            printElements(inputs);
            moveZeroes(inputs);
            System.out.println("Changed");
            printElements(inputs);
        }

    }

    public static void moveZeroes(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            int element = nums[i];
            if(element == 0) {
                for(int j = i; j < nums.length; j++) {
                    if(nums[j] != 0) {
                        nums[i] = nums[j];
                        nums[j] = 0;
                        break;
                    }
                }
            }
        }
    }

    public static void printElements(int[] nums) {
        StringBuilder output = new StringBuilder();
        for(int i = 0; i < nums.length; i++) {
            output.append(" "+nums[i]);
        }
        System.out.println(output);
    }

    public static boolean repeatedSubstringPattern(String s) {
        int maxLen = s.length();
        int hLen = maxLen / 2;

        if (maxLen % 2 != 0) {
            System.out.println("Odd length - reject");
            return false;
        }

        int len = 2;
        while (maxLen / len > 0 && maxLen % len == 0) {
            String left = s.substring(0, maxLen / len);
            String right = s.substring(maxLen / len);
            char[] leftSorted = left.toCharArray();
            char[] rightSorted = right.toCharArray();
            Arrays.sort(leftSorted);
            Arrays.sort(rightSorted);
            System.out.println("left: " + new String(leftSorted));
            System.out.println("right: " + new String(rightSorted));
            System.out.println("is equal: " + Arrays.equals(leftSorted, rightSorted));

            if (Arrays.equals(leftSorted, rightSorted)) return true;

            len *= 2;
        }

        return false;
    }
}
