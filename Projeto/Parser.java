import java.util.List;

public class Parser {

    public void parse(){
        List<String> linhas = lerFicheiro("dados.csv");
        String[] linhaPartida;
        String divisao = null;
        CasaInteligente casaMaisRecente = null;
        for (String linha : linhas) {
            linhaPartida = linha.split(":", 2);
            switch(linhaPartida[0]){
                case "Casa":
                    casaMaisRecente = parseCasa(linhaPartida[1]);
                    (...)
                    break;
                case "Divisao":
                    if (casaMaisRecente == null) System.out.println("Linha inválida.");
                    divisao = linhaPartida[1];
                    casaMaisRecente.addRoom(divisao);
                    (...)
                    break;
                case "SmartBulb":
                    if (divisao == null) System.out.println("Linha inválida.");
                    SmartBulb sd = parseSmartBulb(linhaPartida[1]);
                    casaMaisRecente.addDevice(sd);
                    casaMaisRecente.addToRoom(divisao, sd.getId());
                    (...)
                    break;
                (...)
                default:
                    System.out.println("Linha inválida.");
                    break;
            }
        }
        System.out.println("done!");
    }

    public List<String> lerFicheiro(String nomeFich) {
        List<String> lines;
        try { lines = Files.readAllLines(Paths.get(nomeFich), StandardCharsets.UTF_8); }
        catch(IOException exc) { lines = new ArrayList<>(); }
        return lines;
    }

    public CasaInteligente parseCasa(String input){
        String[] campos = input.split(",");
        String nome = campos[0];
        int nif = Integer.parseInt(campos[1]);
        (...)
        return new CasaInteligente(...);
    }


    //definir parser para cada classe(dispositivo)
}
