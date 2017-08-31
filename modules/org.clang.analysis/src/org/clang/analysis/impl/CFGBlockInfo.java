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
import static org.clank.support.Native.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.analysis.impl.*;


/// CFGBlockInfo is a struct which contains all the information that is
/// maintained for each block in the CFG.  See LocalVariableMap for more
/// information about the contexts.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBlockInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 303,
 FQN="(anonymous namespace)::CFGBlockInfo", NM="_ZN12_GLOBAL__N_112CFGBlockInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_112CFGBlockInfoE")
//</editor-fold>
public class/*struct*/ CFGBlockInfo implements Native.NativePOD<CFGBlockInfo>, Destructors.ClassWithDestructor {
  public FactSet EntrySet; // Lockset held at entry to block
  public FactSet ExitSet; // Lockset held at exit from block
  public ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ > EntryContext; // Context held at entry to block
  public ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ > ExitContext; // Context held at exit from block
  public SourceLocation EntryLoc; // Location of first statement in block
  public SourceLocation ExitLoc; // Location of last statement in block.
  public /*uint*/int EntryIndex; // Used to replay contexts later
  public boolean Reachable; // Is this block reachable?
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBlockInfo::getSet">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 313,
   FQN="(anonymous namespace)::CFGBlockInfo::getSet", NM="_ZNK12_GLOBAL__N_112CFGBlockInfo6getSetENS_12CFGBlockSideE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZNK12_GLOBAL__N_112CFGBlockInfo6getSetENS_12CFGBlockSideE")
  //</editor-fold>
  public /*const*/ FactSet /*&*/ getSet(CFGBlockSide Side) /*const*/ {
    return Side == CFGBlockSide.CBS_Entry ? EntrySet : ExitSet;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBlockInfo::getLocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 316,
   FQN="(anonymous namespace)::CFGBlockInfo::getLocation", NM="_ZNK12_GLOBAL__N_112CFGBlockInfo11getLocationENS_12CFGBlockSideE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZNK12_GLOBAL__N_112CFGBlockInfo11getLocationENS_12CFGBlockSideE")
  //</editor-fold>
  public SourceLocation getLocation(CFGBlockSide Side) /*const*/ {
    return new SourceLocation(Side == CFGBlockSide.CBS_Entry ? EntryLoc : ExitLoc);
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBlockInfo::CFGBlockInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 321,
   FQN="(anonymous namespace)::CFGBlockInfo::CFGBlockInfo", NM="_ZN12_GLOBAL__N_112CFGBlockInfoC1EN4llvm12ImmutableMapIPKN5clang9NamedDeclEjNS1_16ImutKeyValueInfoIS6_jEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_112CFGBlockInfoC1EN4llvm12ImmutableMapIPKN5clang9NamedDeclEjNS1_16ImutKeyValueInfoIS6_jEEEE")
  //</editor-fold>
  private CFGBlockInfo(ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ > EmptyCtx) {
    // : EntrySet(), ExitSet(), EntryContext(EmptyCtx), ExitContext(EmptyCtx), EntryLoc(), ExitLoc(), Reachable(false) 
    //START JInit
    this.EntrySet = new FactSet();
    this.ExitSet = new FactSet();
    this.EntryContext = new ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ >(EmptyCtx);
    this.ExitContext = new ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ >(EmptyCtx);
    this.EntryLoc = new SourceLocation();
    this.ExitLoc = new SourceLocation();
    this.Reachable = false;
    //END JInit
  }

