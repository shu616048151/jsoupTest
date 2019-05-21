package jsoup.dytt;
 
import java.sql.Connection;
import java.sql.Statement;


public class MoviesDao {

	private Connection conn;
	private Statement st;
	public MoviesDao() throws Exception{
		this.conn = Util.conn();
		st= this.conn.createStatement();
	}
	//将电影信息存入数据库
	public void insert(String title,String year,String country,String lan,String douban_link,Double douban_score,String introduce,String main_actor,String download_url,String img_url ) throws Exception{
		StringBuffer stringBuffer=new StringBuffer();
		stringBuffer.append("INSERT INTO movies(title,year,country,lan,douban_link,douban_score,introduce,main_actor,download_url,img_url)").
				append("VALUES(").
				append("'"+title.replace("'", "")+"',").
				append("'"+year.replace("'", "")+"',").
				append("'"+country.replace("'", "")+"',").
				append("'"+lan.replace("'", "")+"',").
				append("'"+douban_link.replace("'", "")+"',").
				append("'"+douban_score+"',").
				append("'"+introduce.replace("'", "")+"',").
				append("'"+main_actor.replace("'", "").replaceAll(" 　　　　", "")+"',").
				append("'"+download_url.replace("'", "")+"',").
				append("'"+img_url.replace("'", "")+"'").
				append(");");
		System.out.println(stringBuffer.toString());
		//String sql="INSERT INTO movies(title,year,country,lan,douban_link,douban_score,introduce,main_actor,download_url,img_url) VALUES('"+title.replace("'", "")+"','"+year.replace("'", "")+"','"+country.replace("'", "")+"','"+lan.replace("'", "")+"','"+douban_link.replace("'", "")+"','"+douban_score+"','"+introduce.replace("'", "")+"','"+main_actor.replace("'", "").replaceAll(" 　　　　", "")+"','"+download_url.replace("'", "")+"','"+img_url.replace("'", "")+"');";
		//System.out.println(sql);
		st.executeUpdate(stringBuffer.toString());
	}
}
