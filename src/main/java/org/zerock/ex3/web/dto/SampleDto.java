package org.zerock.ex3.web.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
@ToString
public class SampleDto {
    private Long sno;

    private String first;

    private String last;

    private LocalDateTime regTime;
}

