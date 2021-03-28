package pashkov;

import java.time.LocalDate;

public class VisitDate {
    private LocalDate start;
    private LocalDate finish;

    public VisitDate(LocalDate start, LocalDate finish) {
        this.start = start;
        this.finish = finish;
    }

    public VisitDate(LocalDate start) {
        this.start = start;
        this.finish = null;
    }

    public VisitDate() {
    }

    public LocalDate getStart() {
        return start;
    }

    public LocalDate getFinish() {
        return finish;
    }

    public void setFinish(LocalDate finish) {
        this.finish = finish;
    }
}
