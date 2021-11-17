package co.edu.mintic.ciclo4.minticciclo4.service;

import co.edu.mintic.ciclo4.minticciclo4.model.User;
import co.edu.mintic.ciclo4.minticciclo4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {

        var it = repository.findAll();
        var users = new ArrayList<User>();
        it.forEach(client -> users.add(client));
        return users;
    }

    public Optional<User> getUser(int id) {
        return repository.findById(id);
    }

    public User save(User user) {
        if(user.getId() == null) {
            return repository.save(user);
        } else {
            Optional<User> result = repository.findById(user.getId());
            if(result.isEmpty()) {
                return repository.save(user);
            } else {
                return user;
            }
        }
    }

    public User update(User user) {

        if(user.getId() == null) {
            return repository.save(user);
        } else {
            Optional<User> result = repository.findById(user.getId());
            if(result.isPresent()) {

                User existing = result.get();
                existing.setEmail(Optional.of(user.getEmail()).orElse(existing.getEmail()));
                existing.setPassword(Optional.of(user.getPassword()).orElse(existing.getPassword()));
                existing.setName(Optional.of(user.getName()).orElse(existing.getName()));

                return repository.save(existing);
            } else {
                return user;
            }
        }
    }

    public boolean delete(int id) {

        repository.deleteById(id);
        return true;
    }
}