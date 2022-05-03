/* this program generates a random password from a text file
   words from https://www.enchantedlearning.com/wordlist/compoundwords.shtml
   @author Alan Martinez-Lopez
 */

package pwgenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Pwgenerator implements ActionListener {

    private static JLabel userLabel;
    private static JTextField userText;
    private static JLabel passwordLabel;
    private static JPasswordField passwordText;
    private static JButton button;
    private static JLabel success;
    
    public static void main(String[] args) {

        // begin with sentence
        /* opening(); */

        // populate list
        File f = new File("passwords.txt");
        Scanner fileInput = null;
        try {
            fileInput = new Scanner(f);
        } catch (FileNotFoundException ERROR) {
            System.out.println("File Not Found Or No Passwords In File");
        }

        // create password list
        ArrayList<String> passwordList = new ArrayList<String>();

        // loop until end of file, uppercase first letter, add to list
        while (fileInput.hasNextLine()) {
            String password = fileInput.nextLine();
            if (password.charAt(0) <= 'z') {
                password = password.substring(0, 1).toUpperCase() + password.substring(1);
            }
            passwordList.add(password);
        }

        // print list
        /* for (int i = 0; i < passwordList.size(); i++) {
            System.out.println(passwordList.get(i));
        } */
        
        // print list size
        /* System.out.println(passwordList.size() + "\n"); */
        
        // generate random numbers, 0 - list size
        Random randGen = new Random();
        int upperbound = passwordList.size();
        int randNumList = randGen.nextInt(upperbound + 1);
        
        // show random number generated
        //System.out.println(randNum + 1);
        
        // confirm random number is generated within 0 - list size
        /* for (int j = 0; j < passwordList.size(); j++) { 
            int randNum = randGen.nextInt(upperbound + 1);
            System.out.println(randNum);
        } */
        
        ending();
        
        String passwordMatch = passwordList.get(randNumList);
        int randNumRange = randGen.nextInt(100); // or arg = randNumRange
        String randNumRangeFormatted;
        
        if (randNumRange <= 9) {
            randNumRangeFormatted = String.format("%02d", randNumRange);
        System.out.println(passwordMatch + randNumRangeFormatted);
        }
        else 
             System.out.println(passwordMatch + randNumRange);
           
        // beginning of GUI
        JPanel panel = new JPanel();
        JFrame frame = new JFrame("PWGen");
        frame.setSize(1200,750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        panel.setLayout(null);

        button = new JButton("Generate");
        button.setBounds(610, 500, 500, 150);
        button.addActionListener(new Pwgenerator());
        panel.add(button);
        
        frame.setVisible(true);
    
    } // end main

    public static void opening() {
        System.out.print("Here is the list of passwords \n");
    }
    
    public static void ending() {
        System.out.print("Your password is ");
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        JTextField userText;
        passwordText = new JPasswordField();
        passwordText.setBounds(610, 250, 500, 150);
        
    }
    
} // end class
