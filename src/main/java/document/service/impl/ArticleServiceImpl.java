package document.service.impl;

import document.dao.ArticleMapper;
import document.po.Article;
import document.po.ArticleExample;
import document.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * Created by Administrator on 2017/9/21.
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleMapper articleMapper;

    @Override
    public List<Article> get() {

        ArticleExample example = new ArticleExample();
        example.createCriteria();

        List<Article> articles = articleMapper.selectByExample(example);

        return  articles;
    }

    @Override
    public int insert(Article article) {
        return articleMapper.insert(article);
    }

    @Override
    public int deleteById(int id) {
        return articleMapper.deleteByPrimaryKey(id);
    }
}
