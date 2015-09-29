package knowledgebase.controller;

import knowledgebase.domain.User;
import knowledgebase.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    private SessionManager sessionManager;

    @Autowired
    private BaseService baseService;

    @RequestMapping(method = RequestMethod.GET)
    public String printLoginPage(ModelMap model) {
//        TODO: сделать реализацию сессии через аннотации SessionAttributes
        try {
            if (sessionManager.userSession().getSessionId() == 1) {
                model.addAttribute("treeList", baseService.getCatalogTree().getChildren());
                model.addAttribute("content", "Главная страница!!!");
                return "index";
            } else {
                return "login";
            }
        }
        catch(Exception e) {
            return "login";
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public String printWelcome(@RequestParam("login") String login, @RequestParam("password") String password, ModelMap model) {

        User user = baseService.getUserByLoginPassword(login, password);
        if (user != null) {
            //TODO: убрать дублирование кода
            sessionManager.userSession().setSessionId(1);
            model.addAttribute("treeList", baseService.getCatalogTree().getChildren());
            model.addAttribute("content", "Главная страница!!!");
            return "index";
        }
        return "login";
    }

}