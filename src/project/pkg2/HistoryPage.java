/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.pkg2;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class HistoryPage extends JFrame {

    JPanel panel;

    JLabel title;

    JButton backBtn, nextBtn, prevBtn;

    public HistoryPage(int page) {
        setTitle("Covid-19 Self Assessment History");
        setSize(432, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        panel = new JPanel();

        panel.setLayout(null);
        panel.setBackground(Color.decode("#04b3ad"));

        title = new JLabel("ASSESSMENT HISTORY");
        title.setBounds(60, 20, 300, 50);
        title.setFont(new Font(title.getFont().toString(), Font.BOLD, 25));
        title.setForeground(Color.WHITE);

        // File reader
        StorageFile fr = new StorageFile();
        List<String> history = fr.getHistory();

        int itemsPerPage = 10;

        int max = page * itemsPerPage;
        int min = max - itemsPerPage;
        int spacer = 0;
        boolean lastPage = false;

        for (int i = min; i < max; i++) {
            if (history.size() <= i) {
                lastPage = true;
                break;
            }
            spacer++;
            String[] split = history.get(i).split(":");

            System.out.println(split[0]);

            JButton btn = new JButton("  " + (i + 1) + ". " + split[0]);
            btn.setHorizontalAlignment(SwingConstants.LEFT);
            btn.setBounds(55, (spacer + 1) * 40, 300, 30);
            designBtn(btn, "#93E48A", Color.WHITE);
            moreInfoBtn(btn, history.get(i), page);

            panel.add(btn);
        }

        // Back Btn
        backBtn = new JButton("Back");
        backBtn.setBounds(55, 550, 300, 30);
        designBtn(backBtn, "#d9534f", Color.WHITE);
        backBtn(backBtn);

        // Prev Btn
        prevBtn = new JButton("Previous Page");
        prevBtn.setBounds(55, 490, 140, 30);
        designBtn(prevBtn, "#5cb85c", Color.WHITE);
        prevPage(prevBtn, page);

        // Next Btn
        nextBtn = new JButton("Next Page");
        nextBtn.setBounds(215, 490, 140, 30);
        designBtn(nextBtn, "#5cb85c", Color.WHITE);
        nextPage(nextBtn, page);

        panel.add(backBtn);
        panel.add(prevBtn);
        panel.add(nextBtn);

        if (lastPage) {
            nextBtn.setEnabled(false);
        }

        if (page <= 1) {
            prevBtn.setEnabled(false);
        }

        panel.add(title);

        add(panel);

        setVisible(true);
    }

    public void moreInfoBtn(JButton btn, String s, int page) {
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String[] split = s.split(":");

                String msg = "Full Name: " + split[0]
                        + "\nAge: " + split[1]
                        + "\nSymptoms: ";

                for (String ss : split[2].split("\\|")) {
                    msg += "\n   - " + ss;
                }

                msg += "\nExisting Conditions:";

                for (String ss : split[3].split("\\|")) {
                    msg += "\n   - " + ss;
                }

                msg += "\nEpidemiological History:";

                for (String ss : split[4].split("\\|")) {
                    msg += "\n   - " + ss;
                }

                msg += "\n\nClick 'Remove Data' to remove this data.";

                int dialog = JOptionPane.showOptionDialog(btn, msg, split[0] + " Info", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new String[]{"Remove Data", "Close"}, "default");

                if (dialog == JOptionPane.YES_OPTION) {
                    new StorageFile().deleteData(s, page);
                }

            }
        });
    }

    public void nextPage(JButton btn, int page) {
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new HistoryPage(page + 1);
                dispose();
            }
        });
    }

    public void prevPage(JButton btn, int page) {
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new HistoryPage(page - 1);
                dispose();
            }
        });
    }

    public void backBtn(JButton btn) {
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dispose();
                Project2.welcomePage.setVisible(true);
            }
        });
    }

    public void designBtn(JButton button, String bg, Color text) {
        button.setBorder(null);
        button.setFocusPainted(false);
        button.setBackground(Color.decode(bg));
        button.setForeground(text);
    }

    class StorageFile {

        List<String> history;

        int itemsPerPage = 10;

        public StorageFile() {
            history = new ArrayList<String>();

            try {
                BufferedReader br = new BufferedReader(new FileReader("storage.txt"));
                String line = br.readLine();

                while (line != null) {
                    history.add(line);
                    line = br.readLine();
                }
                
                br.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }

        public void deleteData(String s, int page) {
            try {
                File storage = new File("storage.txt");
                File temp = new File("temp.txt");

                BufferedReader br = new BufferedReader(new FileReader(storage));
                BufferedWriter bw = new BufferedWriter(new FileWriter(temp));

                String cl;

                while ((cl = br.readLine()) != null) {
                    String tl = cl.trim();

                    if (!tl.equals(s)) {
                        bw.write(cl + System.getProperty("line.separator"));
                    }
                }

                br.close();
                bw.close();

                if (storage.delete()) {
                    temp.renameTo(storage);
                }
                else {
                    JOptionPane.showMessageDialog(panel, "Error: Could not delete the data.");
                }

                dispose();
                new HistoryPage(page);

            } catch (IOException e) {
                System.out.println(e);
            }
        }

        public List<String> getHistory() {
            return history;
        }

    }

}
