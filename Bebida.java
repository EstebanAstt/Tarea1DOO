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
    public int getPrecio(){
        return 100;
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
    public int getPrecio(){
        return 100;
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
    public int getPrecio(){
        return 100;
    }
}
