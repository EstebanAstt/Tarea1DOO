public class Expendedor {
    private int numProductos;
    private int precioBebidas;

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

    public Expendedor(int numProductos, int precioBebidas){
        this.numProductos = numProductos;
        this.precioBebidas = precioBebidas;


        int cont = 0;
        for(int i = 0; i < this.numProductos; i++){
            cocacola.add(new CocaCola(cont));
            cont++;
        }
        for(int i = 0; i < this.numProductos; i++){
            sprite.add(new Sprite(cont));
            cont++;
        }
        for(int i = 0; i < this.numProductos; i++){
            fanta.add(new Fanta(cont));
            cont++;
        }
        for(int i = 0; i < this.numProductos; i++){
            super8.add(new Super8(cont));
            cont++;
        }

    }
    public Bebida comprarBebida(Moneda m, int cual){
        if(m == null) return null;
        if(m.getValor() < precioBebidas){
            monVu.add(m);
            return null;
        }
        Producto p = null;
        switch (cual) {
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
            default:
                monVu.add(m);  // deposito no existe
                return null;
        }

        if(b == null){
            monVu.add(m);
            return null;
        }
        //xd

        int diff = m.getValor() - precioBebidas; //con esto se crea el vuelto y se almacena en monedas de 100
        for(int i = 0; i < diff; i+=100){
            monVu.add(new Moneda100());
        }
        return b;

    }

    public Moneda getVuelto() {
        return monVu.get();
    }

}
