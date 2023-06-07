package tn.usousse.eniso.get1.stage1.presentation.view;


import tn.usousse.eniso.get1.stage1.presentation.controller.AppController;
import tn.usousse.eniso.get1.stage1.presentation.model.Node;
import tn.usousse.eniso.get1.stage1.presentation.model.Table;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class HashTableOfComponents extends JComponent {
    AppController controller;
   private Table tableModel;
    public HashTableOfComponents(AppController controller) {
        this.controller = controller;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                int caseSize = 100;
                int startX = (getWidth() - caseSize) / 2;
                int startY = (getHeight() - (caseSize * controller.getSize())) / 2;
                int nodeIndex = (y - startY) / caseSize;
                Node node = controller.getModel().getNodes()[nodeIndex];
                if (node != null) {
                    int r = startX;
                    while (node != null) {
                        int nodeX = r + caseSize + 50;
                        int nodeY = startY + (caseSize * nodeIndex) + caseSize + 20;
                        if (x >= nodeX && x <= nodeX + caseSize - 20 && y >= nodeY - caseSize - 30 && y <= nodeY - 40) {
                            int dialogResult = JOptionPane.showConfirmDialog(HashTableOfComponents.this,
                                    "Are you sure you want to delete this node?", "Confirmation", JOptionPane.YES_NO_OPTION);
                            if (dialogResult == JOptionPane.YES_OPTION) {
                                boolean removed = controller.getService().remove(node.getValue());
                                if (removed) {
                                    repaint();
                                } else {
                                    JOptionPane.showMessageDialog(HashTableOfComponents.this, "Node not found.");
                                }
                            }
                            break;
                        }
                        r += caseSize + 30;
                        node = node.getNext();
                    }
                }
            }
        });
    }
    public void setModel(Table tableModel) {
        this.tableModel = tableModel;
        SwingUtilities.invokeLater(this::repaint);
    }
    private void drawNode(Node node, Graphics2D g2d, int caseSize, int startX, int startY) {
        int i=controller.getService().hachF(node.getValue());
        int lineY = startY + caseSize * i+50;
        g2d.setStroke(new BasicStroke(1));
        g2d.drawLine(startX + caseSize, lineY, startX + caseSize + 50, lineY);
        int rectY = lineY + caseSize;
        g2d.drawRect(startX + caseSize + 50, rectY - caseSize - 30, caseSize - 20, caseSize - 40);
        g2d.drawString(node.getValue(), startX + caseSize + 75, lineY);
        g2d.drawLine(startX + caseSize * 2 + 30, lineY, startX + caseSize * 2 + 80, lineY);
        }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        super.paintComponent(g);
        g2d.setPaint(Color.WHITE);
        g2d.fill(getBounds());
        Table table=controller.getModel();
        int size= controller.getSize();
        table.setSize(size);
        System.out.println("table size : " + size);
        int caseSize = 100;
        int tableHeight = caseSize * size;
        Node[] nodes=table.getNodes();
        int startX = (getWidth() - caseSize) / 2;
        int startY = (getHeight() - tableHeight) / 2;
        int x=startX;
        int y=startY;
        for (int i = 0; i < controller.getSize(); i++) {
            g2d.setColor(Color.BLACK);
            g2d.setStroke(new BasicStroke(3));
            y = startY + i * caseSize;
            g2d.drawRect(startX, y, caseSize, caseSize);
            Node n = nodes[i];
            int r=startX;
            int z=caseSize;
            while (n != null) {
                drawNode(n, g2d, caseSize, r, startY);
                r += caseSize+30;
                if(n.next==null){
                drawEndOfNode(n,g2d, caseSize, r, startY);}
                n = n.getNext();
            }
        }
    }
    private void drawEndOfNode(Node node , Graphics g2d, int caseSize, int startX, int startY){
        int i=controller.getService().hachF(node.getValue());
        int lineY=startY+caseSize*i+50;
        int lineX=startX+caseSize*2-50;
        g2d.drawLine(lineX,lineY+20,lineX,lineY-20);
        g2d.drawLine(lineX,lineY+10,lineX+10,lineY+20);
        g2d.drawLine(lineX,lineY-10,lineX+10,lineY);
    }
}