package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "DEMO_ACCOUNT_TYPE",schema = "VITRSA_SANDBOX")
public class AccountType implements Serializable {
    private static final long serialVersionUID = -2282337104058330818L;

    private Long accountTypeId;
    private String mnemonic;
    private String accountTypeName;
    private LocalDate creationDate;

    private Set<AccountTransaction> accountTransactions;

    public AccountType(String mnemonic, String accountTypeName, LocalDate creationDate){}
    public AccountType(Long accountTypeId,String mnemonic,String accountTypeName,LocalDate creationDate)
    {
        this.accountTypeId = accountTypeId;
        this.accountTypeName = accountTypeName;
        this.mnemonic = mnemonic;
        this.creationDate = creationDate;
    }

    public AccountType() {

    }

    @Id
    @SequenceGenerator(name = "VIT_RSA_GENERIC_SEQ", sequenceName = "VITRSA_SANDBOX.VIT_RSA_GENERIC_SEQ", allocationSize =1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VIT_RSA_GENERIC_SEQ")

    @Column(name = "ACCOUNT_TYPE_ID")
    public Long getAccountTypeId()
    {
        return accountTypeId;
    }
    @Column(name="ACCOUNT_TYPE_NAME")
    public String getAccountTypeName() {
        return accountTypeName;
    }
    @Column(name="MNEMONIC")
    public String getMnemonic() {
        return mnemonic;
    }
    @Column(name="CREATION_DATE")
    public LocalDate getCreationDate() {
        return creationDate;
    }

    @OneToMany(targetEntity = AccountTransaction.class, fetch = FetchType.LAZY, mappedBy = "accountType", orphanRemoval = true, cascade = CascadeType.PERSIST)
    public Set<AccountTransaction> getAccountTransactions() {
        return accountTransactions;
    }

    public void setAccountTransactions(Set<AccountTransaction> accountTransactions) {
        this.accountTransactions = accountTransactions;
    }

    public void setAccountTypeId(Long accountTypeId) {
        this.accountTypeId = accountTypeId;
    }
    public void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
    }
    public void setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }
    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountType that = (AccountType) o;
        return Objects.equals(accountTypeId, that.accountTypeId) && Objects.equals(mnemonic, that.mnemonic) && Objects.equals(accountTypeName, that.accountTypeName) && Objects.equals(creationDate, that.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountTypeId, mnemonic, accountTypeName, creationDate);
    }

    @Override
    public String toString() {

        return "AccountType{" +
                "accountTypeId=" + accountTypeId +
                ", mnemonic='" + mnemonic + '\'' +
                ", accountTypeName='" + accountTypeName + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
