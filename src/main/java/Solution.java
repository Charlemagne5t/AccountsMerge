import java.util.*;

public class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < accounts.size(); i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                List<Integer> list = map.getOrDefault(accounts.get(i).get(j), new ArrayList<>());
                list.add(i);
                map.put(accounts.get(i).get(j), list);
            }
        }
//        System.out.println(map);
        UnionFind uf = new UnionFind(accounts.size());
        for (int i = 0; i < accounts.size(); i++) {
            for (int j = 1; j < accounts.get(i).size() ; j++) {
                List<Integer> connected = map.get(accounts.get(i).get(j));
                for(int x : connected){
                    uf.unify(i, x);
                }
            }
        }
        List<List<String>> result = new ArrayList<>();
        for(int i = 0; i < accounts.size(); i++){
            result.add(new ArrayList<>());
        }
        for(int i = 0; i < uf.parent.length; i++){
            int parent = uf.find(i);
            List<String> account = result.get(parent);
            if(account.isEmpty()){
                account.add(accounts.get(uf.parent[i]).get(0));
            }
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);
                if (!account.contains(email)) {
                    account.add(email);
                }
            }
        }
        result.removeIf(List::isEmpty);
        for (int i = 0; i < result.size(); i++) {
            sort(result.get(i));
        }
//        System.out.println(Arrays.toString(uf.parent));
//        System.out.println(result);

        return result;
    }
    private void sort(List<String> arrayList) {
        List<String> sublist = arrayList.subList(1, arrayList.size());
        Collections.sort(sublist);

        ArrayList<String> result = new ArrayList<>();
        result.add(arrayList.get(0));
        result.addAll(sublist);

        arrayList.clear();
        arrayList.addAll(result);
    }
}
class UnionFind {
    int edges;
    int[] parent;
    int[] sizes;
    int numberOfElements;

    public UnionFind(int edges) {
        this.edges = edges;
        parent = new int[edges];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        sizes = new int[edges];
        Arrays.fill(sizes, 1);
        numberOfElements = edges;

    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public boolean isConnected(int node1, int node2) {
        return find(node1) == find(node2);
    }

    public int find(int p) {

        int root = p;
        while (root != parent[root]) root = parent[root];

        while (p != root) {
            int next = parent[p];
            parent[p] = root;
            p = next;
        }

        return root;
    }

    public boolean unify(int node1, int node2) {
        if (isConnected(node1, node2)) {
            return false;
        }

        int parent1 = find(node1);
        int parent2 = find(node2);

        if (sizes[parent1] < sizes[parent2]) {
            sizes[parent2] += sizes[parent2];
            parent[parent1] = parent2;
            sizes[parent1] = 0;
        } else {
            sizes[parent1] += sizes[parent2];
            parent[parent2] = parent1;
            sizes[parent2] = 0;
        }
        numberOfElements--;
        return true;
    }

}