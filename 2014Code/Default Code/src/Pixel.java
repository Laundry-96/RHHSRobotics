/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Austin
 */
public class Pixel {
    
   public enum Color {
    Red, Orange, Yellow, Green, Blue, Purple
}
    
    private int red;
    private int green;
    private int blue;
    
    public Pixel()
    {
        red = 0;
        green = 0;
        blue = 0;
    }
    
    public Pixel(int r, int g, int b)
    {
        red = r;
        green = g;
        blue = b;
    }
    
    public int getRed()
    {
        return red;
    }
    
    public int getGreen()
    {
        return green;
    }
    
    public int getBlue()
    {
        return blue;
    }
    
    public void setPixel(int r, int g, int b)
    {
        red = r;
        green = g;
        blue = b;
    }
    
    public Color getShade()
}
