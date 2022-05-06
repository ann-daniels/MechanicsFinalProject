import java.util.ArrayList;

public class SpringArray
{
    public static Spring equivalentSpring(String springExpr)
    {
        if(springExpr.equalsIgnoreCase("[]"))
        {
            return new Spring();
        }

        if(springExpr.charAt(0) == '[')
        {
            return  equivalentSpringInParallel(springExpr.substring(1, springExpr.length() - 1));
        }

        return  equivalentSpringInSeries(springExpr.substring(1, springExpr.length() - 1));
    }

    private static Spring equivalentSpringInSeries(String springExpr) // {}
    {
//        if(springExpr.isEmpty() || springExpr.equalsIgnoreCase("{}"))
//        {
//            return new Spring();
//        }

        ArrayList<Spring> subsequences = new ArrayList<>();

        int currentIndex = 0;
        char current = springExpr.charAt(currentIndex);
        int j = 0;

        for (int i = 1; i < springExpr.length() ; i++)
        {

            if (current == '[')
            {
                if (springExpr.charAt(i) == ']')
                {
                    if(j == 0)
                    {
                        subsequences.add(equivalentSpringInParallel(springExpr.substring(currentIndex + 1,i)));
                        if(i < springExpr.length() - 1)
                        {
                            currentIndex = i + 1;
                            i++;
                            current = springExpr.charAt(currentIndex);
                        }
                    }
                    else
                    {
                        j--;
                    }

                }
                else if (springExpr.charAt(i) == '[')
                {
                    j++;
                }

            }
            else if (current == '{')
            {
                if (springExpr.charAt(i) == '}')
                {
                    if(j == 0)
                    {
                        subsequences.add(equivalentSpringInSeries(springExpr.substring(currentIndex + 1,i)));
                        if(i < springExpr.length() - 1)
                        {
                            currentIndex = i + 1;
                            i++;
                            current = springExpr.charAt(currentIndex);
                        }
                    }
                    else
                    {
                        j--;
                    }

                }
                else if (springExpr.charAt(i) == '{')
                {
                    j++;
                }

            }
        }

        Spring res = subsequences.get(0);

        for (int i = 1; i < subsequences.size() ; i++)
        {
            res = res.inSeries(subsequences.get(i));
        }

        return res;
    }

    private static Spring equivalentSpringInParallel(String springExpr) // []
    {
        if(springExpr.isEmpty() || springExpr.equalsIgnoreCase("[]"))
        {
            return new Spring();
        }
        ArrayList<Spring> subsequences = new ArrayList<Spring>();

        int currentIndex = 0;
        char current = springExpr.charAt(currentIndex);
        int j = 0;

        for (int i = 1; i < springExpr.length() ; i++)
        {

            if (current == '[')
            {
                if (springExpr.charAt(i) == ']')
                {
                    if(j == 0)
                    {
                        subsequences.add(equivalentSpringInParallel(springExpr.substring(currentIndex + 1,i)));
                        if(i < springExpr.length() - 1)
                        {
                            currentIndex = i + 1;
                            i++;
                            current = springExpr.charAt(currentIndex);
                        }
                    }
                    else
                    {
                        j--;
                    }

                }
                else if (springExpr.charAt(i) == '[')
                {
                    j++;
                }

            }
            else if (current == '{')
            {
                if (springExpr.charAt(i) == '}')
                {
                    if(j == 0)
                    {
                        subsequences.add(equivalentSpringInSeries(springExpr.substring(currentIndex + 1,i)));
                        if(i < springExpr.length() - 1)
                        {
                            currentIndex = i + 1;
                            i++;
                            current = springExpr.charAt(currentIndex);
                        }
                    }
                    else
                    {
                        j--;
                    }

                }
                else if (springExpr.charAt(i) == '{')
                {
                    j++;
                }

            }
        }

        Spring res = subsequences.get(0);

        for (int i = 1; i < subsequences.size() ; i++)
        {
            res = res.inParallel(subsequences.get(i));
        }

        return res;
    }
    public static Spring equivalentSpring(String springExpr, Spring[] springs)
    {
        int[] index = {0};

        if(springExpr.equalsIgnoreCase("[]"))
        {
            return springs[index[0]];
        }

        if(springExpr.charAt(0) == '[')
        {
            return  equivalentSpringInParallel(springExpr.substring(1, springExpr.length() - 1), springs, index);
        }

        return  equivalentSpringInSeries(springExpr.substring(1, springExpr.length() - 1), springs, index);
    }