/*public:*/
  
  // This has to be defined after LocalVariableMap.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBlockInfo::getEmptyBlockInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 544,
   FQN="(anonymous namespace)::CFGBlockInfo::getEmptyBlockInfo", NM="_ZN12_GLOBAL__N_112CFGBlockInfo17getEmptyBlockInfoERNS_16LocalVariableMapE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_112CFGBlockInfo17getEmptyBlockInfoERNS_16LocalVariableMapE")
  //</editor-fold>
  public static CFGBlockInfo getEmptyBlockInfo(final LocalVariableMap /*&*/ M) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(new CFGBlockInfo($c$.track(M.getEmptyContext())));
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBlockInfo::CFGBlockInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 303,
   FQN="(anonymous namespace)::CFGBlockInfo::CFGBlockInfo", NM="_ZN12_GLOBAL__N_112CFGBlockInfoC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_112CFGBlockInfoC1EOS0_")
  //</editor-fold>
  public /*inline*/ CFGBlockInfo(JD$Move _dparam, final CFGBlockInfo /*&&*/$Prm0) {
    // : EntrySet(static_cast<CFGBlockInfo &&>().EntrySet), ExitSet(static_cast<CFGBlockInfo &&>().ExitSet), EntryContext(static_cast<CFGBlockInfo &&>().EntryContext), ExitContext(static_cast<CFGBlockInfo &&>().ExitContext), EntryLoc(static_cast<CFGBlockInfo &&>().EntryLoc), ExitLoc(static_cast<CFGBlockInfo &&>().ExitLoc), EntryIndex(static_cast<CFGBlockInfo &&>().EntryIndex), Reachable(static_cast<CFGBlockInfo &&>().Reachable) 
    //START JInit
    this.EntrySet = new FactSet(JD$Move.INSTANCE, $Prm0.EntrySet);
    this.ExitSet = new FactSet(JD$Move.INSTANCE, $Prm0.ExitSet);
    this.EntryContext = new ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ >($Prm0.EntryContext);
    this.ExitContext = new ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ >($Prm0.ExitContext);
    this.EntryLoc = new SourceLocation(JD$Move.INSTANCE, $Prm0.EntryLoc);
    this.ExitLoc = new SourceLocation(JD$Move.INSTANCE, $Prm0.ExitLoc);
    this.EntryIndex = $Prm0.EntryIndex;
    this.Reachable = $Prm0.Reachable;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBlockInfo::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 303,
   FQN="(anonymous namespace)::CFGBlockInfo::operator=", NM="_ZN12_GLOBAL__N_112CFGBlockInfoaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_112CFGBlockInfoaSEOS0_")
  //</editor-fold>
  public /*inline*/ CFGBlockInfo /*&*/ $assignMove(final CFGBlockInfo /*&&*/$Prm0) {
    this.EntrySet.$assignMove($Prm0.EntrySet);
    this.ExitSet.$assignMove($Prm0.ExitSet);
    this.EntryContext.$assign($Prm0.EntryContext);
    this.ExitContext.$assign($Prm0.ExitContext);
    this.EntryLoc.$assignMove($Prm0.EntryLoc);
    this.ExitLoc.$assignMove($Prm0.ExitLoc);
    this.EntryIndex = $Prm0.EntryIndex;
    this.Reachable = $Prm0.Reachable;
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBlockInfo::~CFGBlockInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 303,
   FQN="(anonymous namespace)::CFGBlockInfo::~CFGBlockInfo", NM="_ZN12_GLOBAL__N_112CFGBlockInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_112CFGBlockInfoD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    ExitContext.$destroy();
    EntryContext.$destroy();
    ExitSet.$destroy();
    EntrySet.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBlockInfo::CFGBlockInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 303,
   FQN="(anonymous namespace)::CFGBlockInfo::CFGBlockInfo", NM="_ZN12_GLOBAL__N_112CFGBlockInfoC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_112CFGBlockInfoC1ERKS0_")
  //</editor-fold>
  public /*inline*/ CFGBlockInfo(final /*const*/ CFGBlockInfo /*&*/ $Prm0) {
    // : EntrySet(.EntrySet), ExitSet(.ExitSet), EntryContext(.EntryContext), ExitContext(.ExitContext), EntryLoc(.EntryLoc), ExitLoc(.ExitLoc), EntryIndex(.EntryIndex), Reachable(.Reachable) 
    //START JInit
    this.EntrySet = new FactSet($Prm0.EntrySet);
    this.ExitSet = new FactSet($Prm0.ExitSet);
    this.EntryContext = new ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ >($Prm0.EntryContext);
    this.ExitContext = new ImmutableMapPtrUInt</*const*/ NamedDecl /*P*/ >($Prm0.ExitContext);
    this.EntryLoc = new SourceLocation($Prm0.EntryLoc);
    this.ExitLoc = new SourceLocation($Prm0.ExitLoc);
    this.EntryIndex = $Prm0.EntryIndex;
    this.Reachable = $Prm0.Reachable;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFGBlockInfo::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp", line = 303,
   FQN="(anonymous namespace)::CFGBlockInfo::operator=", NM="_ZN12_GLOBAL__N_112CFGBlockInfoaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN12_GLOBAL__N_112CFGBlockInfoaSERKS0_")
  //</editor-fold>
  public /*inline*/ CFGBlockInfo /*&*/ $assign(final /*const*/ CFGBlockInfo /*&*/ $Prm0) {
    this.EntrySet.$assign($Prm0.EntrySet);
    this.ExitSet.$assign($Prm0.ExitSet);
    this.EntryContext.$assign($Prm0.EntryContext);
    this.ExitContext.$assign($Prm0.ExitContext);
    this.EntryLoc.$assign($Prm0.EntryLoc);
    this.ExitLoc.$assign($Prm0.ExitLoc);
    this.EntryIndex = $Prm0.EntryIndex;
    this.Reachable = $Prm0.Reachable;
    return /*Deref*/this;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  protected CFGBlockInfo(){}

  @Override
  public CFGBlockInfo clone() {
    return new CFGBlockInfo(this);
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "EntrySet=" + EntrySet // NOI18N
              + ", ExitSet=" + ExitSet // NOI18N
              + ", EntryContext=" + EntryContext // NOI18N
              + ", ExitContext=" + ExitContext // NOI18N
              + ", EntryLoc=" + EntryLoc // NOI18N
              + ", ExitLoc=" + ExitLoc // NOI18N
              + ", EntryIndex=" + EntryIndex // NOI18N
              + ", Reachable=" + Reachable; // NOI18N
  }
}
