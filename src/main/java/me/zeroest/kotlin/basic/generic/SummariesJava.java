package me.zeroest.kotlin.basic.generic;

import java.util.*;
import java.util.stream.Collectors;

public class SummariesJava {
    private SummariesJava() {
    }

    public static <T extends Summary> Builder<T> builder(Map<String, T> standardSummaryMap) {
        return new Builder<>(standardSummaryMap);
    }

    @SuppressWarnings("unchecked")
    public static <T extends Summary, E extends Class<? extends SummaryState>> Builder<T> builder(E enumClass) {
        Map<String, T> standardSummaryMap = Arrays.stream(enumClass.getEnumConstants())
            .collect(Collectors.toMap(SummaryState::getStateCode, state -> (T) new DefaultSummary(state.getStateCode(), state.getStateName(), 0L, state.getSortOrder())));
        return new Builder<>(standardSummaryMap);
    }

    public static class Builder<T extends Summary> {
        private final Map<String/*stateCode*/, T> summaryMap;

        public Builder(Map<String, T> standardStateMap) {
            this.summaryMap = standardStateMap;
        }

        @SuppressWarnings("unchecked")
        public List<T> build() {
            Long totalCount = summaryMap.values().stream()
                .mapToLong(Summary::getCount)
                .sum();
            summaryMap.put("TOTAL_STATE", (T) new DefaultSummary("TOTAL_STATE", "TOTAL_STATE_NAME", totalCount));

            return summaryMap.values().stream()
                .sorted(Comparator.comparing(Summary::getSortOrder))
                .collect(Collectors.toList());
        }

        public Builder<T> addCount(String stateCode, Long count) {
            if (Objects.isNull(count)) {
                return this;
            }

            Optional.ofNullable(summaryMap.get(stateCode))
                .ifPresent(summary -> summary.setCount(summary.getCount() + count));
            return this;
        }

        public <S extends Summary> Builder<T> addCount(S summary) {
            if (Objects.isNull(summary)) {
                return this;
            }

            Optional.ofNullable(summaryMap.get(summary.getStateCode()))
                .ifPresent(it -> it.setCount(it.getCount() + summary.getCount()));
            return this;
        }

    }
}
