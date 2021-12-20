package e2;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class ordenJerarquico implements OrdenRealizacion{
    private final Queue<Vertice> cola;
    private final StringBuilder sb;
    public ordenJerarquico(){
        this.cola = new LinkedList<>();
        this.sb = new StringBuilder();
    }

    public String getOrden(Vertice inicial){
        cola.add(inicial);
        while( !cola.isEmpty() ){
            Vertice actual = cola.poll();
            if( !actual.isVisitado() ){ // Por si hay ciclos
                actual.setVisitado(true);
                if(!Objects.equals(actual.getNombre(), "AUXILIAR")){
                    sb.append(actual).append("- ");
                    //System.out.println(actual);
                }
                cola.addAll(actual.getVecinos());
            }
        }
        if(sb.toString().length() < 2){
            return sb.toString();
        }else{
            return sb.substring(0, sb.toString().length() - 3);
        }
    }
}
