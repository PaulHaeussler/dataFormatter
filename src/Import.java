import com.opencsv.CSVReader;

import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Import {

    public static DataTable importFromCsv(String path){

        File csv = new File(path);
        Object[] importedData = null;
        DataTable result = new DataTable(csv.getName());

        try {
            CSVReader reader = new CSVReader(new FileReader(path));
            String[] nextLine;
            boolean isFirstLine = true;
            while ((nextLine = reader.readNext()) != null) {
                ArrayList<String> line = new ArrayList<>();
                for(String str : nextLine){line.add(str);}

                if(isFirstLine){
                    result.header = line;
                    isFirstLine = false;
                } else {
                    result.rows.add(line);
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }

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
