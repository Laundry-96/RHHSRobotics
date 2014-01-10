/*
 * Made by Austin DeLauney on 1/5/2014
 * This class is supposed to do the camera stuff
 */

 import edu.wpi.first.wpilibj.camera.*; 

public class Camera 
{
    AxisCamera aCam;
    Pixel[] pixels;
    ColorImage cI;
    
    public Camera(String cam)
    {
        aCam = new AxisCamera(cam);
        pixels = new Pixel[aCam.getResolution()];
        cI = new ColorImage();
    }
    
    /**
     * Take a photo, do something 
     */
    public void takePhoto()
    {
        ColorImage cImage;
        cImage = aCam.getImage();
        
    }
    
    /**
     * Analyze the photo, check each pixel color and tell where the robot to point
     */
    public void analyzePhoto()
    {
        for(Pixel p : pixels)
        {
            if(p)
        }
    }
}
