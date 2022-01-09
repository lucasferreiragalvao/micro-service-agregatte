package com.unifacef.work.groupone.microservicereserve.gateways.inputs.http.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ErrorResponse implements Serializable {
    private static final long serialVersionUID = -130292785026387590L;
    private List<String> errors = new ArrayList();
}
