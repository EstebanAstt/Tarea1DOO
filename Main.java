public class Main {
	// Se definen las constantes para cada producto
	public static final int  COCA=1;
	public static final int  SPRITE=2;
	public static final int  FANTA=3;
	public static final int  SUPER8=4;
	public static final int  SNICKERS=5;

	public static void main() throws NoHayProductoException, PagoIncorrectoException, PagoInsuficienteException {
		// Se crean los expendedores para probar las excepciones
		Expendedor expendedorValido = new Expendedor(3);
		Expendedor expendedorNulo = new Expendedor(0);

		// Adicionalmente se crean las monedas
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

		// Desde aquí se crean los compradores, cada uno con la intención de comprar un producto distinto

		// Persona que compra una bebida, específicamente una sprite
		Moneda monedaSprite = new Moneda1000();
		Comprador personaCocaCola = new Comprador(monedaSprite, SPRITE, expendedorValido);
		System.out.println(personaCocaCola.queConsumiste() + " " + personaCocaCola.cuantoVuelto());

		// Persona que compra un dulce, específicamente un super 8
		Moneda monedaSuperOcho = new Moneda500();
		Comprador personaSuperOcho = new Comprador(monedaSuperOcho, SUPER8, expendedorValido);
		System.out.println(personaSuperOcho.queConsumiste() + " " + personaSuperOcho.cuantoVuelto());

		// Persona que compra un dulce, específicamente un snickers
		Moneda monedaSnickers = new Moneda1500();
		Comprador personaSnickers = new Comprador(monedaSnickers, SNICKERS, expendedorValido);
		System.out.println(personaSnickers.queConsumiste() + " " + personaSnickers.cuantoVuelto());

		// Desde aquí se prueba el método toString para algunas monedas
		// se pueden ver los distintos números de serie
		System.out.println("Moneda Nula: " + monedaNula);
		System.out.println("Moneda Inferior: " + monedaInferior);
		System.out.println("Moneda Valida: " + monedaValida);
		System.out.println("Moneda Sprite: " + monedaSprite);
	}
}