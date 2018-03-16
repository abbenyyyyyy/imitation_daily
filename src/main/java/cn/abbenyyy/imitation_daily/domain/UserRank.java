package cn.abbenyyy.imitation_daily.domain;

import javax.persistence.*;

@Entity
@Table(name = "user_rank")
public class UserRank {
    @Id
    @Column(nullable = false, columnDefinition = "BIGINT(20) UNSIGNED")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rankId;

    private String rankName;

    protected UserRank() {
    }

    public Long getRankId() {
        return rankId;
    }

    public void setRankId(Long rankId) {
        this.rankId = rankId;
    }

    public String getRankName() {
        return rankName;
    }

    public void setRankName(String rankName) {
        this.rankName = rankName;
    }
}
