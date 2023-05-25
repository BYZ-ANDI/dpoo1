package presentation.controllers;

import Business.entities.Logs;
import Business.entities.Player;
import presentation.model.MainModel;
import presentation.views.GameTrackingView;
import presentation.views.LogsView;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.List;

public class LogsController implements ListSelectionListener {
    private GameTrackingView gameTrackingView;
    private LogsView logsView;
    private MainModel mainModel;

    public LogsController(GameTrackingView gameTrackingView, LogsView logsView, MainModel mainModel) {
        this.gameTrackingView = gameTrackingView;
        this.logsView = logsView;
        this.mainModel = mainModel;

        logsView.addTableRowSelectionListener(this);
    }

    public void updateLogs() {
        List<Logs> gameEvents = mainModel.getLogs();
        logsView.updateEvents(gameEvents);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            int rowIndex = logsView.getSelectedRowIndex();
            if (rowIndex >= 0) {
                Logs logs = mainModel.getLogs().get(rowIndex);
                Player character = logs.getCharacter();
                character.toggleClassification();

                gameTrackingView.actualizarVista();
            }
        }

    }
}
