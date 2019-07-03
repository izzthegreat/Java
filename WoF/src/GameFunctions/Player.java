package GameFunctions;
class Player {
    private String name;
    private int wallet=0, bank=0;

    Player(String name){ this.name = name; }

    void printStatus(){ System.out.println(name + " - $" + wallet); }

    String getName() { return name; }

    int getWallet() { return wallet; }

    void bankrupt() { this.wallet = 0; }

    void gainMoney(int winnings) { this.wallet += winnings; }

    void spendMoney() { this.wallet -= 250; }

    int getBank() { return bank; }

    void walletToBank() { this.bank += Math.max(wallet, 1000); }
}