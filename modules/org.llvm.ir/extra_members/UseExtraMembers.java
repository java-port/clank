private static final ThreadLocalThisSupplier<Use> MemorySupplier = ThreadLocalThisSupplier.Create(Use::assertThisConsumedByCtor, Use.class.getName(), false);
private final type$ptr<Use> $This = (type$ptr<Use>) $toConst(MemorySupplier.consumeAssignedMemory(this));

/*package*/type$ptr<Use> $This$Ptr() {
  return $This;
}

private static Use $new(type$ptr<?> /*P*/ MemoryLocation, PrevPtrTag tag) {
  return $new(MemoryLocation, (type$ptr<?> New$Mem) -> new Use(tag));
}

private static Use $new(type$ptr<?> /*P*/ MemoryLocation, New$ConstructorCallback<Use> $Ctor) {
  MemoryLocation = $Clone(MemoryLocation);
  Use createdInstance = $Ctor.$call(MemorySupplier.assignMemory(MemoryLocation));
  assert MemorySupplier.assertConsumed(createdInstance, MemoryLocation);
  return createdInstance;
}

private static boolean assertThisConsumedByCtor(Use createdInstance, type$ptr Mem) {
  assert createdInstance.$This.$eq(Mem) : "expected " + Mem + " vs. " + createdInstance.$This;
  assert Mem.$star() == createdInstance : "createdInstance should be in Mem, but got: " + Mem.$star();
  return true;
}

private Use() {
  Prev = new PointerEnum2Pair<>();
}

// JAVA: we need address of Next field for addToList/removeFromList
private final type$ref<Use /*P*/> Next$Ref = new type$ptr$inout<Use/*P*/>(this) {
  @Override
  protected Use/*P*/ $star$impl() {
    return Next;
  }

  @Override
  protected Use/*P*/ $set$impl(Use u) {
    return Next = u;
  }
};
