package com.mkyong.Service;

import com.mkyong.Models.Call;
import com.mkyong.Models.Medicine;

import java.util.List;

public interface ServiceInterface<T> {

   void insert(T obj);
   T findById(Integer id);
   List<T> findAll();
   void remove(Integer id);

}
