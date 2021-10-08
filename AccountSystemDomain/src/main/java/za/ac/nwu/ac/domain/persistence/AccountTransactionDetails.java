package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "ACCOUNT_TX_DETAILS", schema = "DEMO_SCHEMA")
public class AccountTransactionDetails implements Serializable {
    private static final long serialVersionUID = 4562890339977033624L;

    Long accountTransactionDetailsId;
    AccountTransaction accountTransaction;
    String partnerName;
    Long numberOfTimes;

    public AccountTransactionDetails() {

    }

    @Id
    @SequenceGenerator(name = "ACCOUNT_SEQ", sequenceName = "DEMO_SCHEMA.ACCOUNT_SEQ", allocationSize =1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACCOUNT_SEQ")

    @Column(name="ACCOUNT_TX_DETAILS_ID")
    private Long getAccountTransactionDetailsId()
    {
        return accountTransactionDetailsId;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="TX_ID")
    private AccountTransaction getAccountTransaction()
    {
        return accountTransaction;
    }
    @Column(name="PARTNER_NAME")
    private String getPartnerName()
    {
        return partnerName;
    }
    @Column(name="NUMBER_OF_TIMES")
    private Long getNumberOfTimes()
    {
        return numberOfTimes;
    }


    public AccountTransactionDetails(AccountTransaction accountTransaction, String partnerName, Long numberOfTimes)
    {
        this.accountTransaction = accountTransaction;
        this.partnerName = partnerName;
        this.numberOfTimes = numberOfTimes;
    }

    public AccountTransactionDetails(String partnerName, Long numberOfTimes)
    {
        this.partnerName = partnerName;
        this.numberOfTimes = numberOfTimes;
    }

    public void setAccountTransactionDetailsId(Long accountTransactionDetailsId) {
        this.accountTransactionDetailsId = accountTransactionDetailsId;
    }

    public void setAccountTransaction(AccountTransaction accountTransaction) {
        this.accountTransaction = accountTransaction;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public void setNumberOfTimes(Long numberOfTimes) {
        this.numberOfTimes = numberOfTimes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransactionDetails that = (AccountTransactionDetails) o;
        return Objects.equals(accountTransactionDetailsId, that.accountTransactionDetailsId) && Objects.equals(accountTransaction, that.accountTransaction) && Objects.equals(partnerName, that.partnerName) && Objects.equals(numberOfTimes, that.numberOfTimes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountTransactionDetailsId, accountTransaction, partnerName, numberOfTimes);
    }

    @Override
    public String toString() {
        return "AccountTransactionDetails{" +
                "accountTransactionDetailsId=" + accountTransactionDetailsId +
                ", accountTransaction=" + accountTransaction +
                ", partnerName='" + partnerName + '\'' +
                ", numberOfTimes=" + numberOfTimes +
                '}';
    }
}


