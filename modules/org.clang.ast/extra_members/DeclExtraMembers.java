private static boolean assertThisConsumedByCreatedDecl(Decl createdDecl, type$ptr Mem) {
  assert createdDecl.$This$InASTContext.$eq(Mem) : "expected " + Mem + " vs. " + createdDecl.$This$InASTContext;
  assert Mem.$star() == createdDecl : "createdDecl should be in Mem, but got: " + Mem.$star();
  return true;
}

private static final ThreadLocalThisSupplier<Decl> MemoryForDecl$Supplier = ThreadLocalThisSupplier.Create(Decl::assertThisConsumedByCreatedDecl, Decl.class.getName(), false);

private final type$ptr<?> $This$InASTContext = MemoryForDecl$Supplier.consumeAssignedMemory(this);

/*friend*/type$ptr<?> $This$Ptr() { return $This$InASTContext; }

/// \brief Allocate memory for a deserialized declaration.
///
/// This routine must be used to allocate memory for any declaration that is
/// deserialized from a module file.
///
/// \param Size The size of the allocated object.
/// \param Ctx The context in which we will allocate memory.
/// \param ID The global ID of the deserialized declaration.
/// \param Extra The amount of extra space to allocate after the object.  
//<editor-fold defaultstate="collapsed" desc="clang::Decl::operator new">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*operator new (Ctx, ID) Decl(...) */,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 55,
 FQN="clang::Decl::operator new", NM="_ZN5clang4DeclnwEjRKNS_10ASTContextEjj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang4DeclnwEjRKNS_10ASTContextEjj")
//</editor-fold>
protected static <T extends Decl> T/*P*/ $new(final /*const*/ ASTContext /*&*/ Context, 
    /*uint*/int ID, New$ConstructorCallback<T/*P*/> New$DeclCtr) {
  return $new(Context, 
    ID, 0, New$DeclCtr);
}
protected static <T extends Decl> T/*P*/ $new(final /*const*/ ASTContext /*&*/ Context, 
    /*uint*/int ID, /*uint*/int Extra/*= 0*/, New$ConstructorCallback<T/*P*/> New$DeclCtr, std.pairIntPtr<Supplier> ... ExtraInitializers) {
  // Allocate an extra 8 bytes worth of storage, which ensures that the
  // resulting pointer will still be 8-byte aligned.
//    static_assert($greatereq_uint($sizeof_UInt() * 2, AlignOf/*<Decl>*/.Unnamed_enum.Alignment), $("Decl won't be misaligned"));
  type$ptr<?>/*void P*/ Start = Context.Allocate$JavaRef(2/*leading integers*/ + 1/*Decl object*/ + Extra/*trailing objects*/);
  type$ptr<?>/*void P*/ Result = Start.$add(/*8*/2/*2 integers in the head*/);

  type$ptr<Integer>/*uint P*/ PrefixPtr = (type$ptr<Integer>)Start;

  // Zero out the first 4 bytes; this is used to store the owning module ID.
  PrefixPtr.$set(0, Integer.valueOf(0));

  // Store the global declaration ID in the second 4 bytes.
  PrefixPtr.$set(1, Integer.valueOf(ID));

  return initExtraTrailingsAndCallConstructorImpl(Result, New$DeclCtr, Extra, ExtraInitializers); 
}  

/// \brief Allocate memory for a non-deserialized declaration.  
//<editor-fold defaultstate="collapsed" desc="clang::Decl::operator new">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*operator new (Ctx, DC) Decl(...) */,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp", line = 75,
 FQN="clang::Decl::operator new", NM="_ZN5clang4DeclnwEjRKNS_10ASTContextEPNS_11DeclContextEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp -nm=_ZN5clang4DeclnwEjRKNS_10ASTContextEPNS_11DeclContextEj")
//</editor-fold>
protected static <T extends Decl> T/*P*/ $new(final /*const*/ ASTContext /*&*/ Context, 
    DeclContext /*P*/ Parent, New$ConstructorCallback<T/*P*/> New$DeclCtr) {
  return $new(Context, 
    Parent, 0, New$DeclCtr);
}
protected static <T extends Decl> T/*P*/ $new(final /*const*/ ASTContext /*&*/ Context, 
    DeclContext /*P*/ Parent, /*uint*/int Extra/*= 0*/, New$ConstructorCallback<T/*P*/> New$DeclCtr, std.pairIntPtr<Supplier> ... ExtraInitializers) {
  assert (!(Parent != null) || $AddrOf(Parent.getParentASTContext()) == $AddrOf(Context));
  // With local visibility enabled, we track the owning module even for local
  // declarations.
  type$ptr<?>/*void P*/ Result;
  if (Context.getLangOpts().ModulesLocalVisibility) {
    type$ptr/*void P*/ Start = Context.Allocate$JavaRef(1/*Decl object*/ + Extra + 1/*Module P*/);
    Result = (type$ptr<?>)Start.$add(/*8*/1/*Module P in the head*/);
//      /*size_t*/int ExtraAlign = $ulong2uint(llvm.OffsetToAlignment($uint2ulong($sizeof_ptr(/*Module  */)), 
//          $uint2ulong(AlignOf/*<Decl>*/.Unnamed_enum.Alignment)));
//      char$ptr/*char P*/ Buffer = $tryClone(reinterpret_cast(char$ptr/*char P*/ .class, /*::*/$new_uint_ASTContext$C_uint(ExtraAlign + $sizeof_ptr(/*Module  */) + Size + Extra, Context)));
//      Buffer.$inc(ExtraAlign);
//      return /*FIXME:NEW_EXPR*//*new (Buffer)*/ new Module /*P*/ (Buffer.$add(1));
    Start.$set((Module/*P*/)null);
  } else {
    Result = Context.Allocate$JavaRef(1/*Decl object*/ + Extra);
  }
  return initExtraTrailingsAndCallConstructorImpl(Result, New$DeclCtr, Extra, ExtraInitializers);
}  

