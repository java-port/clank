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

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.impl.*;
import org.llvm.ir.FunctionType;
import org.llvm.ir.Type;
import org.llvm.ir.intrinsic.ID;
import static org.clang.codegen.java.CodegenRTTI.*;
import static org.llvm.ir.java.IrRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type CGExceptionStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZL12isNonEHScopeRKN5clang7CodeGen7EHScopeE;_ZL15getCPersonalityRKN4llvm6TripleERKN5clang11LangOptionsE;_ZL15getUnexpectedFnRN5clang7CodeGen13CodeGenModuleE;_ZL16getCatchAllValueRN5clang7CodeGen15CodeGenFunctionE;_ZL16getPersonalityFnRN5clang7CodeGen13CodeGenModuleERKNS0_13EHPersonalityE;_ZL17emitCatchPadBlockRN5clang7CodeGen15CodeGenFunctionERNS0_12EHCatchScopeE;_ZL17getCXXPersonalityRKN4llvm6TripleERKN5clang11LangOptionsE;_ZL18getFreeExceptionFnRN5clang7CodeGen13CodeGenModuleE;_ZL18getObjCPersonalityRKN4llvm6TripleERKN5clang11LangOptionsE;_ZL20getCatchallRethrowFnRN5clang7CodeGen13CodeGenModuleEN4llvm9StringRefE;_ZL20getObjCXXPersonalityRKN4llvm6TripleERKN5clang11LangOptionsE;_ZL21getSEHPersonalityMSVCRKN4llvm6TripleE;_ZL22emitCatchDispatchBlockRN5clang7CodeGen15CodeGenFunctionERNS0_12EHCatchScopeE;_ZL22getOpaquePersonalityFnRN5clang7CodeGen13CodeGenModuleERKNS0_13EHPersonalityE;_ZL23emitFilterDispatchBlockRN5clang7CodeGen15CodeGenFunctionERNS0_13EHFilterScopeE;_ZL23useLibGCCSEHPersonalityRKN4llvm6TripleE;_ZL24LandingPadHasOnlyCXXUsesPN4llvm14LandingPadInstE;_ZL25PersonalityHasOnlyCXXUsesPN4llvm8ConstantE; -static-type=CGExceptionStatics -package=org.clang.codegen.impl")
//</editor-fold>
public final class CGExceptionStatics {

//<editor-fold defaultstate="collapsed" desc="getFreeExceptionFn">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp", line = 32,
 FQN="getFreeExceptionFn", NM="_ZL18getFreeExceptionFnRN5clang7CodeGen13CodeGenModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZL18getFreeExceptionFnRN5clang7CodeGen13CodeGenModuleE")
//</editor-fold>
public static Constant /*P*/ getFreeExceptionFn(final CodeGenModule /*&*/ CGM) {
  // void __cxa_free_exception(void *thrown_exception);
  FunctionType /*P*/ FTy = FunctionType.get(CGM.VoidTy, new ArrayRef<Type /*P*/ >(CGM.Unnamed_field9.Int8PtrTy, true), /*IsVarArgs=*/ false);
  
  return CGM.CreateRuntimeFunction(FTy, new StringRef(/*KEEP_STR*/"__cxa_free_exception"));
}

//<editor-fold defaultstate="collapsed" desc="getUnexpectedFn">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp", line = 41,
 FQN="getUnexpectedFn", NM="_ZL15getUnexpectedFnRN5clang7CodeGen13CodeGenModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZL15getUnexpectedFnRN5clang7CodeGen13CodeGenModuleE")
//</editor-fold>
public static Constant /*P*/ getUnexpectedFn(final CodeGenModule /*&*/ CGM) {
  // void __cxa_call_unexpected(void *thrown_exception);
  FunctionType /*P*/ FTy = FunctionType.get(CGM.VoidTy, new ArrayRef<Type /*P*/ >(CGM.Unnamed_field9.Int8PtrTy, true), /*IsVarArgs=*/ false);
  
  return CGM.CreateRuntimeFunction(FTy, new StringRef(/*KEEP_STR*/"__cxa_call_unexpected"));
}

//<editor-fold defaultstate="collapsed" desc="getCatchallRethrowFn">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp", line = 76,
 FQN="getCatchallRethrowFn", NM="_ZL20getCatchallRethrowFnRN5clang7CodeGen13CodeGenModuleEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZL20getCatchallRethrowFnRN5clang7CodeGen13CodeGenModuleEN4llvm9StringRefE")
