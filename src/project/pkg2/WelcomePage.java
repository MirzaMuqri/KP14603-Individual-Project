/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.pkg2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class WelcomePage extends JFrame {

    JPanel panel;
    JLabel title, disclaimer;
    JButton history, start, exit;

    ImageIcon logo;

    /*
    For reference: x coords, y coords, width, height
     */
    public WelcomePage() {
        setTitle("Covid-19 Self Assessment Tool");
        setSize(432, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        
        panel = new JPanel();

        panel.setLayout(null);
        panel.setBackground(Color.decode("#04b3ad"));
        
        title = new JLabel("<html><div style='text-align: center;'>COVID-19<br/>Self-Assessment Tool</div></html>", SwingConstants.CENTER);
        title.setFont(new Font(title.getFont().toString(), Font.BOLD, 14));
        title.setForeground(Color.WHITE);
        title.setBounds(80, 170, 250, 250);
        
        disclaimer = new JLabel("<html><div style='text-align: center;'>This program is not<br>affiliated with any government.</div></html>", SwingConstants.CENTER);
        disclaimer.setFont(new Font(title.getFont().toString(), Font.BOLD, 10));
        disclaimer.setForeground(Color.WHITE);
        disclaimer.setBounds(80, 500, 250, 250);
        
        start = new JButton("Start Assessment");
        start.setBounds(130, 340, 150, 30);
        designBtn(start, "#C4EF7B", Color.WHITE);
        startAssessmentBtn(start);

        history = new JButton("History");
        history.setBounds(130, 380, 150, 30);
        designBtn(history, "#93E48A", Color.WHITE);
        historyBtn(history);

        exit = new JButton("Exit");
        exit.setBounds(130, 420, 150, 30);
        designBtn(exit, "#37C5A6", Color.WHITE);
        exitBtn(exit);
        
        logo = new ImageIcon(getClass().getResource("image/logo.png"));

        // Adding images
        JLabel image = new JLabel(logo);
        image.setBounds(-10, 30, 432, 200);
        panel.add(image);

        // Adding all important items
        panel.add(title);
        panel.add(disclaimer);

        panel.add(start);
        panel.add(history);
        panel.add(exit);

        add(panel);

        setVisible(true);
    }

    public void designBtn(JButton button, String bg, Color text) {
        button.setBorder(null);
        button.setFocusPainted(false);
        button.setBackground(Color.decode(bg));
        button.setForeground(text);
    }
    
    public void startAssessmentBtn(JButton btn) {
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                new AssessmentPage();
            }
        });
    }
    
    public void exitBtn(JButton btn) {
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dispose();
            }
        });
    }
    
    public void historyBtn(JButton btn) {
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                new HistoryPage(1);
            }
        });
    }

}
