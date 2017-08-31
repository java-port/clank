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
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.codegen.impl.CodeGenPGOStatics;
import org.llvm.ir.*;


//<editor-fold defaultstate="collapsed" desc="static type CodeGenFunction_CodeGenPGO">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 NM="org.clang.codegen.CodeGen.impl.CodeGenFunction_CodeGenPGO",        
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this -extends=CodeGenFunction_CodeGenModule ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction20createProfileWeightsEN4llvm8ArrayRefIyEE;_ZN5clang7CodeGen15CodeGenFunction20createProfileWeightsEyy;_ZN5clang7CodeGen15CodeGenFunction27createProfileWeightsForLoopEPKNS_4StmtEy; -static-type=CodeGenFunction_CodeGenPGO -package=org.clang.codegen.CodeGen.impl")
//</editor-fold>
public abstract class CodeGenFunction_CodeGenPGO extends CodeGenFunction_CodeGenModule {
private final /*split clang::CodeGen::CodeGenFunction*/ CodeGenFunction $this() { return (CodeGenFunction)this; }
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::CodeGenFunction">
@Converted(kind = Converted.Kind.MANUAL_ADDED,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp", line = 40,
 FQN="clang::CodeGen::CodeGenFunction::CodeGenFunction", NM="_ZN5clang7CodeGen15CodeGenFunctionC1ERNS0_13CodeGenModuleEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenFunction.cpp -nm=_ZN5clang7CodeGen15CodeGenFunctionC1ERNS0_13CodeGenModuleEb")
//</editor-fold>
protected CodeGenFunction_CodeGenPGO(final CodeGenModule /*&*/ cgm) {
  super(cgm);
}


/// Calculate branch weights appropriate for PGO data
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::createProfileWeights">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp", line = 847,
 FQN="clang::CodeGen::CodeGenFunction::createProfileWeights", NM="_ZN5clang7CodeGen15CodeGenFunction20createProfileWeightsEyy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction20createProfileWeightsEyy")
//</editor-fold>
protected/*private*/ final MDNode /*P*/ createProfileWeights(long/*uint64_t*/ TrueCount, 
                    long/*uint64_t*/ FalseCount) {
  // Check for empty weights.
  if (!(TrueCount != 0) && !(FalseCount != 0)) {
    return null;
  }
  
  // Calculate how to scale down to 32-bits.
  long/*uint64_t*/ Scale = CodeGenPGOStatics.calculateWeightScale(std.max(TrueCount, FalseCount));
  
  MDBuilder MDHelper/*J*/= new MDBuilder($this().CGM.getLLVMContext());
  return MDHelper.createBranchWeights(CodeGenPGOStatics.scaleBranchWeight(TrueCount, Scale), 
      CodeGenPGOStatics.scaleBranchWeight(FalseCount, Scale));
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::createProfileWeights">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp", line = 861,
 FQN="clang::CodeGen::CodeGenFunction::createProfileWeights", NM="_ZN5clang7CodeGen15CodeGenFunction20createProfileWeightsEN4llvm8ArrayRefIyEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction20createProfileWeightsEN4llvm8ArrayRefIyEE")
//</editor-fold>
protected/*private*/ final MDNode /*P*/ createProfileWeights(ArrayRefULong Weights) {
  // We need at least two elements to create meaningful weights.
  if ($less_uint(Weights.size(), 2)) {
    return null;
  }
  
  // Check for empty weights.
  long/*uint64_t*/ MaxWeight = std.max_element(Weights.begin(), Weights.end()).$star();
  if (MaxWeight == $int2ullong(0)) {
    return null;
  }
  
  // Calculate how to scale down to 32-bits.
  long/*uint64_t*/ Scale = CodeGenPGOStatics.calculateWeightScale(MaxWeight);
  
  SmallVectorUInt ScaledWeights/*J*/= new SmallVectorUInt(16, (/*uint32_t*/int)0);
  ScaledWeights.reserve(Weights.size());
  for (long/*uint64_t*/ W : Weights)  {
    ScaledWeights.push_back(CodeGenPGOStatics.scaleBranchWeight(W, Scale));
  }
  
  MDBuilder MDHelper/*J*/= new MDBuilder($this().CGM.getLLVMContext());
  return MDHelper.createBranchWeights(new ArrayRefUInt(ScaledWeights));
}

//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenFunction::createProfileWeightsForLoop">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp", line = 884,
 FQN="clang::CodeGen::CodeGenFunction::createProfileWeightsForLoop", NM="_ZN5clang7CodeGen15CodeGenFunction27createProfileWeightsForLoopEPKNS_4StmtEy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenFunction@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenPGO.cpp -nm=_ZN5clang7CodeGen15CodeGenFunction27createProfileWeightsForLoopEPKNS_4StmtEy")
//</editor-fold>
protected/*private*/ final MDNode /*P*/ createProfileWeightsForLoop(/*const*/ Stmt /*P*/ Cond, 
                           long/*uint64_t*/ LoopCount) {
  if (!$this().PGO.haveRegionCounts()) {
    return null;
  }
  OptionalULong CondCount = $this().PGO.getStmtCount(Cond);
  assert (CondCount.hasValue()) : "missing expected loop condition count";
  if (CondCount.$star() == $int2ullong(0)) {
    return null;
  }
  return $this().createProfileWeights(LoopCount, 
      std.max(CondCount.$star(), LoopCount) - LoopCount);
}

} // END OF class CodeGenFunction_CodeGenPGO
