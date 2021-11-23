package e1;

public class Estudiantes extends Residentes{

    public Estudiantes(String nombre, String apellido, int edad, int horrocruxes, Casa casa) {
        super(nombre, apellido, edad, horrocruxes, casa);
        setInformacion("Estudiante de " + this.casa);
        setRecompensa(calculoRecompensa(Profesion.Estudiante));
        setRecompensa(calcularRecompensa(casa));
    }

}
