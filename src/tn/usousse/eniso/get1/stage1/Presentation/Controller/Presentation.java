package tn.usousse.eniso.get1.stage1.Presentation.Controller;
import javax.swing.*;
import tn.usousse.eniso.get1.stage1.Presentation.Model.Table;
import tn.usousse.eniso.get1.stage1.Presentation.View.HashTableOfComponents;
import tn.usousse.eniso.get1.stage1.Service.Service;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;


public class Presentation {
    public int size;
    JMenuItem addItem = new JMenuItem("Add");

    public void console() {
        Table table = new Table(3);
        Service service = new Service(table);
        HashTableOfComponents tableOfComponents = new HashTableOfComponents();
        JFrame frame = new JFrame("Draw");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       // frame.setVisible(true);

        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenu helpMenu = new JMenu("Help");

        // Create JMenuItem objects

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
                   // service.add(name);
                    tableOfComponents.setName(name);
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
                    service.getTable().setSize(size);
                    System.out.println(size);
                    tableOfComponents.setSize(size);
                    frame.add(
                            tableOfComponents
                    );
                    frame.setVisible(true);
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

       fileMenu.add(addItem);
       fileMenu.add(sizeItem);
       fileMenu.add(exitItem);

       helpMenu.add(aboutItem);
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);

        frame.setJMenuBar(menuBar);
        frame.setVisible(true);

        /*JFrame fr = new JFrame();
        final DrawPad drawPad = new DrawPad();
        fr.add(drawPad, BorderLayout.CENTER);
        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                drawPad.clear();
            }
        });
        fr.add(clearButton, BorderLayout.SOUTH);
        fr.setSize(280, 300);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setVisible(true);
    }

}
class DrawPad extends JComponent {
    Image image;
    Graphics2D graphics2D;
    int currentX, currentY, oldX, oldY;
    public DrawPad() {
        setDoubleBuffered(false);
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                oldX = e.getX();
                oldY = e.getY();
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                currentX = e.getX();
                currentY = e.getY();
                if (graphics2D != null)
                    graphics2D.drawLine(oldX, oldY, currentX, currentY);
                repaint();
                oldX = currentX;
                oldY = currentY;
            }
        });
    }

    public void paintComponent(Graphics g) {
        if (image == null) {
            image = createImage(getSize().width, getSize().height);
            graphics2D = (Graphics2D) image.getGraphics();
            graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            clear();
        }
        g.drawImage(image, 0, 0, null);
    }

    public void clear() {
        graphics2D.setPaint(Color.white);
        graphics2D.fillRect(0, 0, getSize().width, getSize().height);
        graphics2D.setPaint(Color.black);
        repaint();}


       /* public DefaultTableModel adding(String val,DefaultTableModel tableModel){
            tableModel.addColumn("Languages");
            tableModel.insertRow(0, new Object[] { "CSS" });
            tableModel.insertRow(0, new Object[] { "HTML5" });
            tableModel.insertRow(0, new Object[] { "JavaScript" });
            tableModel.insertRow(0, new Object[] { "jQuery" });
            tableModel.insertRow(0, new Object[] { "AngularJS" });
            // adding a new row
            tableModel.insertRow(tableModel.getRowCount(), new Object[] { "ExpressJS" });

            fr.add(new JScrollPane(tab));


        }

        // Make the frame visible






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

        /* JFrame f = new JFrame();
        final JLabel label = new JLabel();
        label.setSize(500, 100);
        JButton b = new JButton("Show");
        b.setBounds(200, 150, 80, 30);
        final DefaultListModel<String> l1 = new DefaultListModel<>();
        l1.addElement("C");
        l1.addElement("C++");
        l1.addElement("Java");
        l1.addElement("PHP");
        final JList<String> list1 = new JList<>(l1);
        list1.setBounds(100, 100, 75, 75);
        DefaultListModel<String> l2 = new DefaultListModel<>();
        l2.addElement("Turbo C++");
        l2.addElement("Struts");
        l2.addElement("Spring");
        l2.addElement("YII");
        final JList<String> list2 = new JList<>(l2);
        list2.setBounds(100, 200, 75, 75);
        f.add(list1);
        f.add(list2);
        f.add(b);
        f.add(label);
        f.setSize(450, 450);
        f.setLayout(null);
        f.setVisible(true);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String data = "";
                if (list1.getSelectedIndex() != -1) {
                    data = "Programming language Selected: " + list1.getSelectedValue();
                    label.setText(data);
                }
                if (list2.getSelectedIndex() != -1) {
                    data += ", FrameWork Selected: ";
                    for (Object frame : list2.getSelectedValues()) {
                        data += frame + " ";
                    }
                }
                label.setText(data);
            }
        });
       /* DefaultTableModel tableModel = new DefaultTableModel();
        JTable tab = new JTable(tableModel);
        tableModel.addColumn("Languages");
        tableModel.insertRow(0, new Object[] { "CSS" });
        tableModel.insertRow(0, new Object[] { "HTML5" });
        tableModel.insertRow(0, new Object[] { "JavaScript" });
        tableModel.insertRow(0, new Object[] { "jQuery" });*/




    }}
