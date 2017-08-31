//<editor-fold defaultstate="collapsed" desc="llvm::ConstantAggrKeyType<ConstantArray>::create">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/ConstantsContext.h", line = 389,
 FQN="llvm::ConstantAggrKeyType<ConstantArray>::create", NM="_ZNK4llvm19ConstantAggrKeyTypeINS_13ConstantArrayEE6createEPNS_9ArrayTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm19ConstantAggrKeyTypeINS_13ConstantArrayEE6createEPNS_9ArrayTypeE")
//</editor-fold>
public ConstantArray /*P*/ create(ArrayType /*P*/ Ty) /*const*/ {
  return ((/*JCast*/ConstantArray /*P*/ )(/*NEW_EXPR [User::new]*//*Operands.size() = *//*new (Operands.size())*/ User.$new_FixedUses(Operands.size(), (type$ptr<?> New$Mem)->{
      return new ConstantArray(Ty, new ArrayRef<Constant /*P*/ >(Operands));
   })));
}

//<editor-fold defaultstate="collapsed" desc="llvm::ConstantAggrKeyType<ConstantVector>::create">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/ConstantsContext.h", line = 389,
 FQN="llvm::ConstantAggrKeyType<ConstantVector>::create", NM="_ZNK4llvm19ConstantAggrKeyTypeINS_14ConstantVectorEE6createEPNS_10VectorTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm19ConstantAggrKeyTypeINS_14ConstantVectorEE6createEPNS_10VectorTypeE")
//</editor-fold>
public ConstantVector /*P*/ create(VectorType /*P*/ Ty) /*const*/ {
  return ((/*JCast*/ConstantVector /*P*/ )(/*NEW_EXPR [User::new]*//*Operands.size() = *//*new (Operands.size())*/ User.$new_FixedUses(Operands.size(), (type$ptr<?> New$Mem)->{
      return new ConstantVector(Ty, new ArrayRef<Constant /*P*/ >(Operands));
   })));
}

//<editor-fold defaultstate="collapsed" desc="llvm::ConstantAggrKeyType<ConstantStruct>::create">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/ConstantsContext.h", line = 389,
 FQN="llvm::ConstantAggrKeyType<ConstantStruct>::create", NM="_ZNK4llvm19ConstantAggrKeyTypeINS_14ConstantStructEE6createEPNS_10StructTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm19ConstantAggrKeyTypeINS_14ConstantStructEE6createEPNS_10StructTypeE")
//</editor-fold>
public ConstantStruct /*P*/ create(StructType /*P*/ Ty) /*const*/ {
  return ((/*JCast*/ConstantStruct /*P*/ )(/*NEW_EXPR [User::new]*//*Operands.size() = *//*new (Operands.size())*/ User.$new_FixedUses(Operands.size(), (type$ptr<?> New$Mem)->{
      return new ConstantStruct(Ty, new ArrayRef<Constant /*P*/ >(Operands));
   })));
}
