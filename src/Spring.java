import static java.lang.Math.*;

public class Spring
{
    private double k;

    public Spring()
    {
        setK(1.0);
    }

    public  Spring(double k)
    {
        setK(k);
    }

    public double getK()
    {
        return k;
    }

    private void setK(double k)
    {
        this.k = k;
    }

    public double[] move(double t, double dt, double x0)
    {
        int size = (int)(t/dt);
        double[] coordinates = new double[size+1];
        double omega = sqrt(k);
        int index = 0;

        for (double i = 0; i <= t ; i += dt)
        {
            double xi = (x0 * cos(omega*i));
            coordinates[index] = xi;
            index++;
        }

        return coordinates;

    }
    public double[] move(double t, double dt, double x0, double v0)
    {
        int size = (int)(t/dt);
        double[] coordinates = new double[size+1];
        double omega = sqrt(k);
        int index = 0;

        for (double i = 0; i <= t ; i += dt)
        {
            double xi = (x0 * cos(omega*i)) + (v0/omega * sin(omega*i));
            coordinates[index] = xi;
            index++;
        }

        return coordinates;

    }
    public double[] move(double t0, double t1, double dt, double x0, double v0)
    {
        int size = (int)((t1-t0)/dt);
        double[] coordinates = new double[size+1];
        double omega = sqrt(k);
        int index = 0;

        for (double t = t0; t <= t1 ; t += dt)
        {
            double xt = (x0 * cos(omega*t)) + (v0/omega * sin(omega*t));
            coordinates[index] = xt;
            index++;
        }

        return coordinates;
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
    public Spring inSeries(Spring that)
    {
        double res = this.getK() + that.getK();
        return new Spring(res);
    }
    public Spring inParallel(Spring that)
    {
        double res = 1.0 / (1.0 / this.getK() + 1.0 / that.getK());
        return  new Spring(res);
    }


}
