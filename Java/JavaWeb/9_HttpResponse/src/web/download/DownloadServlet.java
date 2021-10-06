package web.download;

import web.utils.DownLoadUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 浏览器点击链接下载图片
 */

@WebServlet("/downloadServlet")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 获取请求参数, 文件名称
        String filename = request.getParameter("filename");
        //2. 使用字节输入流加载文件进内存
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/img/" + filename);

        FileInputStream fis = new FileInputStream(realPath);
        ServletOutputStream sos = response.getOutputStream();

        int len = 0;

        byte[] buff = new byte[1024*8];

        //3. 设置response响应头
        //3.1 设置响应头类型 content-type
        String mimeType = servletContext.getMimeType(filename); //获取文件类型
        response.setHeader("content-type", mimeType);
        //3.2 设置打开方式 content-disposition
        response.setHeader("content-disposition", "attachment;filename=" + filename);

        //解决中文文件名在下载时的乱码问题
        //1. 获取user-agent请求头
        String agent = request.getHeader("user-agent");
        //2. 使用工具类编码文件名
        filename = DownLoadUtils.getFileName(agent, filename);

        response.setHeader("content-disposition", "attachment;filename=" + filename);

        //4. 将输入流的数据写入输出流中
        //将fis流中的数据读入buff, 读取的最大长度为buff.length. 若已经读到文件末尾, 则返回-1; 否则返回数据总长度
        //每次读取的长度为buff.length, 需要读取多次才能读完整个文件, 因此用while
        while ((len=fis.read(buff))!=-1) {
            //将buff中从off至off+len-1的数据数据写入sos流
            sos.write(buff, 0, len);
            System.out.println(".");
        }
        //sos不用关
        fis.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
