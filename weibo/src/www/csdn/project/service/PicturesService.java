package www.csdn.project.service;

import java.util.List;

import www.csdn.project.domain.Pictures;

/**
 * 
 * @author chenwc
 * 
 */
public interface PicturesService {
	/**
	 * 查找所有的图片通过家族ID 按时间降序排列
	 * 
	 * @return
	 */
	public List<Pictures> getPicturesByAlbumId(int albumId);
	
	/**
	 * 保存图片
	 * @param pictures
	 * @return
	 */
	public Pictures savePictures(Pictures pictures) ;
}
