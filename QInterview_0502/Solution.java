package QInterview_0502;

class Solution {
    public String printBin(double num) {
        StringBuilder sb = new StringBuilder("0.");
        while(sb.length() <=32 ){
            num *= 2;
            if(num < 1.0){
                sb.append('0');
            }else {
                num--;
                sb.append('1');
                if(num == 0.0) return sb.toString();
            }
        }
        return "ERROR";
    }

    public static void main(String[] args) {
        double d= 1.0 / (1 << 10);
        System.out.println(d);
    }
}
