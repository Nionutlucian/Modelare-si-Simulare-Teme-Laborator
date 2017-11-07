package classes;

import java.util.HashMap;
///hashmap<actiune,<stare_curenta,stare_urmatoare>>
public class Table {

    Table(){
        addTable();
    }

    public HashMap<Coffe,HashMap<Coffe,Coffe>> table = new HashMap<>();

    public void setTable(HashMap<Coffe, HashMap<Coffe, Coffe>> table) {
        this.table = table;
    }

    public void addTable(){
        HashMap<Coffe,Coffe> map = new HashMap<>();
        map.put(Coffe.ZERO,Coffe.FIVECOIN);
        map.put(Coffe.FIVECOIN,Coffe.TENCOIN);
        map.put(Coffe.TENCOIN,Coffe.FIFTYCOIN);
        table.put(Coffe.FIVECOIN,map);

        HashMap<Coffe,Coffe> map1 = new HashMap<>();
        map1.put(Coffe.ZERO,Coffe.TENCOIN);
        map1.put(Coffe.FIVECOIN,Coffe.FIFTYCOIN);
        table.put(Coffe.TENCOIN,map1);

        HashMap<Coffe,Coffe> map5 = new HashMap<>();
        map5.put(Coffe.TENCOIN,Coffe.ZERO);
        map5.put(Coffe.FIFTYCOIN,Coffe.FIVECOIN);
        table.put(Coffe.COFFE1,map5);

        HashMap<Coffe,Coffe> map7 = new HashMap<>();
        map7.put(Coffe.FIFTYCOIN,Coffe.ZERO);
        table.put(Coffe.COFFE2,map7);

        setTable(table);
    }
}
