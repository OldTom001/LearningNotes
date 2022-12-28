package cn.itcast.travel.service;

public interface FavoriteService {

    /**
     * 根据用户id和路线id查询是否收藏
     * @param uid
     * @param rid
     * @return
     */
    public boolean isFavorite(String rid, int uid);


    /**
     * 将用户和对应的路线添加到收藏夹
     * @param rid
     * @param uid
     */
    void add(String rid, int uid);
}
