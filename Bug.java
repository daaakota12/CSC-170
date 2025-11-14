import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Bug falls from the top.
 * If it hits the Catcher: score increases.
 * If it hits the Ground: miss increases.
 */
public class Bug extends Actor
{
    private int speed = 2;

    /**
     * Act - do whatever the Bug wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setLocation(getX(), getY() + speed);

        Catcher c = (Catcher) getOneIntersectingObject(Catcher.class);
        if (c != null)
        {
            GardenWorld world = (GardenWorld) getWorld();
            world.addScore(1);
            getWorld().removeObject(this);
            return;
        }

        Ground g = (Ground) getOneIntersectingObject(Ground.class);
        if (g != null)
        {
            GardenWorld world = (GardenWorld) getWorld();
            world.addMiss();
            getWorld().removeObject(this);
        }
    }
}

