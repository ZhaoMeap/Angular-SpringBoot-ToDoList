package com.example.myproject.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record TodoDTO(
    @Schema(description = "任務標題", example = "買牛奶")
    String title,
    @Schema(description = "是否完成", example = "false")
    boolean completed
    ) {}
