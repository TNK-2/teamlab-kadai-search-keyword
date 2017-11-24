package teamlab.model.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import teamlab.model.dao.PageinfDao;
import teamlab.model.dao.UserDao;
import teamlab.model.entity.Pageinf;
import teamlab.model.entity.User;
import teamlab.model.entity.ViewCount;
import teamlab.model.response.UserPage;
import teamlab.utils.SearchList;

@Service
public class PageService {
	
    @Autowired
    private UserDao userDao;
    
    @Autowired
    private PageinfDao pageinfDao;

    public List<UserPage> findUserViewedPage(String keyWord) {
    	
    		// ユーザーと紐付いていないページの取得（検索結果の先頭になるため）
    		List<Pageinf> noUserPages = null;
    		int hits = 0;
    		if("".equals(keyWord) || null == keyWord) {
    			noUserPages = pageinfDao.findNoUserPage();
    			hits = pageinfDao.countNoUserPage().get(0);
    		} else {
    			noUserPages = pageinfDao.findNoUserPage(keyWord + "%");
    			hits = pageinfDao.countNoUserPage(keyWord + "%").get(0);
    		}
    		
    		
    		// ユーザーと紐付いていないページの格納（検索結果の先頭になるため）
    		int count = 0;
    		UserPage userPage = null;
    		SearchList<UserPage> userPageList = new SearchList<>(10);
    		for (Pageinf page : noUserPages) {	
    			userPage = new UserPage();
    			userPage.pageId = page.getId();
    			userPage.pageTitle = page.getTitle();
    			userPageList.add(userPage);
    			
    			if(++count >= 10) {
    				break;
    			}
    		}
    		
    		
    		// ユーザーと紐付いているページの取得（検索結果の後方になる）
    		List<ViewCount> userPages = null;
    		// ユーザーID、閲覧回数、ページID、ページタイトルを取得
    		if("".equals(keyWord) || null == keyWord) {
    			userPages = pageinfDao.findUserPage();
    			hits += userPages.size();
    		} else {
    			userPages = pageinfDao.findUserPage(keyWord + "%");
    			hits += userPages.size();
    		}

    		
    		if(count < 10) {
    			// ユーザーと紐付いているページの格納（検索結果の後方になる）
    			Map<Integer, UserPage> userPageMap = new HashMap<>();
        		for (ViewCount page : userPages) {
        			User user = userDao.findOne(page.getUserId());
        			if (!userPageMap.containsKey(user.getId())) {
        				userPage = new UserPage();
        				userPage.pageId = page.getPageId();
        				userPage.pageTitle = page.getTitle();
        				userPage.userId = user.getId();
        				userPage.userName = user.getName();
        				userPage.viewCount = page.getViewCount(); //閲覧回数
        				userPageMap.put(user.getId(), userPage);
        				++count;
        			}
        			if(count >= 10) {
        				break;
        			}
        		}
        		
        		//ユーザIDでソート
        		Object[] mapkey = userPageMap.keySet().toArray();
        		Arrays.sort(mapkey);
        		for (Integer key : userPageMap.keySet()) {
        			userPageList.add(userPageMap.get(key));
        		}
    		}
    		
    		
    		// ヒット件数の格納
    		userPageList.setHits(hits);
        return userPageList;
    }
    
    
}
