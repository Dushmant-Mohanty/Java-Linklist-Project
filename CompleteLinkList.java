package DSAjava.Linklist;
import java.util.Scanner;
public class CompleteLinkList{
    public static void main(String[] args)
    {
    System.out.print("\t\t\t\t\t --:Welcome to link list:--\n\n\n\n");
    
// Creating link list to take input of data
     char ansforyn;
     char ansper;
     
     int i=0;
     Scanner sc= new Scanner(System.in);
     System.out.print("Do you want to create a link list...? (y/n)\n");
     ansforyn = sc.next().charAt(0);
     Node head = new Node();
     Node node = head;
     if(ansforyn=='y')
     {
       
     while(ansforyn=='y')
     {
     i++;
     System.out.print("Enter the data of the "+i+" node:\n");
     node.data = sc.nextInt();
     System.out.print("Do you want to create anothere node..? (y/n)\n"); 
     ansforyn = sc.next().charAt(0);
     if(ansforyn=='y')
     {
      node.link = new Node();
      node = node.link;
     }
    }
    }
    else{
        System.out.print("Got it..");
        return;
    }
// End of the creation of the link list 

// Start of actual service to the user 

    System.out.print("Link list has been created do you want to perform any operations...? (y/n)\n");
    ansforyn = sc.next().charAt(0);

    if(ansforyn=='y')
    {
    System.out.print("Enter NUMBER between 1-5 to perform any of the following action...\n1) To traverse the link list...\n2) Change the data of any node...\n3) Delete any node data...\n4) Insert node at a position...\n5) Do not want to perform any action...\n");
    ansper = sc.next().charAt(0);
    Perform obj =new Perform();
    obj.task(ansper,head,i);
    }
    else
    {
    Feedback obj = new Feedback();
    obj.feeds();
    return;
}
Feedback objok = new Feedback();
objok.feeds();     
}         
}
class Node
{
    int data;
    Node link;
}
class Traversal
{
    void traverse(Node head)
    {
        int i=0;
        Node trav = head;
        while(trav != null)
        {
            i++;
            System.out.print("Node "+i+" data :"+trav.data+"\n");
            trav = trav.link;
        }
    }
    void setdata(Node head, int data, int pos,int totalnode) {
        if (pos <= 0 || pos > totalnode) {
            System.out.println("Invalid position! Position must be between 1-"+totalnode+"\n");
            return;
        }
    
        Node trav = head;
        int currentPosition = 1; 
    
        
        while (trav != null && currentPosition < pos) {
            trav = trav.link;
            currentPosition++;
        }
    
        if (trav == null) {
            
            System.out.println("Position out of bounds! The list has fewer nodes.");
            return;
        }
    
       
        trav.data = data;
        System.out.println("Data updated successfully at position " + pos);
    
       
        System.out.println("The updated linked list is:");
        Traversal obj = new Traversal();
        obj.traverse(head);
    }
}
class Onlytraverse 
{
    Node traverse(Node head, int position) {
        Node trav = head;
        int count = 1;
        while (count < position && trav.link != null) {
            trav = trav.link;
            count++;
        }
        return trav;
    }
}

