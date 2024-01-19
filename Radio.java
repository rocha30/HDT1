package HDT1;

/**
 * La clase Radio representa un objeto de radio con funcionalidades básicas.
 * Puede encenderse/apagarse, cambiar de banda (AM/FM), sintonizar hacia arriba
 * o hacia abajo, guardar y seleccionar emisoras preestablecidas.
 */
import java.util.ArrayList;
import java.util.List;

public class Radio {
    private boolean isOn;           // Estado de encendido/apagado del radio
    private double frequency;       // Frecuencia actual del radio
    private String band;            // Banda actual del radio (AM/FM)
    private List<Double> presets;   // Emisoras preestablecidas

    /**
     * Constructor por defecto de la clase Radio.
     * Inicializa el radio con valores predeterminados.
     */
    public Radio() {
        isOn = false;
        frequency = 87.9;
        band = "FM";
        presets = new ArrayList<>(12);
        for (int i = 0; i < 12; i++) {
            presets.add(null);
        }
    }

    /**
     * Enciende el radio.
     */
    public void turnOn() {
        isOn = true;
        System.out.println("Radio encendido");
    }

     /**
     * Apaga el radio.
     */
    public void turnOff() {
        isOn = false;
        System.out.println("Radio apagado");
    }

    /**
     * Cambia la banda del radio entre AM y FM.
     */
    public void changeBand() {
        band = (band.equals("AM")) ? "FM" : "AM";
        System.out.println(band);
    }

    /**
     * Sintoniza el radio hacia arriba, ajustando la frecuencia según la banda.
     */
    public void tuneUp() {
        frequency += (band.equals("AM")) ? 10 : 0.3;
        System.out.println("Sintonizando hacia arriba. Frecuencia actual: " + frequency);
    }

    /**
     * Sintoniza el radio hacia abajo, ajustando la frecuencia según la banda.
     */
    public void tuneDown() {
        frequency -= (band.equals("AM")) ? 10 : 0.3;
        System.out.println("Sintonizando hacia abajo. Frecuencia actual: " + frequency);
    }

    /**
     * Guarda la frecuencia actual en el botón preestablecido especificado.
     *
     * @param buttonNumber Número del botón preestablecido (1-12).
     */
    public void savePreset(int buttonNumber) {
        if (buttonNumber < 1 || buttonNumber > 12) {
            System.out.println("Número de botón no válido. Debe estar entre 1 y 12.");
            return;
        }

        if (presets.get(buttonNumber - 1) == null) {
            presets.set(buttonNumber - 1, frequency);
            System.out.println("Emisora guardada en el botón " + buttonNumber);
        } else {
            System.out.println("El botón " + buttonNumber + " ya tiene una emisora guardada. Elija otro botón.");
        }
    }

    /**
     * Selecciona la emisora almacenada en el botón preestablecido especificado.
     *
     * @param buttonNumber Número del botón preestablecido (1-12).
     */
    public void selectPreset(int buttonNumber) {
        if (buttonNumber < 1 || buttonNumber > 12) {
            System.out.println("Número de botón no válido. Debe estar entre 1 y 12.");
            return;
        }

        Double selectedFrequency = presets.get(buttonNumber - 1);
        if (selectedFrequency != null) {
            System.out.println("Emisoras guardadas en el botón " + buttonNumber + ":");
            for (int i = 0; i < presets.size(); i++) {
                if (presets.get(i) != null) {
                    System.out.println("Slot " + (i + 1) + ": " + presets.get(i));
                }
            }
        } else {
            System.out.println("No hay emisoras guardadas en el botón " + buttonNumber);
        }
    }

    /**
     * regresa los estados de las variables
     *
     * son los getters de las variables
     */
    public boolean isOn() {
        return isOn;
    }

    public String getBand() {
        return band;
    }

    public Double getFrequency(){
        return frequency;
    }

    public List<Double> getPresets() {
        return presets;
    }

    public boolean isPresetsFull() {
        return presets.stream().allMatch(emisora -> emisora != null);
    }    
}
