package knowledgebase.controller;

import knowledgebase.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/")
public class ArticleController {

    @Autowired
    private BaseService baseService;

    @RequestMapping(value = "ajax/article.html")
    @ResponseBody
    public String ajaxArticle(@RequestParam("catalogId") Integer id,
                              ModelMap model) {
        //TODO: получить url статьи по id из базы и вернуть url
        return "";
    }

    @RequestMapping(value = "article.html")
    public String article(ModelMap model) {
        model.addAttribute("treeList", baseService.getCatalogTree().getChildren());
        model.addAttribute("content", "Статья!!!");
        return "index";
    }

}