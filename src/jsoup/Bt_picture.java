
package jsoup;
 
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
 
import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
 
public class Bt_picture {
 
	/**
	 * 
	 * @param ls 传递多来的有关电影的信息，包括所需要的图片地址，和电影名称
	 * @throws IOException 
	 */
	public void download(Movies e) throws IOException  {
		String url=e.getImg_url();
		//图片链接有的没
			if(url=="null"){
				url="https://ws2.sinaimg.cn/large/6c7edb3fly1fguvf22hznj215o0k67h5.jpg";
			}
			Connection conn=Jsoup.connect(url);
			Response rs=conn.ignoreContentType(true).timeout(3000).ignoreHttpErrors(true).execute();
			//存放图片的数组
			byte b[]=rs.bodyAsBytes();
			File file = new File("E:/BT_Movies_Picture",e.getTitle().replace(":", "")+".jpg");
	        if (!file.exists()) {
	            FileOutputStream raf = new FileOutputStream(file);
	            raf.write(b);
	            raf.close();
	        }
	}
}
