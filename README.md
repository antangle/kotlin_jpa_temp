#### kotlin

### 변수
가변값: var
불변값: val (readonly)

- top level variable 개념도 있음.
- 필요할때만 var 사용하고 val 을 기본적으로 쓰는게 권장됨

var apple: String 식으로 선언

### equality
==를 기본으로 쓴다(String의 equals() 안써도 된다!!! List도 포함)
단, List에서는 order를 고려하지 않고 equality를 계산한다.
order를 고려한다면 contentEquals()를 사용

==는 structural equality
===는 referential equality

java와 비슷하게 equals가 필요할 경우 data class에서 override해서 쓴다.

### String 출력
println("There are ${customers + 1} customers")

### Type Check

is 연산자를 통해 타입 체크 가능. 반대 연산자로는 !is 사용
```
if (obj !is String) { // Same as !(obj is String)
    print("Not a String")
} else {
    print(obj.length)
}
```

만약 타입체크가 되면 컴파일러가 자동으로 타입을 유추함. When이나 루프문에서도 동일하게 작동함.
```
if (x is String) {
    print(x.length) // x is automatically cast to String
}
```

### Collection
read-only collection 개념이 존재함. 얘가 디폴트
우리가 평소 사용하던 가변리스트를 사용한다면 MutableList라고 선언해야함

```
val readOnlyShapes = listOf("triangle", "square", "circle")
val shapes: MutableList<String> = mutableListOf("triangle", "square", "circle")
```

Map, Set에 대해서도 동일.

### 조건절

If, When이 존재함

Docs에서는 When을 쓰는것을 권고(코드의 안정성, 간결성 유지)

### Class
```
class Contact(val id: Int, var email: String) // class header
```
class header의 요소에 대해선 생성자 자동생성, 단 해당 생성자(primary constructor)를 편집하는 annotation이 없거나 public 상태여야 자동생성한다. 있다면 직접 명시해야함
class header의 요소들은 class내의 property, 함수에서 사용 가능하다.

class 내의 init 함수를 통해 생성시 작동을 명시할 수 있음.


## 상속
class는 기본적으로 상속 불가능하다. 이를 위해 open 키워드를 붙여준다.
```
open class Base(p: Int)

class Derived(p: Int) : Base(p)
```

만약 자식 class가 primary constructor가 없다면, secondary constructor에서 super를 통해 생성자 호출이 되어야함.(이는 java랑 동일한듯?)

## getters, setters
property 뒤에 get(), set()을 붙여주면됨
```
class Rectangle(val width: Int, val height: Int) {
    val area: Int // property type is optional since it can be inferred from the getter's return type
        get() = this.width * this.height
}
```

## property
const - 컴파일 타임 상수
lateinit - 객체를 init할 시, 보통 생성자에 넣는다. 하지만 이렇게 되면 해당 객체가 null일 시 에러가 남.
이 문제를 해결하기 위해 생성자 대신 lateinit property를 넣어주고, 이후 annotation 등으로 inject해줌
```
public class MyTest {
    lateinit var subject: TestSubject

    @SetUp fun setup() {
        subject = TestSubject()
    }

    @Test fun test() {
        subject.method()  // dereference directly
    }
}
```

### Data Class

일반 class와 같으나, 
toString, equals, copy, componentN 함수를 자동생성해줌

componentN은 파이썬처럼 어떠한 변수 묶음이 있을 시(Map 을 예로 들어보자)
(key, value) = map 처럼 map의 두 변수를 destructure해서 가져올 수 있다.
component1() = key
component2() = value 로 자동매핑됨

### null

코틀린은 변수들이 null을 기본적으로 받지 못한다. 따라서 ?를 붙여 nullable임을 표시한다.
```
    // neverNull has String type
    var neverNull: String = "This can't be null"

    // Throws a compiler error
    neverNull = null

    // nullable has nullable String type
    var nullable: String? = "You can keep a null here"

    // This is OK  
    nullable = null
```

 - Safe Call
```
fun lengthString(maybeString: String?): Int? = maybeString?.length

fun main() { 
    var nullString: String? = null
    println(lengthString(nullString))
    // null
}
   ```
   ?를 return type에 붙여서 만약 저 변수로 인해 null 에러가 뜨면 그냥 null을 리턴해준다.
- Elvis Operator
```
println(nullString?.length ?: 0)
```
  만약 return값이 null이라면 default를 정해준다.

- !! operator
```
val l = b!!.length
```
null이면 NPE 오류를 throw한다(굳이? 써야하나?)

### label
for문이나 람다식 등에서 return 을 할 때, 통상적인 return은 가장 가까운 함수(fun)에게 direct하게 리턴이된다.

따라서 기존 java에서는 for문에서 break등을 걸 때, break 이후 flow를 명시하거나 리턴값을 저장하려면 flag값이나 temp 값에 할당을 했지만, kotlin에서는 label로 리턴될 장소를 명시한다.

```
loop@ for (i in 1..100) {
    for (j in 1..100) {
        if (...) break@loop
    }
}
//loop의 이름을 가진 곳으로 리턴됨
```

label에는 명시적 레이블, 묵시적 레이블이 존재한다.
```
fun foo1() {
    listOf(1, 2, 3, 4, 5).forEach lit@{
        if (it == 3) return@lit // 람다식(forEach loop)에 대한 local return
        print(it)
    }
    print("명시적 label을 사용한 코드")
}

fun foo2() {
    listOf(1, 2, 3, 4, 5).forEach {
        if (it == 3) return@forEach // 람다식(forEach loop)에 대한 local return
        print(it)
    }
    print("묵시적 label을 사용한 코드")
}
```

