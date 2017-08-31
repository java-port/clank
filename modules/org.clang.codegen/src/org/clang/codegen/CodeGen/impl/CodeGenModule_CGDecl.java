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

import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.llvm.ir.*;
import org.llvm.ir.PointerType;
import org.llvm.ir.Type;
import org.llvm.ir.intrinsic.ID;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstJavaDifferentiators.*;
import static org.clang.codegen.impl.CGDeclStatics.getStaticDeclName;
import static org.clank.support.Native.$AddrOf;
import org.clank.support.aliases.type$ptr;
import static org.llvm.ir.intrinsic.IntrinsicGlobals.getDeclaration;


//<editor-fold defaultstate="collapsed" desc="static type CodeGenModule_CGDecl">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.codegen.CodeGen.impl.CodeGenModule_CGDecl",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this -extends=CodeGenModule_CGClass ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN5clang7CodeGen13CodeGenModule20getLLVMLifetimeEndFnEv;_ZN5clang7CodeGen13CodeGenModule22getLLVMLifetimeStartFnEv;_ZN5clang7CodeGen13CodeGenModule23EmitOMPDeclareReductionEPKNS_23OMPDeclareReductionDeclEPNS0_15CodeGenFunctionE;_ZN5clang7CodeGen13CodeGenModule24getOrCreateStaticVarDeclERKNS_7VarDeclEN4llvm11GlobalValue12LinkageTypesE; -static-type=CodeGenModule_CGDecl -package=org.clang.codegen.CodeGen.impl")
//</editor-fold>
public abstract class CodeGenModule_CGDecl extends CodeGenModule_CGClass {
private final /*split clang::CodeGen::CodeGenModule*/ CodeGenModule $this() { return (CodeGenModule)this; }

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::getOrCreateStaticVarDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp", line = 186,
 FQN="clang::CodeGen::CodeGenModule::getOrCreateStaticVarDecl", NM="_ZN5clang7CodeGen13CodeGenModule24getOrCreateStaticVarDeclERKNS_7VarDeclEN4llvm11GlobalValue12LinkageTypesE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN5clang7CodeGen13CodeGenModule24getOrCreateStaticVarDeclERKNS_7VarDeclEN4llvm11GlobalValue12LinkageTypesE")
//</editor-fold>
public final Constant /*P*/ getOrCreateStaticVarDecl(final /*const*/ VarDecl /*&*/ D, GlobalValue.LinkageTypes Linkage) {
  {
    // In general, we don't always emit static var decls once before we reference
    // them. It is possible to reference them before emitting the function that
    // contains them, and it is possible to emit the containing function multiple
    // times.
    Constant /*P*/ ExistingGV = $this().StaticLocalDeclMap.$at_T1$RR($AddrOf(D));
    if ((ExistingGV != null)) {
      return ExistingGV;
    }
  }
  
  QualType Ty = D.getType();
  assert (Ty.$arrow().isConstantSizeType()) : "VLAs can't be static";
  
  // Use the label if the variable is renamed with the asm-label extension.
  std.string Name/*J*/= new std.string();
  if (D.hasAttr(AsmLabelAttr.class)) {
    Name.$assignMove($this().getMangledName(new GlobalDecl($AddrOf(D))).$string());
  } else {
    Name.$assignMove(getStaticDeclName(/*Deref*/$this(), D));
  }
  
  org.llvm.ir.Type /*P*/ LTy = $this().getTypes().ConvertTypeForMem(new QualType(Ty));
  /*uint*/int AddrSpace = $this().GetGlobalVarAddressSpace($AddrOf(D), $this().getContext().getTargetAddressSpace(new QualType(Ty)));
  
  // Local address space cannot have an initializer.
  Constant /*P*/ Init;
  if (Ty.getAddressSpace() != LangAS.ID.opencl_local) {
    Init = $this().EmitNullConstant(new QualType(Ty));
  } else {
    Init = UndefValue.get(LTy);
  }
  
  GlobalVariable /*P*/ GV = /*NEW_EXPR [GlobalVariable::new]*/GlobalVariable.$new_GlobalVariable((type$ptr<?> New$Mem)->{
      return new GlobalVariable($this().getModule(), LTy, 
      Ty.isConstant($this().getContext()), Linkage, 
      Init, new Twine(Name), (GlobalVariable /*P*/ )null, 
      GlobalVariable.ThreadLocalMode.NotThreadLocal, 
      AddrSpace);
   });
  GV.setAlignment($long2uint($this().getContext().getDeclAlign($AddrOf(D)).getQuantity()));
  $this().setGlobalVisibility(GV, $AddrOf(D));
  if ($this().supportsCOMDAT() && GV.isWeakForLinker()) {
    GV.setComdat($this().TheModule.getOrInsertComdat(GV.getName()));
  }
  if ((D.getTLSKind().getValue() != 0)) {
    $this().setTLSMode(GV, D);
  }
  if (D.isExternallyVisible()) {
    if (D.hasAttr(DLLImportAttr.class)) {
      GV.setDLLStorageClass(GlobalVariable.DLLStorageClassTypes.DLLImportStorageClass);
    } else if (D.hasAttr(DLLExportAttr.class)) {
      GV.setDLLStorageClass(GlobalVariable.DLLStorageClassTypes.DLLExportStorageClass);
    }
  }
  
  // Make sure the result is of the correct type.
  /*uint*/int ExpectedAddrSpace = $this().getContext().getTargetAddressSpace(new QualType(Ty));
  Constant /*P*/ Addr = GV;
  if (AddrSpace != ExpectedAddrSpace) {
    PointerType /*P*/ PTy = PointerType.get(LTy, ExpectedAddrSpace);
    Addr = ConstantExpr.getAddrSpaceCast(GV, PTy);
  }
  
  $this().setStaticLocalDeclAddress($AddrOf(D), Addr);
  
  // Ensure that the static local gets initialized by making sure the parent
  // function gets emitted eventually.
  /*const*/ Decl /*P*/ DC = cast_Decl(D.getDeclContext$Const());
  
  // We can't name blocks or captured statements directly, so try to emit their
  // parents.
  if (isa_BlockDecl(DC) || isa_CapturedDecl(DC)) {
    DC = DC.getNonClosureContext$Const();
    // FIXME: Ensure that global blocks get emitted.
    if (!(DC != null)) {
      return Addr;
    }
  }
  
  GlobalDecl GD/*J*/= new GlobalDecl();
  {
    /*const*/ CXXConstructorDecl /*P*/ CD = dyn_cast_CXXConstructorDecl(DC);
    if ((CD != null)) {
      GD.$assignMove(new GlobalDecl(JD$CXXConstructorDecl$C$P_CXXCtorType.INSTANCE, CD, CXXCtorType.Ctor_Base));
    } else {
      /*const*/ CXXDestructorDecl /*P*/ DD = dyn_cast_CXXDestructorDecl(DC);
      if ((DD != null)) {
        GD.$assignMove(new GlobalDecl(JD$CXXDestructorDecl$C$P_CXXDtorType.INSTANCE, DD, CXXDtorType.Dtor_Base));
      } else {
        /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(DC);
        if ((FD != null)) {
          GD.$assignMove(new GlobalDecl(FD));
        } else {
          // Don't do anything for Obj-C method decls or global closures. We should
          // never defer them.
          assert (isa_ObjCMethodDecl(DC)) : "unexpected parent code decl";
        }
      }
    }
  }
  if ((GD.getDecl() != null)) {
    /*J:(void)*/$this().GetAddrOfGlobal(new GlobalDecl(GD));
  }
  
  return Addr;
}


