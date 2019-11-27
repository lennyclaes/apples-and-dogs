import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class MyWorld here.
 * 
 * @author Lenny Claes
 * @version 0.0.1
 */
public class DeWereld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    private GreenfootImage map;
    
    private int timeCounter = 0;

    private int initDogs = 2;
    private int initTrees = 1;
    private int applesGiven = 0;    

    private River river;
    private ArrayList<Dog> dogs = new ArrayList();
    private ArrayList<Apple> apples = new ArrayList();
    private ArrayList<Tree> trees = new ArrayList();

    public DeWereld()
    {    
        super(1000, 600, 1);
        map = new GreenfootImage("background.png");
        setBackground(map);

        initWorld();
    }
    
    public void act() {
        timeCounter++;
        if (timeCounter % 50 == 0) {
            if (gameFinished()) {
                Greenfoot.stop();
            }
        }
    }

    /**
     * Adds a dog to the list and the world;
     * @param   dog    The dog to be added to the list
     */
    public void addDog() {
        Dog d = new Dog();
        int[] coords = getRandomCoords(40, 40, 40, 40);
        dogs.add(d);
        addObject(d, coords[0] - 63, coords[1]);
    }

    /**
     * Adds a apple to the list and the world;
     * @param   tree    The tree where the apple comes from
     */
    public void addApple(Tree tree) {
        Apple apple = new Apple();
        apples.add(apple);
        addObject(apple, (tree.getX() + Greenfoot.getRandomNumber(200) - 100), (tree.getY() + 100 - Greenfoot.getRandomNumber(50)));
    }
    
    private boolean gameFinished() {
        boolean finished = false;
        int applesEaten = 0;
        
        for(Dog dog : dogs) {
            applesEaten += dog.getEaten();
        }
        
        if(applesEaten == applesGiven) {
            finished = true;
        }
        
        return finished;
    }
    
    private int[] getRandomCoords(int xMinOffs, int xMaxOffs, int yMinOffs, int yMaxOffs) {
        int[] coords = {0, 0};    
        int randX = Greenfoot.getRandomNumber(getWidth() - 63);
        int randY = Greenfoot.getRandomNumber(getHeight());
        if (randX > getWidth() / 2) {
            randX -= xMinOffs;
        } else {
            randX += xMaxOffs;
        }
        
        if (randY > getHeight() / 2) {
            randY -= yMinOffs;
        } else {
            randY += yMaxOffs;
        }
        
        coords[0] = randX;
        coords[1] = randY;
        
        return coords;
    }

    private void initWorld() {
        river = new River();
        addObject(river, getWidth() - 63, 300);

        for(int i = 0; i < initDogs; i++) {
            Dog d = new Dog();
            dogs.add(d);
            int[] coords = getRandomCoords(40, 40, 40, 40);
            addObject(d, coords[0] - 63, coords[1]);
        }
        for(int i = 0; i < initTrees; i++) {
            int amountApples = Greenfoot.getRandomNumber(11) + 5;
            Tree t = new Tree(amountApples);
            applesGiven = amountApples;
            trees.add(t);
            int[] coords = getRandomCoords(150, 150, 100, 100);
            addObject(t, coords[0] - 63, coords[1]);
        }
    }
}
