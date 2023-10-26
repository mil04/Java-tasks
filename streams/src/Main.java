import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Etap 1
        System.out.println("Etap 1:");
        try {
          throw new InvalidFileException("Etap 1 działa prawidłowo");
        } catch (InvalidFileException e) {
          System.out.println(e.getMessage());
          System.out.println();
        }

        //Etap 2
        System.out.println("Etap 2:");
        String[] files = { "numbers0", "numbers1", "numbers2", "numbers3"};
        for(var file : files) {
            try {
                var result = Provider.GetMeanOfNumbers(file);
                System.out.println(result);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        System.out.println();

        //Etap 3
        System.out.println("Etap 3:");
        var j = new Job("Software Developer", 1_000_000_000);
        var p = new Person("Jan", "Kowalski", 30, j);

        try {
            Provider.SerializePerson(p, "person.xml");
            var p2 = Provider.DeserializePerson("person.xml");
            System.out.println(p2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();

        // Etap 4
        System.out.println("Etap 4:");
        var text = "d1e0j7*hfdjE2.3E+4irpEe+1fjau*71920;-q,.q79.83746E-10.85hgf7s0asdf jklf1faudifoqhwe 8 e+1fsauiryhfda8932;'@hjds";
        var numbers = Provider.GetAllNumbers(text);
        System.out.println(numbers);
        System.out.println();

        // Etap 5
        System.out.println("Etap 5:");
        System.out.println("Sprawdz folder 'etap5'");
        try {
            Provider.CopySpecialFiles("etap5");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}