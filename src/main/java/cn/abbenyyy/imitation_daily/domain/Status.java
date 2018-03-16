package cn.abbenyyy.imitation_daily.domain;

import javax.persistence.*;

@Entity
@Table(name = "status")
public class Status {
    @Id
    @Column(nullable = false, columnDefinition = "BIGINT(20) UNSIGNED")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long statusId;

    private String statusName;

    protected Status() {
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
}
