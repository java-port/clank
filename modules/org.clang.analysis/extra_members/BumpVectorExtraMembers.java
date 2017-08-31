public type$ptr<T> /*&*/ ptr$at(/*uint*/int idx) {
  assert Begin.$add(idx).$less(End);
  return Begin.$add(idx);
}

private final TypeAllocator<T> $typeAllocator;

@FunctionalInterface
public interface Int2ArryType<Type> {
  public Type[] $call(int size);
}

public static final class TypeAllocator<T> {
  private final boolean isClass;
  private final Int2ArryType<T> newArryType;
  private final Type2RetType<T,T> copyType;
  public TypeAllocator(Int2ArryType<T> newArryType, Type2RetType<T,T> copyType) {
    this.isClass = true;
    this.newArryType = newArryType;
    this.copyType = copyType;
  }
  public TypeAllocator(Int2ArryType<T> newArryType) {
    this.isClass = false;
    this.newArryType = newArryType;
    this.copyType = null;
  }
}
