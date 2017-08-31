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
package org.clang.staticanalyzer.core.pathsensitive.ento.impl;

import static org.clank.support.Native.$Deref;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.staticanalyzer.checkers.ento.EntoGlobals;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.staticanalyzer.java.StaticanalyzerRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type DynamicTypeMapEntoGlobals">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 NM="org.clang.staticanalyzer.core.pathsensitive.ento.impl.DynamicTypeMapEntoGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/DynamicTypeMap.cpp -nm=_ZN5clang4ento18getDynamicTypeInfoEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS0_9MemRegionE;_ZN5clang4ento18setDynamicTypeInfoEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS0_9MemRegionENS0_15DynamicTypeInfoE;_ZN5clang4ento18setDynamicTypeInfoEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS0_9MemRegionENS_8QualTypeEb; -static-type=DynamicTypeMapEntoGlobals -package=org.clang.staticanalyzer.core.pathsensitive.ento.impl")
//</editor-fold>
public final class DynamicTypeMapEntoGlobals {


/// \brief Get dynamic type information for a region.
//<editor-fold defaultstate="collapsed" desc="clang::ento::getDynamicTypeInfo">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/DynamicTypeMap.cpp", line = 21,
 FQN="clang::ento::getDynamicTypeInfo", NM="_ZN5clang4ento18getDynamicTypeInfoEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS0_9MemRegionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/DynamicTypeMap.cpp -nm=_ZN5clang4ento18getDynamicTypeInfoEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS0_9MemRegionE")
//</editor-fold>
public static DynamicTypeInfo getDynamicTypeInfo(IntrusiveRefCntPtr</*const*/ ProgramState> State, 
                  /*const*/ MemRegion /*P*/ Reg) {
  Reg = Reg.StripCasts();
  
  // Look up the dynamic type in the GDM.
  /*const*/ DynamicTypeInfo /*P*/ GDMType = State.$arrow().get(ProgramStateTraitDynamicTypeMap.$Instance, Reg);
  if ((GDMType != null)) {
    return new DynamicTypeInfo($Deref(GDMType));
  }
  {
    
    // Otherwise, fall back to what we know about the region.
    /*const*/ TypedRegion /*P*/ TR = dyn_cast_TypedRegion(Reg);
    if ((TR != null)) {
      return new DynamicTypeInfo(TR.getLocationType(), /*CanBeSubclass=*/ false);
    }
  }
  {
    
    /*const*/ SymbolicRegion /*P*/ SR = dyn_cast_SymbolicRegion(Reg);
    if ((SR != null)) {
      /*const*/ SymExpr /*P*/ Sym = SR.getSymbol();
      return new DynamicTypeInfo(Sym.getType());
    }
  }
  
  return new DynamicTypeInfo();
}


/// \brief Set dynamic type information of the region; return the new state.
//<editor-fold defaultstate="collapsed" desc="clang::ento::setDynamicTypeInfo">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/DynamicTypeMap.cpp", line = 42,
 FQN="clang::ento::setDynamicTypeInfo", NM="_ZN5clang4ento18setDynamicTypeInfoEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS0_9MemRegionENS0_15DynamicTypeInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/DynamicTypeMap.cpp -nm=_ZN5clang4ento18setDynamicTypeInfoEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS0_9MemRegionENS0_15DynamicTypeInfoE")
//</editor-fold>
public static IntrusiveRefCntPtr</*const*/ ProgramState> setDynamicTypeInfo(IntrusiveRefCntPtr</*const*/ ProgramState> State, /*const*/ MemRegion /*P*/ Reg, 
                  DynamicTypeInfo NewTy) {
  IntrusiveRefCntPtr</*const*/ ProgramState> NewState = null;
  try {
    Reg = Reg.StripCasts();
    NewState = State.$arrow().set(ProgramStateTraitDynamicTypeMap.$Instance, Reg, new DynamicTypeInfo(NewTy));
    assert ((NewState).$bool());
    return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, NewState);
  } finally {
    if (NewState != null) { NewState.$destroy(); }
  }
}


/// \brief Set dynamic type information of the region; return the new state.
//<editor-fold defaultstate="collapsed" desc="clang::ento::setDynamicTypeInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/DynamicTypeMap.h", line = 47,
 FQN="clang::ento::setDynamicTypeInfo", NM="_ZN5clang4ento18setDynamicTypeInfoEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS0_9MemRegionENS_8QualTypeEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/DynamicTypeMap.cpp -nm=_ZN5clang4ento18setDynamicTypeInfoEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEPKNS0_9MemRegionENS_8QualTypeEb")
//</editor-fold>
public static /*inline*/ IntrusiveRefCntPtr</*const*/ ProgramState> setDynamicTypeInfo(IntrusiveRefCntPtr</*const*/ ProgramState> State, 
                  /*const*/ MemRegion /*P*/ Reg, QualType NewTy) {
  return setDynamicTypeInfo(State, 
                  Reg, NewTy, 
                  true);
}
public static /*inline*/ IntrusiveRefCntPtr</*const*/ ProgramState> setDynamicTypeInfo(IntrusiveRefCntPtr</*const*/ ProgramState> State, 
                  /*const*/ MemRegion /*P*/ Reg, QualType NewTy, 
                  boolean CanBeSubClassed/*= true*/) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    return $c$.clean(EntoGlobals.setDynamicTypeInfo($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), Reg, 
        new DynamicTypeInfo(new QualType(NewTy), CanBeSubClassed)));
  } finally {
    $c$.$destroy();
  }
}

} // END OF class DynamicTypeMapEntoGlobals
