package www.csdn.project.dao;

import java.util.List;

import www.csdn.project.domain.Pictures;

public interface PicturesDao {
	 /**
     * 查找所有照片通过相册id 并按时间降序排序
     * @return  List<Pictures>
     */
	public List<Pictures> getPicturesByAlbumId(final int albumId) ;
	
	/**
	 * 删除照片通过相册id
	 */
	public void deletePicturesByAlbumId( int albumId) ;
	
	 /**
     * 保存照片
     * @return
     */
	public Pictures savePictures(Pictures pictures) ;
	
	
}
