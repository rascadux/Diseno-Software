package e2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class Apartamentos {

    public ArrayList<Anuncio> listaApartamentos;
    private String criterio=null;

    public Apartamentos(){
        this.listaApartamentos = new ArrayList<>();
    }

    public void setCriterio(String criterio) {
        this.criterio = criterio;
    }

    public String getCriterio() {
        return criterio;
    }

    public void addAnuncio(Anuncio anuncio){
        this.listaApartamentos.add(anuncio);
    }

    public void OrdenarporCriterio(){
        if(Objects.equals(getCriterio(), "precio base")){
            listaApartamentos.sort(new OrdenarPrecioBase());
        }else if(Objects.equals(getCriterio(), "precio total")){
            listaApartamentos.sort(new OrdenarPrecioTotal());
        }else if(Objects.equals(getCriterio(), "habitaciones")){
            listaApartamentos.sort(new OrdenarHabitaciones());
        }else if(Objects.equals(getCriterio(), "tamaño")){
            listaApartamentos.sort(new OrdenarTamanho());
        }else Collections.sort(listaApartamentos);//Si no se dio ningun valor de ordeancion valido o es nulo
    }

    public String imprimirAnuncios(){
        StringBuilder sb = new StringBuilder();
        for(Anuncio m: listaApartamentos){
            sb.append("REF: ").append(m.getNum_ref())
                    .append(" / precioBase: ").append(m.getPrecioBase()).append("€")
                    .append(" / precioPlaza: ").append(m.getPrecioPlaza()).append("€")
                    .append(" / numeroPlazas: ").append(m.getNumPlazas())
                    .append(" / precioTotalPlazas: ").append(m.getPrecioTotalPlazas()).append("€")
                    .append(" / precioTotal: ").append(m.getPrecioTotal()).append("€")
                    .append(" / ").append(m.getTamanho()).append("m2")
                    .append(" / Habitaciones: ").append(m.getHabitaciones())
                    .append(" / CP: ").append(m.getCod_postal()).append("\n");
        }
        return sb.toString();
    }

}
