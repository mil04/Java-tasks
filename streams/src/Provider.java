import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Provider {
    public static double GetMeanOfNumbers(String path) throws InvalidFileException, IllegalArgumentException{
        int num=0;
        int sum=0;
        try(var reader = new FileReader(path)){
            var st = new StreamTokenizer(reader);
            while(st.nextToken() != StreamTokenizer.TT_EOF){
                if(st.ttype == StreamTokenizer.TT_NUMBER) {
                    num++;
                    sum += st.nval;
                }
            }

        }catch (Exception e){
            InvalidFileException ife = new InvalidFileException();
            ife.initCause(e);
            throw ife;
        }
        if(num==0){
            throw new IllegalArgumentException();
        }else{
            return sum/num;
        }
    }
    public static void SerializePerson(Person person, String path) throws InvalidFileException{
        try(var encoder = new XMLEncoder(new FileOutputStream(path))){
            encoder.writeObject(person);
        } catch(Exception e) {
            InvalidFileException ife = new InvalidFileException();
            ife.initCause(e);
            throw ife;
        }
    }
    public static Person DeserializePerson(String path) throws InvalidFileException{
        try(var it = new XMLDecoder(new BufferedInputStream(new FileInputStream(path)))){
            return (Person) it.readObject();
        }catch(Exception e) {
            InvalidFileException ife = new InvalidFileException();
            ife.initCause(e);
            throw ife;
        }
    }
    public static List<Double> GetAllNumbers(String string){
        Pattern p = Pattern.compile("(([0-9].([0-9]+))|([0-9]))[E,e]([+,-]?)([0-9]+)");
        //biarac pod uwage ujemne (-?)(([0-9].([0-9]+))|([0-9]))[E,e]([+,-]?)([0-9]+)
        Matcher m = p.matcher(string);
        List<Double> list = new ArrayList<Double>();
        while(m.find()) {
            list.add(Double.parseDouble(m.group()));
        }
        return list;
    }
    public static void CopySpecialFiles(String path) throws IOException {
        File dir = new File(path);
        getTree(dir, 0);
    }

    private static void getTree(File dir, int tabs) throws IOException {
        File copy = new File(dir.getAbsolutePath() + ".copy");
        for (var item : dir.listFiles()) {
            if (item.isFile()) {
                if (item.getName().matches("x")) {
                    Files.copy(item.toPath(),copy.toPath());
                }
            } else {
                getTree(item, tabs + 1);
            }
        }
    }
}
