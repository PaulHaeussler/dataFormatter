

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Import {

    private static int maximumRows = 100000;

    public static DataTable importFromCsv(String path){

        File csv = new File(path);
        Object[] importedData = null;
        DataTable result = new DataTable(csv.getName());




        int c = 0;
        try {


            try (Scanner sc = new Scanner(new File(path), "UTF-8")) {

                while (sc.hasNextLine()) {
                    ArrayList<String> line = seperateByComma(sc.nextLine());

                    if(c == 0){
                        result.header = line;
                    } else {
                        result.rows.add(line);
                    }
                    c++;
                    if(c >= maximumRows) break;
                    System.out.println("Reading line " + c);
                }
                // note that Scanner suppresses exceptions
                if (sc.ioException() != null) {
                    throw sc.ioException();
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Finished reading all lines. Total count: " + c);
        return result;
    }

    private static ArrayList<String> seperateByComma(String input){
        ArrayList<String> result = new ArrayList<>();
        for(String str : input.split(",")){
            result.add(str.trim());
        }
        return result;
    }
}
