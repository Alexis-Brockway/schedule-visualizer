package edu.hanover.schedulevisualizer.core;
public class DayTime {
    public int hours;
    public int minutes;

    public DayTime(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    public boolean equals(Object other){
        if(other == null) return false;
        if (other.getClass() != getClass()) return false;
        DayTime dt = (DayTime) other;
        return hours == dt.hours && minutes == dt.minutes;
    }

    public boolean isEarlier(DayTime other) {
        return hours < other.hours ||
                (hours == other.hours && minutes < other.minutes);
    }

    public String toString() {
        if (hours < 12) {
            return String.format("%d:%02dam", hours, minutes);
        } else {
            return String.format("%d:%02dpm", hours == 12 ? 12 : hours - 12, minutes);
        }
    }
}
