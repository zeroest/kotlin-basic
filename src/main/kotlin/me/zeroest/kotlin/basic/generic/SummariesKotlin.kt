package me.zeroest.kotlin.basic.generic

import java.util.Arrays
import java.util.stream.Collectors
import java.util.Comparator
import java.util.Objects
import java.util.Optional

object SummariesKotlin {
    fun <T : Summary?> builder(standardSummaryMap: MutableMap<String?, T>): Builder<T> {
        return Builder(standardSummaryMap)
    }

    @SuppressWarnings("unchecked")
    fun <T : Summary?, E : Class<out SummaryState?>?> builder(enumClass: E): Builder<T> {
        val standardSummaryMap = Arrays.stream(enumClass!!.enumConstants)
            .collect(Collectors.toMap({ state: SummaryState? -> state!!.stateCode }) { state: SummaryState? ->
                DefaultSummary(
                    state!!.stateCode,
                    state.stateName,
                    0L,
                    state.sortOrder
                ) as T
            })
        return Builder(standardSummaryMap)
    }

    class Builder<T : Summary?>(private val summaryMap: MutableMap<String?, T>) {
        fun build(): List<T> {
            val totalCount = summaryMap.values.stream()
                .mapToLong { obj: T -> obj!!.count }
                .sum()
            summaryMap["TOTAL_STATE"] = DefaultSummary("TOTAL_STATE", "TOTAL_STATE_NAME", totalCount) as T
            return summaryMap.values.stream()
                .sorted(Comparator.comparing { obj: T -> obj!!.sortOrder })
                .collect(Collectors.toList())
        }

        fun addCount(stateCode: String?, count: Long): Builder<T> {
            if (Objects.isNull(count)) {
                return this
            }
            Optional.ofNullable(summaryMap[stateCode])
                .ifPresent { summary: T -> summary!!.count = summary.count + count }
            return this
        }

        fun <S : Summary?> addCount(summary: S): Builder<T> {
            if (Objects.isNull(summary)) {
                return this
            }
            Optional.ofNullable(summaryMap[summary!!.stateCode])
                .ifPresent { it: T -> it!!.count = it.count + summary.count }
            return this
        }
    }
}