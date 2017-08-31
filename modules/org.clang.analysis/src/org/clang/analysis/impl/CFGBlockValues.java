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

package org.clang.analysis.impl;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.analysis.impl.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBlockValues">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp", line = 107,
 FQN="(anonymous namespace)::CFGBlockValues", NM="_ZN12_GLOBAL__N_114CFGBlockValuesE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN12_GLOBAL__N_114CFGBlockValuesE")
//</editor-fold>
public class CFGBlockValues implements Destructors.ClassWithDestructor {
  private final /*const*/ CFG /*&*/ cfg;
  private SmallVector<PackedVector> vals;
  private PackedVector scratch;
  private DeclToIndex declToIndex;
/*public:*/
  // end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBlockValues::CFGBlockValues">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp", line = 143,
   FQN="(anonymous namespace)::CFGBlockValues::CFGBlockValues", NM="_ZN12_GLOBAL__N_114CFGBlockValuesC1ERKN5clang3CFGE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN12_GLOBAL__N_114CFGBlockValuesC1ERKN5clang3CFGE")
  //</editor-fold>
  public CFGBlockValues(final /*const*/ CFG /*&*/ c) {
    // : cfg(c), vals(0), scratch(), declToIndex() 
    //START JInit
    this./*&*/cfg=/*&*/c;
    this.vals = new SmallVector<PackedVector>(JD$UInt_T$C$R.INSTANCE, 8, 0, new PackedVector(2, false/*uint*/, new SmallBitVector()));
    this.scratch = new PackedVector(2, false/*uint*/, new SmallBitVector());
    this.declToIndex = new DeclToIndex();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBlockValues::getNumEntries">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp", line = 115,
   FQN="(anonymous namespace)::CFGBlockValues::getNumEntries", NM="_ZNK12_GLOBAL__N_114CFGBlockValues13getNumEntriesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZNK12_GLOBAL__N_114CFGBlockValues13getNumEntriesEv")
  //</editor-fold>
  public /*uint*/int getNumEntries() /*const*/ {
    return declToIndex.size();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBlockValues::computeSetOfDeclarations">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp", line = 145,
   FQN="(anonymous namespace)::CFGBlockValues::computeSetOfDeclarations", NM="_ZN12_GLOBAL__N_114CFGBlockValues24computeSetOfDeclarationsERKN5clang11DeclContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN12_GLOBAL__N_114CFGBlockValues24computeSetOfDeclarationsERKN5clang11DeclContextE")
  //</editor-fold>
  public void computeSetOfDeclarations(final /*const*/ DeclContext /*&*/ dc) {
    declToIndex.computeMap(dc);
    /*uint*/int decls = declToIndex.size();
    scratch.resize(decls);
    /*uint*/int n = cfg.getNumBlockIDs();
    if (!(n != 0)) {
      return;
    }
    vals.resize(n);
    for (/*uint*/int i = 0; $less_uint(i, n); ++i)  {
      vals.$at(i).resize(decls);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBlockValues::getValueVector">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp", line = 118,
   FQN="(anonymous namespace)::CFGBlockValues::getValueVector", NM="_ZN12_GLOBAL__N_114CFGBlockValues14getValueVectorEPKN5clang8CFGBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN12_GLOBAL__N_114CFGBlockValues14getValueVectorEPKN5clang8CFGBlockE")
  //</editor-fold>
  public PackedVector /*&*/ getValueVector(/*const*/ CFGBlock /*P*/ block) {
    return vals.$at(block.getBlockID());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBlockValues::setAllScratchValues">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp", line = 168,
   FQN="(anonymous namespace)::CFGBlockValues::setAllScratchValues", NM="_ZN12_GLOBAL__N_114CFGBlockValues19setAllScratchValuesE5Value",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN12_GLOBAL__N_114CFGBlockValues19setAllScratchValuesE5Value")
  //</editor-fold>
  public void setAllScratchValues(/*Value*//*uint*/int V) {
    for (/*uint*/int I = 0, E = scratch.size(); I != E; ++I)  {
      scratch.$at(I).$assign(/*KEEP_ENUM*/V);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBlockValues::mergeIntoScratch">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp", line = 173,
   FQN="(anonymous namespace)::CFGBlockValues::mergeIntoScratch", NM="_ZN12_GLOBAL__N_114CFGBlockValues16mergeIntoScratchERKN4llvm12PackedVectorI5ValueLj2ENS1_14SmallBitVectorEEEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN12_GLOBAL__N_114CFGBlockValues16mergeIntoScratchERKN4llvm12PackedVectorI5ValueLj2ENS1_14SmallBitVectorEEEb")
  //</editor-fold>
  public void mergeIntoScratch(final /*const*/PackedVector /*&*/ source, 
                  boolean isFirst) {
    if (isFirst) {
      scratch.$assign(source);
    } else {
      scratch.$orassign(source);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBlockValues::updateValueVectorWithScratch">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp", line = 181,
   FQN="(anonymous namespace)::CFGBlockValues::updateValueVectorWithScratch", NM="_ZN12_GLOBAL__N_114CFGBlockValues28updateValueVectorWithScratchEPKN5clang8CFGBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN12_GLOBAL__N_114CFGBlockValues28updateValueVectorWithScratchEPKN5clang8CFGBlockE")
  //</editor-fold>
  public boolean updateValueVectorWithScratch(/*const*/ CFGBlock /*P*/ block) {
    final PackedVector /*&*/ dst = getValueVector(block);
    boolean changed = (dst.$noteq(scratch));
    if (changed) {
      dst.$assign(scratch);
    }
    return changed;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBlockValues::hasNoDeclarations">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp", line = 126,
   FQN="(anonymous namespace)::CFGBlockValues::hasNoDeclarations", NM="_ZNK12_GLOBAL__N_114CFGBlockValues17hasNoDeclarationsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZNK12_GLOBAL__N_114CFGBlockValues17hasNoDeclarationsEv")
  //</editor-fold>
  public boolean hasNoDeclarations() /*const*/ {
    return declToIndex.size() == 0;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBlockValues::resetScratch">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp", line = 192,
   FQN="(anonymous namespace)::CFGBlockValues::resetScratch", NM="_ZN12_GLOBAL__N_114CFGBlockValues12resetScratchEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN12_GLOBAL__N_114CFGBlockValues12resetScratchEv")
  //</editor-fold>
  public void resetScratch() {
    scratch.reset();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBlockValues::operator[]">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp", line = 196,
   FQN="(anonymous namespace)::CFGBlockValues::operator[]", NM="_ZN12_GLOBAL__N_114CFGBlockValuesixEPKN5clang7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN12_GLOBAL__N_114CFGBlockValuesixEPKN5clang7VarDeclE")
  //</editor-fold>
  public PackedVector.reference $at(/*const*/ VarDecl /*P*/ vd) {
    final /*const*/OptionalUInt /*&*/ idx = declToIndex.getValueIndex(vd);
    assert (idx.hasValue());
    return scratch.$at(idx.getValue$Const());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBlockValues::getValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp", line = 134,
   FQN="(anonymous namespace)::CFGBlockValues::getValue", NM="_ZN12_GLOBAL__N_114CFGBlockValues8getValueEPKN5clang8CFGBlockES4_PKNS1_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN12_GLOBAL__N_114CFGBlockValues8getValueEPKN5clang8CFGBlockES4_PKNS1_7VarDeclE")
  //</editor-fold>
  public /*Value*//*uint*/int getValue(/*const*/ CFGBlock /*P*/ block, /*const*/ CFGBlock /*P*/ dstBlock, 
          /*const*/ VarDecl /*P*/ vd) {
    final /*const*/OptionalUInt /*&*/ idx = declToIndex.getValueIndex(vd);
    assert (idx.hasValue());
    return getValueVector(block).$at(idx.getValue$Const()).$T();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBlockValues::~CFGBlockValues">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp", line = 107,
   FQN="(anonymous namespace)::CFGBlockValues::~CFGBlockValues", NM="_ZN12_GLOBAL__N_114CFGBlockValuesD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN12_GLOBAL__N_114CFGBlockValuesD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    declToIndex.$destroy();
    scratch.$destroy();
    vals.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "cfg=" + cfg // NOI18N
              + ", vals=" + vals // NOI18N
              + ", scratch=" + scratch // NOI18N
              + ", declToIndex=" + declToIndex; // NOI18N
  }
}
