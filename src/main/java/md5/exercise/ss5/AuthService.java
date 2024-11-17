package md5.exercise.ss5;
import md5.exercise.ss5.config.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class AuthService implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JWTUtils jwtUtils;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public ReqRes signUp(ReqRes request) {
        ReqRes reqRes = new ReqRes();
        try{
            User user = new User();
            user.setEmail(request.getEmail());
            user.setRole(request.getRole());
            user.setPassword(passwordEncoder.encode(request.getPassword()));
            User userResult = userRepository.save(user);
            if (userResult!=null && userResult.getUserId() > 0){
                reqRes.setUsers(userResult);
                reqRes.setStatusCode(201);
                reqRes.setMessage("User created successfully.");
            }
        }catch (Exception e){
            reqRes.setStatusCode(500);
            reqRes.setMessage(e.getMessage());
        }
        return reqRes;
    }

    @Override
    public ReqRes signIn(ReqRes request) {
        ReqRes response = new ReqRes();

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword()));
            var user = userRepository.findByEmail(request.getEmail()).orElseThrow();
            System.out.println("USER IS: "+ user);
            var jwt = jwtUtils.generateToken(user);
            var refreshToken = jwtUtils.generateRefreshToken(new HashMap<>(), user);
            response.setStatusCode(200);
            response.setToken(jwt);
            response.setRefreshToken(refreshToken);
            response.setExpirationTime("24Hr");
            response.setMessage("Successfully Signed In");
        }catch (Exception e){
            response.setStatusCode(500);
            response.setError(e.getMessage());
        }
        return response;
    }

    @Override
    public ReqRes refreshToken(ReqRes request) {
        ReqRes response = new ReqRes();
        String ourEmail = jwtUtils.extractUsername(request.getToken());
        User users = userRepository.findByEmail(ourEmail).orElseThrow();
        if (jwtUtils.isTokenValid(request.getToken(), users)) {
            var jwt = jwtUtils.generateToken(users);
            response.setStatusCode(200);
            response.setToken(jwt);
            response.setRefreshToken(request.getToken());
            response.setExpirationTime("24Hr");
            response.setMessage("Successfully Refreshed Token");
        }
        response.setStatusCode(500);
        return response;
    }

    @Override
    public ReqRes updateUserInfo(ReqRes request) {
        ReqRes response = new ReqRes();
        try {
            // Tìm người dùng trong database dựa vào email
            User user = userRepository.findByEmail(request.getEmail()).orElseThrow(() -> new RuntimeException("User not found"));

            // Cập nhật thông tin người dùng (tên, email, v.v.)
            if (request.getName() != null && !request.getName().isEmpty()) {
                user.setName(request.getName());
            }

            if (request.getEmail() != null && !request.getEmail().isEmpty()) {
                user.setEmail(request.getEmail());
            }

            // Lưu người dùng đã cập nhật vào database
            userRepository.save(user);
            response.setStatusCode(200);
            response.setMessage("User information updated successfully.");
            response.setUsers(user);
        } catch (Exception e) {
            response.setStatusCode(500);
            response.setError("Failed to update user information: " + e.getMessage());
        }
        return response;
    }


    @Override
    public ReqRes changePassword(String oldPassword, String newPassword, String confirmPassword) {
        ReqRes response = new ReqRes();
        try {
            // Lấy người dùng hiện tại dựa vào email
            var user = userRepository.findByEmail(jwtUtils.extractUsername(jwtUtils.getCurrentUserToken()))
                    .orElseThrow(() -> new RuntimeException("User not found"));

            // Kiểm tra mật khẩu cũ có đúng không
            if (!passwordEncoder.matches(oldPassword, user.getPassword())) {
                response.setStatusCode(400);
                response.setError("Old password is incorrect.");
                return response;
            }

            // Kiểm tra mật khẩu mới và confirm có khớp không
            if (!newPassword.equals(confirmPassword)) {
                response.setStatusCode(400);
                response.setError("New password and confirm password do not match.");
                return response;
            }

            // Cập nhật mật khẩu mới
            user.setPassword(passwordEncoder.encode(newPassword));
            userRepository.save(user);

            response.setStatusCode(200);
            response.setMessage("Password changed successfully.");
        } catch (Exception e) {
            response.setStatusCode(500);
            response.setError("Failed to change password: " + e.getMessage());
        }
        return response;
    }

}