//</editor-fold>
public static Constant /*P*/ getCatchallRethrowFn(final CodeGenModule /*&*/ CGM, 
                    StringRef Name) {
  FunctionType /*P*/ FTy = FunctionType.get(CGM.VoidTy, new ArrayRef<Type /*P*/ >(CGM.Unnamed_field9.Int8PtrTy, true), /*IsVarArgs=*/ false);
  
  return CGM.CreateRuntimeFunction(FTy, new StringRef(Name));
}


/// On Win64, use libgcc's SEH personality function. We fall back to dwarf on
/// other platforms, unless the user asked for SjLj exceptions.
//<editor-fold defaultstate="collapsed" desc="useLibGCCSEHPersonality">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp", line = 112,
 FQN="useLibGCCSEHPersonality", NM="_ZL23useLibGCCSEHPersonalityRKN4llvm6TripleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZL23useLibGCCSEHPersonalityRKN4llvm6TripleE")
//</editor-fold>
public static boolean useLibGCCSEHPersonality(final /*const*/ Triple /*&*/ T) {
  return T.isOSWindows() && T.getArch() == Triple.ArchType.x86_64;
}

//<editor-fold defaultstate="collapsed" desc="getCPersonality">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp", line = 116,
 FQN="getCPersonality", NM="_ZL15getCPersonalityRKN4llvm6TripleERKN5clang11LangOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZL15getCPersonalityRKN4llvm6TripleERKN5clang11LangOptionsE")
//</editor-fold>
public static /*const*/ EHPersonality /*&*/ getCPersonality(final /*const*/ Triple /*&*/ T, 
               final /*const*/ LangOptions /*&*/ L) {
  if (L.SjLjExceptions) {
    return EHPersonality.GNU_C_SJLJ;
  } else if (useLibGCCSEHPersonality(T)) {
    return EHPersonality.GNU_C_SEH;
  }
  return EHPersonality.GNU_C;
}

//<editor-fold defaultstate="collapsed" desc="getObjCPersonality">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp", line = 125,
 FQN="getObjCPersonality", NM="_ZL18getObjCPersonalityRKN4llvm6TripleERKN5clang11LangOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZL18getObjCPersonalityRKN4llvm6TripleERKN5clang11LangOptionsE")
//</editor-fold>
public static /*const*/ EHPersonality /*&*/ getObjCPersonality(final /*const*/ Triple /*&*/ T, 
                  final /*const*/ LangOptions /*&*/ L) {
  switch (L.ObjCRuntime.getKind()) {
   case FragileMacOSX:
    return getCPersonality(T, L);
   case MacOSX:
   case iOS:
   case WatchOS:
    return EHPersonality.NeXT_ObjC;
   case GNUstep:
    if (VersionTuple.$greatereq_VersionTuple$C(L.ObjCRuntime.getVersion(), new VersionTuple(1, 7))) {
      return EHPersonality.GNUstep_ObjC;
    }
   case GCC:
   case ObjFW:
    // fallthrough
    return EHPersonality.GNU_ObjC;
  }
  throw new llvm_unreachable("bad runtime kind");
}

//<editor-fold defaultstate="collapsed" desc="getCXXPersonality">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp", line = 145,
 FQN="getCXXPersonality", NM="_ZL17getCXXPersonalityRKN4llvm6TripleERKN5clang11LangOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZL17getCXXPersonalityRKN4llvm6TripleERKN5clang11LangOptionsE")
//</editor-fold>
public static /*const*/ EHPersonality /*&*/ getCXXPersonality(final /*const*/ Triple /*&*/ T, 
                 final /*const*/ LangOptions /*&*/ L) {
  if (L.SjLjExceptions) {
    return EHPersonality.GNU_CPlusPlus_SJLJ;
  } else if (useLibGCCSEHPersonality(T)) {
    return EHPersonality.GNU_CPlusPlus_SEH;
  }
  return EHPersonality.GNU_CPlusPlus;
}


/// Determines the personality function to use when both C++
/// and Objective-C exceptions are being caught.
//<editor-fold defaultstate="collapsed" desc="getObjCXXPersonality">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp", line = 156,
 FQN="getObjCXXPersonality", NM="_ZL20getObjCXXPersonalityRKN4llvm6TripleERKN5clang11LangOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZL20getObjCXXPersonalityRKN4llvm6TripleERKN5clang11LangOptionsE")
