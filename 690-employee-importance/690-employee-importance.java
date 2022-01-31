/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        // for easy employee access
        HashMap<Integer, Employee> hashMap = new HashMap<>();
        for(Employee e: employees) {
            hashMap.put(e.id, e);
        }
        
        // for dealing with calc importance
        Queue<Employee> queue = new LinkedList<>();
        queue.add(hashMap.get(id));
        // hashMap.remove(id);
        
        int rtn = 0;
        
        while(!queue.isEmpty()) {
            Employee currEmployee = queue.poll();
            rtn += currEmployee.importance;
            
            for(int i: currEmployee.subordinates) {
                // if(hashMap.containsKey(i)) {
                    queue.add(hashMap.get(i));
                    // hashMap.remove(i);
                // }
            }
        }
        
        return rtn;
    }
}