package com.example.learningservice.dtos;

import lombok.*;

@RequiredArgsConstructor
@Builder
@AllArgsConstructor
@Setter
@Getter
@Data
public class ResultDto {
    private Integer code;
    private String message;
}
