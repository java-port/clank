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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
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
import org.clang.codegen.java.ClangCodeGenFunctionPointers.*;
import org.llvm.ir.CallingConv;
import org.clang.ast.aliases.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.llvm.ir.java.IrRTTI.*;
import static org.clang.ast.java.AstJavaDifferentiators.*;
import org.clang.ast.llvm.DenseMapInfoCharUnits;
import org.clang.ast.llvm.DenseMapInfoQualType;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 43,
 FQN="(anonymous namespace)::MicrosoftCXXABI", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABIE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABIE")
//</editor-fold>
public class MicrosoftCXXABI extends /*public*/ CGCXXABI implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::MicrosoftCXXABI">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 45,
   FQN="(anonymous namespace)::MicrosoftCXXABI::MicrosoftCXXABI", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABIC1ERN5clang7CodeGen13CodeGenModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABIC1ERN5clang7CodeGen13CodeGenModuleE")
  //</editor-fold>
  public MicrosoftCXXABI(final CodeGenModule /*&*/ CGM) {
    // : CGCXXABI(CGM), VFTablesMap(), VTablesMap(), DeferredVFTables(), VBTablesMap(), GuardVariableMap(), ThreadLocalGuardVariableMap(), ThreadSafeGuardNumMap(), TypeDescriptorTypeMap(), BaseClassDescriptorType(null), ClassHierarchyDescriptorType(null), CompleteObjectLocatorType(null), CatchableTypeArrays(), CatchableTypeType(null), CatchableTypeArrayTypeMap(), ThrowInfoType(null) 
    //START JInit
    super(CGM);
    this.VFTablesMap = new DenseMap<std.pair</*const*/ CXXRecordDecl /*P*/ , CharUnits>, GlobalValue /*P*/ >(
            new DenseMapInfoPair<CXXRecordDecl, CharUnits>(DenseMapInfo$LikePtr.$Info(), DenseMapInfoCharUnits.$Info()), (GlobalValue /*P*/ )null);
    this.VTablesMap = new DenseMap<std.pair</*const*/ CXXRecordDecl /*P*/ , CharUnits>, GlobalVariable /*P*/ >(new DenseMapInfoPair<CXXRecordDecl, CharUnits>(DenseMapInfo$LikePtr.$Info(), DenseMapInfoCharUnits.$Info()), (GlobalVariable /*P*/ )null);
    this.DeferredVFTables = new SmallPtrSet</*const*/ CXXRecordDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 4);
    this.VBTablesMap = new DenseMap</*const*/ CXXRecordDecl /*P*/ , VBTableGlobals>(DenseMapInfo$LikePtr.$Info(), new VBTableGlobals());
    this.GuardVariableMap = new DenseMap</*const*/ DeclContext /*P*/ , GuardInfo>(DenseMapInfo$LikePtr.$Info(), new GuardInfo());
    this.ThreadLocalGuardVariableMap = new DenseMap</*const*/ DeclContext /*P*/ , GuardInfo>(DenseMapInfo$LikePtr.$Info(), new GuardInfo());
    this.ThreadSafeGuardNumMap = new DenseMapTypeUInt</*const*/ DeclContext /*P*/ >(DenseMapInfo$LikePtr.$Info(), 0);
    this.TypeDescriptorTypeMap = new DenseMapUIntType<StructType /*P*/ >(DenseMapInfoUInt.$Info(), (StructType /*P*/ )null);
    this.BaseClassDescriptorType = null;
    this.ClassHierarchyDescriptorType = null;
    this.CompleteObjectLocatorType = null;
    this.CatchableTypeArrays = new DenseMap<QualType, GlobalVariable /*P*/ >(DenseMapInfoQualType.$Info(), (GlobalVariable /*P*/ )null);
    this.CatchableTypeType = null;
    this.CatchableTypeArrayTypeMap = new DenseMapUIntType<StructType /*P*/ >(DenseMapInfoUInt.$Info(), (StructType /*P*/ )null);
    this.ThrowInfoType = null;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::HasThisReturn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 1065,
   FQN="(anonymous namespace)::MicrosoftCXXABI::HasThisReturn", NM="_ZNK12_GLOBAL__N_115MicrosoftCXXABI13HasThisReturnEN5clang10GlobalDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZNK12_GLOBAL__N_115MicrosoftCXXABI13HasThisReturnEN5clang10GlobalDeclE")
  //</editor-fold>
  @Override public boolean HasThisReturn(GlobalDecl GD) /*const*//* override*/ {
    return isa_CXXConstructorDecl(GD.getDecl());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::hasMostDerivedReturn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 1074,
   FQN="(anonymous namespace)::MicrosoftCXXABI::hasMostDerivedReturn", NM="_ZNK12_GLOBAL__N_115MicrosoftCXXABI20hasMostDerivedReturnEN5clang10GlobalDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZNK12_GLOBAL__N_115MicrosoftCXXABI20hasMostDerivedReturnEN5clang10GlobalDeclE")
  //</editor-fold>
  @Override public boolean hasMostDerivedReturn(GlobalDecl GD) /*const*//* override*/ {
    return MicrosoftCXXABIStatics.isDeletingDtor(new GlobalDecl(GD));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::classifyReturnType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 1078,
   FQN="(anonymous namespace)::MicrosoftCXXABI::classifyReturnType", NM="_ZNK12_GLOBAL__N_115MicrosoftCXXABI18classifyReturnTypeERN5clang7CodeGen14CGFunctionInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZNK12_GLOBAL__N_115MicrosoftCXXABI18classifyReturnTypeERN5clang7CodeGen14CGFunctionInfoE")
  //</editor-fold>
  @Override public boolean classifyReturnType(final CGFunctionInfo /*&*/ FI) /*const*//* override*/ {
    /*const*/ CXXRecordDecl /*P*/ RD = ((CanProxyType)FI.getReturnType().$arrow()).$arrow().getAsCXXRecordDecl();
    if (!(RD != null)) {
      return false;
    }
    
    CharUnits Align = CGM.getContext().getTypeAlignInChars(FI.getReturnType().$QualType());
    if (FI.isInstanceMethod()) {
      // If it's an instance method, aggregates are always returned indirectly via
      // the second parameter.
      FI.getReturnInfo().$assignMove(ABIArgInfo.getIndirect(new CharUnits(Align), /*ByVal=*/ false));
      FI.getReturnInfo().setSRetAfterThis(FI.isInstanceMethod());
      return true;
    } else if (!RD.isPOD()) {
      // If it's a free function, non-POD types are returned indirectly.
      FI.getReturnInfo().$assignMove(ABIArgInfo.getIndirect(new CharUnits(Align), /*ByVal=*/ false));
      return true;
    }
    
    // Otherwise, use the C ABI rules.
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::getRecordArgABI">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 790,
   FQN="(anonymous namespace)::MicrosoftCXXABI::getRecordArgABI", NM="_ZNK12_GLOBAL__N_115MicrosoftCXXABI15getRecordArgABIEPKN5clang13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZNK12_GLOBAL__N_115MicrosoftCXXABI15getRecordArgABIEPKN5clang13CXXRecordDeclE")
  //</editor-fold>
  @Override public CGCXXABI.RecordArgABI getRecordArgABI(/*const*/ CXXRecordDecl /*P*/ RD) /*const*//* override*/ {
    switch (CGM.getTarget().getTriple().getArch()) {
     default:
      // FIXME: Implement for other architectures.
      return RecordArgABI.RAA_Default;
     case x86:
      // All record arguments are passed in memory on x86.  Decide whether to
      // construct the object directly in argument memory, or to construct the
      // argument elsewhere and copy the bytes during the call.
      
      // If C++ prohibits us from making a copy, construct the arguments directly
      // into argument memory.
      if (!canCopyArgument(RD)) {
        return RecordArgABI.RAA_DirectInMemory;
      }
      
      // Otherwise, construct the argument into a temporary and copy the bytes
      // into the outgoing argument memory.
      return RecordArgABI.RAA_Default;
     case x86_64:
      // Win64 passes objects with non-trivial copy ctors indirectly.
      if (RD.hasNonTrivialCopyConstructor()) {
        return RecordArgABI.RAA_Indirect;
      }
      
      // If an object has a destructor, we'd really like to pass it indirectly
      // because it allows us to elide copies.  Unfortunately, MSVC makes that
      // impossible for small types, which it will pass in a single register or
      // stack slot. Most objects with dtors are large-ish, so handle that early.
      // We can't call out all large objects as being indirect because there are
      // multiple x64 calling conventions and the C++ ABI code shouldn't dictate
      // how we pass large POD types.
      if (RD.hasNonTrivialDestructor()
         && $greater_ulong_ullong(getContext().getTypeSize(RD.getTypeForDecl()), $int2ullong(64))) {
        return RecordArgABI.RAA_Indirect;
      }
      
      // We have a trivial copy constructor or no copy constructors, but we have
      // to make sure it isn't deleted.
      boolean CopyDeleted = false;
      for (/*const*/ CXXConstructorDecl /*P*/ CD : RD.ctors()) {
        if (CD.isCopyConstructor()) {
          assert (CD.isTrivial());
          // We had at least one undeleted trivial copy ctor.  Return directly.
          if (!CD.isDeleted()) {
            return RecordArgABI.RAA_Default;
          }
          CopyDeleted = true;
        }
      }
      
      // The trivial copy constructor was deleted.  Return indirectly.
      if (CopyDeleted) {
        return RecordArgABI.RAA_Indirect;
      }
      
      // There were no copy ctors.  Return in RAX.
      return RecordArgABI.RAA_Default;
    }
    //throw new llvm_unreachable("invalid enum");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::isSRetParameterAfterThis">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 58,
   FQN="(anonymous namespace)::MicrosoftCXXABI::isSRetParameterAfterThis", NM="_ZNK12_GLOBAL__N_115MicrosoftCXXABI24isSRetParameterAfterThisEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZNK12_GLOBAL__N_115MicrosoftCXXABI24isSRetParameterAfterThisEv")
  //</editor-fold>
  @Override public boolean isSRetParameterAfterThis() /*const*//* override*/ {
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::isThisCompleteObject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 60,
   FQN="(anonymous namespace)::MicrosoftCXXABI::isThisCompleteObject", NM="_ZNK12_GLOBAL__N_115MicrosoftCXXABI20isThisCompleteObjectEN5clang10GlobalDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZNK12_GLOBAL__N_115MicrosoftCXXABI20isThisCompleteObjectEN5clang10GlobalDeclE")
  //</editor-fold>
  @Override public boolean isThisCompleteObject(GlobalDecl GD) /*const*//* override*/ {
    // The Microsoft ABI doesn't use separate complete-object vs.
    // base-object variants of constructors, but it does of destructors.
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
    
    // No other kinds.
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::getSrcArgforCopyCtor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 81,
   FQN="(anonymous namespace)::MicrosoftCXXABI::getSrcArgforCopyCtor", NM="_ZNK12_GLOBAL__N_115MicrosoftCXXABI20getSrcArgforCopyCtorEPKN5clang18CXXConstructorDeclERNS1_7CodeGen15FunctionArgListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZNK12_GLOBAL__N_115MicrosoftCXXABI20getSrcArgforCopyCtorEPKN5clang18CXXConstructorDeclERNS1_7CodeGen15FunctionArgListE")
  //</editor-fold>
  @Override public /*size_t*/int getSrcArgforCopyCtor(/*const*/ CXXConstructorDecl /*P*/ CD, 
                      final FunctionArgList /*&*/ Args) /*const*//* override*/ {
    assert ($greatereq_uint(Args.size(), 2)) : "expected the arglist to have at least two args!";
    // The 'most_derived' parameter goes second if the ctor is variadic and
    // has v-bases.
    if ($greater_uint(CD.getParent$Const().getNumVBases(), 0)
       && CD.getType().$arrow().castAs(FunctionProtoType.class).isVariadic()) {
      return 2;
    }
    return 1;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::getVBPtrOffsets">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,//use type ptr sort version
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 93,
   FQN="(anonymous namespace)::MicrosoftCXXABI::getVBPtrOffsets", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI15getVBPtrOffsetsEPKN5clang13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI15getVBPtrOffsetsEPKN5clang13CXXRecordDeclE")
  //</editor-fold>
  @Override public std.vector<CharUnits> getVBPtrOffsets(/*const*/ CXXRecordDecl /*P*/ RD)/* override*/ {
    std.vector<CharUnits> VBPtrOffsets = null;
    try {
      VBPtrOffsets/*J*/= new std.vector<CharUnits>(new CharUnits());
      final /*const*/ ASTContext /*&*/ Context = getContext();
      final /*const*/ ASTRecordLayout /*&*/ Layout = Context.getASTRecordLayout(RD);
      
      final /*const*/ VBTableGlobals /*&*/ VBGlobals = enumerateVBTables(RD);
      for (/*const*/ VPtrInfo /*P*/ VBT : $Deref(VBGlobals.VBTables)) {
        final /*const*/ ASTRecordLayout /*&*/ SubobjectLayout = Context.getASTRecordLayout(VBT.BaseWithVPtr);
        CharUnits Offs = new CharUnits(VBT.NonVirtualOffset);
        Offs.$addassign(SubobjectLayout.getVBPtrOffset());
        if ((VBT.getVBaseWithVPtr() != null)) {
          Offs.$addassign(Layout.getVBaseClassOffset(VBT.getVBaseWithVPtr()));
        }
        VBPtrOffsets.push_back_T$C$R(Offs);
      }
      llvm.array_pod_sort(VBPtrOffsets.begin().toPointer(), VBPtrOffsets.end().toPointer());
      return new std.vector<CharUnits>(JD$Move.INSTANCE, VBPtrOffsets);
    } finally {
      if (VBPtrOffsets != null) { VBPtrOffsets.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::GetPureVirtualCallName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 112,
   FQN="(anonymous namespace)::MicrosoftCXXABI::GetPureVirtualCallName", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI22GetPureVirtualCallNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI22GetPureVirtualCallNameEv")
  //</editor-fold>
  @Override public StringRef GetPureVirtualCallName()/* override*/ {
    return new StringRef(/*KEEP_STR*/"_purecall");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::GetDeletedVirtualCallName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 113,
   FQN="(anonymous namespace)::MicrosoftCXXABI::GetDeletedVirtualCallName", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI25GetDeletedVirtualCallNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI25GetDeletedVirtualCallNameEv")
  //</editor-fold>
  @Override public StringRef GetDeletedVirtualCallName()/* override*/ {
    return new StringRef(/*KEEP_STR*/"_purecall");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::emitVirtualObjectDelete">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 851,
   FQN="(anonymous namespace)::MicrosoftCXXABI::emitVirtualObjectDelete", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI23emitVirtualObjectDeleteERN5clang7CodeGen15CodeGenFunctionEPKNS1_13CXXDeleteExprENS2_7AddressENS1_8QualTypeEPKNS1_17CXXDestructorDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI23emitVirtualObjectDeleteERN5clang7CodeGen15CodeGenFunctionEPKNS1_13CXXDeleteExprENS2_7AddressENS1_8QualTypeEPKNS1_17CXXDestructorDeclE")
  //</editor-fold>
  @Override public void emitVirtualObjectDelete(final CodeGenFunction /*&*/ CGF, 
                         /*const*/ CXXDeleteExpr /*P*/ DE, 
                         Address Ptr, 
                         QualType ElementType, 
                         /*const*/ CXXDestructorDecl /*P*/ Dtor)/* override*/ {
    // FIXME: Provide a source location here even though there's no
    // CXXMemberCallExpr for dtor call.
    boolean UseGlobalDelete = DE.isGlobalDelete();
    CXXDtorType DtorType = UseGlobalDelete ? CXXDtorType.Dtor_Complete : CXXDtorType.Dtor_Deleting;
    Value /*P*/ MDThis = EmitVirtualDestructorCall(CGF, Dtor, DtorType, new Address(Ptr), /*CE=*/ (/*const*/ CXXMemberCallExpr /*P*/ )null);
    if (UseGlobalDelete) {
      CGF.EmitDeleteCall(DE.getOperatorDelete(), MDThis, new QualType(ElementType));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::emitRethrow">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 866,
   FQN="(anonymous namespace)::MicrosoftCXXABI::emitRethrow", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI11emitRethrowERN5clang7CodeGen15CodeGenFunctionEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI11emitRethrowERN5clang7CodeGen15CodeGenFunctionEb")
  //</editor-fold>
  @Override public void emitRethrow(final CodeGenFunction /*&*/ CGF, boolean isNoReturn)/* override*/ {
    Value /*P*/ Args[/*2*/] = new Value /*P*/  [/*2*/] {
      ConstantPointerNull.get(CGM.Unnamed_field9.Int8PtrTy), 
      ConstantPointerNull.get(getThrowInfoType().getPointerTo())};
    Constant /*P*/ Fn = getThrowFn();
    if (isNoReturn) {
      CGF.EmitNoreturnRuntimeCallOrInvoke(Fn, new ArrayRef<Value /*P*/ >(Args, true));
    } else {
      CGF.EmitRuntimeCallOrInvoke(Fn, new ArrayRef<Value /*P*/ >(Args, true));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::emitThrow">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 4172,
   FQN="(anonymous namespace)::MicrosoftCXXABI::emitThrow", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI9emitThrowERN5clang7CodeGen15CodeGenFunctionEPKNS1_12CXXThrowExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI9emitThrowERN5clang7CodeGen15CodeGenFunctionEPKNS1_12CXXThrowExprE")
  //</editor-fold>
  @Override public void emitThrow(final CodeGenFunction /*&*/ CGF, /*const*/ CXXThrowExpr /*P*/ E)/* override*/ {
    /*const*/ Expr /*P*/ SubExpr = E.getSubExpr$Const();
    QualType ThrowType = SubExpr.getType();
    // The exception object lives on the stack and it's address is passed to the
    // runtime function.
    Address AI = CGF.CreateMemTemp(new QualType(ThrowType));
    CGF.EmitAnyExprToMem(SubExpr, new Address(AI), ThrowType.getQualifiers(), 
        /*IsInit=*/ true);
    
    // The so-called ThrowInfo is used to describe how the exception object may be
    // caught.
    GlobalVariable /*P*/ TI = getThrowInfo(new QualType(ThrowType));
    
    // Call into the runtime to throw the exception.
    Value /*P*/ Args[/*2*/] = new Value /*P*/  [/*2*/] {
      CGF.Builder.CreateBitCast(AI.getPointer(), CGM.Unnamed_field9.Int8PtrTy), 
      TI
    };
    CGF.EmitNoreturnRuntimeCallOrInvoke(getThrowFn(), new ArrayRef<Value /*P*/ >(Args, true));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::emitBeginCatch">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 891,
   FQN="(anonymous namespace)::MicrosoftCXXABI::emitBeginCatch", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI14emitBeginCatchERN5clang7CodeGen15CodeGenFunctionEPKNS1_12CXXCatchStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI14emitBeginCatchERN5clang7CodeGen15CodeGenFunctionEPKNS1_12CXXCatchStmtE")
  //</editor-fold>
  @Override public void emitBeginCatch(final CodeGenFunction /*&*/ CGF, 
                /*const*/ CXXCatchStmt /*P*/ S)/* override*/ {
    // In the MS ABI, the runtime handles the copy, and the catch handler is
    // responsible for destruction.
    VarDecl /*P*/ CatchParam = S.getExceptionDecl();
    BasicBlock /*P*/ CatchPadBB = CGF.Builder.GetInsertBlock();
    CatchPadInst /*P*/ CPI = cast_CatchPadInst(CatchPadBB.getFirstNonPHI());
    CGF.CurrentFuncletPad = CPI;
    
    // If this is a catch-all or the catch parameter is unnamed, we don't need to
    // emit an alloca to the object.
    if (!(CatchParam != null) || !CatchParam.getDeclName().$bool()) {
      CGF.EHStack.<CatchRetScope>pushCleanup$T(CleanupKind.NormalCleanup, () -> new CatchRetScope(CPI));
      return;
    }
    
    CodeGenFunction.AutoVarEmission var = CGF.EmitAutoVarAlloca(/*Deref*/CatchParam);
    CPI.setArgOperand(2, var.getObjectAddress(CGF).getPointer());
    CGF.EHStack.<CatchRetScope>pushCleanup$T(CleanupKind.NormalCleanup, () -> new CatchRetScope(CPI));
    CGF.EmitAutoVarCleanups(var);
  }

  
  
  /// \brief Gets or a creates a Microsoft CompleteObjectLocator.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::getMSCompleteObjectLocator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 3741,
   FQN="(anonymous namespace)::MicrosoftCXXABI::getMSCompleteObjectLocator", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI26getMSCompleteObjectLocatorEPKN5clang13CXXRecordDeclEPKNS1_8VPtrInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI26getMSCompleteObjectLocatorEPKN5clang13CXXRecordDeclEPKNS1_8VPtrInfoE")
  //</editor-fold>
  public GlobalVariable /*P*/ getMSCompleteObjectLocator(/*const*/ CXXRecordDecl /*P*/ RD, 
                            /*const*/ VPtrInfo /*P*/ Info) {
    return new MSRTTIBuilder(/*Deref*/this, RD).getCompleteObjectLocator(Info);
  }

  
  
  /// \brief Gets a TypeDescriptor.  Returns a llvm::Constant * rather than a
  /// llvm::GlobalVariable * because different type descriptors have different
  /// types, and need to be abstracted.  They are abstracting by casting the
  /// address to an Int8PtrTy.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::getAddrOfRTTIDescriptor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 3705,
   FQN="(anonymous namespace)::MicrosoftCXXABI::getAddrOfRTTIDescriptor", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI23getAddrOfRTTIDescriptorEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI23getAddrOfRTTIDescriptorEN5clang8QualTypeE")
  //</editor-fold>
  @Override public Constant /*P*/ getAddrOfRTTIDescriptor(QualType Type)/* override*/ {
    SmallString/*<256>*/ MangledName/*J*/= new SmallString/*<256>*/(256);
    {
      raw_svector_ostream Out = null;
      try {
        Out/*J*/= new raw_svector_ostream(MangledName);
        getMangleContext().mangleCXXRTTI(new QualType(Type), Out);
      } finally {
        if (Out != null) { Out.$destroy(); }
      }
    }
    {
      
      // Check to see if we've already declared this TypeDescriptor.
      GlobalVariable /*P*/ GV = CGM.getModule().getNamedGlobal(MangledName.$StringRef());
      if ((GV != null)) {
        return ConstantExpr.getBitCast(GV, CGM.Unnamed_field9.Int8PtrTy);
      }
    }
    
    // Compute the fields for the TypeDescriptor.
    SmallString/*<256>*/ TypeInfoString/*J*/= new SmallString/*<256>*/(256);
    {
      raw_svector_ostream Out = null;
      try {
        Out/*J*/= new raw_svector_ostream(TypeInfoString);
        getMangleContext().mangleCXXRTTIName(new QualType(Type), Out);
      } finally {
        if (Out != null) { Out.$destroy(); }
      }
    }
    
    // Declare and initialize the TypeDescriptor.
    Constant /*P*/ Fields[/*3*/] = new Constant /*P*/  [/*3*/] {
      MicrosoftCXXABIStatics.getTypeInfoVTable(CGM),  // VFPtr
      ConstantPointerNull.get(CGM.Unnamed_field9.Int8PtrTy),  // Runtime data
      ConstantDataArray.getString(CGM.getLLVMContext(), TypeInfoString.$StringRef())};
    StructType /*P*/ TypeDescriptorType = getTypeDescriptorType(TypeInfoString.$StringRef());
    GlobalVariable /*P*/ Var = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
        return new GlobalVariable(CGM.getModule(), TypeDescriptorType, /*Constant=*/ false, 
                MicrosoftCXXABIStatics.getLinkageForRTTI(new QualType(Type)), 
        ConstantStruct.get(TypeDescriptorType, new ArrayRef<Constant /*P*/ >(Fields, true)), 
        new Twine(MangledName));
     });
    if (Var.isWeakForLinker()) {
      Var.setComdat(CGM.getModule().getOrInsertComdat(Var.getName()));
    }
    return ConstantExpr.getBitCast(Var, CGM.Unnamed_field9.Int8PtrTy);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::getAddrOfCXXCatchHandlerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 3675,
   FQN="(anonymous namespace)::MicrosoftCXXABI::getAddrOfCXXCatchHandlerType", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI28getAddrOfCXXCatchHandlerTypeEN5clang8QualTypeES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI28getAddrOfCXXCatchHandlerTypeEN5clang8QualTypeES2_")
  //</editor-fold>
  @Override public CatchTypeInfo getAddrOfCXXCatchHandlerType(QualType Type, 
                              QualType CatchHandlerType)/* override*/ {
    // TypeDescriptors for exceptions never have qualified pointer types,
    // qualifiers are stored seperately in order to support qualification
    // conversions.
    bool$ref IsConst = create_bool$ref();
    bool$ref IsVolatile = create_bool$ref();
    bool$ref IsUnaligned = create_bool$ref();
    Type.$assignMove(
        MicrosoftCXXABIStatics.decomposeTypeForEH(getContext(), new QualType(Type), IsConst, IsVolatile, IsUnaligned)
    );
    
    boolean IsReference = CatchHandlerType.$arrow().isReferenceType();
    
    /*uint32_t*/int Flags = 0;
    if (IsConst.$deref()) {
      Flags |= 1;
    }
    if (IsVolatile.$deref()) {
      Flags |= 2;
    }
    if (IsUnaligned.$deref()) {
      Flags |= 4;
    }
    if (IsReference) {
      Flags |= 8;
    }
    
    return ((CatchTypeInfo)(new CatchTypeInfo(
      getAddrOfRTTIDescriptor(new QualType(Type)).stripPointerCasts(), 
      Flags)));
  }

  
  /// MSVC needs an extra flag to indicate a catchall.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::getCatchAllTypeInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 132,
   FQN="(anonymous namespace)::MicrosoftCXXABI::getCatchAllTypeInfo", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI19getCatchAllTypeInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI19getCatchAllTypeInfoEv")
  //</editor-fold>
  @Override public CatchTypeInfo getCatchAllTypeInfo()/* override*/ {
    return ((CatchTypeInfo)(new CatchTypeInfo(null, 0x40)));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::shouldTypeidBeNullChecked">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 950,
   FQN="(anonymous namespace)::MicrosoftCXXABI::shouldTypeidBeNullChecked", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI25shouldTypeidBeNullCheckedEbN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI25shouldTypeidBeNullCheckedEbN5clang8QualTypeE")
  //</editor-fold>
  @Override public boolean shouldTypeidBeNullChecked(boolean IsDeref, 
                           QualType SrcRecordTy)/* override*/ {
    /*const*/ CXXRecordDecl /*P*/ SrcDecl = SrcRecordTy.$arrow().getAsCXXRecordDecl();
    return IsDeref
       && !getContext().getASTRecordLayout(SrcDecl).hasExtendableVFPtr();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::EmitBadTypeidCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 967,
   FQN="(anonymous namespace)::MicrosoftCXXABI::EmitBadTypeidCall", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI17EmitBadTypeidCallERN5clang7CodeGen15CodeGenFunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI17EmitBadTypeidCallERN5clang7CodeGen15CodeGenFunctionE")
  //</editor-fold>
  @Override public void EmitBadTypeidCall(final CodeGenFunction /*&*/ CGF)/* override*/ {
    CallSite Call = MicrosoftCXXABIStatics.emitRTtypeidCall(CGF, Constant.getNullValue(CGM.Unnamed_field9.VoidPtrTy));
    Call.setDoesNotReturn();
    CGF.Builder.CreateUnreachable();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::EmitTypeid">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 974,
   FQN="(anonymous namespace)::MicrosoftCXXABI::EmitTypeid", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI10EmitTypeidERN5clang7CodeGen15CodeGenFunctionENS1_8QualTypeENS2_7AddressEPN4llvm4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI10EmitTypeidERN5clang7CodeGen15CodeGenFunctionENS1_8QualTypeENS2_7AddressEPN4llvm4TypeE")
  //</editor-fold>
  @Override public Value /*P*/ EmitTypeid(final CodeGenFunction /*&*/ CGF, 
            QualType SrcRecordTy, 
            Address ThisPtr, 
            org.llvm.ir.Type /*P*/ StdTypeInfoPtrTy)/* override*/ {
    ThisPtr = performBaseAdjustment(CGF, new Address(ThisPtr), new QualType(SrcRecordTy)).first;
    Instruction /*P*/ Typeid = MicrosoftCXXABIStatics.emitRTtypeidCall(CGF, ThisPtr.getPointer()).getInstruction();
    return CGF.Builder.CreateBitCast(Typeid, StdTypeInfoPtrTy);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::shouldDynamicCastCallBeNullChecked">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 984,
   FQN="(anonymous namespace)::MicrosoftCXXABI::shouldDynamicCastCallBeNullChecked", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI34shouldDynamicCastCallBeNullCheckedEbN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI34shouldDynamicCastCallBeNullCheckedEbN5clang8QualTypeE")
  //</editor-fold>
  @Override public boolean shouldDynamicCastCallBeNullChecked(boolean SrcIsPtr, 
                                    QualType SrcRecordTy)/* override*/ {
    /*const*/ CXXRecordDecl /*P*/ SrcDecl = SrcRecordTy.$arrow().getAsCXXRecordDecl();
    return SrcIsPtr
       && !getContext().getASTRecordLayout(SrcDecl).hasExtendableVFPtr();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::EmitDynamicCastCall">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 991,
   FQN="(anonymous namespace)::MicrosoftCXXABI::EmitDynamicCastCall", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI19EmitDynamicCastCallERN5clang7CodeGen15CodeGenFunctionENS2_7AddressENS1_8QualTypeES6_S6_PN4llvm10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI19EmitDynamicCastCallERN5clang7CodeGen15CodeGenFunctionENS2_7AddressENS1_8QualTypeES6_S6_PN4llvm10BasicBlockE")
  //</editor-fold>
  @Override public Value /*P*/ EmitDynamicCastCall(final CodeGenFunction /*&*/ CGF, Address This, QualType SrcRecordTy, 
                     QualType DestTy, QualType DestRecordTy, BasicBlock /*P*/ CastEnd)/* override*/ {
    org.llvm.ir.Type /*P*/ DestLTy = CGF.ConvertType(new QualType(DestTy));
    
    Value /*P*/ SrcRTTI = CGF.CGM.GetAddrOfRTTIDescriptor(SrcRecordTy.getUnqualifiedType());
    Value /*P*/ DestRTTI = CGF.CGM.GetAddrOfRTTIDescriptor(DestRecordTy.getUnqualifiedType());
    
    Value /*P*/ Offset;
    final pair<Address, Value> $thisAndOffset = performBaseAdjustment(CGF, new Address(This), new QualType(SrcRecordTy));
    This = $thisAndOffset.first;
    Offset = $thisAndOffset.second;
    Value /*P*/ ThisPtr = This.getPointer();
    Offset = CGF.Builder.CreateTrunc(Offset, CGF.Int32Ty);
    
    // PVOID __RTDynamicCast(
    //   PVOID inptr,
    //   LONG VfDelta,
    //   PVOID SrcType,
    //   PVOID TargetType,
    //   BOOL isReference)
    org.llvm.ir.Type /*P*/ ArgTypes[/*5*/] = new org.llvm.ir.Type /*P*/  [/*5*/] {
      CGF.Unnamed_field9.Int8PtrTy, CGF.Int32Ty, CGF.Unnamed_field9.Int8PtrTy, 
      CGF.Unnamed_field9.Int8PtrTy, CGF.Int32Ty};
    Constant /*P*/ Function = CGF.CGM.CreateRuntimeFunction(org.llvm.ir.FunctionType.get(CGF.Unnamed_field9.Int8PtrTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(ArgTypes, true), false), 
        new StringRef(/*KEEP_STR*/"__RTDynamicCast"));
    Value /*P*/ Args[/*5*/] = new Value /*P*/  [/*5*/] {
      ThisPtr, Offset, SrcRTTI, DestRTTI, 
      ConstantInt.get(CGF.Int32Ty, (DestTy.$arrow().isReferenceType() ? 1 : 0))};
    ThisPtr = CGF.EmitRuntimeCallOrInvoke(Function, new ArrayRef<Value /*P*/ >(Args, true)).getInstruction();
    return CGF.Builder.CreateBitCast(ThisPtr, DestLTy);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::EmitDynamicCastToVoid">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 1024,
   FQN="(anonymous namespace)::MicrosoftCXXABI::EmitDynamicCastToVoid", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI21EmitDynamicCastToVoidERN5clang7CodeGen15CodeGenFunctionENS2_7AddressENS1_8QualTypeES6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI21EmitDynamicCastToVoidERN5clang7CodeGen15CodeGenFunctionENS2_7AddressENS1_8QualTypeES6_")
  //</editor-fold>
  @Override public Value /*P*/ EmitDynamicCastToVoid(final CodeGenFunction /*&*/ CGF, Address Value, 
                       QualType SrcRecordTy, 
                       QualType DestTy)/* override*/ {
    Value = performBaseAdjustment(CGF, new Address(Value), new QualType(SrcRecordTy)).first;
    
    // PVOID __RTCastToVoid(
    //   PVOID inptr)
    org.llvm.ir.Type /*P*/ ArgTypes[/*1*/] = new org.llvm.ir.Type /*P*/  [/*1*/] {CGF.Unnamed_field9.Int8PtrTy};
    Constant /*P*/ Function = CGF.CGM.CreateRuntimeFunction(org.llvm.ir.FunctionType.get(CGF.Unnamed_field9.Int8PtrTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(ArgTypes, true), false), 
        new StringRef(/*KEEP_STR*/"__RTCastToVoid"));
    Value /*P*/ Args[/*1*/] = new Value /*P*/  [/*1*/] {Value.getPointer()};
    return CGF.EmitRuntimeCall(Function, new ArrayRef<Value /*P*/ >(Args, true));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::EmitBadCastCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 1040,
   FQN="(anonymous namespace)::MicrosoftCXXABI::EmitBadCastCall", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI15EmitBadCastCallERN5clang7CodeGen15CodeGenFunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI15EmitBadCastCallERN5clang7CodeGen15CodeGenFunctionE")
  //</editor-fold>
  @Override public boolean EmitBadCastCall(final CodeGenFunction /*&*/ CGF)/* override*/ {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::canSpeculativelyEmitVTable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 155,
   FQN="(anonymous namespace)::MicrosoftCXXABI::canSpeculativelyEmitVTable", NM="_ZNK12_GLOBAL__N_115MicrosoftCXXABI26canSpeculativelyEmitVTableEPKN5clang13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZNK12_GLOBAL__N_115MicrosoftCXXABI26canSpeculativelyEmitVTableEPKN5clang13CXXRecordDeclE")
  //</editor-fold>
  @Override public boolean canSpeculativelyEmitVTable(/*const*/ CXXRecordDecl /*P*/ RD) /*const*//* override*/ {
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::GetVirtualBaseClassOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 1044,
   FQN="(anonymous namespace)::MicrosoftCXXABI::GetVirtualBaseClassOffset", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI25GetVirtualBaseClassOffsetERN5clang7CodeGen15CodeGenFunctionENS2_7AddressEPKNS1_13CXXRecordDeclES8_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI25GetVirtualBaseClassOffsetERN5clang7CodeGen15CodeGenFunctionENS2_7AddressEPKNS1_13CXXRecordDeclES8_")
  //</editor-fold>
  @Override public Value /*P*/ GetVirtualBaseClassOffset(final CodeGenFunction /*&*/ CGF, Address This, /*const*/ CXXRecordDecl /*P*/ ClassDecl, 
                           /*const*/ CXXRecordDecl /*P*/ BaseClassDecl)/* override*/ {
    final /*const*/ ASTContext /*&*/ Context = getContext();
    long/*int64_t*/ VBPtrChars = Context.getASTRecordLayout(ClassDecl).getVBPtrOffset().getQuantity();
    Value /*P*/ VBPtrOffset = ConstantInt.get(CGM.Unnamed_field8.PtrDiffTy, VBPtrChars);
    CharUnits IntSize = Context.getTypeSizeInChars(Context.IntTy.$QualType());
    CharUnits VBTableChars = IntSize.$star(
        $uint2long(CGM.getMicrosoftVTableContext().getVBTableIndex(ClassDecl, BaseClassDecl))
    );
    Value /*P*/ VBTableOffset = ConstantInt.get(CGM.IntTy, VBTableChars.getQuantity());
    
    Value /*P*/ VBPtrToNewBase = GetVBaseOffsetFromVBPtr(CGF, new Address(This), VBPtrOffset, VBTableOffset);
    VBPtrToNewBase
       = CGF.Builder.CreateSExtOrBitCast(VBPtrToNewBase, CGM.Unnamed_field8.PtrDiffTy);
    return CGF.Builder.CreateNSWAdd(VBPtrOffset, VBPtrToNewBase);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::EmitCtorCompleteObjectHandler">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 1100,
   FQN="(anonymous namespace)::MicrosoftCXXABI::EmitCtorCompleteObjectHandler", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI29EmitCtorCompleteObjectHandlerERN5clang7CodeGen15CodeGenFunctionEPKNS1_13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI29EmitCtorCompleteObjectHandlerERN5clang7CodeGen15CodeGenFunctionEPKNS1_13CXXRecordDeclE")
  //</editor-fold>
  @Override public BasicBlock /*P*/ EmitCtorCompleteObjectHandler(final CodeGenFunction /*&*/ CGF, 
                               /*const*/ CXXRecordDecl /*P*/ RD)/* override*/ {
    Value /*P*/ IsMostDerivedClass = getStructorImplicitParamValue(CGF).$deref();
    assert ((IsMostDerivedClass != null)) : "ctor for a class with virtual bases must have an implicit parameter";
    Value /*P*/ IsCompleteObject = CGF.Builder.CreateIsNotNull(IsMostDerivedClass, new Twine(/*KEEP_STR*/"is_complete_object"));
    
    BasicBlock /*P*/ CallVbaseCtorsBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"ctor.init_vbases"));
    BasicBlock /*P*/ SkipVbaseCtorsBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"ctor.skip_vbases"));
    CGF.Builder.CreateCondBr(IsCompleteObject, 
        CallVbaseCtorsBB, SkipVbaseCtorsBB);
    
    CGF.EmitBlock(CallVbaseCtorsBB);
    
    // Fill in the vbtable pointers here.
    EmitVBPtrStores(CGF, RD);
    
    // CGF will put the base ctor calls in this basic block for us later.
    return SkipVbaseCtorsBB;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::initializeHiddenVirtualInheritanceMembers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 1124,
   FQN="(anonymous namespace)::MicrosoftCXXABI::initializeHiddenVirtualInheritanceMembers", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI41initializeHiddenVirtualInheritanceMembersERN5clang7CodeGen15CodeGenFunctionEPKNS1_13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI41initializeHiddenVirtualInheritanceMembersERN5clang7CodeGen15CodeGenFunctionEPKNS1_13CXXRecordDeclE")
  //</editor-fold>
  @Override public void initializeHiddenVirtualInheritanceMembers(final CodeGenFunction /*&*/ CGF, /*const*/ CXXRecordDecl /*P*/ RD)/* override*/ {
    // In most cases, an override for a vbase virtual method can adjust
    // the "this" parameter by applying a constant offset.
    // However, this is not enough while a constructor or a destructor of some
    // class X is being executed if all the following conditions are met:
    //  - X has virtual bases, (1)
    //  - X overrides a virtual method M of a vbase Y, (2)
    //  - X itself is a vbase of the most derived class.
    //
    // If (1) and (2) are true, the vtorDisp for vbase Y is a hidden member of X
    // which holds the extra amount of "this" adjustment we must do when we use
    // the X vftables (i.e. during X ctor or dtor).
    // Outside the ctors and dtors, the values of vtorDisps are zero.
    final /*const*/ ASTRecordLayout /*&*/ Layout = getContext().getASTRecordLayout(RD);
    // JAVA: typedef ASTRecordLayout::VBaseOffsetsMapTy VBOffsets
//    final class VBOffsets extends DenseMap</*const*/ CXXRecordDecl /*P*/ , ASTRecordLayout.VBaseInfo>{ };
    final /*const*/DenseMap</*const*/ CXXRecordDecl /*P*/ , ASTRecordLayout.VBaseInfo> /*&*/ VBaseMap = Layout.getVBaseOffsetsMap();
    final CGBuilderTy /*&*/ Builder = CGF.Builder;
    
    /*uint*/int AS = getThisAddress(CGF).getAddressSpace();
    Value /*P*/ Int8This = null; // Initialize lazily.
    
    for (DenseMapIterator</*const*/ CXXRecordDecl /*P*/ , ASTRecordLayout.VBaseInfo> I = VBaseMap.begin$Const(), E = VBaseMap.end$Const();
         I.$noteq(E); I.$preInc()) {
      if (!I.$arrow().second.hasVtorDisp()) {
        continue;
      }
      
      Value /*P*/ VBaseOffset = GetVirtualBaseClassOffset(CGF, getThisAddress(CGF), RD, I.$arrow().first);
      long/*uint64_t*/ ConstantVBaseOffset = Layout.getVBaseClassOffset(I.$arrow().first).getQuantity();
      
      // vtorDisp_for_vbase = vbptr[vbase_idx] - offsetof(RD, vbase).
      Value /*P*/ VtorDispValue = Builder.CreateSub(VBaseOffset, ConstantInt.get(CGM.Unnamed_field8.PtrDiffTy, ConstantVBaseOffset), 
          new Twine(/*KEEP_STR*/"vtordisp.value"));
      VtorDispValue = Builder.CreateTruncOrBitCast(VtorDispValue, CGF.Int32Ty);
      if (!(Int8This != null)) {
        Int8This = Builder.CreateBitCast(getThisValue(CGF), 
            CGF.Int8Ty.getPointerTo(AS));
      }
      Value /*P*/ VtorDispPtr = Builder.CreateInBoundsGEP(Int8This, new ArrayRef<Value /*P*/ >(VBaseOffset, true));
      // vtorDisp is always the 32-bits before the vbase in the class layout.
      VtorDispPtr = Builder.CreateConstGEP1_32(VtorDispPtr, -4);
      VtorDispPtr = Builder.CreateBitCast(VtorDispPtr, CGF.Int32Ty.getPointerTo(AS), new Twine(/*KEEP_STR*/"vtordisp.ptr"));
      
      Builder.CreateAlignedStore(VtorDispValue, VtorDispPtr, 
          CharUnits.fromQuantity(4));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::EmitCXXConstructors">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 1186,
   FQN="(anonymous namespace)::MicrosoftCXXABI::EmitCXXConstructors", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI19EmitCXXConstructorsEPKN5clang18CXXConstructorDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI19EmitCXXConstructorsEPKN5clang18CXXConstructorDeclE")
  //</editor-fold>
  @Override public void EmitCXXConstructors(/*const*/ CXXConstructorDecl /*P*/ D)/* override*/ {
    // There's only one constructor type in this ABI.
    CGM.EmitGlobal(new GlobalDecl(JD$CXXConstructorDecl$C$P_CXXCtorType.INSTANCE, D, CXXCtorType.Ctor_Complete));
    
    // Exported default constructors either have a simple call-site where they use
    // the typical calling convention and have a single 'this' pointer for an
    // argument -or- they get a wrapper function which appropriately thunks to the
    // real default constructor.  This thunk is the default constructor closure.
    if (D.hasAttr(DLLExportAttr.class) && D.isDefaultConstructor()) {
      if (!MicrosoftCXXABIStatics.hasDefaultCXXMethodCC(getContext(), D) || D.getNumParams() != 0) {
        Function /*P*/ Fn = getAddrOfCXXCtorClosure(D, CXXCtorType.Ctor_DefaultClosure);
        Fn.setLinkage(GlobalValue.LinkageTypes.WeakODRLinkage);
        Fn.setDLLStorageClass(GlobalValue.DLLStorageClassTypes.DLLExportStorageClass);
      }
    }
  }

  
  // Background on MSVC destructors
  // ==============================
  //
  // Both Itanium and MSVC ABIs have destructor variants.  The variant names
  // roughly correspond in the following way:
  //   Itanium       Microsoft
  //   Base       -> no name, just ~Class
  //   Complete   -> vbase destructor
  //   Deleting   -> scalar deleting destructor
  //                 vector deleting destructor
  //
  // The base and complete destructors are the same as in Itanium, although the
  // complete destructor does not accept a VTT parameter when there are virtual
  // bases.  A separate mechanism involving vtordisps is used to ensure that
  // virtual methods of destroyed subobjects are not called.
  //
  // The deleting destructors accept an i32 bitfield as a second parameter.  Bit
  // 1 indicates if the memory should be deleted.  Bit 2 indicates if the this
  // pointer points to an array.  The scalar deleting destructor assumes that
  // bit 2 is zero, and therefore does not contain a loop.
  //
  // For virtual destructors, only one entry is reserved in the vftable, and it
  // always points to the vector deleting destructor.  The vector deleting
  // destructor is the most general, so it can be used to destroy objects in
  // place, delete single heap objects, or delete arrays.
  //
  // A TU defining a non-inline destructor is only guaranteed to emit a base
  // destructor, and all of the other variants are emitted on an as-needed basis
  // in COMDATs.  Because a non-base destructor can be emitted in a TU that
  // lacks a definition for the destructor, non-base destructors must always
  // delegate to or alias the base destructor.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::buildStructorSignature">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 1228,
   FQN="(anonymous namespace)::MicrosoftCXXABI::buildStructorSignature", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI22buildStructorSignatureEPKN5clang13CXXMethodDeclENS1_7CodeGen12StructorTypeERN4llvm15SmallVectorImplINS1_7CanQualINS1_4TypeEEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI22buildStructorSignatureEPKN5clang13CXXMethodDeclENS1_7CodeGen12StructorTypeERN4llvm15SmallVectorImplINS1_7CanQualINS1_4TypeEEEEE")
  //</editor-fold>
  @Override public void buildStructorSignature(/*const*/ CXXMethodDecl /*P*/ MD, StructorType T, 
                        final SmallVectorImpl<CanQual<org.clang.ast.Type> > /*&*/ ArgTys)/* override*/ {
    // TODO: 'for base' flag
    if (T == StructorType.Deleting) {
      // The scalar deleting destructor takes an implicit int parameter.
      ArgTys.push_back(getContext().IntTy);
    }
    /*const*/ CXXConstructorDecl /*P*/ CD = dyn_cast_CXXConstructorDecl(MD);
    if (!(CD != null)) {
      return;
    }
    
    // All parameters are already in place except is_most_derived, which goes
    // after 'this' if it's variadic and last if it's not.
    /*const*/ CXXRecordDecl /*P*/ Class = CD.getParent$Const();
    /*const*/ FunctionProtoType /*P*/ FPT = CD.getType().$arrow().castAs(FunctionProtoType.class);
    if ((Class.getNumVBases() != 0)) {
      if (FPT.isVariadic()) {
        ArgTys.insert_iterator$T_T$C$R(ArgTys.begin().$add(1), getContext().IntTy);
      } else {
        ArgTys.push_back(getContext().IntTy);
      }
    }
  }

  
  /// Non-base dtors should be emitted as delegating thunks in this ABI.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::useThunkForDtorVariant">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 209,
   FQN="(anonymous namespace)::MicrosoftCXXABI::useThunkForDtorVariant", NM="_ZNK12_GLOBAL__N_115MicrosoftCXXABI22useThunkForDtorVariantEPKN5clang17CXXDestructorDeclENS1_11CXXDtorTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZNK12_GLOBAL__N_115MicrosoftCXXABI22useThunkForDtorVariantEPKN5clang17CXXDestructorDeclENS1_11CXXDtorTypeE")
  //</editor-fold>
  @Override public boolean useThunkForDtorVariant(/*const*/ CXXDestructorDecl /*P*/ Dtor, 
                        CXXDtorType DT) /*const*//* override*/ {
    return DT != CXXDtorType.Dtor_Base;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::EmitCXXDestructors">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 1253,
   FQN="(anonymous namespace)::MicrosoftCXXABI::EmitCXXDestructors", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI18EmitCXXDestructorsEPKN5clang17CXXDestructorDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI18EmitCXXDestructorsEPKN5clang17CXXDestructorDeclE")
  //</editor-fold>
  @Override public void EmitCXXDestructors(/*const*/ CXXDestructorDecl /*P*/ D)/* override*/ {
    // The TU defining a dtor is only guaranteed to emit a base destructor.  All
    // other destructor variants are delegating thunks.
    CGM.EmitGlobal(new GlobalDecl(JD$CXXDestructorDecl$C$P_CXXDtorType.INSTANCE, D, CXXDtorType.Dtor_Base));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::getThisArgumentTypeForMethod">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 216,
   FQN="(anonymous namespace)::MicrosoftCXXABI::getThisArgumentTypeForMethod", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI28getThisArgumentTypeForMethodEPKN5clang13CXXMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI28getThisArgumentTypeForMethodEPKN5clang13CXXMethodDeclE")
  //</editor-fold>
  @Override public /*const*/ CXXRecordDecl /*P*/ getThisArgumentTypeForMethod(/*const*/ CXXMethodDecl /*P*/ MD)/* override*/ {
    MD = MD.getCanonicalDecl$Const();
    if (MD.isVirtual() && !isa_CXXDestructorDecl(MD)) {
      MicrosoftVTableContext.MethodVFTableLocation ML = new MicrosoftVTableContext.MethodVFTableLocation(CGM.getMicrosoftVTableContext().getMethodVFTableLocation(new GlobalDecl(MD)));
      // The vbases might be ordered differently in the final overrider object
      // and the complete object, so the "this" argument may sometimes point to
      // memory that has no particular type (e.g. past the complete object).
      // In this case, we just use a generic pointer type.
      // FIXME: might want to have a more precise type in the non-virtual
      // multiple inheritance case.
      if ((ML.VBase != null) || !ML.VFPtrOffset.isZero()) {
        return null;
      }
    }
    return MD.getParent$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::adjustThisArgumentForVirtualFunctionCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 1296,
   FQN="(anonymous namespace)::MicrosoftCXXABI::adjustThisArgumentForVirtualFunctionCall", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI40adjustThisArgumentForVirtualFunctionCallERN5clang7CodeGen15CodeGenFunctionENS1_10GlobalDeclENS2_7AddressEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI40adjustThisArgumentForVirtualFunctionCallERN5clang7CodeGen15CodeGenFunctionENS1_10GlobalDeclENS2_7AddressEb")
  //</editor-fold>
  @Override public Address adjustThisArgumentForVirtualFunctionCall(final CodeGenFunction /*&*/ CGF, GlobalDecl GD, Address This, 
                                          boolean VirtualCall)/* override*/ {
    if (!VirtualCall) {
      // If the call of a virtual function is not virtual, we just have to
      // compensate for the adjustment the virtual function does in its prologue.
      CharUnits Adjustment = getVirtualFunctionPrologueThisAdjustment(new GlobalDecl(GD));
      if (Adjustment.isZero()) {
        return new Address(JD$Move.INSTANCE, This);
      }
      
      This.$assignMove(CGF.Builder.CreateElementBitCast(new Address(This), CGF.Int8Ty));
      assert (Adjustment.isPositive());
      return CGF.Builder.CreateConstByteGEP(new Address(This), new CharUnits(Adjustment));
    }
    
    GD.$assignMove(GD.getCanonicalDecl());
    /*const*/ CXXMethodDecl /*P*/ MD = cast_CXXMethodDecl(GD.getDecl());
    
    GlobalDecl LookupGD = new GlobalDecl(GD);
    {
      /*const*/ CXXDestructorDecl /*P*/ DD = dyn_cast_CXXDestructorDecl(MD);
      if ((DD != null)) {
        // Complete dtors take a pointer to the complete object,
        // thus don't need adjustment.
        if (GD.getDtorType() == CXXDtorType.Dtor_Complete) {
          return new Address(JD$Move.INSTANCE, This);
        }
        
        // There's only Dtor_Deleting in vftable but it shares the this adjustment
        // with the base one, so look up the deleting one instead.
        LookupGD.$assignMove(new GlobalDecl(JD$CXXDestructorDecl$C$P_CXXDtorType.INSTANCE, DD, CXXDtorType.Dtor_Deleting));
      }
    }
    MicrosoftVTableContext.MethodVFTableLocation ML = new MicrosoftVTableContext.MethodVFTableLocation(CGM.getMicrosoftVTableContext().getMethodVFTableLocation(new GlobalDecl(LookupGD)));
    
    CharUnits StaticOffset = new CharUnits(ML.VFPtrOffset);
    
    // Base destructors expect 'this' to point to the beginning of the base
    // subobject, not the first vfptr that happens to contain the virtual dtor.
    // However, we still need to apply the virtual base adjustment.
    if (isa_CXXDestructorDecl(MD) && GD.getDtorType() == CXXDtorType.Dtor_Base) {
      StaticOffset.$assignMove(CharUnits.Zero());
    }
    
    Address Result = new Address(This);
    if ((ML.VBase != null)) {
      Result.$assignMove(CGF.Builder.CreateElementBitCast(new Address(Result), CGF.Int8Ty));
      
      /*const*/ CXXRecordDecl /*P*/ Derived = MD.getParent$Const();
      /*const*/ CXXRecordDecl /*P*/ VBase = ML.VBase;
      Value /*P*/ VBaseOffset = GetVirtualBaseClassOffset(CGF, new Address(Result), Derived, VBase);
      Value /*P*/ VBasePtr = CGF.Builder.CreateInBoundsGEP(Result.getPointer(), new ArrayRef<Value /*P*/ >(VBaseOffset, true));
      CharUnits VBaseAlign = CGF.CGM.getVBaseAlignment(Result.getAlignment(), Derived, VBase);
      Result.$assignMove(new Address(VBasePtr, new CharUnits(VBaseAlign)));
    }
    if (!StaticOffset.isZero()) {
      assert (StaticOffset.isPositive());
      Result.$assignMove(CGF.Builder.CreateElementBitCast(new Address(Result), CGF.Int8Ty));
      if ((ML.VBase != null)) {
        // Non-virtual adjustment might result in a pointer outside the allocated
        // object, e.g. if the final overrider class is laid out after the virtual
        // base that declares a method in the most derived class.
        // FIXME: Update the code that emits this adjustment in thunks prologues.
        Result.$assignMove(CGF.Builder.CreateConstByteGEP(new Address(Result), new CharUnits(StaticOffset)));
      } else {
        Result.$assignMove(CGF.Builder.CreateConstInBoundsByteGEP(new Address(Result), new CharUnits(StaticOffset)));
      }
    }
    return Result;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::addImplicitStructorParams">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 1366,
   FQN="(anonymous namespace)::MicrosoftCXXABI::addImplicitStructorParams", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI25addImplicitStructorParamsERN5clang7CodeGen15CodeGenFunctionERNS1_8QualTypeERNS2_15FunctionArgListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI25addImplicitStructorParamsERN5clang7CodeGen15CodeGenFunctionERNS1_8QualTypeERNS2_15FunctionArgListE")
  //</editor-fold>
  @Override public void addImplicitStructorParams(final CodeGenFunction /*&*/ CGF, 
                           final QualType /*&*/ ResTy, 
                           final FunctionArgList /*&*/ Params)/* override*/ {
    final ASTContext /*&*/ Context = getContext();
    /*const*/ CXXMethodDecl /*P*/ MD = cast_CXXMethodDecl(CGF.CurGD.getDecl());
    assert (isa_CXXConstructorDecl(MD) || isa_CXXDestructorDecl(MD));
    if (isa_CXXConstructorDecl(MD) && (MD.getParent$Const().getNumVBases() != 0)) {
      ImplicitParamDecl /*P*/ IsMostDerived = ImplicitParamDecl.Create(Context, (DeclContext /*P*/ )null, 
          CGF.CurGD.getDecl().getLocation(), 
          $AddrOf(Context.Idents.get(new StringRef(/*KEEP_STR*/"is_most_derived"))), 
          Context.IntTy.$QualType());
      // The 'most_derived' parameter goes second if the ctor is variadic and last
      // if it's not.  Dtors can't be variadic.
      /*const*/ FunctionProtoType /*P*/ FPT = MD.getType().$arrow().castAs(FunctionProtoType.class);
      if (FPT.isVariadic()) {
        Params.insert/*insert_iterator$T$value_T$RR*/(Params.begin().$add(1), IsMostDerived);
      } else {
        Params.push_back(IsMostDerived);
      }
      getStructorImplicitParamDecl(CGF).$set(IsMostDerived);
    } else if (MicrosoftCXXABIStatics.isDeletingDtor(new GlobalDecl(CGF.CurGD))) {
      ImplicitParamDecl /*P*/ ShouldDelete = ImplicitParamDecl.Create(Context, (DeclContext /*P*/ )null, 
          CGF.CurGD.getDecl().getLocation(), 
          $AddrOf(Context.Idents.get(new StringRef(/*KEEP_STR*/"should_call_delete"))), 
          Context.IntTy.$QualType());
      Params.push_back(ShouldDelete);
      getStructorImplicitParamDecl(CGF).$set(ShouldDelete);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::adjustThisParameterInVirtualFunctionPrologue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 1397,
   FQN="(anonymous namespace)::MicrosoftCXXABI::adjustThisParameterInVirtualFunctionPrologue", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI44adjustThisParameterInVirtualFunctionPrologueERN5clang7CodeGen15CodeGenFunctionENS1_10GlobalDeclEPN4llvm5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI44adjustThisParameterInVirtualFunctionPrologueERN5clang7CodeGen15CodeGenFunctionENS1_10GlobalDeclEPN4llvm5ValueE")
  //</editor-fold>
  @Override public Value /*P*/ adjustThisParameterInVirtualFunctionPrologue(final CodeGenFunction /*&*/ CGF, GlobalDecl GD, Value /*P*/ This)/* override*/ {
    // In this ABI, every virtual function takes a pointer to one of the
    // subobjects that first defines it as the 'this' parameter, rather than a
    // pointer to the final overrider subobject. Thus, we need to adjust it back
    // to the final overrider subobject before use.
    // See comments in the MicrosoftVFTableContext implementation for the details.
    CharUnits Adjustment = getVirtualFunctionPrologueThisAdjustment(new GlobalDecl(GD));
    if (Adjustment.isZero()) {
      return This;
    }
    
    /*uint*/int AS = cast_PointerType(This.getType()).getAddressSpace();
    org.llvm.ir.Type /*P*/ charPtrTy = CGF.Int8Ty.getPointerTo(AS);
    org.llvm.ir.Type /*P*/ thisTy = This.getType();
    
    This = CGF.Builder.CreateBitCast(This, charPtrTy);
    assert (Adjustment.isPositive());
    This = CGF.Builder.CreateConstInBoundsGEP1_32(CGF.Int8Ty, This, 
        $long2uint(-Adjustment.getQuantity()));
    return CGF.Builder.CreateBitCast(This, thisTy);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::EmitInstanceFunctionProlog">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 1419,
   FQN="(anonymous namespace)::MicrosoftCXXABI::EmitInstanceFunctionProlog", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI26EmitInstanceFunctionPrologERN5clang7CodeGen15CodeGenFunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI26EmitInstanceFunctionPrologERN5clang7CodeGen15CodeGenFunctionE")
  //</editor-fold>
  @Override public void EmitInstanceFunctionProlog(final CodeGenFunction /*&*/ CGF)/* override*/ {
    EmitThisParam(CGF);
    
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
    } else if (hasMostDerivedReturn(new GlobalDecl(CGF.CurGD))) {
      CGF.Builder.CreateStore(CGF.EmitCastToVoidPtr(getThisValue(CGF)), 
          new Address(CGF.ReturnValue));
    }
    
    /*const*/ CXXMethodDecl /*P*/ MD = cast_CXXMethodDecl(CGF.CurGD.getDecl());
    if (isa_CXXConstructorDecl(MD) && (MD.getParent$Const().getNumVBases() != 0)) {
      assert ((getStructorImplicitParamDecl(CGF) != null)) : "no implicit parameter for a constructor with virtual bases?";
      getStructorImplicitParamValue(CGF)
         .$set(CGF.Builder.CreateLoad(CGF.GetAddrOfLocalVar(getStructorImplicitParamDecl(CGF).$deref()), 
          $("is_most_derived")));
    }
    if (MicrosoftCXXABIStatics.isDeletingDtor(new GlobalDecl(CGF.CurGD))) {
      assert ((getStructorImplicitParamDecl(CGF) != null)) : "no implicit parameter for a deleting destructor?";
      getStructorImplicitParamValue(CGF)
         .$set(CGF.Builder.CreateLoad(CGF.GetAddrOfLocalVar(getStructorImplicitParamDecl(CGF).$deref()), 
          $("should_call_delete")));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::addImplicitConstructorArgs">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 1456,
   FQN="(anonymous namespace)::MicrosoftCXXABI::addImplicitConstructorArgs", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI26addImplicitConstructorArgsERN5clang7CodeGen15CodeGenFunctionEPKNS1_18CXXConstructorDeclENS1_11CXXCtorTypeEbbRNS2_11CallArgListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI26addImplicitConstructorArgsERN5clang7CodeGen15CodeGenFunctionEPKNS1_18CXXConstructorDeclENS1_11CXXCtorTypeEbbRNS2_11CallArgListE")
  //</editor-fold>
  @Override public /*uint*/int addImplicitConstructorArgs(final CodeGenFunction /*&*/ CGF, /*const*/ CXXConstructorDecl /*P*/ D, CXXCtorType Type, 
                            boolean ForVirtualBase, boolean Delegating, final CallArgList /*&*/ Args)/* override*/ {
    assert (Type == CXXCtorType.Ctor_Complete || Type == CXXCtorType.Ctor_Base);
    
    // Check if we need a 'most_derived' parameter.
    if (!(D.getParent$Const().getNumVBases() != 0)) {
      return 0;
    }
    
    // Add the 'most_derived' argument second if we are variadic or last if not.
    /*const*/ FunctionProtoType /*P*/ FPT = D.getType().$arrow().castAs(FunctionProtoType.class);
    Value /*P*/ MostDerivedArg;
    if (Delegating) {
      MostDerivedArg = getStructorImplicitParamValue(CGF).$deref();
    } else {
      MostDerivedArg = ConstantInt.get(CGM.Int32Ty, ((Type == CXXCtorType.Ctor_Complete) ? 1 : 0));
    }
    RValue RV = RValue.get(MostDerivedArg);
    if (FPT.isVariadic()) {
      Args.insert/*insert_iterator$T$value_T$RR*/(Args.begin().$add(1), 
          new CallArg(new RValue(RV), getContext().IntTy.$QualType(), /*needscopy=*/ false));
    } else {
      Args.add(new RValue(RV), getContext().IntTy.$QualType());
    }
    
    return 1; // Added one arg.
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::EmitDestructorCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 1483,
   FQN="(anonymous namespace)::MicrosoftCXXABI::EmitDestructorCall", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI18EmitDestructorCallERN5clang7CodeGen15CodeGenFunctionEPKNS1_17CXXDestructorDeclENS1_11CXXDtorTypeEbbNS2_7AddressE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI18EmitDestructorCallERN5clang7CodeGen15CodeGenFunctionEPKNS1_17CXXDestructorDeclENS1_11CXXDtorTypeEbbNS2_7AddressE")
  //</editor-fold>
  @Override public void EmitDestructorCall(final CodeGenFunction /*&*/ CGF, 
                    /*const*/ CXXDestructorDecl /*P*/ DD, 
                    CXXDtorType Type, boolean ForVirtualBase, 
                    boolean Delegating, Address This)/* override*/ {
    Value /*P*/ Callee = CGM.getAddrOfCXXStructor(DD, CodeGenStatics.getFromDtorType(Type));
    if (DD.isVirtual()) {
      assert (Type != CXXDtorType.Dtor_Deleting) : "The deleting destructor should only be called via a virtual call";
      This.$assignMove(adjustThisArgumentForVirtualFunctionCall(CGF, new GlobalDecl(JD$CXXDestructorDecl$C$P_CXXDtorType.INSTANCE, DD, Type), 
              new Address(This), false));
    }
    
    CGF.EmitCXXDestructorCall(DD, Callee, This.getPointer(), 
        /*ImplicitParam=*/ (Value /*P*/ )null, 
        /*ImplicitParamTy=*/ new QualType(), (/*const*/ CallExpr /*P*/ )null, 
        CodeGenStatics.getFromDtorType(Type));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::emitVTableTypeMetadata">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 1502,
   FQN="(anonymous namespace)::MicrosoftCXXABI::emitVTableTypeMetadata", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI22emitVTableTypeMetadataEPN5clang8VPtrInfoEPKNS1_13CXXRecordDeclEPN4llvm14GlobalVariableE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI22emitVTableTypeMetadataEPN5clang8VPtrInfoEPKNS1_13CXXRecordDeclEPN4llvm14GlobalVariableE")
  //</editor-fold>
  public void emitVTableTypeMetadata(VPtrInfo /*P*/ Info, 
                        /*const*/ CXXRecordDecl /*P*/ RD, 
                        GlobalVariable /*P*/ VTable) {
    if (!CGM.getCodeGenOpts().PrepareForLTO) {
      return;
    }
    
    // The location of the first virtual function pointer in the virtual table,
    // aka the "address point" on Itanium. This is at offset 0 if RTTI is
    // disabled, or sizeof(void*) if RTTI is enabled.
    CharUnits AddressPoint = getContext().getLangOpts().RTTIData ? getContext().toCharUnitsFromBits(getContext().getTargetInfo().getPointerWidth(0)) : CharUnits.Zero();
    if (Info.PathToBaseWithVPtr.empty()) {
      CGM.AddVTableTypeMetadata(VTable, new CharUnits(AddressPoint), RD);
      return;
    }
    
    // Add a bitset entry for the least derived base belonging to this vftable.
    CGM.AddVTableTypeMetadata(VTable, new CharUnits(AddressPoint), 
        Info.PathToBaseWithVPtr.back());
    
    // Add a bitset entry for each derived class that is laid out at the same
    // offset as the least derived base.
    for (/*uint*/int I = Info.PathToBaseWithVPtr.size() - 1; I != 0; --I) {
      /*const*/ CXXRecordDecl /*P*/ DerivedRD = Info.PathToBaseWithVPtr.$at(I - 1);
      /*const*/ CXXRecordDecl /*P*/ BaseRD = Info.PathToBaseWithVPtr.$at(I);
      
      final /*const*/ ASTRecordLayout /*&*/ Layout = getContext().getASTRecordLayout(DerivedRD);
      CharUnits Offset/*J*/= new CharUnits();
      DenseMapIterator</*const*/ CXXRecordDecl /*P*/ , ASTRecordLayout.VBaseInfo> VBI = Layout.getVBaseOffsetsMap().find$Const(BaseRD);
      if (VBI.$eq(Layout.getVBaseOffsetsMap().end$Const())) {
        Offset.$assignMove(Layout.getBaseClassOffset(BaseRD));
      } else {
        Offset.$assign(VBI.$arrow().second.VBaseOffset);
      }
      if (!Offset.isZero()) {
        return;
      }
      CGM.AddVTableTypeMetadata(VTable, new CharUnits(AddressPoint), DerivedRD);
    }
    
    // Finally do the same for the most derived class.
    if (Info.FullOffsetInMDC.isZero()) {
      CGM.AddVTableTypeMetadata(VTable, new CharUnits(AddressPoint), RD);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::emitVTableDefinitions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 1550,
   FQN="(anonymous namespace)::MicrosoftCXXABI::emitVTableDefinitions", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI21emitVTableDefinitionsERN5clang7CodeGen14CodeGenVTablesEPKNS1_13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI21emitVTableDefinitionsERN5clang7CodeGen14CodeGenVTablesEPKNS1_13CXXRecordDeclE")
  //</editor-fold>
  @Override public void emitVTableDefinitions(final CodeGenVTables /*&*/ CGVT, 
                       /*const*/ CXXRecordDecl /*P*/ RD)/* override*/ {
    final MicrosoftVTableContext /*&*/ VFTContext = CGM.getMicrosoftVTableContext();
    final /*const*/SmallVector<VPtrInfo /*P*/ > /*&*/ VFPtrs = VFTContext.getVFPtrOffsets(RD);
    
    for (VPtrInfo /*P*/ Info : VFPtrs) {
      GlobalVariable /*P*/ VTable = getAddrOfVTable(RD, new CharUnits(Info.FullOffsetInMDC));
      if (VTable.hasInitializer()) {
        continue;
      }
      
      final /*const*/ VTableLayout /*&*/ VTLayout = VFTContext.getVFTableLayout(RD, new CharUnits(Info.FullOffsetInMDC));
      
      Constant /*P*/ RTTI = null;
      if (any_of(VTLayout.vtable_components(), 
          /*[]*/ (final /*const*/ VTableComponent /*&*/ VTC) -> {
                return VTC.isRTTIKind();
              })) {
        RTTI = getMSCompleteObjectLocator(RD, Info);
      }
      
      Constant /*P*/ Init = CGVT.CreateVTableInitializer(RD, VTLayout.vtable_component_begin(), 
          $ulong2uint(VTLayout.getNumVTableComponents()), VTLayout.vtable_thunk_begin(), 
          $ulong2uint(VTLayout.getNumVTableThunks()), RTTI);
      
      VTable.setInitializer(Init);
      
      emitVTableTypeMetadata(Info, RD, VTable);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::isVirtualOffsetNeededForVTableField">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 1579,
   FQN="(anonymous namespace)::MicrosoftCXXABI::isVirtualOffsetNeededForVTableField", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI35isVirtualOffsetNeededForVTableFieldERN5clang7CodeGen15CodeGenFunctionENS3_4VPtrE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI35isVirtualOffsetNeededForVTableFieldERN5clang7CodeGen15CodeGenFunctionENS3_4VPtrE")
  //</editor-fold>
  @Override public boolean isVirtualOffsetNeededForVTableField(final CodeGenFunction /*&*/ CGF, CodeGenFunction.VPtr Vptr)/* override*/ {
    return Vptr.NearestVBase != null;
  }

  
  /// Don't initialize vptrs if dynamic class
  /// is marked with with the 'novtable' attribute.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::doStructorsInitializeVPtrs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 268,
   FQN="(anonymous namespace)::MicrosoftCXXABI::doStructorsInitializeVPtrs", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI26doStructorsInitializeVPtrsEPKN5clang13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI26doStructorsInitializeVPtrsEPKN5clang13CXXRecordDeclE")
  //</editor-fold>
  @Override public boolean doStructorsInitializeVPtrs(/*const*/ CXXRecordDecl /*P*/ VTableClass)/* override*/ {
    return !VTableClass.hasAttr(MSNoVTableAttr.class);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::getVTableAddressPoint">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 1602,
   FQN="(anonymous namespace)::MicrosoftCXXABI::getVTableAddressPoint", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI21getVTableAddressPointEN5clang13BaseSubobjectEPKNS1_13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI21getVTableAddressPointEN5clang13BaseSubobjectEPKNS1_13CXXRecordDeclE")
  //</editor-fold>
  @Override public Constant /*P*/ getVTableAddressPoint(BaseSubobject Base, 
                       /*const*/ CXXRecordDecl /*P*/ VTableClass)/* override*/ {
    /*J:(void)*/getAddrOfVTable(VTableClass, Base.getBaseOffset());
    std.pairPtrType</*const*/ CXXRecordDecl /*P*/ , CharUnits> ID/*J*/= new std.pairPtrType</*const*/ CXXRecordDecl /*P*/ , CharUnits>(JD$T$RR_T1$RR.INSTANCE, VTableClass, new CharUnits(JD$Move.INSTANCE, /*Fwd*/Base.getBaseOffset()));
    return VFTablesMap.$at_T1$C$R(ID);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::getVTableAddressPointInStructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 1584,
   FQN="(anonymous namespace)::MicrosoftCXXABI::getVTableAddressPointInStructor", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI31getVTableAddressPointInStructorERN5clang7CodeGen15CodeGenFunctionEPKNS1_13CXXRecordDeclENS1_13BaseSubobjectES7_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI31getVTableAddressPointInStructorERN5clang7CodeGen15CodeGenFunctionEPKNS1_13CXXRecordDeclENS1_13BaseSubobjectES7_")
  //</editor-fold>
  @Override public Value /*P*/ getVTableAddressPointInStructor(final CodeGenFunction /*&*/ CGF, /*const*/ CXXRecordDecl /*P*/ VTableClass, BaseSubobject Base, 
                                 /*const*/ CXXRecordDecl /*P*/ NearestVBase)/* override*/ {
    Constant /*P*/ VTableAddressPoint = getVTableAddressPoint(new BaseSubobject(Base), VTableClass);
    if (!(VTableAddressPoint != null)) {
      assert ((Base.getBase().getNumVBases() != 0) && !getContext().getASTRecordLayout(Base.getBase()).hasOwnVFPtr());
    }
    return VTableAddressPoint;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::getVTableAddressPointForConstExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 1610,
   FQN="(anonymous namespace)::MicrosoftCXXABI::getVTableAddressPointForConstExpr", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI33getVTableAddressPointForConstExprEN5clang13BaseSubobjectEPKNS1_13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI33getVTableAddressPointForConstExprEN5clang13BaseSubobjectEPKNS1_13CXXRecordDeclE")
  //</editor-fold>
  @Override public Constant /*P*/ getVTableAddressPointForConstExpr(BaseSubobject Base, /*const*/ CXXRecordDecl /*P*/ VTableClass)/* override*/ {
    Constant /*P*/ VFTable = getVTableAddressPoint(new BaseSubobject(Base), VTableClass);
    assert ((VFTable != null)) : "Couldn't find a vftable for the given base?";
    return VFTable;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::getAddrOfVTable">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*make_pair*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 1617,
   FQN="(anonymous namespace)::MicrosoftCXXABI::getAddrOfVTable", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI15getAddrOfVTableEPKN5clang13CXXRecordDeclENS1_9CharUnitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI15getAddrOfVTableEPKN5clang13CXXRecordDeclENS1_9CharUnitsE")
  //</editor-fold>
  @Override public GlobalVariable /*P*/ getAddrOfVTable(/*const*/ CXXRecordDecl /*P*/ RD, 
                 CharUnits VPtrOffset)/* override*/ {
    // getAddrOfVTable may return 0 if asked to get an address of a vtable which
    // shouldn't be used in the given record type. We want to cache this result in
    // VFTablesMap, thus a simple zero check is not sufficient.
    std.pair</*const*/ CXXRecordDecl /*P*/ , CharUnits> ID/*J*/= new std.pairPtrType</*const*/ CXXRecordDecl /*P*/ , CharUnits>(JD$T$RR_T1$RR.INSTANCE, RD, VPtrOffset);
    boolean Inserted;
    final pairTypeBool<DenseMapIterator<pair<CXXRecordDecl, CharUnits>, GlobalVariable>> $pair = VTablesMap.insert_pair$KeyT$ValueT(std.make_pair_T_nullptr_t(ID, (GlobalVariable /*P*/)null));
    final DenseMapIterator<std.pair</*const*/ CXXRecordDecl /*P*/ , CharUnits>, GlobalVariable /*P*/> I = $pair.first;
    Inserted = $pair.second;
    if (!Inserted) {
      return I.$arrow().second;
    }
    
    final type$ref<GlobalVariable /*P*/ /*&*/> VTable = //I.$arrow().second;
      new type$ref<GlobalVariable>() {                   
      @Override
      public GlobalVariable $deref() {
        return I.$arrow().second;
      }
      // JAVA: TODO: MAKE SURE IT WORKS!
      @Override
      public GlobalVariable $set(GlobalVariable value) {
        I.$arrow().second = value;
        return I.$arrow().second;
      }
    };
    
    final MicrosoftVTableContext /*&*/ VTContext = CGM.getMicrosoftVTableContext();
    final /*const*/SmallVector<VPtrInfo /*P*/ > /*&*/ VFPtrs = VTContext.getVFPtrOffsets(RD);
    if (DeferredVFTables.insert(RD).second) {
      StringSet/*<MallocAllocator>*/ ObservedMangledNames = null;
      try {
        // We haven't processed this record type before.
        // Queue up this vtable for possible deferred emission.
        CGM.addDeferredVTable(RD);
        // Create all the vftables at once in order to make sure each vftable has
        // a unique mangled name.
        ObservedMangledNames/*J*/= new StringSet/*<MallocAllocator>*/();
        for (/*size_t*/int J = 0, F = VFPtrs.size(); J != F; ++J) {
          SmallString/*<256>*/ Name/*J*/= new SmallString/*<256>*/(256);
          MicrosoftCXXABIStatics.mangleVFTableName(getMangleContext(), RD, VFPtrs.$at$Const(J), Name);
          if (!ObservedMangledNames.insert(Name.str()).second) {
            throw new llvm_unreachable("Already saw this mangling before?");
          }
        }
      } finally {
        if (ObservedMangledNames != null) { ObservedMangledNames.$destroy(); }
      }
    }
    
    type$ptr<VPtrInfo /*P*/ /*const*/ /*P*/> VFPtrI = $tryClone(std.find_if(VFPtrs.begin$Const(), VFPtrs.end$Const(), /*[&, &VPtrOffset]*/ (VPtrInfo /*P*/ VPI) -> {
              return VPI.FullOffsetInMDC.$eq(VPtrOffset);
            }));
    if ($eq_ptr(VFPtrI, VFPtrs.end$Const())) {
      VFTablesMap.$set(ID, null);
      return null;
    }
    VPtrInfo /*P*/ VFPtr = VFPtrI.$star();
    
    SmallString/*<256>*/ VFTableName/*J*/= new SmallString/*<256>*/(256);
    MicrosoftCXXABIStatics.mangleVFTableName(getMangleContext(), RD, VFPtr, VFTableName);
    
    // Classes marked __declspec(dllimport) need vftables generated on the
    // import-side in order to support features like constexpr.  No other
    // translation unit relies on the emission of the local vftable, translation
    // units are expected to generate them as needed.
    //
    // Because of this unique behavior, we maintain this logic here instead of
    // getVTableLinkage.
    GlobalValue.LinkageTypes VFTableLinkage = RD.hasAttr(DLLImportAttr.class) ? GlobalValue.LinkageTypes.LinkOnceODRLinkage : CGM.getVTableLinkage(RD);
    boolean VFTableComesFromAnotherTU = GlobalValue.isAvailableExternallyLinkage(VFTableLinkage)
       || GlobalValue.isExternalLinkage(VFTableLinkage);
    boolean VTableAliasIsRequred = !VFTableComesFromAnotherTU && getContext().getLangOpts().RTTIData;
    {
      
      GlobalValue /*P*/ VFTable = CGM.getModule().getNamedGlobal(VFTableName.$StringRef());
      if ((VFTable != null)) {
        VFTablesMap.$set(ID, VFTable);
        VTable.$set(VTableAliasIsRequred ? cast_GlobalVariable(cast_GlobalAlias(VFTable).getBaseObject()) : cast_GlobalVariable(VFTable));
        return VTable.$deref();
      }
    }
    
    long/*uint64_t*/ NumVTableSlots = VTContext.getVFTableLayout(RD, new CharUnits(VFPtr.FullOffsetInMDC)).
        getNumVTableComponents();
    GlobalValue.LinkageTypes VTableLinkage = VTableAliasIsRequred ? GlobalValue.LinkageTypes.PrivateLinkage : VFTableLinkage;
    
    StringRef VTableName = VTableAliasIsRequred ? new StringRef() : VFTableName.str();
    
    org.llvm.ir.ArrayType /*P*/ VTableType = org.llvm.ir.ArrayType.get(CGM.Unnamed_field9.Int8PtrTy, NumVTableSlots);
    
    // Create a backing variable for the contents of VTable.  The VTable may
    // or may not include space for a pointer to RTTI data.
    GlobalValue /*P*/ VFTable;
    VTable.$set(/*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
        return new GlobalVariable(CGM.getModule(), VTableType, 
        /*isConstant=*/ true, VTableLinkage, 
                /*Initializer=*/ (Constant /*P*/ )null, new Twine(VTableName));
     }));
    VTable.$deref().setUnnamedAddr(GlobalValue.UnnamedAddr.Global);
    
    Comdat /*P*/ C = null;
    if (!VFTableComesFromAnotherTU
       && (GlobalValue.isWeakForLinker(VFTableLinkage)
       || (GlobalValue.isLocalLinkage(VFTableLinkage)
       && VTableAliasIsRequred))) {
      C = CGM.getModule().getOrInsertComdat(VFTableName.str());
    }
    
    // Only insert a pointer into the VFTable for RTTI data if we are not
    // importing it.  We never reference the RTTI data directly so there is no
    // need to make room for it.
    if (VTableAliasIsRequred) {
      Value /*P*/ GEPIndices[/*2*/] = new Value /*P*/  [/*2*/] {
        ConstantInt.get(CGM.IntTy, $int2ulong(0)), 
        ConstantInt.get(CGM.IntTy, $int2ulong(1))};
      // Create a GEP which points just after the first entry in the VFTable,
      // this should be the location of the first virtual method.
      Constant /*P*/ VTableGEP = ConstantExpr.getInBoundsGetElementPtr_Type$P_Constant$P_ArrayRef$Value$P(VTable.$deref().getValueType(), VTable.$deref(), new ArrayRef<Value /*P*/ >(GEPIndices, true));
      if (GlobalValue.isWeakForLinker(VFTableLinkage)) {
        VFTableLinkage = GlobalValue.LinkageTypes.ExternalLinkage;
        if ((C != null)) {
          C.setSelectionKind(Comdat.SelectionKind.Largest);
        }
      }
      VFTable = GlobalAlias.create(CGM.Unnamed_field9.Int8PtrTy, 
          /*AddressSpace=*/ 0, VFTableLinkage, 
          new Twine(VFTableName.str()), VTableGEP, 
          $AddrOf(CGM.getModule()));
      VFTable.setUnnamedAddr(GlobalValue.UnnamedAddr.Global);
    } else {
      // We don't need a GlobalAlias to be a symbol for the VTable if we won't
      // be referencing any RTTI data.
      // The GlobalVariable will end up being an appropriate definition of the
      // VFTable.
      VFTable = VTable.$deref();
    }
    if ((C != null)) {
      VTable.$deref().setComdat(C);
    }
    if (RD.hasAttr(DLLExportAttr.class)) {
      VFTable.setDLLStorageClass(GlobalValue.DLLStorageClassTypes.DLLExportStorageClass);
    }
    
    VFTablesMap.$set(ID, VFTable);
    return VTable.$deref();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::getVirtualFunctionPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 1798,
   FQN="(anonymous namespace)::MicrosoftCXXABI::getVirtualFunctionPointer", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI25getVirtualFunctionPointerERN5clang7CodeGen15CodeGenFunctionENS1_10GlobalDeclENS2_7AddressEPN4llvm4TypeENS1_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI25getVirtualFunctionPointerERN5clang7CodeGen15CodeGenFunctionENS1_10GlobalDeclENS2_7AddressEPN4llvm4TypeENS1_14SourceLocationE")
  //</editor-fold>
  @Override public Value /*P*/ getVirtualFunctionPointer(final CodeGenFunction /*&*/ CGF, 
                           GlobalDecl GD, 
                           Address This, 
                           org.llvm.ir.Type /*P*/ Ty, 
                           SourceLocation Loc)/* override*/ {
    GD.$assignMove(GD.getCanonicalDecl());
    final CGBuilderTy /*&*/ Builder = CGF.Builder;
    
    Ty = Ty.getPointerTo().getPointerTo();
    Address VPtr = adjustThisArgumentForVirtualFunctionCall(CGF, new GlobalDecl(GD), new Address(This), true);
    
    /*const*/ CXXMethodDecl /*P*/ MethodDecl = cast_CXXMethodDecl(GD.getDecl());
    Value /*P*/ VTable = CGF.GetVTablePtr(new Address(VPtr), Ty, MethodDecl.getParent$Const());
    
    MicrosoftVTableContext.MethodVFTableLocation ML = new MicrosoftVTableContext.MethodVFTableLocation(CGM.getMicrosoftVTableContext().getMethodVFTableLocation(new GlobalDecl(GD)));
    if (CGF.ShouldEmitVTableTypeCheckedLoad(MethodDecl.getParent$Const())) {
      return CGF.EmitVTableTypeCheckedLoad(MicrosoftCXXABIStatics.getClassAtVTableLocation(getContext(), new GlobalDecl(GD), ML), VTable, 
          $div_ullong(ML.Index * CGM.getContext().getTargetInfo().getPointerWidth(0), $int2ullong(8)));
    } else {
      if (CGM.getCodeGenOpts().PrepareForLTO) {
        CGF.EmitTypeMetadataCodeForVCall(MicrosoftCXXABIStatics.getClassAtVTableLocation(getContext(), new GlobalDecl(GD), ML), VTable, new SourceLocation(Loc));
      }
      
      Value /*P*/ VFuncPtr = Builder.CreateConstInBoundsGEP1_64(VTable, ML.Index, new Twine(/*KEEP_STR*/"vfn"));
      return Builder.CreateAlignedLoad(VFuncPtr, CGF.getPointerAlign());
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::EmitVirtualDestructorCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 1831,
   FQN="(anonymous namespace)::MicrosoftCXXABI::EmitVirtualDestructorCall", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI25EmitVirtualDestructorCallERN5clang7CodeGen15CodeGenFunctionEPKNS1_17CXXDestructorDeclENS1_11CXXDtorTypeENS2_7AddressEPKNS1_17CXXMemberCallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI25EmitVirtualDestructorCallERN5clang7CodeGen15CodeGenFunctionEPKNS1_17CXXDestructorDeclENS1_11CXXDtorTypeENS2_7AddressEPKNS1_17CXXMemberCallExprE")
  //</editor-fold>
  @Override public Value /*P*/ EmitVirtualDestructorCall(final CodeGenFunction /*&*/ CGF, /*const*/ CXXDestructorDecl /*P*/ Dtor, CXXDtorType DtorType, 
                           Address This, /*const*/ CXXMemberCallExpr /*P*/ CE)/* override*/ {
    assert (CE == null || CE.arg_begin$Const().$eq(CE.arg_end$Const()));
    assert (DtorType == CXXDtorType.Dtor_Deleting || DtorType == CXXDtorType.Dtor_Complete);
    
    // We have only one destructor in the vftable but can get both behaviors
    // by passing an implicit int parameter.
    GlobalDecl GD/*J*/= new GlobalDecl(JD$CXXDestructorDecl$C$P_CXXDtorType.INSTANCE, Dtor, CXXDtorType.Dtor_Deleting);
    /*const*/ CGFunctionInfo /*P*/ FInfo = $AddrOf(CGM.getTypes().arrangeCXXStructorDeclaration(Dtor, StructorType.Deleting));
    org.llvm.ir.Type /*P*/ Ty = CGF.CGM.getTypes().GetFunctionType($Deref(FInfo));
    Value /*P*/ Callee = getVirtualFunctionPointer(CGF, new GlobalDecl(GD), new Address(This), Ty, (CE != null) ? CE.getLocStart() : new SourceLocation());
    
    final ASTContext /*&*/ Context = getContext();
    Value /*P*/ ImplicitParam = ConstantInt.get(IntegerType.getInt32Ty(CGF.getLLVMContext()), 
        ((DtorType == CXXDtorType.Dtor_Deleting) ? 1 : 0));
    
    This.$assignMove(adjustThisArgumentForVirtualFunctionCall(CGF, new GlobalDecl(GD), new Address(This), true));
    RValue RV = CGF.EmitCXXDestructorCall(Dtor, Callee, This.getPointer(), ImplicitParam, 
        Context.IntTy.$QualType(), CE, StructorType.Deleting);
    return RV.getScalarVal();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::adjustCallArgsForDestructorThunk">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 297,
   FQN="(anonymous namespace)::MicrosoftCXXABI::adjustCallArgsForDestructorThunk", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI32adjustCallArgsForDestructorThunkERN5clang7CodeGen15CodeGenFunctionENS1_10GlobalDeclERNS2_11CallArgListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI32adjustCallArgsForDestructorThunkERN5clang7CodeGen15CodeGenFunctionENS1_10GlobalDeclERNS2_11CallArgListE")
  //</editor-fold>
  @Override public void adjustCallArgsForDestructorThunk(final CodeGenFunction /*&*/ CGF, GlobalDecl GD, 
                                  final CallArgList /*&*/ CallArgs)/* override*/ {
    assert (GD.getDtorType() == CXXDtorType.Dtor_Deleting) : "Only deleting destructor thunks are available in this ABI";
    CallArgs.add(RValue.get(getStructorImplicitParamValue(CGF).$deref()), 
        getContext().IntTy.$QualType());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::emitVirtualInheritanceTables">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 1956,
   FQN="(anonymous namespace)::MicrosoftCXXABI::emitVirtualInheritanceTables", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI28emitVirtualInheritanceTablesEPKN5clang13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI28emitVirtualInheritanceTablesEPKN5clang13CXXRecordDeclE")
  //</editor-fold>
  @Override public void emitVirtualInheritanceTables(/*const*/ CXXRecordDecl /*P*/ RD)/* override*/ {
    final /*const*/ VBTableGlobals /*&*/ VBGlobals = enumerateVBTables(RD);
    for (/*uint*/int I = 0, E = VBGlobals.VBTables.size(); I != E; ++I) {
      /*const*/ VPtrInfo /*P*/ VBT = ($Deref(VBGlobals.VBTables)).$at$Const(I);
      GlobalVariable /*P*/ GV = VBGlobals.Globals.$at$Const(I);
      if (GV.isDeclaration()) {
        emitVBTableDefinition($Deref(VBT), RD, GV);
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::getAddrOfVBTable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 1966,
   FQN="(anonymous namespace)::MicrosoftCXXABI::getAddrOfVBTable", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI16getAddrOfVBTableERKN5clang8VPtrInfoEPKNS1_13CXXRecordDeclEN4llvm11GlobalValue12LinkageTypesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI16getAddrOfVBTableERKN5clang8VPtrInfoEPKNS1_13CXXRecordDeclEN4llvm11GlobalValue12LinkageTypesE")
  //</editor-fold>
  public GlobalVariable /*P*/ getAddrOfVBTable(final /*const*/ VPtrInfo /*&*/ VBT, /*const*/ CXXRecordDecl /*P*/ RD, 
                  GlobalVariable.LinkageTypes Linkage) {
    raw_svector_ostream Out = null;
    try {
      SmallString/*<256>*/ OutName/*J*/= new SmallString/*<256>*/(256);
      Out/*J*/= new raw_svector_ostream(OutName);
      getMangleContext().mangleCXXVBTable(RD, new ArrayRef</*const*/ CXXRecordDecl /*P*/ >(VBT.MangledPath, true), Out);
      StringRef Name = OutName.str();
      
      org.llvm.ir.ArrayType /*P*/ VBTableType = org.llvm.ir.ArrayType.get(CGM.IntTy, $uint2ulong(1 + VBT.ReusingBase.getNumVBases()));
      assert (!(CGM.getModule().getNamedGlobal(new StringRef(Name)) != null)) : "vbtable with this name already exists: mangling bug?";
      GlobalVariable /*P*/ GV = CGM.CreateOrReplaceCXXRuntimeVariable(new StringRef(Name), VBTableType, Linkage);
      GV.setUnnamedAddr(GlobalValue.UnnamedAddr.Global);
      if (RD.hasAttr(DLLImportAttr.class)) {
        GV.setDLLStorageClass(GlobalValue.DLLStorageClassTypes.DLLImportStorageClass);
      } else if (RD.hasAttr(DLLExportAttr.class)) {
        GV.setDLLStorageClass(GlobalValue.DLLStorageClassTypes.DLLExportStorageClass);
      }
      if (!GV.hasExternalLinkage()) {
        emitVBTableDefinition(VBT, RD, GV);
      }
      
      return GV;
    } finally {
      if (Out != null) { Out.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::getAddrOfVirtualDisplacementMap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 311,
   FQN="(anonymous namespace)::MicrosoftCXXABI::getAddrOfVirtualDisplacementMap", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI31getAddrOfVirtualDisplacementMapEPKN5clang13CXXRecordDeclES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI31getAddrOfVirtualDisplacementMapEPKN5clang13CXXRecordDeclES4_")
  //</editor-fold>
  public GlobalVariable /*P*/ getAddrOfVirtualDisplacementMap(/*const*/ CXXRecordDecl /*P*/ SrcRD, 
                                 /*const*/ CXXRecordDecl /*P*/ DstRD) {
    raw_svector_ostream Out = null;
    try {
      SmallString/*<256>*/ OutName/*J*/= new SmallString/*<256>*/(256);
      Out/*J*/= new raw_svector_ostream(OutName);
      getMangleContext().mangleCXXVirtualDisplacementMap(SrcRD, DstRD, Out);
      StringRef MangledName = OutName.str();
      {
        
        GlobalVariable /*P*/ VDispMap = CGM.getModule().getNamedGlobal(new StringRef(MangledName));
        if ((VDispMap != null)) {
          return VDispMap;
        }
      }
      
      final MicrosoftVTableContext /*&*/ VTContext = CGM.getMicrosoftVTableContext();
      /*uint*/int NumEntries = 1 + SrcRD.getNumVBases();
      SmallVector<Constant /*P*/ > Map/*J*/= new SmallVector<Constant /*P*/ >(JD$UInt_T$C$R.INSTANCE, 4, NumEntries, 
          UndefValue.get(CGM.IntTy), (Constant /*P*/ )null);
      Map.$set(0, ConstantInt.get(CGM.IntTy, $int2ulong(0)));
      boolean AnyDifferent = false;
      for (final /*const*/ CXXBaseSpecifier /*&*/ I : SrcRD.vbases$Const()) {
        /*const*/ CXXRecordDecl /*P*/ VBase = I.getType().$arrow().getAsCXXRecordDecl();
        if (!DstRD.isVirtuallyDerivedFrom(VBase)) {
          continue;
        }
        
        /*uint*/int SrcVBIndex = VTContext.getVBTableIndex(SrcRD, VBase);
        /*uint*/int DstVBIndex = VTContext.getVBTableIndex(DstRD, VBase);
        Map.$set(SrcVBIndex, ConstantInt.get(CGM.IntTy, $uint2ulong(DstVBIndex * 4)));
        AnyDifferent |= SrcVBIndex != DstVBIndex;
      }
      // This map would be useless, don't use it.
      if (!AnyDifferent) {
        return null;
      }
      
      org.llvm.ir.ArrayType /*P*/ VDispMapTy = org.llvm.ir.ArrayType.get(CGM.IntTy, $uint2ulong(Map.size()));
      Constant /*P*/ Init = ConstantArray.get(VDispMapTy, new ArrayRef<Constant /*P*/ >(Map, true));
      GlobalValue.LinkageTypes Linkage = SrcRD.isExternallyVisible() && DstRD.isExternallyVisible() ? GlobalValue.LinkageTypes.LinkOnceODRLinkage : GlobalValue.LinkageTypes.InternalLinkage;
      GlobalVariable /*P*/ VDispMap = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
          return new GlobalVariable(CGM.getModule(), VDispMapTy, /*Constant=*/ true, Linkage, 
          /*Initializer=*/ Init, new Twine(MangledName));
       });
      return VDispMap;
    } finally {
      if (Out != null) { Out.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::emitVBTableDefinition">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 1994,
   FQN="(anonymous namespace)::MicrosoftCXXABI::emitVBTableDefinition", NM="_ZNK12_GLOBAL__N_115MicrosoftCXXABI21emitVBTableDefinitionERKN5clang8VPtrInfoEPKNS1_13CXXRecordDeclEPN4llvm14GlobalVariableE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZNK12_GLOBAL__N_115MicrosoftCXXABI21emitVBTableDefinitionERKN5clang8VPtrInfoEPKNS1_13CXXRecordDeclEPN4llvm14GlobalVariableE")
  //</editor-fold>
  public void emitVBTableDefinition(final /*const*/ VPtrInfo /*&*/ VBT, 
                       /*const*/ CXXRecordDecl /*P*/ RD, 
                       GlobalVariable /*P*/ GV) /*const*/ {
    /*const*/ CXXRecordDecl /*P*/ ReusingBase = VBT.ReusingBase;
    assert ((RD.getNumVBases() != 0) && (ReusingBase.getNumVBases() != 0)) : "should only emit vbtables for classes with vbtables";
    
    final /*const*/ ASTRecordLayout /*&*/ BaseLayout = getContext().getASTRecordLayout(VBT.BaseWithVPtr);
    final /*const*/ ASTRecordLayout /*&*/ DerivedLayout = getContext().getASTRecordLayout(RD);
    
    SmallVector<Constant /*P*/ > Offsets/*J*/= new SmallVector<Constant /*P*/ >(JD$UInt_T$C$R.INSTANCE, 4, 1 + ReusingBase.getNumVBases(), 
        (Constant /*P*/ /*const*/)null, (Constant /*P*/ )null);
    
    // The offset from ReusingBase's vbptr to itself always leads.
    CharUnits VBPtrOffset = BaseLayout.getVBPtrOffset();
    Offsets.$set(0, ConstantInt.get(CGM.IntTy, -VBPtrOffset.getQuantity()));
    
    final MicrosoftVTableContext /*&*/ Context = CGM.getMicrosoftVTableContext();
    for (final /*const*/ CXXBaseSpecifier /*&*/ I : ReusingBase.vbases$Const()) {
      /*const*/ CXXRecordDecl /*P*/ VBase = I.getType().$arrow().getAsCXXRecordDecl();
      CharUnits Offset = DerivedLayout.getVBaseClassOffset(VBase);
      assert (!Offset.isNegative());
      
      // Make it relative to the subobject vbptr.
      CharUnits CompleteVBPtrOffset = VBT.NonVirtualOffset.$add(VBPtrOffset);
      if ((VBT.getVBaseWithVPtr() != null)) {
        CompleteVBPtrOffset.$addassign(
            DerivedLayout.getVBaseClassOffset(VBT.getVBaseWithVPtr())
        );
      }
      Offset.$minusassign(CompleteVBPtrOffset);
      
      /*uint*/int VBIndex = Context.getVBTableIndex(ReusingBase, VBase);
      assert (Offsets.$at(VBIndex) == null) : "The same vbindex seen twice?";
      Offsets.$set(VBIndex, ConstantInt.get(CGM.IntTy, Offset.getQuantity()));
    }
    assert ($uint2ullong(Offsets.size()) == cast_ArrayType(cast_PointerType(GV.getType()).getElementType()).getNumElements());
    org.llvm.ir.ArrayType /*P*/ VBTableType = org.llvm.ir.ArrayType.get(CGM.IntTy, $uint2ulong(Offsets.size()));
    Constant /*P*/ Init = ConstantArray.get(VBTableType, new ArrayRef<Constant /*P*/ >(Offsets, true));
    GV.setInitializer(Init);
    if (RD.hasAttr(DLLImportAttr.class)) {
      GV.setLinkage(GlobalVariable.LinkageTypes.AvailableExternallyLinkage);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::setThunkLinkage">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 357,
   FQN="(anonymous namespace)::MicrosoftCXXABI::setThunkLinkage", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI15setThunkLinkageEPN4llvm8FunctionEbN5clang10GlobalDeclEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI15setThunkLinkageEPN4llvm8FunctionEbN5clang10GlobalDeclEb")
  //</editor-fold>
  @Override public void setThunkLinkage(Function /*P*/ Thunk, boolean ForVTable, 
                 GlobalDecl GD, boolean ReturnAdjustment)/* override*/ {
    // Never dllimport/dllexport thunks.
    Thunk.setDLLStorageClass(GlobalValue.DLLStorageClassTypes.DefaultStorageClass);
    
    GVALinkage Linkage = getContext().GetGVALinkageForFunction(cast_FunctionDecl(GD.getDecl()));
    if (Linkage == GVALinkage.GVA_Internal) {
      Thunk.setLinkage(GlobalValue.LinkageTypes.InternalLinkage);
    } else if (ReturnAdjustment) {
      Thunk.setLinkage(GlobalValue.LinkageTypes.WeakODRLinkage);
    } else {
      Thunk.setLinkage(GlobalValue.LinkageTypes.LinkOnceODRLinkage);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::performThisAdjustment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 2043,
   FQN="(anonymous namespace)::MicrosoftCXXABI::performThisAdjustment", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI21performThisAdjustmentERN5clang7CodeGen15CodeGenFunctionENS2_7AddressERKNS1_14ThisAdjustmentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI21performThisAdjustmentERN5clang7CodeGen15CodeGenFunctionENS2_7AddressERKNS1_14ThisAdjustmentE")
  //</editor-fold>
  @Override public Value /*P*/ performThisAdjustment(final CodeGenFunction /*&*/ CGF, 
                       Address This, 
                       final /*const*/ ThisAdjustment /*&*/ TA)/* override*/ {
    if (TA.isEmpty()) {
      return This.getPointer();
    }
    
    This.$assignMove(CGF.Builder.CreateElementBitCast(new Address(This), CGF.Int8Ty));
    
    Value /*P*/ V;
    if (TA.Virtual.isEmpty()) {
      V = This.getPointer();
    } else {
      assert (TA.Virtual.Microsoft.VtordispOffset < 0);
      // Adjust the this argument based on the vtordisp value.
      Address VtorDispPtr = CGF.Builder.CreateConstInBoundsByteGEP(new Address(This), 
          CharUnits.fromQuantity(TA.Virtual.Microsoft.VtordispOffset));
      VtorDispPtr.$assignMove(CGF.Builder.CreateElementBitCast(new Address(VtorDispPtr), CGF.Int32Ty));
      Value /*P*/ VtorDisp = CGF.Builder.CreateLoad(new Address(VtorDispPtr), $("vtordisp"));
      V = CGF.Builder.CreateGEP(This.getPointer(), 
          CGF.Builder.CreateNeg(VtorDisp));
      
      // Unfortunately, having applied the vtordisp means that we no
      // longer really have a known alignment for the vbptr step.
      // We'll assume the vbptr is pointer-aligned.
      if ((TA.Virtual.Microsoft.VBPtrOffset != 0)) {
        // If the final overrider is defined in a virtual base other than the one
        // that holds the vfptr, we have to use a vtordispex thunk which looks up
        // the vbtable of the derived class.
        assert (TA.Virtual.Microsoft.VBPtrOffset > 0);
        assert (TA.Virtual.Microsoft.VBOffsetOffset >= 0);
        type$ptr<Value /*P*/ > VBPtr = create_type$null$ptr();
        Value /*P*/ VBaseOffset = GetVBaseOffsetFromVBPtr(CGF, new Address(V, CGF.getPointerAlign()), 
            -TA.Virtual.Microsoft.VBPtrOffset, 
            TA.Virtual.Microsoft.VBOffsetOffset, $AddrOf(VBPtr));
        V = CGF.Builder.CreateInBoundsGEP(VBPtr.$star(), new ArrayRef<Value /*P*/ >(VBaseOffset, true));
      }
    }
    if ((TA.NonVirtual != 0)) {
      // Non-virtual adjustment might result in a pointer outside the allocated
      // object, e.g. if the final overrider class is laid out after the virtual
      // base that declares a method in the most derived class.
      V = CGF.Builder.CreateConstGEP1_32(V, $long2uint(TA.NonVirtual));
    }
    
    // Don't need to bitcast back, the call CodeGen will handle this.
    return V;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::performReturnAdjustment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 2095,
   FQN="(anonymous namespace)::MicrosoftCXXABI::performReturnAdjustment", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI23performReturnAdjustmentERN5clang7CodeGen15CodeGenFunctionENS2_7AddressERKNS1_16ReturnAdjustmentE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI23performReturnAdjustmentERN5clang7CodeGen15CodeGenFunctionENS2_7AddressERKNS1_16ReturnAdjustmentE")
  //</editor-fold>
  @Override public Value /*P*/ performReturnAdjustment(final CodeGenFunction /*&*/ CGF, Address Ret, 
                         final /*const*/ ReturnAdjustment /*&*/ RA)/* override*/ {
    if (RA.isEmpty()) {
      return Ret.getPointer();
    }
    
    org.llvm.ir.PointerType /*P*/ OrigTy = Ret.getType();
    Ret.$assignMove(CGF.Builder.CreateElementBitCast(new Address(Ret), CGF.Int8Ty));
    
    Value /*P*/ V = Ret.getPointer();
    if ((RA.Virtual.Microsoft.VBIndex != 0)) {
      assert ($greater_uint(RA.Virtual.Microsoft.VBIndex, 0));
      int/*int32_t*/ IntSize = $long2int(CGF.getIntSize().getQuantity());
      type$ptr<Value /*P*/ > VBPtr = create_type$null$ptr();
      Value /*P*/ VBaseOffset = GetVBaseOffsetFromVBPtr(CGF, new Address(Ret), RA.Virtual.Microsoft.VBPtrOffset, 
          IntSize * RA.Virtual.Microsoft.VBIndex, $AddrOf(VBPtr));
      V = CGF.Builder.CreateInBoundsGEP(VBPtr.$star(), new ArrayRef<Value /*P*/ >(VBaseOffset, true));
    }
    if ((RA.NonVirtual != 0)) {
      V = CGF.Builder.CreateConstInBoundsGEP1_32(CGF.Int8Ty, V, $long2uint(RA.NonVirtual));
    }
    
    // Cast back to the original type.
    return CGF.Builder.CreateBitCast(V, OrigTy);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::EmitThreadLocalInitFuncs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 2202,
   FQN="(anonymous namespace)::MicrosoftCXXABI::EmitThreadLocalInitFuncs", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI24EmitThreadLocalInitFuncsERN5clang7CodeGen13CodeGenModuleEN4llvm8ArrayRefIPKNS1_7VarDeclEEENS6_IPNS5_8FunctionEEESA_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI24EmitThreadLocalInitFuncsERN5clang7CodeGen13CodeGenModuleEN4llvm8ArrayRefIPKNS1_7VarDeclEEENS6_IPNS5_8FunctionEEESA_")
  //</editor-fold>
  @Override public void EmitThreadLocalInitFuncs(final CodeGenModule /*&*/ CGM, ArrayRef</*const*/ VarDecl /*P*/ > CXXThreadLocals, 
                          ArrayRef<Function /*P*/ > CXXThreadLocalInits, 
                          ArrayRef</*const*/ VarDecl /*P*/ > CXXThreadLocalInitVars)/* override*/ {
    std.vector<Function /*P*/ > NonComdatInits = null;
    try {
      // This will create a GV in the .CRT$XDU section.  It will point to our
      // initialization function.  The CRT will call all of these function
      // pointers at start-up time and, eventually, at thread-creation time.
      Function2GlobalVariable AddToXDU = /*[&CGM]*/ (Function /*P*/ InitFunc) -> {
            GlobalVariable /*P*/ InitFuncPtr = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
                return new GlobalVariable(CGM.getModule(), InitFunc.getType(), /*IsConstant=*/ true, 
                GlobalVariable.LinkageTypes.InternalLinkage, InitFunc, 
                new Twine(InitFunc.getName(), /*KEEP_STR*/"$initializer$"));
             });
            InitFuncPtr.setSection(new StringRef(/*KEEP_STR*/".CRT$XDU"));
            // This variable has discardable linkage, we have to add it to @llvm.used to
            // ensure it won't get discarded.
            CGM.addUsedGlobal(InitFuncPtr);
            return InitFuncPtr;
          };
      
      NonComdatInits/*J*/= new std.vector<Function /*P*/ >((Function /*P*/ )null);
      for (/*size_t*/int I = 0, E = CXXThreadLocalInitVars.size(); I != E; ++I) {
        GlobalVariable /*P*/ GV = cast_GlobalVariable(CGM.GetGlobalValue(CGM.getMangledName(new GlobalDecl(CXXThreadLocalInitVars.$at(I)))));
        Function /*P*/ F = CXXThreadLocalInits.$at(I);
        {
          
          // If the GV is already in a comdat group, then we have to join it.
          Comdat /*P*/ C = GV.getComdat();
          if ((C != null)) {
            AddToXDU.$call(F).setComdat(C);
          } else {
            NonComdatInits.push_back_T$C$R(F);
          }
        }
      }
      if (!NonComdatInits.empty()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          org.llvm.ir.FunctionType /*P*/ FTy = org.llvm.ir.FunctionType.get(CGM.VoidTy, /*isVarArg=*/ false);
          Function /*P*/ InitFunc = CGM.CreateGlobalInitOrDestructFunction(FTy, new Twine(/*KEEP_STR*/"__tls_init"), CGM.getTypes().arrangeNullaryFunction(), 
              new SourceLocation(), /*TLS=*/ true);
          $c$.track(new CodeGenFunction(CGM)).GenerateCXXGlobalInitFunc(InitFunc, new ArrayRef<Function /*P*/ >(NonComdatInits, true)); $c$.clean();
          
          AddToXDU.$call(InitFunc);
        } finally {
          $c$.$destroy();
        }
      }
    } finally {
      if (NonComdatInits != null) { NonComdatInits.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::usesThreadWrapperFunction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 384,
   FQN="(anonymous namespace)::MicrosoftCXXABI::usesThreadWrapperFunction", NM="_ZNK12_GLOBAL__N_115MicrosoftCXXABI25usesThreadWrapperFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZNK12_GLOBAL__N_115MicrosoftCXXABI25usesThreadWrapperFunctionEv")
  //</editor-fold>
  @Override public boolean usesThreadWrapperFunction() /*const*//* override*/ {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::EmitThreadLocalVarDeclLValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 2246,
   FQN="(anonymous namespace)::MicrosoftCXXABI::EmitThreadLocalVarDeclLValue", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI28EmitThreadLocalVarDeclLValueERN5clang7CodeGen15CodeGenFunctionEPKNS1_7VarDeclENS1_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI28EmitThreadLocalVarDeclLValueERN5clang7CodeGen15CodeGenFunctionEPKNS1_7VarDeclENS1_8QualTypeE")
  //</editor-fold>
  @Override public LValue EmitThreadLocalVarDeclLValue(final CodeGenFunction /*&*/ CGF, 
                              /*const*/ VarDecl /*P*/ VD, 
                              QualType LValType)/* override*/ {
    CGF.CGM.ErrorUnsupported(VD, $("thread wrappers"));
    return new LValue();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::EmitGuardedInit">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 2329,
   FQN="(anonymous namespace)::MicrosoftCXXABI::EmitGuardedInit", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI15EmitGuardedInitERN5clang7CodeGen15CodeGenFunctionERKNS1_7VarDeclEPN4llvm14GlobalVariableEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI15EmitGuardedInitERN5clang7CodeGen15CodeGenFunctionERKNS1_7VarDeclEPN4llvm14GlobalVariableEb")
  //</editor-fold>
  @Override public void EmitGuardedInit(final CodeGenFunction /*&*/ CGF, final /*const*/ VarDecl /*&*/ D, 
                 GlobalVariable /*P*/ GV, 
                 boolean PerformInit)/* override*/ {
    // MSVC only uses guards for static locals.
    if (!D.isStaticLocal()) {
      assert (GV.hasWeakLinkage() || GV.hasLinkOnceLinkage());
      // GlobalOpt is allowed to discard the initializer, so use linkonce_odr.
      Function /*P*/ F = CGF.CurFn;
      F.setLinkage(GlobalValue.LinkageTypes.LinkOnceODRLinkage);
      F.setComdat(CGM.getModule().getOrInsertComdat(F.getName()));
      CGF.EmitCXXGlobalVarDeclInit(D, GV, PerformInit);
      return;
    }
    
    boolean ThreadlocalStatic = (D.getTLSKind().getValue() != 0);
    boolean ThreadsafeStatic = getContext().getLangOpts().ThreadsafeStatics;
    
    // Thread-safe static variables which aren't thread-specific have a
    // per-variable guard.
    boolean HasPerVariableGuard = ThreadsafeStatic && !ThreadlocalStatic;
    
    final CGBuilderTy /*&*/ Builder = CGF.Builder;
    IntegerType /*P*/ GuardTy = CGF.Int32Ty;
    ConstantInt /*P*/ Zero = ConstantInt.get(GuardTy, $int2ulong(0));
    CharUnits GuardAlign = CharUnits.fromQuantity(4);
    
    // Get the guard variable for this function if we have one already.
    GuardInfo /*P*/ GI = null;
    if (ThreadlocalStatic) {
      GI = $AddrOf(ThreadLocalGuardVariableMap.$at_T1$RR(D.getDeclContext$Const()));
    } else if (!ThreadsafeStatic) {
      GI = $AddrOf(GuardVariableMap.$at_T1$RR(D.getDeclContext$Const()));
    }
    
    GlobalVariable /*P*/ GuardVar = (GI != null) ? GI.Guard : null;
    /*uint*/int GuardNum;
    if (D.isExternallyVisible()) {
      // Externally visible variables have to be numbered in Sema to properly
      // handle unreachable VarDecls.
      GuardNum = getContext().getStaticLocalNumber($AddrOf(D));
      assert ($greater_uint(GuardNum, 0));
      GuardNum--;
    } else if (HasPerVariableGuard) {
      GuardNum = ThreadSafeGuardNumMap.ref$at(D.getDeclContext$Const()).$set$postInc();
    } else {
      // Non-externally visible variables are numbered here in CodeGen.
      GuardNum = GI.BitIndex++;
    }
    if (!HasPerVariableGuard && $greatereq_uint(GuardNum, 32)) {
      if (D.isExternallyVisible()) {
        ErrorUnsupportedABI(CGF, new StringRef(/*KEEP_STR*/"more than 32 guarded initializations"));
      }
      GuardNum = $rem_uint(GuardNum, 32);
      GuardVar = null;
    }
    if (!(GuardVar != null)) {
      // Mangle the name for the guard.
      SmallString/*<256>*/ GuardName/*J*/= new SmallString/*<256>*/(256);
      {
        raw_svector_ostream Out = null;
        try {
          Out/*J*/= new raw_svector_ostream(GuardName);
          if (HasPerVariableGuard) {
            getMangleContext().mangleThreadSafeStaticGuardVariable($AddrOf(D), GuardNum, 
                Out);
          } else {
            getMangleContext().mangleStaticGuardVariable($AddrOf(D), Out);
          }
        } finally {
          if (Out != null) { Out.$destroy(); }
        }
      }
      
      // Create the guard variable with a zero-initializer. Just absorb linkage,
      // visibility and dll storage class from the guarded variable.
      GuardVar
         = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
          return new GlobalVariable(CGM.getModule(), GuardTy, /*isConstant=*/ false, 
          GV.getLinkage(), Zero, new Twine(GuardName.str()));
       });
      GuardVar.setVisibility(GV.getVisibility());
      GuardVar.setDLLStorageClass(GV.getDLLStorageClass());
      GuardVar.setAlignment($long2uint(GuardAlign.getQuantity()));
      if (GuardVar.isWeakForLinker()) {
        GuardVar.setComdat(CGM.getModule().getOrInsertComdat(GuardVar.getName()));
      }
      if ((D.getTLSKind().getValue() != 0)) {
        GuardVar.setThreadLocal(true);
      }
      if ((GI != null) && !HasPerVariableGuard) {
        GI.Guard = GuardVar;
      }
    }
    
    ConstantAddress GuardAddr/*J*/= new ConstantAddress(GuardVar, new CharUnits(GuardAlign));
    assert (GuardVar.getLinkage() == GV.getLinkage()) : "static local from the same function had different linkage";
    if (!HasPerVariableGuard) {
      // Pseudo code for the test:
      // if (!(GuardVar & MyGuardBit)) {
      //   GuardVar |= MyGuardBit;
      //   ... initialize the object ...;
      // }
      
      // Test our bit from the guard variable.
      ConstantInt /*P*/ Bit = ConstantInt.get(GuardTy, 1L/*ULL*/ << GuardNum);
      LoadInst /*P*/ LI = Builder.CreateLoad(new Address(GuardAddr));
      Value /*P*/ IsInitialized = Builder.CreateICmpNE(Builder.CreateAnd(LI, Bit), Zero);
      BasicBlock /*P*/ InitBlock = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"init"));
      BasicBlock /*P*/ EndBlock = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"init.end"));
      Builder.CreateCondBr(IsInitialized, EndBlock, InitBlock);
      
      // Set our bit in the guard variable and emit the initializer and add a global
      // destructor if appropriate.
      CGF.EmitBlock(InitBlock);
      Builder.CreateStore(Builder.CreateOr(LI, Bit), new Address(GuardAddr));
      int $GuardNum = GuardNum;
      CGF.EHStack.<ResetGuardBit>pushCleanup$T(CleanupKind.EHCleanup, () -> new ResetGuardBit(new ConstantAddress(GuardAddr), $GuardNum));
      CGF.EmitCXXGlobalVarDeclInit(D, GV, PerformInit);
      CGF.PopCleanupBlock();
      Builder.CreateBr(EndBlock);
      
      // Continue.
      CGF.EmitBlock(EndBlock);
    } else {
      // Pseudo code for the test:
      // if (TSS > _Init_thread_epoch) {
      //   _Init_thread_header(&TSS);
      //   if (TSS == -1) {
      //     ... initialize the object ...;
      //     _Init_thread_footer(&TSS);
      //   }
      // }
      //
      // The algorithm is almost identical to what can be found in the appendix
      // found in N2325.
      
      // This BasicBLock determines whether or not we have any work to do.
      LoadInst /*P*/ FirstGuardLoad = Builder.CreateLoad(new Address(GuardAddr));
      FirstGuardLoad.setOrdering(AtomicOrdering.Unordered);
      LoadInst /*P*/ InitThreadEpoch = Builder.CreateLoad(new Address(JD$Move.INSTANCE, MicrosoftCXXABIStatics.getInitThreadEpochPtr(CGM)));
      Value /*P*/ IsUninitialized = Builder.CreateICmpSGT(FirstGuardLoad, InitThreadEpoch);
      BasicBlock /*P*/ AttemptInitBlock = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"init.attempt"));
      BasicBlock /*P*/ EndBlock = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"init.end"));
      Builder.CreateCondBr(IsUninitialized, AttemptInitBlock, EndBlock);
      
      // This BasicBlock attempts to determine whether or not this thread is
      // responsible for doing the initialization.
      CGF.EmitBlock(AttemptInitBlock);
      CGF.EmitNounwindRuntimeCall(MicrosoftCXXABIStatics.getInitThreadHeaderFn(CGM), 
          new ArrayRef<Value /*P*/ >(GuardAddr.getPointer(), true));
      LoadInst /*P*/ SecondGuardLoad = Builder.CreateLoad(new Address(GuardAddr));
      SecondGuardLoad.setOrdering(AtomicOrdering.Unordered);
      Value /*P*/ ShouldDoInit = Builder.CreateICmpEQ(SecondGuardLoad, getAllOnesInt());
      BasicBlock /*P*/ InitBlock = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"init"));
      Builder.CreateCondBr(ShouldDoInit, InitBlock, EndBlock);
      
      // Ok, we ended up getting selected as the initializing thread.
      CGF.EmitBlock(InitBlock);
      CGF.EHStack.<CallInitThreadAbort>pushCleanup$T(CleanupKind.EHCleanup, () -> new CallInitThreadAbort(new ConstantAddress(GuardAddr)));
      CGF.EmitCXXGlobalVarDeclInit(D, GV, PerformInit);
      CGF.PopCleanupBlock();
      CGF.EmitNounwindRuntimeCall(MicrosoftCXXABIStatics.getInitThreadFooterFn(CGM), 
          new ArrayRef<Value /*P*/ >(GuardAddr.getPointer(), true));
      Builder.CreateBr(EndBlock);
      
      CGF.EmitBlock(EndBlock);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::registerGlobalDtor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 2192,
   FQN="(anonymous namespace)::MicrosoftCXXABI::registerGlobalDtor", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI18registerGlobalDtorERN5clang7CodeGen15CodeGenFunctionERKNS1_7VarDeclEPN4llvm8ConstantESA_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI18registerGlobalDtorERN5clang7CodeGen15CodeGenFunctionERKNS1_7VarDeclEPN4llvm8ConstantESA_")
  //</editor-fold>
  @Override public void registerGlobalDtor(final CodeGenFunction /*&*/ CGF, final /*const*/ VarDecl /*&*/ D, 
                    Constant /*P*/ Dtor, 
                    Constant /*P*/ Addr)/* override*/ {
    if ((D.getTLSKind().getValue() != 0)) {
      MicrosoftCXXABIStatics.emitGlobalDtorWithTLRegDtor(CGF, D, Dtor, Addr);
      /*JAVA:return*/return;
    }
    
    // The default behavior is to use atexit.
    CGF.registerGlobalDtorWithAtExit(D, Dtor, Addr);
  }

  
  // ==== Notes on array cookies =========
  //
  // MSVC seems to only use cookies when the class has a destructor; a
  // two-argument usual array deallocation function isn't sufficient.
  //
  // For example, this code prints "100" and "1":
  //   struct A {
  //     char x;
  //     void *operator new[](size_t sz) {
  //       printf("%u\n", sz);
  //       return malloc(sz);
  //     }
  //     void operator delete[](void *p, size_t sz) {
  //       printf("%u\n", sz);
  //       free(p);
  //     }
  //   };
  //   int main() {
  //     A *p = new A[100];
  //     delete[] p;
  //   }
  // Whereas it prints "104" and "104" if you give A a destructor.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::requiresArrayCookie">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 2122,
   FQN="(anonymous namespace)::MicrosoftCXXABI::requiresArrayCookie", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI19requiresArrayCookieEPKN5clang13CXXDeleteExprENS1_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI19requiresArrayCookieEPKN5clang13CXXDeleteExprENS1_8QualTypeE")
  //</editor-fold>
  @Override public boolean requiresArrayCookie(/*const*/ CXXDeleteExpr /*P*/ expr, 
                     QualType elementType)/* override*/ {
    // Microsoft seems to completely ignore the possibility of a
    // two-argument usual deallocation function.
    return (elementType.isDestructedType().getValue() != 0);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::requiresArrayCookie">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 2129,
   FQN="(anonymous namespace)::MicrosoftCXXABI::requiresArrayCookie", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI19requiresArrayCookieEPKN5clang10CXXNewExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI19requiresArrayCookieEPKN5clang10CXXNewExprE")
  //</editor-fold>
  @Override public boolean requiresArrayCookie(/*const*/ CXXNewExpr /*P*/ expr)/* override*/ {
    // Microsoft seems to completely ignore the possibility of a
    // two-argument usual deallocation function.
    return (expr.getAllocatedType().isDestructedType().getValue() != 0);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::getArrayCookieSizeImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 2135,
   FQN="(anonymous namespace)::MicrosoftCXXABI::getArrayCookieSizeImpl", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI22getArrayCookieSizeImplEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI22getArrayCookieSizeImplEN5clang8QualTypeE")
  //</editor-fold>
  @Override public CharUnits getArrayCookieSizeImpl(QualType type)/* override*/ {
    // The array cookie is always a size_t; we then pad that out to the
    // alignment of the element type.
    final ASTContext /*&*/ Ctx = getContext();
    return new CharUnits(std.max(Ctx.getTypeSizeInChars(Ctx.getSizeType().$QualType()), 
            Ctx.getTypeAlignInChars(new QualType(type))));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::InitializeArrayCookie">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 2151,
   FQN="(anonymous namespace)::MicrosoftCXXABI::InitializeArrayCookie", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI21InitializeArrayCookieERN5clang7CodeGen15CodeGenFunctionENS2_7AddressEPN4llvm5ValueEPKNS1_10CXXNewExprENS1_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI21InitializeArrayCookieERN5clang7CodeGen15CodeGenFunctionENS2_7AddressEPN4llvm5ValueEPKNS1_10CXXNewExprENS1_8QualTypeE")
  //</editor-fold>
  @Override public Address InitializeArrayCookie(final CodeGenFunction /*&*/ CGF, 
                       Address newPtr, 
                       Value /*P*/ numElements, 
                       /*const*/ CXXNewExpr /*P*/ expr, 
                       QualType elementType)/* override*/ {
    assert (requiresArrayCookie(expr));
    
    // The size of the cookie.
    CharUnits cookieSize = getArrayCookieSizeImpl(new QualType(elementType));
    
    // Compute an offset to the cookie.
    Address cookiePtr = new Address(newPtr);
    
    // Write the number of elements into the appropriate slot.
    Address numElementsPtr = CGF.Builder.CreateElementBitCast(new Address(cookiePtr), CGF.Unnamed_field8.SizeTy);
    CGF.Builder.CreateStore(numElements, new Address(numElementsPtr));
    
    // Finally, compute a pointer to the actual data buffer by skipping
    // over the cookie completely.
    return CGF.Builder.CreateConstInBoundsByteGEP(new Address(newPtr), new CharUnits(cookieSize));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::readArrayCookieImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 2143,
   FQN="(anonymous namespace)::MicrosoftCXXABI::readArrayCookieImpl", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI19readArrayCookieImplERN5clang7CodeGen15CodeGenFunctionENS2_7AddressENS1_9CharUnitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI19readArrayCookieImplERN5clang7CodeGen15CodeGenFunctionENS2_7AddressENS1_9CharUnitsE")
  //</editor-fold>
  @Override public Value /*P*/ readArrayCookieImpl(final CodeGenFunction /*&*/ CGF, 
                     Address allocPtr, 
                     CharUnits cookieSize)/* override*/ {
    Address numElementsPtr = CGF.Builder.CreateElementBitCast(new Address(allocPtr), CGF.Unnamed_field8.SizeTy);
    return CGF.Builder.CreateLoad(new Address(numElementsPtr));
  }

  
  /*friend  struct MSRTTIBuilder*/
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::isImageRelative">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 432,
   FQN="(anonymous namespace)::MicrosoftCXXABI::isImageRelative", NM="_ZNK12_GLOBAL__N_115MicrosoftCXXABI15isImageRelativeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZNK12_GLOBAL__N_115MicrosoftCXXABI15isImageRelativeEv")
  //</editor-fold>
  public boolean isImageRelative() /*const*/ {
    return CGM.getTarget().getPointerWidth(/*AddressSpace=*/ 0) == $int2ullong(64);
  }

  
  // 5 routines for constructing the llvm types for MS RTTI structs.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::getTypeDescriptorType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 437,
   FQN="(anonymous namespace)::MicrosoftCXXABI::getTypeDescriptorType", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI21getTypeDescriptorTypeEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI21getTypeDescriptorTypeEN4llvm9StringRefE")
  //</editor-fold>
  public StructType /*P*/ getTypeDescriptorType(StringRef TypeInfoString) {
    SmallString/*<32>*/ TDTypeName/*J*/= new SmallString/*<32>*/(32, new StringRef(/*KEEP_STR*/"rtti.TypeDescriptor"));
    TDTypeName.$addassign(new StringRef(llvm.utostr($uint2ulong(TypeInfoString.size()))));
    final type$ref<StructType /*P*/ /*&*/> TypeDescriptorType = TypeDescriptorTypeMap.ref$at(TypeInfoString.size());
    if ((TypeDescriptorType.$deref() != null)) {
      return TypeDescriptorType.$deref();
    }
    org.llvm.ir.Type /*P*/ FieldTypes[/*3*/] = new org.llvm.ir.Type /*P*/  [/*3*/] {
      CGM.Unnamed_field10.Int8PtrPtrTy, 
      CGM.Unnamed_field9.Int8PtrTy, 
      org.llvm.ir.ArrayType.get(CGM.Int8Ty, $uint2ulong(TypeInfoString.size() + 1))};
    TypeDescriptorType.$set(StructType.create(CGM.getLLVMContext(), new ArrayRef<org.llvm.ir.Type /*P*/ >(FieldTypes, true), TDTypeName.$StringRef()));
    return TypeDescriptorType.$deref();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::getImageRelativeType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 453,
   FQN="(anonymous namespace)::MicrosoftCXXABI::getImageRelativeType", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI20getImageRelativeTypeEPN4llvm4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI20getImageRelativeTypeEPN4llvm4TypeE")
  //</editor-fold>
  public org.llvm.ir.Type /*P*/ getImageRelativeType(org.llvm.ir.Type /*P*/ PtrType) {
    if (!isImageRelative()) {
      return PtrType;
    }
    return CGM.IntTy;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::getBaseClassDescriptorType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 459,
   FQN="(anonymous namespace)::MicrosoftCXXABI::getBaseClassDescriptorType", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI26getBaseClassDescriptorTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI26getBaseClassDescriptorTypeEv")
  //</editor-fold>
  public StructType /*P*/ getBaseClassDescriptorType() {
    if ((BaseClassDescriptorType != null)) {
      return BaseClassDescriptorType;
    }
    org.llvm.ir.Type /*P*/ FieldTypes[/*7*/] = new org.llvm.ir.Type /*P*/  [/*7*/] {
      getImageRelativeType(CGM.Unnamed_field9.Int8PtrTy), 
      CGM.IntTy, 
      CGM.IntTy, 
      CGM.IntTy, 
      CGM.IntTy, 
      CGM.IntTy, 
      getImageRelativeType(getClassHierarchyDescriptorType().getPointerTo())
    };
    BaseClassDescriptorType = StructType.create(CGM.getLLVMContext(), new ArrayRef<org.llvm.ir.Type /*P*/ >(FieldTypes, true), new StringRef(/*KEEP_STR*/"rtti.BaseClassDescriptor"));
    return BaseClassDescriptorType;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::getClassHierarchyDescriptorType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 476,
   FQN="(anonymous namespace)::MicrosoftCXXABI::getClassHierarchyDescriptorType", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI31getClassHierarchyDescriptorTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI31getClassHierarchyDescriptorTypeEv")
  //</editor-fold>
  public StructType /*P*/ getClassHierarchyDescriptorType() {
    if ((ClassHierarchyDescriptorType != null)) {
      return ClassHierarchyDescriptorType;
    }
    // Forward-declare RTTIClassHierarchyDescriptor to break a cycle.
    ClassHierarchyDescriptorType = StructType.create(CGM.getLLVMContext(), new StringRef(/*KEEP_STR*/"rtti.ClassHierarchyDescriptor"));
    org.llvm.ir.Type /*P*/ FieldTypes[/*4*/] = new org.llvm.ir.Type /*P*/  [/*4*/] {
      CGM.IntTy, 
      CGM.IntTy, 
      CGM.IntTy, 
      getImageRelativeType(getBaseClassDescriptorType().getPointerTo().getPointerTo())
    };
    ClassHierarchyDescriptorType.setBody(new ArrayRef<org.llvm.ir.Type /*P*/ >(FieldTypes, true));
    return ClassHierarchyDescriptorType;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::getCompleteObjectLocatorType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 493,
   FQN="(anonymous namespace)::MicrosoftCXXABI::getCompleteObjectLocatorType", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI28getCompleteObjectLocatorTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI28getCompleteObjectLocatorTypeEv")
  //</editor-fold>
  public StructType /*P*/ getCompleteObjectLocatorType() {
    if ((CompleteObjectLocatorType != null)) {
      return CompleteObjectLocatorType;
    }
    CompleteObjectLocatorType = StructType.create(CGM.getLLVMContext(), new StringRef(/*KEEP_STR*/"rtti.CompleteObjectLocator"));
    org.llvm.ir.Type /*P*/ FieldTypes[/*6*/] = new org.llvm.ir.Type /*P*/  [/*6*/] {
      CGM.IntTy, 
      CGM.IntTy, 
      CGM.IntTy, 
      getImageRelativeType(CGM.Unnamed_field9.Int8PtrTy), 
      getImageRelativeType(getClassHierarchyDescriptorType().getPointerTo()), 
      getImageRelativeType(CompleteObjectLocatorType)
    };
    ArrayRef<org.llvm.ir.Type /*P*/ > FieldTypesRef/*J*/= new ArrayRef<org.llvm.ir.Type /*P*/ >(FieldTypes, true);
    if (!isImageRelative()) {
      FieldTypesRef.$assignMove(FieldTypesRef.drop_back());
    }
    CompleteObjectLocatorType.setBody(new ArrayRef<org.llvm.ir.Type /*P*/ >(FieldTypesRef));
    return CompleteObjectLocatorType;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::getImageBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 513,
   FQN="(anonymous namespace)::MicrosoftCXXABI::getImageBase", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI12getImageBaseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI12getImageBaseEv")
  //</editor-fold>
  public GlobalVariable /*P*/ getImageBase() {
    StringRef Name = new StringRef(/*KEEP_STR*/"__ImageBase");
    {
      GlobalVariable /*P*/ GV = CGM.getModule().getNamedGlobal(new StringRef(Name));
      if ((GV != null)) {
        return GV;
      }
    }
    
    return /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
    return new GlobalVariable(CGM.getModule(), CGM.Int8Ty, 
        /*isConstant=*/ true, 
        GlobalValue.LinkageTypes.ExternalLinkage, 
        /*Initializer=*/ (Constant /*P*/ )null, new Twine(Name));
     });
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::getImageRelativeConstant">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 524,
   FQN="(anonymous namespace)::MicrosoftCXXABI::getImageRelativeConstant", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI24getImageRelativeConstantEPN4llvm8ConstantE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI24getImageRelativeConstantEPN4llvm8ConstantE")
  //</editor-fold>
  public Constant /*P*/ getImageRelativeConstant(Constant /*P*/ PtrVal) {
    if (!isImageRelative()) {
      return PtrVal;
    }
    if (PtrVal.isNullValue()) {
      return Constant.getNullValue(CGM.IntTy);
    }
    
    Constant /*P*/ ImageBaseAsInt = ConstantExpr.getPtrToInt(getImageBase(), CGM.Unnamed_field8.IntPtrTy);
    Constant /*P*/ PtrValAsInt = ConstantExpr.getPtrToInt(PtrVal, CGM.Unnamed_field8.IntPtrTy);
    Constant /*P*/ Diff = ConstantExpr.getSub(PtrValAsInt, ImageBaseAsInt, 
        /*HasNUW=*/ true, /*HasNSW=*/ true);
    return ConstantExpr.getTrunc(Diff, CGM.IntTy);
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::getMangleContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 542,
   FQN="(anonymous namespace)::MicrosoftCXXABI::getMangleContext", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI16getMangleContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI16getMangleContextEv")
  //</editor-fold>
  public/*private*/ MicrosoftMangleContext /*&*/ getMangleContext() {
    return cast_MicrosoftMangleContext(super.getMangleContext());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::getZeroInt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 546,
   FQN="(anonymous namespace)::MicrosoftCXXABI::getZeroInt", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI10getZeroIntEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI10getZeroIntEv")
  //</editor-fold>
  private Constant /*P*/ getZeroInt() {
    return ConstantInt.get(CGM.IntTy, $int2ulong(0));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::getAllOnesInt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 550,
   FQN="(anonymous namespace)::MicrosoftCXXABI::getAllOnesInt", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI13getAllOnesIntEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI13getAllOnesIntEv")
  //</editor-fold>
  private Constant /*P*/ getAllOnesInt() {
    return Constant.getAllOnesValue(CGM.IntTy);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::getVirtualFunctionPrologueThisAdjustment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 1259,
   FQN="(anonymous namespace)::MicrosoftCXXABI::getVirtualFunctionPrologueThisAdjustment", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI40getVirtualFunctionPrologueThisAdjustmentEN5clang10GlobalDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI40getVirtualFunctionPrologueThisAdjustmentEN5clang10GlobalDeclE")
  //</editor-fold>
  @Override public/*private*/ CharUnits getVirtualFunctionPrologueThisAdjustment(GlobalDecl GD)/* override*/ {
    GD.$assignMove(GD.getCanonicalDecl());
    /*const*/ CXXMethodDecl /*P*/ MD = cast_CXXMethodDecl(GD.getDecl());
    
    GlobalDecl LookupGD = new GlobalDecl(GD);
    {
      /*const*/ CXXDestructorDecl /*P*/ DD = dyn_cast_CXXDestructorDecl(MD);
      if ((DD != null)) {
        // Complete destructors take a pointer to the complete object as a
        // parameter, thus don't need this adjustment.
        if (GD.getDtorType() == CXXDtorType.Dtor_Complete) {
          return new CharUnits();
        }
        
        // There's no Dtor_Base in vftable but it shares the this adjustment with
        // the deleting one, so look it up instead.
        LookupGD.$assignMove(new GlobalDecl(JD$CXXDestructorDecl$C$P_CXXDtorType.INSTANCE, DD, CXXDtorType.Dtor_Deleting));
      }
    }
    
    MicrosoftVTableContext.MethodVFTableLocation ML = new MicrosoftVTableContext.MethodVFTableLocation(CGM.getMicrosoftVTableContext().getMethodVFTableLocation(new GlobalDecl(LookupGD)));
    CharUnits Adjustment = new CharUnits(ML.VFPtrOffset);
    
    // Normal virtual instance methods need to adjust from the vfptr that first
    // defined the virtual method to the virtual base subobject, but destructors
    // do not.  The vector deleting destructor thunk applies this adjustment for
    // us if necessary.
    if (isa_CXXDestructorDecl(MD)) {
      Adjustment.$assignMove(CharUnits.Zero());
    }
    if ((ML.VBase != null)) {
      final /*const*/ ASTRecordLayout /*&*/ DerivedLayout = getContext().getASTRecordLayout(MD.getParent$Const());
      Adjustment.$addassign(DerivedLayout.getVBaseClassOffset(ML.VBase));
    }
    
    return Adjustment;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::GetNullMemberPointerFields">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 2532,
   FQN="(anonymous namespace)::MicrosoftCXXABI::GetNullMemberPointerFields", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI26GetNullMemberPointerFieldsEPKN5clang17MemberPointerTypeERN4llvm15SmallVectorImplIPNS5_8ConstantEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI26GetNullMemberPointerFieldsEPKN5clang17MemberPointerTypeERN4llvm15SmallVectorImplIPNS5_8ConstantEEE")
  //</editor-fold>
  private void GetNullMemberPointerFields(/*const*/ MemberPointerType /*P*/ MPT, 
                            final SmallVectorImpl<Constant /*P*/ > /*&*/ fields) {
    assert (fields.empty());
    /*const*/ CXXRecordDecl /*P*/ RD = MPT.getMostRecentCXXRecordDecl();
    MSInheritanceAttr.Spelling Inheritance = RD.getMSInheritanceModel();
    if (MPT.isMemberFunctionPointer()) {
      // FunctionPointerOrVirtualThunk
      fields.push_back(Constant.getNullValue(CGM.Unnamed_field9.VoidPtrTy));
    } else {
      if (RD.nullFieldOffsetIsZero()) {
        fields.push_back(getZeroInt()); // FieldOffset
      } else {
        fields.push_back(getAllOnesInt()); // FieldOffset
      }
    }
    if (MSInheritanceAttr.hasNVOffsetField(MPT.isMemberFunctionPointer(), 
        Inheritance)) {
      fields.push_back(getZeroInt());
    }
    if (MSInheritanceAttr.hasVBPtrOffsetField(Inheritance)) {
      fields.push_back(getZeroInt());
    }
    if (MSInheritanceAttr.hasVBTableOffsetField(Inheritance)) {
      fields.push_back(getAllOnesInt());
    }
  }

  
  /// \brief Shared code for virtual base adjustment.  Returns the offset from
  /// the vbptr to the virtual base.  Optionally returns the address of the
  /// vbptr itself.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::GetVBaseOffsetFromVBPtr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 2840,
   FQN="(anonymous namespace)::MicrosoftCXXABI::GetVBaseOffsetFromVBPtr", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI23GetVBaseOffsetFromVBPtrERN5clang7CodeGen15CodeGenFunctionENS2_7AddressEPN4llvm5ValueES8_PS8_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI23GetVBaseOffsetFromVBPtrERN5clang7CodeGen15CodeGenFunctionENS2_7AddressEPN4llvm5ValueES8_PS8_")
  //</editor-fold>
  private Value /*P*/ GetVBaseOffsetFromVBPtr(final CodeGenFunction /*&*/ CGF, 
                         Address This, 
                         Value /*P*/ VBPtrOffset, 
                         Value /*P*/ VBTableOffset) {
    return GetVBaseOffsetFromVBPtr(CGF, 
                         This, 
                         VBPtrOffset, 
                         VBTableOffset, 
                         (type$ptr<Value /*P*/ /*P*/>)null);
  }
  private Value /*P*/ GetVBaseOffsetFromVBPtr(final CodeGenFunction /*&*/ CGF, 
                         Address This, 
                         Value /*P*/ VBPtrOffset, 
                         Value /*P*/ VBTableOffset, 
                         type$ptr<Value /*P*/ /*P*/> VBPtrOut/*= null*/) {
    final CGBuilderTy /*&*/ Builder = CGF.Builder;
    // Load the vbtable pointer from the vbptr in the instance.
    This.$assignMove(Builder.CreateElementBitCast(new Address(This), CGM.Int8Ty));
    Value /*P*/ VBPtr = Builder.CreateInBoundsGEP(This.getPointer(), new ArrayRef<Value /*P*/ >(VBPtrOffset, true), new Twine(/*KEEP_STR*/"vbptr"));
    if ((VBPtrOut != null)) {
      VBPtrOut.$set(VBPtr);
    }
    VBPtr = Builder.CreateBitCast(VBPtr, 
        CGM.Int32Ty.getPointerTo(0).getPointerTo(This.getAddressSpace()));
    
    CharUnits VBPtrAlign/*J*/= new CharUnits();
    {
      ConstantInt /*P*/ CI = dyn_cast_ConstantInt(VBPtrOffset);
      if ((CI != null)) {
        VBPtrAlign.$assignMove(This.getAlignment().alignmentAtOffset(CharUnits.fromQuantity(CI.getSExtValue())));
      } else {
        VBPtrAlign.$assignMove(CGF.getPointerAlign());
      }
    }
    
    Value /*P*/ VBTable = Builder.CreateAlignedLoad(VBPtr, new CharUnits(VBPtrAlign), $("vbtable"));
    
    // Translate from byte offset to table index. It improves analyzability.
    Value /*P*/ VBTableIndex = Builder.CreateAShr(VBTableOffset, ConstantInt.get(VBTableOffset.getType(), $int2ulong(2)), 
        new Twine(/*KEEP_STR*/"vbtindex"), /*isExact=*/ true);
    
    // Load an i32 offset from the vb-table.
    Value /*P*/ VBaseOffs = Builder.CreateInBoundsGEP(VBTable, new ArrayRef<Value /*P*/ >(VBTableIndex, true));
    VBaseOffs = Builder.CreateBitCast(VBaseOffs, CGM.Int32Ty.getPointerTo(0));
    return Builder.CreateAlignedLoad(VBaseOffs, CharUnits.fromQuantity(4), 
        $("vbase_offs"));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::GetVBaseOffsetFromVBPtr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 569,
   FQN="(anonymous namespace)::MicrosoftCXXABI::GetVBaseOffsetFromVBPtr", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI23GetVBaseOffsetFromVBPtrERN5clang7CodeGen15CodeGenFunctionENS2_7AddressEiiPPN4llvm5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI23GetVBaseOffsetFromVBPtrERN5clang7CodeGen15CodeGenFunctionENS2_7AddressEiiPPN4llvm5ValueE")
  //</editor-fold>
  private Value /*P*/ GetVBaseOffsetFromVBPtr(final CodeGenFunction /*&*/ CGF, 
                         Address Base, 
                         int/*int32_t*/ VBPtrOffset, 
                         int/*int32_t*/ VBTableOffset) {
    return GetVBaseOffsetFromVBPtr(CGF, 
                         Base, 
                         VBPtrOffset, 
                         VBTableOffset, 
                         (type$ptr<Value /*P*/ /*P*/>)null);
  }
  private Value /*P*/ GetVBaseOffsetFromVBPtr(final CodeGenFunction /*&*/ CGF, 
                         Address Base, 
                         int/*int32_t*/ VBPtrOffset, 
                         int/*int32_t*/ VBTableOffset, 
                         type$ptr<Value /*P*/ /*P*/> VBPtr/*= null*/) {
    assert (VBTableOffset % 4 == 0) : "should be byte offset into table of i32s";
    Value /*P*/ VBPOffset = ConstantInt.get(CGM.IntTy, $int2ulong(VBPtrOffset));
    Value /*P*/ VBTOffset = ConstantInt.get(CGM.IntTy, $int2ulong(VBTableOffset));
    return GetVBaseOffsetFromVBPtr(CGF, new Address(Base), VBPOffset, VBTOffset, VBPtr);
  }

  
  
  /// We need to perform a generic polymorphic operation (like a typeid
  /// or a cast), which requires an object with a vfptr.  Adjust the
  /// address to point to an object with a vfptr.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::performBaseAdjustment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 917,
   FQN="(anonymous namespace)::MicrosoftCXXABI::performBaseAdjustment", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI21performBaseAdjustmentERN5clang7CodeGen15CodeGenFunctionENS2_7AddressENS1_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI21performBaseAdjustmentERN5clang7CodeGen15CodeGenFunctionENS2_7AddressENS1_8QualTypeE")
  //</editor-fold>
  private std.pairTypePtr<Address, Value /*P*/ > performBaseAdjustment(final CodeGenFunction /*&*/ CGF, Address Value, 
                       QualType SrcRecordTy) {
    Value.$assignMove(CGF.Builder.CreateBitCast(new Address(Value), CGF.Unnamed_field9.Int8PtrTy));
    /*const*/ CXXRecordDecl /*P*/ SrcDecl = SrcRecordTy.$arrow().getAsCXXRecordDecl();
    final /*const*/ ASTContext /*&*/ Context = getContext();
    
    // If the class itself has a vfptr, great.  This check implicitly
    // covers non-virtual base subobjects: a class with its own virtual
    // functions would be a candidate to be a primary base.
    if (Context.getASTRecordLayout(SrcDecl).hasExtendableVFPtr()) {
      return new std.pairTypePtr<Address, Value /*P*/ >(JD$Pair$_U1$_U2.INSTANCE, new Address(JD$Move.INSTANCE, /*Fwd*/new Address(/*Fwd2*/Value)), /*Fwd2*//*Fwd*/ConstantInt.get(CGF.Int32Ty, $int2ulong(0)));
    }
    
    // Okay, one of the vbases must have a vfptr, or else this isn't
    // actually a polymorphic class.
    /*const*/ CXXRecordDecl /*P*/ PolymorphicBase = null;
    for (final /*const*/ CXXBaseSpecifier /*&*/ Base : SrcDecl.vbases$Const()) {
      /*const*/ CXXRecordDecl /*P*/ BaseDecl = Base.getType().$arrow().getAsCXXRecordDecl();
      if (Context.getASTRecordLayout(BaseDecl).hasExtendableVFPtr()) {
        PolymorphicBase = BaseDecl;
        break;
      }
    }
    assert ((PolymorphicBase != null)) : "polymorphic class has no apparent vfptr?";
    
    Value /*P*/ Offset = GetVirtualBaseClassOffset(CGF, new Address(Value), SrcDecl, PolymorphicBase);
    Value /*P*/ Ptr = CGF.Builder.CreateInBoundsGEP(Value.getPointer(), new ArrayRef<Value /*P*/ >(Offset, true));
    CharUnits VBaseAlign = CGF.CGM.getVBaseAlignment(Value.getAlignment(), SrcDecl, PolymorphicBase);
    return std.make_pair_T_Ptr($Move(new Address(Ptr, new CharUnits(VBaseAlign))), Offset);
  }

  
  /// \brief Performs a full virtual base adjustment.  Used to dereference
  /// pointers to members of virtual bases.
  
  // Returns an adjusted base cast to i8*, since we do more address arithmetic on
  // it.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::AdjustVirtualBase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 2879,
   FQN="(anonymous namespace)::MicrosoftCXXABI::AdjustVirtualBase", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI17AdjustVirtualBaseERN5clang7CodeGen15CodeGenFunctionEPKNS1_4ExprEPKNS1_13CXXRecordDeclENS2_7AddressEPN4llvm5ValueESE_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI17AdjustVirtualBaseERN5clang7CodeGen15CodeGenFunctionEPKNS1_4ExprEPKNS1_13CXXRecordDeclENS2_7AddressEPN4llvm5ValueESE_")
  //</editor-fold>
  private Value /*P*/ AdjustVirtualBase(final CodeGenFunction /*&*/ CGF, /*const*/ Expr /*P*/ E, /*const*/ CXXRecordDecl /*P*/ RD, 
                   Address Base, Value /*P*/ VBTableOffset, Value /*P*/ VBPtrOffset) {
    final CGBuilderTy /*&*/ Builder = CGF.Builder;
    Base.$assignMove(Builder.CreateElementBitCast(new Address(Base), CGM.Int8Ty));
    BasicBlock /*P*/ OriginalBB = null;
    BasicBlock /*P*/ SkipAdjustBB = null;
    BasicBlock /*P*/ VBaseAdjustBB = null;
    
    // In the unspecified inheritance model, there might not be a vbtable at all,
    // in which case we need to skip the virtual base lookup.  If there is a
    // vbtable, the first entry is a no-op entry that gives back the original
    // base, so look for a virtual base adjustment offset of zero.
    if ((VBPtrOffset != null)) {
      OriginalBB = Builder.GetInsertBlock();
      VBaseAdjustBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"memptr.vadjust"));
      SkipAdjustBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"memptr.skip_vadjust"));
      Value /*P*/ IsVirtual = Builder.CreateICmpNE(VBTableOffset, getZeroInt(), 
          new Twine(/*KEEP_STR*/"memptr.is_vbase"));
      Builder.CreateCondBr(IsVirtual, VBaseAdjustBB, SkipAdjustBB);
      CGF.EmitBlock(VBaseAdjustBB);
    }
    
    // If we weren't given a dynamic vbptr offset, RD should be complete and we'll
    // know the vbptr offset.
    if (!(VBPtrOffset != null)) {
      CharUnits offs = CharUnits.Zero();
      if (!RD.hasDefinition()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          final DiagnosticsEngine /*&*/ Diags = CGF.CGM.getDiags();
          /*uint*/int DiagID = Diags.getCustomDiagID(/*KEEP_ENUM*/DiagnosticsEngine.Level.Error, 
              /*KEEP_STR*/"member pointer representation requires a complete class type for %0 to perform this expression");
          $c$.clean($out_DiagnosticBuilder$C_SourceRange($out_DiagnosticBuilder$C_NamedDecl$C$P($c$.track(Diags.Report(E.getExprLoc(), DiagID)), RD), E.getSourceRange()));
        } finally {
          $c$.$destroy();
        }
      } else if ((RD.getNumVBases() != 0)) {
        offs.$assignMove(getContext().getASTRecordLayout(RD).getVBPtrOffset());
      }
      VBPtrOffset = ConstantInt.get(CGM.IntTy, offs.getQuantity());
    }
    type$ptr<Value /*P*/ > VBPtr = create_type$null$ptr(null);
    Value /*P*/ VBaseOffs = GetVBaseOffsetFromVBPtr(CGF, new Address(Base), VBPtrOffset, VBTableOffset, $AddrOf(VBPtr));
    Value /*P*/ AdjustedBase = Builder.CreateInBoundsGEP(VBPtr.$star(), new ArrayRef<Value /*P*/ >(VBaseOffs, true));
    
    // Merge control flow with the case where we didn't have to adjust.
    if ((VBaseAdjustBB != null)) {
      Builder.CreateBr(SkipAdjustBB);
      CGF.EmitBlock(SkipAdjustBB);
      PHINode /*P*/ Phi = Builder.CreatePHI(CGM.Unnamed_field9.Int8PtrTy, 2, new Twine(/*KEEP_STR*/"memptr.base"));
      Phi.addIncoming(Base.getPointer(), OriginalBB);
      Phi.addIncoming(AdjustedBase, VBaseAdjustBB);
      return Phi;
    }
    return AdjustedBase;
  }

  
  /// \brief Emits a full member pointer with the fields common to data and
  /// function member pointers.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::EmitFullMemberPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 2568,
   FQN="(anonymous namespace)::MicrosoftCXXABI::EmitFullMemberPointer", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI21EmitFullMemberPointerEPN4llvm8ConstantEbPKN5clang13CXXRecordDeclENS4_9CharUnitsEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI21EmitFullMemberPointerEPN4llvm8ConstantEbPKN5clang13CXXRecordDeclENS4_9CharUnitsEj")
  //</editor-fold>
  private Constant /*P*/ EmitFullMemberPointer(Constant /*P*/ FirstField, 
                       boolean IsMemberFunction, 
                       /*const*/ CXXRecordDecl /*P*/ RD, 
                       CharUnits NonVirtualBaseAdjustment, 
                       /*uint*/int VBTableIndex) {
    MSInheritanceAttr.Spelling Inheritance = RD.getMSInheritanceModel();
    
    // Single inheritance class member pointer are represented as scalars instead
    // of aggregates.
    if (MSInheritanceAttr.hasOnlyOneField(IsMemberFunction, Inheritance)) {
      return FirstField;
    }
    
    SmallVector<Constant /*P*/ > fields/*J*/= new SmallVector<Constant /*P*/ >(4, (Constant /*P*/ )null);
    fields.push_back(FirstField);
    if (MSInheritanceAttr.hasNVOffsetField(IsMemberFunction, Inheritance)) {
      fields.push_back(ConstantInt.get(CGM.IntTy, NonVirtualBaseAdjustment.getQuantity()));
    }
    if (MSInheritanceAttr.hasVBPtrOffsetField(Inheritance)) {
      CharUnits Offs = CharUnits.Zero();
      if ((VBTableIndex != 0)) {
        Offs.$assignMove(getContext().getASTRecordLayout(RD).getVBPtrOffset());
      }
      fields.push_back(ConstantInt.get(CGM.IntTy, Offs.getQuantity()));
    }
    
    // The rest of the fields are adjusted by conversions to a more derived class.
    if (MSInheritanceAttr.hasVBTableOffsetField(Inheritance)) {
      fields.push_back(ConstantInt.get(CGM.IntTy, $uint2ulong(VBTableIndex)));
    }
    
    return ConstantStruct.getAnon(new ArrayRef<Constant /*P*/ >(fields, true));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::MemberPointerConstantIsNull">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 2809,
   FQN="(anonymous namespace)::MicrosoftCXXABI::MemberPointerConstantIsNull", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI27MemberPointerConstantIsNullEPKN5clang17MemberPointerTypeEPN4llvm8ConstantE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI27MemberPointerConstantIsNullEPKN5clang17MemberPointerTypeEPN4llvm8ConstantE")
  //</editor-fold>
  private boolean MemberPointerConstantIsNull(/*const*/ MemberPointerType /*P*/ MPT, 
                             Constant /*P*/ Val) {
    // Function pointers are null if the pointer in the first field is null.
    if (MPT.isMemberFunctionPointer()) {
      Constant /*P*/ FirstField = Val.getType().isStructTy() ? Val.getAggregateElement(0/*U*/) : Val;
      return FirstField.isNullValue();
    }
    
    // If it's not a function pointer and it's zero initializable, we can easily
    // check zero.
    if (isZeroInitializable(MPT) && Val.isNullValue()) {
      return true;
    }
    
    // Otherwise, break down all the fields for comparison.  Hopefully these
    // little Constants are reused, while a big null struct might not be.
    SmallVector<Constant /*P*/ > Fields/*J*/= new SmallVector<Constant /*P*/ >(4, (Constant /*P*/ )null);
    GetNullMemberPointerFields(MPT, Fields);
    if (Fields.size() == 1) {
      assert (Val.getType().isIntegerTy());
      return Val == Fields.$at(0);
    }
    
    /*uint*/int I;
    /*uint*/int E;
    for (I = 0 , E = Fields.size(); I != E; ++I) {
      if (Val.getAggregateElement(I) != Fields.$at(I)) {
        break;
      }
    }
    return I == E;
  }

  
  /// \brief - Initialize all vbptrs of 'this' with RD as the complete type.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::EmitVBPtrStores">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 1202,
   FQN="(anonymous namespace)::MicrosoftCXXABI::EmitVBPtrStores", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI15EmitVBPtrStoresERN5clang7CodeGen15CodeGenFunctionEPKNS1_13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI15EmitVBPtrStoresERN5clang7CodeGen15CodeGenFunctionEPKNS1_13CXXRecordDeclE")
  //</editor-fold>
  private void EmitVBPtrStores(final CodeGenFunction /*&*/ CGF, 
                 /*const*/ CXXRecordDecl /*P*/ RD) {
    Address This = getThisAddress(CGF);
    This.$assignMove(CGF.Builder.CreateElementBitCast(new Address(This), CGM.Int8Ty, new Twine(/*KEEP_STR*/"this.int8")));
    final /*const*/ ASTContext /*&*/ Context = getContext();
    final /*const*/ ASTRecordLayout /*&*/ Layout = Context.getASTRecordLayout(RD);
    
    final /*const*/ VBTableGlobals /*&*/ VBGlobals = enumerateVBTables(RD);
    for (/*uint*/int I = 0, E = VBGlobals.VBTables.size(); I != E; ++I) {
      /*const*/ VPtrInfo /*P*/ VBT = ($Deref(VBGlobals.VBTables)).$at$Const(I);
      GlobalVariable /*P*/ GV = VBGlobals.Globals.$at$Const(I);
      final /*const*/ ASTRecordLayout /*&*/ SubobjectLayout = Context.getASTRecordLayout(VBT.BaseWithVPtr);
      CharUnits Offs = new CharUnits(VBT.NonVirtualOffset);
      Offs.$addassign(SubobjectLayout.getVBPtrOffset());
      if ((VBT.getVBaseWithVPtr() != null)) {
        Offs.$addassign(Layout.getVBaseClassOffset(VBT.getVBaseWithVPtr()));
      }
      Address VBPtr = CGF.Builder.CreateConstInBoundsByteGEP(new Address(This), new CharUnits(Offs));
      Value /*P*/ GVPtr = CGF.Builder.CreateConstInBoundsGEP2_32(GV.getValueType(), GV, 0, 0);
      VBPtr.$assignMove(CGF.Builder.CreateElementBitCast(new Address(VBPtr), GVPtr.getType(), 
              $add_char$ptr$C_StringRef$C(/*KEEP_STR*/"vbptr.", VBT.ReusingBase.getName())));
      CGF.Builder.CreateStore(GVPtr, new Address(VBPtr));
    }
  }

  
  /// \brief Caching wrapper around VBTableBuilder::enumerateVBTables().
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::enumerateVBTables">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 1858,
   FQN="(anonymous namespace)::MicrosoftCXXABI::enumerateVBTables", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI17enumerateVBTablesEPKN5clang13CXXRecordDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI17enumerateVBTablesEPKN5clang13CXXRecordDeclE")
  //</editor-fold>
  private /*const*/ VBTableGlobals /*&*/ enumerateVBTables(/*const*/ CXXRecordDecl /*P*/ RD) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // At this layer, we can key the cache off of a single class, which is much
      // easier than caching each vbtable individually.
      DenseMapIterator</*const*/ CXXRecordDecl /*P*/ , VBTableGlobals> Entry/*J*/= new DenseMapIterator</*const*/ CXXRecordDecl /*P*/ , VBTableGlobals>();
      boolean Added;
      final pairTypeBool<DenseMapIterator<CXXRecordDecl, VBTableGlobals>> $pair = VBTablesMap.insert_pair$KeyT$ValueT($c$.track(std.make_pair_Ptr_T(RD, $c$.track(new VBTableGlobals()))));
      $c$.clean(Entry = $pair.first);
      $c$.clean(Added = $pair.second);
      final VBTableGlobals /*&*/ VBGlobals = Entry.$arrow().second;
      if (!Added) {
        return VBGlobals;
      }
      
      final MicrosoftVTableContext /*&*/ Context = CGM.getMicrosoftVTableContext();
      VBGlobals.VBTables = $AddrOf(Context.enumerateVBTables(RD));
      
      // Cache the globals for all vbtables so we don't have to recompute the
      // mangled names.
      GlobalVariable.LinkageTypes Linkage = CGM.getVTableLinkage(RD);
      for (type$ptr<VPtrInfo /*P*/ /*const*/ /*P*/> I = $tryClone(VBGlobals.VBTables.begin$Const()), 
          /*P*/ E = $tryClone(VBGlobals.VBTables.end$Const());
           $noteq_ptr(I, E); I.$preInc()) {
        VBGlobals.Globals.push_back(getAddrOfVBTable($Deref(I.$star()), RD, Linkage));
      }
      
      return VBGlobals;
    } finally {
      $c$.$destroy();
    }
  }

  
  /// \brief Generate a thunk for calling a virtual member function MD.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::EmitVirtualMemPtrThunk">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 1885,
   FQN="(anonymous namespace)::MicrosoftCXXABI::EmitVirtualMemPtrThunk", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI22EmitVirtualMemPtrThunkEPKN5clang13CXXMethodDeclERKNS1_22MicrosoftVTableContext21MethodVFTableLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI22EmitVirtualMemPtrThunkEPKN5clang13CXXMethodDeclERKNS1_22MicrosoftVTableContext21MethodVFTableLocationE")
  //</editor-fold>
  private Function /*P*/ EmitVirtualMemPtrThunk(/*const*/ CXXMethodDecl /*P*/ MD, 
                        final /*const*/ MicrosoftVTableContext.MethodVFTableLocation /*&*/ ML) {
    raw_svector_ostream Out = null;
    CodeGenFunction CGF = null;
    FunctionArgList FunctionArgs = null;
    try {
      assert (!isa_CXXConstructorDecl(MD) && !isa_CXXDestructorDecl(MD)) : "can't form pointers to ctors or virtual dtors";
      
      // Calculate the mangled name.
      SmallString/*<256>*/ ThunkName/*J*/= new SmallString/*<256>*/(256);
      Out/*J*/= new raw_svector_ostream(ThunkName);
      getMangleContext().mangleVirtualMemPtrThunk(MD, Out);
      {
        
        // If the thunk has been generated previously, just return it.
        GlobalValue /*P*/ GV = CGM.getModule().getNamedValue(ThunkName.$StringRef());
        if ((GV != null)) {
          return cast_Function(GV);
        }
      }
      
      // Create the llvm::Function.
      final /*const*/ CGFunctionInfo /*&*/ FnInfo = CGM.getTypes().arrangeMSMemberPointerThunk(MD);
      org.llvm.ir.FunctionType /*P*/ ThunkTy = CGM.getTypes().GetFunctionType(FnInfo);
      Function /*P*/ ThunkFn = Function.Create(ThunkTy, Function.LinkageTypes.ExternalLinkage, 
          new Twine(ThunkName.str()), $AddrOf(CGM.getModule()));
      assert ($eq_StringRef(ThunkFn.getName(), ThunkName.$StringRef())) : "name was uniqued!";
      
      ThunkFn.setLinkage(MD.isExternallyVisible() ? GlobalValue.LinkageTypes.LinkOnceODRLinkage : GlobalValue.LinkageTypes.InternalLinkage);
      if (MD.isExternallyVisible()) {
        ThunkFn.setComdat(CGM.getModule().getOrInsertComdat(ThunkFn.getName()));
      }
      
      CGM.SetLLVMFunctionAttributes(MD, FnInfo, ThunkFn);
      CGM.SetLLVMFunctionAttributesForDefinition(MD, ThunkFn);
      
      // Add the "thunk" attribute so that LLVM knows that the return type is
      // meaningless. These thunks can be used to call functions with differing
      // return types, and the caller is required to cast the prototype
      // appropriately to extract the correct value.
      ThunkFn.addFnAttr(new StringRef(/*KEEP_STR*/"thunk"));
      
      // These thunks can be compared, so they are not unnamed.
      ThunkFn.setUnnamedAddr(GlobalValue.UnnamedAddr.None);
      
      // Start codegen.
      CGF/*J*/= new CodeGenFunction(CGM);
      CGF.CurGD.$assignMove(new GlobalDecl(MD));
      CGF.CurFuncIsThunk = true;
      
      // Build FunctionArgs, but only include the implicit 'this' parameter
      // declaration.
      FunctionArgs/*J*/= new FunctionArgList();
      buildThisParam(CGF, FunctionArgs);
      
      // Start defining the function.
      CGF.StartFunction(new GlobalDecl(), FnInfo.getReturnType().$QualType(), ThunkFn, FnInfo, 
          FunctionArgs, MD.getLocation(), new SourceLocation());
      EmitThisParam(CGF);
      
      // Load the vfptr and then callee from the vftable.  The callee should have
      // adjusted 'this' so that the vfptr is at offset zero.
      Value /*P*/ VTable = CGF.GetVTablePtr(getThisAddress(CGF), ThunkTy.getPointerTo().getPointerTo(), MD.getParent$Const());
      
      Value /*P*/ VFuncPtr = CGF.Builder.CreateConstInBoundsGEP1_64(VTable, ML.Index, new Twine(/*KEEP_STR*/"vfn"));
      Value /*P*/ Callee = CGF.Builder.CreateAlignedLoad(VFuncPtr, CGF.getPointerAlign());
      
      CGF.EmitMustTailThunk(MD, getThisValue(CGF), Callee);
      
      return ThunkFn;
    } finally {
      if (FunctionArgs != null) { FunctionArgs.$destroy(); }
      if (CGF != null) { CGF.$destroy(); }
      if (Out != null) { Out.$destroy(); }
    }
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::ConvertMemberPointerType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 2509,
   FQN="(anonymous namespace)::MicrosoftCXXABI::ConvertMemberPointerType", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI24ConvertMemberPointerTypeEPKN5clang17MemberPointerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI24ConvertMemberPointerTypeEPKN5clang17MemberPointerTypeE")
  //</editor-fold>
  @Override public org.llvm.ir.Type /*P*/ ConvertMemberPointerType(/*const*/ MemberPointerType /*P*/ MPT)/* override*/ {
    /*const*/ CXXRecordDecl /*P*/ RD = MPT.getMostRecentCXXRecordDecl();
    MSInheritanceAttr.Spelling Inheritance = RD.getMSInheritanceModel();
    SmallVector<org.llvm.ir.Type /*P*/ > fields/*J*/= new SmallVector<org.llvm.ir.Type /*P*/ >(4, (org.llvm.ir.Type /*P*/ )null);
    if (MPT.isMemberFunctionPointer()) {
      fields.push_back(CGM.Unnamed_field9.VoidPtrTy); // FunctionPointerOrVirtualThunk
    } else {
      fields.push_back(CGM.IntTy); // FieldOffset
    }
    if (MSInheritanceAttr.hasNVOffsetField(MPT.isMemberFunctionPointer(), 
        Inheritance)) {
      fields.push_back(CGM.IntTy);
    }
    if (MSInheritanceAttr.hasVBPtrOffsetField(Inheritance)) {
      fields.push_back(CGM.IntTy);
    }
    if (MSInheritanceAttr.hasVBTableOffsetField(Inheritance)) {
      fields.push_back(CGM.IntTy); // VirtualBaseAdjustmentOffset
    }
    if (fields.size() == 1) {
      return fields.$at(0);
    }
    return StructType.get(CGM.getLLVMContext(), new ArrayRef<org.llvm.ir.Type /*P*/ >(fields, true));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::isZeroInitializable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 2494,
   FQN="(anonymous namespace)::MicrosoftCXXABI::isZeroInitializable", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI19isZeroInitializableEPKN5clang17MemberPointerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI19isZeroInitializableEPKN5clang17MemberPointerTypeE")
  //</editor-fold>
  @Override public boolean isZeroInitializable(/*const*/ MemberPointerType /*P*/ MPT)/* override*/ {
    // Null-ness for function memptrs only depends on the first field, which is
    // the function pointer.  The rest don't matter, so we can zero initialize.
    if (MPT.isMemberFunctionPointer()) {
      return true;
    }
    
    // The virtual base adjustment field is always -1 for null, so if we have one
    // we can't zero initialize.  The field offset is sometimes also -1 if 0 is a
    // valid field offset.
    /*const*/ CXXRecordDecl /*P*/ RD = MPT.getMostRecentCXXRecordDecl();
    MSInheritanceAttr.Spelling Inheritance = RD.getMSInheritanceModel();
    return (!MSInheritanceAttr.hasVBTableOffsetField(Inheritance)
       && RD.nullFieldOffsetIsZero());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::isMemberPointerConvertible">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 618,
   FQN="(anonymous namespace)::MicrosoftCXXABI::isMemberPointerConvertible", NM="_ZNK12_GLOBAL__N_115MicrosoftCXXABI26isMemberPointerConvertibleEPKN5clang17MemberPointerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZNK12_GLOBAL__N_115MicrosoftCXXABI26isMemberPointerConvertibleEPKN5clang17MemberPointerTypeE")
  //</editor-fold>
  @Override public boolean isMemberPointerConvertible(/*const*/ MemberPointerType /*P*/ MPT) /*const*//* override*/ {
    /*const*/ CXXRecordDecl /*P*/ RD = MPT.getMostRecentCXXRecordDecl();
    return RD.hasAttr(MSInheritanceAttr.class);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::EmitNullMemberPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 2557,
   FQN="(anonymous namespace)::MicrosoftCXXABI::EmitNullMemberPointer", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI21EmitNullMemberPointerEPKN5clang17MemberPointerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI21EmitNullMemberPointerEPKN5clang17MemberPointerTypeE")
  //</editor-fold>
  @Override public Constant /*P*/ EmitNullMemberPointer(/*const*/ MemberPointerType /*P*/ MPT)/* override*/ {
    SmallVector<Constant /*P*/ > fields/*J*/= new SmallVector<Constant /*P*/ >(4, (Constant /*P*/ )null);
    GetNullMemberPointerFields(MPT, fields);
    if (fields.size() == 1) {
      return fields.$at(0);
    }
    Constant /*P*/ Res = ConstantStruct.getAnon(new ArrayRef<Constant /*P*/ >(fields, true));
    assert (Res.getType() == ConvertMemberPointerType(MPT));
    return Res;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::EmitMemberDataPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 2602,
   FQN="(anonymous namespace)::MicrosoftCXXABI::EmitMemberDataPointer", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI21EmitMemberDataPointerEPKN5clang17MemberPointerTypeENS1_9CharUnitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI21EmitMemberDataPointerEPKN5clang17MemberPointerTypeENS1_9CharUnitsE")
  //</editor-fold>
  @Override public Constant /*P*/ EmitMemberDataPointer(/*const*/ MemberPointerType /*P*/ MPT, 
                       CharUnits offset)/* override*/ {
    /*const*/ CXXRecordDecl /*P*/ RD = MPT.getMostRecentCXXRecordDecl();
    if (RD.getMSInheritanceModel()
       == MSInheritanceAttr.Spelling.Keyword_virtual_inheritance) {
      offset.$minusassign(getContext().getOffsetOfBaseWithVBPtr(RD));
    }
    Constant /*P*/ FirstField = ConstantInt.get(CGM.IntTy, offset.getQuantity());
    return EmitFullMemberPointer(FirstField, /*IsMemberFunction=*/ false, RD, 
        CharUnits.Zero(), /*VBTableIndex=*/ 0);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::EmitMemberFunctionPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 2669,
   FQN="(anonymous namespace)::MicrosoftCXXABI::EmitMemberFunctionPointer", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI25EmitMemberFunctionPointerEPKN5clang13CXXMethodDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI25EmitMemberFunctionPointerEPKN5clang13CXXMethodDeclE")
  //</editor-fold>
  @Override public Constant /*P*/ EmitMemberFunctionPointer(/*const*/ CXXMethodDecl /*P*/ MD)/* override*/ {
    assert (MD.isInstance()) : "Member function must not be static!";
    
    MD = MD.getCanonicalDecl$Const();
    CharUnits NonVirtualBaseAdjustment = CharUnits.Zero();
    /*const*/ CXXRecordDecl /*P*/ RD = MD.getParent$Const().getMostRecentDecl$Const();
    final CodeGenTypes /*&*/ Types = CGM.getTypes();
    
    /*uint*/int VBTableIndex = 0;
    Constant /*P*/ FirstField;
    /*const*/ FunctionProtoType /*P*/ FPT = MD.getType().$arrow().castAs(FunctionProtoType.class);
    if (!MD.isVirtual()) {
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
      FirstField = CGM.GetAddrOfFunction(new GlobalDecl(MD), Ty);
    } else {
      final MicrosoftVTableContext /*&*/ VTableContext = CGM.getMicrosoftVTableContext();
      MicrosoftVTableContext.MethodVFTableLocation ML = new MicrosoftVTableContext.MethodVFTableLocation(VTableContext.getMethodVFTableLocation(new GlobalDecl(MD)));
      FirstField = EmitVirtualMemPtrThunk(MD, ML);
      // Include the vfptr adjustment if the method is in a non-primary vftable.
      NonVirtualBaseAdjustment.$addassign(ML.VFPtrOffset);
      if ((ML.VBase != null)) {
        VBTableIndex = VTableContext.getVBTableIndex(RD, ML.VBase) * 4;
      }
    }
    if (VBTableIndex == 0
       && RD.getMSInheritanceModel()
       == MSInheritanceAttr.Spelling.Keyword_virtual_inheritance) {
      NonVirtualBaseAdjustment.$minusassign(getContext().getOffsetOfBaseWithVBPtr(RD));
    }
    
    // The rest of the fields are common with data member pointers.
    FirstField = ConstantExpr.getBitCast(FirstField, CGM.Unnamed_field9.VoidPtrTy);
    return EmitFullMemberPointer(FirstField, /*IsMemberFunction=*/ true, RD, 
        new CharUnits(NonVirtualBaseAdjustment), VBTableIndex);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::EmitMemberPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 2615,
   FQN="(anonymous namespace)::MicrosoftCXXABI::EmitMemberPointer", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI17EmitMemberPointerERKN5clang7APValueENS1_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI17EmitMemberPointerERKN5clang7APValueENS1_8QualTypeE")
  //</editor-fold>
  @Override public Constant /*P*/ EmitMemberPointer(final /*const*/ APValue /*&*/ MP, 
                   QualType MPType)/* override*/ {
    /*const*/ MemberPointerType /*P*/ DstTy = MPType.$arrow().castAs(MemberPointerType.class);
    /*const*/ ValueDecl /*P*/ MPD = MP.getMemberPointerDecl();
    if (!(MPD != null)) {
      return EmitNullMemberPointer(DstTy);
    }
    
    final ASTContext /*&*/ Ctx = getContext();
    ArrayRef</*const*/ CXXRecordDecl /*P*/ > MemberPointerPath = MP.getMemberPointerPath();
    
    Constant /*P*/ C;
    {
      /*const*/ CXXMethodDecl /*P*/ MD = dyn_cast_CXXMethodDecl(MPD);
      if ((MD != null)) {
        C = EmitMemberFunctionPointer(MD);
      } else {
        CharUnits FieldOffset = Ctx.toCharUnitsFromBits(Ctx.getFieldOffset(MPD));
        C = EmitMemberDataPointer(DstTy, new CharUnits(FieldOffset));
      }
    }
    if (!MemberPointerPath.empty()) {
      /*const*/ CXXRecordDecl /*P*/ SrcRD = cast_CXXRecordDecl(MPD.getDeclContext$Const());
      /*const*/ org.clang.ast.Type /*P*/ SrcRecTy = Ctx.getTypeDeclType(SrcRD).getTypePtr();
      /*const*/ MemberPointerType /*P*/ SrcTy = Ctx.getMemberPointerType(DstTy.getPointeeType(), SrcRecTy).$arrow().castAs(MemberPointerType.class);
      
      boolean DerivedMember = MP.isMemberPointerToDerivedMember();
      SmallVector</*const*/ CXXBaseSpecifier /*P*/ > DerivedToBasePath/*J*/= new SmallVector</*const*/ CXXBaseSpecifier /*P*/ >(4, (/*const*/ CXXBaseSpecifier /*P*/ )null);
      /*const*/ CXXRecordDecl /*P*/ PrevRD = SrcRD;
      for (/*const*/ CXXRecordDecl /*P*/ PathElem : MemberPointerPath) {
        /*const*/ CXXRecordDecl /*P*/ Base = null;
        /*const*/ CXXRecordDecl /*P*/ Derived = null;
        if (DerivedMember) {
          Base = PathElem;
          Derived = PrevRD;
        } else {
          Base = PrevRD;
          Derived = PathElem;
        }
        for (final /*const*/ CXXBaseSpecifier /*&*/ BS : Derived.bases$Const())  {
          if (BS.getType().$arrow().getAsCXXRecordDecl().getCanonicalDecl()
             == Base.getCanonicalDecl$Const()) {
            DerivedToBasePath.push_back($AddrOf(BS));
          }
        }
        PrevRD = PathElem;
      }
      assert (DerivedToBasePath.size() == MemberPointerPath.size());
      
      CastKind CK = DerivedMember ? CastKind.CK_DerivedToBaseMemberPointer : CastKind.CK_BaseToDerivedMemberPointer;
      C = EmitMemberPointerConversion(SrcTy, DstTy, CK, DerivedToBasePath.begin(), 
          DerivedToBasePath.end(), C);
    }
    return C;
  }

  
  
  /// Member pointers are the same if they're either bitwise identical *or* both
  /// null.  Null-ness for function members is determined by the first field,
  /// while for data member pointers we must compare all fields.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::EmitMemberPointerComparison">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 2718,
   FQN="(anonymous namespace)::MicrosoftCXXABI::EmitMemberPointerComparison", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI27EmitMemberPointerComparisonERN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueES7_PKNS1_17MemberPointerTypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI27EmitMemberPointerComparisonERN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueES7_PKNS1_17MemberPointerTypeEb")
  //</editor-fold>
  @Override public Value /*P*/ EmitMemberPointerComparison(final CodeGenFunction /*&*/ CGF, 
                             Value /*P*/ L, 
                             Value /*P*/ R, 
                             /*const*/ MemberPointerType /*P*/ MPT, 
                             boolean Inequality)/* override*/ {
    final CGBuilderTy /*&*/ Builder = CGF.Builder;
    
    // Handle != comparisons by switching the sense of all boolean operations.
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
    
    // If this is a single field member pointer (single inheritance), this is a
    // single icmp.
    /*const*/ CXXRecordDecl /*P*/ RD = MPT.getMostRecentCXXRecordDecl();
    MSInheritanceAttr.Spelling Inheritance = RD.getMSInheritanceModel();
    if (MSInheritanceAttr.hasOnlyOneField(MPT.isMemberFunctionPointer(), 
        Inheritance)) {
      return Builder.CreateICmp(Eq, L, R);
    }
    
    // Compare the first field.
    Value /*P*/ L0 = Builder.CreateExtractValue(L, new ArrayRefUInt(0), new Twine(/*KEEP_STR*/"lhs.0"));
    Value /*P*/ R0 = Builder.CreateExtractValue(R, new ArrayRefUInt(0), new Twine(/*KEEP_STR*/"rhs.0"));
    Value /*P*/ Cmp0 = Builder.CreateICmp(Eq, L0, R0, new Twine(/*KEEP_STR*/"memptr.cmp.first"));
    
    // Compare everything other than the first field.
    Value /*P*/ Res = null;
    StructType /*P*/ LType = cast_StructType(L.getType());
    for (/*uint*/int I = 1, E = LType.getNumElements(); I != E; ++I) {
      Value /*P*/ LF = Builder.CreateExtractValue(L, new ArrayRefUInt(I));
      Value /*P*/ RF = Builder.CreateExtractValue(R, new ArrayRefUInt(I));
      Value /*P*/ Cmp = Builder.CreateICmp(Eq, LF, RF, new Twine(/*KEEP_STR*/"memptr.cmp.rest"));
      if ((Res != null)) {
        Res = Builder.CreateBinOp(And, Res, Cmp);
      } else {
        Res = Cmp;
      }
    }
    
    // Check if the first field is 0 if this is a function pointer.
    if (MPT.isMemberFunctionPointer()) {
      // (l1 == r1 && ...) || l0 == 0
      Value /*P*/ Zero = Constant.getNullValue(L0.getType());
      Value /*P*/ IsZero = Builder.CreateICmp(Eq, L0, Zero, new Twine(/*KEEP_STR*/"memptr.cmp.iszero"));
      Res = Builder.CreateBinOp(Or, Res, IsZero);
    }
    
    // Combine the comparison of the first field, which must always be true for
    // this comparison to succeeed.
    return Builder.CreateBinOp(And, Res, Cmp0, new Twine(/*KEEP_STR*/"memptr.cmp"));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::EmitMemberPointerIsNotNull">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 2778,
   FQN="(anonymous namespace)::MicrosoftCXXABI::EmitMemberPointerIsNotNull", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI26EmitMemberPointerIsNotNullERN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueEPKNS1_17MemberPointerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI26EmitMemberPointerIsNotNullERN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueEPKNS1_17MemberPointerTypeE")
  //</editor-fold>
  @Override public Value /*P*/ EmitMemberPointerIsNotNull(final CodeGenFunction /*&*/ CGF, 
                            Value /*P*/ MemPtr, 
                            /*const*/ MemberPointerType /*P*/ MPT)/* override*/ {
    final CGBuilderTy /*&*/ Builder = CGF.Builder;
    SmallVector<Constant /*P*/ > fields/*J*/= new SmallVector<Constant /*P*/ >(4, (Constant /*P*/ )null);
    // We only need one field for member functions.
    if (MPT.isMemberFunctionPointer()) {
      fields.push_back(Constant.getNullValue(CGM.Unnamed_field9.VoidPtrTy));
    } else {
      GetNullMemberPointerFields(MPT, fields);
    }
    assert (!fields.empty());
    Value /*P*/ FirstField = MemPtr;
    if (MemPtr.getType().isStructTy()) {
      FirstField = Builder.CreateExtractValue(MemPtr, new ArrayRefUInt(0));
    }
    Value /*P*/ Res = Builder.CreateICmpNE(FirstField, fields.$at(0), new Twine(/*KEEP_STR*/"memptr.cmp0"));
    
    // For function member pointers, we only need to test the function pointer
    // field.  The other fields if any can be garbage.
    if (MPT.isMemberFunctionPointer()) {
      return Res;
    }
    
    // Otherwise, emit a series of compares and combine the results.
    for (int I = 1, E = fields.size(); I < E; ++I) {
      Value /*P*/ Field = Builder.CreateExtractValue(MemPtr, new ArrayRefUInt(I));
      Value /*P*/ Next = Builder.CreateICmpNE(Field, fields.$at(I), new Twine(/*KEEP_STR*/"memptr.cmp"));
      Res = Builder.CreateOr(Res, Next, new Twine(/*KEEP_STR*/"memptr.tobool"));
    }
    return Res;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::EmitMemberDataPointerAddress">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 2935,
   FQN="(anonymous namespace)::MicrosoftCXXABI::EmitMemberDataPointerAddress", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI28EmitMemberDataPointerAddressERN5clang7CodeGen15CodeGenFunctionEPKNS1_4ExprENS2_7AddressEPN4llvm5ValueEPKNS1_17MemberPointerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI28EmitMemberDataPointerAddressERN5clang7CodeGen15CodeGenFunctionEPKNS1_4ExprENS2_7AddressEPN4llvm5ValueEPKNS1_17MemberPointerTypeE")
  //</editor-fold>
  @Override public Value /*P*/ EmitMemberDataPointerAddress(final CodeGenFunction /*&*/ CGF, /*const*/ Expr /*P*/ E, Address Base, Value /*P*/ MemPtr, 
                              /*const*/ MemberPointerType /*P*/ MPT)/* override*/ {
    assert (MPT.isMemberDataPointer());
    /*uint*/int AS = Base.getAddressSpace();
    org.llvm.ir.Type /*P*/ PType = CGF.ConvertTypeForMem(MPT.getPointeeType()).getPointerTo(AS);
    final CGBuilderTy /*&*/ Builder = CGF.Builder;
    /*const*/ CXXRecordDecl /*P*/ RD = MPT.getMostRecentCXXRecordDecl();
    MSInheritanceAttr.Spelling Inheritance = RD.getMSInheritanceModel();
    
    // Extract the fields we need, regardless of model.  We'll apply them if we
    // have them.
    Value /*P*/ FieldOffset = MemPtr;
    Value /*P*/ VirtualBaseAdjustmentOffset = null;
    Value /*P*/ VBPtrOffset = null;
    if (MemPtr.getType().isStructTy()) {
      // We need to extract values.
      /*uint*/int I = 0;
      FieldOffset = Builder.CreateExtractValue(MemPtr, new ArrayRefUInt(I++));
      if (MSInheritanceAttr.hasVBPtrOffsetField(Inheritance)) {
        VBPtrOffset = Builder.CreateExtractValue(MemPtr, new ArrayRefUInt(I++));
      }
      if (MSInheritanceAttr.hasVBTableOffsetField(Inheritance)) {
        VirtualBaseAdjustmentOffset = Builder.CreateExtractValue(MemPtr, new ArrayRefUInt(I++));
      }
    }
    
    Value /*P*/ Addr;
    if ((VirtualBaseAdjustmentOffset != null)) {
      Addr = AdjustVirtualBase(CGF, E, RD, new Address(Base), VirtualBaseAdjustmentOffset, 
          VBPtrOffset);
    } else {
      Addr = Base.getPointer();
    }
    
    // Cast to char*.
    Addr = Builder.CreateBitCast(Addr, CGF.Int8Ty.getPointerTo(AS));
    
    // Apply the offset, which we assume is non-null.
    Addr = Builder.CreateInBoundsGEP(Addr, new ArrayRef<Value /*P*/ >(FieldOffset, true), new Twine(/*KEEP_STR*/"memptr.offset"));
    
    // Cast the address to the appropriate pointer type, adopting the address
    // space of the base pointer.
    return Builder.CreateBitCast(Addr, PType);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::EmitNonNullMemberPointerConversion">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 3045,
   FQN="(anonymous namespace)::MicrosoftCXXABI::EmitNonNullMemberPointerConversion", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI34EmitNonNullMemberPointerConversionEPKN5clang17MemberPointerTypeES4_NS1_8CastKindEPKPKNS1_16CXXBaseSpecifierESA_PN4llvm5ValueERNS1_7CodeGen11CGBuilderTyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI34EmitNonNullMemberPointerConversionEPKN5clang17MemberPointerTypeES4_NS1_8CastKindEPKPKNS1_16CXXBaseSpecifierESA_PN4llvm5ValueERNS1_7CodeGen11CGBuilderTyE")
  //</editor-fold>
  public Value /*P*/ EmitNonNullMemberPointerConversion(/*const*/ MemberPointerType /*P*/ SrcTy, /*const*/ MemberPointerType /*P*/ DstTy, CastKind CK, 
                                    type$ptr</*const*/ CXXBaseSpecifier /*P*/ /*const*/ /*P*/> PathBegin, 
                                    type$ptr</*const*/ CXXBaseSpecifier /*P*/ /*const*/ /*P*/> PathEnd, Value /*P*/ Src, 
                                    final CGBuilderTy /*&*/ Builder) {
    /*const*/ CXXRecordDecl /*P*/ SrcRD = SrcTy.getMostRecentCXXRecordDecl();
    /*const*/ CXXRecordDecl /*P*/ DstRD = DstTy.getMostRecentCXXRecordDecl();
    MSInheritanceAttr.Spelling SrcInheritance = SrcRD.getMSInheritanceModel();
    MSInheritanceAttr.Spelling DstInheritance = DstRD.getMSInheritanceModel();
    final boolean IsFunc = SrcTy.isMemberFunctionPointer();
    boolean IsConstant = isa_Constant(Src);
    
    // Decompose src.
    type$ptr<Value> /*P*/ FirstField = create_type$ptr(Src);
    type$ptr<Value> /*P*/ NonVirtualBaseAdjustment = create_type$ptr(getZeroInt());
    Value /*P*/ VirtualBaseAdjustmentOffset = getZeroInt();
    Value /*P*/ VBPtrOffset = getZeroInt();
    if (!MSInheritanceAttr.hasOnlyOneField(IsFunc, SrcInheritance)) {
      // We need to extract values.
      /*uint*/int I = 0;
      FirstField = create_type$ptr(Builder.CreateExtractValue(Src, new ArrayRefUInt(I++)));
      if (MSInheritanceAttr.hasNVOffsetField(IsFunc, SrcInheritance)) {
        NonVirtualBaseAdjustment = create_type$ptr(Builder.CreateExtractValue(Src, new ArrayRefUInt(I++)));
      }
      if (MSInheritanceAttr.hasVBPtrOffsetField(SrcInheritance)) {
        VBPtrOffset = Builder.CreateExtractValue(Src, new ArrayRefUInt(I++));
      }
      if (MSInheritanceAttr.hasVBTableOffsetField(SrcInheritance)) {
        VirtualBaseAdjustmentOffset = Builder.CreateExtractValue(Src, new ArrayRefUInt(I++));
      }
    }
    
    boolean IsDerivedToBase = (CK == CastKind.CK_DerivedToBaseMemberPointer);
    /*const*/ MemberPointerType /*P*/ DerivedTy = IsDerivedToBase ? SrcTy : DstTy;
    /*const*/ CXXRecordDecl /*P*/ DerivedClass = DerivedTy.getMostRecentCXXRecordDecl();
    
    // For data pointers, we adjust the field offset directly.  For functions, we
    // have a separate field.
    final type$ref<Value /*P*/ /*&*/> NVAdjustField = IsFunc ? NonVirtualBaseAdjustment.star$ref() : FirstField.star$ref();
    
    // The virtual inheritance model has a quirk: the virtual base table is always
    // referenced when dereferencing a member pointer even if the member pointer
    // is non-virtual.  This is accounted for by adjusting the non-virtual offset
    // to point backwards to the top of the MDC from the first VBase.  Undo this
    // adjustment to normalize the member pointer.
    Value /*P*/ SrcVBIndexEqZero = Builder.CreateICmpEQ(VirtualBaseAdjustmentOffset, getZeroInt());
    if (SrcInheritance == MSInheritanceAttr.Spelling.Keyword_virtual_inheritance) {
      {
        long/*int64_t*/ SrcOffsetToFirstVBase = getContext().getOffsetOfBaseWithVBPtr(SrcRD).getQuantity();
        if ((SrcOffsetToFirstVBase != 0)) {
          Value /*P*/ UndoSrcAdjustment = Builder.CreateSelect(SrcVBIndexEqZero, 
              ConstantInt.get(CGM.IntTy, SrcOffsetToFirstVBase), 
              getZeroInt());
          NVAdjustField.$set(Builder.CreateNSWAdd(NVAdjustField.$deref(), UndoSrcAdjustment));
        }
      }
    }
    
    // A non-zero vbindex implies that we are dealing with a source member in a
    // floating virtual base in addition to some non-virtual offset.  If the
    // vbindex is zero, we are dealing with a source that exists in a non-virtual,
    // fixed, base.  The difference between these two cases is that the vbindex +
    // nvoffset *always* point to the member regardless of what context they are
    // evaluated in so long as the vbindex is adjusted.  A member inside a fixed
    // base requires explicit nv adjustment.
    Constant /*P*/ BaseClassOffset = ConstantInt.get(CGM.IntTy, 
        CGM.computeNonVirtualBaseClassOffset(DerivedClass, PathBegin, PathEnd).
            getQuantity());
    
    Value /*P*/ NVDisp;
    if (IsDerivedToBase) {
      NVDisp = Builder.CreateNSWSub(NVAdjustField.$deref(), BaseClassOffset, new Twine(/*KEEP_STR*/"adj"));
    } else {
      NVDisp = Builder.CreateNSWAdd(NVAdjustField.$deref(), BaseClassOffset, new Twine(/*KEEP_STR*/"adj"));
    }
    
    NVAdjustField.$set(Builder.CreateSelect(SrcVBIndexEqZero, NVDisp, getZeroInt()));
    
    // Update the vbindex to an appropriate value in the destination because
    // SrcRD's vbtable might not be a strict prefix of the one in DstRD.
    Value /*P*/ DstVBIndexEqZero = SrcVBIndexEqZero;
    if (MSInheritanceAttr.hasVBTableOffsetField(DstInheritance)
       && MSInheritanceAttr.hasVBTableOffsetField(SrcInheritance)) {
      {
        GlobalVariable /*P*/ VDispMap = getAddrOfVirtualDisplacementMap(SrcRD, DstRD);
        if ((VDispMap != null)) {
          Value /*P*/ VBIndex = Builder.CreateExactUDiv(VirtualBaseAdjustmentOffset, ConstantInt.get(CGM.IntTy, $int2ulong(4)));
          if (IsConstant) {
            Constant /*P*/ Mapping = VDispMap.getInitializer();
            VirtualBaseAdjustmentOffset
               = Mapping.getAggregateElement(cast_Constant(VBIndex));
          } else {
            Value /*P*/ Idxs[/*2*/] = new Value /*P*/  [/*2*/] {getZeroInt(), VBIndex};
            VirtualBaseAdjustmentOffset
               = Builder.CreateAlignedLoad(Builder.CreateInBoundsGEP(VDispMap, new ArrayRef<Value /*P*/ >(Idxs, true)), 
                CharUnits.fromQuantity(4));
          }
          
          DstVBIndexEqZero
             = Builder.CreateICmpEQ(VirtualBaseAdjustmentOffset, getZeroInt());
        }
      }
    }
    
    // Set the VBPtrOffset to zero if the vbindex is zero.  Otherwise, initialize
    // it to the offset of the vbptr.
    if (MSInheritanceAttr.hasVBPtrOffsetField(DstInheritance)) {
      Value /*P*/ DstVBPtrOffset = ConstantInt.get(CGM.IntTy, 
          getContext().getASTRecordLayout(DstRD).getVBPtrOffset().getQuantity());
      VBPtrOffset
         = Builder.CreateSelect(DstVBIndexEqZero, getZeroInt(), DstVBPtrOffset);
    }
    
    // Likewise, apply a similar adjustment so that dereferencing the member
    // pointer correctly accounts for the distance between the start of the first
    // virtual base and the top of the MDC.
    if (DstInheritance == MSInheritanceAttr.Spelling.Keyword_virtual_inheritance) {
      {
        long/*int64_t*/ DstOffsetToFirstVBase = getContext().getOffsetOfBaseWithVBPtr(DstRD).getQuantity();
        if ((DstOffsetToFirstVBase != 0)) {
          Value /*P*/ DoDstAdjustment = Builder.CreateSelect(DstVBIndexEqZero, 
              ConstantInt.get(CGM.IntTy, DstOffsetToFirstVBase), 
              getZeroInt());
          NVAdjustField.$set(Builder.CreateNSWSub(NVAdjustField.$deref(), DoDstAdjustment));
        }
      }
    }
    
    // Recompose dst from the null struct and the adjusted fields from src.
    Value /*P*/ Dst;
    if (MSInheritanceAttr.hasOnlyOneField(IsFunc, DstInheritance)) {
      Dst = FirstField.$star();
    } else {
      Dst = UndefValue.get(ConvertMemberPointerType(DstTy));
      /*uint*/int Idx = 0;
      Dst = Builder.CreateInsertValue(Dst, FirstField.$star(), new ArrayRefUInt(Idx++));
      if (MSInheritanceAttr.hasNVOffsetField(IsFunc, DstInheritance)) {
        Dst = Builder.CreateInsertValue(Dst, NonVirtualBaseAdjustment.$star(), new ArrayRefUInt(Idx++));
      }
      if (MSInheritanceAttr.hasVBPtrOffsetField(DstInheritance)) {
        Dst = Builder.CreateInsertValue(Dst, VBPtrOffset, new ArrayRefUInt(Idx++));
      }
      if (MSInheritanceAttr.hasVBTableOffsetField(DstInheritance)) {
        Dst = Builder.CreateInsertValue(Dst, VirtualBaseAdjustmentOffset, new ArrayRefUInt(Idx++));
      }
    }
    return Dst;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::EmitMemberPointerConversion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 2980,
   FQN="(anonymous namespace)::MicrosoftCXXABI::EmitMemberPointerConversion", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI27EmitMemberPointerConversionERN5clang7CodeGen15CodeGenFunctionEPKNS1_8CastExprEPN4llvm5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI27EmitMemberPointerConversionERN5clang7CodeGen15CodeGenFunctionEPKNS1_8CastExprEPN4llvm5ValueE")
  //</editor-fold>
  @Override public Value /*P*/ EmitMemberPointerConversion(final CodeGenFunction /*&*/ CGF, 
                             /*const*/ CastExpr /*P*/ E, 
                             Value /*P*/ Src)/* override*/ {
    assert (E.getCastKind() == CastKind.CK_DerivedToBaseMemberPointer || E.getCastKind() == CastKind.CK_BaseToDerivedMemberPointer || E.getCastKind() == CastKind.CK_ReinterpretMemberPointer);
    
    // Use constant emission if we can.
    if (isa_Constant(Src)) {
      return EmitMemberPointerConversion(E, cast_Constant(Src));
    }
    
    // We may be adding or dropping fields from the member pointer, so we need
    // both types and the inheritance models of both records.
    /*const*/ MemberPointerType /*P*/ SrcTy = E.getSubExpr$Const().getType().$arrow().castAs(MemberPointerType.class);
    /*const*/ MemberPointerType /*P*/ DstTy = E.getType().$arrow().castAs(MemberPointerType.class);
    boolean IsFunc = SrcTy.isMemberFunctionPointer();
    
    // If the classes use the same null representation, reinterpret_cast is a nop.
    boolean IsReinterpret = E.getCastKind() == CastKind.CK_ReinterpretMemberPointer;
    if (IsReinterpret && IsFunc) {
      return Src;
    }
    
    CXXRecordDecl /*P*/ SrcRD = SrcTy.getMostRecentCXXRecordDecl();
    CXXRecordDecl /*P*/ DstRD = DstTy.getMostRecentCXXRecordDecl();
    if (IsReinterpret
       && SrcRD.nullFieldOffsetIsZero() == DstRD.nullFieldOffsetIsZero()) {
      return Src;
    }
    
    final CGBuilderTy /*&*/ Builder = CGF.Builder;
    
    // Branch past the conversion if Src is null.
    Value /*P*/ IsNotNull = EmitMemberPointerIsNotNull(CGF, Src, SrcTy);
    Constant /*P*/ DstNull = EmitNullMemberPointer(DstTy);
    
    // C++ 5.2.10p9: The null member pointer value is converted to the null member
    //   pointer value of the destination type.
    if (IsReinterpret) {
      // For reinterpret casts, sema ensures that src and dst are both functions
      // or data and have the same size, which means the LLVM types should match.
      assert (Src.getType() == DstNull.getType());
      return Builder.CreateSelect(IsNotNull, Src, DstNull);
    }
    
    BasicBlock /*P*/ OriginalBB = Builder.GetInsertBlock();
    BasicBlock /*P*/ ConvertBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"memptr.convert"));
    BasicBlock /*P*/ ContinueBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"memptr.converted"));
    Builder.CreateCondBr(IsNotNull, ConvertBB, ContinueBB);
    CGF.EmitBlock(ConvertBB);
    
    Value /*P*/ Dst = EmitNonNullMemberPointerConversion(SrcTy, DstTy, E.getCastKind(), E.path_begin$Const(), E.path_end$Const(), Src, 
        Builder);
    
    Builder.CreateBr(ContinueBB);
    
    // In the continuation, choose between DstNull and Dst.
    CGF.EmitBlock(ContinueBB);
    PHINode /*P*/ Phi = Builder.CreatePHI(DstNull.getType(), 2, new Twine(/*KEEP_STR*/"memptr.converted"));
    Phi.addIncoming(DstNull, OriginalBB);
    Phi.addIncoming(Dst, ConvertBB);
    return Phi;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::EmitMemberPointerConversion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 3187,
   FQN="(anonymous namespace)::MicrosoftCXXABI::EmitMemberPointerConversion", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI27EmitMemberPointerConversionEPKN5clang8CastExprEPN4llvm8ConstantE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI27EmitMemberPointerConversionEPKN5clang8CastExprEPN4llvm8ConstantE")
  //</editor-fold>
  @Override public Constant /*P*/ EmitMemberPointerConversion(/*const*/ CastExpr /*P*/ E, 
                             Constant /*P*/ Src)/* override*/ {
    /*const*/ MemberPointerType /*P*/ SrcTy = E.getSubExpr$Const().getType().$arrow().castAs(MemberPointerType.class);
    /*const*/ MemberPointerType /*P*/ DstTy = E.getType().$arrow().castAs(MemberPointerType.class);
    
    CastKind CK = E.getCastKind();
    
    return EmitMemberPointerConversion(SrcTy, DstTy, CK, E.path_begin$Const(), 
        E.path_end$Const(), Src);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::EmitMemberPointerConversion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 3200,
   FQN="(anonymous namespace)::MicrosoftCXXABI::EmitMemberPointerConversion", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI27EmitMemberPointerConversionEPKN5clang17MemberPointerTypeES4_NS1_8CastKindEPKPKNS1_16CXXBaseSpecifierESA_PN4llvm8ConstantE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI27EmitMemberPointerConversionEPKN5clang17MemberPointerTypeES4_NS1_8CastKindEPKPKNS1_16CXXBaseSpecifierESA_PN4llvm8ConstantE")
  //</editor-fold>
  public Constant /*P*/ EmitMemberPointerConversion(/*const*/ MemberPointerType /*P*/ SrcTy, /*const*/ MemberPointerType /*P*/ DstTy, CastKind CK, 
                             type$ptr</*const*/ CXXBaseSpecifier /*P*/ /*const*/ /*P*/> PathBegin, 
                             type$ptr</*const*/ CXXBaseSpecifier /*P*/ /*const*/ /*P*/> PathEnd, Constant /*P*/ Src) {
    CGBuilderTy Builder = null;
    try {
      assert (CK == CastKind.CK_DerivedToBaseMemberPointer || CK == CastKind.CK_BaseToDerivedMemberPointer || CK == CastKind.CK_ReinterpretMemberPointer);
      // If src is null, emit a new null for dst.  We can't return src because dst
      // might have a new representation.
      if (MemberPointerConstantIsNull(SrcTy, Src)) {
        return EmitNullMemberPointer(DstTy);
      }
      
      // We don't need to do anything for reinterpret_casts of non-null member
      // pointers.  We should only get here when the two type representations have
      // the same size.
      if (CK == CastKind.CK_ReinterpretMemberPointer) {
        return Src;
      }
      
      Builder/*J*/= new CGBuilderTy(CGM, CGM.getLLVMContext());
      Constant /*P*/ Dst = cast_Constant(EmitNonNullMemberPointerConversion(SrcTy, DstTy, CK, PathBegin, PathEnd, Src, Builder));
      
      return Dst;
    } finally {
      if (Builder != null) { Builder.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::EmitLoadOfMemberFunctionPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 3225,
   FQN="(anonymous namespace)::MicrosoftCXXABI::EmitLoadOfMemberFunctionPointer", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI31EmitLoadOfMemberFunctionPointerERN5clang7CodeGen15CodeGenFunctionEPKNS1_4ExprENS2_7AddressERPN4llvm5ValueESB_PKNS1_17MemberPointerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI31EmitLoadOfMemberFunctionPointerERN5clang7CodeGen15CodeGenFunctionEPKNS1_4ExprENS2_7AddressERPN4llvm5ValueESB_PKNS1_17MemberPointerTypeE")
  //</editor-fold>
  @Override public Value /*P*/ EmitLoadOfMemberFunctionPointer(final CodeGenFunction /*&*/ CGF, /*const*/ Expr /*P*/ E, Address This, 
                                 final type$ref<Value /*P*/ /*&*/> ThisPtrForCall, Value /*P*/ MemPtr, 
                                 /*const*/ MemberPointerType /*P*/ MPT)/* override*/ {
    assert (MPT.isMemberFunctionPointer());
    /*const*/ FunctionProtoType /*P*/ FPT = MPT.getPointeeType().$arrow().castAs(FunctionProtoType.class);
    /*const*/ CXXRecordDecl /*P*/ RD = MPT.getMostRecentCXXRecordDecl();
    org.llvm.ir.FunctionType /*P*/ FTy = CGM.getTypes().GetFunctionType(CGM.getTypes().arrangeCXXMethodType(RD, FPT, /*FD=*/ (/*const*/ CXXMethodDecl /*P*/ )null));
    final CGBuilderTy /*&*/ Builder = CGF.Builder;
    
    MSInheritanceAttr.Spelling Inheritance = RD.getMSInheritanceModel();
    
    // Extract the fields we need, regardless of model.  We'll apply them if we
    // have them.
    Value /*P*/ FunctionPointer = MemPtr;
    Value /*P*/ NonVirtualBaseAdjustment = null;
    Value /*P*/ VirtualBaseAdjustmentOffset = null;
    Value /*P*/ VBPtrOffset = null;
    if (MemPtr.getType().isStructTy()) {
      // We need to extract values.
      /*uint*/int I = 0;
      FunctionPointer = Builder.CreateExtractValue(MemPtr, new ArrayRefUInt(I++));
      if (MSInheritanceAttr.hasNVOffsetField((MPT != null), Inheritance)) {
        NonVirtualBaseAdjustment = Builder.CreateExtractValue(MemPtr, new ArrayRefUInt(I++));
      }
      if (MSInheritanceAttr.hasVBPtrOffsetField(Inheritance)) {
        VBPtrOffset = Builder.CreateExtractValue(MemPtr, new ArrayRefUInt(I++));
      }
      if (MSInheritanceAttr.hasVBTableOffsetField(Inheritance)) {
        VirtualBaseAdjustmentOffset = Builder.CreateExtractValue(MemPtr, new ArrayRefUInt(I++));
      }
    }
    if ((VirtualBaseAdjustmentOffset != null)) {
      ThisPtrForCall.$set(AdjustVirtualBase(CGF, E, RD, new Address(This), 
          VirtualBaseAdjustmentOffset, VBPtrOffset));
    } else {
      ThisPtrForCall.$set(This.getPointer());
    }
    if ((NonVirtualBaseAdjustment != null)) {
      // Apply the adjustment and cast back to the original struct type.
      Value /*P*/ Ptr = Builder.CreateBitCast(ThisPtrForCall.$deref(), CGF.Unnamed_field9.Int8PtrTy);
      Ptr = Builder.CreateInBoundsGEP(Ptr, new ArrayRef<Value /*P*/ >(NonVirtualBaseAdjustment, true));
      ThisPtrForCall.$set(Builder.CreateBitCast(Ptr, ThisPtrForCall.$deref().getType(), 
          new Twine(/*KEEP_STR*/"this.adjusted")));
    }
    
    return Builder.CreateBitCast(FunctionPointer, FTy.getPointerTo());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::emitCXXStructor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 3783,
   FQN="(anonymous namespace)::MicrosoftCXXABI::emitCXXStructor", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI15emitCXXStructorEPKN5clang13CXXMethodDeclENS1_7CodeGen12StructorTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI15emitCXXStructorEPKN5clang13CXXMethodDeclENS1_7CodeGen12StructorTypeE")
  //</editor-fold>
  @Override public void emitCXXStructor(/*const*/ CXXMethodDecl /*P*/ MD, 
                 StructorType Type)/* override*/ {
    {
      /*const*/ CXXConstructorDecl /*P*/ CD = dyn_cast_CXXConstructorDecl(MD);
      if ((CD != null)) {
        MicrosoftCXXABIStatics.emitCXXConstructor(CGM, CD, Type);
        return;
      }
    }
    MicrosoftCXXABIStatics.emitCXXDestructor(CGM, cast_CXXDestructorDecl(MD), Type);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::getCatchableTypeType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 671,
   FQN="(anonymous namespace)::MicrosoftCXXABI::getCatchableTypeType", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI20getCatchableTypeTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI20getCatchableTypeTypeEv")
  //</editor-fold>
  public StructType /*P*/ getCatchableTypeType() {
    if ((CatchableTypeType != null)) {
      return CatchableTypeType;
    }
    org.llvm.ir.Type /*P*/ FieldTypes[/*7*/] = new org.llvm.ir.Type /*P*/  [/*7*/] {
      CGM.IntTy,  // Flags
      getImageRelativeType(CGM.Unnamed_field9.Int8PtrTy),  // TypeDescriptor
      CGM.IntTy,  // NonVirtualAdjustment
      CGM.IntTy,  // OffsetToVBPtr
      CGM.IntTy,  // VBTableIndex
      CGM.IntTy,  // Size
      getImageRelativeType(CGM.Unnamed_field9.Int8PtrTy) // CopyCtor
    };
    CatchableTypeType = StructType.create(CGM.getLLVMContext(), new ArrayRef<org.llvm.ir.Type /*P*/ >(FieldTypes, true), new StringRef(/*KEEP_STR*/"eh.CatchableType"));
    return CatchableTypeType;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::getCatchableTypeArrayType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 688,
   FQN="(anonymous namespace)::MicrosoftCXXABI::getCatchableTypeArrayType", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI25getCatchableTypeArrayTypeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI25getCatchableTypeArrayTypeEj")
  //</editor-fold>
  public StructType /*P*/ getCatchableTypeArrayType(/*uint32_t*/int NumEntries) {
    final type$ref<StructType /*P*/ /*&*/> CatchableTypeArrayType = CatchableTypeArrayTypeMap.ref$at(NumEntries);
    if ((CatchableTypeArrayType.$deref() != null)) {
      return CatchableTypeArrayType.$deref();
    }
    
    SmallString/*<23>*/ CTATypeName/*J*/= new SmallString/*<23>*/(23, new StringRef(/*KEEP_STR*/"eh.CatchableTypeArray."));
    CTATypeName.$addassign(new StringRef(llvm.utostr($uint2ulong(NumEntries))));
    org.llvm.ir.Type /*P*/ CTType = getImageRelativeType(getCatchableTypeType().getPointerTo());
    org.llvm.ir.Type /*P*/ FieldTypes[/*2*/] = new org.llvm.ir.Type /*P*/  [/*2*/] {
      CGM.IntTy,  // NumEntries
      org.llvm.ir.ArrayType.get(CTType, $uint2ulong(NumEntries)) // CatchableTypes
    };
    CatchableTypeArrayType.$set(StructType.create(CGM.getLLVMContext(), new ArrayRef<org.llvm.ir.Type /*P*/ >(FieldTypes, true), CTATypeName.$StringRef()));
    return CatchableTypeArrayType.$deref();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::getThrowInfoType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 707,
   FQN="(anonymous namespace)::MicrosoftCXXABI::getThrowInfoType", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI16getThrowInfoTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI16getThrowInfoTypeEv")
  //</editor-fold>
  public StructType /*P*/ getThrowInfoType() {
    if ((ThrowInfoType != null)) {
      return ThrowInfoType;
    }
    org.llvm.ir.Type /*P*/ FieldTypes[/*4*/] = new org.llvm.ir.Type /*P*/  [/*4*/] {
      CGM.IntTy,  // Flags
      getImageRelativeType(CGM.Unnamed_field9.Int8PtrTy),  // CleanupFn
      getImageRelativeType(CGM.Unnamed_field9.Int8PtrTy),  // ForwardCompat
      getImageRelativeType(CGM.Unnamed_field9.Int8PtrTy) // CatchableTypeArray
    };
    ThrowInfoType = StructType.create(CGM.getLLVMContext(), new ArrayRef<org.llvm.ir.Type /*P*/ >(FieldTypes, true), 
        new StringRef(/*KEEP_STR*/"eh.ThrowInfo"));
    return ThrowInfoType;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::getThrowFn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 721,
   FQN="(anonymous namespace)::MicrosoftCXXABI::getThrowFn", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI10getThrowFnEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI10getThrowFnEv")
  //</editor-fold>
  public Constant /*P*/ getThrowFn() {
    // _CxxThrowException is passed an exception object and a ThrowInfo object
    // which describes the exception.
    org.llvm.ir.Type /*P*/ Args[/*2*/] = new org.llvm.ir.Type /*P*/  [/*2*/] {CGM.Unnamed_field9.Int8PtrTy, getThrowInfoType().getPointerTo()};
    org.llvm.ir.FunctionType /*P*/ FTy = org.llvm.ir.FunctionType.get(CGM.VoidTy, new ArrayRef<org.llvm.ir.Type /*P*/ >(Args, true), /*IsVarArgs=*/ false);
    Function /*P*/ Fn = cast_Function(CGM.CreateRuntimeFunction(FTy, new StringRef(/*KEEP_STR*/"_CxxThrowException")));
    // _CxxThrowException is stdcall on 32-bit x86 platforms.
    if (CGM.getTarget().getTriple().getArch() == Triple.ArchType.x86) {
      Fn.setCallingConv(CallingConv.X86_StdCall);
    }
    return Fn;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::getAddrOfCXXCtorClosure">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 3792,
   FQN="(anonymous namespace)::MicrosoftCXXABI::getAddrOfCXXCtorClosure", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI23getAddrOfCXXCtorClosureEPKN5clang18CXXConstructorDeclENS1_11CXXCtorTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI23getAddrOfCXXCtorClosureEPKN5clang18CXXConstructorDeclENS1_11CXXCtorTypeE")
  //</editor-fold>
  public Function /*P*/ getAddrOfCXXCtorClosure(/*const*/ CXXConstructorDecl /*P*/ CD, 
                         CXXCtorType CT) {
    raw_svector_ostream Out = null;
    CodeGenFunction CGF = null;
    FunctionArgList FunctionArgs = null;
    ImplicitParamDecl SrcParam = null;
    ImplicitParamDecl IsMostDerived = null;
    CallArgList Args = null;
    std.vector<Expr /*P*/ > ArgVec = null;
    CodeGenFunction.RunCleanupsScope Cleanups = null;
    try {
      assert (CT == CXXCtorType.Ctor_CopyingClosure || CT == CXXCtorType.Ctor_DefaultClosure);
      
      // Calculate the mangled name.
      SmallString/*<256>*/ ThunkName/*J*/= new SmallString/*<256>*/(256);
      Out/*J*/= new raw_svector_ostream(ThunkName);
      getMangleContext().mangleCXXCtor(CD, CT, Out);
      {
        
        // If the thunk has been generated previously, just return it.
        GlobalValue /*P*/ GV = CGM.getModule().getNamedValue(ThunkName.$StringRef());
        if ((GV != null)) {
          return cast_Function(GV);
        }
      }
      
      // Create the llvm::Function.
      final /*const*/ CGFunctionInfo /*&*/ FnInfo = CGM.getTypes().arrangeMSCtorClosure(CD, CT);
      org.llvm.ir.FunctionType /*P*/ ThunkTy = CGM.getTypes().GetFunctionType(FnInfo);
      /*const*/ CXXRecordDecl /*P*/ RD = CD.getParent$Const();
      QualType RecordTy = getContext().getRecordType(RD);
      Function /*P*/ ThunkFn = Function.Create(ThunkTy, MicrosoftCXXABIStatics.getLinkageForRTTI(new QualType(RecordTy)), new Twine(ThunkName.str()), $AddrOf(CGM.getModule()));
      ThunkFn.setCallingConv(((/*static_cast*//*uint*/int)(FnInfo.getEffectiveCallingConvention())));
      if (ThunkFn.isWeakForLinker()) {
        ThunkFn.setComdat(CGM.getModule().getOrInsertComdat(ThunkFn.getName()));
      }
      boolean IsCopy = CT == CXXCtorType.Ctor_CopyingClosure;
      
      // Start codegen.
      CGF/*J*/= new CodeGenFunction(CGM);
      CGF.CurGD.$assignMove(new GlobalDecl(JD$CXXConstructorDecl$C$P_CXXCtorType.INSTANCE, CD, CXXCtorType.Ctor_Complete));
      
      // Build FunctionArgs.
      FunctionArgs/*J*/= new FunctionArgList();
      
      // A constructor always starts with a 'this' pointer as its first argument.
      buildThisParam(CGF, FunctionArgs);
      
      // Following the 'this' pointer is a reference to the source object that we
      // are copying from.
      SrcParam/*J*/= new ImplicitParamDecl(getContext(), (DeclContext /*P*/ )null, new SourceLocation(), $AddrOf(getContext().Idents.get(new StringRef(/*KEEP_STR*/"src"))), 
          getContext().getLValueReferenceType(new QualType(RecordTy), 
              /*SpelledAsLValue=*/ true));
      if (IsCopy) {
        FunctionArgs.push_back($AddrOf(SrcParam));
      }
      
      // Constructors for classes which utilize virtual bases have an additional
      // parameter which indicates whether or not it is being delegated to by a more
      // derived constructor.
      IsMostDerived/*J*/= new ImplicitParamDecl(getContext(), (DeclContext /*P*/ )null, new SourceLocation(), 
          $AddrOf(getContext().Idents.get(new StringRef(/*KEEP_STR*/"is_most_derived"))), 
          getContext().IntTy.$QualType());
      // Only add the parameter to the list if thie class has virtual bases.
      if ($greater_uint(RD.getNumVBases(), 0)) {
        FunctionArgs.push_back($AddrOf(IsMostDerived));
      }
      
      // Start defining the function.
      CGF.StartFunction(new GlobalDecl(), FnInfo.getReturnType().$QualType(), ThunkFn, FnInfo, 
          FunctionArgs, CD.getLocation(), new SourceLocation());
      EmitThisParam(CGF);
      Value /*P*/ This = getThisValue(CGF);
      
      Value /*P*/ SrcVal = IsCopy ? CGF.Builder.CreateLoad(CGF.GetAddrOfLocalVar($AddrOf(SrcParam)), $("src")) : null;
      
      Args/*J*/= new CallArgList();
      
      // Push the this ptr.
      Args.add(RValue.get(This), CD.getThisType(getContext()));
      
      // Push the src ptr.
      if ((SrcVal != null)) {
        Args.add(RValue.get(SrcVal), SrcParam.getType());
      }
      
      // Add the rest of the default arguments.
      ArgVec/*J*/= new std.vector<Expr /*P*/ >((Expr /*P*/ )null);
      for (/*uint*/int I = IsCopy ? 1 : 0, E = CD.getNumParams(); I != E; ++I) {
        Expr /*P*/ DefaultArg = getContext().getDefaultArgExprForConstructor(CD, I);
        assert ((DefaultArg != null)) : "sema forgot to instantiate default args";
        ArgVec.push_back_T$C$R(DefaultArg);
      }
      
      Cleanups/*J*/= new CodeGenFunction.RunCleanupsScope(CGF);
      
      /*const*/ FunctionProtoType /*P*/ FPT = CD.getType().$arrow().castAs(FunctionProtoType.class);
      CGF.EmitCallArgs(Args, FPT, new iterator_range</*const*/ Expr /*P*/ /*const*/>(llvm.makeArrayRef(ArgVec)), CD, IsCopy ? 1 : 0); 
      
      // Insert any ABI-specific implicit constructor arguments.
      /*uint*/int ExtraArgs = addImplicitConstructorArgs(CGF, CD, CXXCtorType.Ctor_Complete, 
          /*ForVirtualBase=*/ false, 
          /*Delegating=*/ false, Args);
      
      // Call the destructor with our arguments.
      Value /*P*/ CalleeFn = CGM.getAddrOfCXXStructor(CD, StructorType.Complete);
      final /*const*/ CGFunctionInfo /*&*/ CalleeInfo = CGM.getTypes().arrangeCXXConstructorCall(Args, CD, CXXCtorType.Ctor_Complete, ExtraArgs);
      CGF.EmitCall(CalleeInfo, CalleeFn, new ReturnValueSlot(), Args, new CGCalleeInfo(CD));
      
      Cleanups.ForceCleanup();
      
      // Emit the ret instruction, remove any temporary instructions created for the
      // aid of CodeGen.
      CGF.FinishFunction(new SourceLocation());
      
      return ThunkFn;
    } finally {
      if (Cleanups != null) { Cleanups.$destroy(); }
      if (ArgVec != null) { ArgVec.$destroy(); }
      if (Args != null) { Args.$destroy(); }
      if (IsMostDerived != null) { IsMostDerived.$destroy(); }
      if (SrcParam != null) { SrcParam.$destroy(); }
      if (FunctionArgs != null) { FunctionArgs.$destroy(); }
      if (CGF != null) { CGF.$destroy(); }
      if (Out != null) { Out.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::getCatchableType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 3900,
   FQN="(anonymous namespace)::MicrosoftCXXABI::getCatchableType", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI16getCatchableTypeEN5clang8QualTypeEjij",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI16getCatchableTypeEN5clang8QualTypeEjij")
  //</editor-fold>
  public Constant /*P*/ getCatchableType(QualType T) {
    return getCatchableType(T, 
                  0, 
                  -1, 
                  0);
  }
  public Constant /*P*/ getCatchableType(QualType T, 
                  /*uint32_t*/int NVOffset/*= 0*/) {
    return getCatchableType(T, 
                  NVOffset, 
                  -1, 
                  0);
  }
  public Constant /*P*/ getCatchableType(QualType T, 
                  /*uint32_t*/int NVOffset/*= 0*/, 
                  int/*int32_t*/ VBPtrOffset/*= -1*/) {
    return getCatchableType(T, 
                  NVOffset, 
                  VBPtrOffset, 
                  0);
  }
  public Constant /*P*/ getCatchableType(QualType T, 
                  /*uint32_t*/int NVOffset/*= 0*/, 
                  int/*int32_t*/ VBPtrOffset/*= -1*/, 
                  /*uint32_t*/int VBIndex/*= 0*/) {
    assert (!T.$arrow().isReferenceType());
    
    CXXRecordDecl /*P*/ RD = T.$arrow().getAsCXXRecordDecl();
    /*const*/ CXXConstructorDecl /*P*/ CD = (RD != null) ? CGM.getContext().getCopyConstructorForExceptionObject(RD) : null;
    CXXCtorType CT = CXXCtorType.Ctor_Complete;
    if ((CD != null)) {
      if (!MicrosoftCXXABIStatics.hasDefaultCXXMethodCC(getContext(), CD) || CD.getNumParams() != 1) {
        CT = CXXCtorType.Ctor_CopyingClosure;
      }
    }
    
    /*uint32_t*/int Size = $long2uint(getContext().getTypeSizeInChars(/*NO_COPY*/T).getQuantity());
    SmallString/*<256>*/ MangledName/*J*/= new SmallString/*<256>*/(256);
    {
      raw_svector_ostream Out = null;
      try {
        Out/*J*/= new raw_svector_ostream(MangledName);
        getMangleContext().mangleCXXCatchableType(new QualType(T), CD, CT, Size, NVOffset, 
            VBPtrOffset, VBIndex, Out);
      } finally {
        if (Out != null) { Out.$destroy(); }
      }
    }
    {
      GlobalVariable /*P*/ GV = CGM.getModule().getNamedGlobal(MangledName.$StringRef());
      if ((GV != null)) {
        return getImageRelativeConstant(GV);
      }
    }
    
    // The TypeDescriptor is used by the runtime to determine if a catch handler
    // is appropriate for the exception object.
    Constant /*P*/ TD = getImageRelativeConstant(getAddrOfRTTIDescriptor(new QualType(T)));
    
    // The runtime is responsible for calling the copy constructor if the
    // exception is caught by value.
    Constant /*P*/ CopyCtor;
    if ((CD != null)) {
      if (CT == CXXCtorType.Ctor_CopyingClosure) {
        CopyCtor = getAddrOfCXXCtorClosure(CD, CXXCtorType.Ctor_CopyingClosure);
      } else {
        CopyCtor = CGM.getAddrOfCXXStructor(CD, StructorType.Complete);
      }
      
      CopyCtor = ConstantExpr.getBitCast(CopyCtor, CGM.Unnamed_field9.Int8PtrTy);
    } else {
      CopyCtor = Constant.getNullValue(CGM.Unnamed_field9.Int8PtrTy);
    }
    CopyCtor = getImageRelativeConstant(CopyCtor);
    
    boolean IsScalar = !(RD != null);
    boolean HasVirtualBases = false;
    boolean IsStdBadAlloc = false; // std::bad_alloc is special for some reason.
    QualType PointeeType = new QualType(T);
    if (T.$arrow().isPointerType()) {
      PointeeType.$assignMove(T.$arrow().getPointeeType());
    }
    {
      /*const*/ CXXRecordDecl /*P*/ RD$1 = PointeeType.$arrow().getAsCXXRecordDecl();
      if ((RD$1 != null)) {
        HasVirtualBases = $greater_uint(RD$1.getNumVBases(), 0);
        {
          IdentifierInfo /*P*/ II = RD$1.getIdentifier();
          if ((II != null)) {
            IsStdBadAlloc = II.isStr(/*KEEP_STR*/"bad_alloc") && RD$1.isInStdNamespace();
          }
        }
      }
    }
    
    // Encode the relevant CatchableType properties into the Flags bitfield.
    // FIXME: Figure out how bits 2 or 8 can get set.
    /*uint32_t*/int Flags = 0;
    if (IsScalar) {
      Flags |= 1;
    }
    if (HasVirtualBases) {
      Flags |= 4;
    }
    if (IsStdBadAlloc) {
      Flags |= 16;
    }
    
    Constant /*P*/ Fields[/*7*/] = new Constant /*P*/  [/*7*/] {
      ConstantInt.get(CGM.IntTy, $uint2ulong(Flags)),  // Flags
      TD,  // TypeDescriptor
      ConstantInt.get(CGM.IntTy, $uint2ulong(NVOffset)),  // NonVirtualAdjustment
      ConstantInt.get(CGM.IntTy, $int2ulong(VBPtrOffset)),  // OffsetToVBPtr
      ConstantInt.get(CGM.IntTy, $uint2ulong(VBIndex)),  // VBTableIndex
      ConstantInt.get(CGM.IntTy, $uint2ulong(Size)),  // Size
      CopyCtor // CopyCtor
    };
    StructType /*P*/ CTType = getCatchableTypeType();
    GlobalVariable /*P*/ GV = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
        return new GlobalVariable(CGM.getModule(), CTType, /*Constant=*/ true, MicrosoftCXXABIStatics.getLinkageForRTTI(new QualType(T)), 
        ConstantStruct.get(CTType, new ArrayRef<Constant /*P*/ >(Fields, true)), new Twine(MangledName));
     });
    GV.setUnnamedAddr(GlobalValue.UnnamedAddr.Global);
    GV.setSection(new StringRef(/*KEEP_STR*/".xdata"));
    if (GV.isWeakForLinker()) {
      GV.setComdat(CGM.getModule().getOrInsertComdat(GV.getName()));
    }
    return getImageRelativeConstant(GV);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::getCatchableTypeArray">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 3985,
   FQN="(anonymous namespace)::MicrosoftCXXABI::getCatchableTypeArray", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI21getCatchableTypeArrayEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI21getCatchableTypeArrayEN5clang8QualTypeE")
  //</editor-fold>
  public GlobalVariable /*P*/ getCatchableTypeArray(QualType T) {
    assert (!T.$arrow().isReferenceType());
    
    // See if we've already generated a CatchableTypeArray for this type before.
    final type$ref<GlobalVariable /*P*/ /*&*/> CTA = CatchableTypeArrays.ref$at(T);
    if ((CTA.$deref() != null)) {
      return CTA.$deref();
    }
    
    // Ensure that we don't have duplicate entries in our CatchableTypeArray by
    // using a SmallSetVector.  Duplicates may arise due to virtual bases
    // occurring more than once in the hierarchy.
    SmallSetVector<Constant /*P*/ > CatchableTypes/*J*/= new SmallSetVector<Constant /*P*/ >(2, (Constant /*P*/ ) null);
    
    // C++14 [except.handle]p3:
    //   A handler is a match for an exception object of type E if [...]
    //     - the handler is of type cv T or cv T& and T is an unambiguous public
    //       base class of E, or
    //     - the handler is of type cv T or const T& where T is a pointer type and
    //       E is a pointer type that can be converted to T by [...]
    //         - a standard pointer conversion (4.10) not involving conversions to
    //           pointers to private or protected or ambiguous classes
    /*const*/ CXXRecordDecl /*P*/ MostDerivedClass = null;
    boolean IsPointer = T.$arrow().isPointerType();
    if (IsPointer) {
      MostDerivedClass = T.$arrow().getPointeeType().$arrow().getAsCXXRecordDecl();
    } else {
      MostDerivedClass = T.$arrow().getAsCXXRecordDecl();
    }
    
    // Collect all the unambiguous public bases of the MostDerivedClass.
    if ((MostDerivedClass != null)) {
      final /*const*/ ASTContext /*&*/ Context = getContext();
      final /*const*/ ASTRecordLayout /*&*/ MostDerivedLayout = Context.getASTRecordLayout(MostDerivedClass);
      final MicrosoftVTableContext /*&*/ VTableContext = CGM.getMicrosoftVTableContext();
      SmallVector<MSRTTIClass> Classes/*J*/= new SmallVector<MSRTTIClass>(8, new MSRTTIClass());
      MicrosoftCXXABIStatics.serializeClassHierarchy(Classes, MostDerivedClass);
      Classes.front().initialize(/*Parent=*/ (/*const*/ MSRTTIClass /*P*/ )null, /*Specifier=*/ (/*const*/ CXXBaseSpecifier /*P*/ )null);
      MicrosoftCXXABIStatics.detectAmbiguousBases(Classes);
      for (final /*const*/ MSRTTIClass /*&*/ Class : Classes) {
        // Skip any ambiguous or private bases.
        if (((Class.Flags
           & (MSRTTIClass.Unnamed_enum.IsPrivateOnPath.getValue() | MSRTTIClass.Unnamed_enum.IsAmbiguous.getValue())) != 0)) {
          continue;
        }
        // Write down how to convert from a derived pointer to a base pointer.
        /*uint32_t*/int OffsetInVBTable = 0;
        int/*int32_t*/ VBPtrOffset = -1;
        if ((Class.VirtualRoot != null)) {
          OffsetInVBTable
             = VTableContext.getVBTableIndex(MostDerivedClass, Class.VirtualRoot) * 4;
          VBPtrOffset = $long2int(MostDerivedLayout.getVBPtrOffset().getQuantity());
        }
        
        // Turn our record back into a pointer if the exception object is a
        // pointer.
        QualType RTTITy = new QualType(Class.RD.getTypeForDecl(), 0);
        if (IsPointer) {
          RTTITy.$assignMove(Context.getPointerType(/*NO_COPY*/RTTITy));
        }
        CatchableTypes.insert(getCatchableType(new QualType(RTTITy), Class.OffsetInVBase, 
                VBPtrOffset, OffsetInVBTable));
      }
    }
    
    // C++14 [except.handle]p3:
    //   A handler is a match for an exception object of type E if
    //     - The handler is of type cv T or cv T& and E and T are the same type
    //       (ignoring the top-level cv-qualifiers)
    CatchableTypes.insert(getCatchableType(new QualType(T)));
    
    // C++14 [except.handle]p3:
    //   A handler is a match for an exception object of type E if
    //     - the handler is of type cv T or const T& where T is a pointer type and
    //       E is a pointer type that can be converted to T by [...]
    //         - a standard pointer conversion (4.10) not involving conversions to
    //           pointers to private or protected or ambiguous classes
    //
    // C++14 [conv.ptr]p2:
    //   A prvalue of type "pointer to cv T," where T is an object type, can be
    //   converted to a prvalue of type "pointer to cv void".
    if (IsPointer && T.$arrow().getPointeeType().$arrow().isObjectType()) {
      CatchableTypes.insert(getCatchableType(getContext().VoidPtrTy.$QualType()));
    }
    
    // C++14 [except.handle]p3:
    //   A handler is a match for an exception object of type E if [...]
    //     - the handler is of type cv T or const T& where T is a pointer or
    //       pointer to member type and E is std::nullptr_t.
    //
    // We cannot possibly list all possible pointer types here, making this
    // implementation incompatible with the standard.  However, MSVC includes an
    // entry for pointer-to-void in this case.  Let's do the same.
    if (T.$arrow().isNullPtrType()) {
      CatchableTypes.insert(getCatchableType(getContext().VoidPtrTy.$QualType()));
    }
    
    /*uint32_t*/int NumEntries = CatchableTypes.size();
    org.llvm.ir.Type /*P*/ CTType = getImageRelativeType(getCatchableTypeType().getPointerTo());
    org.llvm.ir.ArrayType /*P*/ AT = org.llvm.ir.ArrayType.get(CTType, $uint2ulong(NumEntries));
    StructType /*P*/ CTAType = getCatchableTypeArrayType(NumEntries);
    Constant /*P*/ Fields[/*2*/] = new Constant /*P*/  [/*2*/] {
      ConstantInt.get(CGM.IntTy, $uint2ulong(NumEntries)),  // NumEntries
      ConstantArray.get(AT, llvm.makeArrayRef(CatchableTypes.begin(), 
              CatchableTypes.end(), true)) // CatchableTypes
    };
    SmallString/*<256>*/ MangledName/*J*/= new SmallString/*<256>*/(256);
    {
      raw_svector_ostream Out = null;
      try {
        Out/*J*/= new raw_svector_ostream(MangledName);
        getMangleContext().mangleCXXCatchableTypeArray(new QualType(T), NumEntries, Out);
      } finally {
        if (Out != null) { Out.$destroy(); }
      }
    }
    CTA.$set(/*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
        return new GlobalVariable(CGM.getModule(), CTAType, /*Constant=*/ true, MicrosoftCXXABIStatics.getLinkageForRTTI(new QualType(T)), 
                ConstantStruct.get(CTAType, new ArrayRef<Constant /*P*/ >(Fields, true)), new Twine(MangledName));
     }));
    CTA.$deref().setUnnamedAddr(GlobalValue.UnnamedAddr.Global);
    CTA.$deref().setSection(new StringRef(/*KEEP_STR*/".xdata"));
    if (CTA.$deref().isWeakForLinker()) {
      CTA.$deref().setComdat(CGM.getModule().getOrInsertComdat(CTA.$deref().getName()));
    }
    return CTA.$deref();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::getThrowInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 4103,
   FQN="(anonymous namespace)::MicrosoftCXXABI::getThrowInfo", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI12getThrowInfoEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI12getThrowInfoEN5clang8QualTypeE")
  //</editor-fold>
  @Override public GlobalVariable /*P*/ getThrowInfo(QualType T)/* override*/ {
    bool$ref IsConst = create_bool$ref();
    bool$ref IsVolatile = create_bool$ref();
    bool$ref IsUnaligned = create_bool$ref();
    T.$assignMove(MicrosoftCXXABIStatics.decomposeTypeForEH(getContext(), new QualType(T), IsConst, IsVolatile, IsUnaligned));
    
    // The CatchableTypeArray enumerates the various (CV-unqualified) types that
    // the exception object may be caught as.
    GlobalVariable /*P*/ CTA = getCatchableTypeArray(new QualType(T));
    // The first field in a CatchableTypeArray is the number of CatchableTypes.
    // This is used as a component of the mangled name which means that we need to
    // know what it is in order to see if we have previously generated the
    // ThrowInfo.
    /*uint32_t*/int NumEntries = $ulong2uint(cast_ConstantInt(CTA.getInitializer().getAggregateElement(0/*U*/)).
        getLimitedValue());
    
    SmallString/*<256>*/ MangledName/*J*/= new SmallString/*<256>*/(256);
    {
      raw_svector_ostream Out = null;
      try {
        Out/*J*/= new raw_svector_ostream(MangledName);
        getMangleContext().mangleCXXThrowInfo(new QualType(T), IsConst.$deref(), IsVolatile.$deref(), IsUnaligned.$deref(), 
            NumEntries, Out);
      } finally {
        if (Out != null) { Out.$destroy(); }
      }
    }
    {
      
      // Reuse a previously generated ThrowInfo if we have generated an appropriate
      // one before.
      GlobalVariable /*P*/ GV = CGM.getModule().getNamedGlobal(MangledName.$StringRef());
      if ((GV != null)) {
        return GV;
      }
    }
    
    // The RTTI TypeDescriptor uses an unqualified type but catch clauses must
    // be at least as CV qualified.  Encode this requirement into the Flags
    // bitfield.
    /*uint32_t*/int Flags = 0;
    if (IsConst.$deref()) {
      Flags |= 1;
    }
    if (IsVolatile.$deref()) {
      Flags |= 2;
    }
    if (IsUnaligned.$deref()) {
      Flags |= 4;
    }
    
    // The cleanup-function (a destructor) must be called when the exception
    // object's lifetime ends.
    Constant /*P*/ CleanupFn = Constant.getNullValue(CGM.Unnamed_field9.Int8PtrTy);
    {
      /*const*/ CXXRecordDecl /*P*/ RD = T.$arrow().getAsCXXRecordDecl();
      if ((RD != null)) {
        {
          CXXDestructorDecl /*P*/ DtorD = RD.getDestructor();
          if ((DtorD != null)) {
            if (!DtorD.isTrivial()) {
              CleanupFn = ConstantExpr.getBitCast(CGM.getAddrOfCXXStructor(DtorD, StructorType.Complete), 
                  CGM.Unnamed_field9.Int8PtrTy);
            }
          }
        }
      }
    }
    // This is unused as far as we can tell, initialize it to null.
    Constant /*P*/ ForwardCompat = getImageRelativeConstant(Constant.getNullValue(CGM.Unnamed_field9.Int8PtrTy));
    Constant /*P*/ PointerToCatchableTypes = getImageRelativeConstant(ConstantExpr.getBitCast(CTA, CGM.Unnamed_field9.Int8PtrTy));
    StructType /*P*/ TIType = getThrowInfoType();
    Constant /*P*/ Fields[/*4*/] = new Constant /*P*/  [/*4*/] {
      ConstantInt.get(CGM.IntTy, $uint2ulong(Flags)),  // Flags
      getImageRelativeConstant(CleanupFn),  // CleanupFn
      ForwardCompat,  // ForwardCompat
      PointerToCatchableTypes // CatchableTypeArray
    };
    GlobalVariable /*P*/ GV = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
        return new GlobalVariable(CGM.getModule(), TIType, /*Constant=*/ true, MicrosoftCXXABIStatics.getLinkageForRTTI(new QualType(T)), 
        ConstantStruct.get(TIType, new ArrayRef<Constant /*P*/ >(Fields, true)), new Twine(MangledName.$StringRef()));
     });
    GV.setUnnamedAddr(GlobalValue.UnnamedAddr.Global);
    GV.setSection(new StringRef(/*KEEP_STR*/".xdata"));
    if (GV.isWeakForLinker()) {
      GV.setComdat(CGM.getModule().getOrInsertComdat(GV.getName()));
    }
    return GV;
  }

/*private:*/
  // JAVA: typedef std::pair<const CXXRecordDecl *, CharUnits> VFTableIdTy
//  public final class VFTableIdTy extends std.pairPtrType</*const*/ CXXRecordDecl /*P*/ , CharUnits>{ };
  // JAVA: typedef llvm::DenseMap<VFTableIdTy, llvm::GlobalVariable *> VTablesMapTy
//  public final class VTablesMapTy extends DenseMap<std.pairPtrType</*const*/ CXXRecordDecl /*P*/ , CharUnits>, GlobalVariable /*P*/ >{ };
  // JAVA: typedef llvm::DenseMap<VFTableIdTy, llvm::GlobalValue *> VFTablesMapTy
//  public final class VFTablesMapTy extends DenseMap<std.pairPtrType</*const*/ CXXRecordDecl /*P*/ , CharUnits>, GlobalValue /*P*/ >{ };
  /// \brief All the vftables that have been referenced.
  private DenseMap<std.pair</*const*/ CXXRecordDecl /*P*/ , CharUnits>, GlobalValue /*P*/ > VFTablesMap;
  private DenseMap<std.pair</*const*/ CXXRecordDecl /*P*/ , CharUnits>, GlobalVariable /*P*/ > VTablesMap;
  
  /// \brief This set holds the record decls we've deferred vtable emission for.
  private SmallPtrSet</*const*/ CXXRecordDecl /*P*/ > DeferredVFTables;
  
  /// \brief All the vbtables which have been referenced.
  private DenseMap</*const*/ CXXRecordDecl /*P*/ , VBTableGlobals> VBTablesMap;
  
  /// Info on the global variable used to guard initialization of static locals.
  /// The BitIndex field is only used for externally invisible declarations.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::GuardInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 764,
   FQN="(anonymous namespace)::MicrosoftCXXABI::GuardInfo", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI9GuardInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI9GuardInfoE")
  //</editor-fold>
  private static class/*struct*/ GuardInfo implements NativePOD<GuardInfo> {
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::GuardInfo::GuardInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 765,
     FQN="(anonymous namespace)::MicrosoftCXXABI::GuardInfo::GuardInfo", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI9GuardInfoC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI9GuardInfoC1Ev")
    //</editor-fold>
    public GuardInfo() {
      // : Guard(null), BitIndex(0) 
      //START JInit
      this.Guard = null;
      this.BitIndex = 0;
      //END JInit
    }

    public GlobalVariable /*P*/ Guard;
    public /*uint*/int BitIndex;
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::GuardInfo::GuardInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 764,
     FQN="(anonymous namespace)::MicrosoftCXXABI::GuardInfo::GuardInfo", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI9GuardInfoC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI9GuardInfoC1ERKS1_")
    //</editor-fold>
    public /*inline*/ GuardInfo(final /*const*/ GuardInfo /*&*/ $Prm0) {
      // : Guard(.Guard), BitIndex(.BitIndex) 
      //START JInit
      this.Guard = $Prm0.Guard;
      this.BitIndex = $Prm0.BitIndex;
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::GuardInfo::GuardInfo">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 764,
     FQN="(anonymous namespace)::MicrosoftCXXABI::GuardInfo::GuardInfo", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABI9GuardInfoC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABI9GuardInfoC1EOS1_")
    //</editor-fold>
    public /*inline*/ GuardInfo(JD$Move _dparam, final GuardInfo /*&&*/$Prm0) {
      // : Guard(static_cast<GuardInfo &&>().Guard), BitIndex(static_cast<GuardInfo &&>().BitIndex) 
      //START JInit
      this.Guard = $Prm0.Guard;
      this.BitIndex = $Prm0.BitIndex;
      //END JInit
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    @Override
    public GuardInfo $assign(GuardInfo other) {
      this.BitIndex = other.BitIndex;
      this.Guard = other.Guard;
      return this;
    }

    @Override
    public GuardInfo clone() {
      GuardInfo res = new GuardInfo();
      res.Guard = this.Guard;
      res.BitIndex = this.BitIndex;
      return res;
    }
    

    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "Guard=" + Guard // NOI18N
                + ", BitIndex=" + BitIndex; // NOI18N
    }
  };
  
  /// Map from DeclContext to the current guard variable.  We assume that the
  /// AST is visited in source code order.
  private DenseMap</*const*/ DeclContext /*P*/ , GuardInfo> GuardVariableMap;
  private DenseMap</*const*/ DeclContext /*P*/ , GuardInfo> ThreadLocalGuardVariableMap;
  private DenseMapTypeUInt</*const*/ DeclContext /*P*/ > ThreadSafeGuardNumMap;
  
  private DenseMapUIntType<StructType /*P*/ > TypeDescriptorTypeMap;
  private StructType /*P*/ BaseClassDescriptorType;
  private StructType /*P*/ ClassHierarchyDescriptorType;
  private StructType /*P*/ CompleteObjectLocatorType;
  
  private DenseMap<QualType, GlobalVariable /*P*/ > CatchableTypeArrays;
  
  private StructType /*P*/ CatchableTypeType;
  private DenseMapUIntType<StructType /*P*/ > CatchableTypeArrayTypeMap;
  private StructType /*P*/ ThrowInfoType;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MicrosoftCXXABI::~MicrosoftCXXABI">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp", line = 43,
   FQN="(anonymous namespace)::MicrosoftCXXABI::~MicrosoftCXXABI", NM="_ZN12_GLOBAL__N_115MicrosoftCXXABID0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/MicrosoftCXXABI.cpp -nm=_ZN12_GLOBAL__N_115MicrosoftCXXABID0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    CatchableTypeArrayTypeMap.$destroy();
    CatchableTypeArrays.$destroy();
    TypeDescriptorTypeMap.$destroy();
    ThreadSafeGuardNumMap.$destroy();
    ThreadLocalGuardVariableMap.$destroy();
    GuardVariableMap.$destroy();
    VBTablesMap.$destroy();
    DeferredVFTables.$destroy();
    VTablesMap.$destroy();
    VFTablesMap.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "VFTablesMap=" + VFTablesMap // NOI18N
              + ", VTablesMap=" + VTablesMap // NOI18N
              + ", DeferredVFTables=" + "[SmallPtrSet$CXXRecordDecl]" // NOI18N
              + ", VBTablesMap=" + VBTablesMap // NOI18N
              + ", GuardVariableMap=" + GuardVariableMap // NOI18N
              + ", ThreadLocalGuardVariableMap=" + ThreadLocalGuardVariableMap // NOI18N
              + ", ThreadSafeGuardNumMap=" + "[DenseMapTypeUInt$DeclContext]" // NOI18N
              + ", TypeDescriptorTypeMap=" + TypeDescriptorTypeMap // NOI18N
              + ", BaseClassDescriptorType=" + BaseClassDescriptorType // NOI18N
              + ", ClassHierarchyDescriptorType=" + ClassHierarchyDescriptorType // NOI18N
              + ", CompleteObjectLocatorType=" + CompleteObjectLocatorType // NOI18N
              + ", CatchableTypeArrays=" + CatchableTypeArrays // NOI18N
              + ", CatchableTypeType=" + CatchableTypeType // NOI18N
              + ", CatchableTypeArrayTypeMap=" + CatchableTypeArrayTypeMap // NOI18N
              + ", ThrowInfoType=" + ThrowInfoType // NOI18N
              + super.toString(); // NOI18N
  }
}
