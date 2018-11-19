package chainframework;

import jblockchain.Transaction;

import java.security.PublicKey;

public interface WalletInterface {
    void generateKeyPair();

    float getBalance();

    Transaction sendFunds(PublicKey _recipient, float value);
}
