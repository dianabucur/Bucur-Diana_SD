package com.mkyong.Models;

import java.util.Iterator;
import java.util.List;

public class CallIterator implements Iterator<Call> {

    private List<Call> calls;
    private int index = 0;

    public CallIterator(List<Call> calls){
        this.calls = calls;
    }

    @Override
    public boolean hasNext() {
        if (index < calls.size()){
            return true;
        }
        return false;
    }

    @Override
    public Call next() {
        if(this.hasNext()){
            return calls.get(index++);
        }
        return null;
    }
}
