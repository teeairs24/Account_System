package za.ac.nwu.ac.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.domain.persistence.AccountType;

import java.io.Serializable;
import java.time.LocalDate;

public class AccountTransactionDto implements Serializable {

    private long transactionId;
    private String accountTypeMnemonic;
    private Long memberId;
    private Long amount;
    private LocalDate transactionDate;
    private AccountTransactionDetailsDto details;

    public AccountTransactionDto(long transactionId, String accountTypeMnemonic, Long memberId, Long amount, LocalDate transactionDate) {
        this.transactionId = transactionId;
        this.accountTypeMnemonic = accountTypeMnemonic;
        this.memberId = memberId;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public AccountTransactionDto(long transactionId, String accoutTypeMnemonic, Long memberId, Long amount, LocalDate transactionDate, AccountTransactionDetailsDto details) {
        this.transactionId = transactionId;
        this.accountTypeMnemonic = accoutTypeMnemonic;
        this.memberId = memberId;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.details = details;
    }

    public AccountTransactionDto(AccountTransaction accountTransaction){
        this.transactionId = accountTransaction.getTransactionId();
        this.accountTypeMnemonic = accountTransaction.getAccountType().getMnemonic();
        this.memberId = accountTransaction.getMemberId();
        this.amount = accountTransaction.getAmount();
        this.transactionDate = accountTransaction.getTransactionDate();
        if(null != accountTransaction.getDetails()){
            this.details = new AccountTransactionDetailsDto(accountTransaction.getDetails());
        }
    }

    @JsonIgnore
    public AccountTransaction buildAccountTransaction(AccountType accountType){
        return new AccountTransaction(this.getTransactionId(), accountType, this.getMemberId(),
                this.getAmount(), this.getTransactionDate());
    }

    public long getTransactionId() {return transactionId;}

    public void setTransactionId(long transactionId) {this.transactionId = transactionId;}

    public String getAccoutTypeMnemonic() {return accountTypeMnemonic;}

    public void setAccoutTypeMnemonic(String accoutTypeMnemonic) {this.accountTypeMnemonic = accoutTypeMnemonic;}

    public Long getMemberId() {return memberId;}

    public void setMemberId(Long memberId) {this.memberId = memberId;}

    public Long getAmount() {return amount;}

    public void setAmount(Long amount) {this.amount = amount;}

    public LocalDate getTransactionDate() {return transactionDate;}

    public void setTransactionDate(LocalDate transactionDate) {this.transactionDate = transactionDate;}

    public AccountTransactionDetailsDto getDetails() {return details;}

    public void setDetails(AccountTransactionDetailsDto details) {this.details = details;}
}
