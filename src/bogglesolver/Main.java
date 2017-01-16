/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bogglesolver;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeSet;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author C13Zachary.Zeitlin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, UnsupportedLookAndFeelException {
        final Board boggle = new Board();

//    	final Object rowData[][] = { { "", "", "" }, { "", "", "" }, { "", "", "" } };
//    	final String columnNames[] = { "", "", "" };



////////////////set look and feel as windows, (less like java app) -- comment out to revert back to orig.
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
        } catch (UnsupportedLookAndFeelException e) {
            // TODO Auto-generated catch block
        }
////////////////////////////////////////////////////////////////////////////////////////


        final DefaultTableModel model = new DefaultTableModel(3, 3);
        final JTable table = new JTable(model);
        table.setRowHeight(90);
        table.setIntercellSpacing(new Dimension(20, 20));
        table.setDragEnabled(false);
        table.doLayout();


        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));


        JScrollPane scrollPane = new JScrollPane(table);


        JFrame frame = new JFrame("Boggle Solver");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 450);
        frame.setResizable(false);


//////////////////    JMENU
        JMenuBar displayMenuBar = new JMenuBar();
        frame.setJMenuBar(displayMenuBar);
        JMenu setBS = new JMenu("Set Board Size...");				//create file menu
        setBS.setMnemonic(KeyEvent.VK_F);							//set hotkey
        displayMenuBar.add(setBS);

///////////////////3x3 board
        JMenuItem three = new JMenuItem("3x3");		//create save subFile object
        three.setMnemonic(KeyEvent.VK_3);
        three.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, ActionEvent.CTRL_MASK));
        three.setToolTipText("Set Board as 3x3");

        three.addActionListener(new ActionListener()
        {

            public void actionPerformed(ActionEvent event) {//Action
                model.setColumnCount(3);
                model.setRowCount(3);
                table.setRowHeight(90);

                for (int r = 0; r < model.getRowCount(); r++) // clear table
                {
                    for (int c = 0; c < model.getColumnCount(); c++) {
                        model.setValueAt("", r, c);
                    }
                }
            }
        });
        setBS.add(three);						//add save to file menu

///////////////////////////////

///////////////////4x4 board
        JMenuItem four = new JMenuItem("4x4");		//create save subFile object
        four.setMnemonic(KeyEvent.VK_4);
        four.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4, ActionEvent.CTRL_MASK));
        four.setToolTipText("Set Board as 4x4");

        four.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                //Action
                model.setColumnCount(4);
                model.setRowCount(4);
                table.setRowHeight(68);
                for (int r = 0; r < model.getRowCount(); r++) // clear table
                {
                    for (int c = 0; c < model.getColumnCount(); c++) {
                        model.setValueAt("", r, c);
                    }
                }
            }
        });
        setBS.add(four);						//add save to file menu

///////////////////////////////

///////////////////5x5 board
        JMenuItem five = new JMenuItem("5x5");		//create save subFile object
        five.setMnemonic(KeyEvent.VK_5);
        five.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_5, ActionEvent.CTRL_MASK));
        five.setToolTipText("Set Board as 5x5");

        five.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                //Action
                model.setColumnCount(5);
                model.setRowCount(5);
                table.setRowHeight(54);

                for (int r = 0; r < model.getRowCount(); r++) // clear table
                {
                    for (int c = 0; c < model.getColumnCount(); c++) {
                        model.setValueAt("", r, c);
                    }
                }
            }
        });
        setBS.add(five);						//add save to file menu

///////////////////////////////

///////////////////6x6 board
        JMenuItem six = new JMenuItem("6x6");		//create save subFile object
        six.setMnemonic(KeyEvent.VK_6);
        six.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_6, ActionEvent.CTRL_MASK));
        six.setToolTipText("Set Board as 6x6");

        six.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                //Action
                model.setColumnCount(6);
                model.setRowCount(6);
                table.setRowHeight(45);

                for (int r = 0; r < model.getRowCount(); r++) // clear table
                {
                    for (int c = 0; c < model.getColumnCount(); c++) {
                        model.setValueAt("", r, c);
                    }
                }
            }
        });
        setBS.add(six);						//add save to file menu

///////////////////////////////

///////////////////7x7 board
        JMenuItem seven = new JMenuItem("7x7");		//create save subFile object
        seven.setMnemonic(KeyEvent.VK_7);
        seven.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_7, ActionEvent.CTRL_MASK));
        seven.setToolTipText("Set Board as 7x7");

        seven.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                //Action
                model.setColumnCount(7);
                model.setRowCount(7);
                table.setRowHeight(39);

                for (int r = 0; r < model.getRowCount(); r++) // clear table
                {
                    for (int c = 0; c < model.getColumnCount(); c++) {
                        model.setValueAt("", r, c);
                    }
                }
            }
        });
        setBS.add(seven);						//add save to file menu

