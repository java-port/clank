private /*mutable *//*uint*/int ref_cnt;


//<editor-fold defaultstate="collapsed" desc="llvm::RefCountedBase::Retain">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 51,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", old_line = 52,
 FQN = "llvm::RefCountedBase::Retain", NM = "_ZNK4llvm14RefCountedBase6RetainEv",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/IntrusiveRefCntPtr.cpp -nm=_ZNK4llvm14RefCountedBase6RetainEv")
//</editor-fold>
public final void Retain() /*const*/ {
  ++ref_cnt;
}

//<editor-fold defaultstate="collapsed" desc="llvm::RefCountedBase::Release">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", line = 52,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", old_line = 53,
 FQN = "llvm::RefCountedBase::Release", NM = "_ZNK4llvm14RefCountedBase7ReleaseEv",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/IntrusiveRefCntPtr.cpp -nm=_ZNK4llvm14RefCountedBase7ReleaseEv")
//</editor-fold>
public final void Release() /*const*/ {
  //((ref_cnt > 0 && "Reference count is already zero.") ? (/*static_cast*/void)(0) : __assert_fail("ref_cnt > 0 && \"Reference count is already zero.\"", ${LLVM_SRC}/llvm/include/llvm/ADT/IntrusiveRefCntPtr.h", 53, __PRETTY_FUNCTION__));
  if (--ref_cnt == 0) {
    DoDestroy();
  }
}

protected void DoDestroy() {    
  /*delete*/
  Destructors.$destroy((/*static_cast*//*const*/GlobalCodeCompletionAllocator /*P*/) (this));
}



