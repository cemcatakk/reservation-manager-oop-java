public class Main {
    public static void main(String[] args) {
        //String input = "input.txt";
        //String output = "output.txt";
        String input = args[0];
        String output = args[1];
        SystemManager systemManager = new SystemManager(input,output);
        systemManager.Run();
    }
}