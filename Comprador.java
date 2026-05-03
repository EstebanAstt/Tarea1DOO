/** Clase la cual corresponde al pedido del comprador */
public class Comprador {
    private String sonido;
    private int vuelto;

    /**
     * Método constructor, recibe moneda, tipo de producto y un expendedor
     * Determina el vuelto al recibir las monedas del deposito
     * @param m
     * @param tipo
     * @param exp
     * @throws PagoIncorrectoException
     * @throws PagoInsuficienteException
     * @throws NoHayProductoException
     */
    public Comprador(Moneda m, int tipo, Expendedor exp) throws PagoIncorrectoException, PagoInsuficienteException, NoHayProductoException {
        this.vuelto = 0;
        Producto producto = exp.comprarProducto(m, tipo);

        if (producto instanceof Bebida bebida) {
            this.sonido = bebida.beber();
        } else if (producto instanceof Dulce dulce){
            this.sonido = dulce.comer();
        } else {
            this.sonido = null;
        }

        Moneda monedaVuelto;
        while ((monedaVuelto = exp.getVuelto()) != null) {
            this.vuelto += monedaVuelto.getValor();
        }
    }

    /**
     * Retorna el valor total de la suma de las monedas del deposito
     * @return valor del vuelto
     */
    public int cuantoVuelto() {
        return this.vuelto;
    }

    /**
     * Retorna el producto
     * @return string correspondiente al producto que se compró
     */
    public String queConsumiste() {
        return this.sonido;
    }
}