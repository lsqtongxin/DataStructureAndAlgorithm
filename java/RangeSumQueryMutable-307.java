// 线段树，底层是链表
class NumArray {  
    class Node{
        int start,end;
        int sum;
        Node left;
        Node right;
        public Node(int start,int end)
        {
            this.start=start;
            this.end=end;
            sum=0;
            this.left=this.right=null;
        }
    }
    Node root=null;
    public NumArray(int[] nums) {
        
       root=buildSegmentTree(nums,0,nums.length-1);
    }
    
    private Node buildSegmentTree(int[] nums,int l,int r)
    {
        if(l>r)return null;
        else if(l==r){
            Node ret=new Node(l,r);
            ret.sum=nums[l];
            return ret;
        }else{
            Node ret=new Node(l,r);
            int mid=l+(r-l)/2;
            
            ret.left= buildSegmentTree(nums,l,mid);
            ret.right=buildSegmentTree(nums,mid+1,r);
            ret.sum=ret.left.sum+ret.right.sum;
            return ret;
        }   
    }
    
    public void update(int i, int val) {
        
        set(root,i,val);
        
    }
    
    private void set(Node node,int i,int val)
    {
        if(node.left==null && node.right==null)
        {
            node.sum=val;
            return;
        }
        
        int mid=node.start+(node.end-node.start)/2;
        if(i<=mid){
            set(node.left,i,val);
        }else if(mid+1<=i)
        {
            set(node.right,i,val);
        }
        
        node.sum=node.left.sum+node.right.sum;    
    }
    private int query(Node node,int queryL,int queryR)
    {
        if(node.start==queryL && node.end==queryR)return node.sum;
        
        int mid=node.start+(node.end-node.start)/2;
        
        if(queryL>=mid+1)
        {
            return query(node.right,queryL,queryR);
        }
        
        if(queryR<=mid)
        {
            return query(node.left,queryL,queryR);
        }
        
        int left=query(node.left,queryL,mid);
        int right=query(node.right,mid+1,queryR);
        return left+right;
    }
    
    public int sumRange(int i, int j) {
        return query(root,i,j);
    }
}

// 线段树，底层是数组
class NumArray {
    private int[] data;
    private int[] tree;
    public NumArray(int[] nums) {
        
        data=new int[nums.length];
        tree=new int[4*nums.length];
        for(int i=0;i<nums.length;i++)
        {
            data[i]=nums[i];
        }
    
        buildSegmentTree(0,0,nums.length-1);
    }
    
    private int leftChildren(int index)
    {
        return 2*index+1;
    }
    
    private int rightChildren(int index)
    {
        return 2*index+2;
    }
    
    private void buildSegmentTree(int TreeIndex,int l,int r)
    {
        if(l==r)
        {
            tree[TreeIndex]=data[l];
            return;
        }
        
        int m=l+(r-l)/2;
        int left=leftChildren(TreeIndex);
        int right=rightChildren(TreeIndex);
        buildSegmentTree(left,l,m);
        buildSegmentTree(right,m+1,r);
        tree[TreeIndex]=tree[left]+tree[right];
    }
    public void update(int i, int val) {
        
        data[i]=val;
        set(0,0,data.length-1,i,val);
        
    }
    private void set(int treeIndex,int l,int r,int i,int val)
    {
        if(l==r)
        {
            tree[treeIndex]=val;
            return;
        }
        int mid=l+(r-l)/2;
        
        int left=leftChildren(treeIndex);
        int right=rightChildren(treeIndex);
        
        if(i<=mid)
        {
           set(left,l,mid,i,val); 
        }
        if(i>=mid+1)
        {
           set(right,mid+1,r,i,val); 
        }
        
        tree[treeIndex]=tree[left]+tree[right];        
    }
    private int query(int treeIndex,int l,int r,int queryL,int queryR)
    {
        
        if(l==queryL && r==queryR)return tree[treeIndex];
        
        int m=l+(r-l)/2;
        int left=leftChildren(treeIndex);
        int right=rightChildren(treeIndex);
        
        if(queryL>=m+1)
        {
           return query(right,m+1,r,queryL,queryR); 
        }
        
        if(queryR<=m)
        {
            return query(left,l,m,queryL,queryR);
        }
        int lChild=query(left,l,m,queryL,m);
        int rChild=query(right,m+1,r,m+1,queryR);
        return lChild+rChild;
    }
    public int sumRange(int i, int j) {
        return query(0,0,data.length-1,i,j);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */

 class NumArray {
    private int[] data;
    private int[] tree;    
    public NumArray(int[] nums) {
        
        data=new int[nums.length];
        tree=new int[4*nums.length];
        for(int i=0;i<nums.length;i++)
        {
            data[i]=nums[i];
        }
    
        buildSegmentTree(0,0,nums.length-1);
    }
    
    private int leftChildren(int index)
    {
        return 2*index+1;
    }
    
    private int rightChildren(int index)
    {
        return 2*index+2;
    }
    
    private void buildSegmentTree(int TreeIndex,int l,int r)
    {
        if(l==r)
        {
            tree[TreeIndex]=data[l];
            return;
        }
        int m=l+(r-l)/2;
        int left=leftChildren(TreeIndex);
        int right=rightChildren(TreeIndex);
        buildSegmentTree(left,l,m);
        buildSegmentTree(right,m+1,r);
        tree[TreeIndex]=tree[left]+tree[right];
    }
    
    
    public void update(int i, int val) {
        data[i]=val;
        set(0,0,data.length-1,i,val);
    }
    
    private void set(int treeIndex,int l,int r,int i,int val)
    {
        if(l==r)
        {
            tree[treeIndex]=val;
            return;
        }
        int mid=l+(r-l)/2;
        
        int left=leftChildren(treeIndex);
        int right=rightChildren(treeIndex);
        
        if(i<=mid)
        {
           set(left,l,mid,i,val); 
        }
        if(i>=mid+1)
        {
           set(right,mid+1,r,i,val); 
        }
        
        tree[treeIndex]=tree[left]+tree[right];        
    }
    
    
    private int query(int treeIndex,int l,int r,int queryL,int queryR)
    {
        
        if(l==queryL && r==queryR)return tree[treeIndex];
        
        int m=l+(r-l)/2;
        int left=leftChildren(treeIndex);
        int right=rightChildren(treeIndex);
        
        if(queryL>=m+1)
        {
           return query(right,m+1,r,queryL,queryR); 
        }
        
        if(queryR<=m)
        {
            return query(left,l,m,queryL,queryR);
        }
        int lChild=query(left,l,m,queryL,m);
        int rChild=query(right,m+1,r,m+1,queryR);
        return lChild+rChild;
    }
    
    
    public int sumRange(int i, int j) {
        return query(0,0,data.length-1,i,j);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */

// RMQ问题： 树状数组
