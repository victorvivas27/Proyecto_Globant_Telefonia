package com.telefonia_vivas.util;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class ApiResponse<T> {

    private String message;

    private int status;

    private T data;

}