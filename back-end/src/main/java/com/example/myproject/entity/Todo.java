package com.example.myproject.entity;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "todos")
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

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean getCompleted() {
        return completed;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
