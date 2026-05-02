public class Main {
	public static void main() throws NoHayProductoException, PagoIncorrectoException, PagoInsuficienteException {
		// Se crea un expendedor
		Expendedor expendedor = new Expendedor(5);

		// Primero se prueban las excepciones relacionadas al pago
		Moneda monedaUno = null;
		Moneda monedaDos = new Moneda100();

		try {
			expendedor.comprarProducto(monedaUno, 1);
		} catch (PagoIncorrectoException e) {
			System.out.println("Error: No se ingresó ninguna moneda");
		}

		try {
			expendedor.comprarProducto(monedaDos, 1);
		} catch (PagoInsuficienteException e) {
			System.out.println("Error: El valor de la moneda ingresada es inferior al producto deseado");
		}

		// Se prueba la última excepción con un expendedor sin ningún producto
		Expendedor expendedorNulo = new Expendedor(0);
		Moneda monedaValida = new Moneda1500();

		try {
			expendedorNulo.comprarProducto(monedaValida, 1);
		} catch (NoHayProductoException e) {
			System.out.println("Error: No hay productos disponibles en el deposito");
		}
	}
}