class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<String>();
        int pointer = 0;
        helper(s.toCharArray(), pointer , ans);
        return ans;
    }
    void helper(char[] arr ,int pointer ,  List<String> ans){
            if(pointer == arr.length){
                ans.add(new String(arr));
                return;
            }
            if(Character.isLetter(arr[pointer])){
                if(Character.isUpperCase(arr[pointer])){
                    arr[pointer] = Character.toLowerCase(arr[pointer]);
                helper(arr , pointer+1 , ans);
                arr[pointer] = Character.toUpperCase(arr[pointer]);
                }
                else{
                    arr[pointer] = Character.toUpperCase(arr[pointer]);
                    helper(arr, pointer+1 , ans);
                    arr[pointer] = Character.toLowerCase(arr[pointer]);
                }
            }
            helper(arr , pointer+1 , ans);
                
    }
}