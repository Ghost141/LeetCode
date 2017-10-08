package traing.common;

import java.util.List;

/**
 * The common Employee class.
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 10/8/17
 */
public class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
}
