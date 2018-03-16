package cn.abbenyyy.imitation_daily.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "news_column")
public class NewsColumn {
    @Id
    @Column(columnDefinition = "BIGINT(20) UNSIGNED")
    private Long columnId;

    private String columnName;

    private String columnDescription;

    private String imgUrl;

    private String appview;

    @Column(columnDefinition = "BIGINT(20) UNSIGNED")
    private Long statusId;

    public NewsColumn(){
    }

    public Long getColumnId() {
        return columnId;
    }

    public void setColumnId(Long columnId) {
        this.columnId = columnId;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnDescription() {
        return columnDescription;
    }

    public void setColumnDescription(String columnDescription) {
        this.columnDescription = columnDescription;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getAppview() {
        return appview;
    }

    public void setAppview(String appview) {
        this.appview = appview;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }
}
