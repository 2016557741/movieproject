package www.csdn.project.action;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import www.csdn.project.domain.Pictures;
import www.csdn.project.domain.Users;
import www.csdn.project.service.PicturesService;
import www.csdn.project.utils.UtilCommon;

/**
 * 
 * @author chenwc
 * 
 */
public class PicturesAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PicturesService picturesService;

	public void setPicturesService(PicturesService picturesService) {
		this.picturesService = picturesService;
	}

	private File fileupload; // 和JSP中input标记name同名
	// Struts2拦截器获得的文件名,命名规则，File的名字+FileName
	// 如此处为 'fileupload' + 'FileName' = 'fileuploadFileName'
	private String fileuploadFileName; // 上传来的文件的名字

	public File getFileupload() {
		return fileupload;
	}

	public void setFileupload(File fileupload) {
		this.fileupload = fileupload;
	}

	public String getFileuploadFileName() {
		return fileuploadFileName;
	}

	public void setFileuploadFileName(String fileuploadFileName) {
		this.fileuploadFileName = fileuploadFileName;
	}

	// 返回json dataMap
	private String jsonStr;

	public String getJsonStr() {
		return jsonStr;
	}

	// 图片剪裁参数
	private String x;
	private String y;
	private String width;
	private String height;
	private String picName;

	public String getX() {
		return x;
	}

	public void setX(String x) {
		this.x = x;
	}

	public String getY() {
		return y;
	}

	public void setY(String y) {
		this.y = y;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getPicName() {
		return picName;
	}

	public void setPicName(String picName) {
		this.picName = picName;
	}

	// 相册图片上传
	public String uploadFile() {
		String extName = ""; // 保存文件拓展名
		String newFileName = ""; // 保存新的文件名
		String savePath = ServletActionContext.getServletContext().getRealPath(
		""); // 获取项目根路径
		savePath = savePath + "/images/famillyGallery/";
		// 获取拓展名
		if (fileuploadFileName.lastIndexOf(".") >= 0) {
			extName = fileuploadFileName.substring(fileuploadFileName
					.lastIndexOf("."));
		}
		try {
			String uuid = UUID.randomUUID().toString();
			newFileName = uuid.substring(0, 8) + uuid.substring(9, 13)
			+ uuid.substring(14, 18) + uuid.substring(19, 23)
			+ uuid.substring(24) + extName; // 文件重命名后的名字
			String filePath = savePath + newFileName;
			filePath = filePath.replace("//", "/");
			// 检查上传的是否是图片
			if (UtilCommon.checkIsImage(extName)) {
				FileUtils.copyFile(fileupload, new File(filePath));
				// 保存图片信息
				HttpServletRequest request = ServletActionContext.getRequest();
				Integer albumId = Integer.valueOf(request
						.getParameter("albumId"));
				String comment = request.getParameter("comment");
				Integer userinfoId = ((Users) request.getSession()
						.getAttribute("user")).getUserinfo().getId();
				Pictures pictures = new Pictures();
				pictures.setUrl(newFileName);
				pictures.setType(2);
				pictures.setComment(comment);
				pictures.setCreateDate(new Date());
				pictures.setUserinfoId(userinfoId);
				pictures.setAlbumId(albumId);
				Pictures retPicture = picturesService.savePictures(pictures);
				JSONObject jsonObject = new JSONObject();
				jsonObject.accumulate("picture", retPicture);
				jsonStr = jsonObject.toString();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return "uploadAbPicSuc";
	}

	// 头像文件上传
	public String uploadHeadPic() {
		String extName = ""; // 保存文件拓展名
		String newFileName = ""; // 保存新的文件名
		String savePath = ServletActionContext.getServletContext().getRealPath(
		""); // 获取项目根路径
		savePath = savePath + "/images/headpic/";
		// 获取拓展名
		if (fileuploadFileName.lastIndexOf(".") >= 0) {
			extName = fileuploadFileName.substring(fileuploadFileName
					.lastIndexOf("."));
		}
		try {
			String uuid = UUID.randomUUID().toString();
			newFileName = uuid.substring(0, 8) + uuid.substring(9, 13)
			+ uuid.substring(14, 18) + uuid.substring(19, 23)
			+ uuid.substring(24) + extName; // 文件重命名后的名字
			String filePath = savePath + newFileName;
			filePath = filePath.replace("//", "/");
			// 检查上传的是否是图片
			if (UtilCommon.checkIsImage(extName)) {
				FileUtils.copyFile(fileupload, new File(filePath));
				jsonStr = "{'flag':'success','picName':'" + newFileName + "'}";
			} else {
				jsonStr = "{'flag':'fail','failInfo':'请上传图片格式gif,jpg,jpeg.png'}";
			}
		} catch (IOException e) {
			jsonStr = "{'flag':'fail','failInfo':'" + e.getMessage() + "'}";
			return "uploadHdPicSuc";
		}
		return "uploadHdPicSuc";
	}

	// 头像剪裁保存
	public String cutHeadPic() throws IOException {
		String rootPath = ServletActionContext.getServletContext().getRealPath(
		"/images/headpic/");
		String savePath = rootPath +"\\"+ picName;
		String sarray[] = picName.split("\\.");
		String fileName = sarray[0];
		String extName = sarray[1];
		FileInputStream is = null;
		ImageInputStream iis = null;
		try {
			is = new FileInputStream(savePath);
			Iterator<ImageReader> it = ImageIO
			.getImageReadersByFormatName(extName);
			ImageReader reader = it.next();
			iis = ImageIO.createImageInputStream(is);
			reader.setInput(iis, true);
			ImageReadParam param = reader.getDefaultReadParam();
			BigDecimal xBD = new BigDecimal(x);
			BigDecimal yBD = new BigDecimal(y);
			BigDecimal widthBD = new BigDecimal(width);
			BigDecimal heightBD = new BigDecimal(width);
			Rectangle rect = new Rectangle();
			rect.setRect(xBD.doubleValue(), yBD.doubleValue(), widthBD
					.doubleValue(), heightBD.doubleValue());
			param.setSourceRegion(rect);
			BufferedImage bi = reader.read(0, param);
			String cutNewName = fileName + "_small." + extName;
			ImageIO.write(bi, extName, new File(rootPath +"\\"+ cutNewName));
			//保存剪裁后图片到用户图片信息中
			HttpServletRequest request = ServletActionContext.getRequest();
			Users currentUser=(Users)request.getSession().getAttribute("user");
			Pictures headPicture=new Pictures();
			headPicture.setCreateDate(new Date());
			headPicture.setType(0);
			headPicture.setUrl(cutNewName);
			headPicture.setUserinfoId(currentUser.getUserinfo().getId());
			Pictures retPicture=picturesService.savePictures(headPicture);
			request.getSession().setAttribute("headPic", retPicture);
			JSONObject jsonObject = new JSONObject();
			jsonObject.accumulate("headPicture", retPicture);
			jsonStr = jsonObject.toString();
		} finally {
			if (is != null)
				is.close();
			if (iis != null)
				iis.close();
		}

		return "cutHeadPicSuc";
	}
}
