class BrowserHistory {
    List<String> history;
    int index;
    
    public BrowserHistory(String homepage) {
        history = new ArrayList<>();
        history.add(homepage);
        index = 0;
    }
    
    public void visit(String url) {
        history.subList(index+1, history.size()).clear();
        history.add(url);
        index++;
    }
    
    public String back(int steps) {
        index -= steps;
        if(index<0) index = 0;
        return history.get(index);
    }
    
    public String forward(int steps) {
        index += steps;
        if(index>history.size()-1) index = history.size()-1;
        return history.get(index);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */