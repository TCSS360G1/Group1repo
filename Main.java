package examples;


public class Main {

    public static void main(String[] theArgs) {
        PropertyLauncher speaker = new PropertyLauncher();
        PropertyListener listener = new PropertyListener();
        
        speaker.addPropertyChangeListener(listener);
        speaker.fireChange();
    }

}
