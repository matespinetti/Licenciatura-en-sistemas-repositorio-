package ar.edu.unlp.info.oo1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateLapse {
    private LocalDate from;
    private LocalDate to;

    public LocalDate getFrom() {
        return from;
    }

    public DateLapse(LocalDate from, LocalDate to) {
        this.from = from;
        this.to = to;
    }

    public void setFrom(LocalDate from) {
        this.from = from;
    }

    public LocalDate getTo() {
        return to;
    }

    public void setTo(LocalDate to) {
        this.to = to;
    }

    public int sizeInDays(){
        return (int)ChronoUnit.DAYS.between(to, from);
    }


    public boolean includesDate(LocalDate f){

        return (f.isAfter(from) && f.isBefore(to)) || f.isEqual(from) || f.isEqual(to);

    }
}
