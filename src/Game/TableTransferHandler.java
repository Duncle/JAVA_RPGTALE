package Game;

import Game.Stuffs.Stuff;
import Game.Stuffs.StuffSubs.Equipments.Weapon;

import javax.activation.ActivationDataFlavor;
import javax.activation.DataHandler;
import javax.swing.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;

public class TableTransferHandler extends TransferHandler implements Serializable {


    private JTable table;
    int selectedRow;
    int selectedColumn;


    public DataFlavor getLocalFlavor() throws ClassNotFoundException {
        return new DataFlavor(DataFlavor.javaJVMLocalObjectMimeType + ";class=\"" + table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()).getClass().getName() + "\"");
    }


//    Transferable transferable = new Transferable() {
//
//
//        @Override
//        public DataFlavor[] getTransferDataFlavors() {
//            return new DataFlavor[]{localFlavor};
//        }
//
//        @Override
//        public boolean isDataFlavorSupported(DataFlavor flavor) {
//            return true;
//        }
//
//        @Override
//        public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
//            System.out.println("ddddaa" + table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()));
//            return (Weapon) table.getValueAt(table.getSelectedRow(), table.getSelectedColumn());
//        }
//    };


    public TableTransferHandler(JTable table) {
        this.table = table;
    }

    @Override
    public int getSourceActions(JComponent c) {
        // данные могут копироваться или перемещаться
        return TransferHandler.COPY_OR_MOVE;
    }

    @Override
    public boolean canImport(TransferSupport support) {
        return true;
    }

    @Override
    protected Transferable createTransferable(JComponent c) {
        // стандартный способ адаптировать строку для обмена

        selectedRow = table.getSelectedRow();
        selectedColumn = table.getSelectedColumn();
        try {
            DataFlavor localFlavor = getLocalFlavor();
            return new DataHandler(table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()), localFlavor.getMimeType());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public boolean importData(TransferSupport support) {
        JTable.DropLocation dl = (JTable.DropLocation) support.getDropLocation();
        int dropLocationRow = dl.getRow();
        int dropLocationColumn = dl.getColumn();


        try {
            DataFlavor localFlavor = new DataFlavor(DataFlavor.javaJVMLocalObjectMimeType + ";class=\"" + table.getValueAt(selectedRow, selectedColumn).getClass().getName() + "\"");
            Stuff stuff = (Stuff) table.getValueAt(dropLocationRow, dropLocationColumn);
            table.setValueAt(support.getTransferable().getTransferData(localFlavor), dropLocationRow, dropLocationColumn);
            table.setValueAt(stuff, selectedRow, selectedColumn);
            table.revalidate();
            table.repaint();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

}