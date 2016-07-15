package www.csdn.project.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import www.csdn.project.domain.Album;
import www.csdn.project.domain.Users;
import www.csdn.project.service.AlbumService;

public class AlbumAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private AlbumService albumService;

	public void setAlbumService(AlbumService albumService) {
		this.albumService = albumService;
	}

	/**
	 * 显示相册
	 * 
	 * @return
	 */
	public String showAlbum() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Users users=(Users)request.getSession().getAttribute("user");
		int familyId =users.getUserinfo().getFamilyId();
		List<Album> albumList=baseService.getObjects(Album.class, "where familyId="+familyId);
		request.setAttribute("albumList",albumList);
 		return "showAlbum";
	}

}
