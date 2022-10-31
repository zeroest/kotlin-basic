package me.zeroest.kotlin.basic.migration.controller.dto;

import lombok.Builder;
import lombok.Data;
import me.zeroest.kotlin.basic.migration.domain.Todo;
import org.springframework.util.Assert;

import java.time.LocalDateTime;

@Data
@Builder
public class TodoResponse {

    private Long id;

    private String title;

    private String description;

    private Boolean done;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public static TodoResponse of(Todo todo) {
        Assert.notNull(todo, "Todo is null");

        return TodoResponse.builder()
            .id(todo.getId())
            .title(todo.getTitle())
            .description(todo.getDescription())
            .done(todo.getDone())
            .createdAt(todo.getCreatedAt())
            .updatedAt(todo.getUpdatedAt())
            .build();
    }

}