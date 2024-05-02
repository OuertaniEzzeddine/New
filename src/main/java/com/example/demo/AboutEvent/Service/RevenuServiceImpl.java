package com.example.demo.AboutEvent.Service;

import com.example.demo.AboutEvent.Models.*;
import com.example.demo.AboutEvent.Repository.RevenuRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RevenuServiceImpl implements RevenuService {

    public final RevenuRepository revenuRepository;

    public RevenuServiceImpl(RevenuRepository revenuRepository) {
        this.revenuRepository = revenuRepository;
    }

    @Override
    public Revenu getRevenutbyId(Integer id) {
        Optional<Revenu> optionalRevenu = revenuRepository.findById(id);
        return optionalRevenu.orElse(null);
    }

    @Override
    public Revenu createRevenu(Revenu revenu) {
        if (revenu == null) {
            throw new IllegalArgumentException("Revenu cannot be null");
        }
        revenuRepository.save(revenu);
        return revenu;
    }

    @Override
    public Revenu updateRevenu(Integer id, Revenu revenu) {
        if (!revenuRepository.existsById(id)) {
            throw new IllegalArgumentException("Revenu with id " + id + " not found for update");
        }
        revenu.setId(id);
        return revenuRepository.save(revenu);
    }

    @Override
    public void deleteRevenu(Integer id) {
        if (!revenuRepository.existsById(id)) {
            throw new IllegalArgumentException("Revenu with id " + id + " not found for deletion");
        }
        revenuRepository.deleteById(id);
    }
}
