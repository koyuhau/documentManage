package document.service.impl;

import document.dao.ArticleMapper;
import document.dao.VideoMapper;
import document.po.Article;
import document.po.ArticleExample;
import document.po.Video;
import document.po.VideoExample;
import document.service.ArticleService;
import document.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/9/21.
 */
@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    VideoMapper videoMapper;

    @Override
    public List<Video> get() {

        VideoExample example = new VideoExample();
        example.createCriteria();

        List<Video> video = videoMapper.selectByExample(example);

        return  video;
    }

    @Override
    public int insert(Video video) {

        int insert = videoMapper.insert(video);

        return insert;
    }

    @Override
    public int deleteById(int id) {
        return videoMapper.deleteByPrimaryKey(id);
    }
}
