public class Menu {
  private int nLinha = 0;
  private int nPagina = 1;
  private static ListaOrdenadaDePalavras listaPal;
  private ArquivoTexto arquivo = new ArquivoTexto(); // objeto que gerencia o arquivo
  private LinhaTexto linha = new LinhaTexto(); // objeto que gerencia uma linha
  private ArquivoTexto arquivoStop = new ArquivoTexto();
  private LinhaTexto linhaStop = new LinhaTexto();
  private LinkedListOfString arrayStop = new LinkedListOfString();
  private String l;
  private static int numStop;

  public Menu(String arq) {
    arquivoStop.open("stopwords.txt");
    arquivo.open(arq);
    listaPal = new ListaOrdenadaDePalavras();
    numStop = 0;
    do {
      String lStop = arquivoStop.getNextLine();
      if (lStop == null) {
        break;
      }
      linhaStop.setLine(lStop);
      arrayStop.add(linhaStop.getNextWord());
    } while (true);
    do // laco que passa em cada linha do arquivo
    {
      l = arquivo.getNextLine();
      if (l == null) // acabou o arquivo?
        break;
      nLinha++; // conta mais uma linha lida do arquivo
      if (nLinha == 40) // chegou ao fim da pagina?
      {
        nLinha = 0;
        nPagina++;
      }

      linha.setLine(l); // define o texto da linha
      do // laco que passa em cada palavra de uma linha
      {
        String palavra = linha.getNextWord(); // obtem a proxima palavra da linha
        if (palavra == null)// acabou a linha
        {
          break;
        }
        boolean aux = false;
        if (arrayStop.contains(palavra)) {
          numStop++;
          aux = true;
        }
        if (palavra.equals("")) {
          aux = true;
        }
        if (aux == false) {
          listaPal.add(palavra, nPagina);
        }
      } while (true);

    } while (true);
    arquivo.close();
  }

  public static String remissivo() {
    return listaPal.toString();
  }

  public static String porcentagem() {
    return String.valueOf(((numStop * 100) / (numStop + (listaPal.size()))) + "%");
  }

  public static String frequente() {
    return listaPal.maiorOc();
  }

  public static String procura(String x) {
    return listaPal.procura(x);
  }
}
