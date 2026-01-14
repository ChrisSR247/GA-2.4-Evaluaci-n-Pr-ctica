public class RouteManager<T> implements IContainer<T> {

    private Node<T> head;
    private Node<T> tail;
    private Node<T> current;

    public RouteManager() {
        head = null;
        tail = null;
        current = null;
    }

    @Override
    public void add(T element) {
        Node<T> newNode = new Node<>(element);

        if (head == null) {
            head = tail = current = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    @Override
    public boolean remove(T element) {
        Node<T> temp = head;

        while (temp != null) {
            if (temp.data.equals(element)) {

                if (temp.prev != null) {
                    temp.prev.next = temp.next;
                } else {
                    head = temp.next;
                }

                if (temp.next != null) {
                    temp.next.prev = temp.prev;
                } else {
                    tail = temp.prev;
                }

                if (temp == current) {
                    current = temp.next;
                }

                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    @Override
    public T get(String id) {
        return null; // no aplica para rutas
    }

    public void moveNext() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Movido a siguiente punto");
        }
    }

    public void movePrev() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Retorno a punto previo");
        }
    }
}
