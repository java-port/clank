/**
 * This file was converted to Java from the original LLVM source file. The original
 * source file follows the LLVM Release License, outlined below.
 * 
 * ==============================================================================
 * LLVM Release License
 * ==============================================================================
 * University of Illinois/NCSA
 * Open Source License
 * 
 * Copyright (c) 2003-2017 University of Illinois at Urbana-Champaign.
 * All rights reserved.
 * 
 * Developed by:
 * 
 *     LLVM Team
 * 
 *     University of Illinois at Urbana-Champaign
 * 
 *     http://llvm.org
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal with
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 * 
 *     * Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimers.
 * 
 *     * Redistributions in binary form must reproduce the above copyright notice
 *       this list of conditions and the following disclaimers in the
 *       documentation and/or other materials provided with the distribution.
 * 
 *     * Neither the names of the LLVM Team, University of Illinois at
 *       Urbana-Champaign, nor the names of its contributors may be used to
 *       endorse or promote products derived from this Software without specific
 *       prior written permission.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.  IN NO EVENT SHALL THE
 * CONTRIBUTORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS WITH THE
 * SOFTWARE.
 * 
 * ==============================================================================
 * Copyrights and Licenses for Third Party Software Distributed with LLVM:
 * ==============================================================================
 * The LLVM software contains code written by third parties.  Such software will
 * have its own individual LICENSE.TXT file in the directory in which it appears.
 * This file will describe the copyrights, license, and restrictions which apply
 * to that code.
 * 
 * The disclaimer of warranty in the University of Illinois Open Source License
 * applies to all code in the LLVM Distribution, and nothing in any of the
 * other licenses gives permission to use the names of the LLVM Team or the
 * University of Illinois to endorse or promote products derived from this
 * Software.
 * 
 * The following pieces of software have additional or alternate copyrights,
 * licenses, and/or restrictions:
 * 
 * Program             Directory
 * -------             ---------
 * Autoconf            llvm/autoconf
 *                     llvm/projects/ModuleMaker/autoconf
 * Google Test         llvm/utils/unittest/googletest
 * OpenBSD regex       llvm/lib/Support/{reg*, COPYRIGHT.regex}
 * pyyaml tests        llvm/test/YAMLParser/{*.data, LICENSE.TXT}
 * ARM contributions   llvm/lib/Target/ARM/LICENSE.TXT
 * md5 contributions   llvm/lib/Support/MD5.cpp llvm/include/llvm/Support/MD5.h
 */

package org.clang.codegen.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.*;
import org.clang.codegen.CodeGen.impl.*;
import org.llvm.ir.CallingConv;
import org.clang.ast.aliases.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.llvm.ir.java.IrRTTI.*;
import static org.clang.ast.java.AstJavaDifferentiators.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 41,
 FQN="(anonymous namespace)::ItaniumCXXABI", NM="_ZN12_GLOBAL__N_113ItaniumCXXABIE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABIE")
