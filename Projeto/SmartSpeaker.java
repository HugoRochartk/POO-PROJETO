/**
 * Um SmartSpeaker é um SmartDevice que além de ligar e desligar permite também
 * reproduzir som.
 * Consegue ligar-se a um canal (por simplificação uma rádio online) e permite
 * a regulação do seu nível de volume.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class SmartSpeaker extends SmartDevice {
    public static final int MAX = 20; //volume máximo
    
    
    private String marca;
    private int volume;
    private String channel;


    /**
     * Constructor for objects of class SmartSpeaker
     */
    public SmartSpeaker() {
        super();
        this.channel = "";
        this.volume = 10;
    }

    public SmartSpeaker(String s) {
        super(s);
        this.channel = "";
        this.volume = 10;
    }



    public SmartSpeaker(String cod, String channel, int i) {
        super(cod);
        this.channel = channel;
        this.volume = i;
    }

    public void volumeUp() {
        if (this.volume<MAX) this.volume++;
    }

    public void volumeDown() {
        if (this.volume>0) this.volume--;
    }
    
    public String getMarca(){
        return this.marca;
    }

    public void setMarca(String marca){
        this.marca = marca;
    }
    

    public int getVolume() {
        return this.volume;
    }
    
    public String getChannel() {
        return this.channel;
    }
    
    public void setChannel(String c) {
        this.channel = c;
    }

}
