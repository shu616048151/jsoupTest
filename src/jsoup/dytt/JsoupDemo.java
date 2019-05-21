package jsoup.dytt;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author shuxibing
 * @Date 2019/5/20 11:05
 * @Uint D9lab
 * @Description:
 */
public class JsoupDemo {
    public static List<Movies> getMovieLink(String url) throws IOException {
        List<String> hrefList=new ArrayList<String>();
        Connection conn= Jsoup.connect(url).timeout(30000);
        Document doc=conn.header("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2").get();
        Elements ele=doc.select("div#Zoom>span p>a");
        for(int k=0;k<ele.size();k++){
            Element element = ele.get(k);
            String href=element.attr("href");
            if (href!=null&&!"".equals(href)){
                 hrefList.add(href);
            }
            System.out.println("第"+k+"个  "+href);
        }
        return getMovies(hrefList);
    }
    public static List<Movies> getMovies(List<String> urlList) throws IOException {
        int num=0;
        List<Movies> moviesList=new ArrayList<Movies>();
        for (String urlLink : urlList) {
            Connection conn = Jsoup.connect(urlLink).timeout(30000);
            Document doc = conn.header("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2").get();
            Elements select = doc.select("tr>td>a[href]");
            Elements ele_p = doc.select("#Zoom>span");
            if (ele_p!=null&&ele_p.size()>0&&select!=null&&select.size()>0){
                Movies m = new Movies();
                String download_url = select.get(0).attr("href");
                m.setDownload_url(download_url);
                m.setDytt_url(urlLink);
                String p = ele_p.get(0).text();
                String sum[] = p.split("◎");
                for (String s : sum) {
                    //年代截取
                    if (s.contains("年　　代")) {
                        m.setYear(s.substring(5, s.length()));
                    }if (s.contains("译　　名")) {
                        m.setTitle(s.substring(5, s.length()));
                    }
                    //国家截取
                    if (s.contains("国　　家")||s.contains("产　　地")) {
                        m.setCountry(s.substring(5, s.length()));
                    }
                    //语言截取
                    if (s.contains("语　　言")) {
                        m.setLan(s.substring(5, s.length()));
                    }
                    //豆瓣链接
                    if (s.contains("豆瓣链接")) {
                        m.setDouban_link(s.substring(5, s.length()));
                    }
                    if (s.toUpperCase().contains("IMDB评分")&&s.length()>=10) {
                        //匹配豆瓣评分
                        Pattern pattern=Pattern.compile("\\d\\.\\d");
                        Matcher matcher = pattern.matcher(s);
                        if (matcher.find()){
                        String douban_score = matcher.group(0);
                        System.out.println(s+"匹配后得分:"+douban_score);
                        m.setDouban_score(Double.valueOf(douban_score));
                        }
                    }
                    //主演
                    if (s.contains("主　　演")) {
                        m.setMain_actor(s.substring(5, s.length()).trim());
                    }
                    if (s.contains("简　　介")) {
                        m.setIntroduce(s.substring(5, s.length()).trim());
                    }
                }
                num++;
                moviesList.add(m);
//                System.out.println(urlLink);
                System.out.println(num+"  "+m.toString());
            }
        }
        return moviesList;

    }
}
