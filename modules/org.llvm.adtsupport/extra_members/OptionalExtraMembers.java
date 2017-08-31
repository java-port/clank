public Optional<T> $assign_T$C$R(T other) {
  this.storage = $tryClone(other);
  this.hasVal = true;
  return this;
}

public Optional<T> $assign_T$RR(T other) {
  this.storage = $tryMove(this.storage, other, false);
  this.hasVal = true;
  return this;
}

public @Override void swap(NativeSwappable RHS) {
  Optional</*typename*/ T> other = (Optional</*typename*/ T>) RHS;
  if (this.storage instanceof NativeSwappable &&
      other.storage instanceof NativeSwappable) {
    ((NativeSwappable)this.storage).swap((NativeSwappable)other.storage);
  } else {
    final T myStorage = this.storage;
    this.storage = other.storage;
    other.storage = myStorage;
  }
  final boolean myHasVal = this.hasVal;    
  this.hasVal = other.hasVal;
  other.hasVal = myHasVal;
}

@Override public Optional<T> clone() { return new Optional(this); }

@Override public Optional<T> move() { return new Optional().$assignMove(this); }

/// Create a new object by constructing it in place with the given arguments.
/*template <typename ... ArgTypes> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::Optional::emplace">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h", line = 75,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Optional.h", old_line = 74,
 FQN="llvm::Optional::emplace", NM="Tpl__ZN4llvm8Optional7emplaceEDpOT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Action.cpp -nm=Tpl__ZN4llvm8Optional7emplaceEDpOT_")
//</editor-fold>
public void emplace(T /*&&*/...Args) {
  reset();
  hasVal = true;
  assert Args.length <= 1;
  storage = Args.length > 0 ? Args[0] : null;
}
