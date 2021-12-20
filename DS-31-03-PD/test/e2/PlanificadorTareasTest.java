package e2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlanificadorTareasTest {
    //Creacion del grafo:
    Vertice Vaux = new Vertice("AUXILIAR"); //nodo auxiliar raiz

    Vertice Vc = new Vertice("C");
    Vertice Va = new Vertice("A");
    Vertice Vb = new Vertice("B");
    Vertice Vd = new Vertice("D");
    Vertice Ve = new Vertice("E");

    Vertice Vg = new Vertice("G");
    Vertice Vf = new Vertice("F");
    Vertice Vh = new Vertice("H");
    Vertice Vj = new Vertice("J");

    @Test
    void FuerteTest(){

        //Vertices iniciales
        Vaux.addVecino(Vc);
        Vaux.addVecino(Vg);
        //C                    //A                   //B                 //D
        Vc.addVecino(Vf);   Va.addVecino(Vd);   Vb.addVecino(Ve);   Vd.addVecino(Ve);
        Vc.addVecino(Va);   Va.addVecino(Vb);
        //G                 //H                 //F
        Vg.addVecino(Vf);   Vh.addVecino(Vj);   Vf.addVecino(Ve);
        Vg.addVecino(Vh);                       Vf.addVecino(Vj);

        OrdenRealizacion algoritmo = new dependenciaFuerte();
        Vaux.setAlgoritmo(algoritmo);
        assertEquals("C - A - B - D - G - F - E - H - J", Vaux.Ordenacion());
    }

    @Test
    void DebilTest(){
        //Vertices iniciales
        Vaux.addVecino(Vc);
        Vaux.addVecino(Vg);
        //C                    //A                   //B                 //D
        Vc.addVecino(Vf);   Va.addVecino(Vd);   Vb.addVecino(Ve);   Vd.addVecino(Ve);
        Vc.addVecino(Va);   Va.addVecino(Vb);
        //G                 //H                 //F
        Vg.addVecino(Vf);   Vh.addVecino(Vj);   Vf.addVecino(Ve);
        Vg.addVecino(Vh);                       Vf.addVecino(Vj);

        OrdenRealizacion algoritmo = new dependenciaDebil();
        Vaux.setAlgoritmo(algoritmo);
        assertEquals("C - A - B - D - E - F - G - H - J", Vaux.Ordenacion());
    }

    @Test
    void jerarquicoTest(){
        //Vertices iniciales
        Vaux.addVecino(Vc);
        Vaux.addVecino(Vg);
        //C                    //A                   //B                 //D
        Vc.addVecino(Vf);   Va.addVecino(Vd);   Vb.addVecino(Ve);   Vd.addVecino(Ve);
        Vc.addVecino(Va);   Va.addVecino(Vb);
        //G                 //H                 //F
        Vg.addVecino(Vf);   Vh.addVecino(Vj);   Vf.addVecino(Ve);
        Vg.addVecino(Vh);                       Vf.addVecino(Vj);

        OrdenRealizacion algoritmo = new ordenJerarquico();
        Vaux.setAlgoritmo(algoritmo);
        assertEquals("C - G - A - F - H - B - D - E - J", Vaux.Ordenacion());


    }
}
