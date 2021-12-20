package e2;

import java.util.*;


public class Vertice{
    private String nombre; //Defino nombre como String, ya que en caso de que haya >27 tareas, nos quedariamos sin letras
    private boolean visitado;
    private int grado = 0;
    private List<Vertice> vecinos;

    public Vertice(String nombre){
        setNombre(nombre);
        this.vecinos = new LinkedList<>();
    }

    public void addVecino(Vertice vertice){
        vertice.grado++;
        this.vecinos.add(vertice);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    public List<Vertice> getVecinos() {
        vecinos.sort(Comparator.comparing(Vertice::getNombre)); // Ordena alfabeticamente
        for(Vertice v: vecinos){ //va quitando un grado a los que apunta el vertice
            v.grado--;
        }
        return vecinos;
    }

    public List<Vertice> getVecinosReversed(){ //Al ser una pila, los necesito invertidos
        Collections.reverse(getVecinos());
        return vecinos;
    }

    public void setVecinos(List<Vertice> vecinos) {
        this.vecinos = vecinos;
    }

    public int getGrado() {
        return grado;
    }

    private OrdenRealizacion algoritmo;

    public OrdenRealizacion getAlgoritmo(){
        return algoritmo;
    }

    public void setAlgoritmo(OrdenRealizacion algoritmo) {
        this.algoritmo = algoritmo;
    }

    public String Ordenacion(){
        return algoritmo.getOrden(this);
    }

    @Override
    public String toString() {
        return this.nombre + " ";
    }
}
