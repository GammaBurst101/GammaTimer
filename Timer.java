import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class Timer implements ActionListener
{
    //Declarations
    private JFrame frame;
    private JPanel ctrl, input;
    private JButton setButton, stopButton;
    private JTextField inputHr, inputMin, inputSec;
    private JLabel inputMsg;
    private String time = "";
    
    Timer()
    {
        //Initialisations
        frame = new JFrame("GammaTimer");
        ctrl = new JPanel();
        input = new JPanel();
        setButton = new JButton("Set Timer");
        stopButton = new JButton("Stop Timer");
        inputHr = new JTextField("Hr");
        inputMin = new JTextField("Min");
        inputSec = new JTextField("Sec");
        inputMsg = new JLabel("Enter the time here");
        
        //Setting up
        frame.setVisible(true);
        frame.setSize(450, 450);
        frame.setLayout(new FlowLayout());
        setButton.setSize(50, 10);
        stopButton.setSize(50, 10);
        inputHr.setSize(2, 4);
        inputMin.setSize(2, 4);
        inputSec.setSize(2, 4);
        
        //Registering ActionListener
        setButton.addActionListener(this);
        
        //Adding to panels
        ctrl.add(setButton);
        ctrl.add(stopButton);
        input.add(inputMsg);
        input.add(inputHr);
        input.add(inputMin);
        input.add(inputSec);
        
        //panel config
        input.setBounds(10, 10, 200, 200);
        ctrl.setBounds(300, 20, 300, 50);
        
        //Adding to frame
        frame.add(input);
        frame.add(ctrl);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        time = inputHr.getText()+":"+inputMin.getText()+":"+inputSec.getText();
    }
}