# originData
mybatis   neo4j  mysql 数据源


此项目为spring boot,myBatis,neo4j整合项目。

有增删改查、动态分页条件排序等一些示例。

运行此项目前请先到http://localhost:7474/browser/运行cql
	create (u:user{name:'wsm',sex:'男',age:23}) - [l:like] -> (y:user{name:'yy',sex:'女',age:21})
