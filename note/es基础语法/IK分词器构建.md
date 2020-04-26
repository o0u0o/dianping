# IK 分词器
## IK分词器构建
analyze:分析
- 分词过程：

    字符串过滤器-> 字符处理-> 分词过滤（分词转换）->

engish analyze:分析:
- 分词过程
    
    字符过滤器（过滤特殊符号和量词,比如 the 等） -> 字符处理 -> 分词过滤（分词转换、词干转化）
    
IK analyze 分词:
- 分词过程

    字符过滤器（过滤特殊符号和量词,比如 的 等） -> 字符处理（词库、词典） -> 分词过滤（分词转换、词干转化）
   
举例：
- 输入`中华人民共和国`
- 贪心算法分析出`中华 人民 共和国` 或者 `中华 人民 共 和 国`（词典没有 共和国的情况下）   
    
举例：
- 原句:eating an apple a day & keeps the docker away

- 过滤器过滤后: `eating an apple a day & keeps the docker away`

- 字符处理后：

     

