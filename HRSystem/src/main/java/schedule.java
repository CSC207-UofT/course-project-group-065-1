public class schedule {
    private String dayOfWeek;
    private String startTime;
    private String endTime;

    public schedule(String dayOfWeek, String startTime, String endTime){
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public void setDayOfWeek(String dayOfWeek){
        this.dayOfWeek = dayOfWeek;
    }

    public void setStartTime(String startTime){
        this.startTime = startTime;
    }

    public void setEndTime(String endTime){
        this.endTime = endTime;
    }

    @Override
    public String toString(){
        return this.dayOfWeek + " from " + this.startTime + " to " + this.endTime;
    }
}
