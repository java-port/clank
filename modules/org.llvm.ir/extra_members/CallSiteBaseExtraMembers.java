public CallSiteBase(CallSiteBase</*typename*/ FunTy/* = const Function*/, /*typename*/ BBTy/* = const BasicBlock*/, /*typename*/ ValTy/* = const Value*/, /*typename*/ UserTy/* = const User*/, /*typename*/ UseTy/* = const Use*/, /*typename*/ InstrTy/* = const Instruction*/, /*typename*/ CallTy/* = const CallInst*/, /*typename*/ InvokeTy/* = const InvokeInst*/, /*typename*/ IterTy/* = User::const_op_iterator*/> BB) {
}

public CallSiteBase(JD$Move $prm, CallSiteBase</*typename*/ FunTy/* = const Function*/, /*typename*/ BBTy/* = const BasicBlock*/, /*typename*/ ValTy/* = const Value*/, /*typename*/ UserTy/* = const User*/, /*typename*/ UseTy/* = const Use*/, /*typename*/ InstrTy/* = const Instruction*/, /*typename*/ CallTy/* = const CallInst*/, /*typename*/ InvokeTy/* = const InvokeInst*/, /*typename*/ IterTy/* = User::const_op_iterator*/> BB) {
}

/// Determine whether this Use is the callee operand's Use.
//<editor-fold defaultstate="collapsed" desc="llvm::CallSiteBase::isCallee">
@Converted(kind = Converted.Kind.MANUAL_ADDED,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/CallSite.h", line = 119,
 FQN="llvm::CallSiteBase::isCallee", NM="_ZNK4llvm12CallSiteBase8isCalleeEPKNS_3UseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZNK4llvm12CallSiteBase8isCalleeEPKNS_3UseE")
//</editor-fold>
public boolean isCallee(/*const*/Use /*P*/ U) /*const*/ {
  throw new UnsupportedOperationException("EmptyBody");
}
