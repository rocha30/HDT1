package HDT1;

/**
 * La clase Main es la clase principal que contiene el método main para ejecutar
 * la aplicación de control de radio. Crea una instancia de la clase RadioController
 * y muestra el menú de radio utilizando la clase RadioMenu.
 */
public class Main {

        /**
     * Método principal que inicia la aplicación de control de radio.
     *
     * @param args Argumentos de la línea de comandos (no se utilizan en este caso).
     */
    public static void main(String[] args) {
                // Crear instancia de RadioController
                RadioController radioController = new RadioController(new Radio());

                // Mostrar el menú de radio
                RadioMenu.showMenu(radioController);
            
        }
}