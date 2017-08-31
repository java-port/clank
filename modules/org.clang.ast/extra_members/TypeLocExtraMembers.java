@Override
public TypeLoc clone() {
  assert getClass() == TypeLoc.class : "Forgot to implement clone in class " + getClass().getCanonicalName() + "?";
  return new TypeLoc(this);
}
  
public static int javaPrepareMemory(QualType T, type$ptr<?> TypeLoc$Data) {
  return javaPrepareMemory(T, TypeLoc$Data, Integer.MAX_VALUE);
}
public static int javaPrepareMemory(QualType T, type$ptr<?> TypeLoc$Data, int MaxSizeToInitialize) {
  // TODO: when create TypeSourceInfo, we need a TypeLoc-visitor to initialize all Local/ExtraLocal data of TypeLocs
  TypeLoc TL = new TypeLoc(T, TypeLoc$Data);
  int Total = 0;
  while (TL.$bool() && (Total < MaxSizeToInitialize)) {
    TL = TypeLocToJavaDerived.toJavaDerived(TL);
    assert !TL.isNull();
    assert TL.Data != null;
    int size = TL.javaAllocateLocalData();
    assert size == TL.getLocalDataSize() : TL.getClass().getSimpleName() + " allocate must init exactly the same count as getFullDataSize:" + size + " vs. " + TL.getFullDataSize();
    Total += size;
    TL = TL.getNextTypeLoc();
  } 
  return Total;
}

protected int javaAllocateLocalData() {
  throw new UnsupportedOperationException("Should be overridden in descendant usually based on getLocalDataSize/initializeLocal: " + getClass().getName());
}

public /*uint*/int getLocalDataSize() /*const*/ {
  throw new UnsupportedOperationException("Should be overridden in descendant " + getClass().getName());
}

public /*uint*/int getLocalDataAlignment() /*const*/ {
  throw new UnsupportedOperationException("Should be overridden in descendant " + getClass().getName());
}

/*friend*//*private*/ static boolean isKind(Class<? extends TypeLoc> TypeLocClazz, /*const*/ TypeLoc /*&*/ TL) {
  if (TypeLocClazz == TypeLoc.class) {
    // copied from TypeLoc
    return true;
  } else if (TypeLocClazz == QualifiedTypeLoc.class) {
    // copied from QualifiedTypeLoc.isKind
    return TL.getType().hasLocalQualifiers();
  } else if (TypeLocClazz == UnqualTypeLoc.class) {
    // copied from UnqualTypeLoc
    return !TL.getType().hasLocalQualifiers();
  }
  assert Concrete$UnqualTypeLoc.class.isAssignableFrom(TypeLocClazz) : "unexpected class derived directly form TypeLoc? " + TypeLocClazz;
  if (TypeLocClazz == TypeSpecTypeLoc.class) {
    // copied from TypeSpecTypeLoc
    if (TL.getType().hasLocalQualifiers()) {
      return false;
    }    
    return new TSTChecker().Visit(TL);
  }
  assert !(TL instanceof UnqualTypeLoc) || !TL.getType().hasLocalQualifiers() : "UnqualTypeLoc should not have local qualifiers: " + TL;
  if (TL instanceof UnqualTypeLoc) {
    // we can skip TL.getType().hasLocalQualifiers() check,
    // clang::InheritingConcreteTypeLoc::isKind(UnqualTypeLoc TL) doesn't check the Qualifiers
    return classofType(TypeLocClazz, TL);
  } else {
    // The check is copied from clang::ConcreteTypeLoc::isKind(TypeLoc TL)
    if (TL.getType().hasLocalQualifiers()) {
      return false;
    }      
    return classofType(TypeLocClazz, TL);
  }
  // clang::InheritingConcreteTypeLoc::isKind(UnqualTypeLoc TL) doesn't check the Qualifiers
//    if (TL instanceof UnqualTypeLoc && 
//            org.clang.ast.java.InheritingConcreteTypeLocBase.class.isAssignableFrom(TypeLocClazz)) {
//      // copied from clang::InheritingConcreteTypeLoc::isKind(UnqualTypeLoc TL)
//      return classofType(TypeLocClazz, TL);
//    }
//    // The check is copied from clang::ConcreteTypeLoc::isKind(TypeLoc TL)
//    if (TL.getType().hasLocalQualifiers()) {
//      return false;
//    }
}
/*friend*//*private*/ static <T extends TypeLoc> boolean classofType(Class<T> TypeLocClass, /*const*/ TypeLoc /*&*/ TL) {
  // known classofType have implementation:
  //return TypeClass::classof(Ty);
  BoolPredicate<Type> TypeClassOf = TypeLocToTypeClassof(TypeLocClass);
  /*FIXME*/return TypeClassOf.$call(TL.getTypePtr());
}

