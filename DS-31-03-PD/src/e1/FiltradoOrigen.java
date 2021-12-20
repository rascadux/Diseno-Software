package e1;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class FiltradoOrigen implements Filtrado{
    String origen;
    ListadoBilletes lista;

    public FiltradoOrigen (String origen, ListadoBilletes lista){
        this.origen = origen;
        this.lista = lista;

    }
    @Override
    public ListadoBilletes getBilletes() {
        ArrayList<Billetes> filteredList = new ArrayList<Billetes>
                (this.
                        lista.getListaBilletes().
                        stream().
                        filter(billete -> billete.
                                getOrigen().equals(this.origen)).
                        collect(Collectors.toList()));
        return new ListadoBilletes(filteredList);//guardamos esta lista en algun lado y despues la sobreescribimos o le añadimos(si or o AND)
    }
}
