package e1;

import java.util.Date;
import java.util.Objects;

public class Billetes {
    private final String Origen;
    private final String Destino;
    private final int precio;
    private final Date fecha;

    public Billetes(String origen, String destino, int precio, Date fecha) {
        this.Origen = origen;
        this.Destino = destino;
        this.precio = precio;
        this.fecha = fecha;
    }

    public String getOrigen() {
        return this.Origen;
    }

    public String getDestino() {
        return this.Destino;
    }

    public int getPrecio() {
        return this.precio;
    }

    public Date getFecha() {
        return this.fecha;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Billetes billetes = (Billetes) o;
        return precio == billetes.precio && Objects.equals(Origen, billetes.Origen) && Objects.equals(Destino, billetes.Destino) && Objects.equals(fecha, billetes.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Origen, Destino, precio, fecha);
    }

    @Override
    public String toString() {
        return "Billetes{" +
                "Origen='" + Origen + '\'' +
                ", Destino='" + Destino + '\'' +
                ", precio=" + precio +
                ", fecha=" + fecha +
                '}';
    }
}
