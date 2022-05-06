public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Spring s = new Spring();
        double[] t = s.move(1,0.1,2,2);
        for (int i = 0; i < t.length; i++)
        {
            System.out.println(t[i]);
        }
    }
}