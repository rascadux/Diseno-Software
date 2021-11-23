package e3;

import java.util.Objects;

public class MusicSheet {
    private Melody.Notes note;
    private Melody.Accidentals accidentals;
    private float time;

    public MusicSheet(Melody.Notes note, Melody.Accidentals accidentals, float time){
        this.note = note;
        this.accidentals = accidentals;
        this.time = time;
    }

    public Melody.Notes getNote() {
        return this.note;
    }

    public void setNote(Melody.Notes note) {
        this.note = note;
    }

    public Melody.Accidentals getAccidentals() {
        return this.accidentals;
    }

    public void setAccidentals(Melody.Accidentals accidentals) {
        this.accidentals = accidentals;
    }

    public float getTime() {
        return this.time;
    }

    public void setTime(float time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return  note +
                ""+ accidentals +
                "("+ time +
                ')';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MusicSheet that = (MusicSheet) o;
        return Float.compare(that.time, time) == 0 && note == that.note && accidentals == that.accidentals;
    }

    @Override
    public int hashCode() {
        return Objects.hash(note, accidentals, time);
    }
}
