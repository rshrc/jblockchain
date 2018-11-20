package chainframework;

import java.security.PublicKey;

public interface TransactionOutputInterface {
    boolean isMine(PublicKey publicKey);
}
