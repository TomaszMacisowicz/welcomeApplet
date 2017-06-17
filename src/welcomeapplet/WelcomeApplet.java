/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package welcomeapplet;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author MAC
 */
public class WelcomeApplet extends JApplet {

    public void init() {
        EventQueue.invokeLater(new Runnable() {

            public void run() {

                setLayout(new BorderLayout());

                JLabel label = new JLabel(getParameter("greeting"), SwingConstants.CENTER);
                label.setFont(new Font("serif", Font.BOLD, 18));
                add(label, BorderLayout.CENTER);
                JPanel panel = new JPanel();

                JButton tomButton = new JButton("Tomek");
                tomButton.addActionListener(makeAction("http://www.macisowicz.eu"));
                panel.add(tomButton);

                JButton mailButton = new JButton("send mail");
                mailButton.addActionListener(makeAction("mailto:tmacisowicz@gmial.com"));
                panel.add(mailButton);

                add(panel, BorderLayout.SOUTH);

            }
        });

    }

    private ActionListener makeAction(final String urlString) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                try {
                    getAppletContext().showDocument(new URL(urlString));
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        };
    }
}
