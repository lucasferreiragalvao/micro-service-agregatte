package com.unifacef.work.groupone.microservicereserve.gateways.inputs.http;

import com.unifacef.work.groupone.microservicereserve.domains.Reserve;
import com.unifacef.work.groupone.microservicereserve.gateways.inputs.http.requests.CreateReserveRequest;
import com.unifacef.work.groupone.microservicereserve.gateways.inputs.http.requests.PatchFinishedReserveRequest;
import com.unifacef.work.groupone.microservicereserve.gateways.inputs.http.requests.PatchInProgressReserveRequest;
import com.unifacef.work.groupone.microservicereserve.gateways.inputs.http.responses.ListResponse;
import com.unifacef.work.groupone.microservicereserve.gateways.inputs.http.responses.ReserveResponse;
import com.unifacef.work.groupone.microservicereserve.usecases.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/ap1/vi/reserves")
public class ReserveController {

    private final CreateReserve createReserve;
    private final PatchStatusFinishedReserve patchStatusFinishedReserve;
    private final PatchStatusInProgressReserve patchStatusInProgressReserve;
    private final FindByReserveCode findByReserveCode;
    private final FindReserve findReserves;

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

    @GetMapping(path = "/{code}")
    public ReserveResponse find(@PathVariable final String code) {
        Reserve reserve = findByReserveCode.execute(code);
        return new ReserveResponse(reserve);
    }

    @GetMapping
    public ListResponse<ReserveResponse> findByPage(@RequestParam(defaultValue = "0") final Integer page,
                                                    @RequestParam(defaultValue = "20") final Integer size) {
        Page<ReserveResponse> reservePage =
                findReserves.execute(PageRequest.of(page, size)).map(ReserveResponse::new);
        return new ListResponse<>(reservePage);
    }
}
