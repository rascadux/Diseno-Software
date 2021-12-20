package e1;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class FiltradoPrecio implements Filtrado{
    int precio;
    ListadoBilletes lista;
    String operator;

    public FiltradoPrecio (int precio, ListadoBilletes lista, String operator){
        this.precio = precio;
        this.lista = lista;
        this.operator = operator;
    }
    @Override
    public ListadoBilletes getBilletes() {

        switch(this.operator) {
            case ">":
                return new ListadoBilletes(filterMajorPrize());
            case "<":
                return new ListadoBilletes(filterMinorPrize());
            case "=":
                return new ListadoBilletes(filterEqualsPrize());
            case "≤":
                return new ListadoBilletes(filterMinorEqualPrize());
            case "≥":
                return new ListadoBilletes(filterMajorEqualPrize());
        }

        return new ListadoBilletes();

    }

    private  ArrayList<Billetes> filterEqualsPrize() {
       return  new ArrayList<Billetes>
                (this.
                        lista.getListaBilletes().
                        stream().
                        filter(billete -> (billete.
                                getPrecio()  == this.precio)).
                        collect(Collectors.toList()));
    }

    private  ArrayList<Billetes> filterMajorPrize() {
        return  new ArrayList<Billetes>
                (this.
                        lista.getListaBilletes().
                        stream().
                        filter(billete -> (billete.
                                getPrecio()  > this.precio)).
                        collect(Collectors.toList()));
    }

    private  ArrayList<Billetes> filterMinorPrize() {
        return  new ArrayList<Billetes>
                (this.
                        lista.getListaBilletes().
                        stream().
                        filter(billete -> (billete.
                                getPrecio()  < this.precio)).
                        collect(Collectors.toList()));
    }

    private  ArrayList<Billetes> filterMajorEqualPrize() {
        return  new ArrayList<Billetes>
                (this.
                        lista.getListaBilletes().
                        stream().
                        filter(billete -> (billete.
                                getPrecio()  >= this.precio)).
                        collect(Collectors.toList()));
    }
    private  ArrayList<Billetes> filterMinorEqualPrize() {
        return  new ArrayList<Billetes>
                (this.
                        lista.getListaBilletes().
                        stream().
                        filter(billete -> (billete.
                                getPrecio()  <= this.precio)).
                        collect(Collectors.toList()));
    }
}
