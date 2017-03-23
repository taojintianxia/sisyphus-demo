package cn.rongcapital.sisyphus.demo.bangbang.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ShellReader {

    // ssh服务器的地址
    private static final String HOSTNAME = "123.56.79.58";

    // ssh服务器的登入端口
    private static final int PORT = 22;

    // ssh服务器的登入用户名
    private static final String USERNAME = "mwnadmin";

    // ssh服务器的登入密码
    private static final String PASSWORD = "036K29754D64qgv";

    @SuppressWarnings("resource")
    public static String readCapcha() {
        // 验证码
        String capcha = "";

        // 截取命令
        String cmd =
                "egrep 'redis缓存中的值' /mydata/website/tomcat-oprsystemDynamic-8145/rkylin-robot-platform-logs/rkylin-robot-platform-web-logs/rkylin-robot-platform-web/robot.log | awk '{printf \"%s\",$6}'";
        Connection conn = null;
        Session ssh = null;
        try {
            conn = new Connection(HOSTNAME, PORT);
            // 连接到主机
            conn.connect();
            // 使用用户名和密码校验
            boolean isconn = conn.authenticateWithPassword(USERNAME, PASSWORD);
            if (!isconn) {
                log.error("ssh获取验证码的用户名称或者是密码不正确");
            } else {
                log.debug("ssh连接已经连接OK");

                // 以下是linux的示例
                // 将本地conf\/server_start.sh传输到远程主机的\/opt\/pg944/目录下
                // SCPClient clt = conn.createSCPClient();
                // clt.put("conf/server_start.sh", "/opt/pg944/");

                // 执行命令
                ssh = conn.openSession();
                ssh.execCommand(cmd);
                // ssh.execCommand("perl /root/hello.pl");
                // 只允许使用一行命令，即ssh对象只能使用一次execCommand这个方法，多次使用则会出现异常.
                // 使用多个命令用分号隔开
                // ssh.execCommand("cd /root; sh hello.sh");

                /*
                 * 执行windows系统命令的示例 Session sess = conn.openSession(); sess.execCommand("ipconfig");
                 */

                // 将Terminal屏幕上的文字全部打印出来
                InputStream is = new StreamGobbler(ssh.getStdout());
                BufferedReader brs = new BufferedReader(new InputStreamReader(is));
                while (true) {
                    String line = brs.readLine();
                    if (line == null) {
                        break;
                    }
                    capcha = line.substring(line.length() - 4);
                    log.debug(line);
                    log.debug("最后一次刷新验证码：" + capcha);
                }
            }
        } catch (IOException e) {
            log.error("通过ssh获取验证码时失败", e);
        } finally {
            // 连接的Session和Connection对象都需要关闭
            if (ssh != null) {
                ssh.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return capcha;
    }

    public static void main(String... args) {
        log.info("验证码为 : " + ShellReader.readCapcha());
    }

}
