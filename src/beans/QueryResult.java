package beans;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
/**
 * A class for handling query results ()
 * @param result - if the query were successful
 * @param exceptionID - if the query weren't successful the exceptionID will showcase the correct exception
 */
public class QueryResult {
    private final boolean result;
    private final int exceptionID;
}
