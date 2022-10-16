package me.zeroest.kotlin.basic.generic;

public enum StateJava implements SummaryState{
    INIT("시작", 1),
    IN_PROGRESS("진행중", 2),
    COMPLETED("완료", 3);

    StateJava(String stateName, int sortOrder) {
        this.stateName = stateName;
        this.sortOrder = sortOrder;
    }

    private String stateName;
    private int sortOrder;

    @Override
    public String getStateCode() {
        return this.name();
    }

    @Override
    public String getStateName() {
        return stateName;
    }

    @Override
    public int getSortOrder() {
        return sortOrder;
    }
}
