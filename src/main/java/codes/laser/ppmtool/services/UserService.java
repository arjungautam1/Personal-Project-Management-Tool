/**
 * @author : Arjun Gautam
 * e-mail : arjungautam5431@gmail.com
 * Date :2021-02-19
 * Time :21:20
 */
package codes.laser.ppmtool.services;

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
        newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));

        //Username has to be unique(exception)
        //Make sure that password and confirm password match
        //We don't persist or show the confirmPassword

        return userRepository.save(newUser);
    }


}
