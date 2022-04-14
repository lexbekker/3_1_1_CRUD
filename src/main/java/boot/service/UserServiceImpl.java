package boot.service;

import boot.entity.User;
import boot.repo.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(User user) {
        repository.save(user);
    }

    @Override
    public List<User> index() {
        return repository.findAll();
    }

    @Override
    public User show(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void update(Long id, User updatedUser) {
        updatedUser.setId(id);
        repository.saveAndFlush(updatedUser);

    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);

    }
}
