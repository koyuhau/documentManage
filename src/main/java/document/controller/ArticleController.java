package document.controller;

import document.po.Article;
import document.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;


/**
 * Created by Administrator on 2017/9/14.
 */
@Controller
@ResponseBody
@RequestMapping(value="/article")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @RequestMapping("/insert")
    public int insert(Article article){
        return articleService.insert(article);
    }

    @RequestMapping("/get")
    public List<Article> get(){
        List<Article> articles = articleService.get();
        return articles;
    }

    @RequestMapping("/deleteById")
    public int deleteById(int id){
        return articleService.deleteById(id);
    }

}
