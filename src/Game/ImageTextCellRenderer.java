package Game;

import Game.Stuffs.Stuff;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class ImageTextCellRenderer extends DefaultTableCellRenderer {
    // Метод получения компонента для прорисовки
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                   boolean hasFocus, int row, int column) {
        // Объект прорисовки
        Stuff weapon = (Stuff) value;

        // Надпись от базового класса
        JLabel label = new JLabel();
        // Размещение значка
        label.setIcon(weapon.texture);
        // Выравнивание
        if (column == 2)
            label.setHorizontalAlignment(JLabel.RIGHT);
        else
            label.setHorizontalAlignment(JLabel.LEFT);
        return label;
    }
}