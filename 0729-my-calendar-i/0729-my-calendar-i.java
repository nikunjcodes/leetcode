class MyCalendar {
    TreeMap<Integer , Integer> calendar;
    public MyCalendar() {
        calendar = new TreeMap<>();
    }
    
    public boolean book(int startTime, int endTime) {
        Integer fkey = calendar.floorKey(startTime);
        if(fkey!=null && calendar.get(fkey)>startTime)
            return false;
        Integer ckey = calendar.ceilingKey(startTime);
        if(ckey!=null && ckey<endTime)
            return false;
        calendar.put(startTime , endTime);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */