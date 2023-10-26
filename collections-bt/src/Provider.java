import java.util.*;
import java.util.function.Consumer;


public class Provider {

    public static  <T extends Comparable<T>> Runnable getAddToListHandler(ListIterator<T> iterator, Collection<T> collection, Consumer<T> fun){
        return ()->{
            for(T t : collection)
            {
                fun.accept(t);
                iterator.add(t);
                iterator.previous();
            }
        };
    }


    public static Map<Breed, List<Dog>> getDogMapped(Collection<Dog> dogs) {
        Map<Breed, List<Dog>> map = new HashMap<>();

        for (Dog dog : dogs) {
            if (!map.containsKey(dog.breed())) {
                map.put(dog.breed(), new ArrayList<>());
            }
            map.get(dog.breed()).add(dog);
        }

        return map;
    };

}
