**
 * A classe SmartDevice é um contactor simples.
 * Permite ligar ou desligar circuitos. 
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class SmartDevice {

    private String id;
    private boolean on;
    public double ConsumoDiarioEN;

    /**
     * Constructor for objects of class SmartDevice
     */
    public SmartDevice() {
        this.id = "";
        this.on = false;
        this.ConsumoDiarioEN = 0;
    }


    public SmartDevice(String s,double c) {
        this.ConsumoDiarioEN = c;
        this.id = s;
        this.on = false;
    }


    public SmartDevice(String s, boolean b,double c) {
        this.ConsumoDiarioEN = c;
        this.id = s;
        this.on = b;
    }

    public SmartDevice clone(){
        return new SmartDevice(this.id, this.on,this.ConsumoDiarioEN);

    }

    public void turnOn() {
        this.on = true;
    }
    
    public void turnOff() {
        this.on = false;
    }
    
    public boolean getOn() {
        return this.on;
    }


    public String toString() {
        return "SmartDevice{" +
                "id='" + id + '\'' +
                ", on=" + on +
                ", ConsumoDiarioEN=" + ConsumoDiarioEN +
                '}';
    }

    public void setOn(boolean b) {
        this.on = b;
    }
    
    public String getID() {
        return this.id;
    }

    public void setID(String id) {
        this.id = id;
    }

    public double getConsumoDiarioEN() {
        return this.ConsumoDiarioEN;
    }

    public void setConsumoDiarioEN(double consumoDiarioEN) {
        this.ConsumoDiarioEN = consumoDiarioEN;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SmartDevice that = (SmartDevice) o;
        return (this.on == that.on && this.id.equalsIgnoreCase(that.id) && this.ConsumoDiarioEN == that.ConsumoDiarioEN);
    }

}
