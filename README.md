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

callgraph实现方法：
例如package.classA.methodB
1.find class:package.classA
2.find All methods of A
2-1.save all call instructions
3.find specified methodB from step2
4.for each insn in methodB
    repeat step-1
5.end until some call terminal methods

analysis:
ClassResolver.resolveClass(class)
    ClassVisitor
MethodResolver.resolveMethod(method) => ClassResolver.resolveClass(class) => MethodResolver.resolveMethod(method)
    MethodVisitor
ClassLoader
ResolvedClassTable
ResolvedMethodTable
CallGraph:method --ref--> method
怎样表达两个方法的引用关系，或者说用怎样的数据结构描绘这个graph？


resolve class(interface or implementation class)
resolve method

