import java.util.Collection;
import java.util.Iterator;

public class BinaryTree implements Collection<Dog> {
    private Node root;
    private class Node{
        Dog dog;
        Node left;
        Node right;
        public Node(Dog dog){
            this.dog=dog;
        }
    }


    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<Dog> iterator() {
        return new Iterator<Dog>() {
            private Node current = root;

            @Override
            public boolean hasNext() {
                if(this.current ==null) return false;
                else return true;
            }

            @Override
            public Dog next() {
                Dog cur = this.current.dog;
                if(hasNext()){
                    current = current.left;
                }
                return cur;
            }
        };
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(Dog dog) {
        if(this.root == null){
            this.root = new Node(dog);
            return true;
        }
        else{
            Node node = this.root;
            while(node.left!=null){
                node = node.left;
            }
            node.left = new Node(dog);
            return true;
        }
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Dog> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}
