package e1;

public class Guardabosques extends Personal{


    public Guardabosques(String nombre, String apellido, int edad, int horrocruxes){
        super(Profesion.Guardabosques, nombre, apellido, edad, horrocruxes);
        setInformacion("Guardabosques");
        setSalario(180);
    }


}
