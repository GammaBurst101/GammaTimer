import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class GammaTimer implements ActionListener
{
    //Declarations
    private JFrame frame;
    private JButton setButton, stopButton;
    private JTextField inputHr, inputMin, inputSec, display;
    private JLabel inputMsg;
    private String time = "";
    private Timer t;
    
    GammaTimer()
    {
        //Initialisations
        frame = new JFrame("GammaTimer");
        setButton = new JButton("Set Timer");
        stopButton = new JButton("Stop Timer");
        inputHr = new JTextField("Hr");
        inputMin = new JTextField("Min");
        inputSec = new JTextField("Sec");
        display = new JTextField();
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
        stopButton.addActionListener(this);
        
        //Adding to frame
        frame.add(display);
        frame.add(inputMsg);
        frame.add(inputHr);
        frame.add(inputMin);
        frame.add(inputSec);
        frame.add(setButton);
        frame.add(stopButton);
        
        //Timer
        t = new Timer(1000, this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==setButton)
        {
            time = inputHr.getText()+":"+inputMin.getText()+":"+inputSec.getText();
            display.setText(time);
            t.start();
        }
        else if (e.getSource()==stopButton)
            t.stop();
        else if (e.getSource()==t)
        {   
            String currentTime = display.getText();
            int hr = Integer.valueOf(currentTime.substring(0, currentTime.indexOf(":")));
            int min = Integer.valueOf(currentTime.substring(currentTime.indexOf(":") + 1, currentTime.lastIndexOf(":")));
            int sec = Integer.valueOf(currentTime.substring(currentTime.lastIndexOf(":")+1));
            
            if (currentTime.equals("0:0:0"))
            {
                t.stop();
                display.setText("Time's Up!");
            }
            
            //Decreasing the current time display
            if (sec != 0)
                sec --;
            else if (min != 0)
            {
                min --;
                sec = 59;
            }
            else 
            {
                hr--;
                min = sec = 59;
            }
            
            //setting time
            display.setText(hr+":"+min+":"+sec);
        }
    }
}