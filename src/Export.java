import java.io.PrintWriter;
import java.util.ArrayList;

public class Export {

    public static void exportToJSON(DataObject object){
        String result = "{ \"tables\": \n";

        for(DataTable table : object.tables){
            result += "{ \n\"tablename\": \"" + table.tablename + "\", \n\"tableheader\": [";
            for(String header : table.header){
                result += "\"" + header + "\", ";
            }
            //remove ", " left at the end
            result = result.substring(0, result.length() - 2);
            result += "],\n\"tablerows\": {\n";

            int c = 0;
            for(ArrayList<String> row : table.rows){
                result += "\"row" + c + "\": [";
                for(String cell : row){
                    result += "\"" + cell + "\", ";
                }
                result = result.substring(0, result.length() - 2);
                result += "],\n";
                c++;
            }
            result = result.substring(0, result.length() - 2);
            result += "} \n } \n }";
        }

        PrintWriter writer = null;
        try{
            writer = new PrintWriter("test.json");
        } catch (Exception e) {
            e.printStackTrace();
        }
        writer.println(result);
        writer.close();
    }
}
