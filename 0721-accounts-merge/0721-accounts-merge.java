class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();

        DisjointSet ds = new DisjointSet(n);

        Map<String, Integer> emailToAcc = new HashMap<>();

        //Union accounts by common email
        for(int i=0; i<n; i++){
            for(int j=1; j<accounts.get(i).size(); j++){

                String email = accounts.get(i).get(j);

                if(!emailToAcc.containsKey(email)){
                    emailToAcc.put(email, i);
                }
                else{
                    ds.unionBySize(i, emailToAcc.get(email));
                }
            }
        }

        //Group email by ultimate parent
        Map<Integer, List<String>> mergedEmails = new HashMap<>();

        for(String email : emailToAcc.keySet()){
            int accIndex = emailToAcc.get(email);
            int parent = ds.findParent(accIndex);

            mergedEmails.putIfAbsent(parent, new ArrayList<>());
            mergedEmails.get(parent).add(email);
        }

        //Build Final answer
        List<List<String>> result = new ArrayList<>();

        for(int parent : mergedEmails.keySet()){
            List<String> emails = mergedEmails.get(parent);

            Collections.sort(emails);

            List<String> account = new ArrayList<>();
            account.add(accounts.get(parent).get(0));
            account.addAll(emails);

            result.add(account);
        }

        return result;
    }
}

class DisjointSet {
    int[] parent;
    int[] size;

    DisjointSet(int n) {
        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    int findParent(int node) {
        if (parent[node] == node) {
            return node;
        }

        parent[node] = findParent(parent[node]);
        return parent[node];
    }

    void unionBySize(int u, int v) {
        int parentU = findParent(u);
        int parentV = findParent(v);

        if (parentU == parentV) {
            return;
        }

        if (size[parentU] < size[parentV]) {
            parent[parentU] = parentV;
            size[parentV] += size[parentU];
        } else {
            parent[parentV] = parentU;
            size[parentU] += size[parentV];
        }
    }
}