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
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.impl.*;
import org.clang.driver.frontend.CodeGenOptions;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstStatementsRTTI.*;
import static org.clank.support.Native.$AddrOf;
import static org.clank.support.Native.$Deref;
import static org.llvm.ir.java.IrRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type CGDeclStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.codegen.impl.CGDeclStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZL12isAccessedByPKN5clang9ValueDeclEPKNS_4ExprE;_ZL12isAccessedByRKN5clang7VarDeclEPKNS_4StmtE;_ZL12isCapturedByRKN5clang7VarDeclEPKNS_4ExprE;_ZL17getStaticDeclNameB5cxx11RN5clang7CodeGen13CodeGenModuleERKNS_7VarDeclE;_ZL22drillIntoBlockVariableRN5clang7CodeGen15CodeGenFunctionERNS0_6LValueEPKNS_7VarDeclE;_ZL22tryEmitARCCopyWeakInitRN5clang7CodeGen15CodeGenFunctionERKNS0_6LValueEPKNS_4ExprE;_ZL23EmitAutoVarWithLifetimeRN5clang7CodeGen15CodeGenFunctionERKNS_7VarDeclENS0_7AddressENS_10Qualifiers12ObjCLifetimeE;_ZL23emitPartialArrayDestroyRN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueES5_NS_8QualTypeENS_9CharUnitsEPFvS2_NS0_7AddressES6_E;_ZL24hasNontrivialDestructionN5clang8QualTypeE;_ZL25shouldEmitLifetimeMarkersRKN5clang14CodeGenOptionsERKNS_11LangOptionsE;_ZL28emitStoresForInitAfterMemsetPN4llvm8ConstantEPNS_5ValueEbRN5clang7CodeGen11CGBuilderTyE;_ZL35canEmitInitWithFewStoresAfterMemsetPN4llvm8ConstantERj;_ZL37shouldUseMemSetPlusStoresToInitializePN4llvm8ConstantEy; -static-type=CGDeclStatics -package=org.clang.codegen.impl")
//</editor-fold>
public final class CGDeclStatics {

//<editor-fold defaultstate="collapsed" desc="getStaticDeclName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp", line = 163,
 FQN="getStaticDeclName", NM="_ZL17getStaticDeclNameRN5clang7CodeGen13CodeGenModuleERKNS_7VarDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZL17getStaticDeclNameRN5clang7CodeGen13CodeGenModuleERKNS_7VarDeclE")
//</editor-fold>
public static std.string getStaticDeclName(final CodeGenModule /*&*/ CGM, final /*const*/ VarDecl /*&*/ D) {
  if (CGM.getLangOpts().CPlusPlus) {
    return CGM.getMangledName(new GlobalDecl($AddrOf(D))).str();
  }
  
  // If this isn't C++, we don't need a mangled name, just a pretty one.
  assert (!D.isExternallyVisible()) : "name shouldn't matter";
  std.string ContextName/*J*/= new std.string();
  /*const*/ DeclContext /*P*/ DC = D.getDeclContext$Const();
  {
    /*const*/ CapturedDecl /*P*/ CD = dyn_cast_CapturedDecl(DC);
    if ((CD != null)) {
      DC = cast_DeclContext(CD.getNonClosureContext$Const());
    }
  }
  {
    /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(DC);
    if ((FD != null)) {
      ContextName.$assignMove(CGM.getMangledName(new GlobalDecl(FD)).$string());
    } else {
      /*const*/ BlockDecl /*P*/ BD = dyn_cast_BlockDecl(DC);
      if ((BD != null)) {
        ContextName.$assignMove(CGM.getBlockMangledName(new GlobalDecl(), BD).$string());
      } else {
        /*const*/ ObjCMethodDecl /*P*/ OMD = dyn_cast_ObjCMethodDecl(DC);
        if ((OMD != null)) {
          ContextName.$assignMove(OMD.getSelector().getAsString());
        } else {
          throw new llvm_unreachable("Unknown context for static var decl");
        }
      }
    }
  }
  
  ContextName.$addassign($add_T$C$P_string(/*KEEP_STR*/".", D.getNameAsString()));
  return ContextName;
}


