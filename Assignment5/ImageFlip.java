import acm.graphics.GImage;
import acm.program.*;

public class ImageFlip extends GraphicsProgram{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void run() {
		GImage milkMaid = new GImage("milkmaid.jpg");
		
		milkMaid = flipImage(milkMaid);
		
		add(milkMaid);
		
	}
	
	
	
	public GImage flipImage(GImage image) {
		int[][] flip = image.getPixelArray();
		int height = flip.length;
		int width = flip[0].length;
		int pixel2;
		int temp;
		for(int i = 0; i < height; i++) {
			for(int pixel1 = 0; pixel1 < width; pixel1++) {
				pixel2 = width - pixel1 - 1;
				temp = flip[i][pixel1];
				flip[i][pixel1] = flip[i][pixel2];
				flip[i][pixel2] = temp;
			}
		}
		
		return new GImage(flip);
	}
}


