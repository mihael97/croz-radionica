package mihael.macuka.crozradionica.service;

import mihael.macuka.crozradionica.dto.CreateUserDto;
import mihael.macuka.crozradionica.dto.UpdateUserDto;
import mihael.macuka.crozradionica.dto.UserDto;
import mihael.macuka.crozradionica.model.User;
import mihael.macuka.crozradionica.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static List<UserDto> map(final List<User> users) {
        return users.stream().map(user -> new UserDto(user.getId(), user.getUsername())).collect(Collectors.toList());
    }

    public void createUser(final CreateUserDto userDto) {
        final String id = UUID.randomUUID().toString();
        userRepository.save(new User(id, userDto.getUsername()));
    }

    public List<UserDto> getAll() {
        return map(userRepository.findAll());
    }

    public boolean updateUser(final UpdateUserDto userDto) {
        final Optional<User> optionalUser = userRepository.findById(userDto.getId());
        if (optionalUser.isPresent()) {
            final User user = optionalUser.get();
            user.setUsername(userDto.getUsername());
            userRepository.save(user);
            return true;
        }
        return false;
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}
