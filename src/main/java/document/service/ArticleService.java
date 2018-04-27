package document.service;



import document.po.Article;

import java.util.List;

/**
 * Created by Administrator on 2017/9/21.
 */
public interface ArticleService {
    public List<Article> get();

    public int insert(Article article);

    public int deleteById(int id);
}
