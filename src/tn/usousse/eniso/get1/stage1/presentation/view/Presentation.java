package tn.usousse.eniso.get1.stage1.presentation.view;
import javax.swing.*;

import tn.usousse.eniso.get1.stage1.presentation.controller.AppController;
import tn.usousse.eniso.get1.stage1.presentation.model.Table;
import tn.usousse.eniso.get1.stage1.service.AppService;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Presentation {
    public AppController controller=new AppController(new AppService(new Table(20)));
    JMenuItem addItem = new JMenuItem("Add");
    HashTableOfComponents tableOfComponents = new HashTableOfComponents(controller);
    public Presentation() {
    }
    public void run() {

        JFrame frame = new JFrame("Draw");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenu helpMenu = new JMenu("Help");

        JMenuItem exitItem = new JMenuItem("Exit");
        JMenuItem sizeItem = new JMenuItem("Size");
        JMenuItem aboutItem = new JMenuItem("About");
        frame.setVisible(true);

        addItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = JOptionPane.showInputDialog(frame, "Enter a name:");
                if (name != null) {
                    controller.add(name);
                    tableOfComponents.repaint();
                }
            }
        });

        sizeItem.addActionListener(new ActionListener() {
            // @Override
            public void actionPerformed(ActionEvent e) {
                // Open a dialog box to enter a size
                String sizeString = JOptionPane.showInputDialog(frame, "Enter a size:");
                if (sizeString != null) {
                    int size = Integer.parseInt(sizeString);
                    controller.setSize(size);
                    frame.add(tableOfComponents);
                    frame.getContentPane().add(tableOfComponents, BorderLayout.CENTER);
                    frame.revalidate();
                }
            }
        });

        aboutItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "This is the About dialog.");
            }
        });

        fileMenu.add(addItem);
        fileMenu.add(sizeItem);
        fileMenu.add(exitItem);

        helpMenu.add(aboutItem);
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);

        frame.setJMenuBar(menuBar);
        frame.setVisible(true);

    }
}