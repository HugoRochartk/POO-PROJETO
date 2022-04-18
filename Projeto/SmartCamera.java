public class SmartCamera extends SmartDevice {

    private String resolucao;  //exemplo: "1280:720" HD, "2048:1080" 2K
    private int tamanho;


    public SmartCamera(){
        super();
        this.resolucao = "1280:720";
        this.tamanho = 10;
    }


    public SmartCamera(String id, String res, int tam){
        super(id);
        this.resolucao = res;
        this.tamanho = tam;
    }


    public String getResolucao(){
        return this.resolucao;
    }


    public int getTamanho() {
        return tamanho;
    }

    public void setResolucao(String resolucao) {
        this.resolucao = String;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    
}
