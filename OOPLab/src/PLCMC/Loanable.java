package PLCMC;

import java.time.LocalDate;

interface Loanable {
    int loanLength = 0;
    LocalDate dueDate;
    boolean isOverdue = false;
    default void checkout(){
        dueDate = LocalDate.now().plusDays(loanLength);
    }

}
