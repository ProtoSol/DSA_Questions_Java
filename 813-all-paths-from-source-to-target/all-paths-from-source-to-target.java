class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> currentPath=new ArrayList<>();
        currentPath.add(0);
        int length=graph.length;
        recSol(res,0,length-1,graph,currentPath);
        return res;
    }
    public void recSol(List<List<Integer>> resList,int currentNode,int destinationNode,int[][] graph ,List<Integer> currentPath ){
            if(currentNode == destinationNode){
                List<Integer> finalPath=new ArrayList<>();
                finalPath.addAll(currentPath);
                resList.add(finalPath);
            }else{
                int[] childNode=graph[currentNode];
                for(int temp:childNode){
                    currentPath.add(temp);
                    recSol(resList,temp,destinationNode,graph,currentPath);                    
                    currentPath.remove(currentPath.size()-1);
                }
            }
    }
}