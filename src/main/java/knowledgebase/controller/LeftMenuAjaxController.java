package knowledgebase.controller;

import knowledgebase.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/ajax/")
public class LeftMenuAjaxController {

    @Autowired
    private BaseService baseService;

    @RequestMapping(value = "renameFolder.html")
    @ResponseBody
    public String renameFolder(@RequestParam("catalogId") Integer id, @RequestParam("title") String title) {
        baseService.renameCatalog(id, title);
        return "";
    }
}