//</editor-fold>
public static /*const*/ EHPersonality /*&*/ getObjCXXPersonality(final /*const*/ Triple /*&*/ T, 
                    final /*const*/ LangOptions /*&*/ L) {
  switch (L.ObjCRuntime.getKind()) {
   case MacOSX:
   case iOS:
   case WatchOS:
    // The ObjC personality defers to the C++ personality for non-ObjC
    // handlers.  Unlike the C++ case, we use the same personality
    // function on targets using (backend-driven) SJLJ EH.
    return EHPersonality.NeXT_ObjC;
   case FragileMacOSX:
    
    // In the fragile ABI, just use C++ exception handling and hope
    // they're not doing crazy exception mixing.
    return getCXXPersonality(T, L);
   case GCC:
   case ObjFW: // XXX: this will change soon
    return EHPersonality.GNU_ObjC;
   case GNUstep:
    return EHPersonality.GNU_ObjCXX;
  }
  throw new llvm_unreachable("bad runtime kind");
}

//<editor-fold defaultstate="collapsed" desc="getSEHPersonalityMSVC">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp", line = 183,
 FQN="getSEHPersonalityMSVC", NM="_ZL21getSEHPersonalityMSVCRKN4llvm6TripleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZL21getSEHPersonalityMSVCRKN4llvm6TripleE")
//</editor-fold>
public static /*const*/ EHPersonality /*&*/ getSEHPersonalityMSVC(final /*const*/ Triple /*&*/ T) {
  if (T.getArch() == Triple.ArchType.x86) {
    return EHPersonality.MSVC_except_handler;
  }
  return EHPersonality.MSVC_C_specific_handler;
}

//<editor-fold defaultstate="collapsed" desc="getPersonalityFn">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp", line = 222,
 FQN="getPersonalityFn", NM="_ZL16getPersonalityFnRN5clang7CodeGen13CodeGenModuleERKNS0_13EHPersonalityE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZL16getPersonalityFnRN5clang7CodeGen13CodeGenModuleERKNS0_13EHPersonalityE")
//</editor-fold>
public static Constant /*P*/ getPersonalityFn(final CodeGenModule /*&*/ CGM, 
                final /*const*/ EHPersonality /*&*/ Personality) {
  Constant /*P*/ Fn = CGM.CreateRuntimeFunction(FunctionType.get(CGM.Int32Ty, true), 
      new StringRef(Personality.PersonalityFn));
  return Fn;
}

//<editor-fold defaultstate="collapsed" desc="getOpaquePersonalityFn">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp", line = 230,
 FQN="getOpaquePersonalityFn", NM="_ZL22getOpaquePersonalityFnRN5clang7CodeGen13CodeGenModuleERKNS0_13EHPersonalityE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZL22getOpaquePersonalityFnRN5clang7CodeGen13CodeGenModuleERKNS0_13EHPersonalityE")
//</editor-fold>
public static Constant /*P*/ getOpaquePersonalityFn(final CodeGenModule /*&*/ CGM, 
                      final /*const*/ EHPersonality /*&*/ Personality) {
  Constant /*P*/ Fn = getPersonalityFn(CGM, Personality);
  return ConstantExpr.getBitCast(Fn, CGM.Unnamed_field9.Int8PtrTy);
}


/// Check whether a landingpad instruction only uses C++ features.
//<editor-fold defaultstate="collapsed" desc="LandingPadHasOnlyCXXUses">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp", line = 237,
 FQN="LandingPadHasOnlyCXXUses", NM="_ZL24LandingPadHasOnlyCXXUsesPN4llvm14LandingPadInstE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZL24LandingPadHasOnlyCXXUsesPN4llvm14LandingPadInstE")
