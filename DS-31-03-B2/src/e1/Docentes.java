package e1;

public class Docentes extends Personal{

    private Asignatura asignatura;

    public Docentes(String nombre, String apellido, int edad, int horrocruxes, Asignatura asignatura){
        super(Profesion.Docente, nombre, apellido, edad, horrocruxes);
        setAsignatura(asignatura);
        setSalario(calculoSalario(this.asignatura));
        setInformacion("Docente de " + this.asignatura);
        setRecompensa(calculoRecompensaDocente(asignatura));
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public int calculoSalario(Asignatura asignatura) {
        if(asignatura == Asignatura.DEFENSA){
            return 500;
        }else if(asignatura == Asignatura.TRANSFORMACIONES){
            return 400;
        }else if(asignatura == Asignatura.POCIONES){
            return 350;
        }else if(asignatura == Asignatura.HERBOLOGIA){
            return 250;
        }else if(asignatura == Asignatura.HISTORIA){
            return 200;
        }else throw new IllegalArgumentException();

    }

    public float calculoRecompensaDocente(Asignatura asignatura){
        if (asignatura == Asignatura.DEFENSA)
            return this.recompensa * 0.75f;
        else
            return this.recompensa;
    }
}
