import javax.swing.*;

class Timer
{
    //Declarations
    private JFrame frame;
    private JPanel ctrl;
    private JButton b1, b2;
    
    Timer()
    {
        //Initialisations
        frame = new JFrame("GammaTimer");
        ctrl = new JPanel();
        b1 = new JButton("Set Timer");
        b2 = new JButton("Stop Timer");
        
        //Setting up
        frame.setVisible(true);
        frame.setSize(450, 450);
        b1.setSize(50, 10);
        b2.setSize(50, 10);
        
        //Adding to frame
        ctrl.add(b1);
        ctrl.add(b2);
        frame.add(ctrl);
    }
}