/*friend*//*private*/ static Class<? extends Type> TypeLocToTypeClass(Class<? extends TypeLoc> TypeLocClass) {
  assert TypeLocToType.get(TypeLocClass) != null : "no Type-class for TypeLoc-class " + TypeLocClass;
  return TypeLocToType.get(TypeLocClass);
}

/*friend*//*private*/ static BoolPredicate<Type> TypeLocToTypeClassof(Class<? extends TypeLoc> TypeLocClass) {
  assert TypeLocToTypeClassof.get(TypeLocClass) != null : "no Type-classof for TypeLoc-class " + TypeLocClass;
  return TypeLocToTypeClassof.get(TypeLocClass);
}

/*friend*//*private*/ static <TLoc extends TypeLoc> TLoc TypeLocToTypeLocInstance(Class<? extends TypeLoc> TypeLocClass) {
  assert TypeLocToTypeLocConstructor.get(TypeLocClass) != null : "no TypeLoc-constructor for TypeLoc-class " + TypeLocClass;
  return (TLoc)TypeLocToTypeLocConstructor.get(TypeLocClass).$call();
}

/*friend*//*private*/ static Class<? extends TypeLoc> TypeToTypeLocClass(Class<? extends Type> TypeClass) {
  assert TypeToTypeLoc.get(TypeClass) != null : "no TypeLoc-class for Type-class " + TypeClass;
  return TypeToTypeLoc.get(TypeClass);
}

private static final java.util.Map<Class<? extends TypeLoc>, ConstructorCallback<? extends TypeLoc>> TypeLocToTypeLocConstructor = new java.util.HashMap<>(64);
private static final java.util.Map<Class<? extends TypeLoc>, Class<? extends Type>> TypeLocToType = new java.util.HashMap<>(64);
private static final java.util.Map<Class<? extends Type>, Class<? extends TypeLoc>> TypeToTypeLoc = new java.util.HashMap<>(64);
private static final java.util.Map<Class<? extends TypeLoc>, BoolPredicate<Type>> TypeLocToTypeClassof = new java.util.HashMap<>(64);
static <TLoc extends TypeLoc, Tp extends Type> void mapTypeLocToTypeClass(Class<TLoc> TypeLocClass, ConstructorCallback<TLoc> ctr, Class<Tp> TypeClass, BoolPredicate<Type> classof) {
  assert TypeLocClass != null;
  assert isSpecilTypeLocClass(TypeLocClass) || TypeClass != null : "not specified TypeClass for " + TypeLocClass;
  assert isSpecilTypeLocClass(TypeLocClass) || 
          TypeLocClass.getSimpleName().equals(TypeClass.getSimpleName() + "Loc") :  TypeLocClass.getSimpleName() + " vs. " + TypeClass.getSimpleName();
  assert TypeLocToTypeLocConstructor.get(TypeLocClass) == null : "constructor can not be registered twice [" + TypeLocClass + "] " + ctr + " vs. " + TypeLocToTypeLocConstructor.get(TypeLocClass);
  assert TypeLocToType.get(TypeLocClass) == null : "can not be registered twice [" + TypeLocClass + "] " + TypeClass + " vs. " + TypeLocToType.get(TypeLocClass);
  assert TypeToTypeLoc.get(TypeClass) == null : "can not be registered twice [" + TypeClass + "] " + TypeLocClass + " vs. " + TypeToTypeLoc.get(TypeLocClass);
  assert TypeLocToTypeClassof.get(TypeLocClass) == null : "can not be registered twice [" + TypeLocClass + "] vs. " + TypeLocToTypeClassof.get(TypeLocClass);
  TypeLocToTypeLocConstructor.put(TypeLocClass, ctr);
  TypeLocToType.put(TypeLocClass, TypeClass);
  if (TypeClass != null) {
    TypeToTypeLoc.put(TypeClass, TypeLocClass);
  } else {
    assert isSpecilTypeLocClass(TypeLocClass) : "not special class with null TypeClass " + TypeLocClass;
  }
  if (classof != null) {
    TypeLocToTypeClassof.put(TypeLocClass, classof);
  } else {
    assert isSpecilTypeLocClass(TypeLocClass) : "not special class with null classof predicate " + TypeLocClass;;
  }
}

