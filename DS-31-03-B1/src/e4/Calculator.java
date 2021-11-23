package e4;

import java.util.Arrays;


public class Calculator {
    private float result;
    // private Operations operations;
    private float[] values_l = new float[10]; //Array para almacenar los valores de los operandos
    private String[] operation_l = new String[5];//Array para almacenar los operadores
    /*enum Operations{
        MULTIPLICACION("*"), DIVISION("/"), SUMA("+"),
        RESTA("-");
        private final String operation;


        Operations(String op){
            this.operation = op;
        }
*/

    private void setOperation(String operation) { //recorre el array operations_l hasta llegar al ultimo hueco y mete la operacion
        int i=0;
        for (i = 0; i != tamanio_s(operation_l); i++) {
                operation_l[i+1] = operation;
        }
        if(i==0){//si no hay nada dentro aun, porque si no hay nada no entra en el bucle
            operation_l[0] = operation;
        }
    }

    private void setValues(float value) {
        int i=0;
        for (i = 0; i != tamanio_f(values_l); i++) {
            values_l[i+1] = value;
        }
        if(i==0){//si no hay nada dentro aun, porque si no hay nada no entra en el bucle
            values_l[0] = value;
        }
    }

    private int tamanio_s(String[] array) { //dice cuantos campos hay llenos dentro del array (SOLO STRINGS)
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                count++;
            }
        }
        return count;
    }
    private int tamanio_f(float[] array) { //dice cuantos campos hay llenos dentro del array (SOLO STRINGS)
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0.0f) {
                count++;
            }
        }
        return count;
    }

    /**
     * Public constructor of the calculator .
     */
    public Calculator() {
    }

    /**
     * Clean the internal state of the calculator
     */
    public void cleanOperations() {
        Arrays.fill(operation_l, null);
        Arrays.fill(values_l, 0.0f);
        this.result = 0;
    }

    /**
     * Add a new operation to the internal state of the calculator .
     * It is worth mentioning that the calculator behaves in an accumulative way ,
     * thus only first operation has two operands .
     * The rest of computations work with the accumulated value and only an extra
     * new operand . Second input value must be ignored if the operation does not
     * correspond to the first one .
     *
     * @param operation operation to add , as string , "+" , " -" , "*" , "/".
     * @param values    Operands of the new operation ( one or two operands ).
     *                  Uses the varargs feature .
     *                  https :// docs . oracle . com / javase /8/ docs / technotes / guides / language / varargs . html
     * @throws IllegalArgumentException If the operation does not exist .
     */
    public void addOperation(String operation, float... values) {
        if (!(operation.equals("+") || operation.equals("-") //Comprueba que se mete una operacion valida
                || operation.equals("*") || operation.equals("/"))) {
            throw new IllegalArgumentException();
        }
        this.setOperation(operation); //Guarda la operacion en el array operation_l
        for (float value : values) { //Guarda los valores metido en el array de values_l
            this.setValues(value);
        }
    }

    /**
     * Execute the set of operations of the internal state of the calculator .
     * Once execution is finished , internal state ( operands and operations )
     * is restored ( EVEN if exception occurs ).
     * This calculator works with " Batches " of operations .
     *
     * @return result of the execution
     * @throws ArithmeticException If the operation returns an invalid value
     *                             ( division by zero )
     */
    public float executeOperations() {
        for (int i = 0; i < tamanio_s(operation_l); i++) {
            if (operation_l[i].equals("+")) { //SI ES SUMA:
                if (i == 0) { //si es la primera operacion que se hace
                    result = values_l[0] + values_l[1];
                } else {
                    result = result + values_l[i + 1];//si es la segunda operacion, hace result + values_l[2] y asi con la q sea
                }
            }
            if (operation_l[i].equals("-")) {
                if (i == 0) { //si es la primera operacion que se hace
                    result = values_l[0] - values_l[1];
                } else {
                    result = result - values_l[i + 1];//si es la operacion2, values_l[2], si es operacion3, values_l[3] y asi con la q sea
                }
            }
            if (operation_l[i].equals("*")) {
                if (i == 0) { //si es la primera operacion que se hace
                    result = values_l[0] * values_l[1];
                } else {
                    result = result * values_l[i + 1];//si es la operacion2, values_l[2], si es operacion3, values_l[3] y asi con la q sea
                }
            }
            if (operation_l[i].equals("/")) {
                if (i == 0) { //si es la primera operacion que se hace
                    if (values_l[1] == 0) {
                        throw new ArithmeticException();
                    }
                    result = values_l[0] / values_l[1];
                } else {
                    if (values_l[i + 1] == 0) {
                        throw new ArithmeticException();
                    }
                    result = result / values_l[i + 1];//si es la operacion2, values_l[2], si es operacion3, values_l[3] y asi con la que sea
                }
            }
        }
        return this.result;
    }

    /**
     * Current internal state of calculator is printed
     * FORMAT :
     * "[{+/ -/"/"/*}] value1_value2 [{+/ -/"/"/*}] value1 [{+/ -/"/"/*}] value1 {...}"
     * EXAMPLES : JUnit tests
     * @return String of the internal state of the calculator
     */
    @Override
    public String toString () { //SIN HACER
        StringBuilder st = new StringBuilder("[STATE:");
        if(tamanio_s(operation_l) >= 1) {
            st.append("[" + operation_l[0]);
        }
        st.append("]");
        if(tamanio_f(values_l)!=0) {
            st.append(values_l[0] + "_" + values_l[1]);
        }
        if(tamanio_s(operation_l) >= 2){
            st.append("[" + operation_l[1] + "]");
        }
        return st.toString();
    }
}
