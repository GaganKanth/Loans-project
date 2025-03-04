package com.restart.loans.service;

import com.restart.loans.dto.LoansDto;
import com.restart.loans.entity.Loans;
import com.restart.loans.exception.ResourceNotFoundException;
import com.restart.loans.repository.LoansRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.restart.loans.mapper.LoansMapper.mapToLoansDto;
@Service
public class DeleteLoanService {
    private final LoansRepository loansRepository;

    @Autowired
    public DeleteLoanService(LoansRepository loansRepository) {
        this.loansRepository = loansRepository;
    }


    public LoansDto deleteRecord(String mobileNumber){
        Loans loans = loansRepository.deleteByMobileNumber(mobileNumber).orElseThrow(()->
                new ResourceNotFoundException("Loans","Mobile number",mobileNumber));
        return mapToLoansDto(loans);


    }
}
