// 1. javascript的生成器（generator）是ES6标准引入的新的数据类型
//    函数前加* 来表示，以及 函数中存在yield
//    这非常类似于Python的Generator
//    下面是匿名函数，然后赋值给到了 fibGenerator
var fibGenerator = function*() {
    let a = 0,b = 1;
    while(true){
        yield a;
        // 解构赋值
        [a,b] = [b,a+b];
    }
};
//  定义格式：添加了一个 * 和 yield
//   function* foo(x){
//        xxxxx
//        yield xxx
//   }
