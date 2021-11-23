package e1;

public abstract class Residentes extends Integrante{

    protected Casa casa;

    public Residentes(String nombre, String apellido, int edad, int horrocruxes, Casa casa){
        super(nombre, apellido, edad, horrocruxes);
        setCasa(casa);
    }

    public void setCasa(Casa casa) {
        this.casa = casa;
    }

    public Casa getCasa(){
        return this.casa;
    }

    public float calcularRecompensa(Casa casa){
        if(casa == Casa.SLYTHERIN)
            return this.recompensa * 2;
        else
            return this.recompensa;
    }


}