//</editor-fold>
public class ItaniumCXXABI extends /*public*/ CGCXXABI implements Destructors.ClassWithDestructor {
  /// VTables - All the vtables which have been defined.
  private DenseMap</*const*/ CXXRecordDecl /*P*/ , GlobalVariable /*P*/ > VTables;
/*protected:*/
  protected boolean UseARMMethodPtrABI;
  protected boolean UseARMGuardVarABI;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::getMangleContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 49,
   FQN="(anonymous namespace)::ItaniumCXXABI::getMangleContext", NM="_ZN12_GLOBAL__N_113ItaniumCXXABI16getMangleContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABI16getMangleContextEv")
  //</editor-fold>
  public/*protected*/ ItaniumMangleContext /*&*/ getMangleContext() {
    return cast_ItaniumMangleContext(super.getMangleContext());
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::ItaniumCXXABI">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 54,
   FQN="(anonymous namespace)::ItaniumCXXABI::ItaniumCXXABI", NM="_ZN12_GLOBAL__N_113ItaniumCXXABIC1ERN5clang7CodeGen13CodeGenModuleEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABIC1ERN5clang7CodeGen13CodeGenModuleEbb")
  //</editor-fold>
  public ItaniumCXXABI(final CodeGenModule /*&*/ CGM) {
    this(CGM, 
      false, 
      false);
  }
  public ItaniumCXXABI(final CodeGenModule /*&*/ CGM, 
      boolean UseARMMethodPtrABI/*= false*/) {
    this(CGM, 
      UseARMMethodPtrABI, 
      false);
  }
  public ItaniumCXXABI(final CodeGenModule /*&*/ CGM, 
      boolean UseARMMethodPtrABI/*= false*/, 
      boolean UseARMGuardVarABI/*= false*/) {
    // : CGCXXABI(CGM), VTables(), UseARMMethodPtrABI(UseARMMethodPtrABI), UseARMGuardVarABI(UseARMGuardVarABI) 
    //START JInit
    super(CGM);
    this.VTables = new DenseMap</*const*/ CXXRecordDecl /*P*/ , GlobalVariable /*P*/ >(DenseMapInfo$LikePtr.$Info(), (GlobalVariable /*P*/ )null);
    this.UseARMMethodPtrABI = UseARMMethodPtrABI;
    this.UseARMGuardVarABI = UseARMGuardVarABI;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::classifyReturnType">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 972,
   FQN="(anonymous namespace)::ItaniumCXXABI::classifyReturnType", NM="_ZNK12_GLOBAL__N_113ItaniumCXXABI18classifyReturnTypeERN5clang7CodeGen14CGFunctionInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZNK12_GLOBAL__N_113ItaniumCXXABI18classifyReturnTypeERN5clang7CodeGen14CGFunctionInfoE")
  //</editor-fold>
  @Override public boolean classifyReturnType(final CGFunctionInfo /*&*/ FI) /*const*//* override*/ {
    /*const*/ CXXRecordDecl /*P*/ RD = ((CanProxyType)FI.getReturnType().$arrow()).$arrow().getAsCXXRecordDecl();
    if (!(RD != null)) {
      return false;
    }
    
    // Return indirectly if we have a non-trivial copy ctor or non-trivial dtor.
    // FIXME: Use canCopyArgument() when it is fixed to handle lazily declared
    // special members.
    if (RD.hasNonTrivialDestructor() || RD.hasNonTrivialCopyConstructor()) {
      CharUnits Align = CGM.getContext().getTypeAlignInChars(FI.getReturnType().$QualType());
      FI.getReturnInfo().$assignMove(ABIArgInfo.getIndirect(new CharUnits(Align), /*ByVal=*/ false));
      return true;
    }
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::getRecordArgABI">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 62,
   FQN="(anonymous namespace)::ItaniumCXXABI::getRecordArgABI", NM="_ZNK12_GLOBAL__N_113ItaniumCXXABI15getRecordArgABIEPKN5clang13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZNK12_GLOBAL__N_113ItaniumCXXABI15getRecordArgABIEPKN5clang13CXXRecordDeclE")
  //</editor-fold>
  @Override public CGCXXABI.RecordArgABI getRecordArgABI(/*const*/ CXXRecordDecl /*P*/ RD) /*const*//* override*/ {
    // Structures with either a non-trivial destructor or a non-trivial
    // copy constructor are always indirect.
    // FIXME: Use canCopyArgument() when it is fixed to handle lazily declared
    // special members.
    if (RD.hasNonTrivialDestructor() || RD.hasNonTrivialCopyConstructor()) {
      return RecordArgABI.RAA_Indirect;
    }
    return RecordArgABI.RAA_Default;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::isThisCompleteObject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 72,
   FQN="(anonymous namespace)::ItaniumCXXABI::isThisCompleteObject", NM="_ZNK12_GLOBAL__N_113ItaniumCXXABI20isThisCompleteObjectEN5clang10GlobalDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZNK12_GLOBAL__N_113ItaniumCXXABI20isThisCompleteObjectEN5clang10GlobalDeclE")
  //</editor-fold>
  @Override public boolean isThisCompleteObject(GlobalDecl GD) /*const*//* override*/ {
    // The Itanium ABI has separate complete-object vs.  base-object
    // variants of both constructors and destructors.
    if (isa_CXXDestructorDecl(GD.getDecl())) {
      switch (GD.getDtorType()) {
       case Dtor_Complete:
       case Dtor_Deleting:
        return true;
       case Dtor_Base:
        return false;
       case Dtor_Comdat:
        throw new llvm_unreachable("emitting dtor comdat as function?");
      }
      throw new llvm_unreachable("bad dtor kind");
    }
    if (isa_CXXConstructorDecl(GD.getDecl())) {
      switch (GD.getCtorType()) {
       case Ctor_Complete:
        return true;
       case Ctor_Base:
        return false;
       case Ctor_CopyingClosure:
       case Ctor_DefaultClosure:
        throw new llvm_unreachable("closure ctors in Itanium ABI?");
       case Ctor_Comdat:
        throw new llvm_unreachable("emitting ctor comdat as function?");
      }
      throw new llvm_unreachable("bad dtor kind");
    }
    
    // No other kinds.
    return false;
  }

  
  
  /// The Itanium ABI requires non-zero initialization only for data
  /// member pointers, for which '0' is a valid offset.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::isZeroInitializable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 990,
   FQN="(anonymous namespace)::ItaniumCXXABI::isZeroInitializable", NM="_ZN12_GLOBAL__N_113ItaniumCXXABI19isZeroInitializableEPKN5clang17MemberPointerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABI19isZeroInitializableEPKN5clang17MemberPointerTypeE")
  //</editor-fold>
  @Override public boolean isZeroInitializable(/*const*/ MemberPointerType /*P*/ MPT)/* override*/ {
    return MPT.isMemberFunctionPointer();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::ConvertMemberPointerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 492,
   FQN="(anonymous namespace)::ItaniumCXXABI::ConvertMemberPointerType", NM="_ZN12_GLOBAL__N_113ItaniumCXXABI24ConvertMemberPointerTypeEPKN5clang17MemberPointerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABI24ConvertMemberPointerTypeEPKN5clang17MemberPointerTypeE")
  //</editor-fold>
  @Override public org.llvm.ir.Type /*P*/ ConvertMemberPointerType(/*const*/ MemberPointerType /*P*/ MPT)/* override*/ {
    if (MPT.isMemberDataPointer()) {
      return CGM.Unnamed_field8.PtrDiffTy;
    }
    return StructType.get(CGM.Unnamed_field8.PtrDiffTy, CGM.Unnamed_field8.PtrDiffTy, null);
  }

  
  
  /// In the Itanium and ARM ABIs, method pointers have the form:
  ///   struct { ptrdiff_t ptr; ptrdiff_t adj; } memptr;
  ///
  /// In the Itanium ABI:
  ///  - method pointers are virtual if (memptr.ptr & 1) is nonzero
  ///  - the this-adjustment is (memptr.adj)
  ///  - the virtual offset is (memptr.ptr - 1)
  ///
  /// In the ARM ABI:
  ///  - method pointers are virtual if (memptr.adj & 1) is nonzero
  ///  - the this-adjustment is (memptr.adj >> 1)
  ///  - the virtual offset is (memptr.ptr)
  /// ARM uses 'adj' for the virtual flag because Thumb functions
  /// may be only single-byte aligned.
  ///
  /// If the member is virtual, the adjusted 'this' pointer points
  /// to a vtable pointer from which the virtual offset is applied.
  ///
  /// If the member is non-virtual, memptr.ptr is the address of
  /// the function to call.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::EmitLoadOfMemberFunctionPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 519,
   FQN="(anonymous namespace)::ItaniumCXXABI::EmitLoadOfMemberFunctionPointer", NM="_ZN12_GLOBAL__N_113ItaniumCXXABI31EmitLoadOfMemberFunctionPointerERN5clang7CodeGen15CodeGenFunctionEPKNS1_4ExprENS2_7AddressERPN4llvm5ValueESB_PKNS1_17MemberPointerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABI31EmitLoadOfMemberFunctionPointerERN5clang7CodeGen15CodeGenFunctionEPKNS1_4ExprENS2_7AddressERPN4llvm5ValueESB_PKNS1_17MemberPointerTypeE")
  //</editor-fold>
  @Override public Value /*P*/ EmitLoadOfMemberFunctionPointer(final CodeGenFunction /*&*/ CGF, /*const*/ Expr /*P*/ E, Address ThisAddr, 
                                 final type$ref<Value /*P*/ /*&*/> ThisPtrForCall, 
                                 Value /*P*/ MemFnPtr, /*const*/ MemberPointerType /*P*/ MPT)/* override*/ {
    final CGBuilderTy /*&*/ Builder = CGF.Builder;
    
    /*const*/ FunctionProtoType /*P*/ FPT = MPT.getPointeeType().$arrow().getAs(FunctionProtoType.class);
    /*const*/ CXXRecordDecl /*P*/ RD = cast_CXXRecordDecl(MPT.__getClass().getAs$RecordType().getDecl());
    
    org.llvm.ir.FunctionType /*P*/ FTy = CGM.getTypes().GetFunctionType(CGM.getTypes().arrangeCXXMethodType(RD, FPT, /*FD=*/ (/*const*/ CXXMethodDecl /*P*/ )null));
    
    Constant /*P*/ ptrdiff_1 = ConstantInt.get(CGM.Unnamed_field8.PtrDiffTy, $int2ulong(1));
    
    BasicBlock /*P*/ FnVirtual = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"memptr.virtual"));
    BasicBlock /*P*/ FnNonVirtual = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"memptr.nonvirtual"));
    BasicBlock /*P*/ FnEnd = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"memptr.end"));
    
    // Extract memptr.adj, which is in the second field.
    Value /*P*/ RawAdj = Builder.CreateExtractValue(MemFnPtr, new ArrayRefUInt(1), new Twine(/*KEEP_STR*/"memptr.adj"));
    
    // Compute the true adjustment.
    Value /*P*/ Adj = RawAdj;
    if (UseARMMethodPtrABI) {
      Adj = Builder.CreateAShr(Adj, ptrdiff_1, new Twine(/*KEEP_STR*/"memptr.adj.shifted"));
    }
    
    // Apply the adjustment and cast back to the original struct type
    // for consistency.
    Value /*P*/ This = ThisAddr.getPointer();
    Value /*P*/ Ptr = Builder.CreateBitCast(This, Builder.getInt8PtrTy());
    Ptr = Builder.CreateInBoundsGEP(Ptr, new ArrayRef<Value /*P*/ >(Adj, true));
    This = Builder.CreateBitCast(Ptr, This.getType(), new Twine(/*KEEP_STR*/"this.adjusted"));
    ThisPtrForCall.$set(This);
    
    // Load the function pointer.
    Value /*P*/ FnAsInt = Builder.CreateExtractValue(MemFnPtr, new ArrayRefUInt(0), new Twine(/*KEEP_STR*/"memptr.ptr"));
    
    // If the LSB in the function pointer is 1, the function pointer points to
    // a virtual function.
    Value /*P*/ IsVirtual;
    if (UseARMMethodPtrABI) {
      IsVirtual = Builder.CreateAnd(RawAdj, ptrdiff_1);
    } else {
      IsVirtual = Builder.CreateAnd(FnAsInt, ptrdiff_1);
    }
    IsVirtual = Builder.CreateIsNotNull(IsVirtual, new Twine(/*KEEP_STR*/"memptr.isvirtual"));
    Builder.CreateCondBr(IsVirtual, FnVirtual, FnNonVirtual);
    
    // In the virtual path, the adjustment left 'This' pointing to the
    // vtable of the correct base subobject.  The "function pointer" is an
    // offset within the vtable (+1 for the virtual flag on non-ARM).
    CGF.EmitBlock(FnVirtual);
    
    // Cast the adjusted this to a pointer to vtable pointer and load.
    org.llvm.ir.Type /*P*/ VTableTy = Builder.getInt8PtrTy();
    CharUnits VTablePtrAlign = CGF.CGM.getDynamicOffsetAlignment(ThisAddr.getAlignment(), RD, 
        CGF.getPointerAlign());
    Value /*P*/ VTable = CGF.GetVTablePtr(new Address(This, new CharUnits(VTablePtrAlign)), VTableTy, RD);
    
    // Apply the offset.
    Value /*P*/ VTableOffset = FnAsInt;
    if (!UseARMMethodPtrABI) {
      VTableOffset = Builder.CreateSub(VTableOffset, ptrdiff_1);
    }
    VTable = Builder.CreateGEP(VTable, VTableOffset);
    
    // Load the virtual function to call.
    VTable = Builder.CreateBitCast(VTable, FTy.getPointerTo().getPointerTo());
    Value /*P*/ VirtualFn = Builder.CreateAlignedLoad(VTable, CGF.getPointerAlign(), 
        $("memptr.virtualfn"));
    CGF.EmitBranch(FnEnd);
    
    // In the non-virtual path, the function pointer is actually a
    // function pointer.
    CGF.EmitBlock(FnNonVirtual);
    Value /*P*/ NonVirtualFn = Builder.CreateIntToPtr(FnAsInt, FTy.getPointerTo(), new Twine(/*KEEP_STR*/"memptr.nonvirtualfn"));
    
    // We're done.
    CGF.EmitBlock(FnEnd);
    PHINode /*P*/ Callee = Builder.CreatePHI(FTy.getPointerTo(), 2);
    Callee.addIncoming(VirtualFn, FnVirtual);
    Callee.addIncoming(NonVirtualFn, FnNonVirtual);
    return Callee;
  }

  
  
  /// Compute an l-value by applying the given pointer-to-member to a
  /// base object.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::EmitMemberDataPointerAddress">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 610,
   FQN="(anonymous namespace)::ItaniumCXXABI::EmitMemberDataPointerAddress", NM="_ZN12_GLOBAL__N_113ItaniumCXXABI28EmitMemberDataPointerAddressERN5clang7CodeGen15CodeGenFunctionEPKNS1_4ExprENS2_7AddressEPN4llvm5ValueEPKNS1_17MemberPointerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABI28EmitMemberDataPointerAddressERN5clang7CodeGen15CodeGenFunctionEPKNS1_4ExprENS2_7AddressEPN4llvm5ValueEPKNS1_17MemberPointerTypeE")
  //</editor-fold>
  @Override public Value /*P*/ EmitMemberDataPointerAddress(final CodeGenFunction /*&*/ CGF, /*const*/ Expr /*P*/ E, Address Base, Value /*P*/ MemPtr, 
                              /*const*/ MemberPointerType /*P*/ MPT)/* override*/ {
    assert (MemPtr.getType() == CGM.Unnamed_field8.PtrDiffTy);
    
    final CGBuilderTy /*&*/ Builder = CGF.Builder;
    
    // Cast to char*.
    Base.$assignMove(Builder.CreateElementBitCast(new Address(Base), CGF.Int8Ty));
    
    // Apply the offset, which we assume is non-null.
    Value /*P*/ Addr = Builder.CreateInBoundsGEP(Base.getPointer(), new ArrayRef<Value /*P*/ >(MemPtr, true), new Twine(/*KEEP_STR*/"memptr.offset"));
    
    // Cast the address to the appropriate pointer type, adopting the
    // address space of the base pointer.
    org.llvm.ir.Type /*P*/ PType = CGF.ConvertTypeForMem(MPT.getPointeeType()).
        getPointerTo(Base.getAddressSpace());
    return Builder.CreateBitCast(Addr, PType);
  }

  
  
  /// Perform a bitcast, derived-to-base, or base-to-derived member pointer
  /// conversion.
  ///
  /// Bitcast conversions are always a no-op under Itanium.
  ///
  /// Obligatory offset/adjustment diagram:
  ///         <-- offset -->          <-- adjustment -->
  ///   |--------------------------|----------------------|--------------------|
  ///   ^Derived address point     ^Base address point    ^Member address point
  ///
  /// So when converting a base member pointer to a derived member pointer,
  /// we add the offset to the adjustment because the address point has
  /// decreased;  and conversely, when converting a derived MP to a base MP
  /// we subtract the offset from the adjustment because the address point
  /// has increased.
  ///
  /// The standard forbids (at compile time) conversion to and from
  /// virtual bases, which is why we don't have to consider them here.
  ///
  /// The standard forbids (at run time) casting a derived MP to a base
  /// MP when the derived MP does not point to a member of the base.
  /// This is why -1 is a reasonable choice for null data member
  /// pointers.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::EmitMemberPointerConversion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 654,
   FQN="(anonymous namespace)::ItaniumCXXABI::EmitMemberPointerConversion", NM="_ZN12_GLOBAL__N_113ItaniumCXXABI27EmitMemberPointerConversionERN5clang7CodeGen15CodeGenFunctionEPKNS1_8CastExprEPN4llvm5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABI27EmitMemberPointerConversionERN5clang7CodeGen15CodeGenFunctionEPKNS1_8CastExprEPN4llvm5ValueE")
  //</editor-fold>
  @Override public Value /*P*/ EmitMemberPointerConversion(final CodeGenFunction /*&*/ CGF, 
                             /*const*/ CastExpr /*P*/ E, 
                             Value /*P*/ src)/* override*/ {
    assert (E.getCastKind() == CastKind.CK_DerivedToBaseMemberPointer || E.getCastKind() == CastKind.CK_BaseToDerivedMemberPointer || E.getCastKind() == CastKind.CK_ReinterpretMemberPointer);
    
    // Under Itanium, reinterprets don't require any additional processing.
    if (E.getCastKind() == CastKind.CK_ReinterpretMemberPointer) {
      return src;
    }
    
    // Use constant emission if we can.
    if (isa_Constant(src)) {
      return EmitMemberPointerConversion(E, cast_Constant(src));
    }
    
    Constant /*P*/ adj = getMemberPointerAdjustment(E);
    if (!(adj != null)) {
      return src;
    }
    
    final CGBuilderTy /*&*/ Builder = CGF.Builder;
    boolean isDerivedToBase = (E.getCastKind() == CastKind.CK_DerivedToBaseMemberPointer);
    
    /*const*/ MemberPointerType /*P*/ destTy = E.getType().$arrow().castAs(MemberPointerType.class);
    
    // For member data pointers, this is just a matter of adding the
    // offset if the source is non-null.
    if (destTy.isMemberDataPointer()) {
      Value /*P*/ dst;
      if (isDerivedToBase) {
        dst = Builder.CreateNSWSub(src, adj, new Twine(/*KEEP_STR*/"adj"));
      } else {
        dst = Builder.CreateNSWAdd(src, adj, new Twine(/*KEEP_STR*/"adj"));
      }
      
      // Null check.
      Value /*P*/ __null = Constant.getAllOnesValue(src.getType());
      Value /*P*/ isNull = Builder.CreateICmpEQ(src, __null, new Twine(/*KEEP_STR*/"memptr.isnull"));
      return Builder.CreateSelect(isNull, src, dst);
    }
    
    // The this-adjustment is left-shifted by 1 on ARM.
    if (UseARMMethodPtrABI) {
      long/*uint64_t*/ offset = cast_ConstantInt(adj).getZExtValue();
      offset <<= 1;
      adj = ConstantInt.get(adj.getType(), offset);
    }
    
    Value /*P*/ srcAdj = Builder.CreateExtractValue(src, new ArrayRefUInt(1), new Twine(/*KEEP_STR*/"src.adj"));
    Value /*P*/ dstAdj;
    if (isDerivedToBase) {
      dstAdj = Builder.CreateNSWSub(srcAdj, adj, new Twine(/*KEEP_STR*/"adj"));
    } else {
      dstAdj = Builder.CreateNSWAdd(srcAdj, adj, new Twine(/*KEEP_STR*/"adj"));
    }
    
    return Builder.CreateInsertValue(src, dstAdj, new ArrayRefUInt(1));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::EmitMemberPointerConversion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 710,
   FQN="(anonymous namespace)::ItaniumCXXABI::EmitMemberPointerConversion", NM="_ZN12_GLOBAL__N_113ItaniumCXXABI27EmitMemberPointerConversionEPKN5clang8CastExprEPN4llvm8ConstantE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABI27EmitMemberPointerConversionEPKN5clang8CastExprEPN4llvm8ConstantE")
  //</editor-fold>
  @Override public Constant /*P*/ EmitMemberPointerConversion(/*const*/ CastExpr /*P*/ E, 
                             Constant /*P*/ src)/* override*/ {
    assert (E.getCastKind() == CastKind.CK_DerivedToBaseMemberPointer || E.getCastKind() == CastKind.CK_BaseToDerivedMemberPointer || E.getCastKind() == CastKind.CK_ReinterpretMemberPointer);
    
    // Under Itanium, reinterprets don't require any additional processing.
    if (E.getCastKind() == CastKind.CK_ReinterpretMemberPointer) {
      return src;
    }
    
    // If the adjustment is trivial, we don't need to do anything.
    Constant /*P*/ adj = getMemberPointerAdjustment(E);
    if (!(adj != null)) {
      return src;
    }
    
    boolean isDerivedToBase = (E.getCastKind() == CastKind.CK_DerivedToBaseMemberPointer);
    
    /*const*/ MemberPointerType /*P*/ destTy = E.getType().$arrow().castAs(MemberPointerType.class);
    
    // For member data pointers, this is just a matter of adding the
    // offset if the source is non-null.
    if (destTy.isMemberDataPointer()) {
      // null maps to null.
      if (src.isAllOnesValue()) {
        return src;
      }
      if (isDerivedToBase) {
        return ConstantExpr.getNSWSub(src, adj);
      } else {
        return ConstantExpr.getNSWAdd(src, adj);
      }
    }
    
    // The this-adjustment is left-shifted by 1 on ARM.
    if (UseARMMethodPtrABI) {
      long/*uint64_t*/ offset = cast_ConstantInt(adj).getZExtValue();
      offset <<= 1;
      adj = ConstantInt.get(adj.getType(), offset);
    }
    
    Constant /*P*/ srcAdj = ConstantExpr.getExtractValue(src, new ArrayRefUInt(1));
    Constant /*P*/ dstAdj;
    if (isDerivedToBase) {
      dstAdj = ConstantExpr.getNSWSub(srcAdj, adj);
    } else {
      dstAdj = ConstantExpr.getNSWAdd(srcAdj, adj);
    }
    
    return ConstantExpr.getInsertValue(src, dstAdj, new ArrayRefUInt(1));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::EmitNullMemberPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 758,
   FQN="(anonymous namespace)::ItaniumCXXABI::EmitNullMemberPointer", NM="_ZN12_GLOBAL__N_113ItaniumCXXABI21EmitNullMemberPointerEPKN5clang17MemberPointerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABI21EmitNullMemberPointerEPKN5clang17MemberPointerTypeE")
  //</editor-fold>
  @Override public Constant /*P*/ EmitNullMemberPointer(/*const*/ MemberPointerType /*P*/ MPT)/* override*/ {
    // Itanium C++ ABI 2.3:
    //   A NULL pointer is represented as -1.
    if (MPT.isMemberDataPointer()) {
      return ConstantInt.get(CGM.Unnamed_field8.PtrDiffTy, -1L/*ULL*/, /*isSigned=*/ true);
    }
    
    Constant /*P*/ Zero = ConstantInt.get(CGM.Unnamed_field8.PtrDiffTy, $int2ulong(0));
    Constant /*P*/ Values[/*2*/] = new Constant /*P*/  [/*2*/] {Zero, Zero};
    return ConstantStruct.getAnon(new ArrayRef<Constant /*P*/ >(Values, true));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::EmitMemberFunctionPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 779,
   FQN="(anonymous namespace)::ItaniumCXXABI::EmitMemberFunctionPointer", NM="_ZN12_GLOBAL__N_113ItaniumCXXABI25EmitMemberFunctionPointerEPKN5clang13CXXMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABI25EmitMemberFunctionPointerEPKN5clang13CXXMethodDeclE")
  //</editor-fold>
  @Override public Constant /*P*/ EmitMemberFunctionPointer(/*const*/ CXXMethodDecl /*P*/ MD)/* override*/ {
    return BuildMemberPointer(MD, CharUnits.Zero());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::EmitMemberDataPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 770,
   FQN="(anonymous namespace)::ItaniumCXXABI::EmitMemberDataPointer", NM="_ZN12_GLOBAL__N_113ItaniumCXXABI21EmitMemberDataPointerEPKN5clang17MemberPointerTypeENS1_9CharUnitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABI21EmitMemberDataPointerEPKN5clang17MemberPointerTypeENS1_9CharUnitsE")
  //</editor-fold>
  @Override public Constant /*P*/ EmitMemberDataPointer(/*const*/ MemberPointerType /*P*/ MPT, 
                       CharUnits offset)/* override*/ {
    // Itanium C++ ABI 2.3:
    //   A pointer to data member is an offset from the base address of
    //   the class object containing it, represented as a ptrdiff_t
    return ConstantInt.get(CGM.Unnamed_field8.PtrDiffTy, offset.getQuantity());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::EmitMemberPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 843,
   FQN="(anonymous namespace)::ItaniumCXXABI::EmitMemberPointer", NM="_ZN12_GLOBAL__N_113ItaniumCXXABI17EmitMemberPointerERKN5clang7APValueENS1_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABI17EmitMemberPointerERKN5clang7APValueENS1_8QualTypeE")
  //</editor-fold>
  @Override public Constant /*P*/ EmitMemberPointer(final /*const*/ APValue /*&*/ MP, 
                   QualType MPType)/* override*/ {
    /*const*/ MemberPointerType /*P*/ MPT = MPType.$arrow().castAs(MemberPointerType.class);
    /*const*/ ValueDecl /*P*/ MPD = MP.getMemberPointerDecl();
    if (!(MPD != null)) {
      return EmitNullMemberPointer(MPT);
    }
    
    CharUnits ThisAdjustment = getMemberPointerPathAdjustment(MP);
    {
      
      /*const*/ CXXMethodDecl /*P*/ MD = dyn_cast_CXXMethodDecl(MPD);
      if ((MD != null)) {
        return BuildMemberPointer(MD, new CharUnits(ThisAdjustment));
      }
    }
    
    CharUnits FieldOffset = getContext().toCharUnitsFromBits(getContext().getFieldOffset(MPD));
    return EmitMemberDataPointer(MPT, ThisAdjustment.$add(FieldOffset));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::BuildMemberPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 784,
   FQN="(anonymous namespace)::ItaniumCXXABI::BuildMemberPointer", NM="_ZN12_GLOBAL__N_113ItaniumCXXABI18BuildMemberPointerEPKN5clang13CXXMethodDeclENS1_9CharUnitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABI18BuildMemberPointerEPKN5clang13CXXMethodDeclENS1_9CharUnitsE")
  //</editor-fold>
  public Constant /*P*/ BuildMemberPointer(/*const*/ CXXMethodDecl /*P*/ MD, 
                    CharUnits ThisAdjustment) {
    assert (MD.isInstance()) : "Member function must not be static!";
    MD = MD.getCanonicalDecl$Const();
    
    final CodeGenTypes /*&*/ Types = CGM.getTypes();
    
    // Get the function pointer (or index if this is a virtual function).
    Constant /*P*/ MemPtr[/*2*/] = new Constant /*P*/  [2];
    if (MD.isVirtual()) {
      long/*uint64_t*/ Index = CGM.getItaniumVTableContext().getMethodVTableIndex(new GlobalDecl(MD));
      
      final /*const*/ ASTContext /*&*/ Context = getContext();
      CharUnits PointerWidth = Context.toCharUnitsFromBits(Context.getTargetInfo().getPointerWidth(0));
      long/*uint64_t*/ VTableOffset = (Index * PointerWidth.getQuantity());
      if (UseARMMethodPtrABI) {
        // ARM C++ ABI 3.2.1:
        //   This ABI specifies that adj contains twice the this
        //   adjustment, plus 1 if the member function is virtual. The
        //   least significant bit of adj then makes exactly the same
        //   discrimination as the least significant bit of ptr does for
        //   Itanium.
        MemPtr[0] = ConstantInt.get(CGM.Unnamed_field8.PtrDiffTy, VTableOffset);
        MemPtr[1] = ConstantInt.get(CGM.Unnamed_field8.PtrDiffTy, 
            2 * ThisAdjustment.getQuantity() + 1);
      } else {
        // Itanium C++ ABI 2.3:
        //   For a virtual function, [the pointer field] is 1 plus the
        //   virtual table offset (in bytes) of the function,
        //   represented as a ptrdiff_t.
        MemPtr[0] = ConstantInt.get(CGM.Unnamed_field8.PtrDiffTy, VTableOffset + $int2ullong(1));
        MemPtr[1] = ConstantInt.get(CGM.Unnamed_field8.PtrDiffTy, 
            ThisAdjustment.getQuantity());
      }
    } else {
      /*const*/ FunctionProtoType /*P*/ FPT = MD.getType().$arrow().castAs(FunctionProtoType.class);
      org.llvm.ir.Type /*P*/ Ty;
      // Check whether the function has a computable LLVM signature.
      if (Types.isFuncTypeConvertible(FPT)) {
        // The function has a computable LLVM signature; use the correct type.
        Ty = Types.GetFunctionType(Types.arrangeCXXMethodDeclaration(MD));
      } else {
        // Use an arbitrary non-function type to tell GetAddrOfFunction that the
        // function type is incomplete.
        Ty = CGM.Unnamed_field8.PtrDiffTy;
      }
      Constant /*P*/ addr = CGM.GetAddrOfFunction(new GlobalDecl(MD), Ty);
      
      MemPtr[0] = ConstantExpr.getPtrToInt(addr, CGM.Unnamed_field8.PtrDiffTy);
      MemPtr[1] = ConstantInt.get(CGM.Unnamed_field8.PtrDiffTy, 
          (UseARMMethodPtrABI ? 2 : 1)
             * ThisAdjustment.getQuantity());
    }
    
    return ConstantStruct.getAnon(new ArrayRef<Constant /*P*/ >(MemPtr, true));
  }

  
  
  /// The comparison algorithm is pretty easy: the member pointers are
  /// the same if they're either bitwise identical *or* both null.
  ///
  /// ARM is different here only because null-ness is more complicated.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::EmitMemberPointerComparison">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 864,
   FQN="(anonymous namespace)::ItaniumCXXABI::EmitMemberPointerComparison", NM="_ZN12_GLOBAL__N_113ItaniumCXXABI27EmitMemberPointerComparisonERN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueES7_PKNS1_17MemberPointerTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABI27EmitMemberPointerComparisonERN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueES7_PKNS1_17MemberPointerTypeEb")
  //</editor-fold>
  @Override public Value /*P*/ EmitMemberPointerComparison(final CodeGenFunction /*&*/ CGF, 
                             Value /*P*/ L, 
                             Value /*P*/ R, 
                             /*const*/ MemberPointerType /*P*/ MPT, 
                             boolean Inequality)/* override*/ {
    final CGBuilderTy /*&*/ Builder = CGF.Builder;
    
    ICmpInst.Predicate Eq;
    /*BinaryOps*/int And;
    /*BinaryOps*/int Or;
    if (Inequality) {
      Eq = ICmpInst.Predicate.ICMP_NE;
      And = Instruction.BinaryOps.Or;
      Or = Instruction.BinaryOps.And;
    } else {
      Eq = ICmpInst.Predicate.ICMP_EQ;
      And = Instruction.BinaryOps.And;
      Or = Instruction.BinaryOps.Or;
    }
    
    // Member data pointers are easy because there's a unique null
    // value, so it just comes down to bitwise equality.
    if (MPT.isMemberDataPointer()) {
      return Builder.CreateICmp(Eq, L, R);
    }
    
    // For member function pointers, the tautologies are more complex.
    // The Itanium tautology is:
    //   (L == R) <==> (L.ptr == R.ptr && (L.ptr == 0 || L.adj == R.adj))
    // The ARM tautology is:
    //   (L == R) <==> (L.ptr == R.ptr &&
    //                  (L.adj == R.adj ||
    //                   (L.ptr == 0 && ((L.adj|R.adj) & 1) == 0)))
    // The inequality tautologies have exactly the same structure, except
    // applying De Morgan's laws.
    Value /*P*/ LPtr = Builder.CreateExtractValue(L, new ArrayRefUInt(0), new Twine(/*KEEP_STR*/"lhs.memptr.ptr"));
    Value /*P*/ RPtr = Builder.CreateExtractValue(R, new ArrayRefUInt(0), new Twine(/*KEEP_STR*/"rhs.memptr.ptr"));
    
    // This condition tests whether L.ptr == R.ptr.  This must always be
    // true for equality to hold.
    Value /*P*/ PtrEq = Builder.CreateICmp(Eq, LPtr, RPtr, new Twine(/*KEEP_STR*/"cmp.ptr"));
    
    // This condition, together with the assumption that L.ptr == R.ptr,
    // tests whether the pointers are both null.  ARM imposes an extra
    // condition.
    Value /*P*/ Zero = Constant.getNullValue(LPtr.getType());
    Value /*P*/ EqZero = Builder.CreateICmp(Eq, LPtr, Zero, new Twine(/*KEEP_STR*/"cmp.ptr.null"));
    
    // This condition tests whether L.adj == R.adj.  If this isn't
    // true, the pointers are unequal unless they're both null.
    Value /*P*/ LAdj = Builder.CreateExtractValue(L, new ArrayRefUInt(1), new Twine(/*KEEP_STR*/"lhs.memptr.adj"));
    Value /*P*/ RAdj = Builder.CreateExtractValue(R, new ArrayRefUInt(1), new Twine(/*KEEP_STR*/"rhs.memptr.adj"));
    Value /*P*/ AdjEq = Builder.CreateICmp(Eq, LAdj, RAdj, new Twine(/*KEEP_STR*/"cmp.adj"));
    
    // Null member function pointers on ARM clear the low bit of Adj,
    // so the zero condition has to check that neither low bit is set.
    if (UseARMMethodPtrABI) {
      Value /*P*/ One = ConstantInt.get(LPtr.getType(), $int2ulong(1));
      
      // Compute (l.adj | r.adj) & 1 and test it against zero.
      Value /*P*/ OrAdj = Builder.CreateOr(LAdj, RAdj, new Twine(/*KEEP_STR*/"or.adj"));
      Value /*P*/ OrAdjAnd1 = Builder.CreateAnd(OrAdj, One);
      Value /*P*/ OrAdjAnd1EqZero = Builder.CreateICmp(Eq, OrAdjAnd1, Zero, 
          new Twine(/*KEEP_STR*/"cmp.or.adj"));
      EqZero = Builder.CreateBinOp(And, EqZero, OrAdjAnd1EqZero);
    }
    
    // Tie together all our conditions.
    Value /*P*/ Result = Builder.CreateBinOp(Or, EqZero, AdjEq);
    Result = Builder.CreateBinOp(And, PtrEq, Result, 
        new Twine(Inequality ? $("memptr.ne") : $("memptr.eq")));
    return Result;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::EmitMemberPointerIsNotNull">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 938,
   FQN="(anonymous namespace)::ItaniumCXXABI::EmitMemberPointerIsNotNull", NM="_ZN12_GLOBAL__N_113ItaniumCXXABI26EmitMemberPointerIsNotNullERN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueEPKNS1_17MemberPointerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABI26EmitMemberPointerIsNotNullERN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueEPKNS1_17MemberPointerTypeE")
  //</editor-fold>
  @Override public Value /*P*/ EmitMemberPointerIsNotNull(final CodeGenFunction /*&*/ CGF, 
                            Value /*P*/ MemPtr, 
                            /*const*/ MemberPointerType /*P*/ MPT)/* override*/ {
    final CGBuilderTy /*&*/ Builder = CGF.Builder;
    
    /// For member data pointers, this is just a check against -1.
    if (MPT.isMemberDataPointer()) {
      assert (MemPtr.getType() == CGM.Unnamed_field8.PtrDiffTy);
      Value /*P*/ NegativeOne = Constant.getAllOnesValue(MemPtr.getType());
      return Builder.CreateICmpNE(MemPtr, NegativeOne, new Twine(/*KEEP_STR*/"memptr.tobool"));
    }
    
    // In Itanium, a member function pointer is not null if 'ptr' is not null.
    Value /*P*/ Ptr = Builder.CreateExtractValue(MemPtr, new ArrayRefUInt(0), new Twine(/*KEEP_STR*/"memptr.ptr"));
    
    Constant /*P*/ Zero = ConstantInt.get(Ptr.getType(), $int2ulong(0));
    Value /*P*/ Result = Builder.CreateICmpNE(Ptr, Zero, new Twine(/*KEEP_STR*/"memptr.tobool"));
    
    // On ARM, a member function pointer is also non-null if the low bit of 'adj'
    // (the virtual bit) is set.
    if (UseARMMethodPtrABI) {
      Constant /*P*/ One = ConstantInt.get(Ptr.getType(), $int2ulong(1));
      Value /*P*/ Adj = Builder.CreateExtractValue(MemPtr, new ArrayRefUInt(1), new Twine(/*KEEP_STR*/"memptr.adj"));
      Value /*P*/ VirtualBit = Builder.CreateAnd(Adj, One, new Twine(/*KEEP_STR*/"memptr.virtualbit"));
      Value /*P*/ IsVirtual = Builder.CreateICmpNE(VirtualBit, Zero, 
          new Twine(/*KEEP_STR*/"memptr.isvirtual"));
      Result = Builder.CreateOr(Result, IsVirtual);
    }
    
    return Result;
  }

  
  
  /// The Itanium ABI always places an offset to the complete object
  /// at entry -2 in the vtable.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::emitVirtualObjectDelete">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 996,
   FQN="(anonymous namespace)::ItaniumCXXABI::emitVirtualObjectDelete", NM="_ZN12_GLOBAL__N_113ItaniumCXXABI23emitVirtualObjectDeleteERN5clang7CodeGen15CodeGenFunctionEPKNS1_13CXXDeleteExprENS2_7AddressENS1_8QualTypeEPKNS1_17CXXDestructorDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABI23emitVirtualObjectDeleteERN5clang7CodeGen15CodeGenFunctionEPKNS1_13CXXDeleteExprENS2_7AddressENS1_8QualTypeEPKNS1_17CXXDestructorDeclE")
  //</editor-fold>
  @Override public void emitVirtualObjectDelete(final CodeGenFunction /*&*/ CGF, 
                         /*const*/ CXXDeleteExpr /*P*/ DE, 
                         Address Ptr, 
                         QualType ElementType, 
                         /*const*/ CXXDestructorDecl /*P*/ Dtor)/* override*/ {
    boolean UseGlobalDelete = DE.isGlobalDelete();
    if (UseGlobalDelete) {
      // Derive the complete-object pointer, which is what we need
      // to pass to the deallocation function.
      
      // Grab the vtable pointer as an intptr_t*.
      CXXRecordDecl /*P*/ ClassDecl = cast_CXXRecordDecl(ElementType.$arrow().getAs$RecordType().getDecl());
      Value /*P*/ VTable = CGF.GetVTablePtr(new Address(Ptr), CGF.Unnamed_field8.IntPtrTy.getPointerTo(), ClassDecl);
      
      // Track back to entry -2 and pull out the offset there.
      Value /*P*/ OffsetPtr = CGF.Builder.CreateConstInBoundsGEP1_64(VTable, $int2ulong(-2), new Twine(/*KEEP_STR*/"complete-offset.ptr"));
      Value /*P*/ Offset = CGF.Builder.CreateAlignedLoad(OffsetPtr, CGF.getPointerAlign());
      
      // Apply the offset.
      Value /*P*/ CompletePtr = CGF.Builder.CreateBitCast(Ptr.getPointer(), CGF.Unnamed_field9.Int8PtrTy);
      CompletePtr = CGF.Builder.CreateInBoundsGEP(CompletePtr, new ArrayRef<Value /*P*/ >(Offset, true));
      
      // If we're supposed to call the global delete, make sure we do so
      // even if the destructor throws.
      CGF.pushCallObjectDeleteCleanup(DE.getOperatorDelete(), CompletePtr, 
          new QualType(ElementType));
    }
    
    // FIXME: Provide a source location here even though there's no
    // CXXMemberCallExpr for dtor call.
    CXXDtorType DtorType = UseGlobalDelete ? CXXDtorType.Dtor_Complete : CXXDtorType.Dtor_Deleting;
    EmitVirtualDestructorCall(CGF, Dtor, DtorType, new Address(Ptr), /*CE=*/ (/*const*/ CXXMemberCallExpr /*P*/ )null);
    if (UseGlobalDelete) {
      CGF.PopCleanupBlock();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::getAlignmentOfExnObject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 157,
   FQN="(anonymous namespace)::ItaniumCXXABI::getAlignmentOfExnObject", NM="_ZN12_GLOBAL__N_113ItaniumCXXABI23getAlignmentOfExnObjectEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABI23getAlignmentOfExnObjectEv")
  //</editor-fold>
  public CharUnits getAlignmentOfExnObject() {
    /*uint*/int Align = CGM.getContext().getTargetInfo().getExnObjectAlignment();
    return CGM.getContext().toCharUnitsFromBits($uint2long(Align));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::emitRethrow">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 1038,
   FQN="(anonymous namespace)::ItaniumCXXABI::emitRethrow", NM="_ZN12_GLOBAL__N_113ItaniumCXXABI11emitRethrowERN5clang7CodeGen15CodeGenFunctionEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABI11emitRethrowERN5clang7CodeGen15CodeGenFunctionEb")
  //</editor-fold>
  @Override public void emitRethrow(final CodeGenFunction /*&*/ CGF, boolean isNoReturn)/* override*/ {
    // void __cxa_rethrow();
    org.llvm.ir.FunctionType /*P*/ FTy = org.llvm.ir.FunctionType.get(CGM.VoidTy, /*IsVarArgs=*/ false);
    
    Constant /*P*/ Fn = CGM.CreateRuntimeFunction(FTy, new StringRef(/*KEEP_STR*/"__cxa_rethrow"));
    if (isNoReturn) {
      CGF.EmitNoreturnRuntimeCallOrInvoke(Fn, new ArrayRef<Value /*P*/ >(None, true));
    } else {
      CGF.EmitRuntimeCallOrInvoke(Fn);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::emitThrow">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 1072,
   FQN="(anonymous namespace)::ItaniumCXXABI::emitThrow", NM="_ZN12_GLOBAL__N_113ItaniumCXXABI9emitThrowERN5clang7CodeGen15CodeGenFunctionEPKNS1_12CXXThrowExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABI9emitThrowERN5clang7CodeGen15CodeGenFunctionEPKNS1_12CXXThrowExprE")
  //</editor-fold>
  @Override public void emitThrow(final CodeGenFunction /*&*/ CGF, /*const*/ CXXThrowExpr /*P*/ E)/* override*/ {
    QualType ThrowType = E.getSubExpr$Const().getType();
    // Now allocate the exception object.
    org.llvm.ir.Type /*P*/ SizeTy = CGF.ConvertType(getContext().getSizeType().$QualType());
    long/*uint64_t*/ TypeSize = getContext().getTypeSizeInChars(/*NO_COPY*/ThrowType).getQuantity();
    
    Constant /*P*/ AllocExceptionFn = ItaniumCXXABIStatics.getAllocateExceptionFn(CGM);
    CallInst /*P*/ ExceptionPtr = CGF.EmitNounwindRuntimeCall(AllocExceptionFn, new ArrayRef<Value /*P*/ >(ConstantInt.get(SizeTy, TypeSize), true), new Twine(/*KEEP_STR*/"exception"));
    
    CharUnits ExnAlign = getAlignmentOfExnObject();
    CGF.EmitAnyExprToExn(E.getSubExpr$Const(), new Address(ExceptionPtr, new CharUnits(ExnAlign)));
    
    // Now throw the exception.
    Constant /*P*/ TypeInfo = CGM.GetAddrOfRTTIDescriptor(new QualType(ThrowType), 
        /*ForEH=*/ true);
    
    // The address of the destructor.  If the exception type has a
    // trivial destructor (or isn't a record), we just pass null.
    Constant /*P*/ Dtor = null;
    {
      /*const*/ RecordType /*P*/ RecordTy = ThrowType.$arrow().getAs$RecordType();
      if ((RecordTy != null)) {
        CXXRecordDecl /*P*/ Record = cast_CXXRecordDecl(RecordTy.getDecl());
        if (!Record.hasTrivialDestructor()) {
          CXXDestructorDecl /*P*/ DtorD = Record.getDestructor();
          Dtor = CGM.getAddrOfCXXStructor(DtorD, StructorType.Complete);
          Dtor = ConstantExpr.getBitCast(Dtor, CGM.Unnamed_field9.Int8PtrTy);
        }
      }
    }
    if (!(Dtor != null)) {
      Dtor = Constant.getNullValue(CGM.Unnamed_field9.Int8PtrTy);
    }
    
    Value /*P*/ args[/*3*/] = new Value /*P*/  [/*3*/] {ExceptionPtr, TypeInfo, Dtor};
    CGF.EmitNoreturnRuntimeCallOrInvoke(ItaniumCXXABIStatics.getThrowFn(CGM), new ArrayRef<Value /*P*/ >(args, true));
  }

  
  
  /// Begins a catch statement by initializing the catch variable and
  /// calling __cxa_begin_catch.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::emitBeginCatch">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 3778,
   FQN="(anonymous namespace)::ItaniumCXXABI::emitBeginCatch", NM="_ZN12_GLOBAL__N_113ItaniumCXXABI14emitBeginCatchERN5clang7CodeGen15CodeGenFunctionEPKNS1_12CXXCatchStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABI14emitBeginCatchERN5clang7CodeGen15CodeGenFunctionEPKNS1_12CXXCatchStmtE")
  //</editor-fold>
  @Override public void emitBeginCatch(final CodeGenFunction /*&*/ CGF, 
                /*const*/ CXXCatchStmt /*P*/ S)/* override*/ {
    // We have to be very careful with the ordering of cleanups here:
    //   C++ [except.throw]p4:
    //     The destruction [of the exception temporary] occurs
    //     immediately after the destruction of the object declared in
    //     the exception-declaration in the handler.
    //
    // So the precise ordering is:
    //   1.  Construct catch variable.
    //   2.  __cxa_begin_catch
    //   3.  Enter __cxa_end_catch cleanup
    //   4.  Enter dtor cleanup
    //
    // We do this by using a slightly abnormal initialization process.
    // Delegation sequence:
    //   - ExitCXXTryStmt opens a RunCleanupsScope
    //     - EmitAutoVarAlloca creates the variable and debug info
    //       - InitCatchParam initializes the variable from the exception
    //       - CallBeginCatch calls __cxa_begin_catch
    //       - CallBeginCatch enters the __cxa_end_catch cleanup
    //     - EmitAutoVarCleanups enters the variable destructor cleanup
    //   - EmitCXXTryStmt emits the code for the catch body
    //   - EmitCXXTryStmt close the RunCleanupsScope
    VarDecl /*P*/ CatchParam = S.getExceptionDecl();
    if (!(CatchParam != null)) {
      Value /*P*/ Exn = CGF.getExceptionFromSlot();
      ItaniumCXXABIStatics.CallBeginCatch(CGF, Exn, true);
      return;
    }
    
    // Emit the local.
    CodeGenFunction.AutoVarEmission var = CGF.EmitAutoVarAlloca($Deref(CatchParam));
    ItaniumCXXABIStatics.InitCatchParam(CGF, $Deref(CatchParam), var.getObjectAddress(CGF), S.getLocStart());
    CGF.EmitAutoVarCleanups(var);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::emitTerminateForUnexpectedException">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 3868,
   FQN="(anonymous namespace)::ItaniumCXXABI::emitTerminateForUnexpectedException", NM="_ZN12_GLOBAL__N_113ItaniumCXXABI35emitTerminateForUnexpectedExceptionERN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABI35emitTerminateForUnexpectedExceptionERN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueE")
  //</editor-fold>
  @Override public CallInst /*P*/ emitTerminateForUnexpectedException(final CodeGenFunction /*&*/ CGF, 
                                     Value /*P*/ Exn)/* override*/ {
    // In C++, we want to call __cxa_begin_catch() before terminating.
    if ((Exn != null)) {
      assert Native.$bool(CGF.CGM.getLangOpts().CPlusPlus);
      return CGF.EmitNounwindRuntimeCall(ItaniumCXXABIStatics.getClangCallTerminateFn(CGF.CGM), new ArrayRef<Value /*P*/ >(Exn, true));
    }
    return CGF.EmitNounwindRuntimeCall(CGF.CGM.getTerminateFn());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::EmitFundamentalRTTIDescriptor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 3351,
   FQN="(anonymous namespace)::ItaniumCXXABI::EmitFundamentalRTTIDescriptor", NM="_ZN12_GLOBAL__N_113ItaniumCXXABI29EmitFundamentalRTTIDescriptorEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABI29EmitFundamentalRTTIDescriptorEN5clang8QualTypeE")
  //</editor-fold>
  public void EmitFundamentalRTTIDescriptor(QualType Type) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      QualType PointerType = getContext().getPointerType(/*NO_COPY*/Type);
      QualType PointerTypeConst = getContext().getPointerType(Type.withConst());
      $c$.clean($c$.track(new ItaniumRTTIBuilder(/*Deref*/this)).BuildTypeInfo(new QualType(Type), true));
      $c$.clean($c$.track(new ItaniumRTTIBuilder(/*Deref*/this)).BuildTypeInfo(new QualType(PointerType), true));
      $c$.clean($c$.track(new ItaniumRTTIBuilder(/*Deref*/this)).BuildTypeInfo(new QualType(PointerTypeConst), true));
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::EmitFundamentalRTTIDescriptors">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 3359,
   FQN="(anonymous namespace)::ItaniumCXXABI::EmitFundamentalRTTIDescriptors", NM="_ZN12_GLOBAL__N_113ItaniumCXXABI30EmitFundamentalRTTIDescriptorsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABI30EmitFundamentalRTTIDescriptorsEv")
  //</editor-fold>
  public void EmitFundamentalRTTIDescriptors() {
    // Types added here must also be added to TypeInfoIsInStandardLibrary.
    QualType FundamentalTypes[/*24*/] = new QualType [/*24*/] {
      getContext().VoidTy.$QualType(), getContext().NullPtrTy.$QualType(), 
      getContext().BoolTy.$QualType(), getContext().WCharTy.$QualType(), 
      getContext().CharTy.$QualType(), getContext().UnsignedCharTy.$QualType(), 
      getContext().SignedCharTy.$QualType(), getContext().ShortTy.$QualType(), 
      getContext().UnsignedShortTy.$QualType(), getContext().IntTy.$QualType(), 
      getContext().UnsignedIntTy.$QualType(), getContext().LongTy.$QualType(), 
      getContext().UnsignedLongTy.$QualType(), getContext().LongLongTy.$QualType(), 
      getContext().UnsignedLongLongTy.$QualType(), getContext().Int128Ty.$QualType(), 
      getContext().UnsignedInt128Ty.$QualType(), getContext().HalfTy.$QualType(), 
      getContext().FloatTy.$QualType(), getContext().DoubleTy.$QualType(), 
      getContext().LongDoubleTy.$QualType(), getContext().Float128Ty.$QualType(), 
      getContext().Char16Ty.$QualType(), getContext().Char32Ty.$QualType()
    };
    for (final /*const*/ QualType /*&*/ FundamentalType : FundamentalTypes)  {
      EmitFundamentalRTTIDescriptor(new QualType(FundamentalType));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::getAddrOfRTTIDescriptor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 3347,
   FQN="(anonymous namespace)::ItaniumCXXABI::getAddrOfRTTIDescriptor", NM="_ZN12_GLOBAL__N_113ItaniumCXXABI23getAddrOfRTTIDescriptorEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABI23getAddrOfRTTIDescriptorEN5clang8QualTypeE")
  //</editor-fold>
  @Override public Constant /*P*/ getAddrOfRTTIDescriptor(QualType Ty)/* override*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean($c$.track(new ItaniumRTTIBuilder(/*Deref*/this)).BuildTypeInfo(new QualType(Ty)));
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::getAddrOfCXXCatchHandlerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 174,
   FQN="(anonymous namespace)::ItaniumCXXABI::getAddrOfCXXCatchHandlerType", NM="_ZN12_GLOBAL__N_113ItaniumCXXABI28getAddrOfCXXCatchHandlerTypeEN5clang8QualTypeES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABI28getAddrOfCXXCatchHandlerTypeEN5clang8QualTypeES2_")
  //</editor-fold>
  @Override public CatchTypeInfo getAddrOfCXXCatchHandlerType(QualType Ty, 
                              QualType CatchHandlerType)/* override*/ {
    return ((CatchTypeInfo)(new CatchTypeInfo(getAddrOfRTTIDescriptor(new QualType(Ty)), 0)));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::shouldTypeidBeNullChecked">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 1194,
   FQN="(anonymous namespace)::ItaniumCXXABI::shouldTypeidBeNullChecked", NM="_ZN12_GLOBAL__N_113ItaniumCXXABI25shouldTypeidBeNullCheckedEbN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABI25shouldTypeidBeNullCheckedEbN5clang8QualTypeE")
  //</editor-fold>
  @Override public boolean shouldTypeidBeNullChecked(boolean IsDeref, 
                           QualType SrcRecordTy)/* override*/ {
    return IsDeref;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::EmitBadTypeidCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 1199,
   FQN="(anonymous namespace)::ItaniumCXXABI::EmitBadTypeidCall", NM="_ZN12_GLOBAL__N_113ItaniumCXXABI17EmitBadTypeidCallERN5clang7CodeGen15CodeGenFunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABI17EmitBadTypeidCallERN5clang7CodeGen15CodeGenFunctionE")
  //</editor-fold>
  @Override public void EmitBadTypeidCall(final CodeGenFunction /*&*/ CGF)/* override*/ {
    Value /*P*/ Fn = ItaniumCXXABIStatics.getBadTypeidFn(CGF);
    CGF.EmitRuntimeCallOrInvoke(Fn).setDoesNotReturn();
    CGF.Builder.CreateUnreachable();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::EmitTypeid">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 1205,
   FQN="(anonymous namespace)::ItaniumCXXABI::EmitTypeid", NM="_ZN12_GLOBAL__N_113ItaniumCXXABI10EmitTypeidERN5clang7CodeGen15CodeGenFunctionENS1_8QualTypeENS2_7AddressEPN4llvm4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABI10EmitTypeidERN5clang7CodeGen15CodeGenFunctionENS1_8QualTypeENS2_7AddressEPN4llvm4TypeE")
  //</editor-fold>
  @Override public Value /*P*/ EmitTypeid(final CodeGenFunction /*&*/ CGF, 
            QualType SrcRecordTy, 
            Address ThisPtr, 
            org.llvm.ir.Type /*P*/ StdTypeInfoPtrTy)/* override*/ {
    CXXRecordDecl /*P*/ ClassDecl = cast_CXXRecordDecl(SrcRecordTy.$arrow().getAs$RecordType().getDecl());
    Value /*P*/ $Value = CGF.GetVTablePtr(new Address(ThisPtr), StdTypeInfoPtrTy.getPointerTo(), ClassDecl);
    
    // Load the type info.
    $Value = CGF.Builder.CreateConstInBoundsGEP1_64($Value, -1L/*ULL*/);
    return CGF.Builder.CreateAlignedLoad($Value, CGF.getPointerAlign());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::shouldDynamicCastCallBeNullChecked">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 1219,
   FQN="(anonymous namespace)::ItaniumCXXABI::shouldDynamicCastCallBeNullChecked", NM="_ZN12_GLOBAL__N_113ItaniumCXXABI34shouldDynamicCastCallBeNullCheckedEbN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABI34shouldDynamicCastCallBeNullCheckedEbN5clang8QualTypeE")
  //</editor-fold>
  @Override public boolean shouldDynamicCastCallBeNullChecked(boolean SrcIsPtr, 
                                    QualType SrcRecordTy)/* override*/ {
    return SrcIsPtr;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::EmitDynamicCastCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 1224,
   FQN="(anonymous namespace)::ItaniumCXXABI::EmitDynamicCastCall", NM="_ZN12_GLOBAL__N_113ItaniumCXXABI19EmitDynamicCastCallERN5clang7CodeGen15CodeGenFunctionENS2_7AddressENS1_8QualTypeES6_S6_PN4llvm10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABI19EmitDynamicCastCallERN5clang7CodeGen15CodeGenFunctionENS2_7AddressENS1_8QualTypeES6_S6_PN4llvm10BasicBlockE")
  //</editor-fold>
  @Override public Value /*P*/ EmitDynamicCastCall(final CodeGenFunction /*&*/ CGF, Address ThisAddr, QualType SrcRecordTy, 
                     QualType DestTy, QualType DestRecordTy, BasicBlock /*P*/ CastEnd)/* override*/ {
    org.llvm.ir.Type /*P*/ PtrDiffLTy = CGF.ConvertType(CGF.getContext().getPointerDiffType());
    org.llvm.ir.Type /*P*/ DestLTy = CGF.ConvertType(new QualType(DestTy));
    
    Value /*P*/ SrcRTTI = CGF.CGM.GetAddrOfRTTIDescriptor(SrcRecordTy.getUnqualifiedType());
    Value /*P*/ DestRTTI = CGF.CGM.GetAddrOfRTTIDescriptor(DestRecordTy.getUnqualifiedType());
    
    // Compute the offset hint.
    /*const*/ CXXRecordDecl /*P*/ SrcDecl = SrcRecordTy.$arrow().getAsCXXRecordDecl();
    /*const*/ CXXRecordDecl /*P*/ DestDecl = DestRecordTy.$arrow().getAsCXXRecordDecl();
    Value /*P*/ OffsetHint = ConstantInt.get(PtrDiffLTy, 
        ItaniumCXXABIStatics.computeOffsetHint(CGF.getContext(), SrcDecl, DestDecl).getQuantity());
    
    // Emit the call to __dynamic_cast.
    Value /*P*/ $Value = ThisAddr.getPointer();
    $Value = CGF.EmitCastToVoidPtr($Value);
    
    Value /*P*/ args[/*4*/] = new Value /*P*/  [/*4*/] {$Value, SrcRTTI, DestRTTI, OffsetHint};
    $Value = CGF.EmitNounwindRuntimeCall(ItaniumCXXABIStatics.getItaniumDynamicCastFn(CGF), new ArrayRef<Value /*P*/ >(args, true));
    $Value = CGF.Builder.CreateBitCast($Value, DestLTy);
    
    /// C++ [expr.dynamic.cast]p9:
    ///   A failed cast to reference type throws std::bad_cast
    if (DestTy.$arrow().isReferenceType()) {
      BasicBlock /*P*/ BadCastBlock = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"dynamic_cast.bad_cast"));
      
      Value /*P*/ IsNull = CGF.Builder.CreateIsNull($Value);
      CGF.Builder.CreateCondBr(IsNull, BadCastBlock, CastEnd);
      
      CGF.EmitBlock(BadCastBlock);
      EmitBadCastCall(CGF);
    }
    
    return $Value;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::EmitDynamicCastToVoid">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 1267,
   FQN="(anonymous namespace)::ItaniumCXXABI::EmitDynamicCastToVoid", NM="_ZN12_GLOBAL__N_113ItaniumCXXABI21EmitDynamicCastToVoidERN5clang7CodeGen15CodeGenFunctionENS2_7AddressENS1_8QualTypeES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABI21EmitDynamicCastToVoidERN5clang7CodeGen15CodeGenFunctionENS2_7AddressENS1_8QualTypeES6_")
  //</editor-fold>
  @Override public Value /*P*/ EmitDynamicCastToVoid(final CodeGenFunction /*&*/ CGF, 
                       Address ThisAddr, 
                       QualType SrcRecordTy, 
                       QualType DestTy)/* override*/ {
    org.llvm.ir.Type /*P*/ PtrDiffLTy = CGF.ConvertType(CGF.getContext().getPointerDiffType());
    org.llvm.ir.Type /*P*/ DestLTy = CGF.ConvertType(new QualType(DestTy));
    
    CXXRecordDecl /*P*/ ClassDecl = cast_CXXRecordDecl(SrcRecordTy.$arrow().getAs$RecordType().getDecl());
    // Get the vtable pointer.
    Value /*P*/ VTable = CGF.GetVTablePtr(new Address(ThisAddr), PtrDiffLTy.getPointerTo(), 
        ClassDecl);
    
    // Get the offset-to-top from the vtable.
    Value /*P*/ OffsetToTop = CGF.Builder.CreateConstInBoundsGEP1_64(VTable, -2L/*ULL*/);
    OffsetToTop
       = CGF.Builder.CreateAlignedLoad(OffsetToTop, CGF.getPointerAlign(), 
        $("offset.to.top"));
    
    // Finally, add the offset to the pointer.
    Value /*P*/ $Value = ThisAddr.getPointer();
    $Value = CGF.EmitCastToVoidPtr($Value);
    $Value = CGF.Builder.CreateInBoundsGEP($Value, new ArrayRef<Value /*P*/ >(OffsetToTop, true));
    
    return CGF.Builder.CreateBitCast($Value, DestLTy);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::EmitBadCastCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 1296,
   FQN="(anonymous namespace)::ItaniumCXXABI::EmitBadCastCall", NM="_ZN12_GLOBAL__N_113ItaniumCXXABI15EmitBadCastCallERN5clang7CodeGen15CodeGenFunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABI15EmitBadCastCallERN5clang7CodeGen15CodeGenFunctionE")
  //</editor-fold>
  @Override public boolean EmitBadCastCall(final CodeGenFunction /*&*/ CGF)/* override*/ {
    Value /*P*/ Fn = ItaniumCXXABIStatics.getBadCastFn(CGF);
    CGF.EmitRuntimeCallOrInvoke(Fn).setDoesNotReturn();
    CGF.Builder.CreateUnreachable();
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::GetVirtualBaseClassOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 1303,
   FQN="(anonymous namespace)::ItaniumCXXABI::GetVirtualBaseClassOffset", NM="_ZN12_GLOBAL__N_113ItaniumCXXABI25GetVirtualBaseClassOffsetERN5clang7CodeGen15CodeGenFunctionENS2_7AddressEPKNS1_13CXXRecordDeclES8_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABI25GetVirtualBaseClassOffsetERN5clang7CodeGen15CodeGenFunctionENS2_7AddressEPKNS1_13CXXRecordDeclES8_")
  //</editor-fold>
  @Override public Value /*P*/ GetVirtualBaseClassOffset(final CodeGenFunction /*&*/ CGF, 
                           Address This, 
                           /*const*/ CXXRecordDecl /*P*/ ClassDecl, 
                           /*const*/ CXXRecordDecl /*P*/ BaseClassDecl)/* override*/ {
    Value /*P*/ VTablePtr = CGF.GetVTablePtr(new Address(This), CGM.Unnamed_field9.Int8PtrTy, ClassDecl);
    CharUnits VBaseOffsetOffset = CGM.getItaniumVTableContext().getVirtualBaseOffsetOffset(ClassDecl, 
        BaseClassDecl);
    
    Value /*P*/ VBaseOffsetPtr = CGF.Builder.CreateConstGEP1_64(VTablePtr, VBaseOffsetOffset.getQuantity(), 
        new Twine(/*KEEP_STR*/"vbase.offset.ptr"));
    VBaseOffsetPtr = CGF.Builder.CreateBitCast(VBaseOffsetPtr, 
        CGM.Unnamed_field8.PtrDiffTy.getPointerTo());
    
    Value /*P*/ VBaseOffset = CGF.Builder.CreateAlignedLoad(VBaseOffsetPtr, CGF.getPointerAlign(), 
        $("vbase.offset"));
    
    return VBaseOffset;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::EmitCXXConstructors">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 1326,
   FQN="(anonymous namespace)::ItaniumCXXABI::EmitCXXConstructors", NM="_ZN12_GLOBAL__N_113ItaniumCXXABI19EmitCXXConstructorsEPKN5clang18CXXConstructorDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABI19EmitCXXConstructorsEPKN5clang18CXXConstructorDeclE")
  //</editor-fold>
  @Override public void EmitCXXConstructors(/*const*/ CXXConstructorDecl /*P*/ D)/* override*/ {
    // Just make sure we're in sync with TargetCXXABI.
    assert (CGM.getTarget().getCXXABI().hasConstructorVariants());
    
    // The constructor used for constructing this as a base class;
    // ignores virtual bases.
    CGM.EmitGlobal(new GlobalDecl(JD$CXXConstructorDecl$C$P_CXXCtorType.INSTANCE, D, CXXCtorType.Ctor_Base));
    
    // The constructor used for constructing this as a complete class;
    // constructs the virtual bases, then calls the base constructor.
    if (!D.getParent$Const().isAbstract()) {
      // We don't need to emit the complete ctor if the class is abstract.
      CGM.EmitGlobal(new GlobalDecl(JD$CXXConstructorDecl$C$P_CXXCtorType.INSTANCE, D, CXXCtorType.Ctor_Complete));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::buildStructorSignature">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 1342,
   FQN="(anonymous namespace)::ItaniumCXXABI::buildStructorSignature", NM="_ZN12_GLOBAL__N_113ItaniumCXXABI22buildStructorSignatureEPKN5clang13CXXMethodDeclENS1_7CodeGen12StructorTypeERN4llvm15SmallVectorImplINS1_7CanQualINS1_4TypeEEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABI22buildStructorSignatureEPKN5clang13CXXMethodDeclENS1_7CodeGen12StructorTypeERN4llvm15SmallVectorImplINS1_7CanQualINS1_4TypeEEEEE")
  //</editor-fold>
  @Override public void buildStructorSignature(/*const*/ CXXMethodDecl /*P*/ MD, StructorType T, 
                        final SmallVectorImpl<CanQual<org.clang.ast.Type> > /*&*/ ArgTys)/* override*/ {
    final ASTContext /*&*/ Context = getContext();
    
    // All parameters are already in place except VTT, which goes after 'this'.
    // These are Clang types, so we don't need to worry about sret yet.
    
    // Check if we need to add a VTT parameter (which has type void **).
    if (T == StructorType.Base && MD.getParent$Const().getNumVBases() != 0) {
      ArgTys.insert/*insert_iterator$T$value_T$RR*/(ArgTys.begin().$add(1), 
          Context.getPointerType(/*NO_COPY*/Context.VoidPtrTy));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::useThunkForDtorVariant">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 210,
   FQN="(anonymous namespace)::ItaniumCXXABI::useThunkForDtorVariant", NM="_ZNK12_GLOBAL__N_113ItaniumCXXABI22useThunkForDtorVariantEPKN5clang17CXXDestructorDeclENS1_11CXXDtorTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZNK12_GLOBAL__N_113ItaniumCXXABI22useThunkForDtorVariantEPKN5clang17CXXDestructorDeclENS1_11CXXDtorTypeE")
  //</editor-fold>
  @Override public boolean useThunkForDtorVariant(/*const*/ CXXDestructorDecl /*P*/ Dtor, 
                        CXXDtorType DT) /*const*//* override*/ {
    // Itanium does not emit any destructor variant as an inline thunk.
    // Delegating may occur as an optimization, but all variants are either
    // emitted with external linkage or as linkonce if they are inline and used.
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::EmitCXXDestructors">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 1356,
   FQN="(anonymous namespace)::ItaniumCXXABI::EmitCXXDestructors", NM="_ZN12_GLOBAL__N_113ItaniumCXXABI18EmitCXXDestructorsEPKN5clang17CXXDestructorDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABI18EmitCXXDestructorsEPKN5clang17CXXDestructorDeclE")
  //</editor-fold>
  @Override public void EmitCXXDestructors(/*const*/ CXXDestructorDecl /*P*/ D)/* override*/ {
    // The destructor used for destructing this as a base class; ignores
    // virtual bases.
    CGM.EmitGlobal(new GlobalDecl(JD$CXXDestructorDecl$C$P_CXXDtorType.INSTANCE, D, CXXDtorType.Dtor_Base));
    
    // The destructor used for destructing this as a most-derived class;
    // call the base destructor and then destructs any virtual bases.
    CGM.EmitGlobal(new GlobalDecl(JD$CXXDestructorDecl$C$P_CXXDtorType.INSTANCE, D, CXXDtorType.Dtor_Complete));
    
    // The destructor in a virtual table is always a 'deleting'
    // destructor, which calls the complete destructor and then uses the
    // appropriate operator delete.
    if (D.isVirtual()) {
      CGM.EmitGlobal(new GlobalDecl(JD$CXXDestructorDecl$C$P_CXXDtorType.INSTANCE, D, CXXDtorType.Dtor_Deleting));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::addImplicitStructorParams">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 1372,
   FQN="(anonymous namespace)::ItaniumCXXABI::addImplicitStructorParams", NM="_ZN12_GLOBAL__N_113ItaniumCXXABI25addImplicitStructorParamsERN5clang7CodeGen15CodeGenFunctionERNS1_8QualTypeERNS2_15FunctionArgListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABI25addImplicitStructorParamsERN5clang7CodeGen15CodeGenFunctionERNS1_8QualTypeERNS2_15FunctionArgListE")
  //</editor-fold>
  @Override public void addImplicitStructorParams(final CodeGenFunction /*&*/ CGF, 
                           final QualType /*&*/ ResTy, 
                           final FunctionArgList /*&*/ Params)/* override*/ {
    /*const*/ CXXMethodDecl /*P*/ MD = cast_CXXMethodDecl(CGF.CurGD.getDecl());
    assert (isa_CXXConstructorDecl(MD) || isa_CXXDestructorDecl(MD));
    
    // Check if we need a VTT parameter as well.
    if (NeedsVTTParameter(new GlobalDecl(CGF.CurGD))) {
      final ASTContext /*&*/ Context = getContext();
      
      // FIXME: avoid the fake decl
      QualType T = Context.getPointerType(/*NO_COPY*/Context.VoidPtrTy).$QualType();
      ImplicitParamDecl /*P*/ VTTDecl = ImplicitParamDecl.Create(Context, (DeclContext /*P*/ )null, MD.getLocation(), 
          $AddrOf(Context.Idents.get(new StringRef(/*KEEP_STR*/"vtt"))), new QualType(T));
      Params.insert/*insert_iterator$T$value_T$RR*/(Params.begin().$add(1), VTTDecl);
      getStructorImplicitParamDecl(CGF).$set(VTTDecl);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::EmitInstanceFunctionProlog">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 1392,
   FQN="(anonymous namespace)::ItaniumCXXABI::EmitInstanceFunctionProlog", NM="_ZN12_GLOBAL__N_113ItaniumCXXABI26EmitInstanceFunctionPrologERN5clang7CodeGen15CodeGenFunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABI26EmitInstanceFunctionPrologERN5clang7CodeGen15CodeGenFunctionE")
  //</editor-fold>
  @Override public void EmitInstanceFunctionProlog(final CodeGenFunction /*&*/ CGF)/* override*/ {
    /// Initialize the 'this' slot.
    EmitThisParam(CGF);
    
    /// Initialize the 'vtt' slot if needed.
    if ((getStructorImplicitParamDecl(CGF) != null)) {
      getStructorImplicitParamValue(CGF).$set(CGF.Builder.CreateLoad(CGF.GetAddrOfLocalVar(getStructorImplicitParamDecl(CGF).$deref()), $("vtt")));
    }
    
    /// If this is a function that the ABI specifies returns 'this', initialize
    /// the return slot to 'this' at the start of the function.
    ///
    /// Unlike the setting of return types, this is done within the ABI
    /// implementation instead of by clients of CGCXXABI because:
    /// 1) getThisValue is currently protected
    /// 2) in theory, an ABI could implement 'this' returns some other way;
    ///    HasThisReturn only specifies a contract, not the implementation
    if (HasThisReturn(new GlobalDecl(CGF.CurGD))) {
      CGF.Builder.CreateStore(getThisValue(CGF), new Address(CGF.ReturnValue));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::addImplicitConstructorArgs">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 1414,
   FQN="(anonymous namespace)::ItaniumCXXABI::addImplicitConstructorArgs", NM="_ZN12_GLOBAL__N_113ItaniumCXXABI26addImplicitConstructorArgsERN5clang7CodeGen15CodeGenFunctionEPKNS1_18CXXConstructorDeclENS1_11CXXCtorTypeEbbRNS2_11CallArgListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABI26addImplicitConstructorArgsERN5clang7CodeGen15CodeGenFunctionEPKNS1_18CXXConstructorDeclENS1_11CXXCtorTypeEbbRNS2_11CallArgListE")
  //</editor-fold>
  @Override public /*uint*/int addImplicitConstructorArgs(final CodeGenFunction /*&*/ CGF, /*const*/ CXXConstructorDecl /*P*/ D, CXXCtorType Type, 
                            boolean ForVirtualBase, boolean Delegating, final CallArgList /*&*/ Args)/* override*/ {
    if (!NeedsVTTParameter(new GlobalDecl(JD$CXXConstructorDecl$C$P_CXXCtorType.INSTANCE, D, Type))) {
      return 0;
    }
    
    // Insert the implicit 'vtt' argument as the second argument.
    Value /*P*/ VTT = CGF.GetVTTParameter(new GlobalDecl(JD$CXXConstructorDecl$C$P_CXXCtorType.INSTANCE, D, Type), ForVirtualBase, Delegating);
    QualType VTTTy = getContext().getPointerType(/*NO_COPY*/getContext().VoidPtrTy).$QualType();
    Args.insert/*insert_iterator$T$value_T$RR*/(Args.begin().$add(1), 
        new CallArg(RValue.get(VTT), new QualType(VTTTy), /*needscopy=*/ false));
    return 1; // Added one arg.
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::EmitDestructorCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 1429,
   FQN="(anonymous namespace)::ItaniumCXXABI::EmitDestructorCall", NM="_ZN12_GLOBAL__N_113ItaniumCXXABI18EmitDestructorCallERN5clang7CodeGen15CodeGenFunctionEPKNS1_17CXXDestructorDeclENS1_11CXXDtorTypeEbbNS2_7AddressE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABI18EmitDestructorCallERN5clang7CodeGen15CodeGenFunctionEPKNS1_17CXXDestructorDeclENS1_11CXXDtorTypeEbbNS2_7AddressE")
  //</editor-fold>
  @Override public void EmitDestructorCall(final CodeGenFunction /*&*/ CGF, 
                    /*const*/ CXXDestructorDecl /*P*/ DD, 
                    CXXDtorType Type, boolean ForVirtualBase, 
                    boolean Delegating, Address This)/* override*/ {
    GlobalDecl GD/*J*/= new GlobalDecl(JD$CXXDestructorDecl$C$P_CXXDtorType.INSTANCE, DD, Type);
    Value /*P*/ VTT = CGF.GetVTTParameter(new GlobalDecl(GD), ForVirtualBase, Delegating);
    QualType VTTTy = getContext().getPointerType(/*NO_COPY*/getContext().VoidPtrTy).$QualType();
    
    Value /*P*/ Callee = null;
    if (getContext().getLangOpts().AppleKext) {
      Callee = CGF.BuildAppleKextVirtualDestructorCall(DD, Type, DD.getParent$Const());
    }
    if (!(Callee != null)) {
      Callee = CGM.getAddrOfCXXStructor(DD, CodeGenStatics.getFromDtorType(Type));
    }
    
    CGF.EmitCXXMemberOrOperatorCall(DD, Callee, new ReturnValueSlot(), 
        This.getPointer(), VTT, new QualType(VTTTy), (/*const*/ CallExpr /*P*/ )null);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::emitVTableDefinitions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 1448,
   FQN="(anonymous namespace)::ItaniumCXXABI::emitVTableDefinitions", NM="_ZN12_GLOBAL__N_113ItaniumCXXABI21emitVTableDefinitionsERN5clang7CodeGen14CodeGenVTablesEPKNS1_13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABI21emitVTableDefinitionsERN5clang7CodeGen14CodeGenVTablesEPKNS1_13CXXRecordDeclE")
  //</editor-fold>
  @Override public void emitVTableDefinitions(final CodeGenVTables /*&*/ CGVT, 
                       /*const*/ CXXRecordDecl /*P*/ RD)/* override*/ {
    GlobalVariable /*P*/ VTable = getAddrOfVTable(RD, new CharUnits());
    if (VTable.hasInitializer()) {
      return;
    }
    
    final ItaniumVTableContext /*&*/ VTContext = CGM.getItaniumVTableContext();
    final /*const*/ VTableLayout /*&*/ VTLayout = VTContext.getVTableLayout(RD);
    GlobalVariable.LinkageTypes Linkage = CGM.getVTableLinkage(RD);
    Constant /*P*/ RTTI = CGM.GetAddrOfRTTIDescriptor(CGM.getContext().getTagDeclType(RD));
    
    // Create and set the initializer.
    Constant /*P*/ Init = CGVT.CreateVTableInitializer(RD, VTLayout.vtable_component_begin(), $ulong2uint(VTLayout.getNumVTableComponents()), 
        VTLayout.vtable_thunk_begin(), $ulong2uint(VTLayout.getNumVTableThunks()), RTTI);
    VTable.setInitializer(Init);
    
    // Set the correct linkage.
    VTable.setLinkage(Linkage);
    if (CGM.supportsCOMDAT() && VTable.isWeakForLinker()) {
      VTable.setComdat(CGM.getModule().getOrInsertComdat(VTable.getName()));
    }
    
    // Set the right visibility.
    CGM.setGlobalVisibility(VTable, RD);
    
    // Use pointer alignment for the vtable. Otherwise we would align them based
    // on the size of the initializer which doesn't make sense as only single
    // values are read.
    /*uint*/int PAlign = $ulong2uint(CGM.getTarget().getPointerAlign(0));
    VTable.setAlignment($long2uint(getContext().toCharUnitsFromBits($uint2long(PAlign)).getQuantity()));
    
    // If this is the magic class __cxxabiv1::__fundamental_type_info,
    // we will emit the typeinfo for the fundamental types. This is the
    // same behaviour as GCC.
    /*const*/ DeclContext /*P*/ DC = RD.getDeclContext$Const();
    if ((RD.getIdentifier() != null)
       && RD.getIdentifier().isStr(/*KEEP_STR*/"__fundamental_type_info")
       && isa_NamespaceDecl(DC) && (cast_NamespaceDecl(DC).getIdentifier() != null)
       && cast_NamespaceDecl(DC).getIdentifier().isStr(/*KEEP_STR*/"__cxxabiv1")
       && DC.getParent$Const().isTranslationUnit()) {
      EmitFundamentalRTTIDescriptors();
    }
    if (!VTable.isDeclarationForLinker()) {
      CGM.EmitVTableTypeMetadata(VTable, VTLayout);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::isVirtualOffsetNeededForVTableField">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 1496,
   FQN="(anonymous namespace)::ItaniumCXXABI::isVirtualOffsetNeededForVTableField", NM="_ZN12_GLOBAL__N_113ItaniumCXXABI35isVirtualOffsetNeededForVTableFieldERN5clang7CodeGen15CodeGenFunctionENS3_4VPtrE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABI35isVirtualOffsetNeededForVTableFieldERN5clang7CodeGen15CodeGenFunctionENS3_4VPtrE")
  //</editor-fold>
  @Override public boolean isVirtualOffsetNeededForVTableField(final CodeGenFunction /*&*/ CGF, CodeGenFunction.VPtr Vptr)/* override*/ {
    if (Vptr.NearestVBase == null) {
      return false;
    }
    return NeedsVTTParameter(new GlobalDecl(CGF.CurGD));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::doStructorsInitializeVPtrs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 241,
   FQN="(anonymous namespace)::ItaniumCXXABI::doStructorsInitializeVPtrs", NM="_ZN12_GLOBAL__N_113ItaniumCXXABI26doStructorsInitializeVPtrsEPKN5clang13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABI26doStructorsInitializeVPtrsEPKN5clang13CXXRecordDeclE")
  //</editor-fold>
  @Override public boolean doStructorsInitializeVPtrs(/*const*/ CXXRecordDecl /*P*/ VTableClass)/* override*/ {
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::getVTableAddressPoint">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 1515,
   FQN="(anonymous namespace)::ItaniumCXXABI::getVTableAddressPoint", NM="_ZN12_GLOBAL__N_113ItaniumCXXABI21getVTableAddressPointEN5clang13BaseSubobjectEPKNS1_13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABI21getVTableAddressPointEN5clang13BaseSubobjectEPKNS1_13CXXRecordDeclE")
  //</editor-fold>
  @Override public Constant /*P*/ getVTableAddressPoint(BaseSubobject Base, 
                       /*const*/ CXXRecordDecl /*P*/ VTableClass)/* override*/ {
    GlobalValue /*P*/ VTable = getAddrOfVTable(VTableClass, new CharUnits());
    
    // Find the appropriate vtable within the vtable group.
    long/*uint64_t*/ AddressPoint = CGM.getItaniumVTableContext().
        getVTableLayout(VTableClass).
        getAddressPoint(new BaseSubobject(Base));
    Value /*P*/ Indices[/*2*/] = new Value /*P*/  [/*2*/] {
      ConstantInt.get(CGM.Int32Ty, $int2ulong(0)), 
      ConstantInt.get(CGM.Int32Ty, AddressPoint)
    };
    
    return ConstantExpr.getInBoundsGetElementPtr_Type$P_Constant$P_ArrayRef$Value$P(VTable.getValueType(), 
        VTable, new ArrayRef<Value /*P*/ >(Indices, true));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::getVTableAddressPointInStructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 1503,
   FQN="(anonymous namespace)::ItaniumCXXABI::getVTableAddressPointInStructor", NM="_ZN12_GLOBAL__N_113ItaniumCXXABI31getVTableAddressPointInStructorERN5clang7CodeGen15CodeGenFunctionEPKNS1_13CXXRecordDeclENS1_13BaseSubobjectES7_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABI31getVTableAddressPointInStructorERN5clang7CodeGen15CodeGenFunctionEPKNS1_13CXXRecordDeclENS1_13BaseSubobjectES7_")
  //</editor-fold>
  @Override public Value /*P*/ getVTableAddressPointInStructor(final CodeGenFunction /*&*/ CGF, /*const*/ CXXRecordDecl /*P*/ VTableClass, BaseSubobject Base, 
                                 /*const*/ CXXRecordDecl /*P*/ NearestVBase)/* override*/ {
    if (((Base.getBase().getNumVBases() != 0) || NearestVBase != null)
       && NeedsVTTParameter(new GlobalDecl(CGF.CurGD))) {
      return getVTableAddressPointInStructorWithVTT(CGF, VTableClass, new BaseSubobject(Base), 
          NearestVBase);
    }
    return getVTableAddressPoint(new BaseSubobject(Base), VTableClass);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::getVTableAddressPointInStructorWithVTT">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 1533,
   FQN="(anonymous namespace)::ItaniumCXXABI::getVTableAddressPointInStructorWithVTT", NM="_ZN12_GLOBAL__N_113ItaniumCXXABI38getVTableAddressPointInStructorWithVTTERN5clang7CodeGen15CodeGenFunctionEPKNS1_13CXXRecordDeclENS1_13BaseSubobjectES7_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABI38getVTableAddressPointInStructorWithVTTERN5clang7CodeGen15CodeGenFunctionEPKNS1_13CXXRecordDeclENS1_13BaseSubobjectES7_")
  //</editor-fold>
  public Value /*P*/ getVTableAddressPointInStructorWithVTT(final CodeGenFunction /*&*/ CGF, /*const*/ CXXRecordDecl /*P*/ VTableClass, BaseSubobject Base, 
                                        /*const*/ CXXRecordDecl /*P*/ NearestVBase) {
    assert (((Base.getBase().getNumVBases() != 0) || NearestVBase != null) && NeedsVTTParameter(new GlobalDecl(CGF.CurGD))) : "This class doesn't have VTT";
    
    // Get the secondary vpointer index.
    long/*uint64_t*/ VirtualPointerIndex = CGM.getVTables().getSecondaryVirtualPointerIndex(VTableClass, new BaseSubobject(Base));
    
    /// Load the VTT.
    Value /*P*/ VTT = CGF.LoadCXXVTT();
    if ((VirtualPointerIndex != 0)) {
      VTT = CGF.Builder.CreateConstInBoundsGEP1_64(VTT, VirtualPointerIndex);
    }
    
    // And load the address point from the VTT.
    return CGF.Builder.CreateAlignedLoad(VTT, CGF.getPointerAlign());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::getVTableAddressPointForConstExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 1552,
   FQN="(anonymous namespace)::ItaniumCXXABI::getVTableAddressPointForConstExpr", NM="_ZN12_GLOBAL__N_113ItaniumCXXABI33getVTableAddressPointForConstExprEN5clang13BaseSubobjectEPKNS1_13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABI33getVTableAddressPointForConstExprEN5clang13BaseSubobjectEPKNS1_13CXXRecordDeclE")
  //</editor-fold>
  @Override public Constant /*P*/ getVTableAddressPointForConstExpr(BaseSubobject Base, /*const*/ CXXRecordDecl /*P*/ VTableClass)/* override*/ {
    return getVTableAddressPoint(new BaseSubobject(Base), VTableClass);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::getAddrOfVTable">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 1557,
   FQN="(anonymous namespace)::ItaniumCXXABI::getAddrOfVTable", NM="_ZN12_GLOBAL__N_113ItaniumCXXABI15getAddrOfVTableEPKN5clang13CXXRecordDeclENS1_9CharUnitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABI15getAddrOfVTableEPKN5clang13CXXRecordDeclENS1_9CharUnitsE")
  //</editor-fold>
  @Override public GlobalVariable /*P*/ getAddrOfVTable(/*const*/ CXXRecordDecl /*P*/ RD, 
                 CharUnits VPtrOffset)/* override*/ {
    raw_svector_ostream Out = null;
    try {
      assert (VPtrOffset.isZero()) : "Itanium ABI only supports zero vptr offsets";
      
      final type$ref<GlobalVariable /*P*/ /*&*/> VTable = VTables.ref$at(RD);
      if ((VTable.$deref() != null)) {
        return VTable.$deref();
      }
      
      // Queue up this vtable for possible deferred emission.
      CGM.addDeferredVTable(RD);
      
      SmallString/*<256>*/ Name/*J*/= new SmallString/*<256>*/(256);
      Out/*J*/= new raw_svector_ostream(Name);
      getMangleContext().mangleCXXVTable(RD, Out);
      
      final ItaniumVTableContext /*&*/ VTContext = CGM.getItaniumVTableContext();
      org.llvm.ir.ArrayType /*P*/ $ArrayType = org.llvm.ir.ArrayType.get(CGM.Unnamed_field9.Int8PtrTy, VTContext.getVTableLayout(RD).getNumVTableComponents());
      
      VTable.$set(CGM.CreateOrReplaceCXXRuntimeVariable(Name.$StringRef(), $ArrayType, GlobalValue.LinkageTypes.ExternalLinkage));
      VTable.$deref().setUnnamedAddr(GlobalValue.UnnamedAddr.Global);
      if (RD.hasAttr(DLLImportAttr.class)) {
        VTable.$deref().setDLLStorageClass(GlobalValue.DLLStorageClassTypes.DLLImportStorageClass);
      } else if (RD.hasAttr(DLLExportAttr.class)) {
        VTable.$deref().setDLLStorageClass(GlobalValue.DLLStorageClassTypes.DLLExportStorageClass);
      }
      
      return VTable.$deref();
    } finally {
      if (Out != null) { Out.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::getVirtualFunctionPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 1588,
   FQN="(anonymous namespace)::ItaniumCXXABI::getVirtualFunctionPointer", NM="_ZN12_GLOBAL__N_113ItaniumCXXABI25getVirtualFunctionPointerERN5clang7CodeGen15CodeGenFunctionENS1_10GlobalDeclENS2_7AddressEPN4llvm4TypeENS1_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABI25getVirtualFunctionPointerERN5clang7CodeGen15CodeGenFunctionENS1_10GlobalDeclENS2_7AddressEPN4llvm4TypeENS1_14SourceLocationE")
  //</editor-fold>
  @Override public Value /*P*/ getVirtualFunctionPointer(final CodeGenFunction /*&*/ CGF, 
                           GlobalDecl GD, 
                           Address This, 
                           org.llvm.ir.Type /*P*/ Ty, 
                           SourceLocation Loc)/* override*/ {
    GD.$assignMove(GD.getCanonicalDecl());
    Ty = Ty.getPointerTo().getPointerTo();
    /*const*/ CXXMethodDecl /*P*/ MethodDecl = cast_CXXMethodDecl(GD.getDecl());
    Value /*P*/ VTable = CGF.GetVTablePtr(new Address(This), Ty, MethodDecl.getParent$Const());
    
    long/*uint64_t*/ VTableIndex = CGM.getItaniumVTableContext().getMethodVTableIndex(new GlobalDecl(GD));
    if (CGF.ShouldEmitVTableTypeCheckedLoad(MethodDecl.getParent$Const())) {
      return CGF.EmitVTableTypeCheckedLoad(MethodDecl.getParent$Const(), VTable, 
          $div_ullong(VTableIndex * CGM.getContext().getTargetInfo().getPointerWidth(0), $int2ullong(8)));
    } else {
      CGF.EmitTypeMetadataCodeForVCall(MethodDecl.getParent$Const(), VTable, new SourceLocation(Loc));
      
      Value /*P*/ VFuncPtr = CGF.Builder.CreateConstInBoundsGEP1_64(VTable, VTableIndex, new Twine(/*KEEP_STR*/"vfn"));
      return CGF.Builder.CreateAlignedLoad(VFuncPtr, CGF.getPointerAlign());
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::EmitVirtualDestructorCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 1612,
   FQN="(anonymous namespace)::ItaniumCXXABI::EmitVirtualDestructorCall", NM="_ZN12_GLOBAL__N_113ItaniumCXXABI25EmitVirtualDestructorCallERN5clang7CodeGen15CodeGenFunctionEPKNS1_17CXXDestructorDeclENS1_11CXXDtorTypeENS2_7AddressEPKNS1_17CXXMemberCallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABI25EmitVirtualDestructorCallERN5clang7CodeGen15CodeGenFunctionEPKNS1_17CXXDestructorDeclENS1_11CXXDtorTypeENS2_7AddressEPKNS1_17CXXMemberCallExprE")
  //</editor-fold>
  @Override public Value /*P*/ EmitVirtualDestructorCall(final CodeGenFunction /*&*/ CGF, /*const*/ CXXDestructorDecl /*P*/ Dtor, CXXDtorType DtorType, 
                           Address This, /*const*/ CXXMemberCallExpr /*P*/ CE)/* override*/ {
    assert (CE == null || CE.arg_begin$Const().$eq(CE.arg_end$Const()));
    assert (DtorType == CXXDtorType.Dtor_Deleting || DtorType == CXXDtorType.Dtor_Complete);
    
    /*const*/ CGFunctionInfo /*P*/ FInfo = $AddrOf(CGM.getTypes().arrangeCXXStructorDeclaration(Dtor, CodeGenStatics.getFromDtorType(DtorType)));
    org.llvm.ir.Type /*P*/ Ty = CGF.CGM.getTypes().GetFunctionType($Deref(FInfo));
    Value /*P*/ Callee = getVirtualFunctionPointer(CGF, new GlobalDecl(JD$CXXDestructorDecl$C$P_CXXDtorType.INSTANCE, Dtor, DtorType), new Address(This), Ty, 
        (CE != null) ? CE.getLocStart() : new SourceLocation());
    
    CGF.EmitCXXMemberOrOperatorCall(Dtor, Callee, new ReturnValueSlot(), 
        This.getPointer(), /*ImplicitParam=*/ (Value /*P*/ )null, 
        new QualType(), CE);
    return null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::emitVirtualInheritanceTables">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 1631,
   FQN="(anonymous namespace)::ItaniumCXXABI::emitVirtualInheritanceTables", NM="_ZN12_GLOBAL__N_113ItaniumCXXABI28emitVirtualInheritanceTablesEPKN5clang13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABI28emitVirtualInheritanceTablesEPKN5clang13CXXRecordDeclE")
  //</editor-fold>
  @Override public void emitVirtualInheritanceTables(/*const*/ CXXRecordDecl /*P*/ RD)/* override*/ {
    final CodeGenVTables /*&*/ VTables = CGM.getVTables();
    GlobalVariable /*P*/ VTT = VTables.GetAddrOfVTT(RD);
    VTables.EmitVTTDefinition(VTT, CGM.getVTableLinkage(RD), RD);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::canSpeculativelyEmitVTable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 1637,
   FQN="(anonymous namespace)::ItaniumCXXABI::canSpeculativelyEmitVTable", NM="_ZNK12_GLOBAL__N_113ItaniumCXXABI26canSpeculativelyEmitVTableEPKN5clang13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZNK12_GLOBAL__N_113ItaniumCXXABI26canSpeculativelyEmitVTableEPKN5clang13CXXRecordDeclE")
  //</editor-fold>
  @Override public boolean canSpeculativelyEmitVTable(/*const*/ CXXRecordDecl /*P*/ RD) /*const*//* override*/ {
    // We don't emit available_externally vtables if we are in -fapple-kext mode
    // because kext mode does not permit devirtualization.
    if (CGM.getLangOpts().AppleKext) {
      return false;
    }
    
    // If we don't have any inline virtual functions, and if vtable is not hidden,
    // then we are safe to emit available_externally copy of vtable.
    // FIXME we can still emit a copy of the vtable if we
    // can emit definition of the inline functions.
    return !hasAnyUsedVirtualInlineFunction(RD) && !isVTableHidden(RD);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::setThunkLinkage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 278,
   FQN="(anonymous namespace)::ItaniumCXXABI::setThunkLinkage", NM="_ZN12_GLOBAL__N_113ItaniumCXXABI15setThunkLinkageEPN4llvm8FunctionEbN5clang10GlobalDeclEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABI15setThunkLinkageEPN4llvm8FunctionEbN5clang10GlobalDeclEb")
  //</editor-fold>
  @Override public void setThunkLinkage(Function /*P*/ Thunk, boolean ForVTable, GlobalDecl GD, 
                 boolean ReturnAdjustment)/* override*/ {
    // Allow inlining of thunks by emitting them with available_externally
    // linkage together with vtables when needed.
    if (ForVTable && !Thunk.hasLocalLinkage()) {
      Thunk.setLinkage(GlobalValue.LinkageTypes.AvailableExternallyLinkage);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::performThisAdjustment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 1700,
   FQN="(anonymous namespace)::ItaniumCXXABI::performThisAdjustment", NM="_ZN12_GLOBAL__N_113ItaniumCXXABI21performThisAdjustmentERN5clang7CodeGen15CodeGenFunctionENS2_7AddressERKNS1_14ThisAdjustmentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABI21performThisAdjustmentERN5clang7CodeGen15CodeGenFunctionENS2_7AddressERKNS1_14ThisAdjustmentE")
  //</editor-fold>
  @Override public Value /*P*/ performThisAdjustment(final CodeGenFunction /*&*/ CGF, 
                       Address This, 
                       final /*const*/ ThisAdjustment /*&*/ TA)/* override*/ {
    return ItaniumCXXABIStatics.performTypeAdjustment(CGF, new Address(This), TA.NonVirtual, 
        TA.Virtual.Itanium.VCallOffsetOffset, 
        /*IsReturnAdjustment=*/ false);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::performReturnAdjustment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 1708,
   FQN="(anonymous namespace)::ItaniumCXXABI::performReturnAdjustment", NM="_ZN12_GLOBAL__N_113ItaniumCXXABI23performReturnAdjustmentERN5clang7CodeGen15CodeGenFunctionENS2_7AddressERKNS1_16ReturnAdjustmentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABI23performReturnAdjustmentERN5clang7CodeGen15CodeGenFunctionENS2_7AddressERKNS1_16ReturnAdjustmentE")
  //</editor-fold>
  @Override public Value /*P*/ performReturnAdjustment(final CodeGenFunction /*&*/ CGF, Address Ret, 
                         final /*const*/ ReturnAdjustment /*&*/ RA)/* override*/ {
    return ItaniumCXXABIStatics.performTypeAdjustment(CGF, new Address(Ret), RA.NonVirtual, 
        RA.Virtual.Itanium.VBaseOffsetOffset, 
        /*IsReturnAdjustment=*/ true);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::getSrcArgforCopyCtor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 292,
   FQN="(anonymous namespace)::ItaniumCXXABI::getSrcArgforCopyCtor", NM="_ZNK12_GLOBAL__N_113ItaniumCXXABI20getSrcArgforCopyCtorEPKN5clang18CXXConstructorDeclERNS1_7CodeGen15FunctionArgListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZNK12_GLOBAL__N_113ItaniumCXXABI20getSrcArgforCopyCtorEPKN5clang18CXXConstructorDeclERNS1_7CodeGen15FunctionArgListE")
  //</editor-fold>
  @Override public /*size_t*/int getSrcArgforCopyCtor(/*const*/ CXXConstructorDecl /*P*/ $Prm0, 
                      final FunctionArgList /*&*/ Args) /*const*//* override*/ {
    assert (!Args.empty()) : "expected the arglist to not be empty!";
    return Args.size() - 1;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::GetPureVirtualCallName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 298,
   FQN="(anonymous namespace)::ItaniumCXXABI::GetPureVirtualCallName", NM="_ZN12_GLOBAL__N_113ItaniumCXXABI22GetPureVirtualCallNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABI22GetPureVirtualCallNameEv")
  //</editor-fold>
  @Override public StringRef GetPureVirtualCallName()/* override*/ {
    return new StringRef(/*KEEP_STR*/"__cxa_pure_virtual");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::GetDeletedVirtualCallName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 299,
   FQN="(anonymous namespace)::ItaniumCXXABI::GetDeletedVirtualCallName", NM="_ZN12_GLOBAL__N_113ItaniumCXXABI25GetDeletedVirtualCallNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABI25GetDeletedVirtualCallNameEv")
  //</editor-fold>
  @Override public StringRef GetDeletedVirtualCallName()/* override*/ {
    return new StringRef(/*KEEP_STR*/"__cxa_deleted_virtual");
  }

  
  
  /************************** Array allocation cookies **************************/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::getArrayCookieSizeImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 1729,
   FQN="(anonymous namespace)::ItaniumCXXABI::getArrayCookieSizeImpl", NM="_ZN12_GLOBAL__N_113ItaniumCXXABI22getArrayCookieSizeImplEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABI22getArrayCookieSizeImplEN5clang8QualTypeE")
  //</editor-fold>
  @Override public CharUnits getArrayCookieSizeImpl(QualType elementType)/* override*/ {
    // The array cookie is a size_t; pad that up to the element alignment.
    // The cookie is actually right-justified in that space.
    return new CharUnits(std.max(CharUnits.fromQuantity($uchar2long(CGM.Unnamed_field13.SizeSizeInBytes)), 
            CGM.getContext().getTypeAlignInChars(new QualType(elementType))));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::InitializeArrayCookie">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 1736,
   FQN="(anonymous namespace)::ItaniumCXXABI::InitializeArrayCookie", NM="_ZN12_GLOBAL__N_113ItaniumCXXABI21InitializeArrayCookieERN5clang7CodeGen15CodeGenFunctionENS2_7AddressEPN4llvm5ValueEPKNS1_10CXXNewExprENS1_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABI21InitializeArrayCookieERN5clang7CodeGen15CodeGenFunctionENS2_7AddressEPN4llvm5ValueEPKNS1_10CXXNewExprENS1_8QualTypeE")
  //</editor-fold>
  @Override public Address InitializeArrayCookie(final CodeGenFunction /*&*/ CGF, 
                       Address NewPtr, 
                       Value /*P*/ NumElements, 
                       /*const*/ CXXNewExpr /*P*/ expr, 
                       QualType ElementType)/* override*/ {
    assert (requiresArrayCookie(expr));
    
    /*uint*/int AS = NewPtr.getAddressSpace();
    
    final ASTContext /*&*/ Ctx = getContext();
    CharUnits SizeSize = CGF.getSizeSize();
    
    // The size of the cookie.
    CharUnits CookieSize = new CharUnits(std.max(SizeSize, Ctx.getTypeAlignInChars(new QualType(ElementType))));
    assert (CookieSize.$eq(getArrayCookieSizeImpl(new QualType(ElementType))));
    
    // Compute an offset to the cookie.
    Address CookiePtr = new Address(NewPtr);
    CharUnits CookieOffset = CookieSize.$sub(SizeSize);
    if (!CookieOffset.isZero()) {
      CookiePtr.$assignMove(CGF.Builder.CreateConstInBoundsByteGEP(new Address(CookiePtr), new CharUnits(CookieOffset)));
    }
    
    // Write the number of elements into the appropriate slot.
    Address NumElementsPtr = CGF.Builder.CreateElementBitCast(new Address(CookiePtr), CGF.Unnamed_field8.SizeTy);
    Instruction /*P*/ SI = CGF.Builder.CreateStore(NumElements, new Address(NumElementsPtr));
    
    // Handle the array cookie specially in ASan.
    if (CGM.getLangOpts().Sanitize.has(SanitizerKind.Address) && AS == 0
       && expr.getOperatorNew().isReplaceableGlobalAllocationFunction()) {
      // The store to the CookiePtr does not need to be instrumented.
      CGM.getSanitizerMetadata().disableSanitizerForInstruction(SI);
      org.llvm.ir.FunctionType /*P*/ FTy = org.llvm.ir.FunctionType.get(CGM.VoidTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(NumElementsPtr.getType(), true), false);
      Constant /*P*/ F = CGM.CreateRuntimeFunction(FTy, new StringRef(/*KEEP_STR*/"__asan_poison_cxx_array_cookie"));
      CGF.Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, new ArrayRef<Value /*P*/ >(NumElementsPtr.getPointer(), true));
    }
    
    // Finally, compute a pointer to the actual data buffer by skipping
    // over the cookie completely.
    return CGF.Builder.CreateConstInBoundsByteGEP(new Address(NewPtr), new CharUnits(CookieSize));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::readArrayCookieImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 1781,
   FQN="(anonymous namespace)::ItaniumCXXABI::readArrayCookieImpl", NM="_ZN12_GLOBAL__N_113ItaniumCXXABI19readArrayCookieImplERN5clang7CodeGen15CodeGenFunctionENS2_7AddressENS1_9CharUnitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABI19readArrayCookieImplERN5clang7CodeGen15CodeGenFunctionENS2_7AddressENS1_9CharUnitsE")
  //</editor-fold>
  @Override public Value /*P*/ readArrayCookieImpl(final CodeGenFunction /*&*/ CGF, 
                     Address allocPtr, 
                     CharUnits cookieSize)/* override*/ {
    // The element size is right-justified in the cookie.
    Address numElementsPtr = new Address(allocPtr);
    CharUnits numElementsOffset = cookieSize.$sub(CGF.getSizeSize());
    if (!numElementsOffset.isZero()) {
      numElementsPtr.$assignMove(
          CGF.Builder.CreateConstInBoundsByteGEP(new Address(numElementsPtr), new CharUnits(numElementsOffset))
      );
    }
    
    /*uint*/int AS = allocPtr.getAddressSpace();
    numElementsPtr.$assignMove(CGF.Builder.CreateElementBitCast(new Address(numElementsPtr), CGF.Unnamed_field8.SizeTy));
    if (!CGM.getLangOpts().Sanitize.has(SanitizerKind.Address) || AS != 0) {
      return CGF.Builder.CreateLoad(new Address(numElementsPtr));
    }
    // In asan mode emit a function call instead of a regular load and let the
    // run-time deal with it: if the shadow is properly poisoned return the
    // cookie, otherwise return 0 to avoid an infinite loop calling DTORs.
    // We can't simply ignore this load using nosanitize metadata because
    // the metadata may be lost.
    org.llvm.ir.FunctionType /*P*/ FTy = org.llvm.ir.FunctionType.get(CGF.Unnamed_field8.SizeTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(CGF.Unnamed_field8.SizeTy.getPointerTo(0), true), false);
    Constant /*P*/ F = CGM.CreateRuntimeFunction(FTy, new StringRef(/*KEEP_STR*/"__asan_load_cxx_array_cookie"));
    return CGF.Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(F, new ArrayRef<Value /*P*/ >(numElementsPtr.getPointer(), true));
  }

  
  
  /// The ARM code here follows the Itanium code closely enough that we
  /// just special-case it at particular places.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::EmitGuardedInit">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 1908,
   FQN="(anonymous namespace)::ItaniumCXXABI::EmitGuardedInit", NM="_ZN12_GLOBAL__N_113ItaniumCXXABI15EmitGuardedInitERN5clang7CodeGen15CodeGenFunctionERKNS1_7VarDeclEPN4llvm14GlobalVariableEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABI15EmitGuardedInitERN5clang7CodeGen15CodeGenFunctionERKNS1_7VarDeclEPN4llvm14GlobalVariableEb")
  //</editor-fold>
  @Override public void EmitGuardedInit(final CodeGenFunction /*&*/ CGF, 
                 final /*const*/ VarDecl /*&*/ D, 
                 GlobalVariable /*P*/ var, 
                 boolean shouldPerformInit)/* override*/ {
    final CGBuilderTy /*&*/ Builder = CGF.Builder;
    
    // Inline variables that weren't instantiated from variable templates have
    // partially-ordered initialization within their translation unit.
    boolean NonTemplateInline = D.isInline()
       && !isTemplateInstantiation(D.getTemplateSpecializationKind());
    
    // We only need to use thread-safe statics for local non-TLS variables and
    // inline variables; other global initialization is always single-threaded
    // or (through lazy dynamic loading in multiple threads) unsequenced.
    boolean threadsafe = getContext().getLangOpts().ThreadsafeStatics
       && (D.isLocalVarDecl() || NonTemplateInline)
       && !(D.getTLSKind().getValue() != 0);
    
    // If we have a global variable with internal linkage and thread-safe statics
    // are disabled, we can just let the guard variable be of type i8.
    boolean useInt8GuardVariable = !threadsafe && var.hasInternalLinkage();
    
    IntegerType /*P*/ guardTy;
    CharUnits guardAlignment/*J*/= new CharUnits();
    if (useInt8GuardVariable) {
      guardTy = CGF.Int8Ty;
      guardAlignment.$assignMove(CharUnits.One());
    } else {
      // Guard variables are 64 bits in the generic ABI and size width on ARM
      // (i.e. 32-bit on AArch32, 64-bit on AArch64).
      if (UseARMGuardVarABI) {
        guardTy = CGF.Unnamed_field8.SizeTy;
        guardAlignment.$assignMove(CGF.getSizeAlign());
      } else {
        guardTy = CGF.Int64Ty;
        guardAlignment.$assignMove(CharUnits.fromQuantity($uint2long(CGM.getDataLayout().getABITypeAlignment(guardTy))));
      }
    }
    org.llvm.ir.PointerType /*P*/ guardPtrTy = guardTy.getPointerTo();
    
    // Create the guard variable if we don't already have it (as we
    // might if we're double-emitting this function body).
    GlobalVariable /*P*/ guard = CGM.getStaticLocalDeclGuardAddress($AddrOf(D));
    if (!(guard != null)) {
      // Mangle the name for the guard.
      SmallString/*<256>*/ guardName/*J*/= new SmallString/*<256>*/(256);
      {
        raw_svector_ostream out = null;
        try {
          out/*J*/= new raw_svector_ostream(guardName);
          getMangleContext().mangleStaticGuardVariable($AddrOf(D), out);
        } finally {
          if (out != null) { out.$destroy(); }
        }
      }
      
      // Create the guard variable with a zero-initializer.
      // Just absorb linkage and visibility from the guarded variable.
      guard = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
          return new GlobalVariable(CGM.getModule(), guardTy, 
          false, var.getLinkage(), 
          ConstantInt.get(guardTy, $int2ulong(0)), 
          new Twine(guardName.str()));
       });
      guard.setVisibility(var.getVisibility());
      // If the variable is thread-local, so is its guard variable.
      guard.setThreadLocalMode(var.getThreadLocalMode());
      guard.setAlignment($long2uint(guardAlignment.getQuantity()));
      
      // The ABI says: "It is suggested that it be emitted in the same COMDAT
      // group as the associated data object." In practice, this doesn't work for
      // non-ELF object formats, so only do it for ELF.
      Comdat /*P*/ C = var.getComdat();
      if (!D.isLocalVarDecl() && (C != null)
         && CGM.getTarget().getTriple().isOSBinFormatELF()) {
        guard.setComdat(C);
        // An inline variable's guard function is run from the per-TU
        // initialization function, not via a dedicated global ctor function, so
        // we can't put it in a comdat.
        if (!NonTemplateInline) {
          CGF.CurFn.setComdat(C);
        }
      } else if (CGM.supportsCOMDAT() && guard.isWeakForLinker()) {
        guard.setComdat(CGM.getModule().getOrInsertComdat(guard.getName()));
      }
      
      CGM.setStaticLocalDeclGuardAddress($AddrOf(D), guard);
    }
    
    Address guardAddr = new Address(guard, new CharUnits(guardAlignment));
    
    // Test whether the variable has completed initialization.
    //
    // Itanium C++ ABI 3.3.2:
    //   The following is pseudo-code showing how these functions can be used:
    //     if (obj_guard.first_byte == 0) {
    //       if ( __cxa_guard_acquire (&obj_guard) ) {
    //         try {
    //           ... initialize the object ...;
    //         } catch (...) {
    //            __cxa_guard_abort (&obj_guard);
    //            throw;
    //         }
    //         ... queue object destructor with __cxa_atexit() ...;
    //         __cxa_guard_release (&obj_guard);
    //       }
    //     }
    
    // Load the first byte of the guard variable.
    LoadInst /*P*/ LI = Builder.CreateLoad(Builder.CreateElementBitCast(new Address(guardAddr), CGM.Int8Ty));
    
    // Itanium ABI:
    //   An implementation supporting thread-safety on multiprocessor
    //   systems must also guarantee that references to the initialized
    //   object do not occur before the load of the initialization flag.
    //
    // In LLVM, we do this by marking the load Acquire.
    if (threadsafe) {
      LI.setAtomic(AtomicOrdering.Acquire);
    }
    
    // For ARM, we should only check the first bit, rather than the entire byte:
    //
    // ARM C++ ABI 3.2.3.1:
    //   To support the potential use of initialization guard variables
    //   as semaphores that are the target of ARM SWP and LDREX/STREX
    //   synchronizing instructions we define a static initialization
    //   guard variable to be a 4-byte aligned, 4-byte word with the
    //   following inline access protocol.
    //     #define INITIALIZED 1
    //     if ((obj_guard & INITIALIZED) != INITIALIZED) {
    //       if (__cxa_guard_acquire(&obj_guard))
    //         ...
    //     }
    //
    // and similarly for ARM64:
    //
    // ARM64 C++ ABI 3.2.2:
    //   This ABI instead only specifies the value bit 0 of the static guard
    //   variable; all other bits are platform defined. Bit 0 shall be 0 when the
    //   variable is not initialized and 1 when it is.
    Value /*P*/ V = (UseARMGuardVarABI && !useInt8GuardVariable) ? Builder.CreateAnd(LI, ConstantInt.get(CGM.Int8Ty, $int2ulong(1))) : LI;
    Value /*P*/ isInitialized = Builder.CreateIsNull(V, new Twine(/*KEEP_STR*/"guard.uninitialized"));
    
    BasicBlock /*P*/ InitCheckBlock = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"init.check"));
    BasicBlock /*P*/ EndBlock = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"init.end"));
    
    // Check if the first byte of the guard variable is zero.
    Builder.CreateCondBr(isInitialized, InitCheckBlock, EndBlock);
    
    CGF.EmitBlock(InitCheckBlock);
    
    // Variables used when coping with thread-safe statics and exceptions.
    if (threadsafe) {
      // Call __cxa_guard_acquire.
      Value /*P*/ V$1 = CGF.EmitNounwindRuntimeCall(ItaniumCXXABIStatics.getGuardAcquireFn(CGM, guardPtrTy), new ArrayRef<Value /*P*/ >(guard, true));
      
      BasicBlock /*P*/ InitBlock = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"init"));
      
      Builder.CreateCondBr(Builder.CreateIsNotNull(V$1, new Twine(/*KEEP_STR*/"tobool")), 
          InitBlock, EndBlock);
      
      // Call __cxa_guard_abort along the exceptional edge.
      GlobalVariable $guard = guard;
      CGF.EHStack.<CallGuardAbort>pushCleanup$T(CleanupKind.EHCleanup, () -> new CallGuardAbort($guard));
      
      CGF.EmitBlock(InitBlock);
    }
    
    // Emit the initializer and add a global destructor if appropriate.
    CGF.EmitCXXGlobalVarDeclInit(D, var, shouldPerformInit);
    if (threadsafe) {
      // Pop the guard-abort cleanup if we pushed one.
      CGF.PopCleanupBlock();
      
      // Call __cxa_guard_release.  This cannot throw.
      CGF.EmitNounwindRuntimeCall(ItaniumCXXABIStatics.getGuardReleaseFn(CGM, guardPtrTy), 
          new ArrayRef<Value /*P*/ >(guardAddr.getPointer(), true));
    } else {
      Builder.CreateStore(ConstantInt.get(guardTy, $int2ulong(1)), new Address(guardAddr));
    }
    
    CGF.EmitBlock(EndBlock);
  }

  
  /// Register a global destructor as best as we know how.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::registerGlobalDtor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 2131,
   FQN="(anonymous namespace)::ItaniumCXXABI::registerGlobalDtor", NM="_ZN12_GLOBAL__N_113ItaniumCXXABI18registerGlobalDtorERN5clang7CodeGen15CodeGenFunctionERKNS1_7VarDeclEPN4llvm8ConstantESA_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABI18registerGlobalDtorERN5clang7CodeGen15CodeGenFunctionERKNS1_7VarDeclEPN4llvm8ConstantESA_")
  //</editor-fold>
  @Override public void registerGlobalDtor(final CodeGenFunction /*&*/ CGF, 
                    final /*const*/ VarDecl /*&*/ D, 
                    Constant /*P*/ dtor, 
                    Constant /*P*/ addr)/* override*/ {
    // Use __cxa_atexit if available.
    if (CGM.getCodeGenOpts().CXAAtExit) {
      ItaniumCXXABIStatics.emitGlobalDtorWithCXAAtExit(CGF, dtor, addr, (D.getTLSKind().getValue() != 0));
      /*JAVA:return*/return;
    }
    if ((D.getTLSKind().getValue() != 0)) {
      CGM.ErrorUnsupported($AddrOf(D), $("non-trivial TLS destruction"));
    }
    
    // In Apple kexts, we want to add a global destructor entry.
    // FIXME: shouldn't this be guarded by some variable?
    if (CGM.getLangOpts().AppleKext) {
      // Generate a global destructor entry.
      CGM.AddCXXDtorEntry(dtor, addr);
      /*JAVA:return*/return;
    }
    
    CGF.registerGlobalDtorWithAtExit(D, dtor, addr);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::getOrCreateThreadLocalWrapper">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 2181,
   FQN="(anonymous namespace)::ItaniumCXXABI::getOrCreateThreadLocalWrapper", NM="_ZN12_GLOBAL__N_113ItaniumCXXABI29getOrCreateThreadLocalWrapperEPKN5clang7VarDeclEPN4llvm5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABI29getOrCreateThreadLocalWrapperEPKN5clang7VarDeclEPN4llvm5ValueE")
  //</editor-fold>
  public Function /*P*/ getOrCreateThreadLocalWrapper(/*const*/ VarDecl /*P*/ VD, 
                               Value /*P*/ Val) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Mangle the name for the thread_local wrapper function.
      SmallString/*<256>*/ WrapperName/*J*/= new SmallString/*<256>*/(256);
      {
        raw_svector_ostream Out = null;
        try {
          Out/*J*/= new raw_svector_ostream(WrapperName);
          getMangleContext().mangleItaniumThreadLocalWrapper(VD, Out);
        } finally {
          if (Out != null) { Out.$destroy(); }
        }
      }
      {
        
        // FIXME: If VD is a definition, we should regenerate the function attributes
        // before returning.
        Value /*P*/ V = CGM.getModule().getNamedValue(WrapperName.$StringRef());
        if ((V != null)) {
          return cast_Function(V);
        }
      }
      
      QualType RetQT = VD.getType();
      if (RetQT.$arrow().isReferenceType()) {
        RetQT.$assignMove(RetQT.getNonReferenceType());
      }
      
      final /*const*/ CGFunctionInfo /*&*/ FI = $c$.clean(CGM.getTypes().arrangeBuiltinFunctionDeclaration(getContext().getPointerType(/*NO_COPY*/RetQT), $c$.track(new FunctionArgList())));
      
      org.llvm.ir.FunctionType /*P*/ FnTy = CGM.getTypes().GetFunctionType(FI);
      Function /*P*/ Wrapper = Function.Create(FnTy, ItaniumCXXABIStatics.getThreadLocalWrapperLinkage(VD, CGM), 
          new Twine(WrapperName.str()), $AddrOf(CGM.getModule()));
      
      CGM.SetLLVMFunctionAttributes((/*const*/ Decl /*P*/ )null, FI, Wrapper);
      if ((VD.hasDefinition().getValue() != 0)) {
        CGM.SetLLVMFunctionAttributesForDefinition((/*const*/ Decl /*P*/ )null, Wrapper);
      }
      
      // Always resolve references to the wrapper at link time.
      if (!Wrapper.hasLocalLinkage() && !(ItaniumCXXABIStatics.isThreadWrapperReplaceable(VD, CGM)
         && !GlobalVariable.isLinkOnceLinkage(Wrapper.getLinkage())
         && !GlobalVariable.isWeakODRLinkage(Wrapper.getLinkage()))) {
        Wrapper.setVisibility(GlobalValue.VisibilityTypes.HiddenVisibility);
      }
      if (ItaniumCXXABIStatics.isThreadWrapperReplaceable(VD, CGM)) {
        Wrapper.setCallingConv(CallingConv.CXX_FAST_TLS);
        Wrapper.addFnAttr(Attribute.AttrKind.NoUnwind);
      }
      return Wrapper;
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::EmitThreadLocalInitFuncs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 2226,
   FQN="(anonymous namespace)::ItaniumCXXABI::EmitThreadLocalInitFuncs", NM="_ZN12_GLOBAL__N_113ItaniumCXXABI24EmitThreadLocalInitFuncsERN5clang7CodeGen13CodeGenModuleEN4llvm8ArrayRefIPKNS1_7VarDeclEEENS6_IPNS5_8FunctionEEESA_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABI24EmitThreadLocalInitFuncsERN5clang7CodeGen13CodeGenModuleEN4llvm8ArrayRefIPKNS1_7VarDeclEEENS6_IPNS5_8FunctionEEESA_")
  //</editor-fold>
  @Override public void EmitThreadLocalInitFuncs(final CodeGenModule /*&*/ CGM, ArrayRef</*const*/ VarDecl /*P*/ > CXXThreadLocals, 
                          ArrayRef<Function /*P*/ > CXXThreadLocalInits, 
                          ArrayRef</*const*/ VarDecl /*P*/ > CXXThreadLocalInitVars)/* override*/ {
    Function /*P*/ InitFunc = null;
    if (!CXXThreadLocalInits.empty()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // Generate a guarded initialization function.
        org.llvm.ir.FunctionType /*P*/ FTy = org.llvm.ir.FunctionType.get(CGM.VoidTy, /*isVarArg=*/ false);
        final /*const*/ CGFunctionInfo /*&*/ FI = CGM.getTypes().arrangeNullaryFunction();
        InitFunc = CGM.CreateGlobalInitOrDestructFunction(FTy, new Twine(/*KEEP_STR*/"__tls_init"), FI, 
            new SourceLocation(), 
            /*TLS=*/ true);
        GlobalVariable /*P*/ Guard = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
            return new GlobalVariable(CGM.getModule(), CGM.Int8Ty, /*isConstant=*/ false, 
            GlobalVariable.LinkageTypes.InternalLinkage, 
            ConstantInt.get(CGM.Int8Ty, $int2ulong(0)), new Twine(/*KEEP_STR*/"__tls_guard"));
         });
        Guard.setThreadLocal(true);
        
        CharUnits GuardAlign = CharUnits.One();
        Guard.setAlignment($long2uint(GuardAlign.getQuantity()));
        
        $c$.track(new CodeGenFunction(CGM)).
            GenerateCXXGlobalInitFunc(InitFunc, new ArrayRef<Function /*P*/ >(CXXThreadLocalInits), 
            new Address(Guard, new CharUnits(GuardAlign))); $c$.clean();
        // On Darwin platforms, use CXX_FAST_TLS calling convention.
        if (CGM.getTarget().getTriple().isOSDarwin()) {
          InitFunc.setCallingConv(CallingConv.CXX_FAST_TLS);
          InitFunc.addFnAttr(Attribute.AttrKind.NoUnwind);
        }
      } finally {
        $c$.$destroy();
      }
    }
    for (/*const*/ VarDecl /*P*/ VD : CXXThreadLocals) {
      CGBuilderTy Builder = null;
      try {
        GlobalVariable /*P*/ Var = cast_GlobalVariable(CGM.GetGlobalValue(CGM.getMangledName(new GlobalDecl(VD))));
        
        // Some targets require that all access to thread local variables go through
        // the thread wrapper.  This means that we cannot attempt to create a thread
        // wrapper or a thread helper.
        if (ItaniumCXXABIStatics.isThreadWrapperReplaceable(VD, CGM) && !(VD.hasDefinition().getValue() != 0)) {
          continue;
        }
        
        // Mangle the name for the thread_local initialization function.
        SmallString/*<256>*/ InitFnName/*J*/= new SmallString/*<256>*/(256);
        {
          raw_svector_ostream Out = null;
          try {
            Out/*J*/= new raw_svector_ostream(InitFnName);
            getMangleContext().mangleItaniumThreadLocalInit(VD, Out);
          } finally {
            if (Out != null) { Out.$destroy(); }
          }
        }
        
        // If we have a definition for the variable, emit the initialization
        // function as an alias to the global Init function (if any). Otherwise,
        // produce a declaration of the initialization function.
        GlobalValue /*P*/ Init = null;
        boolean InitIsInitFunc = false;
        if ((VD.hasDefinition().getValue() != 0)) {
          InitIsInitFunc = true;
          if ((InitFunc != null)) {
            Init = GlobalAlias.create(Var.getLinkage(), new Twine(InitFnName.str()), 
                InitFunc);
          }
        } else {
          // Emit a weak global function referring to the initialization function.
          // This function will not exist if the TU defining the thread_local
          // variable in question does not need any dynamic initialization for
          // its thread_local variables.
          org.llvm.ir.FunctionType /*P*/ FnTy = org.llvm.ir.FunctionType.get(CGM.VoidTy, false);
          Init = Function.Create(FnTy, GlobalVariable.LinkageTypes.ExternalWeakLinkage, new Twine(InitFnName.str()), 
              $AddrOf(CGM.getModule()));
          final /*const*/ CGFunctionInfo /*&*/ FI = CGM.getTypes().arrangeNullaryFunction();
          CGM.SetLLVMFunctionAttributes((/*const*/ Decl /*P*/ )null, FI, cast_Function(Init));
        }
        if ((Init != null)) {
          Init.setVisibility(Var.getVisibility());
        }
        
        Function /*P*/ Wrapper = getOrCreateThreadLocalWrapper(VD, Var);
        final LLVMContext /*&*/ Context = CGM.getModule().getContext();
        BasicBlock /*P*/ Entry = BasicBlock.Create(Context, new Twine(/*KEEP_STR*/$EMPTY), Wrapper);
        Builder/*J*/= new CGBuilderTy(CGM, Entry);
        if (InitIsInitFunc) {
          if ((Init != null)) {
            CallInst /*P*/ CallVal = Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(Init);
            if (ItaniumCXXABIStatics.isThreadWrapperReplaceable(VD, CGM)) {
              CallVal.setCallingConv(CallingConv.CXX_FAST_TLS);
            }
          }
        } else {
          // Don't know whether we have an init function. Call it if it exists.
          Value /*P*/ Have = Builder.CreateIsNotNull(Init);
          BasicBlock /*P*/ InitBB = BasicBlock.Create(Context, new Twine(/*KEEP_STR*/$EMPTY), Wrapper);
          BasicBlock /*P*/ ExitBB = BasicBlock.Create(Context, new Twine(/*KEEP_STR*/$EMPTY), Wrapper);
          Builder.CreateCondBr(Have, InitBB, ExitBB);
          
          Builder.SetInsertPoint(InitBB);
          Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(Init);
          Builder.CreateBr(ExitBB);
          
          Builder.SetInsertPoint(ExitBB);
        }
        
        // For a reference, the result of the wrapper function is a pointer to
        // the referenced object.
        Value /*P*/ Val = Var;
        if (VD.getType().$arrow().isReferenceType()) {
          CharUnits Align = CGM.getContext().getDeclAlign(VD);
          Val = Builder.CreateAlignedLoad(Val, new CharUnits(Align));
        }
        if (Val.getType() != Wrapper.getReturnType()) {
          Val = Builder.CreatePointerBitCastOrAddrSpaceCast(Val, Wrapper.getReturnType(), new Twine(/*KEEP_STR*/$EMPTY));
        }
        Builder.CreateRet(Val);
      } finally {
        if (Builder != null) { Builder.$destroy(); }
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::usesThreadWrapperFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 326,
   FQN="(anonymous namespace)::ItaniumCXXABI::usesThreadWrapperFunction", NM="_ZNK12_GLOBAL__N_113ItaniumCXXABI25usesThreadWrapperFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZNK12_GLOBAL__N_113ItaniumCXXABI25usesThreadWrapperFunctionEv")
  //</editor-fold>
  @Override public boolean usesThreadWrapperFunction() /*const*//* override*/ {
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::EmitThreadLocalVarDeclLValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 2338,
   FQN="(anonymous namespace)::ItaniumCXXABI::EmitThreadLocalVarDeclLValue", NM="_ZN12_GLOBAL__N_113ItaniumCXXABI28EmitThreadLocalVarDeclLValueERN5clang7CodeGen15CodeGenFunctionEPKNS1_7VarDeclENS1_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABI28EmitThreadLocalVarDeclLValueERN5clang7CodeGen15CodeGenFunctionEPKNS1_7VarDeclENS1_8QualTypeE")
  //</editor-fold>
  @Override public LValue EmitThreadLocalVarDeclLValue(final CodeGenFunction /*&*/ CGF, 
                              /*const*/ VarDecl /*P*/ VD, 
                              QualType LValType)/* override*/ {
    Value /*P*/ Val = CGF.CGM.GetAddrOfGlobalVar(VD);
    Function /*P*/ Wrapper = getOrCreateThreadLocalWrapper(VD, Val);
    
    CallInst /*P*/ CallVal = CGF.Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(Wrapper);
    if (ItaniumCXXABIStatics.isThreadWrapperReplaceable(VD, CGF.CGM)) {
      CallVal.setCallingConv(CallingConv.CXX_FAST_TLS);
    }
    
    LValue LV/*J*/= new LValue();
    if (VD.getType().$arrow().isReferenceType()) {
      LV.$assignMove(CGF.MakeNaturalAlignAddrLValue(CallVal, new QualType(LValType)));
    } else {
      LV.$assignMove(CGF.MakeAddrLValue(CallVal, new QualType(LValType), 
              CGF.getContext().getDeclAlign(VD)));
    }
    // FIXME: need setObjCGCLValueClass?
    return LV;
  }

  
  
  /// Return whether the given global decl needs a VTT parameter, which it does
  /// if it's a base constructor or destructor with virtual bases.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::NeedsVTTParameter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 2360,
   FQN="(anonymous namespace)::ItaniumCXXABI::NeedsVTTParameter", NM="_ZN12_GLOBAL__N_113ItaniumCXXABI17NeedsVTTParameterEN5clang10GlobalDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABI17NeedsVTTParameterEN5clang10GlobalDeclE")
  //</editor-fold>
  @Override public boolean NeedsVTTParameter(GlobalDecl GD)/* override*/ {
    /*const*/ CXXMethodDecl /*P*/ MD = cast_CXXMethodDecl(GD.getDecl());
    
    // We don't have any virtual bases, just return early.
    if (!(MD.getParent$Const().getNumVBases() != 0)) {
      return false;
    }
    
    // Check if we have a base constructor.
    if (isa_CXXConstructorDecl(MD) && GD.getCtorType() == CXXCtorType.Ctor_Base) {
      return true;
    }
    
    // Check if we have a base destructor.
    if (isa_CXXDestructorDecl(MD) && GD.getDtorType() == CXXDtorType.Dtor_Base) {
      return true;
    }
    
    return false;
  }


  /**************************** RTTI Uniqueness ******************************/
  /*protected:*/
  /// Returns true if the ABI requires RTTI type_info objects to be unique
  /// across a program.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::shouldRTTIBeUnique">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 337,
   FQN="(anonymous namespace)::ItaniumCXXABI::shouldRTTIBeUnique", NM="_ZNK12_GLOBAL__N_113ItaniumCXXABI18shouldRTTIBeUniqueEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZNK12_GLOBAL__N_113ItaniumCXXABI18shouldRTTIBeUniqueEv")
  //</editor-fold>
  protected /*virtual*/ boolean shouldRTTIBeUnique() /*const*/ {
    return true;
  }

