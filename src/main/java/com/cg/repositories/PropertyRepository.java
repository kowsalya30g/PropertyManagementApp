package com.cg.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.entities.Property;
@Repository
public interface PropertyRepository  extends JpaRepository<Property, Long>{

//   @Query(value = "select p.propertyId , p.propertyName , p.type , p.sellOrRent , p.price , p.area  From Property p ")
//   public List<Object> getALLProperty();
  
	 @Query("Select p From Property p where p.type =:ty")
	   public List<Property> findByType(@Param("ty") String type);
	     
	   @Query("Select p From Property p where p.sellOrRent =:avl")
	   public List<Property> findByAvailability(@Param("avl") String purpose);
	     
	   @Query("Select p From Property p where p.sellOrRent =:avl and p.type =:ty and p.price <=:price")
	   public List<Property> findByPrice(@Param("avl") String purpose,@Param("ty") String type,@Param("price") double price);

	   public Property findByPropertyName(String name);

}
