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
package org.clang.codegen.CodeGen.impl;

import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.*;
import org.llvm.ir.FunctionType;
import org.llvm.ir.PointerType;
import org.llvm.ir.Type;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.llvm.ir.java.IrRTTI.*;
import static org.clang.ast.java.AstJavaDifferentiators.*;
import static org.clang.codegen.CodeGen.impl.CodeGenStatics.*;


//<editor-fold defaultstate="collapsed" desc="static type CodeGenModule_CGCXX">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.codegen.CodeGen.impl.CodeGenModule_CGCXX",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this -extends=CodeGenModule_CGBuiltin ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN5clang7CodeGen13CodeGenModule18codegenCXXStructorEPKNS_13CXXMethodDeclENS0_12StructorTypeE;_ZN5clang7CodeGen13CodeGenModule20getAddrOfCXXStructorEPKNS_13CXXMethodDeclENS0_12StructorTypeEPKNS0_14CGFunctionInfoEPN4llvm12FunctionTypeEbb;_ZN5clang7CodeGen13CodeGenModule24TryEmitDefinitionAsAliasENS_10GlobalDeclES2_b;_ZN5clang7CodeGen13CodeGenModule28TryEmitBaseDestructorAsAliasEPKNS_17CXXDestructorDeclE; -static-type=CodeGenModule_CGCXX -package=org.clang.codegen.CodeGen.impl")
//</editor-fold>
public abstract class CodeGenModule_CGCXX extends CodeGenModule_CGBuiltin {
private final /*split clang::CodeGen::CodeGenModule*/ CodeGenModule $this() { return (CodeGenModule)this; }


// Produce code for this constructor/destructor. This method doesn't try
// to apply any ABI rules about which other constructors/destructors
// are needed or if they are alias to each other.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::codegenCXXStructor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp", line = 217,
 FQN="clang::CodeGen::CodeGenModule::codegenCXXStructor", NM="_ZN5clang7CodeGen13CodeGenModule18codegenCXXStructorEPKNS_13CXXMethodDeclENS0_12StructorTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN5clang7CodeGen13CodeGenModule18codegenCXXStructorEPKNS_13CXXMethodDeclENS0_12StructorTypeE")
//</editor-fold>
public final Function /*P*/ codegenCXXStructor(/*const*/ CXXMethodDecl /*P*/ MD, 
                  StructorType Type) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    final /*const*/ CGFunctionInfo /*&*/ FnInfo = $this().getTypes().arrangeCXXStructorDeclaration(MD, Type);
    Function /*P*/ Fn = cast_Function($this().getAddrOfCXXStructor(MD, Type, $AddrOf(FnInfo), /*FnType=*/ (FunctionType /*P*/ )null, 
    /*DontDefer=*/ true, /*IsForDefinition=*/ true));
    
    GlobalDecl GD/*J*/= new GlobalDecl();
    {
      /*const*/ CXXDestructorDecl /*P*/ DD = dyn_cast_CXXDestructorDecl(MD);
      if ((DD != null)) {
        GD.$assignMove(new GlobalDecl(JD$CXXDestructorDecl$C$P_CXXDtorType.INSTANCE, DD, toCXXDtorType(Type)));
      } else {
        /*const*/ CXXConstructorDecl /*P*/ CD = cast_CXXConstructorDecl(MD);
        GD.$assignMove(new GlobalDecl(JD$CXXConstructorDecl$C$P_CXXCtorType.INSTANCE, CD, toCXXCtorType(Type)));
      }
    }
    
    $this().setFunctionLinkage(new GlobalDecl(GD), Fn);
    $this().setFunctionDLLStorageClass(new GlobalDecl(GD), Fn);
    
    $c$.track(new CodeGenFunction(/*Deref*/$this())).GenerateCode(new GlobalDecl(GD), Fn, FnInfo); $c$.clean();
    $this().setFunctionDefinitionAttributes(MD, Fn);
    $this().SetLLVMFunctionAttributesForDefinition(MD, Fn);
    return Fn;
  } finally {
    $c$.$destroy();
  }
}


