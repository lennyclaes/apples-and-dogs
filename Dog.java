import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class dog here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dog extends Creatures
{
    private int applesEaten;
    private boolean isHungry = true;
    private boolean isThirsty = false;
    private int steps = 0;
    private int health = 100;
    private boolean isAlive = true;

    /**
     * Act - do whatever the dog wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(isAlive) {
            move();
            eatApple();
            drink();
            updateHealth();
        }
    }

    private void updateHealth() {
        if(isHungry && steps % 600 == 0) {
            health -= 10;
        }

        if(isThirsty && steps % 500 == 0) {
            health -= 15;
        }
        
        if(health <= 0) {
            isAlive = false;
        }
    }

    public void move()
    {
        move(6);
        steps++;

        if (!isHungry && steps % 48 == 0) {
            isHungry = true;
        }

        if (!isThirsty && steps % 256 == 0) {
            isThirsty = true;
        }

        if(!isAtEdge()) {

            if(Greenfoot.getRandomNumber(100) <= 10) {
                turn(Greenfoot.getRandomNumber(90) - 45);
            }

        } else {
            turn(180);
            move(10);
        }
    }

    private void eatApple() {
        if(isHungry && !isThirsty) {
            Actor apple = getOneIntersectingObject(Apple.class);

            if(apple != null) {
                applesEaten++;
                getWorld().removeObject(apple);
                isHungry = false;
            }
        }
    }

    private void drink() {
        if(isThirsty && isAtRiver()) {
            isThirsty = false;
        }
    }

    private boolean isAtRiver() {
        boolean atRiver = false;
        Actor river = getOneIntersectingObject(River.class);

        if(river != null) {
            atRiver = true;
        }

        return atRiver;
    }

    public int getEaten() {
        return applesEaten;
    }

    public boolean getThirst() {
        return isThirsty;
    }

    public boolean getHunger() {
        return isHungry;
    }
    
    public boolean getLife() {
        return isAlive;
    }

}
