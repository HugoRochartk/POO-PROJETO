/**
 * Uma SmartBulb é uma lâmpada inteligente que além de ligar e desligar (já que
 * é subclasse de SmartDevice) também permite escolher a intensidade da iluminação 
 * (a cor da mesma).
 *
 * @author (your name)
 * @version (a version number or a date)
 */
 
public class SmartBulb extends SmartDevice {
    public static final int WARM = 2;
    public static final int NEUTRAL = 1;
    public static final int COLD = 3;

    private double size;
    private double consumoEnergetico;
    private int tone;


    /**
     * Constructor for objects of class SmartBulb
     */
    public SmartBulb() {
        super();
        this.tone = NEUTRAL;
        this.consumoEnergetico = 0.0;
        this.size = 0.0;
    }

    public SmartBulb(String id, int tone,double consumoEnergetico,double size) {
        super(id);
        this.tone = tone;
        this.consumoEnergetico = 0.0;
        this.size = 0.0;
    }

    public SmartBulb(String id) {
        super(id);
        this.tone = NEUTRAL;
    }

    public void setTone(int t) {
        if (t>WARM)
            this.tone = WARM;
        else if (t<COLD) 
            this.tone = COLD;
        else 
            this.tone = t;
    }

    public int getTone() {
        return this.tone;
    }
 
 
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SmartBulb that = (SmartBulb) o;
        return (this.tone == that.tone);

    }

    public void CalculaConsumoEnergetico(){ //TODO SO PARA CLARIFICAR!!! neste caso os valores atribuidos a WARM, COLD e NEUTRAL sao multiplicados por um valor arbitrario pode ser mudado
        switch (this.tone){
            case WARM -> {
                super.ConsumoDiarioEN = this.size * this.consumoEnergetico + (WARM * 7.5);
            }
            case COLD -> {
                super.ConsumoDiarioEN = this.size * this.consumoEnergetico + (COLD * 7.5);
            }
            default -> {
                super.ConsumoDiarioEN = this.size * this.consumoEnergetico + (NEUTRAL * 7.5);
            }
        }
    }
}
