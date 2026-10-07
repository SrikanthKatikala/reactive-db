package com.ibm.sri.tech.model.error;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResponse {

    private String errorId;
    private LocalDateTime errorAt;
    private String errorLocation;
    private ErrorMessage error;
    private List<ErrorMessage> errors;

}
