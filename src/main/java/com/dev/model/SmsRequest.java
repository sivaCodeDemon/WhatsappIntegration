package com.dev.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;


@Data
@AllArgsConstructor
public class SmsRequest {
    @NotBlank(message = "Feild Must Not be null")
    private final String phoneNumber;
    @NotBlank(message = "Feild Must Not be null")
    private final String message;

}
