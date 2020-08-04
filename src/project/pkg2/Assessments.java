package project.pkg2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Assessments {

    private String name;

    private int age;

    private List<String> symptoms;
    private List<String> preExistingCondition;
    private List<String> epidemiologicalHistory;

    public Assessments(String name, int age) {
        this.name = name;
        this.age = age;

        symptoms = new ArrayList<>();
        preExistingCondition = new ArrayList<>();
        epidemiologicalHistory = new ArrayList<>();
    }

    public void showResult() {
        if (symptoms.size() >= 1 || preExistingCondition.size() >= 1 || epidemiologicalHistory.size() >= 1) {
            JOptionPane.showMessageDialog(null, "Contact your health care provider.\nYour answers indicate that you have a possible symptoms of COVID-19!");
        } else {
            JOptionPane.showMessageDialog(null, "Manage your symptoms at home.\nYou do not have any symptoms that indicates for COVID-19.");
        }
    }

    public void save() {
        String data = name + ":" + age + ":";

        if (getSymptoms().size() >= 1) {
            for (int i = 0; i < getSymptoms().size(); i++) {
                if ((1 + i) == getSymptoms().size()) {
                    data += getSymptoms().get(i);
                } else {
                    data += getSymptoms().get(i) + "|";
                }
            }
        } else {
            data += "None";
        }

        data += ":";

        if (getEpidemiologicalHistory().size() >= 1) {
            for (int i = 0; i < getEpidemiologicalHistory().size(); i++) {
                if ((1 + i) == getEpidemiologicalHistory().size()) {
                    data += getEpidemiologicalHistory().get(i);
                } else {
                    data += getEpidemiologicalHistory().get(i) + "|";
                }
            }
        } else {
            data += "None";
        }

        data += ":";

        if (getPreExistingCondition().size() >= 1) {
            for (int i = 0; i < getPreExistingCondition().size(); i++) {
                if ((1 + i) == getPreExistingCondition().size()) {
                    data += getPreExistingCondition().get(i);
                } else {
                    data += getPreExistingCondition().get(i) + "|";
                }
            }
        } else {
            data += "None";
        }

        try {
            FileWriter fw = new FileWriter("storage.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            pw.append(data);
            bw.newLine();

            pw.close();
            bw.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not save data!");
        }
    }

    private String getName() {
        return name;
    }

    private int getAge() {
        return age;
    }

    public List<String> getEpidemiologicalHistory() {
        return epidemiologicalHistory;
    }

    public List<String> getPreExistingCondition() {
        return preExistingCondition;
    }

    public List<String> getSymptoms() {
        return symptoms;
    }
}
