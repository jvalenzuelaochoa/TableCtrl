package ListTable;

import UsrCtrl.User;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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

    @Test
    public void populateFromCsv()
    {
        String csvFile = "C:\\Users\\jvalenzu\\Documents\\UT\\GradCourses\\AlgorithmicFoundations\\Project\\Sample\\TableCtrl\\src\\ListTable\\shortManualUsers.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        ListTable sampleTbl = new ListTable();

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] currentUsrAtt = line.split(cvsSplitBy);
                User newUser = new User(Integer.parseInt(currentUsrAtt[0]), currentUsrAtt[1], Integer.parseInt(currentUsrAtt[2]));
                sampleTbl.addUser(newUser);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        sampleTbl.displayByAttribute(User.userAttributes.ID);

        sampleTbl.displayByAttribute(User.userAttributes.NAME);

        sampleTbl.displayByAttribute(User.userAttributes.SALARY);

    }

}
