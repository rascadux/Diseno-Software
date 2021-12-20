package e1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FiltradoFechaTest {
    static Date tripDate = new Date();

    public static ArrayList<Billetes> originalBilletes  = new ArrayList<>(List.of(new Billetes[]{
            new Billetes("MADRID", "BARCELONA", 100, tripDate),
            new Billetes("MADRID", "SEVILLA", 100, tripDate),
            new Billetes("BARCELONA", "LA PALMA", 100, tripDate)
    }));
    @Test
    void filterTimeTest(){
        Filtrado f = new FiltradoFecha(tripDate, new ListadoBilletes(FiltradoFechaTest.originalBilletes));
        ListadoBilletes listadoBilletes = f.getBilletes();
        ListadoBilletes listadoBilletesExpected = new ListadoBilletes(new ArrayList<>(List.of(new Billetes[] {
                new Billetes("MADRID", "BARCELONA", 100, tripDate),
                new Billetes("MADRID", "SEVILLA", 100, tripDate),
                new Billetes("BARCELONA", "LA PALMA", 100, tripDate)
        })));
        assertEquals(listadoBilletesExpected, listadoBilletes);

    }
    @Test
    void filterTimeNotExistingTest() {
        Date date1 = new Date();
        date1.setTime(1000000);//cambiamos la fecha para que no coincida con la de ningún billete
        Filtrado f = new FiltradoFecha(date1, new ListadoBilletes(FiltradoFechaTest.originalBilletes));
        ListadoBilletes listadoBilletes = f.getBilletes();
        ListadoBilletes listadoBilletesExpected = new ListadoBilletes(new ArrayList<>());
        assertEquals(listadoBilletesExpected, listadoBilletes);
    }


}
