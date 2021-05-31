/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doublylinked.list;

import java.util.Scanner;

/**
 *
 * @author mena_
 */
public class DoublyLinkedList {
       
    class Node{  
        int data;  
        String item; 
        String Name; 
        Node previous;  
        Node next;  
  
        public Node(String item , String Name) {  
            this.item = item;
            this.Name  = Name;
        }  
    }
    Node head, tail = null; 
    public void addNode(String item , String Name) {  
         Node newNode = new Node(item , Name);  
         if(head == null) {  
            head = tail = newNode;  
            head.previous = null;  
            tail.next = null;  
        }  
        else {  
             tail.next = newNode;  
             newNode.previous = tail;  
             tail = newNode;  
             tail.next = null;  
        }  
    }
    public void searchname(){
         Scanner s =new Scanner(System.in);
         String name = s.nextLine();
        Node current = head;
        if(head == null) {  
            System.out.println("List is empty");  
            return;  
        }  
        while(current != null) {  
            if(current.Name.contains(name)) {  
                System.out.println("The Phone Number is "+current.item +" The Name is  "+ current.Name );  
            }  
            current = current.next;
        }      
    }  
        
     public void searchitem(){
         Scanner s =new Scanner(System.in);
         String phonenumber = s.nextLine();
         int i = 0;
        Node current = head;
        boolean flag = false;  
        if(head == null) {  
            System.out.println("List is empty");  
            return;  
        }  
        while(current != null) {  
            if(current.item.contains(phonenumber)) {  
                System.out.println("The Phone Number is "+current.item +" The Name is  "+ current.Name );  
            }  
            current = current.next;
        }
         
     }
     public void delete(){
         Scanner s =new Scanner(System.in);
         String name = s.nextLine();
         
         Node current = head;
         
          if(head == null) {  
            System.out.println("List is empty");  
            return;  
        }  
        while(current != null) {  
            if(current.Name.equals(name)) {
                
                if(current == head) {  
                head = current.next;  
            }   
            else if(current == tail) {  
                tail = tail.previous;  
            }  
            else {  
                current.previous.next = current.next;  
                current.next.previous = current.previous;  
            }  
            current = null; 
            break;
            }  
            current = current.next;
        }     
         
     }
     public void update(){
         Scanner s =new Scanner(System.in);
         String name = s.nextLine();
         Node current = head;
         if(head == null) {  
            System.out.println("List is empty");  
            return;  
        }  
        while(current != null) {  
            if(current.Name.equals(name)) {
               System.out.println("Current number is "+current.item +" Current name is "+ current.Name +")");
             System.out.println("Enter New Name");
             String n= s.nextLine();
             current.Name= n;
             System.out.println("Enter New Number");
             String i= s.nextLine();
             current.item= i; 
            break;
            }  
            current = current.next;
        }          
     }
    public void display() {  
        //Node current will point to head  
        Node current = head;  
        if(head == null) {  
            System.out.println("List is empty");  
            return;  
        }  
        System.out.println("Nodes of doubly linked list: ");  
        while(current != null) {  
            //Prints each node by incrementing the pointer.  
  
            System.out.print(current.item + " ");  
            current = current.next;  
        }  
    }  
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner c =new Scanner(System.in);
        DoublyLinkedList List = new DoublyLinkedList();  
         char ch;
        do{
             System.out.println("Doubly Linked List Operations");
                System.out.println("1. Insert");
                System.out.println("2. Search");
                System.out.println("3. Delete");
                System.out.println("4. Update");
                int choice;
                try{
                 choice = Integer.parseInt(c.nextLine());
                  switch (choice) {
                    case 1:
                        System.out.println("Enter Phone Then Contact to insert");
                        try{
                        int number = Integer.parseInt(c.nextLine());
                        String item = String.valueOf(number);
                        System.out.println("Enter Name Then Contact to insert");
                        String Name = c.nextLine();
                        List.addNode(item , Name);
                        }catch(Exception e){
                        System.out.println("Please Entre Vaild Namber");}
                        break;                        
                       
                    case 2:
                        System.out.println("1.Search With Name");
                        System.out.println("2.Search With Item");
                        System.out.println("3.Exit The Program");
                        int choice1=    Integer.parseInt(c.nextLine());
                        switch(choice1){
                            case 1: 
                                System.out.println("Enter Name");
                                List.searchname();
                                break;
                            case 2:
                                System.out.println("Enter Number");
                                List.searchitem();
                                break;
                            case 3:
                                System.exit(0);
                        }
                        break;
                         //*
                    case 3:
                        System.out.println("1.Search With Name You Want To Delete");
                        System.out.println("2.Exit The Program");
                        int choice2=    Integer.parseInt(c.nextLine());
                        switch(choice2){
                            case 1: 
                                System.out.println("Enter Name ");
                                List.delete();                               
                                break;
                            case 2:
                                System.exit(0);
                                break;
                        }
                        break;
                    case 4:
                        System.out.println("1.Enter Name You Want To Update");
                        System.out.println("2.Exit The Program");
                        int choice3 = Integer.parseInt(c.nextLine());
                        switch(choice3){
                            case 1: 
                                System.out.println("Enter Name");   
                                List.update();
                                break;
                            case 2:
                                System.exit(0);
                                break;
                        }                                
                        break;
                      //*/
                }
                }catch(Exception e){
                    System.out.println("Please Entre Vaild Namber");
                }               
                //List.display();
                System.out.println("Do you want to continue (Type y or n)\n");
                ch = c.nextLine().charAt(0);
        } 
                while (ch == 'Y'|| ch == 'y');
    }
    
}
