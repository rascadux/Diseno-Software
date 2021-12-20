package e1;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class FiltradoDestino implements Filtrado{
    String destino;
    ListadoBilletes lista;

    public FiltradoDestino (String destino, ListadoBilletes lista){
        this.destino = destino;
        this.lista = lista;
    }
    @Override
    public ListadoBilletes getBilletes() {
        ArrayList<Billetes> filteredList = new ArrayList<Billetes>
                (this.
                        lista.getListaBilletes().
                        stream().
                        filter(billete -> billete.
                                getDestino().equals(this.destino)).
                        collect(Collectors.toList()));
        return new ListadoBilletes(filteredList);
    }
}
