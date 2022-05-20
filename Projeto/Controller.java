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

             int opcao;
             String texto;

             while(true){
                 System.out.println("Pretende avancar no tempo?\n");
                 System.out.println("0: Sim\n");
                 System.out.println("1: Nao\n");
                 opcao = sc.nextInt();
                 if(opcao==1){
                     break;
                 }
                 System.out.println("Quanto tempo, em dias, pretende avançar no tempo?\n");
                 opcao = sc.nextInt();
                 System.out.println("Indique a operação que pretende realizar:");
                 System.out.println("0:Calcular faturas de todas as casas.");
                 System.out.println("1:Alterar valores base fornecedores");
                 opcao = sc.nextInt();
                 if (opcao == 0) {

                     Map<CasaInteligente, Double> tot = calculaFaturasTodas(opcao, lot);
                     for (Map.Entry<CasaInteligente, Double> pair : tot.entrySet()) {
                         System.out.println("Casa:" + pair.getKey() + "; Fatura:" + pair.getValue() + ";");
                     }
                 }

                 if (opcao == 1){
                    System.out.println("Insira o fornecedor que quer alterar:"); //TODO terminar alteracao valores fornecedores, ligar e desligar todos e um dispositivo em especifico, ver diagrama de classes e começar o relatorio.


                 }
             }

             System.out.println("Fim\n");

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
