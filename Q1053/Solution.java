package Q1053;

public class Solution {
    public int[] prevPermOpt1(int[] arr) {
        int n = arr.length;
        if(n == 1) return arr;
        for (int i = n-2; i >=0 ; i--) {
            if(arr[i]> arr[i+1]){
                int j = n-1;
                while (j > i && arr[j] >= arr[i] || arr[j] == arr[j-1]){
                    j--;
                }
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                return arr;
            }
        }
        return arr;
    }

}