    private static Spring equivalentSpringInSeries(String springExpr, Spring[] springs, int[] index) // {}
    {
//        if(springExpr.isEmpty() || springExpr.equalsIgnoreCase("{}"))
//        {
//            int tmp = index[0];
//            index[0]++;
//            return springs[tmp];
//        }

        ArrayList<Spring> subsequences = new ArrayList<>();

        int currentIndex = 0;
        char current = springExpr.charAt(currentIndex);
        int j = 0;

        for (int i = 1; i < springExpr.length() ; i++)
        {

            if (current == '[')
            {
                if (springExpr.charAt(i) == ']')
                {
                    if(j == 0)
                    {
                        subsequences.add(equivalentSpringInParallel(springExpr.substring(currentIndex + 1,i),springs,index));
                        if(i < springExpr.length() - 1)
                        {
                            currentIndex = i + 1;
                            i++;
                            current = springExpr.charAt(currentIndex);
                        }
                    }
                    else
                    {
                        j--;
                    }

                }
                else if (springExpr.charAt(i) == '[')
                {
                    j++;
                }

            }
            else if (current == '{')
            {
                if (springExpr.charAt(i) == '}')
                {
                    if(j == 0)
                    {
                        subsequences.add(equivalentSpringInSeries(springExpr.substring(currentIndex + 1,i),springs,index));
                        if(i < springExpr.length() - 1)
                        {
                            currentIndex = i + 1;
                            i++;
                            current = springExpr.charAt(currentIndex);
                        }
                    }
                    else
                    {
                        j--;
                    }

                }
                else if (springExpr.charAt(i) == '{')
                {
                    j++;
                }

            }
        }

        Spring res = subsequences.get(0);

        for (int i = 1; i < subsequences.size() ; i++)
        {
            res = res.inSeries(subsequences.get(i));
        }

        return res;
    }

    private static Spring equivalentSpringInParallel(String springExpr, Spring[] springs, int[] index) // []
    {
        if(springExpr.isEmpty() || springExpr.equalsIgnoreCase("[]"))
        {
            int tmp = index[0];
            index[0]++;
            return springs[tmp];

        }
        ArrayList<Spring> subsequences = new ArrayList<Spring>();

        int currentIndex = 0;
        char current = springExpr.charAt(currentIndex);
        int j = 0;

        for (int i = 1; i < springExpr.length() ; i++)
        {

            if (current == '[')
            {
                if (springExpr.charAt(i) == ']')
                {
                    if(j == 0)
                    {
                        subsequences.add(equivalentSpringInParallel(springExpr.substring(currentIndex + 1,i),springs,index));
                        if(i < springExpr.length() - 1)
                        {
                            currentIndex = i + 1;
                            i++;
                            current = springExpr.charAt(currentIndex);
                        }
                    }
                    else
                    {
                        j--;
                    }

                }
                else if (springExpr.charAt(i) == '[')
                {
                    j++;
                }

            }
            else if (current == '{')
            {
                if (springExpr.charAt(i) == '}')
                {
                    if(j == 0)
                    {
                        subsequences.add(equivalentSpringInSeries(springExpr.substring(currentIndex + 1,i), springs,index));
                        if(i < springExpr.length() - 1)
                        {
                            currentIndex = i + 1;
                            i++;
                            current = springExpr.charAt(currentIndex);
                        }
                    }
                    else
                    {
                        j--;
                    }

                }
                else if (springExpr.charAt(i) == '{')
                {
                    j++;
                }

            }
        }

        Spring res = subsequences.get(0);

        for (int i = 1; i < subsequences.size() ; i++)
        {
            res = res.inParallel(subsequences.get(i));
        }

        return res;
    }
}
