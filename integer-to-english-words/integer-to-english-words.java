class Solution {
    String[] oneDigit = new String[] {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String[] tens = new String[] {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tenDigit = new String[] {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    
    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        return numberToWordsHelper(num);
    }
    
    private String numberToWordsHelper(int num) {
        String rtn = "";
        if (num < 10)
            rtn = oneDigit[num];
        else if (num < 20)
            rtn = tens[num -10];
        else if (num < 100)
            rtn = tenDigit[num/10] + " " + numberToWordsHelper(num%10);
        else if (num < 1000)
            rtn = oneDigit[num/100] + " Hundred " +  numberToWordsHelper(num%100);
        else if (num < 1000000)
            rtn = numberToWordsHelper(num/1000) + " Thousand " +  numberToWordsHelper(num%1000);
        else if (num < 1000000000)
            rtn = numberToWordsHelper(num/1000000) + " Million " +  numberToWordsHelper(num%1000000);
        else
            rtn = numberToWordsHelper(num/1000000000) + " Billion " + numberToWordsHelper(num%1000000000);
        return rtn.trim();
    }
}

/* 2,147,483,647
 * two billion, one hundred forty-seven million, four hundred eighty-three thousand, six hundred forty-seven
 *
 * one two three four five six seven eight nine
 * ten eleven twelve thirteen fourteen fithteen sixteen seventeen eighteen nineteen
 * twenty twenty one twenty two
 * thirty fourty fivty sixty seventy eighty ninty
 * one hundred, one hundred one, one hundred two
 * thousand
 * million
 */