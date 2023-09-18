package org.zerock.ex3.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class HelloResPonseDto {
    private final String name;
    private final int amount;
}
