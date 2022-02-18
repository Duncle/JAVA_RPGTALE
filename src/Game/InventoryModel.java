package Game;


import Game.Stuffs.Stuff;
import Game.Stuffs.StuffSubs.Equipments.Weapon;

import javax.swing.table.AbstractTableModel;
import java.io.Serializable;
import java.util.ArrayList;



public class InventoryModel extends AbstractTableModel implements Serializable {

    ArrayList<ArrayList<Stuff>> data;

    private boolean editable;

    public InventoryModel(boolean editable, ArrayList<ArrayList<Stuff>> data) {
        this.data = data;
        this.editable = editable;
    }

    // количество строк
    public int getRowCount() {
        return data.size();
    }

    // количество столбцов
    public int getColumnCount() {
        return data.get(0).size();
    }


    // тип данных, хранимых в столбце
    public Class getColumnClass(int column) {


        return Stuff.class;

    }

    // данные в ячейке
    public Object getValueAt(int row, int column) {
        return  data.get(row).get(column);

    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return editable;
    }

    @Override
    public void setValueAt(Object value, int row, int column) {
        (data.get(row)).set(column,  (Stuff) value);

    }
}