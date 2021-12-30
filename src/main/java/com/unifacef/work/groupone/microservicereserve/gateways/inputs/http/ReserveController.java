package com.unifacef.work.groupone.microservicereserve.gateways.inputs.http;

import com.unifacef.work.groupone.microservicereserve.gateways.inputs.http.requests.CreateReserveRequest;
import com.unifacef.work.groupone.microservicereserve.gateways.inputs.http.responses.ReserveResponse;
import com.unifacef.work.groupone.microservicereserve.usecases.CreateReserve;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/ap1/vi/reserves")
public class ReserveController {

    private final CreateReserve createReserve;

    @PostMapping
    public ReserveResponse create(@RequestBody @Validated final CreateReserveRequest request){
        return new ReserveResponse(createReserve.execute(request.toDomain()));
    }
}
