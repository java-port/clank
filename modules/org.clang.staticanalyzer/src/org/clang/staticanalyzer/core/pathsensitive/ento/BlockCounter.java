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

package org.clang.staticanalyzer.core.pathsensitive.ento;

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.analysis.*;
import org.clang.staticanalyzer.core.impl.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.staticanalyzer.core.impl.BlockCounterStatics.*;


/// \class BlockCounter
/// \brief An abstract data type used to count the number of times a given
/// block has been visited along a path analyzed by CoreEngine.
//<editor-fold defaultstate="collapsed" desc="clang::ento::BlockCounter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/BlockCounter.h", line = 30,
 FQN="clang::ento::BlockCounter", NM="_ZN5clang4ento12BlockCounterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BlockCounter.cpp -nm=_ZN5clang4ento12BlockCounterE")
//</editor-fold>
public class BlockCounter {
  private Object/*void P*/ Data;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BlockCounter::BlockCounter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/BlockCounter.h", line = 33,
   FQN="clang::ento::BlockCounter::BlockCounter", NM="_ZN5clang4ento12BlockCounterC1EPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BlockCounter.cpp -nm=_ZN5clang4ento12BlockCounterC1EPv")
  //</editor-fold>
  private BlockCounter(Object/*void P*/ D) {
    // : Data(D) 
    //START JInit
    this.Data = D;
    //END JInit
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BlockCounter::BlockCounter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/BlockCounter.h", line = 36,
   FQN="clang::ento::BlockCounter::BlockCounter", NM="_ZN5clang4ento12BlockCounterC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BlockCounter.cpp -nm=_ZN5clang4ento12BlockCounterC1Ev")
  //</editor-fold>
  public BlockCounter() {
    // : Data(null) 
    //START JInit
    this.Data = null;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BlockCounter::getNumVisited">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BlockCounter.cpp", line = 58,
   FQN="clang::ento::BlockCounter::getNumVisited", NM="_ZNK5clang4ento12BlockCounter13getNumVisitedEPKNS_17StackFrameContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BlockCounter.cpp -nm=_ZNK5clang4ento12BlockCounter13getNumVisitedEPKNS_17StackFrameContextEj")
  //</editor-fold>
  public /*uint*/int getNumVisited(/*const*/ StackFrameContext /*P*/ CallSite, 
               /*uint*/int BlockID) /*const*/ {
    ImmutableMapTypeUInt<CountKey> M = null;
    try {
      M = GetMap(Data);
      /*const*/uint$ptr/*uint P*/ T = $tryClone(M.lookup(new CountKey(CallSite, BlockID)));
      return Native.$bool(T) ? T.$star() : 0;
    } finally {
      if (M != null) { M.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BlockCounter::Factory">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/BlockCounter.h", line = 41,
   FQN="clang::ento::BlockCounter::Factory", NM="_ZN5clang4ento12BlockCounter7FactoryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BlockCounter.cpp -nm=_ZN5clang4ento12BlockCounter7FactoryE")
  //</editor-fold>
  public static class Factory implements Destructors.ClassWithDestructor {
    private Object/*void P*/ F;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::ento::BlockCounter::Factory::Factory">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BlockCounter.cpp", line = 65,
     FQN="clang::ento::BlockCounter::Factory::Factory", NM="_ZN5clang4ento12BlockCounter7FactoryC1ERN4llvm20BumpPtrAllocatorImplINS3_15MallocAllocatorELj4096ELj4096EEE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BlockCounter.cpp -nm=_ZN5clang4ento12BlockCounter7FactoryC1ERN4llvm20BumpPtrAllocatorImplINS3_15MallocAllocatorELj4096ELj4096EEE")
    //</editor-fold>
    public Factory(final BumpPtrAllocatorImpl /*&*/ Alloc) {
      F = new ImmutableMapTypeUInt.Factory<CountKey>(
              new ImutKeyValueInfo$TypeUInt(
                      new ImutContainerInfo<CountKey>(new DefaultFoldingSetTrait<CountKey>())
                  ), 
              Alloc);
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ento::BlockCounter::Factory::~Factory">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BlockCounter.cpp", line = 69,
     FQN="clang::ento::BlockCounter::Factory::~Factory", NM="_ZN5clang4ento12BlockCounter7FactoryD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BlockCounter.cpp -nm=_ZN5clang4ento12BlockCounter7FactoryD0Ev")
    //</editor-fold>
    public void $destroy() {
      if (((/*static_cast*/ImmutableMapTypeUInt.Factory<CountKey> /*P*/ )(F)) != null) { ((/*static_cast*/ImmutableMapTypeUInt.Factory<CountKey> /*P*/ )(F)).$destroy();};
    }

    
    //<editor-fold defaultstate="collapsed" desc="clang::ento::BlockCounter::Factory::GetEmptyCounter">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BlockCounter.cpp", line = 82,
     FQN="clang::ento::BlockCounter::Factory::GetEmptyCounter", NM="_ZN5clang4ento12BlockCounter7Factory15GetEmptyCounterEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BlockCounter.cpp -nm=_ZN5clang4ento12BlockCounter7Factory15GetEmptyCounterEv")
    //</editor-fold>
    public BlockCounter GetEmptyCounter() {
      return new BlockCounter(GetFactory(F).getEmptyMap().getRoot());
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ento::BlockCounter::Factory::IncrementCount">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BlockCounter.cpp", line = 73,
     FQN="clang::ento::BlockCounter::Factory::IncrementCount", NM="_ZN5clang4ento12BlockCounter7Factory14IncrementCountES1_PKNS_17StackFrameContextEj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BlockCounter.cpp -nm=_ZN5clang4ento12BlockCounter7Factory14IncrementCountES1_PKNS_17StackFrameContextEj")
    //</editor-fold>
    public BlockCounter IncrementCount(BlockCounter BC, 
                  /*const*/ StackFrameContext /*P*/ CallSite, 
                  /*uint*/int BlockID) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean(new BlockCounter(GetFactory(F).add($c$.track(GetMap(BC.Data)), 
                new CountKey(CallSite, BlockID), 
                BC.getNumVisited(CallSite, BlockID) + 1).getRoot()));
      } finally {
        $c$.$destroy();
      }
    }

    
    @Override public String toString() {
      return "" + "F=" + F; // NOI18N
    }
  };
  
  /*friend  class Factory*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::BlockCounter::BlockCounter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/BlockCounter.h", line = 30,
   FQN="clang::ento::BlockCounter::BlockCounter", NM="_ZN5clang4ento12BlockCounterC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BlockCounter.cpp -nm=_ZN5clang4ento12BlockCounterC1EOS1_")
  //</editor-fold>
  public /*inline*/ BlockCounter(JD$Move _dparam, final BlockCounter /*&&*/$Prm0) {
    // : Data(static_cast<BlockCounter &&>().Data) 
    //START JInit
    this.Data = $Prm0.Data;
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::BlockCounter::BlockCounter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/BlockCounter.h", line = 30,
   FQN="clang::ento::BlockCounter::BlockCounter", NM="_ZN5clang4ento12BlockCounterC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento12BlockCounterC1ERKS1_")
  //</editor-fold>
  public /*inline*/ BlockCounter(final /*const*/ BlockCounter /*&*/ $Prm0) {
    // : Data(.Data) 
    //START JInit
    this.Data = $Prm0.Data;
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::BlockCounter::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/BlockCounter.h", line = 30,
   FQN="clang::ento::BlockCounter::operator=", NM="_ZN5clang4ento12BlockCounteraSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento12BlockCounteraSERKS1_")
  //</editor-fold>
  public /*inline*/ BlockCounter /*&*/ $assign(final /*const*/ BlockCounter /*&*/ $Prm0) {
    this.Data = $Prm0.Data;
    return /*Deref*/this;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ento::BlockCounter::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/BlockCounter.h", line = 30,
   FQN="clang::ento::BlockCounter::operator=", NM="_ZN5clang4ento12BlockCounteraSEOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CoreEngine.cpp -nm=_ZN5clang4ento12BlockCounteraSEOS1_")
  //</editor-fold>
  public /*inline*/ BlockCounter /*&*/ $assignMove(final BlockCounter /*&&*/$Prm0) {
    this.Data = $Prm0.Data;
    return /*Deref*/this;
  }

  
  @Override public String toString() {
    return "" + "Data=" + Data; // NOI18N
  }
}
