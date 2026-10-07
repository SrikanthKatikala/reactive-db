package com.ibm.sri.tech.model.error;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorMessage {

    private String code;
    private String title;
    private String message;
    private String[] values;
    private String origmesg;
    private Map<String, String> errors;

}
