public class SmartCamera extends SmartDevice {

    private int resolucao;  //Resoluçoes em MegaPixeis
    private int tamanho;


    public SmartCamera(){
        super();
        this.resolucao = 16;
        this.tamanho = 10;
    }


    public SmartCamera(String id, int res, int tam){
        super(id);
        this.resolucao = res;
        this.tamanho = tam;
    }


    public int getResolucao(){
        return this.resolucao;
    }


    public int getTamanho() {
        return tamanho;
    }

    public void setResolucao(int resolucao) {
        this.resolucao = resolucao;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    
}
