package SPOffer.SPOffer11;

class Solution {
    public int minArray(int[] numbers) {
        int left = 0, right = numbers.length-1;
        if(numbers[left] < numbers [right]) return numbers[left];
        while (left < right){
            if(numbers[left+1]< numbers[left]) return numbers[left+1];
            else if(numbers[right-1]>numbers[right]) return numbers[right];
            int mid = (left + right) >> 1;
            if(numbers[left] > numbers [mid]){
                right = mid;
            }else if(numbers[left] < numbers [mid]) {
                left = mid;
            }else
            {
                right--;
            }
        }
        return numbers[left];
    }
}
