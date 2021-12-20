package e1;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

public class GestionBilletes {
    ListadoBilletes lista ;
    public GestionBilletes(ListadoBilletes lista){
        this.lista = lista;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GestionBilletes that = (GestionBilletes) o;
        return Objects.equals(lista, that.lista);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lista);
    }

    public ListadoBilletes getBilletes (String consulta) throws ParseException {
        ArrayList<String> queries = new ArrayList<>(Arrays.asList(consulta.split(" ")));
        ListadoBilletes currentList;//se irá actualizando según avance la consulta...
        ListadoBilletes filteredList;
        currentList = filterApply(0, queries);

        for (int i = 0;  i < queries.size(); i++){
            if (i%2 == 1){
                switch (queries.get(i)){
                    case "AND":
                        OperacionLogica AND = new OperacionAND();
                        filteredList = filterApply(i+1, queries);//bien
                        currentList = AND.match(currentList, filteredList);
                        break;
                    case "OR":
                        OperacionLogica OR = new OperacionOR();
                        filteredList = filterApply(i+1, queries);
                        currentList = OR.match(currentList, filteredList);
                        break;

                    default:
                        break;

                }
            }
        }
        return currentList;
    }

    public ListadoBilletes filterApply(int position, ArrayList<String> queries) throws ParseException {
        String aux;
        int precio;
        Date date;
        ListadoBilletes listFinal = new ListadoBilletes();
        if (position%2 == 0){
            Filtrado f;
            if (queries.get(position).contains("origen")){
                aux = queries.get(position).replaceAll("origen=", "");
                f = new FiltradoOrigen(aux, this.lista);
                listFinal= f.getBilletes();

            }else if (queries.get(position).contains("destino")){
                aux = queries.get(position).replaceAll("destino=", "");
                f = new FiltradoDestino(aux, this.lista);
                listFinal = f.getBilletes();

            }else if (queries.get(position).contains("precio")){
                precio = Integer.parseInt(queries.get(position + 2)); //el precio esta dos posiciones adelante
                f = new FiltradoPrecio(precio, this.lista, queries.get(position + 1));//el simbolo está a una posicion
                listFinal = f.getBilletes();

            }else if (queries.get(position).contains("fecha")){
                aux = queries.get(position).replaceAll("fecha=", "");
                date = new SimpleDateFormat("dd/MM/yyyy").parse(aux);
                f = new FiltradoFecha(date, this.lista);
                listFinal = f.getBilletes();

            }
        }
        return listFinal;
    }




}
