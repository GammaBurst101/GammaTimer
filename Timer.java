import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class Timer implements ActionListener
{
    //Declarations
    private JFrame frame;
    private JButton setButton, stopButton;
    private JTextField inputHr, inputMin, inputSec, display;
    private JLabel inputMsg;
    private String time = "";
    
    Timer()
    {
        //Initialisations
        frame = new JFrame("GammaTimer");
        setButton = new JButton("Set Timer");
        stopButton = new JButton("Stop Timer");
        inputHr = new JTextField("Hr");
        inputMin = new JTextField("Min");
        inputSec = new JTextField("Sec");
        display = new JTextField(100);
        inputMsg = new JLabel("Enter the time here");
        
        //Setting up
        frame.setVisible(true);
        frame.setSize(450, 450);
        frame.setLayout(null);
        display.setEditable(false);
        
        //Using setBounds()
        display.setBounds(10, 10, 400, 100);
        inputMsg.setBounds (10, 100, 400, 50);
        inputHr.setBounds (40, 150, 50, 15);
        inputMin.setBounds (100, 150, 50, 15);
        inputSec.setBounds (160, 150, 50, 15);
        setButton.setBounds (20, 200, 100, 30);
        stopButton.setBounds (200, 200, 100, 30);
        
        //Registering ActionListener
        setButton.addActionListener(this);
        stopButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                time = "";
            }
        }
        );
        
        //Adding to frame
        frame.add(display);
        frame.add(inputMsg);
        frame.add(inputHr);
        frame.add(inputMin);
        frame.add(inputSec);
        frame.add(setButton);
        frame.add(stopButton);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        time = inputHr.getText()+":"+inputMin.getText()+":"+inputSec.getText();
    }
}