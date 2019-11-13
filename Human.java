import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
* Write a description of class mens here.
* 
* @author (your name) 
* @version (a version number or a date)
*/
public class Human extends Creatures
{
    /**
     * Act - do whatever the mens wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        hongerstatus();
        move();
        if (honger != 0){
            eatFood();
        }
        if(honger == 3){
                getWorld().removeObject(this);
        }
        }
   
    private int honger = 0; //0=geen honger, 1=goesting, 2=honger, 3=dood
    private int tijd = 1;
    private void hongerstatus()
    {
        if (tijd%100 == 0){
            honger++;
        }
        tijd++;
    }
    
    public void eatFood()
    {
        Actor Appel = getOneIntersectingObject(Apple.class);
        if(Appel != null) {
            getWorld().removeObject(Appel);
            honger--;
        }
        
    }
    
    public void move()
    {
        move(1);
    }

}
