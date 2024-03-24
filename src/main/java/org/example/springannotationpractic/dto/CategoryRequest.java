package org.example.springannotationpractic.dto;

import lombok.Builder;

@Builder
public record CategoryRequest(String title, String decription) {
}
