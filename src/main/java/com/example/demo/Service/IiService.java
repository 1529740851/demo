package com.example.demo.Service;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Dao.I2Mapper;
import com.example.demo.Dao.IiMapper;
import com.example.demo.entity.Ii;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

@Service
public class IiService {

	
	@Autowired
private IiMapper a;	
	
	@Autowired

private I2Mapper a1;	
	
	public List<Ii> Select(){
			return a.Select();
					
	}
	@Transactional
	public void insert(Ii i){
		a.insert(i);
	}
	public void delete(String id){
		a.delete(id);
		//a.delete(id);
	}
	
	public Ii Select2(){
		
		return a1.select2("12");
				
	}
	public  void qrcode(HttpServletResponse response,String xiaoqu) throws WriterException, IOException{
		
		response.setContentType("application/octet-stream;charset=UTF-8");
		response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("二维码.png", "UTF-8"));
		Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
		 hints.put(EncodeHintType.MARGIN, 0);
		
		BitMatrix bitMatrix = new QRCodeWriter().encode("www.baidu.com",BarcodeFormat.QR_CODE, 300, 640,hints);

		int width = bitMatrix.getWidth();
	
		int height = bitMatrix.getHeight();
		BufferedImage image = new BufferedImage(width, height,BufferedImage.TYPE_INT_ARGB);
		for (int x = 0; x < width; x++) {
		     for (int y = 0; y < height; y++) {
		           image.setRGB(x, y, bitMatrix.get(x, y) == true ? 
		           Color.BLACK.getRGB():Color.WHITE.getRGB());
		    }
		}
		   Graphics g = image.createGraphics();
		   int x=(int)(width/2-0.90*g.getFontMetrics().stringWidth(xiaoqu)/2); 
		   System.out.println(g.getFontMetrics());
		   System.out.println(g.getFontMetrics().stringWidth(xiaoqu));
		   System.out.println(g.getFontMetrics().stringWidth(xiaoqu)/2);
		   System.out.println(x);
		   g.setColor( Color.black);
           g.setFont(new Font(null, 1, 18));
           g.drawString("自助扫分", x, 240);
           g.setFont(new Font(null, 1, 18));
           g.drawString("阳春花园", x, 20);
           g.dispose();
           try {
      
           	ImageIO.write(image, "png", response.getOutputStream());
           	
			} catch (Exception e) {
			System.out.println(e);
			}
		/*ImageIO.write(image,"png", new File("C:\\二维码.png"));
		pressText("杨春花园", "C:\\二维码.png", 1, Color.black, 18,  65,  20, response.getOutputStream() ) ;*/
	}
	
	public void pressText(String pressText,  String targetImg, int fontStyle, Color color, int fontSize, int startX, int startY, OutputStream os) {
        try {
            File file = new File(targetImg);
            Image src = ImageIO.read(file);
             int imageW = src.getWidth(null);
             int imageH = src.getHeight(null);
             BufferedImage image = new BufferedImage(imageW, imageH, BufferedImage.TYPE_INT_RGB);
            Graphics g = image.createGraphics();
            g.drawImage(src, 0, 0, imageW, imageH, null);
            g.setColor(color);
            g.setFont(new Font(null, fontStyle, fontSize));
            g.drawString("自助扫分", 65, 240);
            g.setFont(new Font(null, fontStyle, fontSize));
            g.drawString(pressText, startX, startY);
            g.dispose();
            try {
            	if(os!=null){
            	ImageIO.write(image, "png", os);
            	}
			} catch (Exception e) {
				// TODO: handle exception
			}
          //  ImageIO.write(image,"png", new File("D:\\二维码.png"));
          /*  FileOutputStream out = new FileOutputStream(newImg);
            ImageIO.write(image, "JPEG", out);*/
       } catch (Exception e) {
           System.out.println(e);
        }
   }
}
