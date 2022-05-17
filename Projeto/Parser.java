import java.nio.file.Files;
import java.util.List;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.util.ArrayList;


public class Parser {

    public void parse(){
        List<String> linhas = lerFicheiro("log.txt");
        String[] linhaPartida;
        Loteamento lot = new Loteamento();
        String divisao = null;
        CasaInteligente casaMaisRecente = null;
        for (String linha : linhas) {
            linhaPartida = linha.split(":", 2);
            switch(linhaPartida[0]){
                case "Casa":
                    casaMaisRecente = parseCasa(linhaPartida[1]);
                    lot.addCasaInteligente(casaMaisRecente.clone());
                    break;
                case "Divisao":
                    if (casaMaisRecente == null) System.out.println("Linha inválida.");
                    divisao = linhaPartida[1];
                    assert casaMaisRecente != null;
                    casaMaisRecente.addRoom(divisao);
                    break;
                case "SmartBulb":
                    if (divisao == null) System.out.println("Linha inválida.");
                    SmartBulb sd = parseSmartBulb(linhaPartida[1]);
                    assert casaMaisRecente != null;
                    casaMaisRecente.addDevice(sd);
                    casaMaisRecente.addToRoom(divisao, sd.getID());
                    break;
                case "SmartSpeaker":
                    if (divisao == null) System.out.println("Linha inválida.");
                    SmartSpeaker ss = parseSmartSpeaker(linhaPartida[1]);
                    assert casaMaisRecente != null;
                    casaMaisRecente.addDevice(ss);
                    casaMaisRecente.addToRoom(divisao, ss.getID());
                    break;
                case "SmartCamera":
                    if (divisao == null) System.out.println("Linha inválida.");
                    SmartCamera sc = parseSmartCamera(linhaPartida[1]);
                    assert casaMaisRecente != null;
                    casaMaisRecente.addDevice(sc);
                    casaMaisRecente.addToRoom(divisao, sc.getID());
                    break;
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
        Fornecedor forn = new Fornecedor();
        forn.setString(campos[2]);
        return new CasaInteligente(nif, nome, forn);
    }

    public SmartBulb parseSmartBulb(String input){
        String[] campos = input.split(",");
        int tonalidade = Integer.parseInt(campos[0]);
        double size = Double.parseDouble(campos[1]);
        double consumo = Double.parseDouble(campos[2]);
        return new SmartBulb(tonalidade, consumo, size);
    }

    public SmartSpeaker parseSmartSpeaker(String input){
        String[] campos = input.split(",");
        int volume = Integer.parseInt(campos[0]);
        String channel = campos[1];
        String marca = campos[2];
        double consumo = Double.parseDouble(campos[3]);
        return new SmartSpeaker(volume, channel, marca, consumo);

    }


    public SmartCamera parseSmartCamera(String input){
        String[] campos = input.split(",");
        String resolucao = campos[0];
        int tamanho = Integer.parseInt(campos[1]);
        double consumo = Double.parseDouble(campos[2]);
        return new SmartCamera(resolucao, tamanho, consumo);
    }



}
