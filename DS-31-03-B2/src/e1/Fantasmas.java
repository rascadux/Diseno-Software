package e1;

public class Fantasmas extends Residentes{

    public Fantasmas(String nombre, String apellido, int edad, int horrocruxes, Casa casa){
        super(nombre, apellido, edad, horrocruxes, casa);
        setInformacion("Fantasma de " + this.casa);
        setRecompensa(calculoRecompensa(Profesion.Fantasma));
        setRecompensa(calcularRecompensa(casa));
    }

}
