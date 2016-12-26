package servlet;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import keepin.KeepInContent;
import findmould.OperateMoulds;
import html2doc.html2doc;

public class DownloadKeepInWord extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8;");
		request.setCharacterEncoding("utf-8");
		javax.servlet.ServletOutputStream out = response.getOutputStream();
		String savePath = this.getServletConfig().getServletContext()
				.getRealPath("/")
				+ "backup\\";//临时文件的存放地址
		int id = Integer.parseInt(request.getParameter("id"));//获取草稿id
		String html = KeepInContent.getInById(id);//获取草稿的html内容
		String filename = KeepInContent.getFileName(id);//获取草稿的名字
		try {
			//将字符串写入到html文件
			File fileText = new File(savePath+filename+".html");  
			FileWriter fileWriter = new FileWriter(fileText);  
			fileWriter.write(html);  
			fileWriter.close();
			//将html文件转换为word文件
			html2doc.WriteWordFile(savePath, filename);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 设置返回头让用户下载文件
		java.io.File file = new java.io.File(savePath+filename+".doc");
		String realfilename = filename+".doc";
		if (!file.exists()) {
			System.out.println(file.getAbsolutePath() + "文件不存在");
			return;
		}
		// 读取文件流
		java.io.FileInputStream fileInputStream = new java.io.FileInputStream(
				file);
		// 下载文件
		// 设置响应头和下载保存的文件名
		response.setContentType("application/x-msdownload");
		response.setHeader("Content-Disposition", "attachment; filename="
				+ new String(realfilename.getBytes("utf-8"), "iso8859-1") + "");
		if (fileInputStream != null) {
			int filelen = fileInputStream.available();
			// 文件太大时内存不能一次读出要循环
			byte a[] = new byte[filelen];
			fileInputStream.read(a);
			out.write(a);
		}
		fileInputStream.close();
//		out.write();
		out.close();
		
	}
	/**
	 * id查找内容
	 * type
	 * 1	mould
	 * 2	keepin
	 */
	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8;");
		
	}

	@Override
	public void destroy() {
		super.destroy();
	}

	@Override
	public void init() throws ServletException {
		super.init();
	}
}