/// hasNontrivialDestruction - Determine whether a type's destruction is
/// non-trivial. If so, and the variable uses static initialization, we must
/// register its destructor to run on exit.
//<editor-fold defaultstate="collapsed" desc="hasNontrivialDestruction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp", line = 282,
 FQN="hasNontrivialDestruction", NM="_ZL24hasNontrivialDestructionN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZL24hasNontrivialDestructionN5clang8QualTypeE")
//</editor-fold>
public static boolean hasNontrivialDestruction(QualType T) {
  CXXRecordDecl /*P*/ RD = T.$arrow().getBaseElementTypeUnsafe().getAsCXXRecordDecl();
  return (RD != null) && !RD.hasTrivialDestructor();
}

// end anonymous namespace

/// EmitAutoVarWithLifetime - Does the setup required for an automatic
/// variable with lifetime.
//<editor-fold defaultstate="collapsed" desc="EmitAutoVarWithLifetime">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp", line = 536,
 FQN="EmitAutoVarWithLifetime", NM="_ZL23EmitAutoVarWithLifetimeRN5clang7CodeGen15CodeGenFunctionERKNS_7VarDeclENS0_7AddressENS_10Qualifiers12ObjCLifetimeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZL23EmitAutoVarWithLifetimeRN5clang7CodeGen15CodeGenFunctionERKNS_7VarDeclENS0_7AddressENS_10Qualifiers12ObjCLifetimeE")
//</editor-fold>
public static void EmitAutoVarWithLifetime(final CodeGenFunction /*&*/ CGF, final /*const*/ VarDecl /*&*/ var, 
                       Address addr, 
                       Qualifiers.ObjCLifetime lifetime) {
  switch (lifetime) {
   case OCL_None:
    throw new llvm_unreachable("present but none");
   case OCL_ExplicitNone:
    // nothing to do
    break;
   case OCL_Strong:
    {
      CodeGenFunction.AddressQualType2Void destroyer = /*FuncRef*/(var.hasAttr(ObjCPreciseLifetimeAttr.class) ? CodeGenFunction::destroyARCStrongPrecise : CodeGenFunction::destroyARCStrongImprecise);
      
      /*CleanupKind*//*uint*/int cleanupKind = CGF.getARCCleanupKind();
      CGF.pushDestroy(cleanupKind, new Address(addr), var.getType(), destroyer, 
          ((cleanupKind & CleanupKind.EHCleanup) != 0));
      break;
    }
   case OCL_Autoreleasing:
    // nothing to do
    break;
   case OCL_Weak:
    // __weak objects always get EH cleanups; otherwise, exceptions
    // could cause really nasty crashes instead of mere leaks.
    CGF.pushDestroy(CleanupKind.NormalAndEHCleanup, new Address(addr), var.getType(), 
        /*FuncRef*/CodeGenFunction::destroyARCWeak, 
        /*useEHCleanup*/ true);
    break;
  }
}

//<editor-fold defaultstate="collapsed" desc="isAccessedBy">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp", line = 572,
 FQN="isAccessedBy", NM="_ZL12isAccessedByRKN5clang7VarDeclEPKNS_4StmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZL12isAccessedByRKN5clang7VarDeclEPKNS_4StmtE")
//</editor-fold>
public static boolean isAccessedBy(final /*const*/ VarDecl /*&*/ var, /*const*/ Stmt /*P*/ s) {
  {
    /*const*/ Expr /*P*/ e = dyn_cast_Expr(s);
    if ((e != null)) {
      // Skip the most common kinds of expressions that make
      // hierarchy-walking expensive.
      s = e = e.IgnoreParenCasts$Const();
      {
        
        /*const*/ DeclRefExpr /*P*/ ref = dyn_cast_DeclRefExpr(e);
        if ((ref != null)) {
          return (ref.getDecl$Const() == $AddrOf(var));
        }
      }
      {
        /*const*/ BlockExpr /*P*/ be = dyn_cast_BlockExpr(e);
        if ((be != null)) {
          /*const*/ BlockDecl /*P*/ block = be.getBlockDecl$Const();
          for (final /*const*/ BlockDecl.Capture /*&*/ I : block.captures()) {
            if (I.getVariable() == $AddrOf(var)) {
              return true;
            }
          }
        }
      }
    }
  }
  
  for (/*const*/ Stmt /*P*/ SubStmt : s.children$Const())  {
    // SubStmt might be null; as in missing decl or conditional of an if-stmt.
    if ((SubStmt != null) && isAccessedBy(var, SubStmt)) {
      return true;
    }
  }
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="isAccessedBy">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp", line = 597,
 FQN="isAccessedBy", NM="_ZL12isAccessedByPKN5clang9ValueDeclEPKNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZL12isAccessedByPKN5clang9ValueDeclEPKNS_4ExprE")
