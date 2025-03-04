package com.restart.loans.service;

import com.restart.loans.dto.LoansDto;
import com.restart.loans.entity.Loans;
import com.restart.loans.exception.ResourceNotFoundException;
import com.restart.loans.mapper.LoansMapper;
import com.restart.loans.repository.LoansRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UpdateLoanService {

    private final LoansRepository loansRepository;

    public UpdateLoanService(LoansRepository loansRepository) {
        this.loansRepository = loansRepository;
    }

    public void updateLoan(LoansDto loansDto) {
        Loans loans = loansRepository.findByLoanNumber(loansDto.getLoanNumber()).orElseThrow(
                () -> new ResourceNotFoundException("Loan", "LoanNumber", loansDto.getLoanNumber()));
        LoansMapper.mapToLoans(loansDto, loans);
        loansRepository.save(loans);

    }

}
