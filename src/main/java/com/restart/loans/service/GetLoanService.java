package com.restart.loans.service;

import com.restart.loans.dto.LoansDto;
import com.restart.loans.entity.Loans;
import com.restart.loans.exception.ResourceNotFoundException;
import com.restart.loans.mapper.LoansMapper;
import com.restart.loans.repository.LoansRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetLoanService {

    private final LoansRepository loansRepository;

    @Autowired
    public GetLoanService(LoansRepository loansRepository) {
        this.loansRepository = loansRepository;

    }


    public LoansDto getLoanDetails(String mobileNumber){
        Loans loans = loansRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Loan","MobileNumber", mobileNumber));
        return LoansMapper.mapToLoansDto(loans);

    }
}
