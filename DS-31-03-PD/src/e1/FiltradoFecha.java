package e1;

import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;

public class FiltradoFecha implements Filtrado{

    Date fecha;
    ListadoBilletes lista;

    public FiltradoFecha(Date fecha, ListadoBilletes lista){
        this.fecha = fecha;
        this.lista = lista;
    }

    @Override
    public ListadoBilletes getBilletes() {
        ArrayList<Billetes> filteredList = new ArrayList<Billetes>
                (this.
                        lista.getListaBilletes().
                        stream().
                        filter(billete -> billete.
                                getFecha().equals(this.fecha)).
                        collect(Collectors.toList()));
        return new ListadoBilletes(filteredList);
    }
}
