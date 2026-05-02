/**
 * la clase {@link Bebida} es subclase de producto y a su vez es la clase padre de Cocacola, Fanta y Sprite respectivamente
 * Para hacer que clase Dulce y Bebida tuvieran otras diferencias ademas de del nombre fue poner dos metodos distintos,
 * en bebida es String beber y en Dulce es String comer
 */
public abstract class Bebida extends Producto{
    private int serie;

    public Bebida(int serie) {
        super(serie);
    }

    public int getSerie() {
        return this.serie;
    }

    public abstract String beber();
}

class CocaCola extends Bebida {
    public CocaCola(int serie) {
        super(serie);
    }
    
    @Override
    public String beber() {
        return "cocacola";
    }
}

class Sprite extends Bebida {
    public Sprite(int serie) {
        super(serie);
    }
    
    @Override
    public String beber() {
        return "sprite";
    }
}

class Fanta extends Bebida {
    public Fanta(int serie) {
        super(serie);
    }
    
    @Override
    public String beber() {
        return "fanta";
    }
}
