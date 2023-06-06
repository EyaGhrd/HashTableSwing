package tn.usousse.eniso.get1.stage1.Service;

import tn.usousse.eniso.get1.stage1.Presentation.Model.Node;
import tn.usousse.eniso.get1.stage1.Presentation.Model.Table;

public class Service {
     Table table;

    public Table getTable() {
        return table;
    }

    public Service(Table table) {
        this.table = new Table(table.getSize());
    }

    public int hachF(String value){
        int s=0;
        if (value!=null){
            for (char ch:value.toCharArray()){
                s=s+(int)ch;}
            s= s%3;}
        else {s=0;}
        return s;
    }

    public boolean find(String value){
        int index=hachF(value);
        boolean test=false;
        Node currentNode=table.getNodes()[index];
        while (
                currentNode!= null) {
            if (currentNode.getValue().equals(value) ) {
                test=true;
                break;
            }
            currentNode=currentNode.getNext();
        }
        return test;
    }

    /* public boolean add(String value){
         int index=hachF(value);
        //Node currentNode = table.getTable()[index];
         boolean test=false;
         if(!(find(value))){
             test=true;
             if (table.getNodes()[index]!=null){
                 if(table.getNodes()[index].getNext()==null){
                     table.getNodes()[index].setNext(new Node(value,null));
                 }
                 else {
                     while(table.getNodes()[index].getNext()!=null){
                         table.getNodes()[index]=table.getNodes()[index].getNext();
                     }
                     table.getNodes()[index].setNext(new Node(value,null));
                     test=true;
                 }
                 }
             else table.getNodes()[index]=new Node(value,null);
         }
         return test;
     }
     */
   public boolean add(String value){
       int index=hachF(value);
       //Node currentNode = table.getTable()[index];
       boolean test=false;
       if(!(find(value))){
           test=true;
           if (table.getNodes()[index]!=null){
                   Node NewNode= new Node(value,table.getNodes()[index]);
                   table.getNodes()[index]=NewNode;
           }
           else table.getNodes()[index]=new Node(value,null);
       }
       return test;
   }

   public boolean remove(String value){
      /* boolean test=false;
       int index=hachF(value);
       Node currentNode=table.getNodes()[index];
       if (find(value)){
           if (currentNode.getNext()==null){
               table.getNodes()[index]=null;
               test=true;
           }
           else {
                 while (currentNode.getValue()!=value){
                     currentNode=currentNode.getNext();
                     table.getNodes()[index].getNext().setNext(currentNode.getNext());
                   }
                   table.getNodes()[index].setNext(currentNode.getNext());
                   test=true;
               }
           }
       return test;*/
       int index=hachF(value);
       if (table.getNodes()[index] == null) {
           return false; // Value doesn't exist
       }
       Node current = table.getNodes()[index];
       Node previous = table.getNodes()[index];
       if (current.getNext()==null){
           table.getNodes()[index]=null;
           return true;
       }
       while (current != null) {
           if (current.getValue().equals(value)) {
               if (previous != null) {
                   previous.next = current.getNext();
               } else {
                   table.getNodes()[index] = current.getNext();
               }
               return true; // Value removed successfully
           }
           previous = current;
           current = current.getNext();
       }

       return false; // Value doesn't exist
   }


  public void list(){
      Node nodeTab=null;
       Node currentNode=table.getNodes()[0];
       String s="";
       for (int i = 0; i < table.getNodes().length; i++) {
           s= "Node " + i + ":"+"\n";
           nodeTab=table.getNodes()[i];
           if (nodeTab!=null){
               currentNode=nodeTab;
               while (currentNode.getNext()!=null) {
                   s = s + currentNode.getValue()+" ";
                   currentNode = currentNode.getNext();
               }
               s=s+currentNode.getValue();
               System.out.println(s);
           }
       }
   }
    @Override
    public String toString() {
        return  table.toString() ;

    }



}