//</editor-fold>
public static boolean LandingPadHasOnlyCXXUses(LandingPadInst /*P*/ LPI) {
  for (/*uint*/int I = 0, E = LPI.getNumClauses(); I != E; ++I) {
    // Look for something that would've been returned by the ObjC
    // runtime's GetEHType() method.
    Value /*P*/ Val = LPI.getClause(I).stripPointerCasts();
    if (LPI.isCatch(I)) {
      {
        // Check if the catch value has the ObjC prefix.
        GlobalVariable /*P*/ GV = dyn_cast_GlobalVariable(Val);
        if ((GV != null)) {
          // ObjC EH selector entries are always global variables with
          // names starting like this.
          if (GV.getName().startswith(/*STRINGREF_STR*/"OBJC_EHTYPE")) {
            return false;
          }
        }
      }
    } else {
      // Check if any of the filter values have the ObjC prefix.
      Constant /*P*/ CVal = cast_Constant(Val);
      for (type$ptr<Use/*P*/> II = $tryClone(CVal.op_begin()), /*P*/ IE = $tryClone(CVal.op_end()); $noteq_ptr(II, IE); II.$preInc()) {
        {
          GlobalVariable /*P*/ GV = cast_GlobalVariable((II.$star()).$arrow().stripPointerCasts());
          if ((GV != null)) {
            // ObjC EH selector entries are always global variables with
            // names starting like this.
            if (GV.getName().startswith(/*STRINGREF_STR*/"OBJC_EHTYPE")) {
              return false;
            }
          }
        }
      }
    }
  }
  return true;
}


/// Check whether a personality function could reasonably be swapped
/// for a C++ personality function.
//<editor-fold defaultstate="collapsed" desc="PersonalityHasOnlyCXXUses">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp", line = 268,
 FQN="PersonalityHasOnlyCXXUses", NM="_ZL25PersonalityHasOnlyCXXUsesPN4llvm8ConstantE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZL25PersonalityHasOnlyCXXUsesPN4llvm8ConstantE")
//</editor-fold>
public static boolean PersonalityHasOnlyCXXUses(Constant /*P*/ Fn) {
  for (User /*P*/ U : Fn.users()) {
    {
      // Conditionally white-list bitcasts.
      ConstantExpr /*P*/ CE = dyn_cast_ConstantExpr(U);
      if ((CE != null)) {
        if (CE.getOpcode() != Instruction.CastOps.BitCast) {
          return false;
        }
        if (!PersonalityHasOnlyCXXUses(CE)) {
          return false;
        }
        continue;
      }
    }
    
    // Otherwise it must be a function.
    Function /*P*/ F = dyn_cast_Function(U);
    if (!(F != null)) {
      return false;
    }
    
    for (ilist_iterator<BasicBlock> BB = F.begin(), E = F.end(); BB.$noteq(E); BB.$preInc()) {
      if (BB.$arrow().isLandingPad()) {
        if (!LandingPadHasOnlyCXXUses(BB.$arrow().getLandingPadInst())) {
          return false;
        }
      }
    }
  }
  
  return true;
}


/// Returns the value to inject into a selector to indicate the
/// presence of a catch-all.
//<editor-fold defaultstate="collapsed" desc="getCatchAllValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp", line = 336,
 FQN="getCatchAllValue", NM="_ZL16getCatchAllValueRN5clang7CodeGen15CodeGenFunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZL16getCatchAllValueRN5clang7CodeGen15CodeGenFunctionE")
//</editor-fold>
public static Constant /*P*/ getCatchAllValue(final CodeGenFunction /*&*/ CGF) {
  // Possibly we should use @llvm.eh.catch.all.value here.
  return ConstantPointerNull.get(CGF.Unnamed_field9.Int8PtrTy);
}


/// Emit the dispatch block for a filter scope if necessary.
//<editor-fold defaultstate="collapsed" desc="emitFilterDispatchBlock">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp", line = 466,
 FQN="emitFilterDispatchBlock", NM="_ZL23emitFilterDispatchBlockRN5clang7CodeGen15CodeGenFunctionERNS0_13EHFilterScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZL23emitFilterDispatchBlockRN5clang7CodeGen15CodeGenFunctionERNS0_13EHFilterScopeE")
//</editor-fold>
public static void emitFilterDispatchBlock(final CodeGenFunction /*&*/ CGF, 
                       final EHFilterScope /*&*/ filterScope) {
  BasicBlock /*P*/ dispatchBlock = filterScope.getCachedEHDispatchBlock();
  if (!(dispatchBlock != null)) {
    return;
  }
  if (dispatchBlock.use_empty()) {
    /*delete*/Destructors.$destroy((Destructors.ClassWithDestructor)dispatchBlock);
    return;
  }
  
  CGF.EmitBlockAfterUses(dispatchBlock);
  
  // If this isn't a catch-all filter, we need to check whether we got
  // here because the filter triggered.
  if ((filterScope.getNumFilters() != 0)) {
    // Load the selector value.
    Value /*P*/ selector = CGF.getSelectorFromSlot();
    BasicBlock /*P*/ unexpectedBB = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"ehspec.unexpected"));
    
    Value /*P*/ zero = CGF.Builder.getInt32(0);
    Value /*P*/ failsFilter = CGF.Builder.CreateICmpSLT(selector, zero, new Twine(/*KEEP_STR*/"ehspec.fails"));
    CGF.Builder.CreateCondBr(failsFilter, unexpectedBB, 
        CGF.getEHResumeBlock(false));
    
    CGF.EmitBlock(unexpectedBB);
  }
  
  // Call __cxa_call_unexpected.  This doesn't need to be an invoke
  // because __cxa_call_unexpected magically filters exceptions
  // according to the last landing pad the exception was thrown
  // into.  Seriously.
  Value /*P*/ exn = CGF.getExceptionFromSlot();
  CGF.EmitRuntimeCall(getUnexpectedFn(CGF.CGM), new ArrayRef<Value /*P*/ >(exn, true)).
      setDoesNotReturn();
  CGF.Builder.CreateUnreachable();
}


