package Q1001_1500.Q1138;

class Solution {
    public String alphabetBoardPath(String target) {
        StringBuilder sb = new StringBuilder();
        int x =0,y = 0, tarX = 0, tarY = 0;
        for(char c: target.toCharArray()){
            tarX = ((int) c-'a') %5;
            tarY = ((int) c-'a') /5;
            if(c == 'z'){
                leftRight(x, tarX, sb);
                upDown(y, tarY, sb);
            }else {
                upDown(y, tarY, sb);
                leftRight(x, tarX, sb);
            }

            sb.append('!');
            x = tarX;
            y = tarY;
        }
        return sb.toString();
    }

    void upDown(int y, int tarY, StringBuilder sb){
        if(tarY > y){
            for (int i = y; i < tarY; i++) {
                sb.append('D');
            }
        }
        else {
            for (int i = y; i > tarY; i--) {
                sb.append('U');
            }
        }
    }

    void leftRight(int x , int tarX, StringBuilder sb ){
        if(tarX > x){
            for (int i = x; i < tarX; i++) {
                sb.append('R');
            }
        }
        else {
            for (int i = x; i > tarX; i--) {
                sb.append('L');
            }
        }
    }
}
