package e3;

import java.util.ArrayList;
import java.util.Objects;


public class Melody {
    private final ArrayList<MusicSheet> melody;
    private float durationMelody = 0f;
    public enum Notes {
        DO(6.5f), RE(5.5f), MI(4.5f), FA(4f), SOL(3f),
        LA(2f), SI(1.0f);

        private final float valor;

        Notes(float valor) {
            this.valor = valor;
        }

        @Override
        public String toString() {
            return this.name();
        }

        public float getValor() {
            return this.valor;
        }
    }

    public enum Accidentals {
        SHARP(-0.5f), FLAT(0.5f), NATURAL(0f);
        private float valor;

        public float getValor() {
            return this.valor;
        }

        Accidentals(float s) {
            this.valor = s;
        }

        @Override
        public String toString() {
            if (this.name().equals("NATURAL")){
                return "";
            }
            else if (this.name().equals("SHARP")){
                return "#";
            }
            else if (this.name().equals("FLAT")){
                return "b";
            }
            return this.name();
        }
    }

    public Melody() { melody = new ArrayList<>();}
    public void addNote(Notes note, Accidentals accidental, float time) throws IllegalArgumentException {
        if (note == null || accidental == null || time <= 0)
            throw new IllegalArgumentException();
        try {
            Notes.valueOf(note.toString());
            //yes
        } catch (IllegalArgumentException exception) {
            //nope
        }
        //hacer las excepciones
        MusicSheet m = new MusicSheet(note, accidental, time);
        melody.add(m);
        durationMelody = durationMelody + time;
    }

    public Notes getNote(int index) {
        if (index < 0 || index > melody.size() - 1) {
            throw new IllegalArgumentException();
        } else {
            return this.melody.get(index).getNote();
        }

    }
    public Accidentals getAccidental(int index) {
        if (index < 0 || index > melody.size() - 1) {
            throw new IllegalArgumentException();
        } else {
            return this.melody.get(index).getAccidentals();

        }
    }

    public float getTime(int index) {
        if (index < 0 || index > melody.size() - 1) {
            throw new IllegalArgumentException();
        } else {
            return this.melody.get(index).getTime();
        }
    }

    public int size() {
        return this.melody.size();
    }

    public float getDuration() {
        return this.durationMelody;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Melody melody1 = (Melody) o;
        int contador = 0;
        for (int i = 0; i < this.size(); i++){//con los valores float de los enum, comprobamos la suma de cada uno
            if (this.melody.get(i).getNote().getValor() + this.melody.get(i).getAccidentals().getValor() == melody1.melody.get(i).getNote().getValor() + melody1.melody.get(i).getAccidentals().getValor()){
                contador++;
            }else {
                switch (this.melody.get(i).getNote().toString()){//comienza comprobar semitonos entre do y si
                    case "SI":
                        if (this.melody.get(i).getAccidentals().equals(Accidentals.NATURAL)  && melody1.melody.get(i).getNote().getValor() + melody1.melody.get(i).getAccidentals().getValor() == 7f)
                            contador++;
                        else if (this.melody.get(i).getAccidentals().equals(Accidentals.SHARP) && melody1.melody.get(i).getNote().getValor() + melody1.melody.get(i).getAccidentals().getValor() == 6.5f)
                            contador++;
                    case "DO":
                        if (this.melody.get(i).getAccidentals().equals(Accidentals.NATURAL)  && melody1.melody.get(i).getNote().getValor() + melody1.melody.get(i).getAccidentals().getValor() == 0.5f)
                            contador++;
                        else if (this.melody.get(i).getAccidentals().equals(Accidentals.FLAT) && melody1.melody.get(i).getNote().getValor() + melody1.melody.get(i).getAccidentals().getValor() == 1f)
                            contador++;
                        break;

                }
            }
        }
        return  (contador == this.size()) && Objects.equals(melody1.durationMelody, durationMelody);
    }

    @Override
    public int hashCode() {
        ArrayList<MusicSheet> m2 = this.melody;
        if (melody.equals(m2))
            return (int) Math.random();
        return Objects.hash(melody, durationMelody);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (MusicSheet m : melody) {
            sb.append(m.toString() + " ");
        }
        return sb.substring(0, sb.toString().length() -1);
    }
}

