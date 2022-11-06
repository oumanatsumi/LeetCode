package Q2456;

import java.util.*;


public class Solution {
    static class Creator{
        String name;
        int maxViews;

        public Creator(String name,int maxViews){
            this.name = name;
            this.maxViews = maxViews;
        }
    }

    Map<String, Integer> totalPlayMap = new HashMap<>();
    Map<String, Integer> maxPlayMap = new HashMap<>();
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        int n = creators.length;
        for (int i = 0; i < n; i++) {
            totalPlayMap.put(creators[i],totalPlayMap.getOrDefault(creators[i],0)+views[i]);
            if(maxPlayMap.containsKey(creators[i])){
                int viewIndex = maxPlayMap.get(creators[i]);
                if(views[viewIndex] < views[i]){
                    maxPlayMap.put(creators[i],i);
                }else if(views[viewIndex] == views[i]){
                    if(ids[viewIndex].compareTo(ids[i])>0){
                        maxPlayMap.put(creators[i],i);
                    }
                }
            }else {
                maxPlayMap.put(creators[i],i);
            }
        }
        List<Creator> creatorList = new ArrayList<>();
        for(String s : totalPlayMap.keySet()){
            creatorList.add(new Creator(s,totalPlayMap.get(s)));
        }
        Collections.sort(creatorList, new Comparator<Creator>() {
            @Override
            public int compare(Creator o1, Creator o2) {
                return o1.maxViews - o2.maxViews;
            }
        });
        List<List<String>> ans = new ArrayList<>();
        int maxView = creatorList.get(creatorList.size()-1).maxViews;
        int curIndex = creatorList.size()-1;
        while(curIndex >= 0 && creatorList.get(curIndex).maxViews == maxView){
            List<String> temp = new ArrayList<>();
            temp.add(creatorList.get(curIndex).name);
            temp.add(ids[maxPlayMap.get(creatorList.get(curIndex).name)]);
            ans.add(temp);
            curIndex--;
        }
        return ans;
    }


}

