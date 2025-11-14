import greenfoot.*;  
public class Catcher extends Actor
{
    /**
     * Act - do whatever the Catcher wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (Greenfoot.isKeyDown("left"))
        {
            setLocation(getX() - 4, getY());
        }
        if (Greenfoot.isKeyDown("right"))
        {
            setLocation(getX() + 4, getY());
        }
    }
}

