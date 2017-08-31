private final type$ref<type$ptr<?>>/*char P*/ Buffer$Ref = new type$ref<type$ptr<?>>() {
  @Override public type$ptr<?> $deref() {return Buffer;} 
  @Override public type$ptr<?> $set(type$ptr<?> value) {return Buffer = $tryClone(value);}
};

public void $MemoryCopy(final /*const*/ NestedNameSpecifierLocBuilder /*&*/ Other) {
  this.Representation = Other.Representation;
  this.Buffer = $tryClone(Other.Buffer);
  this.BufferSize.$assign(Other.BufferSize.$deref());
  this.BufferCapacity.$assign(Other.BufferCapacity.$deref());
}
