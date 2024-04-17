package com.example.demo.AboutEvent.Service;

import com.example.demo.AboutEvent.Models.*;
import com.example.demo.AboutEvent.Repository.RevenuRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RevenuServiceImpl implements RevenuService{
    private static final Logger logger = LogManager.getLogger(RevenuServiceImpl.class);

    public final RevenuRepository revenuRepository;
    public RevenuServiceImpl(RevenuRepository revenuRepository)
    {this.revenuRepository=revenuRepository;}

    @Override
    public Revenu getRevenutbyId(Integer id) {
        logger.info("Getting Revenu with id {}",id);
        Optional<Revenu> optionalRevenu = revenuRepository.findById(id);
        Revenu r = optionalRevenu.orElse(null);
        if (r==null) {
            logger.warn("Revenu with id {} not found", id);
            return r;
        }return r;
    }

    @Override
    public Revenu createRevenu(Revenu R) {
        logger.info("Creating revenu {}", R);
        revenuRepository.save(R);
        return R;
    }

    @Override
    public Revenu updateRevenu(Integer id, Revenu r) {
        logger.info("Updating revenu with id {}",id);
        if (revenuRepository.existsById(id)) {
            r.setId(id);
            return revenuRepository.save(r);
        }
        logger.warn("Revenu with id {} not found",id);
        return null; 
    }

    @Override
    public void deleteRevenu(Integer id) {
        logger.info("Deleting revenu with id {}",id);
        revenuRepository.deleteById(id);

    }
}
