import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class Timer implements ActionListener
{
    //Declarations
    private JFrame frame;
    private JPanel ctrl, input, timer;
    private JButton setButton, stopButton;
    private JTextField inputHr, inputMin, inputSec, display;
    private JLabel inputMsg;
    private String time = "";
    
    Timer()
    {
        //Initialisations
        frame = new JFrame("GammaTimer");
        ctrl = new JPanel();
        input = new JPanel();
        timer = new JPanel();
        setButton = new JButton("Set Timer");
        stopButton = new JButton("Stop Timer");
        inputHr = new JTextField("Hr");
        inputMin = new JTextField("Min");
        inputSec = new JTextField("Sec");
        display = new JTextField(400);
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
        display.setEditable(false);
        
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
        
        //Adding to panels
        timer.add(display);
        ctrl.add(setButton);
        ctrl.add(stopButton);
        input.add(inputMsg);
        input.add(inputHr);
        input.add(inputMin);
        input.add(inputSec);
        
        //panel config
        timer.setBounds(10, 10, 410, 60);
        input.setBounds(10, 10, 200, 200);
        ctrl.setBounds(300, 20, 300, 50);
        
        //Adding to frame
        frame.add(timer);
        frame.add(input);
        frame.add(ctrl);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        time = inputHr.getText()+":"+inputMin.getText()+":"+inputSec.getText();
    }
}