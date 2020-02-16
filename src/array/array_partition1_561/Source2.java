package array.array_partition1_561;

class Solution2 {

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int i = solution2.shortestWay("abc", "abcbc");
        System.out.println("i = " + i);
    }

    public int shortestWay(String source, String target) {
        char[] sAr=source.toCharArray();
        char[] tAr=target.toCharArray();

        int[] sCount=new int[26];
        int[] tCount=new int[26];

        for(char c:sAr){
            sCount[c-'a']++;
        }
        for(char c:tAr){
            tCount[c-'a']++;
        }

        for(int i=0;i<26;i++){
            if(tCount[i]>0 && sCount[i]==0){
                return -1;
            }
        }

        int sIndex=0;
        int count=1;
        for(int i=0;i<tAr.length;i++){

            if(sIndex==sAr.length){
                sIndex=0;
                count++;
            }

            while(sAr[sIndex] != tAr[i]){
                sIndex++;

                if(sIndex==sAr.length){
                    sIndex=0;
                    count++;
                }
            }

            sIndex++;

        }
        return count;
    }
}