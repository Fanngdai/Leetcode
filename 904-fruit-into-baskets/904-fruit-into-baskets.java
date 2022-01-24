class Solution {
    public int totalFruit(int[] fruits) {
        int fLen = fruits.length;
        int fruit1Index = -1, fruit1Cnt = 0;
        int fruit2Index = -1, fruit2Cnt = 0;
        int rtn = 0;
        
        for(int i=0; i<fLen; i++) {
            int currFruit = fruits[i];
            
            // if current fruit is not init or if curr fruit is the same
            if(fruit1Index == -1 || currFruit == fruits[fruit1Index]) {
                if(fruit1Index == -1 || fruits[i-1] != fruits[fruit1Index]) {
                    fruit1Index = i;
                }
                fruit1Cnt++;
            } else if(fruit2Index == -1 || currFruit == fruits[fruit2Index]) {
                if(fruit2Index == -1 || fruits[i-1] != fruits[fruit2Index]) {
                    fruit2Index = i;
                }
                fruit2Cnt++;
            } else if(fruit1Index < fruit2Index) {
                fruit1Index = i;
                fruit1Cnt = 1;
                fruit2Cnt = i - fruit2Index;
            } else {
                fruit2Index = i;
                fruit2Cnt = 1;
                fruit1Cnt = i - fruit1Index;
            }
            
            rtn = Math.max(rtn, fruit1Cnt + fruit2Cnt);
        }
        
        return rtn;
    }
}

/*
[1,2,1]
[0,1,2,2]
[1,2,3,2,2]
[1,2,3,2,2,4,4,4]
[0]
[0,1]
[0,0]
*/