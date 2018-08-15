package jsoup;
 
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
 
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
 
public class JsoupDemo {
 
	//获取第二级页面的所有链接地址并返回
	public List<String> link(String url) throws Exception{
		//由于获取的连接只是一部分,所以要拼接
		String link="http://www.bttiantangs.com";
		List <String > href=new ArrayList<>();
		Connection conn=Jsoup.connect(url).timeout(30000);
		Document doc=conn.header("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2").get(); 
		//System.out.println(doc.html());
		Elements ele=doc.select(".article >h2>a");
		for(Element element:ele){
			String a=element.attr("href");
			//拼接完整的连接
			String full=link+a;
			href.add(full);
		}
		return href;
	}
	
	
	//根据第二级页面的链接，将爬取到的电影集合返回
	
	public List<Movies> get(List<String> href) throws IOException {
		List<Movies> ls=new ArrayList<>();
		for(String h:href){
			Movies m=new Movies();
			Connection conn=Jsoup.connect(h).timeout(30000);
			Document doc;
			try {
				doc = conn.header("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2").get(); 
			} catch (IOException e) {
			    conn=Jsoup.connect("http://www.bttiantangs.com/movie/50680.html").timeout(30000);
			    doc = conn.get();
				e.printStackTrace();
			}
			Elements ele_title=doc.select(".article_container >h1");//电影标题
			m.setTitle(ele_title.get(0).text());
			Elements ele_p=doc.select("#post_content :nth-child(2)");//电影其他信息
			String p=ele_p.text();
			String sum[]=p.split("◎");
			for(String s:sum){
				//年代截取
				if(s.contains("年　　代")){
					m.setYear(s.substring(5, s.length()));
				}
				//国家截取
				if(s.contains("国　　家")){
					m.setContry(s.substring(5, s.length()));
				}
				//语言截取
				if(s.contains("语　　言")){
					m.setLan(s.substring(5, s.length()));
				}
				//豆瓣链接
				if(s.contains("豆瓣链接")){
					m.setDouban_link(s.substring(5, s.length()));
				}
				//主演
				if(s.contains("主　　演")){
					m.setMain_actor(s.substring(5, s.length()));
				}
				
				
			}
			
			//电影图片
			Elements ele_img=doc.select(".tpic-cont-s >img:nth-child(1)");
			//有的不存在电影图片
			if(!ele_img.isEmpty()){
				m.setImg_url(ele_img.attr("src"));
			}
			
			//电影简介
			Elements ele_introduce =doc.select(".minfos");
			//有的不存在电影简介
			if(!ele_introduce.isEmpty()){
				m.setIntroduce(ele_introduce.text());
			}
			//电影下载地址
			Elements ele_download=doc.select(".dlist >li >a:nth-child(2)");
			if(!ele_download.isEmpty()){
				m.setDownload_url(ele_download.get(0).attr("href"));
			}
			
			ls.add(m);
		}
		return ls;
	}
}
