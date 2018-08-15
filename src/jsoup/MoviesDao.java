package jsoup;
 
import java.sql.Connection;
import java.sql.Statement;


 
public class MoviesDao {
 
	private Util util;
	private Connection conn;
	private Statement st;
	public MoviesDao() throws Exception{
		util=new Util();
		conn=util.conn();
		st=conn.createStatement();
	}
	//将电影信息存入数据库
	public void insert(String title,String year,String country,String lan,String douban_link,String introduce,String main_actor,String download_url,String img_url ) throws Exception{
		String sql="INSERT INTO movies(title,year,country,lan,douban_link,introduce,main_actor,download_url,img_url) VALUES('"+title.replace("'", "")+"','"+year.replace("'", "")+"','"+country.replace("'", "")+"','"+lan.replace("'", "")+"','"+douban_link.replace("'", "")+"','"+introduce.replace("'", "")+"','"+main_actor.replace("'", "").replaceAll(" 　　　　", "")+"','"+download_url.replace("'", "")+"','"+img_url.replace("'", "")+"');";
		System.out.println(sql);
		st.executeUpdate(sql);
	}
}
