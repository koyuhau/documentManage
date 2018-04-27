package document.service;



import document.po.Article;
import document.po.Video;

import java.util.List;

/**
 * Created by Administrator on 2017/9/21.
 */
public interface VideoService {
    public List<Video> get();

    public int insert(Video video);

    public int deleteById(int id);

}
