package com.mkyong.Service;

import com.mkyong.Models.Call;
import com.mkyong.Repository.CallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CallService implements ServiceInterface<Call> {

    @Autowired
    private CallRepository callRepository;

    public void insert(Call call){
        callRepository.save(call);
    }

    @Override
    public Call findById(Integer id) {
        return null;
    }

    @Override
    public List<Call> findAll() {
        return callRepository.findAll();
    }

    public void remove(Integer id ){

        callRepository.delete(id);
    }
}
