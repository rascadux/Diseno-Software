package e2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AnunciosTest {
    Anuncio anuncio1 = new Anuncio(110, 200, 0, 0, 40, 1, 15007);
    Anuncio anuncio2 = new Anuncio(111, 450, 70, 2, 110, 2, 15008);
    Anuncio anuncio3 = new Anuncio(112, 500, 65, 1, 95, 3, 15009);
    Anuncio anuncio4 = new Anuncio(113, 775, 80, 3, 135, 4, 15010);
    Anuncio anuncio5 = new Anuncio(115, 1200, 100, 1, 180, 6, 15011);


    @Test
    void constructores(){

        assertEquals(111, anuncio2.getNum_ref());
        assertEquals(450, anuncio2.getPrecioBase());
        assertEquals(2, anuncio2.getNumPlazas());
        assertEquals(70, anuncio2.getPrecioPlaza());
        assertEquals(140, anuncio2.getPrecioTotalPlazas());
        assertEquals(590, anuncio2.getPrecioTotal());
        //anuncio1.setTamanho(200);
        assertEquals(110, anuncio2.getTamanho());
        //anuncio1.setTamanho(110);
        assertEquals(2, anuncio2.getHabitaciones());
        assertEquals(15008, anuncio2.getCod_postal());

    }

    @Test
    void Ordenacion(){
        Apartamentos apartamentos = new Apartamentos();//Como los queremos ordenar?

        apartamentos.addAnuncio(anuncio1);
        apartamentos.addAnuncio(anuncio2);
        apartamentos.addAnuncio(anuncio3);
        apartamentos.addAnuncio(anuncio4);
        apartamentos.addAnuncio(anuncio5);

        apartamentos.setCriterio("precio base");
        apartamentos.OrdenarporCriterio();

        assertEquals("""
                    REF: 110 / precioBase: 200€ / precioPlaza: 0€ / numeroPlazas: 0 / precioTotalPlazas: 0€ / precioTotal: 200€ / 40m2 / Habitaciones: 1 / CP: 15007
                    REF: 111 / precioBase: 450€ / precioPlaza: 70€ / numeroPlazas: 2 / precioTotalPlazas: 140€ / precioTotal: 590€ / 110m2 / Habitaciones: 2 / CP: 15008
                    REF: 112 / precioBase: 500€ / precioPlaza: 65€ / numeroPlazas: 1 / precioTotalPlazas: 65€ / precioTotal: 565€ / 95m2 / Habitaciones: 3 / CP: 15009
                    REF: 113 / precioBase: 775€ / precioPlaza: 80€ / numeroPlazas: 3 / precioTotalPlazas: 240€ / precioTotal: 1015€ / 135m2 / Habitaciones: 4 / CP: 15010
                    REF: 115 / precioBase: 1200€ / precioPlaza: 100€ / numeroPlazas: 1 / precioTotalPlazas: 100€ / precioTotal: 1300€ / 180m2 / Habitaciones: 6 / CP: 15011
                    """, apartamentos.imprimirAnuncios());

        apartamentos.setCriterio("precio total");
        apartamentos.OrdenarporCriterio();

        assertEquals("""
                    REF: 110 / precioBase: 200€ / precioPlaza: 0€ / numeroPlazas: 0 / precioTotalPlazas: 0€ / precioTotal: 200€ / 40m2 / Habitaciones: 1 / CP: 15007
                    REF: 112 / precioBase: 500€ / precioPlaza: 65€ / numeroPlazas: 1 / precioTotalPlazas: 65€ / precioTotal: 565€ / 95m2 / Habitaciones: 3 / CP: 15009
                    REF: 111 / precioBase: 450€ / precioPlaza: 70€ / numeroPlazas: 2 / precioTotalPlazas: 140€ / precioTotal: 590€ / 110m2 / Habitaciones: 2 / CP: 15008
                    REF: 113 / precioBase: 775€ / precioPlaza: 80€ / numeroPlazas: 3 / precioTotalPlazas: 240€ / precioTotal: 1015€ / 135m2 / Habitaciones: 4 / CP: 15010
                    REF: 115 / precioBase: 1200€ / precioPlaza: 100€ / numeroPlazas: 1 / precioTotalPlazas: 100€ / precioTotal: 1300€ / 180m2 / Habitaciones: 6 / CP: 15011
                    """, apartamentos.imprimirAnuncios());

        apartamentos.setCriterio("habitaciones");
        apartamentos.OrdenarporCriterio();

        assertEquals("""
                    REF: 110 / precioBase: 200€ / precioPlaza: 0€ / numeroPlazas: 0 / precioTotalPlazas: 0€ / precioTotal: 200€ / 40m2 / Habitaciones: 1 / CP: 15007
                    REF: 111 / precioBase: 450€ / precioPlaza: 70€ / numeroPlazas: 2 / precioTotalPlazas: 140€ / precioTotal: 590€ / 110m2 / Habitaciones: 2 / CP: 15008
                    REF: 112 / precioBase: 500€ / precioPlaza: 65€ / numeroPlazas: 1 / precioTotalPlazas: 65€ / precioTotal: 565€ / 95m2 / Habitaciones: 3 / CP: 15009
                    REF: 113 / precioBase: 775€ / precioPlaza: 80€ / numeroPlazas: 3 / precioTotalPlazas: 240€ / precioTotal: 1015€ / 135m2 / Habitaciones: 4 / CP: 15010
                    REF: 115 / precioBase: 1200€ / precioPlaza: 100€ / numeroPlazas: 1 / precioTotalPlazas: 100€ / precioTotal: 1300€ / 180m2 / Habitaciones: 6 / CP: 15011
                    """, apartamentos.imprimirAnuncios());

        apartamentos.setCriterio("tamaño");
        apartamentos.OrdenarporCriterio();

        assertEquals("""
                    REF: 110 / precioBase: 200€ / precioPlaza: 0€ / numeroPlazas: 0 / precioTotalPlazas: 0€ / precioTotal: 200€ / 40m2 / Habitaciones: 1 / CP: 15007
                    REF: 112 / precioBase: 500€ / precioPlaza: 65€ / numeroPlazas: 1 / precioTotalPlazas: 65€ / precioTotal: 565€ / 95m2 / Habitaciones: 3 / CP: 15009
                    REF: 111 / precioBase: 450€ / precioPlaza: 70€ / numeroPlazas: 2 / precioTotalPlazas: 140€ / precioTotal: 590€ / 110m2 / Habitaciones: 2 / CP: 15008
                    REF: 113 / precioBase: 775€ / precioPlaza: 80€ / numeroPlazas: 3 / precioTotalPlazas: 240€ / precioTotal: 1015€ / 135m2 / Habitaciones: 4 / CP: 15010
                    REF: 115 / precioBase: 1200€ / precioPlaza: 100€ / numeroPlazas: 1 / precioTotalPlazas: 100€ / precioTotal: 1300€ / 180m2 / Habitaciones: 6 / CP: 15011
                    """, apartamentos.imprimirAnuncios());

        apartamentos.setCriterio(""); //Al ser nulo, deberia ordenar por numero de referencia
        apartamentos.OrdenarporCriterio();

        assertEquals("""
                    REF: 110 / precioBase: 200€ / precioPlaza: 0€ / numeroPlazas: 0 / precioTotalPlazas: 0€ / precioTotal: 200€ / 40m2 / Habitaciones: 1 / CP: 15007
                    REF: 111 / precioBase: 450€ / precioPlaza: 70€ / numeroPlazas: 2 / precioTotalPlazas: 140€ / precioTotal: 590€ / 110m2 / Habitaciones: 2 / CP: 15008
                    REF: 112 / precioBase: 500€ / precioPlaza: 65€ / numeroPlazas: 1 / precioTotalPlazas: 65€ / precioTotal: 565€ / 95m2 / Habitaciones: 3 / CP: 15009
                    REF: 113 / precioBase: 775€ / precioPlaza: 80€ / numeroPlazas: 3 / precioTotalPlazas: 240€ / precioTotal: 1015€ / 135m2 / Habitaciones: 4 / CP: 15010
                    REF: 115 / precioBase: 1200€ / precioPlaza: 100€ / numeroPlazas: 1 / precioTotalPlazas: 100€ / precioTotal: 1300€ / 180m2 / Habitaciones: 6 / CP: 15011
                    """, apartamentos.imprimirAnuncios());

    }
}