/*public:*/
  /// What sort of unique-RTTI behavior should we use?
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::RTTIUniquenessKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 341,
   FQN="(anonymous namespace)::ItaniumCXXABI::RTTIUniquenessKind", NM="_ZN12_GLOBAL__N_113ItaniumCXXABI18RTTIUniquenessKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABI18RTTIUniquenessKindE")
  //</editor-fold>
  public enum RTTIUniquenessKind implements Native.NativeUIntEnum {
    /// We are guaranteeing, or need to guarantee, that the RTTI string
    /// is unique.
    RUK_Unique(0),
    
    /// We are not guaranteeing uniqueness for the RTTI string, so we
    /// can demote to hidden visibility but must use string comparisons.
    RUK_NonUniqueHidden(RUK_Unique.getValue() + 1),
    
    /// We are not guaranteeing uniqueness for the RTTI string, so we
    /// have to use string comparisons, but we also have to emit it with
    /// non-hidden visibility.
    RUK_NonUniqueVisible(RUK_NonUniqueHidden.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static RTTIUniquenessKind valueOf(int val) {
      RTTIUniquenessKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final RTTIUniquenessKind[] VALUES;
      private static final RTTIUniquenessKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (RTTIUniquenessKind kind : RTTIUniquenessKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new RTTIUniquenessKind[min < 0 ? (1-min) : 0];
        VALUES = new RTTIUniquenessKind[max >= 0 ? (1+max) : 0];
        for (RTTIUniquenessKind kind : RTTIUniquenessKind.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
              VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final /*uint*/int value;
    private RTTIUniquenessKind(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  
  /// Return the required visibility status for the given type and linkage in
  /// the current ABI.
  
  /// What sort of uniqueness rules should we use for the RTTI for the
  /// given type?
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::classifyRTTIUniqueness">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 3381,
   FQN="(anonymous namespace)::ItaniumCXXABI::classifyRTTIUniqueness", NM="_ZNK12_GLOBAL__N_113ItaniumCXXABI22classifyRTTIUniquenessEN5clang8QualTypeEN4llvm11GlobalValue12LinkageTypesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZNK12_GLOBAL__N_113ItaniumCXXABI22classifyRTTIUniquenessEN5clang8QualTypeEN4llvm11GlobalValue12LinkageTypesE")
  //</editor-fold>
  public ItaniumCXXABI.RTTIUniquenessKind classifyRTTIUniqueness(QualType CanTy, GlobalValue.LinkageTypes Linkage) /*const*/ {
    if (shouldRTTIBeUnique()) {
      return RTTIUniquenessKind.RUK_Unique;
    }
    
    // It's only necessary for linkonce_odr or weak_odr linkage.
    if (Linkage != GlobalValue.LinkageTypes.LinkOnceODRLinkage
       && Linkage != GlobalValue.LinkageTypes.WeakODRLinkage) {
      return RTTIUniquenessKind.RUK_Unique;
    }
    
    // It's only necessary with default visibility.
    if (CanTy.$arrow().getVisibility() != Visibility.DefaultVisibility) {
      return RTTIUniquenessKind.RUK_Unique;
    }
    
    // If we're not required to publish this symbol, hide it.
    if (Linkage == GlobalValue.LinkageTypes.LinkOnceODRLinkage) {
      return RTTIUniquenessKind.RUK_NonUniqueHidden;
    }
    
    // If we're required to publish this symbol, as we might be under an
    // explicit instantiation, leave it with default visibility but
    // enable string-comparisons.
    assert (Linkage == GlobalValue.LinkageTypes.WeakODRLinkage);
    return RTTIUniquenessKind.RUK_NonUniqueVisible;
  }

  /*friend  class ItaniumRTTIBuilder*/
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::emitCXXStructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 3476,
   FQN="(anonymous namespace)::ItaniumCXXABI::emitCXXStructor", NM="_ZN12_GLOBAL__N_113ItaniumCXXABI15emitCXXStructorEPKN5clang13CXXMethodDeclENS1_7CodeGen12StructorTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABI15emitCXXStructorEPKN5clang13CXXMethodDeclENS1_7CodeGen12StructorTypeE")
  //</editor-fold>
  @Override public void emitCXXStructor(/*const*/ CXXMethodDecl /*P*/ MD, 
                 StructorType Type)/* override*/ {
    /*const*/ CXXConstructorDecl /*P*/ CD = dyn_cast_CXXConstructorDecl(MD);
    /*const*/ CXXDestructorDecl /*P*/ DD = (CD != null) ? null : cast_CXXDestructorDecl(MD);
    
    StructorCodegen CGType = ItaniumCXXABIStatics.getCodegenToUse(CGM, MD);
    if (Type == StructorType.Complete) {
      GlobalDecl CompleteDecl/*J*/= new GlobalDecl();
      GlobalDecl BaseDecl/*J*/= new GlobalDecl();
      if ((CD != null)) {
        CompleteDecl.$assignMove(new GlobalDecl(JD$CXXConstructorDecl$C$P_CXXCtorType.INSTANCE, CD, CXXCtorType.Ctor_Complete));
        BaseDecl.$assignMove(new GlobalDecl(JD$CXXConstructorDecl$C$P_CXXCtorType.INSTANCE, CD, CXXCtorType.Ctor_Base));
      } else {
        CompleteDecl.$assignMove(new GlobalDecl(JD$CXXDestructorDecl$C$P_CXXDtorType.INSTANCE, DD, CXXDtorType.Dtor_Complete));
        BaseDecl.$assignMove(new GlobalDecl(JD$CXXDestructorDecl$C$P_CXXDtorType.INSTANCE, DD, CXXDtorType.Dtor_Base));
      }
      if (CGType == StructorCodegen.Alias || CGType == StructorCodegen.COMDAT) {
        ItaniumCXXABIStatics.emitConstructorDestructorAlias(CGM, new GlobalDecl(CompleteDecl), new GlobalDecl(BaseDecl));
        return;
      }
      if (CGType == StructorCodegen.RAUW) {
        StringRef MangledName = CGM.getMangledName(new GlobalDecl(CompleteDecl));
        Constant /*P*/ Aliasee = CGM.GetAddrOfGlobal(new GlobalDecl(BaseDecl));
        CGM.addReplacement(new StringRef(MangledName), Aliasee);
        return;
      }
    }
    
    // The base destructor is equivalent to the base destructor of its
    // base class if there is exactly one non-virtual base class with a
    // non-trivial destructor, there are no fields with a non-trivial
    // destructor, and the body of the destructor is trivial.
    if ((DD != null) && Type == StructorType.Base && CGType != StructorCodegen.COMDAT
       && !CGM.TryEmitBaseDestructorAsAlias(DD)) {
      return;
    }
    
    Function /*P*/ Fn = CGM.codegenCXXStructor(MD, Type);
    if (CGType == StructorCodegen.COMDAT) {
      raw_svector_ostream Out = null;
      try {
        SmallString/*<256>*/ Buffer/*J*/= new SmallString/*<256>*/(256);
        Out/*J*/= new raw_svector_ostream(Buffer);
        if ((DD != null)) {
          getMangleContext().mangleCXXDtorComdat(DD, Out);
        } else {
          getMangleContext().mangleCXXCtorComdat(CD, Out);
        }
        Comdat /*P*/ C = CGM.getModule().getOrInsertComdat(Out.str());
        Fn.setComdat(C);
      } finally {
        if (Out != null) { Out.$destroy(); }
      }
    } else {
      CGM.maybeSetTrivialComdat($Deref(MD), $Deref(Fn));
    }
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::hasAnyUsedVirtualInlineFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 366,
   FQN="(anonymous namespace)::ItaniumCXXABI::hasAnyUsedVirtualInlineFunction", NM="_ZNK12_GLOBAL__N_113ItaniumCXXABI31hasAnyUsedVirtualInlineFunctionEPKN5clang13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZNK12_GLOBAL__N_113ItaniumCXXABI31hasAnyUsedVirtualInlineFunctionEPKN5clang13CXXRecordDeclE")
  //</editor-fold>
  private boolean hasAnyUsedVirtualInlineFunction(/*const*/ CXXRecordDecl /*P*/ RD) /*const*/ {
    final /*const*/ VTableLayout /*&*/ VtableLayout = CGM.getItaniumVTableContext().getVTableLayout(RD);
    
    for (final /*const*/ VTableComponent /*&*/ VtableComponent : VtableLayout.vtable_components()) {
      if (!VtableComponent.isUsedFunctionPointerKind()) {
        continue;
      }
      
      /*const*/ CXXMethodDecl /*P*/ Method = VtableComponent.getFunctionDecl();
      if (Method.getCanonicalDecl$Const().isInlined()) {
        return true;
      }
    }
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::isVTableHidden">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 381,
   FQN="(anonymous namespace)::ItaniumCXXABI::isVTableHidden", NM="_ZNK12_GLOBAL__N_113ItaniumCXXABI14isVTableHiddenEPKN5clang13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZNK12_GLOBAL__N_113ItaniumCXXABI14isVTableHiddenEPKN5clang13CXXRecordDeclE")
  //</editor-fold>
  private boolean isVTableHidden(/*const*/ CXXRecordDecl /*P*/ RD) /*const*/ {
    final /*const*/ VTableLayout /*&*/ VtableLayout = CGM.getItaniumVTableContext().getVTableLayout(RD);
    
    for (final /*const*/ VTableComponent /*&*/ VtableComponent : VtableLayout.vtable_components()) {
      if (VtableComponent.isRTTIKind()) {
        /*const*/ CXXRecordDecl /*P*/ RTTIDecl = VtableComponent.getRTTIDecl();
        if (RTTIDecl.getVisibility() == Visibility.HiddenVisibility) {
          return true;
        }
      } else if (VtableComponent.isUsedFunctionPointerKind()) {
        /*const*/ CXXMethodDecl /*P*/ Method = VtableComponent.getFunctionDecl();
        if (Method.getVisibility() == Visibility.HiddenVisibility
           && !Method.isDefined()) {
          return true;
        }
      }
    }
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ItaniumCXXABI::~ItaniumCXXABI">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 41,
   FQN="(anonymous namespace)::ItaniumCXXABI::~ItaniumCXXABI", NM="_ZN12_GLOBAL__N_113ItaniumCXXABID0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_113ItaniumCXXABID0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    VTables.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "VTables=" + VTables // NOI18N
              + ", UseARMMethodPtrABI=" + UseARMMethodPtrABI // NOI18N
              + ", UseARMGuardVarABI=" + UseARMGuardVarABI // NOI18N
              + super.toString(); // NOI18N
  }
}
