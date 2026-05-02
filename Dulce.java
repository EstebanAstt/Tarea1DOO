/**
 * la clase {@link Dulce} es subclase de producto y a su vez es la clase padre de Super8 y Snickers respectivamente
 * Para hacer que clase Dulce y Bebida tuvieran otras diferencias ademas de del nombre fue poner dos metodos distintos,
 * en bebida es String beber y en Dulce es String comer
 */
public abstract class Dulce extends Producto {
    /**
     *
     * @param serie el constructor ya esta definido en producto, por lo que para definir la serie se debe llamar a la clase super
     */
    public Dulce(int serie){
        super(serie);
    }

    public abstract String comer();
}


class Super8 extends Dulce{
    public Super8 (int serie) {
        super(serie);
    }
    @Override
    public String comer(){
        return "Super8";
    }


}

class Snickers extends Dulce{
    public Snickers(int serie) {
        super(serie);
    }
    @Override
    public String comer(){
        return "Snickers";
    }

}
