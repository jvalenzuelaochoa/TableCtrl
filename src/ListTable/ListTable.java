package ListTable;

import UsrCtrl.User;
import org.junit.Test;

import java.util.HashMap;

public class ListTable {
    private HashMap<User.userAttributes, ListColumn> head;
    private HashMap<User.userAttributes, ListColumn> tail;

    public ListTable()
    {
        head = new HashMap<User.userAttributes, ListColumn>();
        tail = new HashMap<User.userAttributes, ListColumn>();

        for(User.userAttributes att: User.userAttributes.values())
        {
            head.put(att, null);
            tail.put(att, null);
        }
    }

    //TODO: add error checking for non-existing attributes.
    public ListColumn getHead(User.userAttributes att)
    {
        return head.get(att);
    }

    public void setHead(User.userAttributes att, ListColumn newHead)
    {
        this.head.replace(att, newHead);
    }

    public ListColumn getTail(User.userAttributes att)
    {
        return tail.get(att);
    }

    public void setTailById(User.userAttributes att, ListColumn newTail)
    {
        this.tail.replace(att, newTail);
    }

    //TODO:experiment with different insertion methods
    public void addUser(User newUser)
    {
        //TODO: validate user input
        ListColumn newColumn = new ListColumn();
        newColumn.setUsr(newUser);

        if (head.get(User.userAttributes.ID)==null)
        {
            for(User.userAttributes att: User.userAttributes.values())
            {
                head.replace(att, newColumn);
                tail.replace(att, newColumn);
            }
        }
        else
        {
            for(User.userAttributes att: User.userAttributes.values())
            {
                tail.get(att).setNext(att,newColumn);
                tail.replace(att, newColumn);
            }
        }

    }

    //TODO:add Remove method


    public void displayByAttribute(User.userAttributes att)
    {
        ListColumn traverser = head.get(att);
        while (traverser != null)
        {
            System.out.println(traverser.getUsr().toString());
            System.out.println("|");
            traverser = traverser.getNext(att);
        }
        System.out.println("null");
    }

    @Test
    public void quicktest()
    {
        ListTable sampleTbl = new ListTable();
        sampleTbl.displayByAttribute(User.userAttributes.ID);
        User sampleUsr = new User(1, "Javier", 3500);
        sampleTbl.addUser(sampleUsr);
        sampleTbl.displayByAttribute(User.userAttributes.ID);
    }

    //TODO: Implement test to populate list from file.

}
