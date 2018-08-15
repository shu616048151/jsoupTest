package jsoup;
import java.util.List;
 
public class Main {
 
	public static void main(String [] args) throws Exception{
		int k=0;                     //用来计数
		MoviesDao md=new MoviesDao();//用来对获取到的数据插入数据库
		Bt_picture p=new Bt_picture();//用来下载图片
		for(int i=2;i<50;i++){        //爬取地址的总数
			//String url="http://www.bttiantangs.com/list/dianying/index_"+i+".html";//爬取的地址
			String url="http://www.bttiantangs.com/list/dianying/index_"+i+".html";//爬取的地址
			JsoupDemo jsoup=new JsoupDemo();
			//获取某一页的所有电影详情页下的连接
			List<String> href=jsoup.link(url);
			//获取每一页的电影资料
			List <Movies> m=jsoup.get(href);
			for(Movies e:m){
				k++;
				//插入数据库
				//p.download(e);
				md.insert(e.getTitle(), e.getYear(), e.getContry(), e.getLan(), e.getDouban_link(), e.getIntroduce(), e.getMain_actor(), e.getDownload_url(), e.getImg_url());
				System.out.println(k);
			}
			
		}
		
	}
}
