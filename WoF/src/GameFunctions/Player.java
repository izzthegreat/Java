package GameFunctions;
class Player {
    private String name;
    private int wallet=0, bank=0;

    Player(String name){ this.name = name; }

    void printStatus(){ System.out.println(name + " - $" + wallet); }

    String getName() { return name; }

    int getWallet() { return wallet; }

    void setWallet(int wallet) { this.wallet = wallet; }

    void gainMoney(int winnings) { this.wallet += winnings; }

    void spendMoney(int cost) { this.wallet -= cost; }

    int getBank() { return bank; }

    void walletToBank() { this.bank += Math.max(wallet, 1000); }
}