package e1;

public abstract class Personal extends Integrante{

    protected Profesion profesion;
    protected int salario;

    public Personal(Profesion Profesion, String nombre, String apellido, int edad, int horrocruxes){
        super(nombre, apellido, edad, horrocruxes);
        setProfesion(Profesion);
        setRecompensa(calculoRecompensa(profesion));
    }

    public Profesion getProfesion(){
        return this.profesion;
    }

    public int getSalario(){
        return this.salario;
    }

    public void setProfesion(Profesion profesion) {
        this.profesion = profesion;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }
}
