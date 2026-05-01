import java.util.Scanner;

public class MainInteractivo {
    public static void main(){

        // ésto se puede eliminar después
        Scanner scan = new Scanner(System.in);
        System.out.println("Prueba Scanner Int:");
        int entero = scan.nextInt();
        System.out.println("Entero ingresado: " + entero);
    }
}
