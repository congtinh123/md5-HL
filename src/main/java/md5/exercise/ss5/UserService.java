package md5.exercise.ss5;
public interface UserService {
    ReqRes signUp(ReqRes request);
    ReqRes signIn(ReqRes request);
    ReqRes refreshToken(ReqRes request);
    ReqRes updateUserInfo(ReqRes request);
    ReqRes changePassword(String oldPassword, String newPassword, String confirmPassword);
}
