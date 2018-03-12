package cn.abbenyyy.imitation_daily.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "news")
public class News {

    @Id
    @Column(nullable = false, columnDefinition = "BIGINT(20) UNSIGNED")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    @Column(columnDefinition = "BIGINT(20) UNSIGNED DEFAULT 0")
    private Long praiseCount= 0L;

    @Column(columnDefinition = "BIGINT(20) UNSIGNED DEFAULT 0")
    private Long commentCount = 0L;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    @CreationTimestamp
    private Date createTime;


    private String imgUrl;

    @Column(columnDefinition = "BIGINT(20) UNSIGNED")
    private Long newsCategoryId;

    @Column(columnDefinition = "BIGINT(20) UNSIGNED")
    private Long statusId;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(columnDefinition = "BIGINT(20) UNSIGNED")
    private Long cssColumn;

    private String appview;

    protected News() {
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

    public Long getNewsCategoryId() {
        return newsCategoryId;
    }

    public void setNewsCategoryId(Long newsCategoryId) {
        this.newsCategoryId = newsCategoryId;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
}
