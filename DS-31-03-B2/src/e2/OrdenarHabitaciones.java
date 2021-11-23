package e2;

import java.util.Comparator;

public class OrdenarHabitaciones implements Comparator<Anuncio> {

    @Override
    public int compare(Anuncio o1, Anuncio o2) {
        return o1.getHabitaciones() - o2.getHabitaciones();
    }

}
