package cn.abbenyyy.imitation_daily.result;

import java.util.List;

public class HomePageBean {
    private boolean has_more;

    private List<BannerBean> homepageData;

    public HomePageBean(List<BannerBean> homepageData, boolean has_more) {
        this.homepageData = homepageData;
        this.has_more = has_more;
    }

    public boolean isHas_more() {
        return has_more;
    }

    public void setHas_more(boolean has_more) {
        this.has_more = has_more;
    }

    public List<BannerBean> getHomepageData() {
        return homepageData;
    }

    public void setHomepageData(List<BannerBean> homepageData) {
        this.homepageData = homepageData;
    }
}
