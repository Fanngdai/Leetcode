class Solution {
    public String intToRoman(int num) {
        String rtn = "";
        
        rtn += convertToRoman(num / 1000, 'M');
        num %= 1000;
        if(num/900>=1) {
            rtn += "CM";
            num -= 900;
        }
        rtn += convertToRoman(num / 500, 'D');
        num %= 500;
        if(num/400>=1) {
            rtn += "CD";
            num -= 400;
        }
        rtn += convertToRoman(num / 100, 'C');
        num %= 100;
        if(num/90>=1) {
            rtn += "XC";
            num -= 90;
        }
        rtn += convertToRoman(num / 50, 'L');
        num %= 50;
        if(num/40>=1) {
            rtn += "XL";
            num -= 40;
        }
        rtn += convertToRoman(num / 10, 'X');
        num %= 10;
        if(num/9>=1) {
            rtn += "IX";
            num -= 9;
        }
        rtn += convertToRoman(num / 5, 'V');
        num %= 5;
        if(num/4>=1) {
            rtn += "IV";
            num -= 4;
        }
        rtn += convertToRoman(num / 1, 'I');
        
        return rtn;
    }
    
    private String convertToRoman(int amt, char c) {
        String rtn = "";
        for (int i = 0; i < amt; i++)
            rtn += c;
        return rtn;
    }
}

