package cn.abbenyyy.imitation_daily.result;

import java.util.List;

public class HomePageBean {
    private boolean has_more;

    private long last_key;

    private List<BannerBean> homepageData;

    public HomePageBean(List<BannerBean> homepageData, boolean has_more) {
        this.homepageData = homepageData;
        this.has_more = has_more;
        this.last_key = has_more ? homepageData.get(homepageData.size() - 1).getId() : -1L;
    }

    public boolean isHas_more() {
        return has_more;
    }

    public void setHas_more(boolean has_more) {
        this.has_more = has_more;
    }

    public long getLast_key() {
        return last_key;
    }

    public void setLast_key(long last_key) {
        this.last_key = last_key;
    }

    public List<BannerBean> getHomepageData() {
        return homepageData;
    }

    public void setHomepageData(List<BannerBean> homepageData) {
        this.homepageData = homepageData;
    }
}
