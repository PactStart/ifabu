package io.pactstart.ifabu.base;

import tk.mybatis.mapper.common.*;

public interface MyMapper<T> extends BaseMapper<T>, ExampleMapper<T>, ConditionMapper<T>, IdsMapper<T>, MySqlMapper<T>, Marker {
}
