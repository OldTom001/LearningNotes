package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Favorite;

public interface FavoriteDao {

    /**
     * 根据路线id和用户id查询收藏信息
     * @param rid
     * @param uid
     * @return
     */
    public Favorite findByRidAndUid(int rid, int uid);

    /**
     * 根据rid查询路线收藏次数
     * @param rid
     * @return
     */
    int findCountByRid(int rid);

    /**
     * 将用户和对应的路线添加到收藏夹
     * @param rid
     * @param uid
     */
    void add(int rid, int uid);
}
