class MyQueue {

public:
    vector<int> vec;
    MyQueue() {
         vector<int> vec;
        this->vec = vec;
       
    }
    
    void push(int x) {
        this->vec.push_back(x);
    }
    
    int pop() {
        int ret = this->vec[0];
        this->vec.erase(this->vec.begin());
        return ret;
    }
    
    int peek() {
        return this->vec[0];
    }
    
    bool empty() {
        if(this->vec.size()!=0){
            return false;
        }else{
            return true;
        }
    }
};

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue* obj = new MyQueue();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->peek();
 * bool param_4 = obj->empty();
 */