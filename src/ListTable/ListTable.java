package ListTable;

import UsrCtrl.User;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.HashMap;

public class ListTable {
    HashMap<User.userAttributes, ListRow> head;
    HashMap<User.userAttributes, ListRow> tail;

    public ListTable()
    {
        head = new HashMap<User.userAttributes, ListRow>();
        tail = new HashMap<User.userAttributes, ListRow>();

        for(User.userAttributes att: User.userAttributes.values())
        {
            head.put(att, null);
            tail.put(att, null);
        }
    }

    //TODO: add error checking for non-existing attributes.
    public ListRow getHead(User.userAttributes att)
    {
        return head.get(att);
    }

    public void setHead(User.userAttributes att, ListRow newHead)
    {
        this.head.replace(att, newHead);
    }

    public ListRow getTail(User.userAttributes att)
    {
        return tail.get(att);
    }

    public void setTailById(User.userAttributes att, ListRow newTail)
    {
        this.tail.replace(att, newTail);
    }

    //TODO:experiment with different insertion methods
    public void addUser(User newUser)
    {
        //TODO: validate user input
        ListRow newRow = new ListRow();
        newRow.setUsr(newUser);

        if (head.get(User.userAttributes.ID)==null)
        {
            for(User.userAttributes att: User.userAttributes.values())
            {
                head.replace(att, newRow);
                tail.replace(att, newRow);
            }
        }
        else
        {
            for(User.userAttributes att: User.userAttributes.values())
            {
                tail.get(att).setNext(att,newRow);
                newRow.setPrevious(att, tail.get(att));
                tail.replace(att, newRow);
            }
        }

    }

    //TODO:add Remove method


    public void displayByAttribute(User.userAttributes att)
    {
        ListRow traverser = head.get(att);
        int noOfUsers = 0;
        while (traverser != null)
        {
            System.out.println(traverser.getUsr().toString());
            System.out.println("|");
            traverser = traverser.getNext(att);
            noOfUsers++;
        }
        System.out.println("null");
        System.out.println("\nTotal Number of Users: " + Integer.toString(noOfUsers)+"\n\n");
    }

    @Test
    public void quickTest()
    {
        ListTable sampleTbl = new ListTable();
        sampleTbl.displayByAttribute(User.userAttributes.ID);
        User sampleUsr = new User(1, "Javier", 3500);
        sampleTbl.addUser(sampleUsr);
        sampleTbl.displayByAttribute(User.userAttributes.ID);
    }
    @Test
    public void notSoQuickTest()
    {
        ListTable sampleTbl = new ListTable();
        sampleTbl.displayByAttribute(User.userAttributes.ID);
        sampleTbl.addUser( new User(1, "Jesus", 3500));
        sampleTbl.addUser( new User(2, "Pedro", 3500));
        sampleTbl.addUser( new User(6, "Ochoa", 3500));
        sampleTbl.addUser( new User(5, "Valenzuela", 3500));
        sampleTbl.addUser( new User(3, "Mentira", 3500));
        sampleTbl.addUser( new User(4, "Javier", 3500));
        sampleTbl.displayByAttribute(User.userAttributes.ID);
        sampleTbl.displayByAttribute(User.userAttributes.NAME);
        sampleTbl.displayByAttribute(User.userAttributes.SALARY);
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
