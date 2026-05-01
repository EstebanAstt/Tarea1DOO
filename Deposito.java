import java.util.ArrayList;

class Deposito<T> { //deposito<T> sirve para crear un deposito generico
    private ArrayList<T> dep;

    public Deposito() {
        this.dep = new ArrayList<T>();
    }

    public void add(T item) {
        dep.add(item);
    }

    public T get() {
        if (dep.size() != 0) {
            return dep.remove(0);
        }
        else{
            return null;
        }
    }
}