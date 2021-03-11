/**
 * @author : Arjun Gautam
 * e-mail : arjungautam5431@gmail.com
 * Date :2021-03-11
 * Time :07:30
 */
package codes.laser.ppmtool.payload;

public class JWTLoginSuccessResponse {
    private boolean success;
    private String token;

    public JWTLoginSuccessResponse(boolean success, String token) {
        this.success = success;
        this.token = token;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "JWTLoginSuccessResponse{" +
                "success=" + success +
                ", token='" + token + '\'' +
                '}';
    }
}
