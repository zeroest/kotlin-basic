package me.zeroest.kotlin.basic.generic;

public class DefaultSummary implements Summary {

    public DefaultSummary(String stateCode, String stateName, Long count, Integer sortOrder) {
        this.stateCode = stateCode;
        this.stateName = stateName;
        this.count = count;
        this.sortOrder = sortOrder;
    }

    public DefaultSummary(String stateCode, String stateName, Long count) {
        this.stateCode = stateCode;
        this.stateName = stateName;
        this.count = count;
    }

    private final String stateCode;
    private final String stateName;
    private Long count;
    private int sortOrder;

    @Override
    public String getStateCode() {
        return stateCode;
    }

    @Override
    public String getStateName() {
        return stateName;
    }

    @Override
    public Long getCount() {
        return count;
    }

    @Override
    public void setCount(Long count) {
        this.count = count;
    }

    @Override
    public int getSortOrder() {
        return sortOrder;
    }

}
