import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;


public class SimpleGUI extends JFrame {

    private static Room startRoom = new Room("Start room");

    private JButton lookAroundButton = new JButton("Look Around");
    private JButton giveUpButton = new JButton("Give up");
    private JButton lookForWayOutButton = new JButton("Look for a way out");
    private JButton lookForACompanyButton = new JButton("Look for company");
    private JButton quickSaveButton = new JButton("QuickSave");
    private JButton quickLoadButton = new JButton("QuickLoad");
    private JButton saveButton = new JButton("Save");
    private JButton loadButton = new JButton("Load");
    private JButton printMapButton = new JButton("Print Map");

    public String  getInfo(Room room){
         String info = "Player hp:" + (room.getPlayer().getHealth());
         return info;
    }


    static private JTextField input = new JTextField("", 5);
    static private JRadioButton radio1 = new JRadioButton("Select this");
    private JRadioButton radio2 = new JRadioButton("Select that");
    static private JCheckBox check = new JCheckBox("Check", false);

    public SimpleGUI() {
        super("Simple Example");
        this.setBounds(100,100,500,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(4,2,2,2));
        container.add(giveUpButton);
        container.add(lookAroundButton);
        container.add(lookForWayOutButton);
        container.add(lookForACompanyButton);
        container.add(quickSaveButton);
        container.add(quickLoadButton);
        container.add(saveButton);
        container.add(loadButton);
        container.add(printMapButton);


        /*ButtonGroup group = new ButtonGroup();
        group.add(radio1);
        group.add(radio2);
        container.add(radio1);

        radio1.setSelected(true);
        container.add(radio2);
        container.add(check);
        lookAroundButton.addActionListener(new ButtonEventListener());
        container.add(lookAroundButton);*/
    }

    static class ButtonEventListener implements ActionListener {

        public void actionPerformed(java.awt.event.ActionEvent e) {
            String message = "";
            message += "Button was pressed\n";
            message += "Text is " + input.getText() + "\n";
            message += (radio1.isSelected() ? "Radio #1" : "Radio #2")
                    + " is selected\n";
            message += "CheckBox is " + ((check.isSelected())
                    ? "checked" : "unchecked");
            JOptionPane.showMessageDialog(null,
                    message,
                    "Output",
                    JOptionPane.PLAIN_MESSAGE);
        }

        public static void main(String[] args) throws IOException, ClassNotFoundException {
            SimpleGUI app = new SimpleGUI();
            app.setVisible(true);

        }

    }

}