//</editor-fold>
public static boolean isAccessedBy(/*const*/ ValueDecl /*P*/ decl, /*const*/ Expr /*P*/ e) {
  if (!(decl != null)) {
    return false;
  }
  if (!isa_VarDecl(decl)) {
    return false;
  }
  /*const*/ VarDecl /*P*/ var = cast_VarDecl(decl);
  return isAccessedBy($Deref(var), (Stmt)e); // JAVA: w/o cast to Stmt Java can not resolve ambiguity
}

//<editor-fold defaultstate="collapsed" desc="tryEmitARCCopyWeakInit">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp", line = 604,
 FQN="tryEmitARCCopyWeakInit", NM="_ZL22tryEmitARCCopyWeakInitRN5clang7CodeGen15CodeGenFunctionERKNS0_6LValueEPKNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZL22tryEmitARCCopyWeakInitRN5clang7CodeGen15CodeGenFunctionERKNS0_6LValueEPKNS_4ExprE")
//</editor-fold>
public static boolean tryEmitARCCopyWeakInit(final CodeGenFunction /*&*/ CGF, 
                      final /*const*/ LValue /*&*/ destLV, /*const*/ Expr /*P*/ init) {
  boolean needsCast = false;
  {
    
    /*const*/ CastExpr /*P*/ castExpr;
    while (((/*P*/ castExpr = dyn_cast_CastExpr(init.IgnoreParens$Const())) != null)) {
      switch (castExpr.getCastKind()) {
       case CK_NoOp:
       case CK_BitCast:
       case CK_BlockPointerToObjCPointerCast:
        // Look through casts that don't require representation changes.
        needsCast = true;
        break;
       case CK_LValueToRValue:
        {
          /*const*/ Expr /*P*/ srcExpr = castExpr.getSubExpr$Const();
          if (srcExpr.getType().getObjCLifetime() != Qualifiers.ObjCLifetime.OCL_Weak) {
            return false;
          }
          
          // Emit the source l-value.
          LValue srcLV = CGF.EmitLValue(srcExpr);
          
          // Handle a formal type change to avoid asserting.
          Address srcAddr = srcLV.getAddress();
          if (needsCast) {
            srcAddr.$assignMove(CGF.Builder.CreateElementBitCast(new Address(srcAddr), 
                    destLV.getAddress().getElementType()));
          }
          
          // If it was an l-value, use objc_copyWeak.
          if (srcExpr.getValueKind() == ExprValueKind.VK_LValue) {
            CGF.EmitARCCopyWeak(destLV.getAddress(), new Address(srcAddr));
          } else {
            assert (srcExpr.getValueKind() == ExprValueKind.VK_XValue);
            CGF.EmitARCMoveWeak(destLV.getAddress(), new Address(srcAddr));
          }
          return true;
        }
       default:
        
        // Stop at anything else.
        return false;
      }
      
      init = castExpr.getSubExpr$Const();
    }
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="drillIntoBlockVariable">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp", line = 654,
 FQN="drillIntoBlockVariable", NM="_ZL22drillIntoBlockVariableRN5clang7CodeGen15CodeGenFunctionERNS0_6LValueEPKNS_7VarDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZL22drillIntoBlockVariableRN5clang7CodeGen15CodeGenFunctionERNS0_6LValueEPKNS_7VarDeclE")
//</editor-fold>
public static void drillIntoBlockVariable(final CodeGenFunction /*&*/ CGF, 
                      final LValue /*&*/ lvalue, 
                      /*const*/ VarDecl /*P*/ var) {
  lvalue.setAddress(CGF.emitBlockByrefAddress(lvalue.getAddress(), var));
}


/// canEmitInitWithFewStoresAfterMemset - Decide whether we can emit the
/// non-zero parts of the specified initializer with equal or fewer than
/// NumStores scalar stores.
//<editor-fold defaultstate="collapsed" desc="canEmitInitWithFewStoresAfterMemset">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp", line = 802,
 FQN="canEmitInitWithFewStoresAfterMemset", NM="_ZL35canEmitInitWithFewStoresAfterMemsetPN4llvm8ConstantERj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZL35canEmitInitWithFewStoresAfterMemsetPN4llvm8ConstantERj")
