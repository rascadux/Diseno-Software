package e2;

import java.util.*;

public class dependenciaFuerte implements OrdenRealizacion{

    private final Stack<Vertice> stack;
    private final StringBuilder sb;

    public dependenciaFuerte(){
        this.stack = new Stack<>();
        this.sb = new StringBuilder();
    }

    @Override
    public String getOrden(Vertice inicial){
        this.stack.add(inicial);
        inicial.setVisitado(true);

        while( !stack.isEmpty() ){
            Vertice actual = this.stack.pop();
            if(!Objects.equals(actual.getNombre(), "AUXILIAR")){
                sb.append(actual).append("- ");
            }

            for(Vertice v : actual.getVecinosReversed()){
                if( v.getGrado() == 0 && !v.isVisitado()){
                    v.setVisitado(true);
                    this.stack.push(v);
                }
            }
        }
        if(sb.toString().length() < 2){
            return sb.toString();
        }else{
            return sb.substring(0, sb.toString().length() - 3);
        }
    }

}
