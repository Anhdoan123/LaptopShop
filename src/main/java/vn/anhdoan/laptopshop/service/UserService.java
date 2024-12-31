package vn.anhdoan.laptopshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import vn.anhdoan.laptopshop.domain.User;
import vn.anhdoan.laptopshop.domain.dto.RegisterDTO;
import vn.anhdoan.laptopshop.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User handleSaveUser(User user) {
        return this.userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    public void deleteUserById(long id) {
        this.userRepository.deleteById(id);
    }

    public Optional<User> getUserById(long id) {
        return this.userRepository.findById(id);
    }

    public User RegisterDTOToUser(RegisterDTO registerDTO) {
        User user = new User();
        user.setFullName(registerDTO.getFirstName() + " " + registerDTO.getLastName());
        user.setPassword(registerDTO.getPassword());
        user.setEmail(registerDTO.getEmail());
        return user;
    }

    public boolean checkEmailExists(String email) {
        return this.userRepository.existsByEmail(email);
    }

    public User getUserByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }

}
