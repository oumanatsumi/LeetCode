package Q501_1000.Q808;

class Solution {
    public double soupServings(int n) {
        n = Math.min(200, (int) Math.ceil(n / 25.0));
        double[][] f = new double[n + 10][n + 10];
        f[0][0] = 0.5;
        for (int j = 1; j <= n; j++) f[0][j] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                double a = f[Math.max(i - 4, 0)][j], b = f[Math.max(i - 3, 0)][Math.max(j - 1, 0)];
                double c = f[Math.max(i - 2, 0)][Math.max(j - 2, 0)], d = f[Math.max(i - 1, 0)][Math.max(j - 3, 0)];
                f[i][j] = 0.25 * (a + b + c + d);
            }
        }
        return f[n][n];
    }

}
