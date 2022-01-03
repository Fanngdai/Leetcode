class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> lst = new ArrayList<>();
        int letterCount = 0, spaceCount = 0, indexStart = 0;
        
        for(int i=0; i<words.length; i++) {
            int wordLength = words[i].length();
            
            if(letterCount + spaceCount + wordLength > maxWidth) {
                addWord(lst, words, maxWidth, indexStart, i-1, letterCount);
                letterCount = wordLength;
                spaceCount = 0;
                indexStart = i;
            } else {
                letterCount += wordLength;
            }
            
            // For space
            spaceCount++;
        }
        
        addWord(lst, words, maxWidth, indexStart, words.length-1, letterCount);
        return lst;
    }
    
    private void addWord(List<String> lst, String[] words, int maxWidth, int start, int end, int letterCount) {
        StringBuilder rtn = new StringBuilder(maxWidth);
        // if one word or if last line
        if(end == words.length - 1 || end - start == 0) {
            for(int i = start; i<end; i++) {
                rtn.append(words[i]);
                padWithSpace(rtn, 1);
            }
            rtn.append(words[end]);
            padWithSpace(rtn, maxWidth - rtn.length());
        } else {
            int wordAmt = end - start + 1;
            int spaces = (maxWidth-letterCount)/(wordAmt-1);
            int extraSpaces = (maxWidth-letterCount)%(wordAmt-1);
            for(int i=start; i<end; i++) {
                rtn.append(words[i]);
                padWithSpace(rtn, extraSpaces-- > 0 ? spaces + 1 : spaces);
            }
            rtn.append(words[end]);
        }
        lst.add(rtn.toString());
    }
    
    private void padWithSpace(StringBuilder word, int spaces) {
        for(int i=0; i<spaces; i++) {
            word.append(" ");
        }
    }
}

/*
 * Count words
 * Count spaces -> words - 1 at least
 *
 * If last line or if one word, left justified
 */