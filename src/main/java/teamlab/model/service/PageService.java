package teamlab.model.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import teamlab.model.dao.ActivityDao;
import teamlab.model.dao.PageDao;
import teamlab.model.dao.UserDao;
import teamlab.model.entity.Activity;
import teamlab.model.entity.Page;
import teamlab.model.entity.User;
import teamlab.model.response.UserPage;

@Service
public class PageService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private ActivityDao activityDao;

    @Autowired
    private PageDao pageDao;

    public List<UserPage> findUserViewedPage(String keyWord) {
    	List<Page> pages = null;
    	if("".equals(keyWord) || null == keyWord){
    		pages = pageDao.findAll();
    	} else {
    		pages = pageDao.findPageByTitle(keyWord);
    	}
        List<Activity> activitys = activityDao.findAll();

        Map<Integer, UserPage> userPageMap = new HashMap<>();
        List<UserPage> userPageList = new ArrayList<>();

        List<Activity> remainingActivitys = new ArrayList<>();
        UserPage userPage = null;
         //ページごとにユーザの閲覧数
        for (Page page : pages) {
            boolean isFound = false;
            for (Activity activity : activitys) {
            	if(activity.getPageId() == page.getId()){
            		User user = userDao.findOne(activity.getUserId());
                    if (user != null) {
                        isFound = true;
                        if (userPageMap.containsKey(user.getId())) {
                            userPageMap.get(user.getId()).viewCount = userPageMap.get(user.getId()).viewCount + 1;
                        } else {
                            userPage = new UserPage();
                            userPage.pageId = page.getId();
                            userPage.pageTitle = page.getTitle();
                            userPage.userId = user.getId();
                            userPage.userName = user.getName();
                            userPage.viewCount = 1;
                            userPageMap.put(user.getId(), userPage);
                        }
                    }
            	} else {
            		remainingActivitys.add(activity);
            	}
            }
            activitys = remainingActivitys;
            remainingActivitys.clear();
            if (!isFound) {
                userPage = new UserPage();
                userPage.pageId = page.getId();
                userPage.pageTitle = page.getTitle();
                userPageList.add(userPage);
            }

        }

        //ユーザIDでソート
        Object[] mapkey = userPageMap.keySet().toArray();
        Arrays.sort(mapkey);
        for (Integer key : userPageMap.keySet()) {
            userPageList.add(userPageMap.get(key));
        }

        return userPageList;
    }
}
