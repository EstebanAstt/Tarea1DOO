public class Comprador {
    private String sonido;
    private int vuelto;

    public Comprador(Moneda m, TipoProducto tipo, Expendedor exp) throws PagoIncorrectoException, PagoInsuficienteException, NoHayProductoException {
        this.vuelto = 0;
        
        Producto producto = exp.comprarProducto(m, tipo);
        
        // si se pudo comprar, se consume
        if (producto != null) {
            this.sonido = producto.consumir();
        } else {
            this.sonido = null;
        }

        // saca el vuelto moneda a moneda hasta que quede vacio
        Moneda monedaVuelto;
        while ((monedaVuelto = exp.getVuelto()) != null) {
            this.vuelto += monedaVuelto.getValor();
        }
    }

    public int cuantoVuelto() {
        return this.vuelto;
    }

    public String queConsumiste() {
        return this.sonido;
    }
}
