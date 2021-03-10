/**
 * @author : Arjun Gautam
 * e-mail : arjungautam5431@gmail.com
 * Date :2021-02-19
 * Time :21:20
 */
package codes.laser.ppmtool.services;

import codes.laser.ppmtool.exceptions.UsernameAlreadyExistsException;
import codes.laser.ppmtool.model.User;
import codes.laser.ppmtool.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User saveUser(User newUser) {

        try {
            newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));

            //Username has to be unique(exception)
            newUser.setUsername(newUser.getUsername());

            //Make sure that password and confirm password match
            //We don't persist or show the confirmPassword

            newUser.setConfirmPassword("");

            return userRepository.save(newUser);
        } catch (Exception e) {
            throw new UsernameAlreadyExistsException("Username'" + newUser.getUsername() + "'already exists");
        }
    }


}
