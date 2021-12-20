package e1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FiltradoDestinoTest {
    static Date tripDate = new Date();
    public static ArrayList<Billetes> originalBilletes  = new ArrayList<>(List.of(new Billetes[]{
            new Billetes("MADRID", "SEVILLA", 100, tripDate),
            new Billetes("CADIZ", "SEVILLA", 100, tripDate),
            new Billetes("BARCELONA", "PARIS", 100, tripDate)
    }));

    @Test
    @DisplayName("It should retrieve only tickets with destiny equals to 'Sevilla'")
    void filterOrigenTest() {
        Filtrado f = new FiltradoDestino("SEVILLA", new ListadoBilletes(FiltradoDestinoTest.originalBilletes));
        ListadoBilletes listadoBilletes = f.getBilletes();
        ListadoBilletes listadoBilletesExpected = new ListadoBilletes(new ArrayList<>(List.of(new Billetes[] {
                new Billetes("MADRID", "SEVILLA", 100, tripDate),
                new Billetes("CADIZ", "SEVILLA", 100, tripDate)
        })));
        assertEquals(listadoBilletesExpected, listadoBilletes);
    }

    @Test
    @DisplayName("It should retrieve empty list if destiny is not in any ticket")
    void filterOrigenNotExistingTest() {
        Filtrado f = new FiltradoDestino("LA PALMA", new ListadoBilletes(FiltradoDestinoTest.originalBilletes));
        ListadoBilletes listadoBilletes = f.getBilletes();
        ListadoBilletes listadoBilletesExpected = new ListadoBilletes(new ArrayList<>());
        assertEquals(listadoBilletesExpected, listadoBilletes);
    }
}
