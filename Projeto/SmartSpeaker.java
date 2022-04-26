import java.util.Map;
import java.util.Objects;

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
    
    
    private static final int JBL = 1; // 480 Watt dia
    private static final int MARSHALL = 2; // 600 Watt dia
    private static final int BOSE = 3; // 540 Watt dia
    private int volume;
    private String channel;
    private int marca;

    /**
     * Constructor for objects of class SmartSpeaker
     */
    public SmartSpeaker() {
        super();
        this.marca = 0;
        this.channel = "";
        this.volume = 10;
    }

    public SmartSpeaker(String s) {
        super(s);
        this.marca = 0;
        this.channel = "";
        this.volume = 10;
    }



    public SmartSpeaker(String cod, int marca, String channel, int i) {
        super(cod);
        this.marca = marca;
        this.channel = channel;
        this.volume = i;
    }

    public void volumeUp() {
        if (this.volume<MAX) this.volume++;
    }

    public void volumeDown() {
        if (this.volume>0) this.volume--;
    }
    
    public int getMarca(){
        return this.marca;
    }

    public void setMarca(int marca){
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

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SmartSpeaker that = (SmartSpeaker) o;
        return (this.volume == that.volume && this.marca == that.marca && this.channel.equalsIgnoreCase(that.channel));
    }

    public String toString() {
        return "SmartSpeaker{" +
                "volume=" + volume +
                ", channel='" + channel + '\'' +
                ", marca=" + marca +
                '}';
    }

    public void CalculaConsumoEnergetico(){ //TODO SO PARA CLARIFICAR !!! neste caso como esta classe nao recebe o valor do consumo da lampada como variavel de instancia esse passa a ser o valor arbitrario e os valores passados a MARSHALL, BOSE e JBL sao agora os fatores multiplicativos do volume.(neste caso nao faz tant sentido mas foi pra facilitar)
        switch (this.marca){
            case MARSHALL -> {
                super.ConsumoDiarioEN = 600 + (MARSHALL * this.volume) ;
            }
            case BOSE -> {
                super.ConsumoDiarioEN = 540 + (BOSE * this.volume);
            }
            default -> {
                super.ConsumoDiarioEN = 480 + (JBL * this.volume);
            }
        }
    }
}
