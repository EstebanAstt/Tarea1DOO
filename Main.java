public class Main {
	public static void main() throws NoHayProductoException, PagoIncorrectoException, PagoInsuficienteException {
		Moneda m = new Moneda1500();
		System.out.println(m);

		Moneda mDos = new Moneda100();
		System.out.println(mDos);

		Moneda mTres = new Moneda500();
		System.out.println(mTres);
	}
}