import java.util.ArrayList;

public class DataObject {

    public ArrayList<DataTable> tables;


    public DataObject(ArrayList<DataTable> list){
        tables = list;
    }

    public DataObject(DataTable table){
        ArrayList<DataTable> list = new ArrayList<>();
        list.add(table);
        tables = list;
    }
}
