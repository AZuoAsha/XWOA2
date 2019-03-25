package oa.action;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionCounter implements HttpSessionListener {

	private static int activeSessions = 0;
    //session����ʱִ��
    public void sessionCreated(HttpSessionEvent se) {
        activeSessions++;
    }
    //session����ʱִ��
    public void sessionDestroyed(HttpSessionEvent se) {
        if (activeSessions > 0)
            activeSessions--;
    }
    //��ȡ���session����(��������)
    public static int getActiveSessions() {
        return activeSessions;
    }
}
