import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Dice extends PApplet {

Die gambler;
int colorOne;
int colorTwo;
int colorThree;
int totalDie;
public void setup()
{
	size(450,450);
	noLoop();
	
}
public void draw()
{
	background(0);
	colorOne = (int)(Math.random()*256);
	colorTwo = (int)(Math.random()*256);
	colorThree = (int)(Math.random()*256);
	for(int coordinateY = 50; coordinateY <= 350; coordinateY = coordinateY + 75)
	{
		for (int coordinateX = 50; coordinateX <= 350; coordinateX = coordinateX + 75)
		{
			gambler = new Die(coordinateX,coordinateY);
			gambler.roll();
			gambler.show();
		}
	}
	textAlign(CENTER);
	text("The total count is: " + totalDie, 225, 425);
	totalDie = 0;
}
public void mousePressed()
{
	redraw();
}
class Die //models one single dice cube
{
	int myX;
	int myY;
	int dieNumber;
	Die(int x, int y) //constructor
	{
		myX = x;
		myY = y;
	}
	public void roll()
	{
		dieNumber = (int)(Math.random() * 6) + 1;
		totalDie = totalDie + dieNumber;
	}
	public void show()
	{
		noStroke();
		fill(255);
		rect(myX,myY,50,50);
		if(dieNumber == 1)
		{
			fill(colorOne,colorTwo,colorThree);
			ellipse(myX + 25, myY + 25, 8, 8);
		}
		else if(dieNumber == 2)
		{
			fill(colorOne,colorTwo,colorThree);
			ellipse(myX + 15, myY + 25, 8, 8);
			ellipse(myX + 35, myY + 25, 8, 8);
		}
		else if(dieNumber == 3)
		{
			fill(colorOne,colorTwo,colorThree);
			ellipse(myX + 25, myY + 15, 8, 8);
			ellipse(myX + 15, myY + 35, 8, 8);
			ellipse(myX + 35, myY + 35, 8, 8);
		}
		else if (dieNumber == 4)
		{
			fill(colorOne,colorTwo,colorThree);
			ellipse(myX + 15, myY + 15, 8, 8);
			ellipse(myX + 35, myY + 15, 8, 8);
			ellipse(myX + 15, myY + 35, 8, 8);
			ellipse(myX + 35, myY + 35, 8, 8);
		}
		else if (dieNumber == 5)
		{
			fill(colorOne,colorTwo,colorThree);
			ellipse(myX + 15, myY + 15, 8, 8);
			ellipse(myX + 35, myY + 15, 8, 8);
			ellipse(myX + 15, myY + 35, 8, 8);
			ellipse(myX + 35, myY + 35, 8, 8);
			ellipse(myX + 25, myY + 25, 8, 8);
		}
		else if (dieNumber == 6)
		{
			fill(colorOne,colorTwo,colorThree);
			ellipse(myX + 15, myY + 10, 8, 8);
			ellipse(myX + 35, myY + 10, 8, 8);
			ellipse(myX + 15, myY + 25, 8, 8);
			ellipse(myX + 35, myY + 25, 8, 8);
			ellipse(myX + 15, myY + 40, 8, 8);
			ellipse(myX + 35, myY + 40, 8, 8);
		}
	}
}

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Dice" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
