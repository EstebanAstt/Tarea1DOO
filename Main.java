/** Clase main en la cual se prueban los casos posibles y también las excepciones */
public class Main {
	public static final int  COCA=1;
	public static final int  SPRITE=2;
	public static final int  FANTA=3;
	public static final int  SUPER8=4;
	public static final int  SNICKERS=5;

	/**
	 * @throws NoHayProductoException
	 * @throws PagoIncorrectoException
	 * @throws PagoInsuficienteException
	 */
	public static void main(String[] args) throws NoHayProductoException, PagoIncorrectoException, PagoInsuficienteException {
		Expendedor expendedorValido = new Expendedor(3);
		Expendedor expendedorNulo = new Expendedor(0);

		Moneda monedaNula = null;
		Moneda monedaInferior = new Moneda100();
		Moneda monedaValida = new Moneda1500();

		try {
			expendedorValido.comprarProducto(monedaNula, COCA);
		} catch (PagoIncorrectoException e) {
			System.out.println("Error: No se ingresó ninguna moneda");
		}

		try {
			expendedorValido.comprarProducto(monedaInferior, COCA);
		} catch (PagoInsuficienteException e) {
			System.out.println("Error: El valor de la moneda ingresada es inferior al producto deseado");
		}

		try {
			expendedorNulo.comprarProducto(monedaValida, COCA);
		} catch (NoHayProductoException e) {
			System.out.println("Error: No hay productos disponibles en el deposito");
		}

		Moneda monedaSprite = new Moneda1000();
		Comprador personaCocaCola = new Comprador(monedaSprite, SPRITE, expendedorValido);
		System.out.println(personaCocaCola.queConsumiste() + " " + personaCocaCola.cuantoVuelto());

		Moneda monedaSuperOcho = new Moneda500();
		Comprador personaSuperOcho = new Comprador(monedaSuperOcho, SUPER8, expendedorValido);
		System.out.println(personaSuperOcho.queConsumiste() + " " + personaSuperOcho.cuantoVuelto());

		Moneda monedaSnickers = new Moneda1500();
		Comprador personaSnickers = new Comprador(monedaSnickers, SNICKERS, expendedorValido);
		System.out.println(personaSnickers.queConsumiste() + " " + personaSnickers.cuantoVuelto());

		System.out.println("Moneda Nula: " + monedaNula);
		System.out.println("Moneda Inferior: " + monedaInferior);
		System.out.println("Moneda Valida: " + monedaValida);
		System.out.println("Moneda Sprite: " + monedaSprite);
	}
}