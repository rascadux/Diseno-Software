package e2;

import java.util.*;

public class dependenciaDebil implements OrdenRealizacion{

    private final ArrayList<Vertice> lista;
    private final StringBuilder sb;

    public dependenciaDebil(){
        this.lista = new ArrayList<>();
        this.sb = new StringBuilder();
    }

    public String getOrden(Vertice inicial){
        this.lista.add(inicial);
        inicial.setVisitado(true);

        while(!lista.isEmpty()){
            //Ordenar lista
            lista.sort(Comparator.comparing(Vertice::getNombre));
            Vertice actual = lista.get(0);
            if(!Objects.equals(actual.getNombre(), "AUXILIAR")){
                sb.append(actual).append("- ");
            }

            for(Vertice v : actual.getVecinos()){
                if( !v.isVisitado() ){
                    v.setVisitado(true);
                    lista.add(v);
                }
            }
            lista.remove(actual);
        }

        if(sb.toString().length() < 2){
            return sb.toString();
        }else{
            return sb.substring(0, sb.toString().length() - 3);
        }
    }
}

