package Q1_500.Q273;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public String numberToWords(int num) {
        if(num == 0)
        {
            return "Zero";
        }
        //最大2^31，就是10位，2,147,483,647
        List<List<Integer>> numList = new ArrayList<List<Integer>>();
        List<Integer> tempList = new ArrayList<Integer>();
        while(num > 0)
        {
            int temp = num % 10;
            num = num / 10;
            tempList.add(0,temp);

            if(tempList.size() == 3)
            {
                numList.add(0,tempList);
                tempList = new ArrayList<Integer>();
            }
        }
        if(tempList.size()==1)
        {
            tempList.add(0,0);
            tempList.add(0,0);
            numList.add(0,tempList);
        }
        else if(tempList.size()==2)
        {
            tempList.add(0,0);
            numList.add(0,tempList);
        }


        String res="";
        int commaCount =0;
        for(int i=numList.size()-1;i>=0;i--)
        {
            if(commaCount==1 && !isZero(numList.get(i)))
            {
                res = " Thousand"+res;
            }
            else if(commaCount ==2&& !isZero(numList.get(i)))
            {
                res = " Million"+res;
            }
            else if(commaCount==3&& !isZero(numList.get(i)))
            {
                res = " Billion"+res;
            }
            res = getWord(numList.get(i)) + res;

            commaCount++;
        }
        res=res.substring(1);
        return res;
    }

    private String getWord(List<Integer> nums)
    {
        String res="";
        int hun=nums.get(0);
        int ten=nums.get(1);
        int unit=nums.get(2);
        //  先处理百位
        if(hun != 0)
        {
            String tempStr = getBaseNum(hun);
            res += tempStr;
            res += " Hundred";
        }
        //十位和个位一起处理
        if(ten == 0)
        {
            String tempStr = getBaseNum(unit);
            res += tempStr;
        }
        else if(ten == 1)
        {
            switch (unit)
            {
                case 0:
                    res += " Ten";
                    break;
                case 1:
                    res += " Eleven";
                    break;
                case 2:
                    res += " Twelve";
                    break;
                case 3:
                    res += " Thirteen";
                    break;
                case 4:
                    res += " Fourteen";
                    break;
                case 5:
                    res += " Fifteen";
                    break;
                case 6:
                    res += " Sixteen";
                    break;
                case 7:
                    res += " Seventeen";
                    break;
                case 8:
                    res += " Eighteen";
                    break;
                case 9:
                    res += " Nineteen";
                    break;
                default:
                    break;
            }
        }
        else
        {
            switch (ten)
            {
                case 2:
                    res += " Twenty";
                    break;
                case 3:
                    res += " Thirty";
                    break;
                case 4:
                    res += " Forty";
                    break;
                case 5:
                    res += " Fifty";
                    break;
                case 6:
                    res += " Sixty";
                    break;
                case 7:
                    res += " Seventy";
                    break;
                case 8:
                    res += " Eighty";
                    break;
                case 9:
                    res += " Ninety";
                    break;
                default:
                    break;
            }

            String tempStr = getBaseNum(unit);
            res += tempStr;
        }
        return res;
    }

    private String getBaseNum(int num)
    {
        String res ="";
        switch (num)
        {
            case 0:
                break;
            case 1:
                res += " One";
                break;
            case 2:
                res += " Two";
                break;
            case 3:
                res += " Three";
                break;
            case 4:
                res += " Four";
                break;
            case 5:
                res += " Five";
                break;
            case 6:
                res += " Six";
                break;
            case 7:
                res += " Seven";
                break;
            case 8:
                res += " Eight";
                break;
            case 9:
                res += " Nine";
                break;
            default:
                break;
        }
        return res;
    }

    private boolean isZero(List<Integer> nums) {
        int hun = nums.get(0);
        int ten = nums.get(1);
        int unit = nums.get(2);
        if (hun == 0 && ten == 0 && unit == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();
        String res =s.numberToWords(1000000);
        System.out.println(res);
    }

}
