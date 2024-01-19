package HDT1;
import java.util.Scanner;

/**
 * La clase RadioMenu es responsable de mostrar el menú interactivo para controlar
 * las funciones del radio y gestionar las interacciones del usuario.
 */
public class RadioMenu {
    /**
     * Método principal que inicia el menú interactivo para controlar el radio.
     * Crea instancias de la clase Radio y RadioController, luego muestra y gestiona el menú.
     *
     * @param args Argumentos de la línea de comandos (no se utilizan en este caso).
     */
    public static void main(String[] args) {
        // Crear instancia de Radio
        Radio radio = new Radio();
        // Crear instancia de RadioController
        RadioController radioController = new RadioController(radio);
        // Configurar el menú y mostrarlo
        showMenu(radioController);
    }

    /**
     * Muestra el menú interactivo y gestiona las interacciones del usuario.
     *
     * @param radioController Instancia de RadioController para manejar las acciones del usuario.
     */
    static void showMenu(RadioController radioController) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        int cont = 0;
        do {
            
            System.out.println("\n---------------------- Radio ----------------------");
            System.out.println("| Seleccione el numero de la opción:               |");
            System.out.println("|                                                  |");
            if(cont == 0){
                System.out.println("|               1. Encender el radio               |");
            }else if (cont == 1){
                System.out.println("| 2.Cambiar AM/FM                 Señal actual: " + radioController.getSignal() + " |");
                System.out.println("|                      EMISORAS                    |");
                System.out.println("|     4.Bajar <--------- "+ radioController.getFrequency()+ "---------->3.Subir    |");
                System.out.println("|5. Guardar emisora actual                         |");
                System.out.println("|6. Seleccionar emisora guardada                   |");
                System.out.println("|                                                  |");
                System.out.println("|1. Apagar el radio                                |");


            }
            System.out.println("|                                                  |");
            System.out.println("|                                                  |");
            System.out.println("----------------------------------------------------");
            System.out.println("0. Salir");
            System.out.print("Ingrese su elección: ");
            choice = scanner.nextInt();

            switch (choice) {
                
                case 1:
                
                    radioController.onPowerButtonClicked();
                    if (cont == 0){
                        cont = 1;
                    }else if (cont == 1){
                        cont = 0;
                    }
                    break;
                
                case 2:
                if(cont==0){
                    System.out.println("No puede acceder a la Radio hasta encenderla");
                }else{
                    radioController.onBandButtonClicked();
                }
                break;
                case 3:
                if(cont==0){
                    System.out.println("No puede acceder a la Radio hasta encenderla");
                }else{
                    radioController.onTuneUpButtonClicked();
                }
                break;
                case 4:
                if(cont==0){
                    System.out.println("No puede acceder a la Radio hasta encenderla");
                }else{
                    radioController.onTuneDownButtonClicked();
                }
                break;
                case 5:
                if(cont==0){
                    System.out.println("No puede acceder a la Radio hasta encenderla");
                }else{
                    System.out.print("Ingrese el número del botón (1-12): ");
                    int saveButton = scanner.nextInt();
                    radioController.onSaveButtonClicked(saveButton);
                }
                break;
                case 6:
                if(cont==0){
                    System.out.println("No puede acceder a la Radio hasta encenderla");
                }else{
                    System.out.print("Ingrese el número del botón (1-12): ");
                    int selectButton = scanner.nextInt();
                    radioController.onSelectButtonClicked(selectButton);
                }
                break;
                case 0:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                    break;
            }

        } while (choice != 0);

        scanner.close();
    }
}