///////////////////////////////


        /*
        table.getModel().addTableModelListener(new TableModelListener()
        {
        public void tableChanged(TableModelEvent e)
        {
        System.out.println(  table.getValueAt(  e.getFirstRow(),e.getColumn()  )  );
        }
        });
         */

        JButton b1 = new JButton("Solve");
        b1.setMnemonic(KeyEvent.VK_S);
        b1.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        //action
                        boggle.setBoard(table);
                        boggle.solve();
                        //boggle.display();
                    }
                });

        JButton b2 = new JButton("Clear");
        b2.setMnemonic(KeyEvent.VK_C);
        b2.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        //action
                        for (int r = 0; r < model.getRowCount(); r++) {
                            for (int c = 0; c < model.getColumnCount(); c++) {
                                model.setValueAt("", r, c);
                            }
                        }
                    }
                });


        JCheckBox dictType = new JCheckBox("Use Large Dictionary", false);
        dictType.addItemListener(
                new ItemListener() {

                    public void itemStateChanged(ItemEvent e) {
                        // Set "ignore" whenever box is checked or unchecked.
                        if (e.getStateChange() == ItemEvent.SELECTED) {
                            try {
                                boggle.initDictionaryLong();
                            } catch (IOException e2) {
                            }
                        } else {
                            try {
                                boggle.initDictionaryShort();
                            } catch (IOException e2) {
                            }
                        }
                    }
                });


        String[] comboChoices = {"Minimum Word Length...", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        JComboBox comboBox = new JComboBox(comboChoices);
        comboBox.setSelectedIndex(0);
        comboBox.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                JComboBox jcmbType = (JComboBox) e.getSource();
                String minLength = (String) jcmbType.getSelectedItem();
                if (minLength.equals("Minimum Word Length...")) {
                    boggle.setMinimumLength(0);
                } else {
                    boggle.setMinimumLength(Integer.parseInt(minLength));
                }

            }
        });









        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(comboBox);
        panel.add(b1);
        panel.add(b2);
        panel.add(dictType);
        frame.add(panel);
        frame.setVisible(true);


    }
}

class Board {

    String copyBoard[][];
    String board[][];
    String boardLine[];
    ArrayList<String> dictionary;
    ArrayList<String> successWords;
    ArrayList<String> solution;
    JTable myTable;
    int minimumLength = 1;

    public Board() throws IOException {
        dictionary = new ArrayList<String>();
        successWords = new ArrayList<String>();
        solution = new ArrayList<String>();
        initDictionaryShort();
    }

