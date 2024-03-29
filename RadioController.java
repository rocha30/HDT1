package HDT1;

/**
 * La clase RadioController actúa como un controlador que maneja eventos y comunica
 * entre la lógica del radio y la interfaz de usuario. Se encarga de controlar las
 * operaciones relacionadas con el radio, como encender/apagar, cambiar de banda,
 * sintonizar, guardar y seleccionar emisoras preestablecidas.
 */

import java.util.List;

public class RadioController {
    private Radio radio;  // Instancia de la clase Radio que se está controlando

    /**
     * Constructor de la clase RadioController.
     *
     * @param radio Instancia de la clase Radio que se asociará con este controlador.
     */
    public RadioController(Radio radio) {
        this.radio = radio;
        
    }

    /**
     * Maneja el evento de clic en el botón de encendido/apagado y realiza la
     * acción correspondiente en la lógica del radio.
     */
    public void onPowerButtonClicked() {
        if (radio.isOn()) {
            radio.turnOff();
        } else {
            radio.turnOn();
        }
    }

     /**
     * Maneja el evento de clic en el botón de cambio de banda y realiza la
     * acción correspondiente en la lógica del radio.
     */
    public void onBandButtonClicked() {
        radio.changeBand();
    }

    /**
     * Maneja el evento de clic en el botón de sintonización hacia arriba y realiza
     * la acción correspondiente en la lógica del radio.
     */
    public void onTuneUpButtonClicked() {
        radio.tuneUp();
    }

    /**
     * Maneja el evento de clic en el botón de sintonización hacia abajo y realiza
     * la acción correspondiente en la lógica del radio.
     */
    public void onTuneDownButtonClicked() {
        radio.tuneDown();
    }

    /**
     * Maneja el evento de clic en el botón de guardar emisora y realiza la
     * acción correspondiente en la lógica del radio.
     *
     * @param buttonNumber Número del botón preestablecido (1-12).
     */
    public void onSaveButtonClicked(int buttonNumber) {
        radio.savePreset(buttonNumber);
    }

    /**
     * Maneja el evento de clic en el botón de seleccionar emisora preestablecida y
     * realiza la acción correspondiente en la lógica del radio.
     *
     * @param buttonNumber Número del botón preestablecido (1-12).
     */
    public void onSelectButtonClicked(int buttonNumber) {
        radio.selectPreset(buttonNumber);
    }

    /**
     * regresa los estados de las variables
     *
     * son los getters de las variables
     */
    public String getSignal() {
        return radio.getBand();
    }

    public Double getFrequency(){
        return radio.getFrequency();
    }

    public List<Double> getPresets() {
        return presets;
    }

    public boolean isPresetsFull() {
        return presets.stream().allMatch(emisora -> emisora != null);
    }    
}

