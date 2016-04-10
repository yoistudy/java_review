package ch06.KC;

/**
 * Created by Daniel on 2016. 4. 2..
 */
public class Time {
    private int hour;
    private int minute;
    private int second;

    public int getHour() {
        return hour;
    }

    public void setHour(int h) {
        if(h < 0 || h > 23){
            return ;
        }
        this.hour = h;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int m) {
        if(m < 0 || m > 23){
            return ;
        }
        this.minute = m;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int s) {
        if(s < 0 || s > 59){
            return ;
        }
        second = s;
    }
}
