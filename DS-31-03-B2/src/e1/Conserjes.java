package e1;

public class Conserjes extends Personal{

    public Conserjes(String nombre, String apellido, int edad, int horrocruxes){
        super(Profesion.Conserje, nombre, apellido, edad, horrocruxes);
        setSalario(160);
        setInformacion("Conserje");
    }

}
