import java.util.ArrayList;

public class DataTable {

    public String tablename;
    public ArrayList<String> header;
    public ArrayList<ArrayList<String>> rows = new ArrayList<ArrayList<String>>();

    public DataTable(String name){
        tablename = name;
    }
}
