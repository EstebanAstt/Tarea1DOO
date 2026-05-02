public class Main {
	public static void main() throws Exception{
		Expendedor exp = new Expendedor(10);
		Moneda m = null;
		// agregar comprador

		try {
			exp.comprarProducto(m, 1);
		} catch (PagoIncorrectoException e) {
			System.out.println("No se ingreso ninguna moneda");
		} catch (PagoInsuficienteException e) {
			System.out.println("El valor de moneda es inferior al producto");
		} catch (NoHayProductoException e) {
			System.out.println("No hay producto en el deposito");
		}
	}
}