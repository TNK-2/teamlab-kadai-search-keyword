package teamlab.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import teamlab.model.response.UserPage;
import teamlab.model.service.PageService;

@Controller
public class PageController {
    @Autowired
    private PageService pageService;

    //page?keyword=テスト
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    @Transactional
    public String get(Model model, @RequestParam("keyword") String keyword) {
        long start = System.nanoTime();

        List<UserPage> list = pageService.findUserViewedPage(keyword);
        list.stream()
        .forEach(e -> System.out.println("ID : " + e.pageId + " name : " + e.pageTitle));
        long estimatedTime = System.nanoTime() - start;

        model.addAttribute("userpages", list);
        model.addAttribute("searchtime", estimatedTime);

        return "index";
    }
}