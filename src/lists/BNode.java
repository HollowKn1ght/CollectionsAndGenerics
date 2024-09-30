package lists;

class BNode<T> {
    private T data;
    private BNode<T> prev;
    private BNode<T> next;

    BNode (T data){
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    BNode (BNode<T> prev, T data){
        this.data = data;
        this.prev = prev;
        this.next = null;
    }

    BNode (BNode<T> prev, T data, BNode<T> next){
        this.data = data;
        this.prev = prev;
        this.next = next;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setPrev(BNode<T> prev) {
        this.prev = prev;
    }

    public void setNext(BNode<T> next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public BNode<T> getNext() {
        return next;
    }

    public BNode<T> getPrev() {
        return prev;
    }
}
