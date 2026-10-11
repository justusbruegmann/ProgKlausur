
import java.util.List;

/**
 * Interface that defines a corona warn client
 */
public interface CoronaWarnClient {
    /**
     * Invoked whenever a token was received by the API
     * @param token the token
     */
    void tokenReceived(Token token);

    /**
     * Get the current token
     * @return current token
     */
    Token getCurrentToken();

    /**
     * Get all tokens that this client had
     * @return all tokens that this client had
     */
    List<Token> getAllTokens();

    /**
     * Get all tokens that this client had contact with
     * @return all tokens that this client had contact with
     */
    List<Token> getAllSeenTokens();
}
