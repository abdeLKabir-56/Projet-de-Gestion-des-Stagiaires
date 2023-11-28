package LoginGoogle;

public class Constants {
	public static String GOOGLE_CLIENT_ID = "273113573870-45u4eu77is37qg753rj0slgrdng9g539.apps.googleusercontent.com";

	public static String GOOGLE_CLIENT_SECRET = "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";

	public static String GOOGLE_REDIRECT_URI = "http://localhost:8081/Login_registration_j2ee/LoginGoogleHandler";

	public static String GOOGLE_LINK_GET_TOKEN = "https://accounts.google.com/o/oauth2/token";

	public static String GOOGLE_LINK_GET_USER_INFO = "https://www.googleapis.com/oauth2/v1/userinfo?access_token=";

	public static String GOOGLE_GRANT_TYPE = "authorization_code";
}
