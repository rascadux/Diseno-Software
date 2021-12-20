package e1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class ListadoBilletes {
    ArrayList<Billetes> listaBilletes;

    public ListadoBilletes(){
        listaBilletes = new ArrayList<>();
    }

    public ListadoBilletes(ArrayList<Billetes> listaBilletes) {
        this.listaBilletes = listaBilletes;
    }

    public ArrayList<Billetes> getListaBilletes() {
        return listaBilletes;
    }

    public void setBilletes(Billetes billete) {
        this.listaBilletes.add(billete);
    }

    public void addListBilletes(ArrayList<Billetes> listaBilletes){
        this.listaBilletes.addAll(listaBilletes);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListadoBilletes that = (ListadoBilletes) o;
        return Objects.equals(listaBilletes, that.listaBilletes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listaBilletes);
    }

    @Override
    public String toString() {
        return "ListadoBilletes{" +
                "listaBilletes=" + listaBilletes +
                '}';
    }
}
