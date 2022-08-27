
public class LinkedListOfString {

    // Classe interna Node
    private class Node {
        public String element;
        public Node next;

        public Node(String element) {
            this.element = element;
            next = null;
        }
    }

    
    private Node head;
    private Node tail;
    private int count;

   
    public LinkedListOfString() {
        head = null;
        tail = null;
        count = 0;
    }

   
    public int size() {
        return count;
    }

   
    public void add(String element)  { 
        Node n = new Node(element);
        if (head == null) {
            head = n;
        } else {
            tail.next = n;
        }
        tail = n;
        count++;
    }
    

    public String get(int index) { 
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException();
        }
        if (index == count-1)
            return tail.element;
        
        Node aux = head;
        int c = 0;
        while (c < index) {
            aux = aux.next;
            c++;
        }
        return (aux.element);
    }

    public boolean contains(String element){
        for (int i = 0; i < count; i++) {
            if(element.equals(get(i))){
                return true;
            }
        }
        return false;
    } 
}