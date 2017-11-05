package traing.prob721;

import java.util.*;

/**
 * Accounts Merge
 * Link:
 *
 * @author zhaokai
 * @version 1.0
 * @since 1.0 - 11/5/17
 */
public class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Account> map = new HashMap<>();
        for (List<String> list : accounts) {
            String name = list.get(0);
            Account account = new Account(name, list);
            for (int i = 1; i < list.size(); i++) {
                String email = list.get(i);
                if (map.containsKey(email)) {
                    Account exAcc = map.get(email);
                    account.emails.addAll(exAcc.emails);
                }
            }
            for (String s : account.emails) map.put(s, account);
        }
        List<List<String>> res = new ArrayList<>();
        List<String> keyList = new ArrayList<>(map.keySet());
        for (String key : keyList) {
            if (map.containsKey(key)) {
                Account account = map.get(key);
                List<String> list = new ArrayList<>();
                list.add(account.name);
                List<String> emails = new ArrayList<>(account.emails);
                Collections.sort(emails);
                list.addAll(emails);
                res.add(list);
                for (String email : account.emails) map.remove(email);
            }
        }
        return res;
    }

    class Account {
        String name;
        Set<String> emails;

        public Account(String name, List<String> list) {
            this.name = name;
            emails = new HashSet<>();
            for (int i = 1; i < list.size(); i++) emails.add(list.get(i));
        }
    }
}
