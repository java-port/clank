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

package org.llvm.ir;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.adt.aliases.*;
import org.llvm.pass.*;


/// PredIteratorCache - This class is an extremely trivial cache for
/// predecessor iterator queries.  This is useful for code that repeatedly
/// wants the predecessor list for the same blocks.
//<editor-fold defaultstate="collapsed" desc="llvm::PredIteratorCache">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PredIteratorCache.h", line = 28,
 FQN="llvm::PredIteratorCache", NM="_ZN4llvm17PredIteratorCacheE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp -nm=_ZN4llvm17PredIteratorCacheE")
//</editor-fold>
public class PredIteratorCache implements Destructors.ClassWithDestructor {
  /// BlockToPredsMap - Pointer to null-terminated list.
  private DenseMap<BasicBlock /*P*/ , type$ptr<BasicBlock /*P*/ /*P*/>> BlockToPredsMap;
  private DenseMapTypeUInt<BasicBlock /*P*/ > BlockToPredCountMap;
  
  /// Memory - This is the space that holds cached preds.
  private BumpPtrAllocatorImpl Memory;
/*private:*/
  /// GetPreds - Get a cached list for the null-terminated predecessor list of
  /// the specified block.  This can be used in a loop like this:
  ///   for (BasicBlock **PI = PredCache->GetPreds(BB); *PI; ++PI)
  ///      use(*PI);
  /// instead of:
  /// for (pred_iterator PI = pred_begin(BB), E = pred_end(BB); PI != E; ++PI)
  //<editor-fold defaultstate="collapsed" desc="llvm::PredIteratorCache::GetPreds">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PredIteratorCache.h", line = 43,
   FQN="llvm::PredIteratorCache::GetPreds", NM="_ZN4llvm17PredIteratorCache8GetPredsEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp -nm=_ZN4llvm17PredIteratorCache8GetPredsEPNS_10BasicBlockE")
  //</editor-fold>
  private type$ptr<BasicBlock /*P*/ /*P*/> GetPreds(BasicBlock /*P*/ BB) {
    final type$ref<type$ptr<BasicBlock /*P*/ /*P*/ /*&*/>> Entry = $tryClone(BlockToPredsMap.ref$at(BB));
    if (!Entry.$bool()) {
      return Entry.$deref();
    }
    
    SmallVector<BasicBlock /*P*/ > PredCache/*J*/= new SmallVector<BasicBlock /*P*/ >(JD$T.INSTANCE, 32, IrLlvmGlobals.pred_begin_BasicBlock$P(BB), IrLlvmGlobals.pred_end_BasicBlock$P(BB), (BasicBlock /*P*/ )null);
    PredCache.push_back((BasicBlock /*P*/ /*const*/)null); // null terminator.
    
    BlockToPredCountMap.$set(BB, PredCache.size() - 1);
    
    Entry.$set((type$ptr<BasicBlock>)Memory.Allocate(BasicBlock.class, PredCache.size()));
    std.copy(PredCache.begin(), PredCache.end(), Entry.$deref());
    return Entry.$deref();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::PredIteratorCache::GetNumPreds">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PredIteratorCache.h", line = 58,
   FQN="llvm::PredIteratorCache::GetNumPreds", NM="_ZN4llvm17PredIteratorCache11GetNumPredsEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp -nm=_ZN4llvm17PredIteratorCache11GetNumPredsEPNS_10BasicBlockE")
  //</editor-fold>
  private /*uint*/int GetNumPreds(BasicBlock /*P*/ BB) {
    GetPreds(BB);
    return BlockToPredCountMap.$at_T1$C$R(BB);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::PredIteratorCache::size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PredIteratorCache.h", line = 64,
   FQN="llvm::PredIteratorCache::size", NM="_ZN4llvm17PredIteratorCache4sizeEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp -nm=_ZN4llvm17PredIteratorCache4sizeEPNS_10BasicBlockE")
  //</editor-fold>
  public /*size_t*/int size(BasicBlock /*P*/ BB) {
    return GetNumPreds(BB);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PredIteratorCache::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PredIteratorCache.h", line = 65,
   FQN="llvm::PredIteratorCache::get", NM="_ZN4llvm17PredIteratorCache3getEPNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp -nm=_ZN4llvm17PredIteratorCache3getEPNS_10BasicBlockE")
  //</editor-fold>
  public ArrayRef<BasicBlock /*P*/ > get(BasicBlock /*P*/ BB) {
    return makeArrayRef(GetPreds(BB), GetNumPreds(BB), true);
  }

  
  /// clear - Remove all information.
  //<editor-fold defaultstate="collapsed" desc="llvm::PredIteratorCache::clear">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PredIteratorCache.h", line = 70,
   FQN="llvm::PredIteratorCache::clear", NM="_ZN4llvm17PredIteratorCache5clearEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp -nm=_ZN4llvm17PredIteratorCache5clearEv")
  //</editor-fold>
  public void clear() {
    BlockToPredsMap.clear();
    BlockToPredCountMap.clear();
    Memory.Reset();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PredIteratorCache::PredIteratorCache">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PredIteratorCache.h", line = 28,
   FQN="llvm::PredIteratorCache::PredIteratorCache", NM="_ZN4llvm17PredIteratorCacheC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp -nm=_ZN4llvm17PredIteratorCacheC1EOS0_")
  //</editor-fold>
  public /*inline*/ PredIteratorCache(JD$Move _dparam, final PredIteratorCache /*&&*/$Prm0) {
    // : BlockToPredsMap(static_cast<PredIteratorCache &&>().BlockToPredsMap), BlockToPredCountMap(static_cast<PredIteratorCache &&>().BlockToPredCountMap), Memory(static_cast<PredIteratorCache &&>().Memory) 
    //START JInit
    this.BlockToPredsMap = new DenseMap<BasicBlock /*P*/ , type$ptr<BasicBlock /*P*/ /*P*/>>(JD$Move.INSTANCE, $Prm0.BlockToPredsMap);
    this.BlockToPredCountMap = new DenseMapTypeUInt<BasicBlock /*P*/ >(JD$Move.INSTANCE, $Prm0.BlockToPredCountMap);
    this.Memory = new BumpPtrAllocatorImpl(JD$Move.INSTANCE, $Prm0.Memory);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PredIteratorCache::~PredIteratorCache">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PredIteratorCache.h", line = 28,
   FQN="llvm::PredIteratorCache::~PredIteratorCache", NM="_ZN4llvm17PredIteratorCacheD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp -nm=_ZN4llvm17PredIteratorCacheD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Memory.$destroy();
    BlockToPredCountMap.$destroy();
    BlockToPredsMap.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::PredIteratorCache::PredIteratorCache">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/PredIteratorCache.h", line = 28,
   FQN="llvm::PredIteratorCache::PredIteratorCache", NM="_ZN4llvm17PredIteratorCacheC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Passes/PassBuilder.cpp -nm=_ZN4llvm17PredIteratorCacheC1Ev")
  //</editor-fold>
  public /*inline*/ PredIteratorCache() {
    // : BlockToPredsMap(), BlockToPredCountMap(), Memory() 
    //START JInit
    this.BlockToPredsMap = new DenseMap<BasicBlock /*P*/ , type$ptr<BasicBlock /*P*/ /*P*/>>(DenseMapInfo$LikePtr.$Info(), (type$ptr<BasicBlock /*P*/ /*P*/>)null);
    this.BlockToPredCountMap = new DenseMapTypeUInt<BasicBlock /*P*/ >(DenseMapInfo$LikePtr.$Info(), 0);
    this.Memory = new BumpPtrAllocatorImpl(4096, 4096);
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "BlockToPredsMap=" + BlockToPredsMap // NOI18N
              + ", BlockToPredCountMap=" + BlockToPredCountMap // NOI18N
              + ", Memory=" + "[BumpPtrAllocatorImpl]"; // NOI18N
  }
}
