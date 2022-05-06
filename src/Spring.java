import static java.lang.Math.*;

public class Spring
{
    private double k;

    public Spring()
    {
        k = 1;
    }

    public  Spring(double k)
    {
        this.k = k;
    }

    public double getK()
    {
        return k;
    }

    private void setK(double k)
    {
        this.k = k;
    }

    public double[] move(double t, double dt, double x0, double v0)
    {
        return move(0,t,dt,x0,v0,1.0);
    }

    public double[] move(double t, double dt, double x0)
    {
        return move(0,t,dt,x0,0,1.0);
    }

    public double[] move(double t0, double t1, double dt, double x0, double v0)
    {
       return move(t0,t1,dt,x0,v0,1.0);
    }

    public double[] move(double t0, double t1, double dt, double x0, double v0, double m)
    {
        int size = (int)((t1-t0)/dt);
        double[] coordinates = new double[size+1];
        double omega = sqrt(k/m);
        int index = 0;

        for (double t = t0; t <= t1 ; t += dt)
        {
            double xt = (x0 * cos(omega*t)) + (v0/omega * sin(omega*t));
            coordinates[index] = xt;
            index++;
        }

        return coordinates;
    }

}
