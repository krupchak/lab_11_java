package org.o7planning.sbhibernate.form;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.o7planning.sbhibernate.exception.BankTransactionException;
import org.o7planning.sbhibernate.dao.BankAccountDAO;


public class SendMoneyForm {
    private Long fromAccountId;
    private Long toAccountId;
    private Double amount;

    public SendMoneyForm() {
    }
    public SendMoneyForm(Long fromAccountId, Long toAccountId, Double amount) {
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.amount = amount;
    }

    public Long getFromAccountId() {
        return fromAccountId;
    }
    public void setFromAccountId(Long fromAccountId) {
        this.fromAccountId = fromAccountId;
    }
    public Long getToAccountId() {
        return toAccountId;
    }
    public void setToAccountId(Long toAccountId) {
        this.toAccountId = toAccountId;
    }
    public Double getAmount() {
        return amount;
    }
    public void setAmount(Double amount) {
        this.amount = amount;
    }

@Transactional(propagation = Propagation.REQUIRES_NEW,
                         rollbackFor = BankTransactionException.class)
public void sendMoney(Long fromAccountId, Long toAccountId,
                       double amount) throws BankTransactionException {
    addAmount(toAccountId, amount);
    addAmount(fromAccountId, -amount);
}
private void addAmount(Long fromAccountId2, double d) {
	// TODO Auto-generated method stub
	
}
}
