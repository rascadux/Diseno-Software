package e2;

import java.util.Objects;

public class Anuncio implements Comparable<Anuncio>{

    private int num_ref;
    private int precioTotal;
    private int precioBase;
    private int precioPlaza;
    private int numPlazas;
    private int tamanho;
    private int habitaciones;
    private int cod_Postal;

    public Anuncio(int num_ref, int precioBase, int precioPlaza, int numPlazas,
                   int tamanho, int habitaciones, int cod_Postal){ //precioPlaza es el precio por cada plaza
        setNum_ref(num_ref);
        setPrecioBase(precioBase);
        setPrecioPlaza(precioPlaza); //Suponemos que si no venden plazas, pondrán su precio a 0
        setNumPlazas(numPlazas);
        setPrecioTotal();
        setTamanho(tamanho);
        setHabitaciones(habitaciones);
        setCod_postal(cod_Postal);
    }

    public void setCod_postal(int cod_Postal) {
        this.cod_Postal = cod_Postal;
    }

    public int getCod_postal() {
        return cod_Postal;
    }

    public void setNum_ref(int num_ref) {
        this.num_ref = num_ref;
    }

    public int getNum_ref() {
        return num_ref;
    }

    public void setNumPlazas(int numPlazas) {
        this.numPlazas = numPlazas;
    }

    public int getNumPlazas() {
        return numPlazas;
    }

    public void setPrecioBase(int precioBase) {
        this.precioBase = precioBase;
    }

    public int getPrecioBase() {
        return precioBase;
    }

    public void setPrecioPlaza(int precioPlaza) {
        this.precioPlaza = precioPlaza;
    }

    public int getPrecioPlaza() {
        return precioPlaza;
    }

    public int getPrecioTotalPlazas() {
        return precioPlaza * numPlazas;
    }

    public void setPrecioTotal() {
        precioTotal = getPrecioBase() + getPrecioTotalPlazas();
    }

    public int getPrecioTotal() {
        return precioTotal;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setHabitaciones(int habitaciones) {
        this.habitaciones = habitaciones;
    }

    public int getHabitaciones() {
        return habitaciones;
    }

    @Override
    public String toString(){
        return "REF: " + num_ref + " / " + precioBase + "€ / Plazas: " + precioPlaza + "€ / TotalPlazas: "
                + getPrecioTotalPlazas() + " / " + tamanho + "m2 / " + "CP: " + cod_Postal + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Anuncio anuncio = (Anuncio) o;
        return Objects.equals(toString(), anuncio.toString());
        //Como ningun atributo en si nos sirve para ver si son el mismo, comparamos los toString cogiendo asi todos ellos
    }

    @Override
    public int hashCode() {
        return Objects.hash(precioTotal, precioBase, precioPlaza, tamanho, habitaciones, cod_Postal);
        //En el hashcode() lo mismo, cogemos todos los atributos
    }

    @Override
    public int compareTo(Anuncio other){ //Como ordenacion por defecto, ordena segun numero de referencia
        return Integer.compare(this.num_ref, other.num_ref);
    }

}
