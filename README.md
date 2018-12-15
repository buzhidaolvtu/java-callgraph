```text
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
methodA
    ref call-ref
            ref methodB

public <T,K> T void(K parameter);

```

```text
analyzer
    1.class-resolver:读取class文件,解析类和方法
    2.method-resolver:读取method code，解析调用方法的类和方法
        step-1和step-2把文件读取到内存中，把文件中的结构在内存中再组织一遍：
            文件中的结构：调用关系隐式存在；
            内存中的结构：调用关系，类和方法的组织关系，类的属性，方法的属性等等，在内存中显式存储，并可以对外暴露接口使用。
    3.graph:利用前面步骤的接口，建立graph接口，可供搜索遍历
说明：
这几个步骤的目的都是为了使结构structure使用起来更加方便，因为需要不同，组织结构的方式也不同，接口提供的功能也不相同。
基本元素是相同，客观存在的关系是相同的，但是对于不同的要求层次，组织和使用的方式却是不同的，为了让使用起来更加方便，抽象了以上概念。
即使元素只有0和1，但是也能组合成不同的形式，也就需要层次抽象来帮助管理。
```

```text
resolve ref伪代码：
function callgraph(ref)
	resolveMethod(ref)=>class+method+ref_list
	for each ref in ref_list
		callgraph(ref)

为了简单化，处理如下：
1.如果遇到接口interface，不再继续resolve，后续支持；
2.接口调用可能会形成死循环，这时要break死循环；

难点：
1.接口没有body，需要找到实现impl;  (findDirectImplClasses,findAllImplClasses)
2.类有子类，使用哪一个实现; (findDirectSubClasses,findAllSubClasses)
3.怎样避免cycle调用;
4.怎样清楚优雅地显示;
interface:
findDirectSubInterfaces(parameter:interface)
findSubInterfaces(parameter:interface)
findDirectImplClasses(parameter:interface)
findAllImplClasses(parameter:interface)
impl class:
findDirectSubClasses(parameter:impl class)
findAllSubClasses(parameter:impl class)


类的关系
resolve和classloader是一对一的关系
不同的classloader会单独加载class，但是resolve的逻辑是一样的
```