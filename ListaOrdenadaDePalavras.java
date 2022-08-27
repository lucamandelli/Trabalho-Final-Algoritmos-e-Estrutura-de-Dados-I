/**
 * Esta classe guarda as palavra do indice remissivo em ordem alfabetica.
 * 
 * @author Isabel H. Manssour
 */

public class ListaOrdenadaDePalavras {
    // Classe interna
    private class Palavra {
        public String s;
        public ListaDeOcorrencias listaOcorrencias;
        public Palavra next;
        public int oc;

        public Palavra(String str) {
            s = str;
            next = null;
            listaOcorrencias = new ListaDeOcorrencias();
            oc = 0;
        }

        public void addOcorrencia(int numPag) {
            listaOcorrencias.add(numPag);
        }

        public void ocorrencia() {
            oc++;
        }
    }

    private Palavra head;
    private Palavra tail;
    private int count;

    public ListaOrdenadaDePalavras() {
        head = null;
        tail = null;
        count = 0;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public int size() {
        return count;
    }

    public void clear() {
        head = null;
        tail = null;
        count = 0;
    }

    public boolean add(String palavra, int numPagina) {
        Palavra aux = head;
        for (int i = 0; i < count; i++) {
            if (aux.s.equals(palavra)) {
                aux.addOcorrencia(numPagina);
                aux.ocorrencia();
                return true;
            }
            aux = aux.next;
        }
        Palavra n = new Palavra(palavra);
        if (head == null) {
            head = n;
        } else {
            String aux2;
            for (int i = 0; i < count; i++) {
                aux2 = getElement(i);
                if (palavra.compareTo(aux2) < 0) {
                    n.next = getNode(i);
                    if (head.s == aux2) {
                        head = n;
                        n.addOcorrencia(numPagina);
                        n.ocorrencia();
                        count++;
                        return true;
                    }
                    getNode(i - 1).next = n;
                    n.addOcorrencia(numPagina);
                    n.ocorrencia();
                    count++;
                    return true;
                }
            }
            tail.next = n;
        }
        tail = n;
        n.addOcorrencia(numPagina);
        n.ocorrencia();
        count++;
        return true;
    }

    public String getElement(int index) {
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException();
        }
        if (index == count - 1) {
            return tail.s;
        }
        Palavra aux = head;
        int c = 0;
        while (c < index) {
            aux = aux.next;
            c++;
        }
        return (aux.s);
    }

    public Palavra getNode(int index) {
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException();
        }
        if (index == count - 1) {
            return tail;
        }
        Palavra aux = head;
        int c = 0;
        while (c < index) {
            aux = aux.next;
            c++;
        }
        return aux;
    }

    public String toString() {
        String a = "";
        Palavra aux = head;
        for (int i = 0; i < count; i++) {
            a += aux.s + " [ Total de ocorrencias: " + aux.oc + " Páginas: " + aux.listaOcorrencias.toString() + "]\n";
            aux = aux.next;
        }
        return a;
    }

    public String maiorOc() {
        Palavra aux = head;
        Palavra maior = head;
        int ocAux = -1;
        for (int i = 0; i < count; i++) {
            if (aux.oc > ocAux) {
                ocAux = aux.oc;
                maior = aux;
            }
            aux = aux.next;
        }
        return maior.s + " - Número de ocorrências: " + maior.oc;
    }

    public String procura(String x) {
        x = x.toLowerCase();
        Palavra aux = head;
        for (int i = 0; i < count; i++) {
            if (aux.s.equals(x)) {
                return aux.s + " [ Total de ocorrencias: " + aux.oc + " Páginas: " + aux.listaOcorrencias.toString()
                        + "]";
            }
            aux = aux.next;
        }
        return null;
    }

}
