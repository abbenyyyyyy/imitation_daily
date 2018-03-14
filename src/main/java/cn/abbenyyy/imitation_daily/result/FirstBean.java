package cn.abbenyyy.imitation_daily.result;

import java.util.Date;

public class FirstBean {
    private Long id;
    private String title;
    private String description;
    private Long praiseCount;
    private Long commentCount;
    private Date createTime;
    private String imgUrl;
    private Long cssColumn;
    private String appview;
    private String categoryName;

    public FirstBean() {
    }

    public FirstBean(Long id, String title, String description, Long praiseCount, Long commentCount, Date createTime,
                     String imgUrl, Long cssColumn, String appview, String categoryName) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.praiseCount = praiseCount;
        this.commentCount = commentCount;
        this.createTime = createTime;
        this.imgUrl = imgUrl;
        this.cssColumn = cssColumn;
        this.appview = appview;
        this.categoryName = categoryName;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
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