class Delete
      {
    Node delete(Node head, int totalnode) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Which node do you want to delete Enter the position no...? There are " + totalnode + " nodes:\n");
        int delnode = sc.nextInt();

        if (delnode > totalnode || delnode <= 0) {
            System.out.print("Invalid node number! Do you want to try again? (y/n): ");
            char answer = sc.next().charAt(0);
            if (answer == 'y') {
                return delete(head, totalnode);
            } else {
                System.out.print("Got it...");
                return head;
            }
        }

        if (delnode == 1) {
            // Deleting the first node
            System.out.println("Deleting the head node...");
            head = head.link;
            //Onlytraverse obj = new Onlytraverse();
            
            // return head;
        } else {
            // Deleting nodes other than the first
            Onlytraverse obj = new Onlytraverse();
            Node prevNode = obj.traverse(head, delnode - 1); // Get node before the one to delete
            prevNode.link = prevNode.link.link; // Skip the deleted node
        }

        System.out.println("Node deleted successfully.");
        return head; // Return updated head
    }
}
class Insertion
 {
    Node insert(Node head, int totalnode) {
        Scanner sc = new Scanner(System.in);
        System.out.print("At which position do you want to insert a node? There are " + totalnode + " nodes.\nEnter the position number:\n");
        int inspos = sc.nextInt();

        if (inspos > totalnode + 1 || inspos <= 0) {
            System.out.print("Invalid position! Do you want to try again? (y/n): ");
            char ans = sc.next().charAt(0);
            if (ans == 'y') {
                return insert(head, totalnode);
            } else {
                System.out.print("Got it...");
                return head;
            }
        }

        Node newNode = new Node();
        System.out.print("Enter the data for the new node:\n");
        newNode.data = sc.nextInt();

        if (inspos == 1) {
            // Insert at the beginning
            newNode.link = head;
            head = newNode;
        } else {
            // Insert at any other position
            Onlytraverse obj = new Onlytraverse();
            Node prevNode = obj.traverse(head, inspos - 1); // Get the node before the insertion point
            newNode.link = prevNode.link;
            prevNode.link = newNode;
        }

        System.out.println("Node inserted successfully.");
        Traversal obj = new Traversal();
        obj.traverse(head);
        return head; // Return updated head
    }
}
class Perform
{
void task(char ans,Node head,int i)
{
    Scanner sc = new Scanner(System.in);
    switch(ans)
    {
        case '1' : Traversal obj1 = new Traversal();
                   obj1.traverse(head);
                   Reperform obj40 = new Reperform();
                   obj40.retask(head,i);
                   break;

        case '2' :int pos,data;
                  System.out.print("Ther is "+i+" nodes\n");
                  System.out.print("Enter the position no you want to change the data:");
                  pos = sc.nextInt();
                  System.out.print("Enter the data you want to set :");
                  data = sc.nextInt();
                  Traversal obj2 = new Traversal();
                  obj2.setdata(head,data,pos,i);
                  Reperform obj41 = new Reperform();
                  obj41.retask(head,i);
                  break;

        case '3' :Delete obj = new Delete();
                 head = obj.delete(head,i);
                  i-=1;
                  Traversal objtra =new Traversal();
                  objtra.traverse(head);
                  Reperform obj42 = new Reperform();
                  obj42.retask(head,i);
                  break;  
        case '4' :Insertion inobj1 = new Insertion(); 
                  head = inobj1.insert(head,i);
                  i+=1;
                  Reperform obj43 = new Reperform();
                  obj43.retask(head,i);
                  break;
        case '5' :System.out.print("We hope you enjoy that...\n");
                  Feedback obj05 = new Feedback();
                  obj05.feeds();
    }  
}
}
class Reperform
{
    void retask(Node head,int i)
    {
        char ansper;
        //Node refhead = new Node();
        //Node refhead = head;
       // char funans = ans;
        int j=i;
        char answer;
        Scanner s = new Scanner(System.in);
        System.out.print("Do you want to perform other tasks (y/n):");
        answer = s.next().charAt(0);
        switch(answer)
        {
            case 'y' :System.out.print("Enter NUMBER between 1-5 to perform any of the following action...\n1) To traverse the link list...\n2) Change the data of any node...\n3) Delete any node data...\n4) Insert node at a position...\n5) Do not want to perform any action...\n");
                      ansper = s.next().charAt(0);
                      Perform obj = new Perform();
                      obj.task(ansper,head,j);
                      break;
            case 'n' :System.out.print("Got it...\n");
                      break;
            default : char AnsInelse;
                      System.out.println("Oops ! you didn't enter a valid answer do you want to give answer again..(y/n) ?");
                      Scanner sc= new Scanner(System.in);
                      AnsInelse = sc.next().charAt(0);
                      if (AnsInelse == 'y')
                     {
                      System.out.print("Enter NUMBER between 1-5 to perform any of the following action...\n1) To traverse the link list...\n2) Change the data of any node...\n3) Delete any node data...\n4) Insert node at a position...\n5) Do not want to perform any action...\n");
                      ansper = s.next().charAt(0);
                      Perform obj56 = new Perform();
                      obj56.task(ansper,head,j);
                     }
                     else
                     {
                     System.out.print("You lose the chance !");
                     }
        }
    
        return;
    }
 }
class Feedback
 {
     int feeds()
     {
     Scanner sc =new Scanner(System.in);
    int feed;
    System.out.print("Give a feedback...\nHow many star do you want to give us 1-5 :\n");
    feed = sc.nextInt();
    switch(feed)
    {
     case 1 :System.out.print("We will note your feedback");
             break;
     case 2 :System.out.print("Oops seems like you didn't enjoy it...\n We will work on it...!");
             break;
     case 3 :System.out.print("We will work for your more better experience...");
             break;
     case 4 :System.out.print("Thanks for your feedback...");
             break;
     case 5 :break;
     default :System.out.print("You didn't enter a valid number...");
    } 
    System.out.print("\n\t\t\t\tThanks for your feedback !!");
    return 0;
     }
    
 }
