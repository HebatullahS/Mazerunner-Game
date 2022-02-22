package model;

import javax.swing.ImageIcon;



public class Imagefactory extends factory{
  
	public  ImageIcon getImage(int x ) {

		

		if(x==1) {

			return new ImageIcon("src/Images/grass.jpg");

		}
                else if(x==0) {

			return new ImageIcon("src/Images/flower1.jpg");

		}
                else
           return null;

		
        }
     
        
}