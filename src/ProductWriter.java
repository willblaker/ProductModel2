import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductWriter {
    public static void main(String[] args)
    {
        // Test data the lines of the file we will write
        ArrayList <String>recs = new ArrayList<>();
        ArrayList<Product> pList = new ArrayList<Product>();

        Scanner in = new Scanner(System.in);
        boolean done = false;
        String id;
        String name;
        String desc;
        double cost;
        do{
            //get input from user
            id = SafeInput.getNonZeroLenString(in, "Input ID: ");
            name = SafeInput.getNonZeroLenString(in, "Input Name: ");
            desc = SafeInput.getNonZeroLenString(in, "Input Description: ");
            cost = SafeInput.getDouble(in, "Input Cost: ");
            //put them into string, with commas separating data
            String input = id + ", " + name + ", " + desc + ", " + cost;
            // add to the array list
            Product p = new Product(id, name, desc, cost);
            pList.add(p);
            recs.add(input);
            done = SafeInput.getYNConfirm(in, "Are you done?");
        }while(!done);

        // uses a fixed known path:
        //  Path file = Paths.get("c:\\My Documents\\data.txt");

        // use the toolkit to get the current working directory of the IDE
        // will create the file within the Netbeans project src folder
        // (may need to adjust for other IDE)
        // Not sure if the toolkit is thread safe...
        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\ProductTestData.txt");

        try
        {
            // Typical java pattern of inherited classes
            // we wrap a BufferedWriter around a lower level BufferedOutputStream
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

            // Finally can write the file LOL!

            for(String rec : recs)
            {
                writer.write(rec, 0, rec.length());  // stupid syntax for write rec
                // 0 is where to start (1st char) the write
                // rec. length() is how many chars to write (all)
                writer.newLine();  // adds the new line

            }
            writer.close(); // must close the file to seal it and flush buffer
            System.out.println("Data file written!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
