package Q2303;

public class Solution {
    public double calculateTax(int[][] brackets, int income) {
        double total = 0.0f;
        int n = brackets.length;
        if(income < brackets[0][0]) {
            return (double) income * (brackets[0][1] / 100.0);
        }else {
            total += (double) brackets[0][0] * (brackets[0][1] / 100.0);
        }
        for (int i = 1; i < n; i++) {
            if(brackets[i][0] < income){
                total += (brackets[i][0] - brackets[i-1][0]) * (brackets[i][1] / 100.0);
            }
            else {
                total += (income - brackets[i-1][0]) * (brackets[i][1] / 100.0);
                break;
            }
        }
        if(income > brackets[n-1][0]){
            total += ( income - brackets[n-1][0]) * (brackets[n-1][1] / 100.0);
        }
        return total;
    }
}
