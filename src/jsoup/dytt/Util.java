package jsoup.dytt;
 
import java.sql.Connection;
import java.sql.DriverManager;

public class Util {
 
 
	//数据库连接
	public static Connection conn() throws Exception{
		
//		//创建Properties对象，用于加载配置信息
//		Properties prop=new Properties();
//		//将文件加载到字节输入流中
//		InputStream in=MoviesDao.class.getClassLoader().getResourceAsStream("db_properties.properties");
//		//把流对象的数据放到prop对象中
//		prop.load(in);
//		String username=prop.getProperty("username");
//		String password=prop.getProperty("password");
//		String url=prop.getProperty("url");
//		String driver=prop.getProperty("driver");
		
		String username="root";
		String password="123";
		String url="jdbc:mysql://localhost:3306/movie";
		String driver="com.mysql.jdbc.Driver";
		//数据库连接
		//第一步：加载驱动
		Class.forName(driver);
		//第二步：建立数据库连接
		Connection conn=DriverManager.getConnection(url,username,password);
		return conn;
	}
	
}