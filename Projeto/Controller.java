import java.util.*;

public class Controller {

    public void run(){
           Scanner sc = new Scanner(System.in);

           System.out.println("\n\nBem-vindo!\n\n");
           System.out.println("Escolha uma das seguintes opcoes:\n");


           System.out.println("0: Carregar dados.\n");
           System.out.println("1: Criar casas e dispositivos manualmente.\n");


           int op = sc.nextInt();

           if(op==0){
             Parser p = new Parser();
             Loteamento lot = p.parse();
             System.out.println("Dados carregados com sucesso!\n");

             int opcao;

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
                 Map<CasaInteligente, Double> tot = calculaFaturasTodas(opcao, lot);


             }

             System.out.println("Fim\n");

           }

           if(op==1){
               System.out.println("Coloque abaixo os dados para a criação de uma casa:\n")
               System.out.println("Nome: \n");
               String nome = sc.nextLine();
               System.out.println("Nif:\n ");
               int nif = sc.nextInt();
               System.out.println("Fornecedor:\n");
               String nomeForn = sc.nextLine();
               System.out.println("Valor base de venda do fornecedor (inteiro):\n");
               int vb = sc.nextInt();
               Fornecedor fornec = new Fornecedor(nomeForn, vb);
               CasaInteligente casa = new CasaInteligente(nif, nome, fornec);

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
