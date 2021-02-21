package com.ourkart.dao;

import com.ourkart.model.MediaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MediaModelRepository extends JpaRepository<MediaModel, Long> {
}
