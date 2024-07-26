package nnw.task;

public class HighestCommonFactor {
    public static int highestCommonFactor(int a, int b){
        if(a == 0){
            return b;
        }
        return highestCommonFactor(b % a, a);
    }

    public int highestCommonFactor(int[] numbers){
        if(numbers.length == 0){
            return 0;
        }

        int result = numbers[0];
        for(int value : numbers){
            result = highestCommonFactor(result, value);
        }
        return result;
    }
}
