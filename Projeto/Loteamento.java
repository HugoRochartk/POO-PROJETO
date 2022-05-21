import java.util.*;

/**
 * A classe Loteamento é responsável
 * por associar, a cada propriétario,
 * a lista das casas que este possuí.
 *
 * @author José Faria, Hugo Rocha, Gabriel Silva
 *
 */

public class Loteamento {
    private Map<Integer, ArrayList<CasaInteligente>> loteamento;  //  NIF -> Lista das cassas que possui

    
    public Loteamento(){
        this.loteamento = new HashMap<>();
    }
    
    public Loteamento(Map<Integer, ArrayList<CasaInteligente>> lot) {

        for(Map.Entry<Integer, ArrayList<CasaInteligente>> pair: lot.entrySet()){
            ArrayList<CasaInteligente> lista = new ArrayList<>();
            for(CasaInteligente casa: pair.getValue()){
                lista.add(casa.clone());
            }
            this.loteamento.put(pair.getKey(), lista);
        }

    }

    public Map<Integer, ArrayList<CasaInteligente>> getLoteamento() {
        Map<Integer, ArrayList<CasaInteligente>> mapa = new HashMap<>();

        for(Map.Entry<Integer, ArrayList<CasaInteligente>> pair: this.loteamento.entrySet())
            mapa.put(pair.getKey(), pair.getValue());

        return mapa;
    }

    public void setLoteamento(Map<Integer, ArrayList<CasaInteligente>> lot) {

        for(Map.Entry<Integer, ArrayList<CasaInteligente>> pair: lot.entrySet()){
            ArrayList<CasaInteligente> lista = new ArrayList<>();
            for(CasaInteligente casa: pair.getValue()){
                lista.add(casa.clone());
            }
            this.loteamento.put(pair.getKey(), lista);
        }
    }

    public void addCasaInteligente(CasaInteligente c){


         if(this.loteamento.containsKey(c.getNif())){
            this.loteamento.get(c.getNif()).add(c.clone());
         }
         else{
             ArrayList<CasaInteligente> lista = new ArrayList<>();
             lista.add(c.clone());
             this.loteamento.put(c.getNif(), lista);
         }

    }


    public ArrayList<CasaInteligente> getCasasInteligentes(int nif){  //dada uma pessoa retorna as casas que lhe pertencem

        if(this.loteamento.containsKey(nif)) {
            return this.loteamento.get(nif);
        }
        else{
            System.out.println("Nif nao existente!");
            return null;
        }

    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Loteamento that = (Loteamento) o;
        return Objects.equals(loteamento, that.loteamento);
    }


    public String toString() {
        return "Loteamento{" +
                "loteamento=" + loteamento +
                '}';
    }
}
