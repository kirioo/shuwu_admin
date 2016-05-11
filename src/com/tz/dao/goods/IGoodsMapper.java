/**
 * 玛丽猫系统平台
 * moonvip
 * com.tz.model
 * Content.java
 * 创建人:luochenxi 
 * 时间：2015年6月8日-下午1:13:00 
 * 2016Nq公司-版权所有
 */
package com.tz.dao.goods;

import java.util.List;

import com.tz.bean.Goods;
import com.tz.bean.GoodsPrice;
import com.tz.bean.PriceElements;
import com.tz.bean.TzParams;

/**
 * 商品管理Mapper IGoodsMapper 创建人:落落 时间：2016年03月15日 17:15:31
 * 
 * @version 1.0.0
 * 
 */
public interface IGoodsMapper {

	/**
	 * 
	 * com.tz.dao.goods 方法名：findGoodss 创建人：落落 手机号码:15712837729 时间：2016年03月15日
	 * 17:15:31
	 * 
	 * @param params
	 * @return 返回类型：List<Goods>
	 * @exception
	 * @since 1.0.0
	 */
	public List<Goods> findGoodss(TzParams params);

	/**
	 * 求总数 com.tz.dao.goods 方法名：count 创建人：落落 手机号码:15712837729 时间：2016年03月15日
	 * 17:15:31
	 * 
	 * @param id
	 * @return 返回类型：List<Goods>
	 * @exception
	 * @since 1.0.0
	 */
	public int count(TzParams params);

	/**
	 * 
	 * com.tz.dao.goods 方法名：getGoods 创建人：落落 手机号码:15712837729 时间：2016年03月15日
	 * 17:15:31
	 * 
	 * @param id
	 * @return 返回类型：List<Goods>
	 * @exception
	 * @since 1.0.0
	 */
	public Goods get(Integer id);

	/**
	 * 保存商品管理 com.tz.dao.goods 方法名：save 创建人：落落 手机号码:15712837729 时间：2016年03月15日
	 * 17:15:31
	 * 
	 * @param goods
	 * @return 返回类型：Goods
	 * @exception
	 * @since 1.0.0
	 */
	public int save(Goods goods);

	/**
	 * 更新商品管理 com.tz.dao.goods 方法名：update 创建人：落落 手机号码:15712837729 时间：2016年03月15日
	 * 17:15:31
	 * 
	 * @param goods
	 * @return 返回类型：int
	 * @exception
	 * @since 1.0.0
//	 */
	public int update(Goods goods);

	/**
	 * 删除商品管理 com.tz.dao.goods 方法名：delete 创建人：落落 手机号码:15712837729 时间：2016年03月15日
	 * 17:15:31
	 * 
	 * @param params
	 * @return 返回类型：int
	 * @exception
	 * @since 1.0.0
	 */
	public int delete(TzParams params);

	/**
	 * 根据商品ID获取商品价格列表
	 * 
	 * @param id
	 * @return
	 */
	public List<GoodsPrice> getGoodsPrice(Goods goods);

	/**
	 * 获取商品尺寸列表
	 * 
	 * @param pe
	 * @return
	 */
	public List<PriceElements> getSizeList();

	/**
	 * 获取商品颜色列表
	 * 
	 * @param pe
	 * @return
	 */
	public List<PriceElements> getColorList();

	/**
	 * 更新商品价格
	 * 
	 * @param gp
	 * @return
	 */
	public int updateGoodPrice(GoodsPrice gp);

	/**
	 * 添加商品价格
	 * @param gp
	 * @return
	 */
	public int addGoodPrice(GoodsPrice gp);
}
