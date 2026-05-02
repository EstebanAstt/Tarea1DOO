import java.util.ArrayList;

/**
 * en {@link Deposito<T>} se crea el deposito generico, que sirve tanto como para guardar bebidas como dulces o monedas
 * @param <T> se crea dep, un arraylist en el que T simboliza ese objeto generico pero unico que podra ingresar al deposito
 * holaaa
 *
 */
public class Deposito<T> {
    private ArrayList<T> dep;

    public Deposito() {
        this.dep = new ArrayList<T>();
    }

    /**
     *
     * @param item se añade el item generico al array list, en este proyecto se utiliza para rellenar inicialmente el expendedor y para entregar el vuelto
     */
    public void add(T item) {
        dep.add(item);
    }

    /**
     *
     * @return se retorna el objeto que esta en el arraylist generico y si el arraylist esta vacio, retorna null
     */
    public T get() {
        if (dep.size() != 0) {
            return dep.remove(0);
        }
        else{
            return null;
        }
    }
}