import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 Bug Catcher Game World.
 */
public class GardenWorld extends World
{
    private int score;
    private int misses;
    private int targetScore;
    private int maxMisses;
    private boolean gameOver;


    public GardenWorld()
    {    
        // 600x400 cells, 1x1 pixels each
        super(600, 400, 1); 

        score = 0;
        misses = 0;
        targetScore = 10;   
        maxMisses = 5;     
        gameOver = false;

        Catcher c = new Catcher();
        addObject(c, getWidth() / 2, getHeight() - 40);

        Ground g = new Ground();
        Bug firstBug = new Bug();
        int startX = Greenfoot.getRandomNumber(getWidth());
        addObject(firstBug, startX, 0);

        addObject(g, getWidth() / 2, getHeight() - 5);

        showText("Score: 0", 60, 20);
        showText("Misses: 0", 540, 20);
    }

    public void act()
    {
        if (!gameOver)
        {
            if (Greenfoot.getRandomNumber(60) == 0)
            {
                Bug b = new Bug();
                int x = Greenfoot.getRandomNumber(getWidth());
                addObject(b, x, 0);
            }

            showText("Score: " + score, 60, 20);
            showText("Misses: " + misses, 540, 20);

            if (score >= targetScore)
            {
                showText("You caught enough bugs! You win!", getWidth() / 2, getHeight() / 2);
                gameOver = true;
                Greenfoot.stop();
            }
            else if (misses >= maxMisses)
            {
                showText("Too many bugs escaped! You lose!", getWidth() / 2, getHeight() / 2);
                gameOver = true;
                Greenfoot.stop();
            }
        }
    }

    public void addScore(int points)
    {
        score = score + points;
    }
    
    public void addMiss()
    {
        misses = misses + 1;
    }
}

