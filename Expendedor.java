/**
 * la clase {@link Expendedor} es la que conecta todo para el comprador,
 * es por eso que tiene un codigo mas largo
 */

public class Expendedor {
    private int numProductos;
    private int precioProductos;

    /**
     * se crean los depositos de todos los productos definidos, la cantidad de cada
     * producto se define al crear el expendedor
     */
    private Deposito<CocaCola> cocacola = new Deposito<>();
    private Deposito<Sprite> sprite = new Deposito<>();
    private Deposito<Fanta> fanta = new Deposito<>();
    private Deposito<Super8> super8 = new Deposito<>();
    private Deposito<Snickers> snickers = new Deposito<>();

    /**
     * el deposito monVu sirve exclusivamente para entregar el vuelto en monedas de 100,
     * o devolverle el dinero al comprador si ocurre una exception
     */
    private Deposito<Moneda> monVu = new Deposito<>();

    /**
     * todos estos static int sirven para facilitar la comprension conceptual, como
     * {@link #comprarProducto(Moneda, int)} solo puede recibir moneda y entero definimos
     * que cada numero representa un producto
     */
    public static final int  COCA=1;
    public static final int  SPRITE=2;
    public static final int  FANTA=3;
    public static final int  SUPER8=4;
    public static final int  SNICKERS=5;

    public Expendedor(int numProductos){
        this.numProductos = numProductos;

        /**
         * @param cont sirve para dar un N° de serie unico para cada producto en el for,
         * el cual crea productos segun la cantidad definida al inicializar el expendedor
         */
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
    public Producto comprarProducto(Moneda m, int cual) throws PagoIncorrectoException, PagoInsuficienteException, NoHayProductoException{
        /**
         * aqui una aclaracion importante y es porque se hace uso de dos switch, porque en principio
         * es innecesario, pero es porque en un switch se define el precio del producto y en el otro
         * se crea el producto, no se hacen ambas cosas juntas porque se tendria que extraer el producto
         * de su deposito para poder verificar si al comprador le alcanza, y en caso de que no le alcanze,
         * como el producto ya se saco del deposito desapareceria, lo cual no tiene sentido, se podria
         * vaciar un deposito sin haber comprado un solo producto
         */
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
                monVu.add(m);
                return null;
        }

        // repeticiones para el ciclo for
        int repeticiones;
        
        if(m == null){
            /**
             * @throws PagoIncorrectoException se lanza si se intenta pagar con una moneda null
             */
            throw new PagoIncorrectoException();
        }
        if(m.getValor() < precioProductos){
            /**
             * @throws PagoInsuficienteException se lanza si el dinero no alcanza para comprar el producto solicitado
             */
            monVu.add(m);
            repeticiones = m.getValor() / 100;
            throw new PagoInsuficienteException();
        }

        repeticiones = (m.getValor() - precioProductos) / 100;
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

        if(p == null){
            /**
             * @throws NoHayProductoException se lanza si no queda producto (el deposito p entrego null)
             */
            monVu.add(m);
            repeticiones = m.getValor() / 100;
            throw new NoHayProductoException();
        }
        /**
         * @param repeticiones son la cantidad de monedas de vuelto,
         * la cual no se retorna (porque lo único que se retorna es el producto p)
         */
        for(int i = 0; i < repeticiones; i++){
            Moneda monedaLocal = new Moneda100();
            monVu.add(monedaLocal);
        }
        return p;
    }

    /**
     * @return se retorna las monedas de 100 de una en una, el comprador debe tener
     * un metodo para obtener su vuelto completo
     */
    public Moneda getVuelto() {
        return monVu.get();
    }
}
