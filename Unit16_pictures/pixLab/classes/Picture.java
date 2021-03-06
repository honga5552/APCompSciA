import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

import org.omg.CORBA.Current;

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
    System.out.println("Anna Hong \nPeriod 1 \n4/24/18 \n computer # 33");
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
 
  
  
  //written by me - PICKING COLORS
 
  
  public void keepOnlyRed(){
	  Pixel[][] pixels = this.getPixels2D();
	  for (Pixel[] rowArray : pixels){
		  for(Pixel pixelObj : rowArray){
			  pixelObj.setBlue(0);
			  pixelObj.setGreen(0);
		  }
	  }
  }
  
  public void keepOnlyGreen(){
	  Pixel[][] pixels = this.getPixels2D();
	  for (Pixel[] rowArray : pixels){
		  for(Pixel pixelObj : rowArray){
			  pixelObj.setBlue(0);
			  pixelObj.setRed(0);
		  }
	  }
  }
  
  public void negate(){
	  Pixel[][] pixels = this.getPixels2D();
	  for (Pixel[] rowArray : pixels){
		  for(Pixel pixelObj : rowArray){
			  pixelObj.setRed(255 - pixelObj.getRed());
			  pixelObj.setGreen(255 - pixelObj.getBlue());
			  pixelObj.setBlue(255 - pixelObj.getBlue()); 
		  }
	  }
  }
  
  public void grayscale(){
	  Pixel[][] pixels = this.getPixels2D();
	  for (Pixel[] rowArray : pixels){
		  for (Pixel pixelObj : rowArray){
			  int average = (int) pixelObj.getAverage();
			  pixelObj.setRed(average);
			  pixelObj.setBlue(average);
			  pixelObj.setGreen(average);
		  }
	  }
  }
  
  public void fixUnderWater(){
	  Pixel[][] pixels = this.getPixels2D();
	  for (Pixel[] rowArray : pixels){
		  for (Pixel pixelObj : rowArray){
			  pixelObj.setGreen(pixelObj.getGreen() - 100);
			  pixelObj.setBlue(pixelObj.getBlue() - 100);
			  //pixelObj.setRed(pixelObj.getRed() + 10);
			 // pixelObj.setAlpha(pixelObj.getAlpha()  + 100);
		  }
	  }
  }
  
  
  //written by me - MIRRORING PICTURES
  public void mirrorVerticalRightToLeft(){
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel leftPixel = null;
	  Pixel rightPixel = null;
	  
	  int width = pixels[0].length;
	  for (int row = 0; row < pixels.length; row++){
		  for (int col = 0; col < width / 2; col++){
			  leftPixel = pixels[row][col];
			  rightPixel = pixels[row][width - 1 - col];
			  leftPixel.setColor(rightPixel.getColor());
		  }
	  }
  }
  
  public void mirrorHorizontal(){
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel topPixel = null; 
	  Pixel bottomPixel = null;
	  int height = pixels.length;
	  
	  for (int row = 0; row < height / 2; row++){
		  for (int col = 0; col < pixels[0].length; col++){
			  topPixel = pixels[row][col];
			  bottomPixel = pixels[height - 1 - row][col];
			  bottomPixel.setColor(topPixel.getColor());
		  }
	  }
  }
  
  public void mirrorHorizontalBotToTop(){
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel topPixel = null; 
	  Pixel bottomPixel = null;
	  int height = pixels.length;
	  
	  for (int row = 0; row < height / 2; row++){
		  for (int col = 0; col < pixels[0].length; col++){
			  topPixel = pixels[row][col];
			  bottomPixel = pixels[height - 1 - row][col];
			  topPixel.setColor(bottomPixel.getColor());
		  }
	  }
  }
  
  public void mirrorDiagonal(){
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel topRight = null;
	  Pixel bottomLeft = null;
	  int maxLength;
	  if (pixels[0].length < pixels.length){
		  maxLength = pixels[0].length;
	  }
	  else {
		  maxLength = pixels.length;
	  }
	  
	  for (int row = 0; row < maxLength; row++){
		  for (int col = row; col < maxLength; col++){
			  topRight = pixels[row][col];
			  bottomLeft = pixels[col][row];
			  topRight.setColor(bottomLeft.getColor());
		  }
	  }
	  
  }
  
  
  
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }
  
  //Written by me - MIRRORING PARTS OF PICTURES

  public void mirrorArms(){
	//col 112 - 207
	  //row 155 - 192
	 int mirrorPoint = 200;
	 Pixel leftPixel = null;
	 Pixel rightPixel = null;
	 Pixel[][] pixels = this.getPixels2D();
	 
	 for (int row = 163; row < mirrorPoint; row++){
		 for (int col = 98; col < 173; col++){
			 leftPixel = pixels[row][col];
			 rightPixel = pixels[mirrorPoint - row + mirrorPoint][col];
			 rightPixel.setColor(leftPixel.getColor());
		 }
	 }
	 
	 //col 240 - 293
	 for (int row = 163; row < mirrorPoint; row++){
		 for (int col = 240; col < 293; col++){
			 leftPixel = pixels[row][col];
			 rightPixel = pixels[mirrorPoint - row + mirrorPoint][col];
			 rightPixel.setColor(leftPixel.getColor());
		 }
	 }
  }
  
  public void mirrorGull(){
	//row  232 - 322
	//col 239 - 346
	  
	 Pixel leftPixel = null;
	 Pixel rightPixel = null;
	 Pixel[][] pixels = this.getPixels2D();
	 int mirrorPoint = 347;
	 
	 for (int row = 232; row < 323; row++){
		 for (int col = 239; col < mirrorPoint; col++){
			 leftPixel = pixels[row][mirrorPoint - col + mirrorPoint];
			 rightPixel = pixels[row][col];
			 
			 leftPixel.setColor(rightPixel.getColor());
		 }
	 }
  }
  
  public void edgeDetection2(int edgeDist){
	  Pixel leftPixel = null;
	  Pixel rightPixel = null;
	  Pixel topPixel = null;
	  Pixel botPixel = null;
	  Pixel[][] pixels = this.getPixels2D();
	  Color rightColor = null;
	  Color botColor = null;
	  for (int row = 0; row < pixels.length; row++)
	    {
	      for (int col = 0; col < pixels[0].length-1; col++)
	      {
	        leftPixel = pixels[row][col];
	        rightPixel = pixels[row][col+1];
	        rightColor = rightPixel.getColor();
	        if (leftPixel.colorDistance(rightColor) > 
	            edgeDist)
	          leftPixel.setColor(Color.BLACK);
	        else
	          leftPixel.setColor(Color.WHITE);
	      }
	    }
	  
	  for (int row = 0; row < pixels.length - 1; row++){
		  for (int col = 0; col < pixels[0].length; col++){
			  topPixel = pixels[row][col];
			  botPixel = pixels[row+1][col];
			  botColor = botPixel.getColor();
			  if (topPixel.colorDistance(botColor) > edgeDist){
				  topPixel.setColor(Color.BLACK);
			  }
			  else
				  topPixel.setColor(Color.WHITE);
		  }
	  }
	  
  }

  
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
        count++;
      }
    }
    System.out.println(count);
  }
 
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }
  
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }
  
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture beach = new Picture("beach.jpg");
  //  beach.explore();
    beach.zeroBlue();
   // beach.explore();
  }
  
  public void keepOnlyBlue(){
	  Pixel[][] pixels = this.getPixels2D();
	  for (Pixel[] rowArray : pixels){
		  for (Pixel pixelObj : rowArray){
			  pixelObj.setRed(0);
			  pixelObj.setGreen(0);
		  }
	  }
  }
  
  //LAB ASSESSMENT
  public void blur(int x, int y, int w, int h){
	  Pixel[][] pixels = this.getPixels2D();
	  for (int row = 0; row < pixels.length; row++){
		  for (int col = 0; col < pixels[0].length; col++){
			  if(row > 0 && row < h && col > 0 && col < w){
				pixels[row][col].setRed(blurHelperRed(row,col,pixels));
				pixels[row][col].setBlue(blurHelperBlue(row,col,pixels));
				pixels[row][col].setGreen(blurHelperGreen(row,col,pixels));
			  }
		  }
	  }
  }
  
  public int blurHelperRed(int row, int col, Pixel[][] pixels){
	  //gets average of surrounding pixel colors
	  double top = pixels[row - 1][col].getRed();
	  double bottom = pixels[row + 1][col].getRed();
	  double left = pixels[row][col-1].getRed();
	  double right = pixels[row][col+1].getRed();
	  return (int) (top + bottom + left + right) / 4;
	  
  }
  
  public int blurHelperBlue(int row, int col, Pixel[][] pixels){
	  //gets average of surrounding pixel colors
	  double top = pixels[row - 1][col].getBlue();
	  double bottom = pixels[row + 1][col].getBlue();
	  double left = pixels[row][col-1].getBlue();
	  double right = pixels[row][col+1].getBlue();
	  return (int) (top + bottom + left + right) / 4;
	  
  }
  
  public int blurHelperGreen(int row, int col, Pixel[][] pixels){
	  //gets average of surrounding pixel colors
	  double top = pixels[row - 1][col].getGreen();
	  double bottom = pixels[row + 1][col].getGreen();
	  double left = pixels[row][col-1].getGreen();
	  double right = pixels[row][col+1].getGreen();
	  return (int) (top + bottom + left + right) / 4;
	  
  }
  /** Hide a black and white message in the current
  * picture by changing the red to even and then
  * setting it to odd if the message pixel is black
  * @param messagePict the picture with a message
  */
  
  //if red % 5 == 2 AND blue % 5 == 2, pixel is BLACK
	public void encode(Picture messagePict) {
		Pixel[][] messagePixels = messagePict.getPixels2D();
		Pixel[][] currPixels = this.getPixels2D();
		Pixel currPixel = null;
		Pixel messagePixel = null;
		int count = 0;
		for (int row = 0; row < this.getHeight(); row++) {
			for (int col = 0; col < this.getWidth(); col++) {
				// if the current pixel red is odd make it even
				currPixel = currPixels[row][col];
				if (currPixel.getRed() % 5 == 2)
					currPixel.setRed(currPixel.getRed() - 1);
				/*if(currPixel.getBlue() % 5 == 2)
					currPixel.setBlue(currPixel.getBlue() - 1);*/
				
				messagePixel = messagePixels[row][col];
				if (messagePixel.colorDistance(Color.BLACK) < 50) {
					int redValue = currPixel.getRed();
					int blueValue = currPixel.getBlue();
					
					if (redValue % 5 == 0)
						currPixel.setRed(redValue + 2);
					else if(redValue % 5 == 1)
						currPixel.setRed(redValue + 1);
					else if (redValue %5 == 3)
						currPixel.setRed(redValue - 1);
					else if(redValue % 5 == 4)
						currPixel.setRed(redValue - 2);
					
					if (blueValue % 5 ==0)
						currPixel.setBlue(blueValue + 2);
					else if(blueValue % 5 == 1)
						currPixel.setBlue(blueValue + 1);
					else if(blueValue % 5 == 3)
						currPixel.setBlue(blueValue - 1);
					else if(blueValue % 5 == 4)
						currPixel.setBlue(blueValue - 2);
					
					count++;
				}
			}
		}
		System.out.println(count);
	}
  /**
  * Method to decode a message hidden in the
  * red value of the current picture
  * @return the picture with the hidden message
  */
	public Picture decode() {
		Pixel[][] pixels = this.getPixels2D();
		int height = this.getHeight();
		int width = this.getWidth();
		Pixel currPixel = null;

		Pixel messagePixel = null;
		Picture messagePicture = new Picture(height, width);
		Pixel[][] messagePixels = messagePicture.getPixels2D();
		int count = 0;
		for (int row = 0; row < this.getHeight(); row++) {
			for (int col = 0; col < this.getWidth(); col++) {
				currPixel = pixels[row][col];
				messagePixel = messagePixels[row][col];
				if (currPixel.getRed() % 5 == 2 && currPixel.getBlue() % 5 == 2) {
					messagePixel.setColor(Color.BLUE);
					count++;
				}
			}
		}
		System.out.println(count);
		return messagePicture;
	}

	//red and blue
	// % 5 == 2
  
} // this } is the end of class Picture, put all new methods before this
