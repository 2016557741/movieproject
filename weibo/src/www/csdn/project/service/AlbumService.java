package www.csdn.project.service;

import www.csdn.project.domain.Album;



public interface AlbumService {
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
	public Album updateAlbum(int id,String name,String comment) ;
	
	 /**
     * 删除相册
     * @return
     */
	public void deleteAlbumById(int id);
	
	
	
}
