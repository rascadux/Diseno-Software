package e1;

import java.util.ArrayList;

public class Colegio {
    public ArrayList<Integrante> colegio;//guardaremos alumnos y personal
    public ArrayList<Personal> personal;//solo personal, para cuestiones de salarios

    public Colegio(){
        this.colegio = new ArrayList<>();
        this.personal = new ArrayList<>();
    }

    public void addPersonal(Personal personal){
        this.personal.add(personal);
    }

    public void addIntegrante(Integrante integrante){
        this.colegio.add(integrante);
    }

    public String imprimirRecompensas(){
        float Recompensas=0.0f;
        StringBuilder sb = new StringBuilder();
        for (Integrante m: colegio) {
            sb.append(m.nombre).append(" ").append(m.apellido);
            sb.append("(").append(m.informacion).append(",").append(m.horrocruxes).append(" horrocruxes): ");
            sb.append(m.recompensa).append(" galeones\n");
            Recompensas += m.recompensa;
        }
        sb.append("La recompensa total del Colegio Hogwarts es de ").append(Recompensas).append(" galeones");
        return sb.toString();
    }

    public String imprimirSalarios(){
        int Salarios=0;
        StringBuilder sb = new StringBuilder();
        for (Personal p: personal) {
            sb.append(p.nombre).append(" ").append(p.apellido);
            sb.append("(").append(p.informacion).append("): ");
            sb.append(p.salario).append(" galeones\n");
            Salarios += p.salario;
        }
        sb.append("El gasto de Hogwarts en personal es de ").append(Salarios).append(" galeones");
        return sb.toString();
        }
    }
