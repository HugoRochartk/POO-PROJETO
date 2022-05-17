import java.util.*;

/**
 * A CasaInteligente faz a gestão dos SmartDevices que existem e dos 
 * espaços (as salas) que existem na casa.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CasaInteligente extends Loteamento{

    private String nome;
    private int nif;

    private Map<String, SmartDevice> devices; // identificador -> SmartDevice
    private Map<String, List<String>> locations; // Espaço -> Lista codigo dos devices
    private Fornecedor forn;
    private String deviceID = "1";

    private static final int EDP = 1; //possivel método de criação  (valor base
    private static final int COFIDIS = 2; //possivel método de criação
    private static final int OutroNome = 3; //possivel método de criação

    /**
     * Constructor for objects of class CasaInteligente
     */
    public CasaInteligente() {
        this.nome = "";
        this.nif = 0;
      //  this.morada = "";
        this.devices = new HashMap();
        this.locations = new HashMap();
    }

    public CasaInteligente(String nome) {
        this.nome = nome;
        this.nif = 0;
       // this.morada = morada;
        this.devices = new HashMap();
        this.locations = new HashMap();
    }


    public CasaInteligente(int nif, String nome, Fornecedor forn) {
        this.nome = nome;
        this.nif = nif;
     //   this.morada = morada;
        this.devices = new HashMap();
        this.locations = new HashMap();
        this.forn = forn;
    }

    public CasaInteligente(CasaInteligente casa){
        this.nif = casa.getNif();
        this.nome = casa.getNome();
        this.forn = casa.getForn();

        for(SmartDevice dev : casa.devices.values()){
            this.devices.put(dev.getID(),dev.clone());
        }

        for(Map.Entry<String, List<String>> pair: casa.locations.entrySet()){
            List<String> lista = new ArrayList<>();
            for(String id: pair.getValue()){
                lista.add(id);
            }
            this.locations.put(pair.getKey(), lista);
        }
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

    public void setForn(Fornecedor forn) {
        this.forn = forn;
    }

    public Fornecedor getForn() {
        return this.forn;
    }

    public void addDevice(SmartDevice s) {

        s.setID(this.deviceID);
        s.setOn(false);
        this.devices.put(s.getID(), s.clone());
        int num = Integer.parseInt(this.deviceID);
        num +=1;
        this.deviceID = Integer.toString(num);
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
        return new CasaInteligente(this);
    }
    
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        CasaInteligente that = (CasaInteligente) o;
        return (this.nif == that.nif && this.nome.equalsIgnoreCase(that.nome) && this.devices.equals(that.devices) && this.locations.equals(that.locations));
    }

    public int CustoDiarioDispositivos(){
        int sum = 0;

        for(SmartDevice dev: this.devices.values()){
            sum += this.forn.getValorBase() * dev.getConsumoDiarioEN() * (1+ 0.35) * 0.9;
        }

        return sum;
    }

    @Override
    public String toString() {
        return "CasaInteligente{" +
                "nome='" + nome + '\'' +
                ", nif=" + nif +
                ", devices=" + devices +
                ", locations=" + locations +
                ", forn=" + forn +
                ", deviceID='" + deviceID + '\'' +
                '}';
    }
}