//</editor-fold>
public static boolean canEmitInitWithFewStoresAfterMemset(Constant /*P*/ Init, 
                                   final uint$ref/*uint &*/ NumStores) {
  // Zero and Undef never requires any extra stores.
  if (isa_ConstantAggregateZero(Init)
     || isa_ConstantPointerNull(Init)
     || isa_UndefValue(Init)) {
    return true;
  }
  if (isa_ConstantInt(Init) || isa_ConstantFP(Init)
     || isa_ConstantVector(Init) || isa_BlockAddress(Init)
     || isa_ConstantExpr(Init)) {
    return Init.isNullValue() || ((NumStores.$set$postDec()) != 0);
  }
  
  // See if we can emit each element.
  if (isa_ConstantArray(Init) || isa_ConstantStruct(Init)) {
    for (/*uint*/int i = 0, e = Init.getNumOperands$User(); i != e; ++i) {
      Constant /*P*/ Elt = cast_Constant(Init.getOperand(i));
      if (!canEmitInitWithFewStoresAfterMemset(Elt, NumStores)) {
        return false;
      }
    }
    return true;
  }
  {
    
    ConstantDataSequential /*P*/ CDS = dyn_cast_ConstantDataSequential(Init);
    if ((CDS != null)) {
      for (/*uint*/int i = 0, e = CDS.getNumElements(); i != e; ++i) {
        Constant /*P*/ Elt = CDS.getElementAsConstant(i);
        if (!canEmitInitWithFewStoresAfterMemset(Elt, NumStores)) {
          return false;
        }
      }
      return true;
    }
  }
  
  // Anything else is hard and scary.
  return false;
}


/// emitStoresForInitAfterMemset - For inits that
/// canEmitInitWithFewStoresAfterMemset returned true for, emit the scalar
/// stores that would be required.
//<editor-fold defaultstate="collapsed" desc="emitStoresForInitAfterMemset">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp", line = 841,
 FQN="emitStoresForInitAfterMemset", NM="_ZL28emitStoresForInitAfterMemsetPN4llvm8ConstantEPNS_5ValueEbRN5clang7CodeGen11CGBuilderTyE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZL28emitStoresForInitAfterMemsetPN4llvm8ConstantEPNS_5ValueEbRN5clang7CodeGen11CGBuilderTyE")
//</editor-fold>
public static void emitStoresForInitAfterMemset(Constant /*P*/ Init, Value /*P*/ Loc, 
                            boolean isVolatile, final CGBuilderTy /*&*/ Builder) {
  assert (!Init.isNullValue() && !isa_UndefValue(Init)) : "called emitStoresForInitAfterMemset for zero or undef value.";
  if (isa_ConstantInt(Init) || isa_ConstantFP(Init)
     || isa_ConstantVector(Init) || isa_BlockAddress(Init)
     || isa_ConstantExpr(Init)) {
    Builder.CreateDefaultAlignedStore(Init, Loc, isVolatile);
    return;
  }
  {
    
    ConstantDataSequential /*P*/ CDS = dyn_cast_ConstantDataSequential(Init);
    if ((CDS != null)) {
      for (/*uint*/int i = 0, e = CDS.getNumElements(); i != e; ++i) {
        Constant /*P*/ Elt = CDS.getElementAsConstant(i);
        
        // If necessary, get a pointer to the element and emit it.
        if (!Elt.isNullValue() && !isa_UndefValue(Elt)) {
          emitStoresForInitAfterMemset(Elt, Builder.CreateConstGEP2_32(Init.getType(), Loc, 0, i), 
              isVolatile, Builder);
        }
      }
      return;
    }
  }
  assert ((isa_ConstantStruct(Init) || isa_ConstantArray(Init))) : "Unknown value type!";
  
  for (/*uint*/int i = 0, e = Init.getNumOperands$User(); i != e; ++i) {
    Constant /*P*/ Elt = cast_Constant(Init.getOperand(i));
    
    // If necessary, get a pointer to the element and emit it.
    if (!Elt.isNullValue() && !isa_UndefValue(Elt)) {
      emitStoresForInitAfterMemset(Elt, Builder.CreateConstGEP2_32(Init.getType(), Loc, 0, i), 
          isVolatile, Builder);
    }
  }
}


