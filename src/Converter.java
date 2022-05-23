import java.util.ArrayList;

public class Converter
{

    ArrayList<Spring> s = new ArrayList<>();
    public ArrayList<Spring> getSprings(int[] bites)
    {

        for (int i = 0; i < bites.length ; i++)
        {
            if (bites[i] == 1)
            {
                Spring newSpring = new Spring(Math.pow(2, i));
                s.add(newSpring);

            }
        }
        return s;
    }

    public double convertToBinary (ArrayList<Spring> s)
    {
        Spring spr = new Spring(0);
        for (Spring spring: s)
        {
            spr = spr.inSeries(spring);
            s.remove(spr);
        }
        return spr.getK();
    }

    public void convert (int[] bites)
    {
        ArrayList s = getSprings(bites);
        double k = convertToBinary(s);
        System.out.println(k);
    }

}
