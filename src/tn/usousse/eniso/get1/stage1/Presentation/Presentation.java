package tn.usousse.eniso.get1.stage1.Presentation;
import javax.swing.*;
import javax.swing.table.TableColumn;
import tn.usousse.eniso.get1.stage1.Model.Table;
import tn.usousse.eniso.get1.stage1.Service.Service;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Presentation {
    private int size;
    public JScrollPane drawTable(int size){
        String[][] data = new String[size][1];
        String[] columnNAmes={"NAme"};
        JTable j = new JTable(data, columnNAmes);
        j.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        TableColumn column = j.getColumnModel().getColumn(0);
        column.setPreferredWidth(200);
        return new JScrollPane(j);
    }
    public void console() {
        Table table = new Table(3);
        Service service = new Service(table);
        JFrame frame = new JFrame("Menu Bar Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(400, 300);
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenu helpMenu = new JMenu("Help");

        // Create JMenuItem objects
        JMenuItem addItem = new JMenuItem("Add");
        JMenuItem exitItem = new JMenuItem("Exit");
        JMenuItem sizeItem = new JMenuItem("Size");
        JMenuItem aboutItem = new JMenuItem("About");
        //salem alaykom
        // ActionListener for "Add" menu item
        addItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open a dialog box to enter a name
                String name = JOptionPane.showInputDialog(frame, "Enter a name:");
                if (name != null) {
                    service.add(name);
                    service.list();
                }
            }
        });

        // ActionListener for "Size" menu item
        sizeItem.addActionListener(new ActionListener() {
           // @Override
            public void actionPerformed(ActionEvent e) {
                // Open a dialog box to enter a size
                String sizeString = JOptionPane.showInputDialog(frame, "Enter a size:");
                if (sizeString != null) {
                    size = Integer.parseInt(sizeString);
                    JScrollPane jtab = drawTable(size);
                    frame.add(jtab);
                    frame.setVisible(true);
                    service.getTable().setSize(size);
                    System.out.println(size);
                }
            }
        });
        // ActionListener for "About" menu item
        aboutItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Show a message dialog with information
                JOptionPane.showMessageDialog(frame, "This is the About dialog.");
            }
        });

        // Add JMenuItems to JMenus
        fileMenu.add(addItem);
        fileMenu.add(sizeItem);
        fileMenu.add(exitItem);

        helpMenu.add(aboutItem);

        // Add JMenus to JMenuBar
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);

        // Set the menu bar for the frame
        frame.setJMenuBar(menuBar);
        //service.list();

        // Make the frame visible
        frame.setVisible(true);




       /*String name=null;
        String operation="start";
        System.out.println("Hey! You can get started");
        while (!(operation.equals("exit"))){
        Scanner demand=new Scanner(System.in);
        operation=demand.nextLine();
        operation=operation.trim();
        String[] listOfItems=operation.split(" +");
        if (listOfItems.length==2){
            operation=listOfItems[0];
            name=listOfItems[1];}
        else {
            operation=listOfItems[0];
        }
        //System.out.println("operation: "+operation);
        //System.out.println("name: "+name);

            switch(operation){
                case "add": {service.add(name);break;}
                case "remove":{service.remove(name);break;}
                case "find":{System.out.println(service.find(name));break;}
                case"list":{service.list(); break;}
                case"exit":{break;}
                default:
                    System.out.println("no valid operation");
            }}
        }


      /* service.add("Eya");
        service.add("tasnim");
        service.add("eya1");
        // boolean x=service.remove("Eya");
        service.add("taysirr");
        service.add("jihed");
        service.add("taha");
        service.add("mondher");
        service.remove("eya1");
       // service.remove("taysirr");
       // service.remove("taha");
        // service.remove("tasnim");
       // service.remove("jihed");
        service.remove("taha");
       /*System.out.println(service.toString());
        System.out.println(service.find("eya1"));
        System.out.println(service.find("ahlem"));*/
        //service.list();
        //System.out.println(x);

        // System.out.println(x);
     /* boolean x=false;
        System.out.println(x);
      x=service.remove("taha");
        System.out.println(x);
        service.add("alae");
        service.list();
        System.out.println("hello");*/
    }
}
