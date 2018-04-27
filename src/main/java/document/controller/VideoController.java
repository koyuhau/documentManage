package document.controller;

import document.po.Article;
import document.po.Video;
import document.service.ArticleService;
import document.service.VideoService;
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
@RequestMapping(value="/video")
public class VideoController {

    @Autowired
    VideoService videoService;

    @RequestMapping("/insert")
    public int insert(Video video){
        return videoService.insert(video);
    }

    @RequestMapping("/get")
    public List<Video> get(){
       return videoService.get();
    }

    @RequestMapping("/deleteById")
    public int deleteById(int id){
        return videoService.deleteById(id);
    }

}
