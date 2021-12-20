package e1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FiltradoPrecioTest {
    static Date tripDate = new Date();
    public static ArrayList<Billetes> originalBilletes  = new ArrayList<>(List.of(new Billetes[]{
            new Billetes("MADRID", "BARCELONA", 120, tripDate),
            new Billetes("MADRID", "SEVILLA", 120, tripDate),
            new Billetes("BARCELONA", "LA PALMA", 100, tripDate)
    }));

    @Test
    @DisplayName("It should retrieve only tickets with price equals to 120")
    void filterPriceTest() {
        Filtrado f = new FiltradoPrecio(120, new ListadoBilletes(FiltradoPrecioTest.originalBilletes), "=");
        ListadoBilletes listadoBilletes = f.getBilletes();
        ListadoBilletes listadoBilletesExpected = new ListadoBilletes(new ArrayList<>(List.of(new Billetes[] {
                new Billetes("MADRID", "BARCELONA", 120, tripDate),
                new Billetes("MADRID", "SEVILLA", 120, tripDate)
        })));
        assertEquals(listadoBilletesExpected, listadoBilletes);
    }

    @Test
    @DisplayName("It should retrieve empty list if price is not in any ticket")
    void filterPriceNotExistingTest() {
        Filtrado f = new FiltradoPrecio(90, new ListadoBilletes(FiltradoPrecioTest.originalBilletes), "=");
        ListadoBilletes listadoBilletes = f.getBilletes();
        ListadoBilletes listadoBilletesExpected = new ListadoBilletes(new ArrayList<>());
        assertEquals(listadoBilletesExpected, listadoBilletes);
    }

}
