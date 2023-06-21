package Q1001_1500.Q1108;

class Solution {
    public String defangIPaddr(String address) {
        return address.replaceAll("\\.","[.]");
    }
}