/// Return the address of the constructor/destructor of the given type.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::getAddrOfCXXStructor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp", line = 242,
 FQN="clang::CodeGen::CodeGenModule::getAddrOfCXXStructor", NM="_ZN5clang7CodeGen13CodeGenModule20getAddrOfCXXStructorEPKNS_13CXXMethodDeclENS0_12StructorTypeEPKNS0_14CGFunctionInfoEPN4llvm12FunctionTypeEbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN5clang7CodeGen13CodeGenModule20getAddrOfCXXStructorEPKNS_13CXXMethodDeclENS0_12StructorTypeEPKNS0_14CGFunctionInfoEPN4llvm12FunctionTypeEbb")
//</editor-fold>
public final Constant /*P*/ getAddrOfCXXStructor(/*const*/ CXXMethodDecl /*P*/ MD, StructorType Type) {
  return getAddrOfCXXStructor(MD, Type, (/*const*/ CGFunctionInfo /*P*/ )null, 
                    (FunctionType /*P*/ )null, false, false);
}
public final Constant /*P*/ getAddrOfCXXStructor(/*const*/ CXXMethodDecl /*P*/ MD, StructorType Type, /*const*/ CGFunctionInfo /*P*/ FnInfo/*= null*/) {
  return getAddrOfCXXStructor(MD, Type, FnInfo, 
                    (FunctionType /*P*/ )null, false, false);
}
public final Constant /*P*/ getAddrOfCXXStructor(/*const*/ CXXMethodDecl /*P*/ MD, StructorType Type, /*const*/ CGFunctionInfo /*P*/ FnInfo/*= null*/, 
                    FunctionType /*P*/ FnType/*= null*/) {
  return getAddrOfCXXStructor(MD, Type, FnInfo, 
                    FnType, false, false);
}
public final Constant /*P*/ getAddrOfCXXStructor(/*const*/ CXXMethodDecl /*P*/ MD, StructorType Type, /*const*/ CGFunctionInfo /*P*/ FnInfo/*= null*/, 
                    FunctionType /*P*/ FnType/*= null*/, boolean DontDefer/*= false*/) {
  return getAddrOfCXXStructor(MD, Type, FnInfo, 
                    FnType, DontDefer, false);
}
public final Constant /*P*/ getAddrOfCXXStructor(/*const*/ CXXMethodDecl /*P*/ MD, StructorType Type, /*const*/ CGFunctionInfo /*P*/ FnInfo/*= null*/, 
                    FunctionType /*P*/ FnType/*= null*/, boolean DontDefer/*= false*/, boolean IsForDefinition/*= false*/) {
  GlobalDecl GD/*J*/= new GlobalDecl();
  {
    /*const*/ CXXConstructorDecl /*P*/ CD = dyn_cast_CXXConstructorDecl(MD);
    if ((CD != null)) {
      GD.$assignMove(new GlobalDecl(JD$CXXConstructorDecl$C$P_CXXCtorType.INSTANCE, CD, toCXXCtorType(Type)));
    } else {
      GD.$assignMove(new GlobalDecl(JD$CXXDestructorDecl$C$P_CXXDtorType.INSTANCE, cast_CXXDestructorDecl(MD), toCXXDtorType(Type)));
    }
  }
  if (!(FnType != null)) {
    if (!(FnInfo != null)) {
      FnInfo = $AddrOf($this().getTypes().arrangeCXXStructorDeclaration(MD, Type));
    }
    FnType = $this().getTypes().GetFunctionType($Deref(FnInfo));
  }
  
  return $this().GetOrCreateLLVMFunction($this().getMangledName(new GlobalDecl(GD)), FnType, new GlobalDecl(GD), /*ForVTable=*/ false, DontDefer, 
      /*isThunk=*/ false, /*ExtraAttrs=*/ new AttributeSet(), IsForDefinition);
}


/// Try to emit a definition as a global alias for another definition.
/// If \p InEveryTU is true, we know that an equivalent alias can be produced
/// in every translation unit.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::TryEmitDefinitionAsAlias">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp", line = 120,
 FQN="clang::CodeGen::CodeGenModule::TryEmitDefinitionAsAlias", NM="_ZN5clang7CodeGen13CodeGenModule24TryEmitDefinitionAsAliasENS_10GlobalDeclES2_b",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN5clang7CodeGen13CodeGenModule24TryEmitDefinitionAsAliasENS_10GlobalDeclES2_b")
