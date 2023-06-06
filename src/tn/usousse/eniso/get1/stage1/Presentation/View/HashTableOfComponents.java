package tn.usousse.eniso.get1.stage1.Presentation.View;


import tn.usousse.eniso.get1.stage1.Presentation.Model.Table;
import tn.usousse.eniso.get1.stage1.Service.Service;

import javax.swing.*;
import java.awt.*;

public class HashTableOfComponents extends JComponent {
    private int tableSize;
    private String name ="eya";
    public HashTableOfComponents(){
        tableSize = 0;
    }

    public void setSize(int size) {
        this.tableSize = size;
    }
    public void setName(String name){
        this.name = name;
    }

    private void drawNode(Graphics2D g2d,int caseSize, int startX, int startY){
        if(name !=null){
            Table table = new Table(tableSize);
            Service service = new Service(table);
            int i = service.hachF(name);
            int lineY = startY +caseSize* i+50;
            g2d.drawLine(startX+caseSize, lineY, startX + caseSize+50, lineY);
            int rectY = lineY + caseSize;
            g2d.drawRect(startX+caseSize+50, rectY-caseSize-30, caseSize -20, caseSize -40);
            g2d.drawString(name, startX + caseSize + 75, lineY);
            g2d.drawLine(startX + caseSize*2+30, lineY, startX + caseSize*2+100, lineY);
            int lineX = startX + caseSize*2+100;
            g2d.drawLine(lineX, lineY+20, lineX, lineY-20);
            g2d.drawLine(lineX, lineY+10, lineX +10, lineY+20 );
            g2d.drawLine(lineX, lineY-10, lineX +10, lineY );


        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int caseSize = 100;
        int tableHeight = caseSize*tableSize;

        int startX = (getWidth() - caseSize) / 2;
        int startY = (getHeight() - tableHeight) / 2;

        for (int i = 0; i < tableSize; i++) {
            int y = startY + i * caseSize;
            g2d.drawRect(startX, y, caseSize, caseSize);

        }

        drawNode(g2d,caseSize,startX,startY);
    }
}













/*package tn.usousse.eniso.get1.stage1.Presentation.View;

import tn.usousse.eniso.get1.stage1.Presentation.Model.Table;
import tn.usousse.eniso.get1.stage1.Service.Service;

import javax.swing.*;
import java.awt.*;

public class HashTableOfComponents extends JComponent {
  private int size;
  String name;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public void setSize(int size) {
        this.size = size;
    }
    Table table = new Table(size);
    Service service=new Service(table);
    int index=service.hachF(name);
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d=(Graphics2D) g;
        g.setColor(Color.red);
        g2d.drawString(name,200,60+index*80);
        for (int i = 1; i <this.size ; i++) {
            g2d.drawRect(50,60+i*50,220,100);
            g2d.drawLine(270,190,500,190);

        }

    */
