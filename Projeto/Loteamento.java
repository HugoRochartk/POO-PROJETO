import java.util.Map;
import java.util.Objects;

public class Loteamento {
    private Map<String, CasaInteligente> loteamento;

    public Loteamento(Map<String, CasaInteligente> loteamento) {
        this.loteamento = loteamento;
    }

    public Map<String, CasaInteligente> getLoteamento() {
        return loteamento;
    }

    public void setLoteamento(Map<String, CasaInteligente> loteamento) {
        this.loteamento = loteamento;
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