//</editor-fold>
public final boolean TryEmitDefinitionAsAlias(GlobalDecl AliasDecl, 
                        GlobalDecl TargetDecl, 
                        boolean InEveryTU) {
  if (!$this().getCodeGenOpts().CXXCtorDtorAliases) {
    return true;
  }
  
  // The alias will use the linkage of the referent.  If we can't
  // support aliases with that linkage, fail.
  GlobalValue.LinkageTypes Linkage = $this().getFunctionLinkage(new GlobalDecl(AliasDecl));
  
  // We can't use an alias if the linkage is not valid for one.
  if (!GlobalAlias.isValidLinkage(Linkage)) {
    return true;
  }
  
  GlobalValue.LinkageTypes TargetLinkage = $this().getFunctionLinkage(new GlobalDecl(TargetDecl));
  
  // Check if we have it already.
  StringRef MangledName = $this().getMangledName(new GlobalDecl(AliasDecl));
  GlobalValue /*P*/ Entry = $this().GetGlobalValue(new StringRef(MangledName));
  if ((Entry != null) && !Entry.isDeclaration()) {
    return false;
  }
  if (($this().Replacements.count(/*NO_COPY*/MangledName) != 0)) {
    return false;
  }
  
  // Derive the type for the alias.
  Type /*P*/ AliasValueType = $this().getTypes().GetFunctionType(new GlobalDecl(AliasDecl));
  PointerType /*P*/ AliasType = AliasValueType.getPointerTo();
  
  // Find the referent.  Some aliases might require a bitcast, in
  // which case the caller is responsible for ensuring the soundness
  // of these semantics.
  GlobalValue /*P*/ Ref = cast_GlobalValue($this().GetAddrOfGlobal(new GlobalDecl(TargetDecl)));
  Constant /*P*/ Aliasee = Ref;
  if (Ref.getType() != AliasType) {
    Aliasee = ConstantExpr.getBitCast(Ref, AliasType);
  }
  
  // Instead of creating as alias to a linkonce_odr, replace all of the uses
  // of the aliasee.
  if (GlobalValue.isDiscardableIfUnused(Linkage)
     && (TargetLinkage != GlobalValue.LinkageTypes.AvailableExternallyLinkage
     || !TargetDecl.getDecl().hasAttr(AlwaysInlineAttr.class))) {
    // FIXME: An extern template instantiation will create functions with
    // linkage "AvailableExternally". In libc++, some classes also define
    // members with attribute "AlwaysInline" and expect no reference to
    // be generated. It is desirable to reenable this optimisation after
    // corresponding LLVM changes.
    $this().addReplacement(new StringRef(MangledName), Aliasee);
    return false;
  }
  
  // If we have a weak, non-discardable alias (weak, weak_odr), like an extern
  // template instantiation or a dllexported class, avoid forming it on COFF.
  // A COFF weak external alias cannot satisfy a normal undefined symbol
  // reference from another TU. The other TU must also mark the referenced
  // symbol as weak, which we cannot rely on.
  if (GlobalValue.isWeakForLinker(Linkage)
     && $this().getTriple().isOSBinFormatCOFF()) {
    return true;
  }
  if (!InEveryTU) {
    // If we don't have a definition for the destructor yet, don't
    // emit.  We can't emit aliases to declarations; that's just not
    // how aliases work.
    if (Ref.isDeclaration()) {
      return true;
    }
  }
  
  // Don't create an alias to a linker weak symbol. This avoids producing
  // different COMDATs in different TUs. Another option would be to
  // output the alias both for weak_odr and linkonce_odr, but that
  // requires explicit comdat support in the IL.
  if (GlobalValue.isWeakForLinker(TargetLinkage)) {
    return true;
  }
  
  // Create the alias with no name.
  GlobalAlias /*P*/ Alias = GlobalAlias.create(AliasValueType, 0, Linkage, new Twine(/*KEEP_STR*/$EMPTY), 
      Aliasee, $AddrOf($this().getModule()));
  
  // Switch any previous uses to the alias.
  if ((Entry != null)) {
    assert (Entry.getType() == AliasType) : "declaration exists with different type";
    Alias.takeName(Entry);
    Entry.replaceAllUsesWith(Alias);
    Entry.eraseFromParent();
  } else {
    Alias.setName(new Twine(MangledName));
  }
  
  // Finally, set up the alias with its proper name and attributes.
  $this().setAliasAttributes(cast_NamedDecl(AliasDecl.getDecl()), Alias);
  
  return false;
}


