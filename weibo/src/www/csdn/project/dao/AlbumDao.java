package www.csdn.project.dao;

import www.csdn.project.domain.Album;

/**
 * chenwc
 * @author Administrator
 *
 */
public interface AlbumDao {
	 /**
     * 加载相册通过ID
     * @return
     */
	public Album loadAlbumById(int Id) ;	
	
	 /**
     * 保存保存相册
     * @return
     */
	public Album saveAlbum(Album album) ;
	
	 /**
     * 更新相册
     * @return
     */
	public Album updateAlbum(Album album) ;
	
	 /**
     * 删除相册
     * @return
     */
	public void deleteAlbumById(int id) ;
	
 
}
