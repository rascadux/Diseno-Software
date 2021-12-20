package e1;


public class OperacionAND implements OperacionLogica{
    @Override
    public ListadoBilletes match(ListadoBilletes l1, ListadoBilletes l2) {
        ListadoBilletes lista = new ListadoBilletes();
        for (Billetes b : l1.listaBilletes) {
            if(l2.listaBilletes.contains(b)) {
                lista.listaBilletes.add(b);
            }
        }
        return lista;
    }
}