/// Try to emit a base destructor as an alias to its primary
/// base-class destructor.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::TryEmitBaseDestructorAsAlias">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp", line = 34,
 FQN="clang::CodeGen::CodeGenModule::TryEmitBaseDestructorAsAlias", NM="_ZN5clang7CodeGen13CodeGenModule28TryEmitBaseDestructorAsAliasEPKNS_17CXXDestructorDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN5clang7CodeGen13CodeGenModule28TryEmitBaseDestructorAsAliasEPKNS_17CXXDestructorDeclE")
//</editor-fold>
public final boolean TryEmitBaseDestructorAsAlias(/*const*/ CXXDestructorDecl /*P*/ D) {
  if (!$this().getCodeGenOpts().CXXCtorDtorAliases) {
    return true;
  }
  
  // Producing an alias to a base class ctor/dtor can degrade debug quality
  // as the debugger cannot tell them apart.
  if ($2bits_uint2uint($this().getCodeGenOpts().OptimizationLevel) == 0) {
    return true;
  }
  
  // If sanitizing memory to check for use-after-dtor, do not emit as
  //  an alias, unless this class owns no members.
  if ($this().getCodeGenOpts().SanitizeMemoryUseAfterDtor
     && !D.getParent$Const().field_empty()) {
    return true;
  }
  
  // If the destructor doesn't have a trivial body, we have to emit it
  // separately.
  if (!D.hasTrivialBody()) {
    return true;
  }
  
  /*const*/ CXXRecordDecl /*P*/ Class = D.getParent$Const();
  
  // We are going to instrument this destructor, so give up even if it is
  // currently empty.
  if (Class.mayInsertExtraPadding()) {
    return true;
  }
  
  // If we need to manipulate a VTT parameter, give up.
  if ((Class.getNumVBases() != 0)) {
    // Extra Credit:  passing extra parameters is perfectly safe
    // in many calling conventions, so only bail out if the ctor's
    // calling convention is nonstandard.
    return true;
  }
  
  // If any field has a non-trivial destructor, we have to emit the
  // destructor separately.
  for (/*const*/ FieldDecl /*P*/ I : Class.fields())  {
    if ((I.getType().isDestructedType().getValue() != 0)) {
      return true;
    }
  }
  
  // Try to find a unique base class with a non-trivial destructor.
  /*const*/ CXXRecordDecl /*P*/ UniqueBase = null;
  for (final /*const*/ CXXBaseSpecifier /*&*/ I : Class.bases$Const()) {
    
    // We're in the base destructor, so skip virtual bases.
    if (I.isVirtual()) {
      continue;
    }
    
    // Skip base classes with trivial destructors.
    /*const*/ CXXRecordDecl /*P*/ Base = cast_CXXRecordDecl(I.getType().$arrow().getAs$RecordType().getDecl());
    if (Base.hasTrivialDestructor()) {
      continue;
    }
    
    // If we've already found a base class with a non-trivial
    // destructor, give up.
    if ((UniqueBase != null)) {
      return true;
    }
    UniqueBase = Base;
  }
  
  // If we didn't find any bases with a non-trivial destructor, then
  // the base destructor is actually effectively trivial, which can
  // happen if it was needlessly user-defined or if there are virtual
  // bases with non-trivial destructors.
  if (!(UniqueBase != null)) {
    return true;
  }
  
  // If the base is at a non-zero offset, give up.
  final /*const*/ ASTRecordLayout /*&*/ ClassLayout = $this().Context.getASTRecordLayout(Class);
  if (!ClassLayout.getBaseClassOffset(UniqueBase).isZero()) {
    return true;
  }
  
  // Give up if the calling conventions don't match. We could update the call,
  // but it is probably not worth it.
  /*const*/ CXXDestructorDecl /*P*/ BaseD = UniqueBase.getDestructor();
  if (BaseD.getType().$arrow().getAs(org.clang.ast.FunctionType.class).getCallConv()
     != D.getType().$arrow().getAs(org.clang.ast.FunctionType.class).getCallConv()) {
    return true;
  }
  
  return $this().TryEmitDefinitionAsAlias(new GlobalDecl(JD$CXXDestructorDecl$C$P_CXXDtorType.INSTANCE, D, CXXDtorType.Dtor_Base), 
      new GlobalDecl(JD$CXXDestructorDecl$C$P_CXXDtorType.INSTANCE, BaseD, CXXDtorType.Dtor_Base), 
      false);
}

} // END OF class CodeGenModule_CGCXX
