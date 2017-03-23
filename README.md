# Sisyphus Demo

标签（空格分隔）： sisyphus

---
## 前言
### &nbsp; &nbsp; 作为一款前端自动化测试工具,[sisyphus](http://gitlab.dataengine.com/msa/sisyphus)已经发布了2.x版本.但是目前仅仅提供javadoc是远远不够的,所以基于sisyphus提供了一些比较具有典型性的用例,包括对JD.com,帮帮助学的一些用例,方便大家模仿与使用

- - -

## 用例
### 1.京东商城
#### &nbsp; &nbsp; 该测试用例针对京东商城进行了简单业务流程的执行,story如下 :
When 我访问了京东的首页  
When 我在搜索栏中搜索商品&lt;白酒&gt;  
Then 我应该看到各种品牌的&lt;白酒&gt;  
When 我选取了&lt;酱香&gt;型的相关产品  
Then 我应该看到&lt;酱香&gt;型相关产品的品牌  
When 我按&lt;评论数&gt;对商品进行了排序  
Then 我应该看到商品已经按照&lt;评论数&gt;进行了排序  
When 我将&lt;评论数&gt;最多的商品放入购入车  
Then 我应该看到商品已经放入购入车  
When 我去购物车进行结算  
Then 我应该看到商品等待被结算  

##### 使用方式 : 执行cn.rongcapital.sisyphus.demo.jd.runners下的JDDemoRunner.java , run as JUnit Test
- - -