private static <T extends Decl> T initExtraTrailingsAndCallConstructorImpl(type$ptr<?> MemoryLocation, New$ConstructorCallback<T> New$DeclCtr, 
        /*uint*/int ExtraTrailings/*= 0*/, std.pairIntPtr<Supplier> ... ExtraInitializers) {
  // Initialize extra memory before constructor call
  // because constructors usually access it's trailing objects
  if (ExtraTrailings != 0) {
    assert ExtraInitializers != null;
    int TrailingIndex = 1;
    for (std.pairIntType<Supplier> numAndSupplier : ExtraInitializers) {
      for (int counter = 0; counter < numAndSupplier.first; ++counter) {
        assert ((type$ptr)MemoryLocation).$at(TrailingIndex) == null : "how could it be already occupied by " + NativeTrace.getIdentityStr(((type$ptr)MemoryLocation).$at(TrailingIndex));
        ((type$ptr)MemoryLocation).$set(TrailingIndex, numAndSupplier.second.get());
        ++TrailingIndex;
      }
    }          
  }
  T createdDecl = New$DeclCtr.$call(MemoryForDecl$Supplier.assignMemory(MemoryLocation));
  assert (ExtraTrailings == 0) || createdDecl instanceof TrailingObjectsImpl : 
          "Extra [" + ExtraTrailings + "] is incorrect for Decl class without TrailingObjects:" + NativeTrace.getIdentityStr(createdDecl);    
  assert MemoryForDecl$Supplier.assertConsumed(createdDecl, MemoryLocation);
  return createdDecl;
} 

public boolean isFirstDecl() /*const*/ { return isFirstDecl$Decl(); }
public Decl /*P*/ getPreviousDecl() { return getPreviousDecl$Decl(); }
public /*const*/ Decl /*P*/ getPreviousDecl$Const() /*const*/ { return getPreviousDecl$Decl$Const(); }
public Decl /*P*/ getMostRecentDecl() { return getMostRecentDecl$Decl(); }
public /*const*/ Decl /*P*/ getMostRecentDecl$Const() /*const*/ { return getMostRecentDecl$Decl$Const(); }

//////////////////////////////////////////////////////////////////////////////

@Override public String toString() {
  String DeclCtxStr = "<null>";
  if (!DeclCtx.isNull()) {
    DeclContext DC = DeclCtx.dyn_cast(DeclContext.class);
    if (DC != null) {
      DeclCtxStr = NativeTrace.getIdentityStr(DC);
    } else {
      DeclCtxStr = "" + DeclCtx.get(MultipleDC.class); // NOI18N
    }
  }
  return " As$Decl{" + NativeTrace.getIdentityStr(this)
            + ", DeclKind=" + Kind.valueOf($uchar2uint(DeclKind)) // NOI18N
            + ", NextInContextAndBits=" + NextInContextAndBits // NOI18N
            + ", Loc=" + Loc // NOI18N
            + ", DeclCtx={" + DeclCtxStr // NOI18N
            + "}, InvalidDecl=" + InvalidDecl // NOI18N
            + ", HasAttrs=" + HasAttrs // NOI18N
            + ", Implicit=" + Implicit // NOI18N
            + ", Used=" + Used // NOI18N
            + ", Referenced=" + Referenced // NOI18N
            + ", Access=" + AccessSpecifier.valueOf($uchar2uint(Access)) // NOI18N
            + ", FromASTFile=" + FromASTFile // NOI18N
            + ", Hidden=" + Hidden // NOI18N
            + ", _IdentifierNamespace=" + $ushort2uint(IdentifierNamespace_field) // NOI18N
            + ", CacheValidAndLinkage=" + $uchar2uint(CacheValidAndLinkage) + "}\n" // NOI18N
            + ((this instanceof DeclContext) ? ((DeclContext)this).$DeclContext$Fields().toString() : ""); // NOI18N
}
