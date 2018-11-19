package chainframework;
import jblockchain.Transaction;

public interface BlockInterface {

    //Calculate new hash based on blocks contents
    String calculateHash();

    //Increases nonce value until hash target is reached.
    void mineBlock(int difficulty);

    //Add transactions to this block
    boolean addTransaction(Transaction transaction);

}
