package jsoup;
 
public class Movies {
 
	private String title;//电影标题
	private String year;//电影年份
	private String country;//国家
	private String lan;//语言
	private String douban_link;//豆瓣连接
	private String introduce;//简介
	private String main_actor;//主演
	private String download_url;//下载地址
	private String img_url;//图片下载地址
	public Movies(){
		title="null";
		year="null";
		country="null";
		lan="null";
		douban_link="null";
		introduce="null";
		main_actor="null";
		download_url="null";
		img_url="null";
		
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getContry() {
		return country;
	}
	public void setContry(String contry) {
		this.country = contry;
	}
	public String getLan() {
		return lan;
	}
	public void setLan(String lan) {
		this.lan = lan;
	}
	public String getDouban_link() {
		return douban_link;
	}
	public void setDouban_link(String douban_link) {
		this.douban_link = douban_link;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getMain_actor() {
		return main_actor;
	}
	public void setMain_actor(String main_actor) {
		this.main_actor = main_actor;
	}
	public String getDownload_url() {
		return download_url;
	}
	public void setDownload_url(String download_url) {
		this.download_url = download_url;
	}
	public String getImg_url() {
		return img_url;
	}
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
	
}
