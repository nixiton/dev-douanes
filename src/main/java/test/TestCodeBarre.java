package test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.krysalis.barcode4j.impl.code128.Code128;
import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.impl.code39.Code39Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.krysalis.barcode4j.tools.UnitConv;

public class TestCodeBarre {

	/**
	 * @author kumara
	 *
	 */
	public static void main(String[] args) {
		try {
			// Create the barcode bean
			Code128Bean bean = new Code128Bean();

			final int dpi = 150;
			bean.setHeight(40d);

			// Configure the barcode generator
			bean.setModuleWidth(UnitConv.in2mm(1.0f / 40)); // makes the narrow
			//bean.setModuleWidth(UnitConv.in2mm(1.0f / 80));
			// bar
			// width exactly
			// one pixel
			bean.setFontSize(8);
			
			//bean.setWideFactor(3);
			bean.doQuietZone(false);

			// Open output file
			File outputFile = new File("out.jpg");
			OutputStream out = new FileOutputStream(outputFile);
			try {
				// Set up the canvas provider for monochrome JPEG output
				BitmapCanvasProvider canvas = new BitmapCanvasProvider(out, "image/jpeg", dpi,
						//BufferedImage.TYPE_BYTE_BINARY, false, 0);
						BufferedImage.TYPE_BYTE_GRAY, false, 0);

				// Generate the barcode
				bean.generateBarcode(canvas, "1EEE2XX2");

				// Signal end of generation
				canvas.finish();
			} finally {
				out.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
