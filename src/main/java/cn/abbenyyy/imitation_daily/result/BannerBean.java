package cn.abbenyyy.imitation_daily.result;

import cn.abbenyyy.imitation_daily.domain.News;
import cn.abbenyyy.imitation_daily.domain.NewsColumn;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.text.SimpleDateFormat;
import java.util.Locale;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BannerBean {
    private Long id;
    private String title;
    private String description;
    private Long praiseCount;
    private Long commentCount;
    private String createTime;
    private String imgUrl;
    private Long cssColumn;
    private String appview;
    private String categoryName;

    public BannerBean(News news) {
        setId(news.getId());
        setTitle(news.getTitle());
        setDescription(news.getDescription());
        setPraiseCount(news.getPraiseCount());
        setCommentCount(news.getCommentCount());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        setCreateTime(simpleDateFormat.format(news.getCreateTime()));
        setImgUrl(news.getImgUrl());
        setCssColumn(news.getCssColumn());
        setAppview(news.getAppview());
        setCategoryName(news.getNewsCategory().getCategoryName());
    }

    public BannerBean(NewsColumn newsColumn){
        setId(newsColumn.getColumnId());
        setTitle(newsColumn.getColumnName());
        setDescription(newsColumn.getColumnDescription());
        setImgUrl(newsColumn.getImgUrl());
        setCssColumn(-1L);
        setAppview(newsColumn.getAppview());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPraiseCount() {
        return praiseCount;
    }

    public void setPraiseCount(Long praiseCount) {
        this.praiseCount = praiseCount;
    }

    public Long getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Long commentCount) {
        this.commentCount = commentCount;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Long getCssColumn() {
        return cssColumn;
    }

    public void setCssColumn(Long cssColumn) {
        this.cssColumn = cssColumn;
    }

    public String getAppview() {
        return appview;
    }

    public void setAppview(String appview) {
        this.appview = appview;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

}
