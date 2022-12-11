package QC_323_3;

class Allocator {
    int[] memory ;
    int[][][] map; // [mid][regionIndex][start & end]
    int[] mapIndex;
    int len;
    public Allocator(int n) {
        len = n;
        memory = new int[n];
        for (int i = 0; i < n; i++) {
            memory[i] = -1;
        }
        map = new int[1001][1001][2];
        mapIndex = new int[1001];
    }

    public int allocate(int size, int mID) {
        boolean flag = false;
        for (int i = 0; i <= len - size; i++) {
            if(memory[i] == -1){
                for (int j = 0; j < size; j++) {
                    if(memory[i+j] != -1){
                        break;
                    }
                    if(j == size-1) flag= true;
                }
                // find success
                if(flag){
                    for (int j = 0; j < size; j++) {
                        memory[i+j] = mID;
                    }
                    map[mID][mapIndex[mID]][0] = i;
                    map[mID][mapIndex[mID]][1] = i+size;
                    mapIndex[mID]++;
                    return i;
                }
            }
        }
        return -1;
    }

    public int free(int mID) {
        int cnt = 0;
        for (int i = 0; i < mapIndex[mID]; i++) {
            int start = map[mID][i][0];
            int end = map[mID][i][1];
            cnt += end - start;
            for (int j = start; j < end; j++) {
                memory[j] = -1;
            }
        }
        mapIndex[mID]=0;
        map[mID] = new int[1001][2];
        return cnt;
    }

    public static void main(String[] args) {
        Allocator loc = new Allocator(5); // 初始化一个大小为 10 的内存数组，所有内存单元都是空闲的。
        System.out.println(loc.allocate(5, 8)); // 最左侧的块的第一个下标是 2 。内存数组变为 [1,2,3, , , , , , , ]。返回 2 。
        System.out.println(loc.allocate(4,8)); // 释放 mID 为 2 的所有内存单元。内存数组变为 [1, ,3, , , , , , , ] 。返回 1 ，因为只有 1 个 mID 为 2 的内存单元。
        System.out.println(loc.allocate(3, 2)); // 最左侧的块的第一个下标是 3 。内存数组变为 [1, ,3,4,4,4, , , , ]。返回 3 。
        System.out.println(loc.free(6)); // 最左侧的块的第一个下标是 1 。内存数组变为 [1,1,3,4,4,4, , , , ]。返回 1 。
        System.out.println(loc.allocate(9, 9)); // 最左侧的块的第一个下标是 6 。内存数组变为 [1,1,3,4,4,4,1, , , ]。返回 6 。
        System.out.println(loc.free(6)); // 释放 mID 为 1 的所有内存单元。内存数组变为 [ , ,3,4,4,4, , , , ] 。返回 3 ，因为有 3 个 mID 为 1 的内存单元。
    }

    //正确答案：0, 1, 2, 1, 3, 1, 6, 3, -1, 0
}
