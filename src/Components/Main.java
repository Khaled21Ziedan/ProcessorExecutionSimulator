package Components;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Simulator simulator = new Simulator(5,3,"C:\\Users\\khaled\\Desktop\\Atypon Tasks.txt");
        Thread simulaterThread = new Thread(simulator);
        simulaterThread.start();
    }
}
