package jsoup.dytt;

import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        MoviesDao moviesDao=new MoviesDao();
        for (int i=1;i<5;i++){
            //分页网址
            String url="https://www.dytt8.net/html/gndy/jddy/20160320/50523_"+i+".html";//爬取的地址
            if (i==1) {
                url="https://www.dytt8.net/html/gndy/jddy/20160320/50523.html";//爬取的地址
            }
            System.out.println("---------------第"+i+"页---------------");
            List<Movies> movies = JsoupDemo.getMovieLink(url);
            for (Movies m : movies) {
                System.out.println(m);
                moviesDao.insert(m.getTitle(),m.getYear(),m.getCountry(),m.getLan(),m.getDouban_link(),m.getDouban_score(),m.getIntroduce(),m.getMain_actor(),m.getDownload_url(),m.getImg_url());
            }
        }

    }
}
