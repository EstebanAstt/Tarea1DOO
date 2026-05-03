import java.util.Scanner;

/** Clase interactiva en donde el usuario puede comprar productos con monedas ingresadas */
public class MainInteractivo {

    /**
     * @throws NoHayProductoException
     * @throws PagoIncorrectoException
     * @throws PagoInsuficienteException
     */
    public static void main(String[] args) throws NoHayProductoException, PagoIncorrectoException, PagoInsuficienteException {
        Expendedor expendedorValido = new Expendedor(2);
        Scanner usuarioScan = new Scanner(System.in);

        System.out.println("########################");
        System.out.println("### MAIN INTERACTIVO ###");
        System.out.println("########################");

        int repeatValue = 1;
        while (repeatValue == 1){

            System.out.print("\n");
            System.out.println("############################");
            System.out.println("### 1) Elige un producto ###");
            System.out.println("############################");
            System.out.print("1. CocaCola, Precio: 1000\n" +
                            "2. Sprite, Precio: 1000\n" +
                            "3. Fanta, Precio: 1000\n" +
                            "4. Super 8, Precio: 500\n" +
                            "5. Snickers, Precio: 1100\n");
            int tipoProducto = usuarioScan.nextInt();

            System.out.print("\n");
            System.out.println("###########################");
            System.out.println("### 2) Elige una moneda ###");
            System.out.println("###########################");
            System.out.print("1. 100\n2. 500\n3. 1000\n4. 1500\n");
            int tipoMoneda = usuarioScan.nextInt();

            Moneda monedaInput = null;
            switch (tipoMoneda) {
                case 1: monedaInput = new Moneda100(); break;
                case 2: monedaInput = new Moneda500(); break;
                case 3: monedaInput = new Moneda1000(); break;
                case 4: monedaInput = new Moneda1500(); break;
                default: monedaInput = null; break;
            }

            try {
                Comprador compradorInput = new Comprador(monedaInput, tipoProducto, expendedorValido);
                System.out.println("Moneda Ingresada: " + monedaInput);
                System.out.println("Compraste " + compradorInput.queConsumiste() + " y tienes " + compradorInput.cuantoVuelto() + " pesos de vuelto");

            } catch (PagoIncorrectoException e) {
                System.out.println("Error: No se ingresó ninguna moneda"); break;
            } catch (PagoInsuficienteException e) {
                System.out.println("Error: El valor de la moneda ingresada es inferior al producto deseado"); break;
            } catch (NoHayProductoException e) {
                System.out.println("Error: No hay productos disponibles en el deposito"); break;
            }


            System.out.print("\n");
            System.out.println("#######################################");
            System.out.println("### ¿Quieres comprar otro producto? ###");
            System.out.println("#######################################");
            System.out.print("1: Sí\nOtro número: No\n");
            repeatValue = usuarioScan.nextInt();
        }
    }
}
