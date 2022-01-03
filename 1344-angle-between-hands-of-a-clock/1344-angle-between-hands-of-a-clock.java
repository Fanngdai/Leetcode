class Solution {
    public double angleClock(int hour, int minutes) {
        double degreeOfMin = minutes * 6;
        if(hour == 12)
            hour = 0;
        double degreeOfHour = hour * 30 + (0.5 * minutes);
        
        double ans = Math.abs(degreeOfMin - degreeOfHour);
        return ans > 180 ? 360 - ans : ans;
    }
}

/*
 * circle = 360
 * each hour/5mins is 30 degrees
 * each min is 6 degrees
 
 hour * 30 is the actual hour hand... but we need to move it in depending on the minute
 each minute is 0.5 degrees (within the 1->2 hour), so multiple it with the minutes.
 */