Scenario: 京东demo

When 我访问了京东的首页
When 我在搜索栏中搜索商品<白酒>
Then 我应该看到各种相关商品的品牌
When 我选取了<酱香>型的相关产品
Then 我应该看到<酱香>型相关产品的品牌