/// shouldUseMemSetPlusStoresToInitialize - Decide whether we should use memset
/// plus some stores to initialize a local variable instead of using a memcpy
/// from a constant global.  It is beneficial to use memset if the global is all
/// zeros, or mostly zeros and large.
//<editor-fold defaultstate="collapsed" desc="shouldUseMemSetPlusStoresToInitialize">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp", line = 885,
 FQN="shouldUseMemSetPlusStoresToInitialize", NM="_ZL37shouldUseMemSetPlusStoresToInitializePN4llvm8ConstantEy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZL37shouldUseMemSetPlusStoresToInitializePN4llvm8ConstantEy")
//</editor-fold>
public static boolean shouldUseMemSetPlusStoresToInitialize(Constant /*P*/ Init, 
                                     long/*uint64_t*/ GlobalSize) {
  // If a global is all zeros, always use a memset.
  if (isa_ConstantAggregateZero(Init)) {
    return true;
  }
  
  // If a non-zero global is <= 32 bytes, always use a memcpy.  If it is large,
  // do it if it will require 6 or fewer scalar stores.
  // TODO: Should budget depends on the size?  Avoiding a large global warrants
  // plopping in more stores.
  uint$ref StoreBudget = create_uint$ref(6);
  long/*uint64_t*/ SizeLimit = $int2ulong(32);
  
  return $greater_ulong(GlobalSize, SizeLimit)
     && canEmitInitWithFewStoresAfterMemset(Init, StoreBudget);
}


/// shouldEmitLifetimeMarkers - Decide whether we need emit the life-time
/// markers.
//<editor-fold defaultstate="collapsed" desc="shouldEmitLifetimeMarkers">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp", line = 912,
 FQN="shouldEmitLifetimeMarkers", NM="_ZL25shouldEmitLifetimeMarkersRKN5clang14CodeGenOptionsERKNS_11LangOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZL25shouldEmitLifetimeMarkersRKN5clang14CodeGenOptionsERKNS_11LangOptionsE")
//</editor-fold>
public static boolean shouldEmitLifetimeMarkers(final /*const*/ CodeGenOptions /*&*/ CGOpts, 
                         final /*const*/ LangOptions /*&*/ LangOpts) {
  // Asan uses markers for use-after-scope checks.
  if (CGOpts.SanitizeAddressUseAfterScope) {
    return true;
  }
  
  // Disable lifetime markers in msan builds.
  // FIXME: Remove this when msan works with lifetime markers.
  if (LangOpts.Sanitize.has(SanitizerKind.Memory)) {
    return false;
  }
  
  // For now, only in optimized builds.
  return $2bits_uint2uint(CGOpts.OptimizationLevel) != 0;
}


/// Determines whether the given __block variable is potentially
/// captured by the given expression.
//<editor-fold defaultstate="collapsed" desc="isCapturedBy">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp", line = 1115,
 FQN="isCapturedBy", NM="_ZL12isCapturedByRKN5clang7VarDeclEPKNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZL12isCapturedByRKN5clang7VarDeclEPKNS_4ExprE")
