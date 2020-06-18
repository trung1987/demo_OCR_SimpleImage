/**
 * 
 */
package SST.demoOCR_readImage;

import java.awt.Image;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.asprise.ocr.Ocr;

/**
 * @author trto
 *
 */
public class demoReadImageFromLocal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File imageFile = new File(System.getProperty("user.dir") + "/data/cap.png");
		//File imageFile = new File(System.getProperty("user.dir") + "/data/cap2_fulltext.jpg");
		
		System.out.println(imageFile.getAbsolutePath());
		
		try {
			//BufferedImage image = ImageIO.read(new File(imageFile.getAbsolutePath()));   
			Image image = ImageIO.read(imageFile.getAbsoluteFile());
			Ocr.setUp();
			Ocr orc =  new Ocr();
			orc.startEngine(Ocr.LANGUAGE_ENG, Ocr.SPEED_SLOW);
			String imageText = orc.recognize((RenderedImage)image,Ocr.RECOGNIZE_TYPE_TEXT,Ocr.OUTPUT_FORMAT_PLAINTEXT,null);
			System.out.println("Text From Image : \n" + imageText);
			System.out.println("Length of total text : \n" + imageText.length());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
	}

}
