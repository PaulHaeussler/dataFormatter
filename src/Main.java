public class Main {


    public static void main(String[] args){

        String input = "C:\\Users\\paulh\\Desktop\\data\\flights.csv";
        DataTable table = Import.importFromCsv(input);
        DataObject obj = new DataObject(table);
        Export.exportToJSON(obj);

    }
}
