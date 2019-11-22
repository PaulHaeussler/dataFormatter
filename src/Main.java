public class Main {


    public static void main(String[] args){

        String input = "C:\\Users\\Paul\\Desktop\\data\\flights.csv";
        DataTable table = Import.importFromCsv(input);
        DataObject obj = new DataObject(table);
        System.out.println("Created DataObject. Total Lines: " + table.rows.size());
        Export.exportToJSON(obj);

    }
}
