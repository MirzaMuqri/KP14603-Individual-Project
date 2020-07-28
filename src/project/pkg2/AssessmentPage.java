/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.pkg2;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.scene.control.CheckBox;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author MS1
 */
public class AssessmentPage extends JFrame {

    JPanel panel;

    JTextField name, age;

    JLabel nameLbl, ageLbl, symptomsLbl, existingcondLbl, historyLbl, preventionTips;

    JCheckBox fever, cough, fatigue, chestTightness, shortBreath,
            runnyNose, soreThroat, musclePain;

    JCheckBox highCholesterol, type2Diabetes, highBp, heart, stroke,
            chronicKidney;

    JCheckBox contactCovid, travelCountry, contactTravel;

    JButton submitBtn, backBtn;

    public AssessmentPage() {
        setTitle("Covid-19 Self Assessment Tool");
        setSize(760, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        panel = new JPanel();

        panel.setLayout(null);
        panel.setBackground(Color.decode("#04b3ad"));

        // Name
        nameLbl = new JLabel("Full Name");
        nameLbl.setBounds(10, 10, 250, 10);
        nameLbl.setForeground(Color.WHITE);

        name = new JTextField(32);
        name.setBounds(10, 30, 250, 30);

        // Age
        ageLbl = new JLabel("Age");
        ageLbl.setBounds(10, 70, 250, 30);
        ageLbl.setForeground(Color.WHITE);
        
        age = new JTextField(32);
        age.setBounds(10, 100, 250, 30);

        // Symptoms
        symptomsLbl = new JLabel("Do you have any of the following symptoms?");
        symptomsLbl.setBounds(10, 150, 250, 30);
        symptomsLbl.setForeground(Color.WHITE);
        
        fever = new JCheckBox("Fever");
        fever.setBounds(10, 180, 150, 30);

        cough = new JCheckBox("Cough");
        cough.setBounds(170, 180, 150, 30);

        fatigue = new JCheckBox("Fatigue");
        fatigue.setBounds(10, 220, 150, 30);

        chestTightness = new JCheckBox("Chest Tightness");
        chestTightness.setBounds(170, 220, 150, 30);

        shortBreath = new JCheckBox("Shortness of Breath");
        shortBreath.setBounds(10, 260, 150, 30);

        runnyNose = new JCheckBox("Runny Nose");
        runnyNose.setBounds(170, 260, 150, 30);

        soreThroat = new JCheckBox("Sore Throat");
        soreThroat.setBounds(10, 300, 150, 30);

        musclePain = new JCheckBox("Muscle Pain");
        musclePain.setBounds(170, 300, 150, 30);

        // Existing Condition
        existingcondLbl = new JLabel("Do you have the following existing conditions?");
        existingcondLbl.setBounds(10, 350, 300, 30);
        existingcondLbl.setForeground(Color.WHITE);
        
        highCholesterol = new JCheckBox("High Cholesterol");
        highCholesterol.setBounds(10, 380, 150, 30);

        type2Diabetes = new JCheckBox("Type 2 Diabetes");
        type2Diabetes.setBounds(170, 380, 150, 30);

        highBp = new JCheckBox("High Blood Pressure");
        highBp.setBounds(10, 420, 150, 30);

        heart = new JCheckBox("Heart Disease");
        heart.setBounds(170, 420, 150, 30);

        stroke = new JCheckBox("Stroke");
        stroke.setBounds(10, 460, 150, 30);

        chronicKidney = new JCheckBox("Chronic Kidney");
        chronicKidney.setBounds(170, 460, 150, 30);

        // Epidemiological history
        historyLbl = new JLabel("Do you have the following epidemiological history?");
        historyLbl.setBounds(10, 510, 300, 30);
        historyLbl.setForeground(Color.WHITE);
        
        contactCovid = new JCheckBox("Contact with COVID-19 confirmed patient.");
        contactCovid.setBounds(10, 540, 310, 30);

        travelCountry = new JCheckBox("Travel or residence in an epidemic area/country.");
        travelCountry.setBounds(10, 580, 310, 30);

        contactTravel = new JCheckBox("Contact with people who recently traveled.");
        contactTravel.setBounds(10, 620, 310, 30);

        // Prevention Tips
        preventionTips = new JLabel("<html>Prevention Tips:"
                + "<br>◦ Minimize outdoor activities. Avoid going to areas where COVID-19 is spreading and other crowded public places."
                + "<br><br>◦ Pay attention to personal protection and maintan hand hygiene. It is recommended to wear surgical masks or N95 masks when going out."
                + "<br><br>◦ Avoid touching surfaces in public places. Wash your hands with hand sanitizer or soap under running water, or use alcohol hand sanitizer. Cover your nose and mouth when sneezing or coughing."
                + "<br><br>◦ Actively measure your body temperature when you feel feverish. If there is a child in the family, feel the child's forehead twice a day and take the temperature of the child if necessary. If there are suspected symptoms, put on a mask and seek medical consultation nearby."
                + "<br><br><br> Disclaimer: This results is for reference only, and should not be relied upon as a basis for diagnosis and treatement. Please decide the next steps based on your own situation and follow the advise given by a doctor.</html>");
        preventionTips.setBounds(350, 10, 350, 390);
        preventionTips.setForeground(Color.WHITE);

        // Buttons
        submitBtn = new JButton("Submit Assessments");
        submitBtn.setBounds(350, 410, 160, 30);
        designBtn(submitBtn, "#5cb85c", Color.WHITE);
        onSubmit(submitBtn);

        backBtn = new JButton("Back");
        backBtn.setBounds(530, 410, 160, 30);
        designBtn(backBtn, "#d9534f", Color.WHITE);
        backBtn(backBtn);

        // Adding components to panel
        panel.add(nameLbl);
        panel.add(name);

        panel.add(ageLbl);
        panel.add(age);

        panel.add(symptomsLbl);
        panel.add(fever);
        panel.add(cough);
        panel.add(fatigue);
        panel.add(chestTightness);
        panel.add(shortBreath);
        panel.add(runnyNose);
        panel.add(soreThroat);
        panel.add(musclePain);

        panel.add(existingcondLbl);
        panel.add(highCholesterol);
        panel.add(type2Diabetes);
        panel.add(highBp);
        panel.add(heart);
        panel.add(stroke);
        panel.add(chronicKidney);

        panel.add(historyLbl);
        panel.add(contactCovid);
        panel.add(travelCountry);
        panel.add(contactTravel);

        panel.add(preventionTips);
        panel.add(submitBtn);
        panel.add(backBtn);
        
        for (Component c : panel.getComponents()) {
            if (c instanceof  JCheckBox) {
                c.setBackground(Color.decode("#37C5A6"));
                c.setForeground(Color.WHITE);
            }
        }

        add(panel);

        setVisible(true);
    }

    public void designBtn(JButton button, String bg, Color text) {
        button.setBorder(null);
        button.setFocusPainted(false);
        button.setBackground(Color.decode(bg));
        button.setForeground(text);
    }

    public void backBtn(JButton btn) {
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                Project2.welcomePage.setVisible(true);
            }
        });
    }

    public void onSubmit(JButton btn) {
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int userAge = 0;
                String fullName = "";
                
                if (name.getText().length() <= 0) {
                    JOptionPane.showMessageDialog(panel, "Please enter your full name.");
                    return;
                }
                else {
                    fullName = name.getText();
                }
                
                try {
                    userAge = Integer.parseInt(age.getText());
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(panel, "Please enter a valid age.");
                    return;
                }
                
                Assessments assessments = new Assessments(fullName, userAge);
                
                name.setText("");
                age.setText("");
                
                if (fever.isSelected()) {
                    assessments.getSymptoms().add("Fever");
                    fever.setSelected(false);
                }
                if (cough.isSelected()) {
                    assessments.getSymptoms().add("Cough");
                    cough.setSelected(false);
                }
                if (fatigue.isSelected()) {
                    assessments.getSymptoms().add("Fatigue");
                    fatigue.setSelected(false);
                }
                if (chestTightness.isSelected()) {
                    assessments.getSymptoms().add("Chest Tightness");
                    chestTightness.setSelected(false);
                }
                if (shortBreath.isSelected()) {
                    assessments.getSymptoms().add("Shortness of Breath");
                    shortBreath.setSelected(false);
                }
                if (runnyNose.isSelected()) {
                    assessments.getSymptoms().add("Runny Nose");
                    runnyNose.setSelected(false);
                }
                if (soreThroat.isSelected()) {
                    assessments.getSymptoms().add("Sore Throat");
                    soreThroat.setSelected(false);
                }
                if (musclePain.isSelected()) {
                    assessments.getSymptoms().add("Muscle Pain");
                    musclePain.setSelected(false);
                }
                
                if (highCholesterol.isSelected()) {
                    assessments.getPreExistingCondition().add("High Cholesterol");
                    highCholesterol.setSelected(false);
                }
                if (type2Diabetes.isSelected()) {
                    assessments.getPreExistingCondition().add("Type 2 Diabetes");
                    type2Diabetes.setSelected(false);
                }
                if (highBp.isSelected()) {
                    assessments.getPreExistingCondition().add("High Blood Pressure");
                    highBp.setSelected(false);
                }
                if (heart.isSelected()) {
                    assessments.getPreExistingCondition().add("Heart Disease");
                    heart.setSelected(false);
                }
                if (stroke.isSelected()) {
                    assessments.getPreExistingCondition().add("Stroke");
                    stroke.setSelected(false);
                }
                if (chronicKidney.isSelected()) {
                    assessments.getPreExistingCondition().add("Chronic Kidney");
                    chronicKidney.setSelected(false);
                }
                
                if (contactCovid.isSelected()) {
                    assessments.getEpidemiologicalHistory().add("Contact with COVID-19 confirmed patient.");
                    contactCovid.setSelected(false);
                }
                if (travelCountry.isSelected()) {
                    assessments.getEpidemiologicalHistory().add("Travel or residence in an epidemic area/country.");
                    travelCountry.setSelected(false);
                }
                if (contactTravel.isSelected()) {
                    assessments.getEpidemiologicalHistory().add("Contact with people who recently traveled.");
                    contactTravel.setSelected(false);
                }
                
                assessments.showResult();
                assessments.save();
            }
        });

    }

}
