package com.unifacef.work.groupone.microservicereserve.gateways.inputs.http;

import com.unifacef.work.groupone.microservicereserve.gateways.inputs.http.requests.CreateReserveRequest;
import com.unifacef.work.groupone.microservicereserve.gateways.inputs.http.requests.PatchFinishedReserveRequest;
import com.unifacef.work.groupone.microservicereserve.gateways.inputs.http.requests.PatchInProgressReserveRequest;
import com.unifacef.work.groupone.microservicereserve.gateways.inputs.http.responses.ReserveResponse;
import com.unifacef.work.groupone.microservicereserve.usecases.CreateReserve;
import com.unifacef.work.groupone.microservicereserve.usecases.PatchStatusFinishedReserve;
import com.unifacef.work.groupone.microservicereserve.usecases.PatchStatusInProgressReserve;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/ap1/vi/reserves")
public class ReserveController {

    private final CreateReserve createReserve;
    private final PatchStatusFinishedReserve patchStatusFinishedReserve;
    private final PatchStatusInProgressReserve patchStatusInProgressReserve;

    @PostMapping
    public ReserveResponse create(@RequestBody @Validated final CreateReserveRequest request){
        return new ReserveResponse(createReserve.execute(request.toDomain()));
    }

    @PatchMapping(path = "/{code}/status/finished")
    public ReserveResponse patchStatusFinished(@PathVariable final String code, @RequestBody @Validated final PatchFinishedReserveRequest request){
        return new ReserveResponse(patchStatusFinishedReserve.execute(request.toDomain(code)));
    }

    @PatchMapping(path = "/{code}/status/in-progress")
    public ReserveResponse patchStatusInProgress(@PathVariable final String code,@RequestBody @Validated final PatchInProgressReserveRequest request){
        return new ReserveResponse(patchStatusInProgressReserve.execute(request.toDomain(code)));
    }

}
