package chainframework;

import jblockchain.StringUtil;
import jblockchain.Transaction;

import java.util.ArrayList;
import java.util.Date;

interface BlockInterface {

    //Calculate new hash based on blocks contents
    public String calculateHash();

    //Increases nonce value until hash target is reached.
    public void mineBlock(int difficulty);

    //Add transactions to this block
    public boolean addTransaction(Transaction transaction);

}
