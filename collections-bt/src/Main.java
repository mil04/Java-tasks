import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Etap 1
        System.out.println("Etap 1");
        List<Dog> dogs = new ArrayList<>(List.of(
                new Dog("Azor", Breed.HUSKY, 50.5),
                new Dog("Azor", Breed.DACHSHUND, 53.5),
                new Dog("Saba", Breed.HUSKY, 47),
                new Dog("Saba", Breed.MONGREL, 53.5),
                new Dog("Burek", Breed.DACHSHUND, 150.5),
                new Dog("Bajka", Breed.HUSKY, 5.5)
        ));


        dogs.sort((d1,d2)-> d1.compareTo(d2));
        System.out.println(dogs);


        dogs.sort((d1,d2)-> d1.compareTo(d2));
        dogs.sort((d1,d2)->{

            if(d1.breed().name().compareTo(d2.breed().name())>0) return 1;
            if(d1.breed().name().compareTo(d2.breed().name())<0) return -1;
            return 0;
        });
        System.out.println(dogs);



//        3) trzecie sortowanie (3pkt) sortowało w taki sposób, że na początku są psy o imieniu Azor, a na końcu psy o imieniu Saba;
//        ponadto drugorzędnym kryterium sortowania jest masa psa, ale sortowanie po masie powinno być malejące.

        dogs.sort((d1,d2)-> (-d1.compareTo(d2)));
        dogs.sort((d1,d2)->{
            if(d1.name()=="Azor" && d2.name()!="Azor") return -1;
            if(d1.name()!="Azor" && d2.name()=="Azor") return 1;
            return 0;
        });
        dogs.sort((d1,d2)->{
            if(d1.name()=="Saba" && d2.name()!="Saba") return 1;
            if(d1.name()!="Saba" && d2.name()=="Saba") return -1;
            return 0;
        });
        System.out.println(dogs);
        System.out.println();

        // Etap 2
        System.out.println("Etap 2");

        BinaryTree bt = new BinaryTree();
        bt.add(dogs.get(0));
        bt.add(dogs.get(1));
        bt.add(dogs.get(2));
        bt.add(dogs.get(3));
        bt.add(dogs.get(4));
        bt.add(dogs.get(5));

        for (Dog d: dogs) {
            System.out.println(d);
        }
        System.out.println();

        // Etap 3
        System.out.println("Etap 3");
        List<Dog> dogList = new ArrayList<>();


        Runnable fun = Provider.getAddToListHandler(dogList.listIterator(), bt, (Dog d) -> d.getMoreMass());
        fun.run();

        System.out.println(dogList);

        System.out.println();

        // Etap 4
        System.out.println("Etap 4");
        var map = Provider.getDogMapped(bt);
        System.out.println(map.toString().replace("{", "{\n\t").replace("}", "\n}").replace(")], ", ")], \n\t"));
    }
}