/// Check whether this is a non-EH scope, i.e. a scope which doesn't
/// affect exception handling.  Currently, the only non-EH scopes are
/// normal-only cleanup scopes.
//<editor-fold defaultstate="collapsed" desc="isNonEHScope">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp", line = 671,
 FQN="isNonEHScope", NM="_ZL12isNonEHScopeRKN5clang7CodeGen7EHScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZL12isNonEHScopeRKN5clang7CodeGen7EHScopeE")
//</editor-fold>
public static boolean isNonEHScope(final /*const*/ EHScope /*&*/ S) {
  switch (S.getKind()) {
   case Cleanup:
    return !cast_EHCleanupScope(S).isEHCleanup();
   case Filter:
   case Catch:
   case Terminate:
   case PadEnd:
    return false;
  }
  throw new llvm_unreachable("Invalid EHScope Kind!");
}

//<editor-fold defaultstate="collapsed" desc="emitCatchPadBlock">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp", line = 876,
 FQN="emitCatchPadBlock", NM="_ZL17emitCatchPadBlockRN5clang7CodeGen15CodeGenFunctionERNS0_12EHCatchScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZL17emitCatchPadBlockRN5clang7CodeGen15CodeGenFunctionERNS0_12EHCatchScopeE")
//</editor-fold>
public static void emitCatchPadBlock(final CodeGenFunction /*&*/ CGF, final EHCatchScope /*&*/ CatchScope) {
  BasicBlock /*P*/ DispatchBlock = CatchScope.getCachedEHDispatchBlock();
  assert Native.$bool(DispatchBlock);
  
  CGBuilderTy.InsertPoint SavedIP = CGF.Builder.saveIP();
  CGF.EmitBlockAfterUses(DispatchBlock);
  
  Value /*P*/ ParentPad = CGF.CurrentFuncletPad;
  if (!(ParentPad != null)) {
    ParentPad = ConstantTokenNone.get(CGF.getLLVMContext());
  }
  BasicBlock /*P*/ UnwindBB = CGF.getEHDispatchBlock(CatchScope.getEnclosingEHScope());
  
  /*uint*/int NumHandlers = CatchScope.getNumHandlers();
  CatchSwitchInst /*P*/ CatchSwitch = CGF.Builder.CreateCatchSwitch(ParentPad, UnwindBB, NumHandlers);
  
  // Test against each of the exception types we claim to catch.
  for (/*uint*/int I = 0; $less_uint(I, NumHandlers); ++I) {
    final /*const*/ EHCatchScope.Handler /*&*/ Handler = CatchScope.getHandler(I);
    
    CatchTypeInfo TypeInfo = new CatchTypeInfo(Handler.Type);
    if (!(TypeInfo.RTTI != null)) {
      TypeInfo.RTTI = Constant.getNullValue(CGF.Unnamed_field9.VoidPtrTy);
    }
    
    CGF.Builder.SetInsertPoint(Handler.Block);
    if (EHPersonality.get(CGF).isMSVCXXPersonality()) {
      CGF.Builder.CreateCatchPad(CatchSwitch, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*3*/] {
                TypeInfo.RTTI, CGF.Builder.getInt32(TypeInfo.Flags), 
                Constant.getNullValue(CGF.Unnamed_field9.VoidPtrTy)}, true)/* }*/);
    } else {
      CGF.Builder.CreateCatchPad(CatchSwitch, /*{ */new ArrayRef<Value /*P*/ >(new Value /*P*/ /*const*/ [/*1*/] {TypeInfo.RTTI}, true)/* }*/);
    }
    
    CatchSwitch.addHandler(Handler.Block);
  }
  CGF.Builder.restoreIP(new IRBuilderBase.InsertPoint(SavedIP));
}


