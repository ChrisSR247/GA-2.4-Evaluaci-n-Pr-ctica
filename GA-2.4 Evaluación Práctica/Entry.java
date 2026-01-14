public class Entry <K, V>{
    K key;
    V value;
    Entry <K, V> next;

    public Entry(K key, V vlue){
        this.key= key;
        this.value = value;
        this.next = null;
    }
}