import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class tree here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tree extends Objects
{

    private int spawnApples;
    private int applesSpawned = 0;

    public Tree(int apples) {
        spawnApples = apples;
    }

    /**
     * Act - do whatever the tree wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        spawnApple();
    }  

    private void spawnApple() {
        if(applesSpawned != spawnApples) {
            int chance = Greenfoot.getRandomNumber(100);

            if (chance <= 5) {
                ((DeWereld)getWorld()).addApple(this);
                applesSpawned++;
            }
        }
    }
}
