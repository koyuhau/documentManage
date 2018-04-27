package document.po;

public class Article {
    private Integer id;

    private String title;

    private String author;

    private String sectitle;

    private String content;

    private String backgroundimage;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getSectitle() {
        return sectitle;
    }

    public void setSectitle(String sectitle) {
        this.sectitle = sectitle == null ? null : sectitle.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getBackgroundimage() {
        return backgroundimage;
    }

    public void setBackgroundimage(String backgroundimage) {
        this.backgroundimage = backgroundimage == null ? null : backgroundimage.trim();
    }
}