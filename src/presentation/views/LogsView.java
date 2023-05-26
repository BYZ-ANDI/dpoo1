package presentation.views;

import Business.entities.Logs;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class LogsView extends JPanel{
    private JTable table;
    private DefaultTableModel tableModel;

    public LogsView() {
        tableModel = new DefaultTableModel();
        tableModel.addColumn("CREWMATE");
        tableModel.addColumn("ROOM");
        tableModel.addColumn("INSTANT");

        table = new JTable(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(600, 400));

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
    }

    public void updateEvents(List<Logs> events) {
        tableModel.setRowCount(0);

        for (Logs event : events) {
            Object[] rowData = {
                    event.getCharacter().getColor(),
                    event.getRoom().getId(),
                    event.getTimestamp().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            };

            tableModel.addRow(rowData);
        }
    }

    public void addTableRowSelectionListener(ListSelectionListener listener) {
        table.getSelectionModel().addListSelectionListener(listener);
    }

    public int getSelectedRowIndex() {
        return table.getSelectedRow();
    }
}
