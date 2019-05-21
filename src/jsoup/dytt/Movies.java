package jsoup.dytt;
 
public class Movies {
 
	private Integer id;
	private String title;//电影标题
	private String year;//电影年份
	private String country;//国家
	private String lan;//语言
	private String douban_link;//豆瓣连接
	private Double douban_score;//豆瓣连接
	private String introduce;//简介
	private String main_actor;//主演
	private String download_url;//下载地址
	private String img_url;//图片下载地址
	private String dytt_url;
	//默认初始化，防止出现空指针的情况
	public Movies() {
		title="null";
		year="null";
		country="null";
		lan="null";
		douban_link="null";
		douban_score=0.0;
		introduce="null";
		main_actor="null";
		download_url="null";
		img_url="null";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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

	public Double getDouban_score() {
		return douban_score;
	}

	public void setDouban_score(Double douban_score) {
		this.douban_score = douban_score;
	}

	public String getDytt_url() {
		return dytt_url;
	}

	public void setDytt_url(String dytt_url) {
		this.dytt_url = dytt_url;
	}

	@Override
	public String toString() {
		return "Movies{" +
				"id=" + id +
				", title='" + title + '\'' +
				", year='" + year + '\'' +
				", country='" + country + '\'' +
				", lan='" + lan + '\'' +
				", douban_link='" + douban_link + '\'' +
				", douban_score=" + douban_score +
				", introduce='" + introduce + '\'' +
				", main_actor='" + main_actor + '\'' +
				", download_url='" + download_url + '\'' +
				", img_url='" + img_url + '\'' +
				", dytt_url='" + dytt_url + '\'' +
				'}';
	}
}
