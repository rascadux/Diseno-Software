package e1;

public class OperacionOR implements OperacionLogica{
    @Override
    public ListadoBilletes match(ListadoBilletes l1, ListadoBilletes l2) {
        l1.addListBilletes(l2.listaBilletes);
        return l1;
    }
}
