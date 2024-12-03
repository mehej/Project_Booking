package com.synergy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.synergy.domain.Guest;


@Repository
public interface GuestRepository extends JpaRepository<Guest,Integer> {

}
