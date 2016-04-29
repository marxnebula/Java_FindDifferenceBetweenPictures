/**
 * Jordan Marx
 * 
 * Class for creating a method to find the modifications between two pictures
 * using if statements and colorDistance, and returning the results to a third picture.
 * 
 * The results returned to the third picture: 
 * 1.) if the pixels between the two pictures are modified, 
 * then the pixel is set to the unmodified picture(first loaded picture).
 * 2.) if the pixels are the same, then the pixel is set to black.
 */

import java.awt.Color;
 
public class FindModifications
{
  
  public static void main (String[] args) 
  {

    // Select unmodified picture from the computer
    String filename1;
    filename1 = FileChooser.pickAFile();
    System.out.println(filename1);
    
    // Select modified picture from the computer
    String filename2;
    filename2 = FileChooser.pickAFile();
    System.out.println(filename2);

    // Create the two pictures
    Picture pic1 = new Picture(filename1);
    Picture pic2 = new Picture(filename2);
   
    // Create the third picture using the method findModification
    Picture pic3 = findModification(pic1, pic2);
    
    // Show the modified picture
    pic3.show();
    
    // Save the modified picture
    String filename3;
    filename3 = FileChooser.pickAFile ();
    pic3.write (filename3);

  }
  
  
// Method for finding the modification of p2 using colorDistance
// and returns the result into another picture
public static Picture findModification (Picture p1, Picture p2)
  {
    int x;
    int y;
    int red, green, blue;
    Color c1, c2;
    Pixel pix1, pix2, pix3;
    
    Picture result = new Picture(p1.getWidth(), p1.getHeight());
    
    for ( x = 0 ; x < result.getWidth() ; ++x )
    {
      for ( y = 0 ; y < result.getHeight() ; ++y )
      {
        // Access the pixel at position (x,y)
        pix1 = p1.getPixel(x,y);
        
        // Access the color values at that pixel
        c1 = pix1.getColor();
        
        // Access the pixel at position (x,y)
        pix2 = p2.getPixel(x,y);
        
        // Access the color values at that pixel
        c2 = pix2.getColor();
        
        // Access the pixel at position (x,y)
        pix3 = result.getPixel(x,y);
        
        // Determine the final color value
        if (Pixel.colorDistance(c1, c2) > 10)
        {
          // Set the pixel to be the original pixel
          pix3.setColor(c1);
        }
        else
        {
          // Set the pixel to black
          pix3.setRed(0);
          pix3.setGreen(0);
          pix3.setBlue(0);
        }
      }
    }
    return result;
    }
    

}