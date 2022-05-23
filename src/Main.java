public class Main {
    public static void main(String[] args) {

//        Spring s = new Spring();
//        double[] t = s.move(1.0, 0.1, 2.0, 2.0);
//        double[] t = s.move(1.0, 0.1, 2.0);
//        double[] t = s.move(0, 4.0, 0.2, 0.1, 2.0);
//        double[] t = s.move(0, 4.0, 0.2, 0.1, 2.0, 2.0);
//
//        for (int i = 0; i < t.length; i++)
//        {
//            System.out.println(t[i]);
//        }

        System.out.println(SpringArray.equivalentSpring("[[]{[][]}]").getK());
        System.out.println(SpringArray.equivalentSpring("[[]{[][]}]", new Spring[] {new Spring(1),new Spring(2),new Spring(3)}).getK());
        int[] bites = {1,0,1,0,0,1,0,0,1};
        Converter c = new Converter();
        c.convert(bites);

    }
}