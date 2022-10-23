
# Data class

- equals()
- hashCode()
- toString()
- componentN(), copy()


Tools -> Kotlin -> Show Kotlin Bytecode -> Decompile

```kotlin
data class Person(val name:String, val age: Int)
```

```java
// Person.java
package me.zeroest.kotlin.basic.dataclass;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
    mv = {1, 6, 0},
    k = 1,
    d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"},
    d2 = {"Lme/zeroest/kotlin/basic/dataclass/Person;", "", "name", "", "age", "", "(Ljava/lang/String;I)V", "getAge", "()I", "getName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "kotlin-basic.main"}
)
public final class Person {
    @NotNull
    private final String name;
    private final int age;

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final int getAge() {
        return this.age;
    }

    public Person(@NotNull String name, int age) {
        Intrinsics.checkNotNullParameter(name, "name");
        super();
        this.name = name;
        this.age = age;
    }

    @NotNull
    public final String component1() {
        return this.name;
    }

    public final int component2() {
        return this.age;
    }

    @NotNull
    public final Person copy(@NotNull String name, int age) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new Person(name, age);
    }

    // $FF: synthetic method
    public static Person copy$default(Person var0, String var1, int var2, int var3, Object var4) {
        if ((var3 & 1) != 0) {
            var1 = var0.name;
        }

        if ((var3 & 2) != 0) {
            var2 = var0.age;
        }

        return var0.copy(var1, var2);
    }

    @NotNull
    public String toString() {
        return "Person(name=" + this.name + ", age=" + this.age + ")";
    }

    public int hashCode() {
        String var10000 = this.name;
        return (var10000 != null ? var10000.hashCode() : 0) * 31 + Integer.hashCode(this.age);
    }

    public boolean equals(@Nullable Object var1) {
        if (this != var1) {
            if (var1 instanceof Person) {
                Person var2 = (Person)var1;
                if (Intrinsics.areEqual(this.name, var2.name) && this.age == var2.age) {
                    return true;
                }
            }

            return false;
        } else {
            return true;
        }
    }
}
// DataClassKt.java
package me.zeroest.kotlin.basic.dataclass;

    import kotlin.Metadata;

@Metadata(
    mv = {1, 6, 0},
    k = 2,
    d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u001a\u0006\u0010\u0000\u001a\u00020\u0001¨\u0006\u0002"},
    d2 = {"main", "", "kotlin-basic.main"}
)
public final class DataClassKt {
    public static final void main() {
    }

    // $FF: synthetic method
    public static void main(String[] var0) {
        main();
    }
}
```