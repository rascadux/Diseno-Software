package e2;

public class Slopes {
    public static int downTheSlope(char[][] slopeMap, int right, int down) {
        int numCol = slopeMap[0].length;
        int numFil = slopeMap.length;
        int trees = 0;
        int j = 0;
        int i = 0;
        int z = 0;
        int auxRight = right;
        int auxDown = down;

        // aqui empiezan las condiciones de Illegal(hecho)
        if(numCol < 1 || numFil < 1 || right < 1 || down < 1 || down >= numCol || right >= numFil ){
            throw new IllegalArgumentException();
        }
        for (i = 0; i < numFil; i++) { //comprueba si un caracter es diferente a los establecidos
            for (j = 0; j < numCol; j++){
                if (slopeMap[i][j] != '.' && slopeMap[i][j] != '#') {
                    throw new IllegalArgumentException();
                }
                if(slopeMap[0].length != slopeMap[i].length){
                    throw new IllegalArgumentException();
                }
            }
        }
        i = j = 0; // volvemos a igualar a 0 nuestros pivotes
        //recorremos matriz y comprobaremos cuantos arboles hay
        while(i != numFil - 1){ //condicion que indica el final del recorrido
            while(auxRight != 0){
                j++;
                if (j == numCol){
                    j = 0; // reiniciamos si llega a la parte derecha del mapa
                }
                if (slopeMap[i][j] == '#'){
                    trees++;
                }
                auxRight--;
            }
            while(auxDown != 0){ //recorrer hacia abajo, dependiendo del valor que nos dan
                i++;
                if (i == numFil){
                    z = 1;
                    break; // sale del bucle si llega al final de las filas
                }
                if (slopeMap[i][j] == '#'){
                    trees++;
                }
                auxDown--;
            }
            if(z==1){ //Comprobamos si estamos en la ultima fila
                break;
            }
            auxDown = down; // volvemos a dar valor a aux para volver al siguiente while
            auxRight = right;
        }

        //Una vez llega a la ultima fila, empieza a recorrer hacia la derecha y acaba
        while(auxRight != 0){
            j++;
            if (j == numCol){
                j = 0; // reiniciamos si llega a la parte derecha del mapa
            }
            if (slopeMap[i][j] == '#'){
                trees++;
            }
            auxRight--;
        }
        return trees;
    }

    public static int jumpTheSlope(char[][] slopeMap, int right, int down) { //Solo sumas arbol en el utlimo salto hacia abajo
        int numCol = slopeMap[0].length;
        int numFil = slopeMap.length;
        int trees = 0;
        int j = 0;
        int i = 0;
        int z = 0;
        int auxRight = right;
        int auxDown = down;

        // aqui empiezan las condiciones de Illegal(hecho)
        if (numCol < 1 || numFil < 1 || right < 1 || down < 1 || down >= numCol || right >= numFil) {
            throw new IllegalArgumentException();
        }
        for (i = 0; i < numFil; i++) { //comprueba si un caracter es diferente a los establecidos
            for (j = 0; j < numCol; j++) {
                if (slopeMap[i][j] != '.' && slopeMap[i][j] != '#') {
                    throw new IllegalArgumentException();
                }
                if (slopeMap[0].length != slopeMap[i].length) {
                    throw new IllegalArgumentException();
                }
            }
        }
        i = j = 0; // volvemos a igualar a 0 nuestros pivotes
        //recorremos matriz y comprobaremos cuantos arboles hay
        while (i != numFil - 1) { //condicion que indica el final del recorrido
            while (auxRight != 0) {
                j++;
                if (j == numCol) {
                    j = 0; // reiniciamos si llega a la parte derecha del mapa
                }
                auxRight--;
            }
            while (auxDown != 0) { //recorrer hacia abajo, dependiendo del valor que nos dan
                i++;
                if (i == numFil) {
                    z = 1;
                    break; // sale del bucle si llega al final de las filas
                }
                if (auxDown == 1) {
                    if (slopeMap[i][j] == '#') {
                        trees++;
                    }
                }
                auxDown--;
            }
            if (z == 1) { //Comprobamos si estamos en la ultima fila
                break;
            }
            auxDown = down; // volvemos a dar valor a aux para volver al siguiente while
            auxRight = right;
        }
        return trees;
    }
}