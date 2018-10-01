package thread;

public class MainBank {
    /**
     * 两个人AB通过一个账户A在柜台取钱和B在ATM机取钱
     * */
    public static void main(String[] args) {
        // 实力化一个银行对象
        Bank bank = new Bank();
        // 实例化两个人，传入同一个银行的对象
        PersonA pA = new PersonA(bank);
        PersonB pB = new PersonB(bank);
        // 两个人开始取钱
        pA.start();
        pB.start();
         
    }
 
}
