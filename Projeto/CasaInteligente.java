import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;


/**
 * A CasaInteligente faz a gestão dos SmartDevices que existem e dos 
 * espaços (as salas) que existem na casa.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CasaInteligente {

    private String nome;
    private int nif;
    private String morada;
    private Map<String, SmartDevice> devices; // identificador -> SmartDevice
    private Map<String, List<String>> locations; // Espaço -> Lista codigo dos devices

    /**
     * Constructor for objects of class CasaInteligente
     */
    public CasaInteligente() {
        this.nome = "";
        this.nif = 0;
        this.morada = "";
        this.devices = new HashMap();
        this.locations = new HashMap();
    }

    public CasaInteligente(String morada) {
        this.nome = "";
        this.nif = 0;
        this.morada = morada;
        this.devices = new HashMap();
        this.locations = new HashMap();
    }


    public CasaInteligente(int nif, String nome, String morada) {
        this.nome = nome;
        this.nif = nif;
        this.morada = morada;
        this.devices = new HashMap();
        this.locations = new HashMap();
    }

    
    public void setDeviceOn(String devCode) {
        this.devices.get(devCode).turnOn();
    }
    
    public boolean existsDevice(String id) {
        return this.devices.containsKey(id);
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setNif(int i){
        this.nif = i;
    }

    public int getNif(){
        return this.nif;
    }

    public String getNome(){
        return this.nome;
    }


    public void addDevice(SmartDevice s) {
        this.devices.put(s.getID(), s.clone());
    }
    
    public SmartDevice getDevice(String s) {

        return this.devices.get(s);
    }
    
    public void setOn(String s, boolean b) {
        this.devices.get(s).setOn(b);
    }
    
    public void setAllOn(boolean b) {
        for(SmartDevice d: this.devices.values()){
               d.setOn(b);
        }
    }
    
    public void addRoom(String s) {
          List<String> a = new ArrayList<>();

          this.locations.put(s, a);
    }
    
    public boolean hasRoom(String s) {
        return this.locations.containsKey(s);
    }
    
    public void addToRoom (String s1, String s2) {
        this.locations.get(s1).add(s2);
    }
    
    public boolean roomHasDevice (String s1, String s2) {
        return this.locations.get(s1).contains(s2);
    }
    
    public CasaInteligente clone(){
        return new CasaInteligente(this.nome, this.nif, this.morada);
    }
    
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CasaInteligente that = (CasaInteligente) o;
        return (this.nif == that.nif && this.morada.equalsIgnoreCase(that.morada) && this.nome.equalsIgnoreCase(that.nome) && this.devices.equals(that.devices) && this.locations.equals(that.locations));
    }

}
