package chainframework;

import java.security.*;

public interface TransactionInterface {


    boolean processTransaction();

    float getInputsValue();

    void generateSignature(PrivateKey privateKey);

    boolean verifySignature();

    float getOutputsValue();

    String calulateHash();
}
