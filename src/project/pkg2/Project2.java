package project.pkg2;

public class Project2 {

    public static WelcomePage welcomePage;
    
    public static void main(String[] args) {
        welcomePage = new WelcomePage();
        
        welcomePage.openPage();
        openPage();
    }
    
    public static void openPage() {
        System.out.println("Opening page...");
    }
    
}
