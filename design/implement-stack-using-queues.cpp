class MyStack {
    
public:
    vector<int> vec;
    
    MyStack() {
      vector<int> vec;
        this->vec = vec;
    }
    
    void push(int x) {
        this->vec.push_back(x);
    }
    
    int pop() {
        int last = this->vec[this->vec.size()-1];
        this->vec.pop_back();
        return last;
    }
    
    int top() {
        return this->vec[this->vec.size()-1];
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
 * Your MyStack object will be instantiated and called as such:
 * MyStack* obj = new MyStack();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->top();
 * bool param_4 = obj->empty();
 */