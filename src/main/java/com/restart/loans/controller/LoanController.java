package com.restart.loans.controller;

import com.restart.loans.constants.LoanConstant;
import com.restart.loans.dto.ErrorResponseDto;
import com.restart.loans.dto.LoansDto;
import com.restart.loans.dto.ResponseDto;
import com.restart.loans.service.CreateLoanService;
import com.restart.loans.service.DeleteLoanService;
import com.restart.loans.service.GetLoanService;
import com.restart.loans.service.UpdateLoanService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/loans-api", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class LoanController {
    private final CreateLoanService createLoanService;

    private final UpdateLoanService updateLoanService;

    private final GetLoanService getLoanService;

    private final DeleteLoanService deleteLoanService;

    @Autowired
    public LoanController(CreateLoanService createLoanService, UpdateLoanService updateLoanService, GetLoanService getLoanService, DeleteLoanService deleteLoanService) {
        this.createLoanService = createLoanService;
        this.updateLoanService = updateLoanService;
        this.getLoanService = getLoanService;
        this.deleteLoanService = deleteLoanService;
    }
    @Operation(
            summary = "Create Loan REST API",
            description = "REST API to create new loan inside EazyBank"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "HTTP Status CREATED"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createLoan(@RequestParam
                                                  @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits")
                                                  String mobileNumber){
        createLoanService.createLoan(mobileNumber);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(LoanConstant.STATUS_201, LoanConstant.MESSAGE_201));
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateLoanDetails(@Valid @RequestBody LoansDto loansDto) {

        updateLoanService.updateLoan(loansDto);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(LoanConstant.STATUS_200, LoanConstant.MESSAGE_200));
        }

    @GetMapping("/fetch")
    public ResponseEntity<ResponseDto> getDetails( @RequestBody @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits") String mobileNumber){
        getLoanService.getLoanDetails(mobileNumber);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(LoanConstant.STATUS_200, LoanConstant.MESSAGE_200));


    }
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto>deleteRecord(@RequestBody @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits") String mobileNumber){
        deleteLoanService.deleteRecord(mobileNumber);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(LoanConstant.STATUS_200, LoanConstant.MESSAGE_200));

    }
    }