///@}

/// Lazily declare the @llvm.lifetime.start intrinsic.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::getLLVMLifetimeStartFn">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp", line = 1711,
 FQN="clang::CodeGen::CodeGenModule::getLLVMLifetimeStartFn", NM="_ZN5clang7CodeGen13CodeGenModule22getLLVMLifetimeStartFnEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN5clang7CodeGen13CodeGenModule22getLLVMLifetimeStartFnEv")
//</editor-fold>
public final Constant /*P*/ getLLVMLifetimeStartFn() {
  if (($this().LifetimeStartFn != null)) {
    return $this().LifetimeStartFn;
  }
  $this().LifetimeStartFn = getDeclaration($AddrOf($this().getModule()), 
      ID.lifetime_start);
  return $this().LifetimeStartFn;
}


/// Lazily declare the @llvm.lifetime.end intrinsic.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::getLLVMLifetimeEndFn">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp", line = 1719,
 FQN="clang::CodeGen::CodeGenModule::getLLVMLifetimeEndFn", NM="_ZN5clang7CodeGen13CodeGenModule20getLLVMLifetimeEndFnEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN5clang7CodeGen13CodeGenModule20getLLVMLifetimeEndFnEv")
//</editor-fold>
public final Constant /*P*/ getLLVMLifetimeEndFn() {
  if (($this().LifetimeEndFn != null)) {
    return $this().LifetimeEndFn;
  }
  $this().LifetimeEndFn = getDeclaration($AddrOf($this().getModule()), 
      ID.lifetime_end);
  return $this().LifetimeEndFn;
}


/// \brief Emit a code for declare reduction construct.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::EmitOMPDeclareReduction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp", line = 1874,
 FQN="clang::CodeGen::CodeGenModule::EmitOMPDeclareReduction", NM="_ZN5clang7CodeGen13CodeGenModule23EmitOMPDeclareReductionEPKNS_23OMPDeclareReductionDeclEPNS0_15CodeGenFunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN5clang7CodeGen13CodeGenModule23EmitOMPDeclareReductionEPKNS_23OMPDeclareReductionDeclEPNS0_15CodeGenFunctionE")
//</editor-fold>
public final void EmitOMPDeclareReduction(/*const*/ OMPDeclareReductionDecl /*P*/ D) {
  EmitOMPDeclareReduction(D, 
                       (CodeGenFunction /*P*/ )null);
}
public final void EmitOMPDeclareReduction(/*const*/ OMPDeclareReductionDecl /*P*/ D, 
                       CodeGenFunction /*P*/ CGF/*= null*/) {
  if (!($this().LangOpts.OpenMP != 0) || (!$this().LangOpts.EmitAllDecls && !D.isUsed())) {
    return;
  }
  $this().getOpenMPRuntime().emitUserDefinedReduction(CGF, D);
}

} // END OF class CodeGenModule_CGDecl
