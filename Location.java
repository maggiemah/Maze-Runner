/**
 * A class that creates an object that stores the x and y location.
 *
 * @author Maggie Mah
 * @version 03-09-20
 */

public class Location
{
    private int x;
    private int y;

    public Location(int xLocation, int yLocation) 
    {
        x = xLocation;
        y = yLocation;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }
}
