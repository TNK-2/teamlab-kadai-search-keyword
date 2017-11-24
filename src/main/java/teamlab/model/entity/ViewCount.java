package teamlab.model.entity;

public class ViewCount {

	private int pageId;
	private String title;
	private int userId;
	private int viewCount;
	
	public ViewCount(int pageId, String title, int userId, int viewCount) {
		super();
		this.pageId = pageId;
		this.title = title;
		this.userId = userId;
		this.viewCount = viewCount;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getPageId() {
		return pageId;
	}

	public void setPageId(int pageId) {
		this.pageId = pageId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
}
