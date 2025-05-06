package io.github.vanbv.list.keep.dto;

import jakarta.validation.constraints.NotBlank;

public record ListCreateDto(@NotBlank String name) {}
