package e1;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class GestionBilletesTest {
    static Date tripDate = new Date();
    public static ArrayList<Billetes> originalBilletes  = new ArrayList<>(List.of(new Billetes[]{
            new Billetes("MADRID", "BARCELONA", 100, tripDate),
            new Billetes("MADRID", "SEVILLA", 100, tripDate),
            new Billetes("BARCELONA", "LAPALMA", 90, tripDate)
    }));
    public static ArrayList<Billetes> originalBilletes2  = new ArrayList<>(List.of(new Billetes[]{
            new Billetes("FERROL", "CORUÑA", 8, tripDate),
            new Billetes("SANTIAGO", "VIGO", 10, tripDate),
            new Billetes("OURENSE", "LUGO", 15, tripDate),
            new Billetes("OVIEDO", "BILBAO", 20, tripDate),
            new Billetes("LOGROÑO", "VALENCIA", 40, tripDate),
            new Billetes("CARTAGENA", "MÁLAGA", 30, tripDate),
            new Billetes("BARCELONA", "PARÍS", 50, tripDate),
            new Billetes("LONDRES", "MANCHESTER", 98, tripDate),
            new Billetes("OPORTO", "LUGO", 15, tripDate)

    }));


    @Test
    void equalsTest1() throws ParseException {
        ListadoBilletes lista = new ListadoBilletes(originalBilletes);
        GestionBilletes gestor = new GestionBilletes(lista);
        ListadoBilletes listadoBilletesExpected = new ListadoBilletes(new ArrayList<>(List.of(new Billetes[] {
                new Billetes("MADRID", "BARCELONA", 100, tripDate),
                new Billetes("MADRID", "SEVILLA", 100, tripDate),
                new Billetes("BARCELONA", "LAPALMA", 90, tripDate)
        })));
        assertEquals(listadoBilletesExpected, gestor.getBilletes("origen=MADRID OR origen=BARCELONA AND destino=BARCELONA OR destino=SEVILLA OR destino=LAPALMA"));

        listadoBilletesExpected = new ListadoBilletes(new ArrayList<>(List.of(new Billetes[] {
                new Billetes("MADRID", "BARCELONA", 100, tripDate),
        })));
        assertEquals(listadoBilletesExpected, gestor.getBilletes("origen=MADRID AND destino=BARCELONA"));

        listadoBilletesExpected = new ListadoBilletes(new ArrayList<>(List.of(new Billetes[] {
                new Billetes("MADRID", "BARCELONA", 100, tripDate),
        })));
        assertEquals(listadoBilletesExpected, gestor.getBilletes("origen=MADRID OR origen=FERROL AND destino=BARCELONA AND precio = 100"));

        listadoBilletesExpected = new ListadoBilletes(new ArrayList<>(List.of(new Billetes[] {
                new Billetes("BARCELONA", "LAPALMA", 90, tripDate),
        })));
        assertEquals(listadoBilletesExpected, gestor.getBilletes("precio < 100"));

    }

    @Test
    void equalTest2() throws ParseException {
        ListadoBilletes lista = new ListadoBilletes(originalBilletes2);
        GestionBilletes gestor = new GestionBilletes(lista);

        ListadoBilletes listadoBilletesExpected = new ListadoBilletes(new ArrayList<>(List.of(new Billetes[] {
                new Billetes("LONDRES", "MANCHESTER", 98, tripDate),
        })));

        assertEquals(listadoBilletesExpected, gestor.getBilletes("destino=MANCHESTER AND origen=LONDRES AND precio < 100 AND precio > 90"));

        listadoBilletesExpected = new ListadoBilletes(new ArrayList<>(List.of(new Billetes[] {
                new Billetes("BARCELONA", "PARÍS", 50, tripDate),
                new Billetes("LONDRES", "MANCHESTER", 98, tripDate),
        })));

        assertEquals(listadoBilletesExpected, gestor.getBilletes("precio ≥ 50"));

        listadoBilletesExpected = new ListadoBilletes(new ArrayList<>(List.of(new Billetes[] {
                new Billetes("SANTIAGO", "VIGO", 10, tripDate),
                new Billetes("OURENSE", "LUGO", 15, tripDate),
                new Billetes("OVIEDO", "BILBAO", 20, tripDate),
                new Billetes("OPORTO", "LUGO", 15, tripDate)

        })));
        assertEquals(listadoBilletesExpected, gestor.getBilletes("precio ≥ 10 AND precio ≤ 20"));





    }
}