// special classes
static {  TypeLoc.mapTypeLocToTypeClass(TypeLoc.class, TypeLoc::new, null, null); }
static {  TypeLoc.mapTypeLocToTypeClass(QualifiedTypeLoc.class, QualifiedTypeLoc::new, null, null); }
static {  TypeLoc.mapTypeLocToTypeClass(UnqualTypeLoc.class, UnqualTypeLoc::new, null, null); }
static {  TypeLoc.mapTypeLocToTypeClass(TypeSpecTypeLoc.class, TypeSpecTypeLoc::new, null, null); }
// real classes
static {  TypeLoc.mapTypeLocToTypeClass(AdjustedTypeLoc.class, AdjustedTypeLoc::new, AdjustedType.class, AdjustedType::classof); }
static {  TypeLoc.mapTypeLocToTypeClass(ArrayTypeLoc.class, ArrayTypeLoc::new, ArrayType.class, ArrayType::classof); }  
static {  TypeLoc.mapTypeLocToTypeClass(AtomicTypeLoc.class, AtomicTypeLoc::new, AtomicType.class, AtomicType::classof); }  
static {  TypeLoc.mapTypeLocToTypeClass(AttributedTypeLoc.class, AttributedTypeLoc::new, AttributedType.class, AttributedType::classof); }
static {  TypeLoc.mapTypeLocToTypeClass(AutoTypeLoc.class, AutoTypeLoc::new, AutoType.class, AutoType::classof); }  
static {  TypeLoc.mapTypeLocToTypeClass(BlockPointerTypeLoc.class, BlockPointerTypeLoc::new, BlockPointerType.class, BlockPointerType::classof); }  
static {  TypeLoc.mapTypeLocToTypeClass(BuiltinTypeLoc.class, BuiltinTypeLoc::new, BuiltinType.class, BuiltinType::classof); }
static {  TypeLoc.mapTypeLocToTypeClass(ComplexTypeLoc.class, ComplexTypeLoc::new, ComplexType.class, ComplexType::classof); }
static {  TypeLoc.mapTypeLocToTypeClass(ConstantArrayTypeLoc.class, ConstantArrayTypeLoc::new, ConstantArrayType.class, ConstantArrayType::classof); }
static {  TypeLoc.mapTypeLocToTypeClass(DecayedTypeLoc.class, DecayedTypeLoc::new, DecayedType.class, DecayedType::classof); }
static {  TypeLoc.mapTypeLocToTypeClass(DecltypeTypeLoc.class, DecltypeTypeLoc::new, DecltypeType.class, DecltypeType::classof); }
static {  TypeLoc.mapTypeLocToTypeClass(DependentNameTypeLoc.class, DependentNameTypeLoc::new, DependentNameType.class, DependentNameType::classof); }
static {  TypeLoc.mapTypeLocToTypeClass(DependentSizedArrayTypeLoc.class, DependentSizedArrayTypeLoc::new, DependentSizedArrayType.class, DependentSizedArrayType::classof); }
static {  TypeLoc.mapTypeLocToTypeClass(DependentSizedExtVectorTypeLoc.class, DependentSizedExtVectorTypeLoc::new, DependentSizedExtVectorType.class, DependentSizedExtVectorType::classof); }
static {  TypeLoc.mapTypeLocToTypeClass(DependentTemplateSpecializationTypeLoc.class, DependentTemplateSpecializationTypeLoc::new, DependentTemplateSpecializationType.class, DependentTemplateSpecializationType::classof); }
static {  TypeLoc.mapTypeLocToTypeClass(ElaboratedTypeLoc.class, ElaboratedTypeLoc::new, ElaboratedType.class, ElaboratedType::classof); }
static {  TypeLoc.mapTypeLocToTypeClass(EnumTypeLoc.class, EnumTypeLoc::new, EnumType.class, EnumType::classof); }
static {  TypeLoc.mapTypeLocToTypeClass(ExtVectorTypeLoc.class, ExtVectorTypeLoc::new, ExtVectorType.class, ExtVectorType::classof); }
static {  TypeLoc.mapTypeLocToTypeClass(FunctionNoProtoTypeLoc.class, FunctionNoProtoTypeLoc::new, FunctionNoProtoType.class, FunctionNoProtoType::classof); }
static {  TypeLoc.mapTypeLocToTypeClass(FunctionProtoTypeLoc.class, FunctionProtoTypeLoc::new, FunctionProtoType.class, FunctionProtoType::classof); }
static {  TypeLoc.mapTypeLocToTypeClass(FunctionTypeLoc.class, FunctionTypeLoc::new, FunctionType.class, FunctionType::classof); }
static {  TypeLoc.mapTypeLocToTypeClass(IncompleteArrayTypeLoc.class, IncompleteArrayTypeLoc::new, IncompleteArrayType.class, IncompleteArrayType::classof); }
static {  TypeLoc.mapTypeLocToTypeClass(LValueReferenceTypeLoc.class, LValueReferenceTypeLoc::new, LValueReferenceType.class, LValueReferenceType::classof); }
static {  TypeLoc.mapTypeLocToTypeClass(MemberPointerTypeLoc.class, MemberPointerTypeLoc::new, MemberPointerType.class, MemberPointerType::classof); }
static {  TypeLoc.mapTypeLocToTypeClass(ObjCInterfaceTypeLoc.class, ObjCInterfaceTypeLoc::new, ObjCInterfaceType.class, ObjCInterfaceType::classof); }
static {  TypeLoc.mapTypeLocToTypeClass(ObjCObjectPointerTypeLoc.class, ObjCObjectPointerTypeLoc::new, ObjCObjectPointerType.class, ObjCObjectPointerType::classof); }
static {  TypeLoc.mapTypeLocToTypeClass(ObjCObjectTypeLoc.class, ObjCObjectTypeLoc::new, ObjCObjectType.class, ObjCObjectType::classof); }
static {  TypeLoc.mapTypeLocToTypeClass(PackExpansionTypeLoc.class, PackExpansionTypeLoc::new, PackExpansionType.class, PackExpansionType::classof); }
static {  TypeLoc.mapTypeLocToTypeClass(ParenTypeLoc.class, ParenTypeLoc::new, ParenType.class, ParenType::classof); }
static {  TypeLoc.mapTypeLocToTypeClass(PipeTypeLoc.class, PipeTypeLoc::new, PipeType.class, PipeType::classof); }
static {  TypeLoc.mapTypeLocToTypeClass(PointerTypeLoc.class, PointerTypeLoc::new, PointerType.class, PointerType::classof); }
static {  TypeLoc.mapTypeLocToTypeClass(RecordTypeLoc.class, RecordTypeLoc::new, RecordType.class, RecordType::classof); }
static {  TypeLoc.mapTypeLocToTypeClass(ReferenceTypeLoc.class, ReferenceTypeLoc::new, ReferenceType.class, ReferenceType::classof); }
static {  TypeLoc.mapTypeLocToTypeClass(RValueReferenceTypeLoc.class, RValueReferenceTypeLoc::new, RValueReferenceType.class, RValueReferenceType::classof); }
static {  TypeLoc.mapTypeLocToTypeClass(SubstTemplateTypeParmPackTypeLoc.class, SubstTemplateTypeParmPackTypeLoc::new, SubstTemplateTypeParmPackType.class, SubstTemplateTypeParmPackType::classof); }
static {  TypeLoc.mapTypeLocToTypeClass(SubstTemplateTypeParmTypeLoc.class, SubstTemplateTypeParmTypeLoc::new, SubstTemplateTypeParmType.class, SubstTemplateTypeParmType::classof); }
static {  TypeLoc.mapTypeLocToTypeClass(TagTypeLoc.class, TagTypeLoc::new, TagType.class, TagType::classof); }
static {  TypeLoc.mapTypeLocToTypeClass(TemplateSpecializationTypeLoc.class, TemplateSpecializationTypeLoc::new, TemplateSpecializationType.class, TemplateSpecializationType::classof); }
static {  TypeLoc.mapTypeLocToTypeClass(TemplateTypeParmTypeLoc.class, TemplateTypeParmTypeLoc::new, TemplateTypeParmType.class, TemplateTypeParmType::classof); }
static {  TypeLoc.mapTypeLocToTypeClass(TypedefTypeLoc.class, TypedefTypeLoc::new, TypedefType.class, TypedefType::classof); }
static {  TypeLoc.mapTypeLocToTypeClass(TypeOfExprTypeLoc.class, TypeOfExprTypeLoc::new, TypeOfExprType.class, TypeOfExprType::classof); }
static {  TypeLoc.mapTypeLocToTypeClass(TypeOfTypeLoc.class, TypeOfTypeLoc::new, TypeOfType.class, TypeOfType::classof); }
static {  TypeLoc.mapTypeLocToTypeClass(UnaryTransformTypeLoc.class, UnaryTransformTypeLoc::new, UnaryTransformType.class, UnaryTransformType::classof); }
static {  TypeLoc.mapTypeLocToTypeClass(UnresolvedUsingTypeLoc.class, UnresolvedUsingTypeLoc::new, UnresolvedUsingType.class, UnresolvedUsingType::classof); }
static {  TypeLoc.mapTypeLocToTypeClass(VariableArrayTypeLoc.class, VariableArrayTypeLoc::new, VariableArrayType.class, VariableArrayType::classof); }
static {  TypeLoc.mapTypeLocToTypeClass(VectorTypeLoc.class, VectorTypeLoc::new, VectorType.class, VectorType::classof); }
static {  TypeLoc.mapTypeLocToTypeClass(InjectedClassNameTypeLoc.class, InjectedClassNameTypeLoc::new, InjectedClassNameType.class, InjectedClassNameType::classof); }

private static <TLoc extends TypeLoc> boolean isSpecilTypeLocClass(Class<TLoc> TypeLocClass) {
  return TypeLocClass == QualifiedTypeLoc.class || TypeLocClass == UnqualTypeLoc.class || TypeLocClass == TypeLoc.class || TypeLocClass == TypeSpecTypeLoc.class;
}
