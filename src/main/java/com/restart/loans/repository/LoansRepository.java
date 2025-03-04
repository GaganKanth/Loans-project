package com.restart.loans.repository;

import com.restart.loans.entity.Loans;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface LoansRepository extends MongoRepository<Loans, Long> {


    Optional<Loans> findByMobileNumber(String mobileNumber);

    Optional<Loans> findByLoanNumber(String loanNumber);

    Optional<Loans> deleteByMobileNumber(String mobileNumber);
}
