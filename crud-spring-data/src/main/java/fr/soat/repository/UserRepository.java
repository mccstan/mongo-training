package fr.soat.repository;

import fr.soat.model.User;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by mccstan on 19/11/2017.
 */
//@Document(collection = "users")
public interface UserRepository extends MongoRepository<User, String> {
    public User findOneByName(String name);
}
