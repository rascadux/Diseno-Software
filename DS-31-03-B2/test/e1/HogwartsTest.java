package e1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HogwartsTest {
    Estudiantes Hermione = new Estudiantes("Hermione", "Granger", 18, 3, Casa.GRYFFINDOR);
    Fantasmas Baron = new Fantasmas("Baron", "Sanguinario", 60, 1, Casa.SLYTHERIN);
    Guardabosques Hagrid = new Guardabosques("Rubeus", "Hagrid", 40, 2);
    Docentes Minerva = new Docentes("Minerva", "McGonagall", 90, 1, Asignatura.TRANSFORMACIONES);
    Docentes Severus = new Docentes("Severus", "Snape", 65, 2, Asignatura.DEFENSA);
    Conserjes Argus = new Conserjes("Argus", "Filch", 90, 0);
    Colegio colegio = new Colegio();

    @Test
    void constructores(){

        assertEquals("Estudiante de GRYFFINDOR", Hermione.getInformacion());
        Hermione.setCasa(Casa.SLYTHERIN);
        assertEquals(Casa.SLYTHERIN, Hermione.getCasa());
        Hermione.setCasa(Casa.GRYFFINDOR);
        assertEquals(3, Hermione.getHorrocruxes());

        assertEquals("Fantasma de SLYTHERIN", Baron.getInformacion());
        assertEquals(Casa.SLYTHERIN, Baron.getCasa());
        Baron.setCasa(Casa.HUFFLEPUFF);
        assertEquals(Casa.HUFFLEPUFF, Baron.getCasa());
        Baron.setCasa(Casa.SLYTHERIN);
        assertEquals("Baron Sanguinario", Baron.getNombre() + " " + Baron.getApellido());
        Baron.setApellido("Cacao");
        assertEquals("Cacao", Baron.getApellido());
        Baron.setApellido("Sanguinario");

        assertEquals("Guardabosques", Hagrid.getInformacion());
        assertEquals(Profesion.Guardabosques, Hagrid.getProfesion());
        assertEquals(180, Hagrid.getSalario());
        assertEquals(150.0f, Hagrid.getRecompensa());
        Hagrid.setHorrocruxes(50);
        assertEquals(50, Hagrid.getHorrocruxes());
        Hagrid.setHorrocruxes(2);

        assertEquals("Docente de TRANSFORMACIONES", Minerva.getInformacion());
        assertEquals(Asignatura.TRANSFORMACIONES, Minerva.getAsignatura());
        assertEquals(400, Minerva.getSalario());
        Minerva.setEdad(500);
        assertEquals(500, Minerva.getEdad());
        Minerva.setEdad(90);

        assertEquals("Docente de DEFENSA", Severus.getInformacion());
        assertEquals(Asignatura.DEFENSA, Severus.getAsignatura());
        Severus.setAsignatura(Asignatura.TRANSFORMACIONES);
        assertEquals(Asignatura.TRANSFORMACIONES, Severus.getAsignatura());
        Severus.setAsignatura(Asignatura.DEFENSA);

        assertEquals("Conserje", Argus.getInformacion());
        assertEquals("Argus", Argus.getNombre());
        Argus.setProfesion(Profesion.Docente);
        assertEquals(Profesion.Docente, Argus.getProfesion());
        Argus.setProfesion(Profesion.Conserje);

        assertThrows(IllegalArgumentException.class, () -> new Estudiantes("Daniel", "Rodriguez", 10, -3, Casa.SLYTHERIN));
        assertThrows(IllegalArgumentException.class, () -> new Estudiantes("Daniel", "Rodriguez", -5, 1, Casa.SLYTHERIN));
    }

    @Test
    void Recompensas(){

        colegio.addIntegrante(Hermione);
        colegio.addIntegrante(Baron);
        colegio.addIntegrante(Hagrid);
        colegio.addIntegrante(Minerva);
        colegio.addIntegrante(Severus);
        colegio.addIntegrante(Argus);

        assertEquals("""
                Hermione Granger(Estudiante de GRYFFINDOR,3 horrocruxes): 270.0 galeones
                Baron Sanguinario(Fantasma de SLYTHERIN,1 horrocruxes): 160.0 galeones
                Rubeus Hagrid(Guardabosques,2 horrocruxes): 150.0 galeones
                Minerva McGonagall(Docente de TRANSFORMACIONES,1 horrocruxes): 50.0 galeones
                Severus Snape(Docente de DEFENSA,2 horrocruxes): 75.0 galeones
                Argus Filch(Conserje,0 horrocruxes): 0.0 galeones
                La recompensa total del Colegio Hogwarts es de 705.0 galeones""", colegio.imprimirRecompensas());


    }

    @Test
    void Salarios(){
        colegio.addPersonal(Hagrid);
        colegio.addPersonal(Minerva);
        colegio.addPersonal(Severus);
        colegio.addPersonal(Argus);

        assertEquals("""
                Rubeus Hagrid(Guardabosques): 180 galeones
                Minerva McGonagall(Docente de TRANSFORMACIONES): 400 galeones
                Severus Snape(Docente de DEFENSA): 500 galeones
                Argus Filch(Conserje): 160 galeones
                El gasto de Hogwarts en personal es de 1240 galeones""", colegio.imprimirSalarios());

    }
}
