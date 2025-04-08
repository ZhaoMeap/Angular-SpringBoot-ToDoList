package com.example.myproject.entity;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "todos")
@Data
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "主鍵 ID，自動產生")
    private Long id;

    @Column(nullable = false)
    @Schema(description = "任務標題", example = "買牛奶")
    private String title;

    @Column(nullable = true)
    @Schema(description = "任務描述", example = "晚上去超市買一瓶光泉牛奶")
    private String description;

    @Column(nullable = false)
    @Schema(description = "是否完成", example = "false")
    private boolean completed = false;

    @Column(nullable = false, updatable = false)
    @Schema(description = "建立時間", example = "2025-03-21T14:30:00")
    private LocalDateTime createdAt = LocalDateTime.now();
}
