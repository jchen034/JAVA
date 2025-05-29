
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import net.glxn.qrgen.QRCode;

public class DynamicQRCodeGenerator {
    private static final String OUTPUT_DIR = "QRCodeOutput";
    private static final int GENERATE_INTERVAL = 10000; // 10 seconds

    public static void main(String[] args) {
        createOutputDirectory();

        int counter = 1;
        while (true) {
            String qrCodeData = generateQRCodeData(counter);
            generateQRCodeImage(qrCodeData, counter);

            try {
                Thread.sleep(GENERATE_INTERVAL);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            counter++;
        }
    }

    private static void createOutputDirectory() {
        File outputDir = new File(OUTPUT_DIR);
        if (!outputDir.exists()) {
            outputDir.mkdir();
        }
    }

    private static String generateQRCodeData(int counter) {
        // Generate your dynamic QR code data here
        // For example, you can generate a unique code based on the current timestamp or any other criteria
        return "DynamicQRCode" + counter;
    }

    private static void generateQRCodeImage(String qrCodeData, int counter) {
        String filePath = OUTPUT_DIR + File.separator + "QRCode_" + counter + ".png";

        BufferedImage qrCodeImage = QRCode.from(qrCodeData)
                .withSize(250, 250)
                .to(ImageType.PNG)
                .withCharset("UTF-8")
                .stream()
                .toImage();

        try {
            ImageIO.write(qrCodeImage, "png", new File(filePath));
            System.out.println("Generated QR code: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