리턴값 표현
```
return@a 1
```

### exceptions

코틀린은 checked exception을 지원하지 않는다.
이 행위가 큰 프로젝트에서는 오히려 productivity를 해친다는 결과가 나왔기에, 코틀린은 이를 과감히 없엔 모양
```
try {
    log.append(message)
} catch (IOException e) { --- 저런 IOException 받아서 처리하는 형식을 지원하지 않는다함
    // Must be safe
}
```
코틀린의 throw는 Nothing 타입을 리턴한다. exception 체크를 할 시 타입이 Nothing인지 아닌지로 판단하는셈.

### functional interface
추상 메소드가 단 하나만 있는 인터페이스
기존 인터페이스와 다르게 앞에 fun이 붙는다.
```
fun interface IntPredicate {
   fun accept(i: Int): Boolean
}
```
이를 상속할 시 함수가 하나기에 override로 메서드를 명시하지 않아도 상속할 수 있다.
```
// Creating an instance using lambda
val isEven = IntPredicate { it % 2 == 0 }
```

### typealias 
타입이 너무 길어지면 대신 쓰는 alias라 생각하면됨
```
typealias MyHandler = (Int, String, Any) -> Unit
```

### visibility modifier
public
protected
internal
public

### extention (확장)
외부 라이브러리의 class에 함수나 property를 추가하고 싶을 때, 코틀린은 open없이 상속할 수 없다.
그렇기에 extention이라는 기능을 사용하여 일회성 method나 property를 추가할 수 있다.

```
class Kong {
    val name = "홍진호"
 
    fun playGame() {
        println("폭풍 저그! 홍진호가 간다!")
    }
}

//method extention
fun Kong.speak(sentence: String) {
    println(sentence)
    println(sentence)
}
//property extention
```
단 extention은 그 class에 실제로 추가되는것이기 아니기 때문에, 값이 저장되지 않는다.

### sealed class, interface
무분별한 extention때문에 해당 클래스나 인터페이스에서 에러가 나는것을 방지함.
주로 ERROR 클래스를 만들 때 사용

### inline class
어떤 변수를 wrapper 클래스로 싸놓는 로직이 필요할 시, 성능 최적화를 위해 inline class를 사용한다.
```
@JvmInline // jvm에서 사용시 필요
value class Password(private val s: String)
```

### object
이름이 없는 1회성 객체 (js 생각해보면 됨)
단, kotlin에서의 object는 interface나 class를 상속받을 수 있음.

해당 class 에서 조금만 바꾸거나 추가가 필요할 때, 일회성 object를 생성하여 사용하면 편함

## object 선언
이름이 있는 객체
- singleton 객체를 만들 시 사용
```
object DataProviderManager {
    fun registerDataProvider(provider: DataProvider) {
        // ...
    }

    val allDataProviders: Collection<DataProvider>
        get() = // ...
}
```
## data object
data class같이 data object도 생성 가능
단, data object는 singleton이기 때문에 copy() 지원 안함
또한, class처럼 data property가 없기 때문에 componentN()도 지원안함 
```
data object MyDataObject {
    val x: Int = 3
}
```

## companion object
java의 static이랑 거의 비슷하다 보면 될거같다.
대신 실제로 java로 decompile하면 static이 아닌 class의 인스턴스로 적용이 된다.
만약 java에서 static으로 작동하게 하고 싶다면 @jvmStatic annotation을 붙여주면 됨.

### delegation(위임)
다른 class나 interface의 기능을 가져오곤 싶은데, 상속을 못하거나 상속하기엔 싫을 때 사용.

```
interface Champion {
    val hp: Int,
    val mp: Int,
    fun info()
}

class Ezreal : Champion {
    override val hp: Int = 500
    override val mp: Int = 400
    override fun info() {
    print("체력은 $hp, 마나는 $mp 입니다.")
  }
}
//by 미사용
class User(private val champ: Champion) : Champion {
    override val hp: Int = champ.hp
    override val mp: Int = champ.mp
    override fun info() = champ.info()
}

//by 사용
class User(private val champ: Champion) : Champion by champ {
}

fun main(){
    val user = User(Ezreal())
    user.info()
}
```
저런 식으로 parameter로 들어온 Ezreal 클래스에게 property와 method를 위임받아 User가 사용할 수 있다.

상속과 거의 비슷하지만, kotlin은 기본적으로 상속을 제한하기 때문에 위임을 사용한다.

override가 불가능하다

### this
코틀린은 이제 this가 뭘 명시하는지 정해줄수 있다!!!
```
class A { // implicit label @A
    inner class B { // implicit label @B
        fun Int.foo() { // implicit label @foo
            val a = this@A // A's this
            val b = this@B // B's this

            val c = this // foo()'s receiver, an Int
            val c1 = this@foo // foo()'s receiver, an Int

            val funLit = lambda@ fun String.() {
                val d = this // funLit's receiver, a String
            }

            val funLit2 = { s: String ->
                // foo()'s receiver, since enclosing lambda expression
                // doesn't have any receiver
                val d1 = this
            }
        }
    }
}
```
물론 명시 안하고 기존대로 this를 사용할수도 있다.

### coroutine
코루틴 개념에 대해서는 따로 공부를 해야할듯..

기본적으로 async를 구현하기 위한 한가지의 방법이다.

### annotation
어노테이션 class 생성
```
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION,
        AnnotationTarget.TYPE_PARAMETER, AnnotationTarget.VALUE_PARAMETER,
        AnnotationTarget.EXPRESSION)
@Retention(AnnotationRetention.SOURCE)
@MustBeDocumented
annotation class Fancy
```

