public class Expendedor {
    private int numProductos;
    private int precioProductos;

    private Deposito<CocaCola> cocacola = new Deposito<>();
    private Deposito<Sprite> sprite = new Deposito<>();
    private Deposito<Fanta> fanta = new Deposito<>();
    private Deposito<Super8> super8 = new Deposito<>();
    private Deposito<Snickers> snickers = new Deposito<>();
    private Deposito<Moneda> monVu = new Deposito<>();

    public static final int  COCA=1;
    public static final int  SPRITE=2;
    public static final int  FANTA=3;
    public static final int  SUPER8=4;
    public static final int  SNICKERS=5;

    public Expendedor(int numProductos){
        this.numProductos = numProductos;


        int cont = 1;
        for(int i = 0; i < this.numProductos; i++){
            cocacola.add(new CocaCola(cont));
            sprite.add(new Sprite(cont+1));
            fanta.add(new Fanta(cont+2));
            super8.add(new Super8(cont+3));
            snickers.add(new Snickers(cont+4));
            cont+=5;
        }


    }
    public Producto comprarProducto(Moneda m, int cual){
        switch(cual) {
            case COCA:
                this.precioProductos = Precio.COCA.getValor();
                break;
            case SPRITE:
                this.precioProductos = Precio.SPRITE.getValor();
                break;
            case FANTA:
                this.precioProductos = Precio.FANTA.getValor();
                break;
            case SUPER8:
                this.precioProductos = Precio.SUPER8.getValor();
                break;
            case SNICKERS:
                this.precioProductos = Precio.SNICKERS.getValor();
                break;
            default:
                monVu.add(m);  // deposito no existe
                return null;
        }


        if(m == null) return null; // en este if tiene que ir PagoIncorrectoException
        if(m.getValor() < precioProductos){ //en este if tiene que ir PagoInsuficienteException
            monVu.add(m);
            return null;
        }


        Producto p = null;
        switch(cual) {
            case COCA:
                p = cocacola.get();
                break;
            case SPRITE:
                p = sprite.get();
                break;
            case FANTA:
                p = fanta.get();
                break;
            case SUPER8:
                p = super8.get();
                break;
            case SNICKERS:
                p = snickers.get();
                break;
        }

        if(p == null){ //en este if tiene que ir NoHayProductoException
            monVu.add(m);
            return null;
        }

        int diff = m.getValor() - precioProductos; //con esto se crea el vuelto y se almacena en monedas de 100
        for(int i = 0; i < diff; i+=100){
            monVu.add(new Moneda100());
        }
        return p;

    }

    public Moneda getVuelto() {
        return monVu.get();
    }
}
