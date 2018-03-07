import javax.swing.*;
import java.awt.FlowLayout;

class Timer
{
    //Declarations
    private JFrame frame;
    private JPanel ctrl, input;
    private JButton b1, b2;
    private JTextField inputHr, inputMin, inputSec;
    private JLabel inputMsg;
    
    Timer()
    {
        //Initialisations
        frame = new JFrame("GammaTimer");
        ctrl = new JPanel();
        input = new JPanel();
        b1 = new JButton("Set Timer");
        b2 = new JButton("Stop Timer");
        inputHr = new JTextField("Hr");
        inputMin = new JTextField("Min");
        inputSec = new JTextField("Sec");
        inputMsg = new JLabel("Enter the time here");
        
        //Setting up
        frame.setVisible(true);
        frame.setSize(450, 450);
        frame.setLayout(new FlowLayout());
        b1.setSize(50, 10);
        b2.setSize(50, 10);
        inputHr.setSize(2, 4);
        inputMin.setSize(2, 4);
        inputSec.setSize(2, 4);
        
        //Adding to panels
        ctrl.add(b1);
        ctrl.add(b2);
        input.add(inputHr);
        input.add(inputMin);
        input.add(inputSec);
        input.add(inputMsg);
        
        //panel config
        input.setBounds(10, 10, 200, 200);
        ctrl.setBounds(300, 20, 300, 50);
        
        //Adding to frame
        frame.add(input);
        frame.add(ctrl);
    }
}