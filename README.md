#### kotlin

### 변수
가변값: var
불변값: val (readonly)

- top level variable 개념도 있음.
- 필요할때만 var 사용하고 val 을 기본적으로 쓰는게 권장됨

var apple: String 식으로 선언

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

class Contact(val id: Int, var email: String) // class header

class header의 요소에 대해선 생성자 자동생성.

### Data Class

일반 class와 같으나, 
toString, equals, copy 함수를 자동생성해줌

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



