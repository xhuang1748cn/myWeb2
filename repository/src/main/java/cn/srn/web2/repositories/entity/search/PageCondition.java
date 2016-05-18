package cn.srn.web2.repositories.entity.search;

/**
 * Created by Winter on 2016/4/1.
 */
public class PageCondition extends Condition {

    private int pageSize;
    private int pageNum;
    private int pageOffset;

    public PageCondition() {
        pageSize = -1;
        pageNum = -1;
        pageOffset = 0;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
        calcOffset();
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
        calcOffset();
    }

    public int getPageOffset() {
        return pageOffset;
    }

    private void calcOffset() {
        if (pageSize != -1 && pageNum != -1) {
            pageOffset = (pageNum - 1) * pageSize;
        }
    }

    @Override
    public String toString() {
        return "PageCondition{" +
                "pageSize=" + pageSize +
                ", pageNum=" + pageNum +
                ", pageOffset=" + pageOffset +
                '}';
    }
}
