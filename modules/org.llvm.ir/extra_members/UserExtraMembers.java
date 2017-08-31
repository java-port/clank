private static final ThreadLocal<java.util.LinkedList<UserCreationData>> creationData;
private static final ThreadLocalThisSupplier<User> MemorySupplier;

static {
  // the initialization is moved to the static block in order for fields to be initialized in correct order
  creationData = ThreadLocal.withInitial(()->new java.util.LinkedList<UserCreationData>());
  MemorySupplier = ThreadLocalThisSupplier.Create(User::assertThisConsumedByCtor, User.class.getName(), false);
}

/*protected:*/
/// Allocate a User with an operand pointer co-allocated.
///
/// This is used for subclasses which need to allocate a variable number
/// of operands, ie, 'hung off uses'.
/// Allocate a User with an operand pointer co-allocated.
///
/// This is used for subclasses which need to allocate a variable number
/// of operands, ie, 'hung off uses'.
//<editor-fold defaultstate="collapsed" desc="llvm::User::operator new">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/IR/User.cpp", line = 154)
public static <T extends User> T $new_HangOffUses(New$ConstructorCallback<T> $Ctor) {
  int $UsePtr = 1; // sizeof(Use *)
  Object[] data = new Object[1 + $UsePtr];
  type$ptr<?>/*void P*/ Start = create_type$ptr(data);
  type$ptr<?>/*void P*/ Result = Start.$add($UsePtr);
  UserCreationData Obj = new UserCreationData();
  Obj.NumUserOperands = 0;
  Obj.HasHungOffUses = true;
  Obj.HasDescriptor = false;
  Obj.$this = Result;
  // we support stack of assigned memories for creation of inner objects
  final LinkedList<UserCreationData> stack = creationData.get();
  assert stack != null : "creationData list should be prepared!";
  stack.addLast(Obj);
  T out = callConstructorImpl(Result, $Ctor);
  assert out == Obj.$this.$star() : "created object " + NativeTrace.getIdentityStr(out) + " must be the same as assigned into $this " + NativeTrace.getIdentityStr(Obj.$this.$star());
  return out;
}
/// Allocate a User with the operands co-allocated.
///
/// This is used for subclasses which have a fixed number of operands.

/// Allocate a User with the operands co-allocated.
///
/// This is used for subclasses which have a fixed number of operands.
//<editor-fold defaultstate="collapsed" desc="llvm::User::operator new">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/User.cpp", line = 146,
 FQN="llvm::User::operator new", NM="_ZN4llvm4UsernwEjj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/User.cpp -nm=_ZN4llvm4UsernwEjj")
//</editor-fold>
protected static <T extends User> T /*void P*/ $new_FixedUses(/*size_tint UnusedSizeOf, *//*uint*/int Us, New$ConstructorCallback<T> $Ctor) {
  return allocateFixedOperandUser(/*s,*/Us, 0, $Ctor);
}
protected static <T extends User> T /*void P*/ $new_FixedUsesAndDesc(/*size_tint UnusedSizeOf, *//*uint*/int Us, /*uint*/int DescBytes, New$ConstructorCallback<T> $Ctor) {
  return allocateFixedOperandUser(/*s,*/Us, DescBytes, $Ctor);
}

private void $init() {
  final LinkedList<UserCreationData> stack = creationData.get();
  assert stack != null : "creationData list should be prepared!";
  assert !stack.isEmpty() : "creationData memory should be prepared!";
  UserCreationData d = stack.removeLast();
  assert d != null : "creationData should not be null!";
  NumUserOperands = d.NumUserOperands;
  HasHungOffUses = d.HasHungOffUses;
  HasDescriptor = d.HasDescriptor;
}

public static type$ptr<Use /*P*/> getOperandList$beingCreated() {
  return peek$UserCreationData().getOperandList();
}

private static UserCreationData peek$UserCreationData() {
  final LinkedList<UserCreationData> stack = creationData.get();
  assert stack != null : "creationData list should be prepared!";
  assert !stack.isEmpty() : "forgot to wrap constructor call in one of UserDerivedClass.$new_UserDerivedClass new operator calls?";
  UserCreationData d = stack.getLast();
  assert d != null : "creationData should not be null!";
  return d;
}

private static <T extends User> T callConstructorImpl(type$ptr<?> MemoryLocation, New$ConstructorCallback<T> $Ctor) {
  T createdInstance = $Ctor.$call(MemorySupplier.assignMemory(MemoryLocation));
  assert MemorySupplier.assertConsumed(createdInstance, MemoryLocation);
  return createdInstance;
}

private static boolean assertThisConsumedByCtor(User createdInstance, type$ptr Mem) {
  assert createdInstance.$This.$eq(Mem) : "expected " + Mem + " vs. " + createdInstance.$This;
  assert Mem.$star() == createdInstance : "createdInstance should be in Mem, but got: " + Mem.$star();
  return true;
}

/**
 * In C++, these 3 fields are initialized not in ctor but in operator new.
 * An we need these fields before constructor is called.
 */
private static class UserCreationData implements IUser {
  public int NumUserOperands;
  public boolean HasHungOffUses;
  public boolean HasDescriptor;
  private type$ptr<?> $this;
  public type$ptr<Use> getOperandList() {
    return HasHungOffUses ? getHungOffOperands() : getIntrusiveOperands();
  }
  public type$ptr<Use /*P*/>/*&*/ getHungOffOperands() {
    UserCreationData d = peek$UserCreationData();
    return (type$ptr<Use /*P*/>/*P*/) d.$this.$sub(1);
  }
  public type$ptr<Use /*P*/> getIntrusiveOperands() {
    UserCreationData d = peek$UserCreationData();
    return (type$ptr<Use /*P*/>) d.$this.$sub(NumUserOperands);
  }
  public type$ptr<?> $This$Ptr() {
    return $this;
  }
  public int getNumOperands() {
    return NumUserOperands;
  }
  public int getNumOperands$User() {
    return NumUserOperands;
  }
}

private final type$ptr<?> $This = $toConst(MemorySupplier.consumeAssignedMemory(this));

public type$ptr<?> $This$Ptr() {
  return $This;
}
protected static IUser $BEING_CREATED() {
  UserCreationData out = peek$UserCreationData();
  return out;
}

protected User() { /*for descendants deleted ctors + for sentinels */ $init(); }
protected static int $sizeof_PointerUIntPair$User$P() { return 1; };
protected static int $sizeof_Use() { return 1; };
protected static int $sizeof_DescriptorInfo() { return 1; };

protected final OperandTraits<User> $OperandTraits() {
  OperandTraits<User> traits = OperandTraitsRegistry.<User>get(this.getClass());
  assert (traits != null) : "OperandTraits for " + getClass().getName() + " not registered";
  return traits;
};

public /*uint*/int getNumOperands$User() /*const*/ {
  return NumUserOperands;
}

@Override
public void $delete() {
  User.$delete(this);
}