//</editor-fold>
public static boolean isCapturedBy(final /*const*/ VarDecl /*&*/ var, /*const*/ Expr /*P*/ e) {
  // Skip the most common kinds of expressions that make
  // hierarchy-walking expensive.
  e = e.IgnoreParenCasts$Const();
  {
    
    /*const*/ BlockExpr /*P*/ be = dyn_cast_BlockExpr(e);
    if ((be != null)) {
      /*const*/ BlockDecl /*P*/ block = be.getBlockDecl$Const();
      for (final /*const*/ BlockDecl.Capture /*&*/ I : block.captures()) {
        if (I.getVariable() == $AddrOf(var)) {
          return true;
        }
      }
      
      // No need to walk into the subexpressions.
      return false;
    }
  }
  {
    
    /*const*/ StmtExpr /*P*/ SE = dyn_cast_StmtExpr(e);
    if ((SE != null)) {
      /*const*/ CompoundStmt /*P*/ CS = SE.getSubStmt$Const();
      for (/*const*/ Stmt /*P*/ BI : CS.body$Const())  {
        {
          /*const*/ Expr /*P*/ E = dyn_cast_Expr(BI);
          if ((E != null)) {
            if (isCapturedBy(var, E)) {
              return true;
            }
          } else {
            /*const*/ DeclStmt /*P*/ DS = dyn_cast_DeclStmt(BI);
            if ((DS != null)) {
              // special case declarations
              for (/*const*/ Decl /*P*/ I : DS.decls$Const()) {
                {
                  /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl((I));
                  if ((VD != null)) {
                    /*const*/ Expr /*P*/ Init = VD.getInit$Const();
                    if ((Init != null) && isCapturedBy(var, Init)) {
                      return true;
                    }
                  }
                }
              }
            } else {
              // FIXME. Make safe assumption assuming arbitrary statements cause capturing.
              // Later, provide code to poke into statements for capture analysis.
              return true;
            }
          }
        }
      }
      return false;
    }
  }
  
  for (/*const*/ Stmt /*P*/ SubStmt : e.children$Const())  {
    if (isCapturedBy(var, cast_Expr(SubStmt))) {
      return true;
    }
  }
  
  return false;
}


/// Perform partial array destruction as if in an EH cleanup.  Unlike
/// emitArrayDestroy, the element type here may still be an array type.
//<editor-fold defaultstate="collapsed" desc="emitPartialArrayDestroy">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp", line = 1597,
 FQN="emitPartialArrayDestroy", NM="_ZL23emitPartialArrayDestroyRN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueES5_NS_8QualTypeENS_9CharUnitsEPFvS2_NS0_7AddressES6_E",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZL23emitPartialArrayDestroyRN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueES5_NS_8QualTypeENS_9CharUnitsEPFvS2_NS0_7AddressES6_E")
//</editor-fold>
public static void emitPartialArrayDestroy(final CodeGenFunction /*&*/ CGF, 
                       Value /*P*/ begin, Value /*P*/ end, 
                       QualType type, CharUnits elementAlign, 
                       CodeGenFunction.AddressQualType2Void destroyer) {
  // If the element type is itself an array, drill down.
  /*uint*/int arrayDepth = 0;
  {
    /*const*/ org.clang.ast.ArrayType /*P*/ arrayType;
    while (((/*P*/ arrayType = CGF.getContext().getAsArrayType(new QualType(type))) != null)) {
      // VLAs don't require a GEP index to walk into.
      if (!isa_VariableArrayType(arrayType)) {
        arrayDepth++;
      }
      type.$assignMove(arrayType.getElementType());
    }
  }
  if ((arrayDepth != 0)) {
    Value /*P*/ zero = ConstantInt.get(CGF.Unnamed_field8.SizeTy, $int2ulong(0));
    
    SmallVector<Value /*P*/ > gepIndices/*J*/= new SmallVector<Value /*P*/ >(JD$UInt_T$C$R.INSTANCE, 4, arrayDepth + 1, zero, (Value /*P*/ )null);
    begin = CGF.Builder.CreateInBoundsGEP(begin, new ArrayRef<Value /*P*/ >(gepIndices, true), new Twine(/*KEEP_STR*/"pad.arraybegin"));
    end = CGF.Builder.CreateInBoundsGEP(end, new ArrayRef<Value /*P*/ >(gepIndices, true), new Twine(/*KEEP_STR*/"pad.arrayend"));
  }
  
  // Destroy the array.  We don't ever need an EH cleanup because we
  // assume that we're in an EH cleanup ourselves, so a throwing
  // destructor causes an immediate terminate.
  CGF.emitArrayDestroy(begin, end, new QualType(type), new CharUnits(elementAlign), destroyer, 
      /*checkZeroLength*/ true, /*useEHCleanup*/ false);
}

} // END OF class CGDeclStatics
