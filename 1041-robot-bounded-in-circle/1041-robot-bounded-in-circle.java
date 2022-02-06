class Solution {    
    
    public boolean isRobotBounded(String instructions) {
        // direction -> n w s e -> where n is 0, rotating left
        int xAxis = 0, yAxis = 0, direction = 0;
        
        for(int i=0; i<instructions.length(); i++) {            
            switch(instructions.charAt(i)) {
                case 'L':
                    direction = (direction + 1) % 4;
                    break;
                case 'R':
                    direction = (direction + 3) % 4;
                    break;
                case 'G':
                    if(direction == 0) {
                        yAxis++;
                    } else if(direction == 1) {
                        xAxis--;
                    } else if(direction == 2) {
                        yAxis--;
                    } else if(direction == 3) {
                        xAxis++;
                    }
                    break;
            }
        }
        
        return xAxis == 0 && yAxis == 0 || direction != 0;
    }
    
}

/*
Logic
    If you end up at 0,0
    so either 2 turns or 4 turns, you will end at 0,0 otherwise, false?
    
"LLGRL"
*/