/**
 * A SmartCamera é uma camera que permite
 * variar de resolução e ser desligada ou
 * ligada (subclasse de SmartDevice).
 *
 * @author Hugo Rocha, Gabriel Silva, José Faria
 *
 */
public class SmartCamera extends SmartDevice implements Devices{

    private String resolucao;  

    private int tamanho;
    private double consumoEnergetico;


    public SmartCamera(){
        super();
        this.resolucao = "(1280x720)";
        this.tamanho = 10;
        this.consumoEnergetico = 7.0;
    }
    
    
    public SmartCamera(String id, boolean b, double consumo){
        super(id,b);
        this.resolucao = "(1280x720)";
        this.tamanho = 10;
        this.consumoEnergetico = consumo;
    }

    public SmartCamera(String id, boolean b, String res, int tam, double consumoEnergetico){
        super(id,b);
        this.resolucao = res;
        this.tamanho = tam;
        this.consumoEnergetico = consumoEnergetico;
    }

    public SmartCamera(String res, int tam, double consumoEnergetico){
        super();
        this.resolucao = res;
        this.tamanho = tam;
        this.consumoEnergetico = consumoEnergetico;

    }


    public String getResolucao(){
        return this.resolucao;
    }


    public int getTamanho() {
        return tamanho;
    }

    public void setResolucao(String resolucao) {
        this.resolucao = resolucao;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public SmartCamera clone(){
        return new SmartCamera(this.resolucao, this.tamanho, this.consumoEnergetico);
    }


    public String toString() {
        return "SmartCamera{" +
                "resolucao='" + resolucao + '\'' +
                ", tamanho=" + tamanho +
                ", consumoEnergetico=" + consumoEnergetico +
                '}';
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        SmartCamera that = (SmartCamera) o;
        return (this.resolucao.equalsIgnoreCase(that.resolucao) && this.tamanho == that.tamanho && this.consumoEnergetico == that.consumoEnergetico);
    }

    public double getConsumoEnergetico() {
        return this.consumoEnergetico;
    }

    public void setConsumoEnergetico(double consumoEnergetico) {
        this.consumoEnergetico = consumoEnergetico;
    }

    public double CalculaConsumoEnergetico(){

        double res = .0;
          switch(resolucao.length()){
              case 9 -> {
                  res = this.consumoEnergetico/10;
              }
              case 10 -> {
                  res = (this.consumoEnergetico * (15))/100;
              }

              case 11 -> {
                  res = (this.consumoEnergetico * (20))/100;
              }

              case 12 ->{
                  res = (this.consumoEnergetico * (30))/100;
              }

          }


        return res;
    }

    
}

