package org.nutz.redis.dao;

import org.nutz.dao.pager.Pager;

/**
 * Created by Jianghao on 2017/2/10
 *
 * @howechiang
 */
public interface RDao {

    /**
     * 根据数据源的类型，创建一个翻页对象
     *
     * @param pageNumber 第几页 ，从 1 开始。
     * @param pageSize   每页可以有多少条记录
     * @return 翻页对象
     */
    Pager createPager(int pageNumber, int pageSize);

    /**
     * 根据对象 key 获取一个对象。它只会获取这个对象，关联对象不会被获取。
     * <p>
     * 如果对象不存在，返回null
     *
     * @param classOfT 对象类型
     * @param id       对象 id
     * @see org.nutz.dao.entity.annotation.Id
     */
    <T> T fetch(Class<T> classOfT, String id);

    /**
     * 根据对象 key 获取一个对象。它只会获取这个对象，关联对象不会被获取。
     * <p>
     * 如果对象不存在，返回null
     *
     * @param classOfT  对象类型
     * @param keyPrefix key前缀
     * @param id        对象 id
     * @see org.nutz.dao.entity.annotation.Id
     */
    <T> T fetch(String keyPrefix, Class<T> classOfT, String id);


    /**
     * 根据一个正则表达式，获取对象所有的关联字段
     *
     * @param obj   数据对象,不可以是Class啊!!!传对象或集合啊!!!
     * @param regex 正则表达式，描述了什么样的关联字段将被关注。如果为 null，则表示全部的关联字段都会被查询
     * @return 更新后的数据对象本身
     * @see org.nutz.dao.entity.annotation.One
     * @see org.nutz.dao.entity.annotation.Many
     * @see org.nutz.dao.entity.annotation.ManyMany
     */
    <T> T fetchLinks(T obj, String regex);

    /**
     * 清除key前缀所有记录（类似表的形式）
     *
     * @param keyPrefix key前缀
     * @return 影响的行数
     */
    int clear(String keyPrefix);

    /**
     * 根据keyPrefix判断如何删除一个对象。
     * <p>
     * 相当于 delete(keyPrefix,Class<T>,id)<br>
     *
     * @param obj 要被删除的对象
     */
    int delete(String keyPrefix, Object obj);

    /**
     * 根据对象 key 删除一个对象。它只会删除这个对象，关联对象不会被删除。
     * <p>
     * 你的对象必须在某个字段声明了注解 '@Id'，否则本操作会抛出一个运行时异常
     * <p>
     *
     * @param classOfT  对象类型
     * @param keyPrefix key前缀
     * @param id        对象 id
     * @return 影响的行数
     * @see org.nutz.dao.entity.annotation.Id
     */
    int delete(String keyPrefix, Class<?> classOfT, String id);

    /**
     * 计算某个key前缀的有多少条记录
     *
     * @param keyPrefix key前缀
     * @return 数量
     */
    int count(String keyPrefix);

    /**
     * 将一个对象插入到一个数据源。
     * <p>
     * 声明了 '@Id'的字段会在插入数据库时被忽略，因为会自动为其设值(模拟关系数据库的自增长)。如果想手动设置，请设置 '@Id(auto=false)'
     * <p>
     *
     * @param obj 要被插入的对象
     *            <p>
     *            它可以是：
     *            <ul>
     *            <li>普通 POJO
     *            <li>数组
     *            </ul>
     *            <b style=color:red>注意：</b> 如果是数组，所有的对象必须类型相同，否则可能会出错
     * @return 插入后的对象
     * @see org.nutz.dao.entity.annotation.Id
     */
    <T> T insert(T obj);

    /**
     * 将一个对象插入到一个数据源。
     * <p>
     * 声明了 '@Id'的字段会在插入数据库时被忽略，因为会自动为其设值(模拟关系数据库的自增长)。如果想手动设置，请设置 '@Id(auto=false)'
     * <p>
     *
     * @param keyPrefix key前缀
     * @param obj       要被插入的对象
     *                  <p>
     *                  它可以是：
     *                  <ul>
     *                  <li>普通 POJO
     *                  <li>数组
     *                  </ul>
     *                  <b style=color:red>注意：</b> 如果是数组，所有的对象必须类型相同，否则可能会出错
     * @return 插入后的对象
     * @see org.nutz.dao.entity.annotation.Id
     */
    <T> T insert(String keyPrefix, T obj);

    /**
     * 更新一个对象。对象必须有 '@Id'。
     * <p>
     * 并且调用这个函数前， 主键的值必须保证是有效，否则会更新失败
     * <p>
     * 这个对象所有的字段都会被更新，即，所有的没有被设值的字段，都会被置成 NULL。
     * <p>
     *
     * @param obj 要被更新的对象
     *            <p>
     *            它可以是：
     *            <ul>
     *            <li>普通 POJO
     *            <li>数组
     *            </ul>
     *            <b style=color:red>注意：</b> 如果是，数组，所有的对象必须类型相同，否则可能会出错
     * @return 返回实际被更新的记录条数，一般的情况下，如果更新成功，返回 1，否则，返回 0
     */
    int update(Object obj);
}
