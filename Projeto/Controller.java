import java.util.*;

public class Controller {

    public void run(){
           Scanner sc = new Scanner(System.in);

           System.out.println("\n\nBem-vindo!\n\n");
           System.out.println("Escolha uma das seguintes opcoes:\n");


           System.out.println("0: Carregar dados.\n");

           int op = sc.nextInt();

           if(op==0){
             Parser p = new Parser();
             Loteamento lot = p.parse();
             System.out.println("Dados carregados com sucesso!\n");

             int dias;
             int opcao;

             while(true){
                 System.out.println("Pretende avancar no tempo?\n");
                 System.out.println("0: Sim\n");
                 System.out.println("1: Nao\n");
                 opcao = sc.nextInt();
                 if(opcao ==1){
                     break;
                 }
                 System.out.println("Quanto tempo, em dias, pretende avançar no tempo?\n");
                 dias = sc.nextInt();
                 System.out.println("Indique a operação que pretende realizar:\n");
                 System.out.println("0:Calcular faturas de todas as casas.\n");
                 System.out.println("1:Alterar valores base fornecedores.\n");
                 System.out.println("2:Ligar/desligar dispositivos.\n");
                 opcao = sc.nextInt();
                 if (opcao == 0) {
                    printFaturasTodas(dias,lot);

                 }

                 if (opcao == 1){
                    alteraValForn(lot);

                 }

                 if(opcao == 2){
                    changeStateDevices(lot);
                 }


             }

             System.out.println("Fim\n");

           }


    }

    public void printFaturasTodas(int dias, Loteamento lot){
        Map<CasaInteligente, Double> tot = calculaFaturasTodas(dias, lot);
        for (Map.Entry<CasaInteligente, Double> pair : tot.entrySet()) {
            System.out.println("Casa:" + pair.getKey() + "; Fatura:" + pair.getValue() + ";\n");
        }
    }

    public void alteraValForn(Loteamento lot){
        Scanner sc = new Scanner(System.in);
        String texto;
        int valBase;
        System.out.println("Insira o fornecedor que quer alterar:\n"); //TODO começar o relatorio.
        texto = sc.nextLine();
        System.out.println("Insira o novo valor base:\n");
        valBase = sc.nextInt();

        for(ArrayList<CasaInteligente> cil : lot.getLoteamento().values()){
            for(CasaInteligente ci : cil){
                if(texto.equals(ci.getForn().getString())){
                    ci.getForn().setValorBase(valBase);
                }
            }
        }
    }

    public void changeStateDevices(Loteamento lot){
        System.out.println("Insira o id do dispositivo ou 'all' se pretender alterar o estado de todos os dispositivos.\n");
        Scanner sc = new Scanner(System.in);
        String id = sc.nextLine();

        System.out.println("Insira:\n 'on' para ligar.\n 'off' para desligar.\n");
        String stateLine = sc.nextLine();
        boolean state = false;

        if (stateLine.equals("on")) {
            state = true;
        }

        if(id.equals("all")){
            System.out.println("Insira o nif do proprietario:\n");
            String nif = sc.nextLine();

            for(ArrayList<CasaInteligente> cil: lot.getLoteamento().values()){
                for(CasaInteligente ci : cil){
                    if (nif.equals(ci.getNif())){
                        ci.setAllOn(state);
                    }
                }
            }

        }
        else {

            for (ArrayList<CasaInteligente> cil : lot.getLoteamento().values()) {
                for (CasaInteligente ci : cil) {
                    for (SmartDevice sd : ci.getDevices().values()) {
                        if (id.equals(sd.getID())) {
                            sd.setOn(state);
                        }
                    }
                }
            }
        }
    }


    public double calculaFaturaCasa(int dias, CasaInteligente casa){
               double res = 0;

               for(SmartDevice d: casa.getDevices().values()){
                   res += (d.getConsumoDiarioEN() * dias);
               }

               return res;
    }

    public Map<CasaInteligente, Double> calculaFaturasTodas(int dias, Loteamento lot){

        Map<CasaInteligente, Double> faturas = new HashMap<>();


        for(ArrayList<CasaInteligente> arr : lot.getLoteamento().values()){

            for(CasaInteligente c: arr){
                double temp = calculaFaturaCasa(dias, c);
                faturas.put(c.clone(), temp);
            }
        }

        return faturas;
    }
}
