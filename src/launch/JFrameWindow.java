package launch;

import javax.swing.*;

public class JFrameWindow extends JFrame {

    public JFrameWindow() {
        setTitle("Millstone Woods");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setContentPane(new GamePanel(1280, 720));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
