import java.util.*;

public class Loteamento {
    private Map<Integer, ArrayList<CasaInteligente>> loteamento;  //  (nif, listadascasasquepossui)
   
    
    public Loteamento(){
        this.loteamento = new HashMap<>();
    }
    
    public Loteamento(Map<Integer, ArrayList<CasaInteligente>> loteamento) {
        this.loteamento = loteamento;
    }

    public Map<Integer, ArrayList<CasaInteligente>> getLoteamento() {
        return this.loteamento;
    }

    public void setLoteamento(Map<Integer, ArrayList<CasaInteligente>> loteamento) {
        this.loteamento = loteamento;
    }

    public void addCasaInteligente(CasaInteligente c){
         if(this.loteamento.containsKey(c.getNif())){
            this.loteamento.get(c.getNif()).add(c.clone());
         }
         else{
             ArrayList<CasaInteligente> lista = new ArrayList<>();
             this.loteamento.put(c.getNif(), lista.add(c.clone());
         }

    }


    public ArrayList<CasaInteligente> getCasasInteligentes(int nif){  //dada uma pessoa retorna as casas que lhe pertencem
        return this.loteamento.get(nif);
    }


    public int getNif(CasaInteligente c){

        for(Map.Entry<Integer, ArrayList<CasaInteligente>> pair: this.loteamento.entrySet()){
            if(pair.getValue().contains(c)) return pair.getKey();
        }
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Loteamento that = (Loteamento) o;
        return Objects.equals(loteamento, that.loteamento);
    }

    @Override
    public String toString() {
        return "Loteamento{" +
                "loteamento=" + loteamento +
                '}';
    }
}

