package presentation.controllers;

import Business.model.MainModel;
import presentation.views.CreationGameView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class CreationGameController implements ActionListener, MouseWheelListener {
    private CreationGameView creationGameView;
    private MainModel mainModel;

    public CreationGameController(CreationGameView creationGameView, MainModel mainModel) {
        this.creationGameView = creationGameView;
        this.mainModel = mainModel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(creationGameView.MAP_COMMAND)) {
            // Hacer lo del JFileChooser
        } else if(e.getActionCommand().equals(CreationGameView.SUBMIT_COMMAND)) {
            // Pasar a la MapView || GameView
        }
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        if(e.getSource() instanceof JComboBox<?>) {
            JComboBox<?> combobox = (JComboBox<?>) e.getSource();
            // We get the rotation value of the wheel
            // Positive value = down side rotation.
            int selectedItem = combobox.getSelectedIndex();
            int offset = e.getWheelRotation();
            selectedItem += offset;
            if (selectedItem < 0) {
                selectedItem = combobox.getItemCount() + selectedItem;
            }
            selectedItem %= combobox.getItemCount();
            combobox.setSelectedIndex(selectedItem);
            String comboBoxName = combobox.getName();

            if(comboBoxName.equals(creationGameView.NUMPERS_COMMAND)) {
                //int num_pers = Integer.parseInt((String) combobox.getSelectedItem());
            } else if(comboBoxName.equals(creationGameView.NUMIMP_COMMAND)) {
                //int num_impos = Integer.parseInt((String) combobox.getSelectedItem());
            } else if(comboBoxName.equals(creationGameView.COLORS_COMMAND)) {
                //String color = (String) combobox.getSelectedItem();
            }
        }
    }
}

