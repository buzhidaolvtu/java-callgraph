1.sp callgraph -cp [classpath] package.class.method
package.class.method
	->package.class.method
		->package.class.method
		->package.class.method
	->package.class.method
		->package.class.method
			package.class.method
	->package.class.method
		->package.class.method


2.sp search -cp [classpath] package.class.method
package.class.method
	<-package.class.method
		<-package.class.method
		<-package.class.method
	<-package.class.method
		<-package.class.method
			<-package.class.method
	<-package.class.method
		<-package.class.method


analysis:
1.怎样判断方法属于哪一个类
resolve class(interface or implementation class)
resolve method

实现方法：
例如package.class.method?
1.find class:package.class : A
2.find All methods of A
2-1.save all call instructions
3.find specified method? from step2
4.for each insn in method?
    repeat step-1
5.end until some call methods
