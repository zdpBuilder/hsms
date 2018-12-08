package com.hsms.mapper;

import com.hsms.model.Store;

public interface StoreCustomMapper {
	Store getOneByGoodsCode(String goodsCode);
}
