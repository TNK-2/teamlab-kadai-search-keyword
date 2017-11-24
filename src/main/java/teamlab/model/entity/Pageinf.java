package teamlab.model.entity;

public class Pageinf {
	
	private Integer id;
	private String  title;
	private Integer userId;
	private Integer pageId;

	public Pageinf(Integer id, String title, Integer userId, Integer pageId) {
		super();
		this.id = id;
		this.title = title;
		this.userId = userId;
		this.pageId = pageId;
	}

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getPageId() {
		return pageId;
	}
	public void setPageId(Integer pageId) {
		this.pageId = pageId;
	}
	
	
}
