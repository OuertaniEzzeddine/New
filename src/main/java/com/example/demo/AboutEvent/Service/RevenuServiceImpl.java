package com.example.demo.AboutEvent.Service;

import com.example.demo.AboutEvent.Models.*;
import com.example.demo.AboutEvent.Repository.RevenuRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public class RevenuServiceImpl implements RevenuService{
    public final RevenuRepository revenuRepository;
    public RevenuServiceImpl(RevenuRepository revenuRepository)
    {this.revenuRepository=revenuRepository;}

    @Override
    public Revenu getRevenutbyId(Integer id) {
        Optional<Revenu> optionalRevenu = revenuRepository.findById(id);
        return optionalRevenu.orElse(null);
    }

    @Override
    public Revenu createRevenu(Revenu R) {
        revenuRepository.save(R);
        return R;
    }

    @Override
    public Revenu updateRevenu(Integer id, Revenu r) {
        if (revenuRepository.existsById(id)) {
            r.setId(id);
            return revenuRepository.save(r);
        }
        return null; // Or throw an exception
    }

    @Override
    public void deleteRevenu(Integer id) {
        revenuRepository.deleteById(id);

    }
}
