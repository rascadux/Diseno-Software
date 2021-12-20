package e1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FiltradoOrigenTest {
    static Date tripDate = new Date();
    public static ArrayList<Billetes> originalBilletes  = new ArrayList<>(List.of(new Billetes[]{
            new Billetes("MADRID", "BARCELONA", 100, tripDate),
            new Billetes("MADRID", "SEVILLA", 100, tripDate),
            new Billetes("BARCELONA", "LA PALMA", 100, tripDate)
    }));

    @Test
    @DisplayName("It should retrieve only tickets with origin equals to 'Madrid'")
    void filterDestinyTest() {
        Filtrado f = new FiltradoOrigen("MADRID", new ListadoBilletes(FiltradoOrigenTest.originalBilletes));
        ListadoBilletes listadoBilletes = f.getBilletes();
        Filtrado f2 = new FiltradoDestino("BARCELONA",listadoBilletes);//origen = MADRID AND destino = BARCELONA

        ListadoBilletes listadoBilletesExpected = new ListadoBilletes(new ArrayList<>(List.of(new Billetes[] {
                new Billetes("MADRID", "BARCELONA", 100, tripDate),
        })));
        assertEquals(listadoBilletesExpected, f2.getBilletes());
    }

    @Test
    @DisplayName("It should retrieve empty list if origin is not in any ticket")
    void filterDestinyNotExistingTest() {
        Filtrado f = new FiltradoOrigen("MALAGA", new ListadoBilletes(FiltradoOrigenTest.originalBilletes));
        ListadoBilletes listadoBilletes = f.getBilletes();
        ListadoBilletes listadoBilletesExpected = new ListadoBilletes(new ArrayList<>());
        assertEquals(listadoBilletesExpected, listadoBilletes);
    }
}