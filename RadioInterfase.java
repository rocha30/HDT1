
/**
 * La clase RadioInterfase implemnta la interfaz para todas las clases 
 */
public interface RadioInterfase {
    void onPowerButtonClicked();
    void onBandButtonClicked();
    void onTuneUpButtonClicked();
    void onTuneDownButtonClicked();
    void onSaveButtonClicked(int buttonNumber);
    void onSelectButtonClicked(int buttonNumber);
    String getSignal();
}

public class RadioController implements RadioControllerInterface {
    private Radio radio;

    public RadioController(Radio radio) {
        this.radio = radio;
    }

    @Override
    public void onPowerButtonClicked() {
        if (radio.isOn()) {
            radio.turnOff();
        } else {
            radio.turnOn();
        }
    }

    @Override
    public void onBandButtonClicked() {
        radio.changeBand();
    }

    @Override
    public void onTuneUpButtonClicked() {
        radio.tuneUp();
    }

    @Override
    public void onTuneDownButtonClicked() {
        radio.tuneDown();
    }

    @Override
    public void onSaveButtonClicked(int buttonNumber) {
        radio.savePreset(buttonNumber);
    }

    @Override
    public void onSelectButtonClicked(int buttonNumber) {
        radio.selectPreset(buttonNumber);
    }

    @Override
    public String getSignal() {
        return radio.getBand();
    }

    @Override
    public Double getFrequency(){
        return radio.getFrequency();
    }

    @Override
    public List<Double> getPresets() {
        return presets;
    }

    @Override
    public boolean isPresetsFull() {
        return presets.stream().allMatch(emisora -> emisora != null);
    }    
}