    public void display() // prints out board array
    {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board.length; c++) {
                System.out.print(board[r][c] + ",");
            }
            System.out.println();
        }
    }

    public void solve() {
        for (String word : dictionary) {
            if (firstTest(word)) {
                successWords.add(word);
            }
        }
        secondTest();

        //System.out.print(successWords);
        System.out.println();
        System.out.println();
        int newLine = 0;		//only used to space out answers

        TreeSet<String> tree = new TreeSet<String>();	// used to remove duplicates
        for (String a : solution) {
            tree.add(a);
        }

        int count = 0;
        for (String a : tree) {
            if (a.length() >= minimumLength) {
                count++;
                System.out.print(a + "\t\t");
                newLine++;
                if (newLine % 6 == 0) {
                    System.out.println();
                }
            }
        }

        System.out.println();
        System.out.print(count + " total words displayed.");
        System.out.println();
        System.out.println();
        solution.clear();
        successWords.clear();
    }

    public boolean firstTest(String word) // tests if each letter of word is found on the board
    {
        boolean containsWord = false;
        boolean containsLetter = false;
        boolean keepGoing = true;
        int numLetters = 0;
        for (int lcv = 0; lcv < word.length() && keepGoing; lcv++) {
            for (int lcv2 = 0; lcv2 < boardLine.length; lcv2++) {

                if (Character.toString(word.charAt(lcv)).equals(boardLine[lcv2]) && containsLetter == false) //if letter of the word is = letter of element of array
                {
                    containsLetter = true;
                    boardLine[lcv2] = "0";		// prevents duplicate letters from resulting "true"
                    numLetters++;			//checks in end if numLetters == number of letters in word.
                }
            }
            keepGoing = containsLetter; //continue if letter was found in board
            containsLetter = false;		// reset containsLetter

        }

        if (numLetters == word.length()) {
            resetBoardLine();
            return true;
        }

        resetBoardLine();
        return false;
    }

    public void secondTest() // tests if all letters connect on the board and then adds them.
    {
        int r2;
        int c2;

        for (String word2 : successWords) {
            boolean keepGoing2 = true;
            initCopyBoard();

            int k2 = 0;

            for (int r = 0; r < board.length; r++) {
                for (int c = 0; c < board[0].length; c++) {
                    r2 = r;
                    c2 = c;
                    k2 = 0;
                    keepGoing2 = true;
                    while (Character.toString(word2.charAt(0)).equals(board[r][c]) && Character.toString(word2.charAt(k2)).equals(copyBoard[r2][c2]) && keepGoing2) {
                        copyBoard[r2][c2] = "0";
                        if (k2 < word2.length() - 1) {
                            k2++;
                        } else {
                            solution.add(word2);
                            keepGoing2 = false;
                        }

                        if (Character.toString(word2.charAt(k2)).equals(getUp(r2, c2))) {
                            r2 -= 1;
                        } else if (Character.toString(word2.charAt(k2)).equals(getUpRight(r2, c2))) {
                            r2 -= 1;
                            c2 += 1;
                        } else if (Character.toString(word2.charAt(k2)).equals(getRight(r2, c2))) {
                            c2 += 1;
                        } else if (Character.toString(word2.charAt(k2)).equals(getDownRight(r2, c2))) {
                            r2 += 1;
                            c2 += 1;
                        } else if (Character.toString(word2.charAt(k2)).equals(getDown(r2, c2))) {
                            r2 += 1;
                        } else if (Character.toString(word2.charAt(k2)).equals(getDownLeft(r2, c2))) {
                            r2 += 1;
                            c2 -= 1;
                        } else if (Character.toString(word2.charAt(k2)).equals(getLeft(r2, c2))) {
                            c2 -= 1;
                        } else if (Character.toString(word2.charAt(k2)).equals(getUpLeft(r2, c2))) {
                            r2 -= 1;
                            c2 -= 1;
                        } else {
                            keepGoing2 = false;		//prevent double letters ("apple")
                            initCopyBoard();
                        }

                    } // end while
                } // end for c
            }
        }// end forEach


    }

    public void setBoard(JTable table) {
        myTable = table;
        board = new String[table.getRowCount()][table.getColumnCount()];
        boardLine = new String[table.getRowCount() * table.getColumnCount()];

        for (int r = 0; r < table.getRowCount(); r++) //copy board to string 2d array
        {
            for (int c = 0; c < table.getColumnCount(); c++) {
                board[r][c] = ((String) table.getValueAt(r, c)).toUpperCase();
            }
        }

        resetBoardLine();

    }

    public void resetBoardLine() {
        int ele = 0;
        for (int r = 0; r < myTable.getRowCount(); r++) //copy board to boardLine 1d array
        {
            for (int c = 0; c < myTable.getColumnCount(); c++) {
                boardLine[ele] = ((String) myTable.getValueAt(r, c)).toUpperCase();
                ele++;
            }
        }
    }

    public void initCopyBoard() // fills the copyBoard with table values
    {
        copyBoard = new String[myTable.getRowCount()][myTable.getColumnCount()];
        for (int r = 0; r < myTable.getRowCount(); r++) //copy board to string 2d array
        {
            for (int c = 0; c < myTable.getColumnCount(); c++) {
                copyBoard[r][c] = ((String) myTable.getValueAt(r, c)).toUpperCase();
            }
        }
    }

    public void initDictionaryShort() throws IOException //fills dictionary arraylist with valid words
    {
        dictionary.clear();
        BufferedReader dictSource = new BufferedReader(new FileReader("DictionaryShort.txt"));
        String entry;

        while ((entry = dictSource.readLine()) != null) // fill arraylist with valid words (String).
        {
            dictionary.add(entry.toUpperCase());
        }

        //System.out.print("Dictionary filled, press enter to continue...");

    }

    public void initDictionaryLong() throws IOException //fills dictionary arraylist with valid words
    {
        dictionary.clear();
        BufferedReader dictSource = new BufferedReader(new FileReader("DictionaryLong.txt"));
        String entry;

        while ((entry = dictSource.readLine()) != null) // fill arraylist with valid words (String).
        {
            dictionary.add(entry.toUpperCase());
        }

        //System.out.print("Dictionary filled, press enter to continue...");

    }

    public void setMinimumLength(int length) {
        minimumLength = length;
    }

    public boolean isAWord(String word) {
        return dictionary.contains(word);
    }

    public String getUp(int r, int c) {
        if (r > 0) {
            return board[r - 1][c];
        } else {
            return "0";
        }
    }

    public String getUpRight(int r, int c) {
        if (r > 0 && c < (board[0].length - 1)) {
            return board[r - 1][c + 1];
        } else {
            return "0";
        }
    }

    public String getRight(int r, int c) {
        if (c < (board[0].length - 1)) {
            return board[r][c + 1];
        } else {
            return "0";
        }
    }

    public String getDownRight(int r, int c) {
        if (r < (board.length - 1) && c < (board[0].length - 1)) {
            return board[r + 1][c + 1];
        } else {
            return "0";
        }
    }

    public String getDown(int r, int c) {
        if (r < (board.length - 1)) {
            return board[r + 1][c];
        } else {
            return "0";
        }
    }

    public String getDownLeft(int r, int c) {
        if (r < (board.length - 1) && c > 0) {
            return board[r + 1][c - 1];
        } else {
            return "0";
        }
    }

    public String getLeft(int r, int c) {
        if (c > 0) {
            return board[r][c - 1];
        } else {
            return "0";
        }
    }

    public String getUpLeft(int r, int c) {
        if (r > 0 && c > 0) {
            return board[r - 1][c - 1];
        } else {
            return "0";
        }
    }
}
