import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import javax.sound.sampled.*;

class GammaTimer
{
    //Declarations
    private JFrame frame;
    private JButton setButton, stopButton;
    private JTextField inputHr, inputMin, inputSec, display;
    private JLabel inputMsg;
    private String time = "";
    private Timer t;
    private boolean alarmRinging = false;
    private Clip clip;

    GammaTimer()
    {
        init();
    }

    private void init()
    {
        //Initialisations
        frame = new JFrame("GammaTimer");
        setButton = new JButton("Set Timer");
        stopButton = new JButton("Stop Timer");
        inputHr = new JTextField("Hr");
        inputMin = new JTextField("Min");
        inputSec = new JTextField("Sec");
        display = new JTextField();
        inputMsg = new JLabel("Enter the time here:");

        //Setting up
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(400, 300);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        display.setEditable(false);
        display.setFont(new Font("Arial", Font.PLAIN, 125));
        display.setHorizontalAlignment(SwingConstants.CENTER);

        inputMsg.setFont(new Font("Arial", Font.PLAIN, 20));

        inputHr.setFont(new Font("Comic Sans", Font.PLAIN, 20));
        inputMin.setFont(new Font("Comic Sans", Font.PLAIN, 20));
        inputSec.setFont(new Font("Comic Sans", Font.PLAIN, 20));

        //Using setBounds()
        display.setBounds(10, 10, 370, 100);
        inputMsg.setBounds (10, 100, 400, 50);
        inputHr.setBounds (100, 150, 40, 30);
        inputMin.setBounds (150, 150, 40, 30);
        inputSec.setBounds (200, 150, 40, 30);
        setButton.setBounds (75, 200, 100, 30);
        stopButton.setBounds (220, 200, 100, 30);

        //Registering ActionListener
        setButton.addActionListener(new SetButtonListener());
        stopButton.addActionListener(new StopButtonListener());

        //Adding to frame
        frame.add(display);
        frame.add(inputMsg);
        frame.add(inputHr);
        frame.add(inputMin);
        frame.add(inputSec);
        frame.add(setButton);
        frame.add(stopButton);

        //Timer
        t = new Timer(1000, new TimerListener());
    }

    private void ringAlarm()
    {
        try{
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("sounds\\alarm.wav").getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            alarmRinging = true;
            stopButton.setText("Stop Alarm");
        }catch(Exception e) {
            System.out.println ("Error with playing sound.");
            e.printStackTrace();
        }
    }

    //Inner classes for event handling
    class SetButtonListener implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            time = inputHr.getText()+":"+inputMin.getText()+":"+inputSec.getText();

            if ( checkValidity(time) ) {
                display.setText(time);
                t.start();
            }
        }
        
        //The input time has to be greater than 0:0:0 otherwise there is no meaning in running the timer 
        boolean checkValidity (String time) {
            int hr = Integer.valueOf(time.substring(0, time.indexOf(":")));
            int min = Integer.valueOf(time.substring(time.indexOf(":") + 1, time.lastIndexOf(":")));
            int sec = Integer.valueOf(time.substring(time.lastIndexOf(":")+1));
            
            if (hr <0 || min < 0 || sec < 0) return false;
            if (hr == 0 && min == 0 && sec == 0) return false;
            
            //If the time passes the above checks then it's valid
            return true;
        }
    }

    class StopButtonListener implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            if (alarmRinging == false)
                t.stop();
            else
            {
                clip.stop();
                alarmRinging = false;
                stopButton.setText("Stop Timer");
            }
        }
    }

    class TimerListener implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            String currentTime = display.getText();
            int hr = Integer.valueOf(currentTime.substring(0, currentTime.indexOf(":")));
            int min = Integer.valueOf(currentTime.substring(currentTime.indexOf(":") + 1, currentTime.lastIndexOf(":")));
            int sec = Integer.valueOf(currentTime.substring(currentTime.lastIndexOf(":")+1));

            if (currentTime.equals("0:0:1"))
            {
                t.stop();
                ringAlarm();
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
                display.setFont(new Font("Arial", Font.PLAIN, 100));
            }

            //setting time
            display.setText(hr+":"+min+":"+sec);
        }
    }
}