/// Emit the structure of the dispatch block for the given catch scope.
/// It is an invariant that the dispatch block already exists.
//<editor-fold defaultstate="collapsed" desc="emitCatchDispatchBlock">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp", line = 918,
 FQN="emitCatchDispatchBlock", NM="_ZL22emitCatchDispatchBlockRN5clang7CodeGen15CodeGenFunctionERNS0_12EHCatchScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZL22emitCatchDispatchBlockRN5clang7CodeGen15CodeGenFunctionERNS0_12EHCatchScopeE")
//</editor-fold>
public static void emitCatchDispatchBlock(final CodeGenFunction /*&*/ CGF, 
                      final EHCatchScope /*&*/ catchScope) {
  if (EHPersonality.get(CGF).usesFuncletPads()) {
    emitCatchPadBlock(CGF, catchScope);
    /*JAVA:return*/return;
  }
  
  BasicBlock /*P*/ dispatchBlock = catchScope.getCachedEHDispatchBlock();
  assert Native.$bool(dispatchBlock);
  
  // If there's only a single catch-all, getEHDispatchBlock returned
  // that catch-all as the dispatch block.
  if (catchScope.getNumHandlers() == 1
     && catchScope.getHandler(0).isCatchAll()) {
    assert (dispatchBlock == catchScope.getHandler(0).Block);
    return;
  }
  
  CGBuilderTy.InsertPoint savedIP = CGF.Builder.saveIP();
  CGF.EmitBlockAfterUses(dispatchBlock);
  
  // Select the right handler.
  Value /*P*/ llvm_eh_typeid_for = CGF.CGM.getIntrinsic(ID.eh_typeid_for);
  
  // Load the selector value.
  Value /*P*/ selector = CGF.getSelectorFromSlot();
  
  // Test against each of the exception types we claim to catch.
  for (/*uint*/int i = 0, e = catchScope.getNumHandlers();; ++i) {
    assert ($less_uint(i, e)) : "ran off end of handlers!";
    final /*const*/ EHCatchScope.Handler /*&*/ handler = catchScope.getHandler(i);
    
    Value /*P*/ typeValue = handler.Type.RTTI;
    assert (handler.Type.Flags == 0) : "landingpads do not support catch handler flags";
    assert ((typeValue != null)) : "fell into catch-all case!";
    typeValue = CGF.Builder.CreateBitCast(typeValue, CGF.Unnamed_field9.Int8PtrTy);
    
    // Figure out the next block.
    boolean nextIsEnd;
    BasicBlock /*P*/ nextBlock;
    
    // If this is the last handler, we're at the end, and the next
    // block is the block for the enclosing EH scope.
    if (i + 1 == e) {
      nextBlock = CGF.getEHDispatchBlock(catchScope.getEnclosingEHScope());
      nextIsEnd = true;
      // If the next handler is a catch-all, we're at the end, and the
      // next block is that handler.
    } else if (catchScope.getHandler(i + 1).isCatchAll()) {
      nextBlock = catchScope.getHandler(i + 1).Block;
      nextIsEnd = true;
      // Otherwise, we're not at the end and we need a new block.
    } else {
      nextBlock = CGF.createBasicBlock(new Twine(/*KEEP_STR*/"catch.fallthrough"));
      nextIsEnd = false;
    }
    
    // Figure out the catch type's index in the LSDA's type table.
    CallInst /*P*/ typeIndex = CGF.Builder.CreateCall_Value$P_ArrayRef$Value$P_Twine$C_MDNode$P(llvm_eh_typeid_for, new ArrayRef<Value /*P*/ >(typeValue, true));
    typeIndex.setDoesNotThrow();
    
    Value /*P*/ matchesTypeIndex = CGF.Builder.CreateICmpEQ(selector, typeIndex, new Twine(/*KEEP_STR*/"matches"));
    CGF.Builder.CreateCondBr(matchesTypeIndex, handler.Block, nextBlock);
    
    // If the next handler is a catch-all, we're completely done.
    if (nextIsEnd) {
      CGF.Builder.restoreIP(new IRBuilderBase.InsertPoint(savedIP));
      return;
    }
    // Otherwise we need to emit and continue at that block.
    CGF.EmitBlock(nextBlock);
  }
}

} // END OF class CGExceptionStatics
