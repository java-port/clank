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

package org.llvm.analysis;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.pass.*;
import static org.llvm.ir.PassManagerGlobals.*;


/// This is a result from a NonLocal dependence query.
///
/// For each BasicBlock (the BB entry) it keeps a MemDepResult and the
/// (potentially phi translated) address that was live in the block.
//<editor-fold defaultstate="collapsed" desc="llvm::NonLocalDepResult">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryDependenceAnalysis.h", line = 226,
 FQN="llvm::NonLocalDepResult", NM="_ZN4llvm17NonLocalDepResultE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZN4llvm17NonLocalDepResultE")
//</editor-fold>
public class NonLocalDepResult {
  private NonLocalDepEntry Entry;
  private Value /*P*/ Address;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::NonLocalDepResult::NonLocalDepResult">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryDependenceAnalysis.h", line = 231,
   FQN="llvm::NonLocalDepResult::NonLocalDepResult", NM="_ZN4llvm17NonLocalDepResultC1EPNS_10BasicBlockENS_12MemDepResultEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZN4llvm17NonLocalDepResultC1EPNS_10BasicBlockENS_12MemDepResultEPNS_5ValueE")
  //</editor-fold>
  public NonLocalDepResult(BasicBlock /*P*/ bb, MemDepResult result, Value /*P*/ address) {
    // : Entry(bb, result), Address(address) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // BB is the sort key, it can't be changed.
  //<editor-fold defaultstate="collapsed" desc="llvm::NonLocalDepResult::getBB">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryDependenceAnalysis.h", line = 235,
   FQN="llvm::NonLocalDepResult::getBB", NM="_ZNK4llvm17NonLocalDepResult5getBBEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZNK4llvm17NonLocalDepResult5getBBEv")
  //</editor-fold>
  public BasicBlock /*P*/ getBB() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::NonLocalDepResult::setResult">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryDependenceAnalysis.h", line = 237,
   FQN="llvm::NonLocalDepResult::setResult", NM="_ZN4llvm17NonLocalDepResult9setResultERKNS_12MemDepResultEPNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZN4llvm17NonLocalDepResult9setResultERKNS_12MemDepResultEPNS_5ValueE")
  //</editor-fold>
  public void setResult(final /*const*/ MemDepResult /*&*/ R, Value /*P*/ Addr) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::NonLocalDepResult::getResult">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryDependenceAnalysis.h", line = 242,
   FQN="llvm::NonLocalDepResult::getResult", NM="_ZNK4llvm17NonLocalDepResult9getResultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZNK4llvm17NonLocalDepResult9getResultEv")
  //</editor-fold>
  public /*const*/ MemDepResult /*&*/ getResult() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Returns the address of this pointer in this block.
  ///
  /// This can be different than the address queried for the non-local result
  /// because of phi translation.  This returns null if the address was not
  /// available in a block (i.e. because phi translation failed) or if this is
  /// a cached result and that address was deleted.
  ///
  /// The address is always null for a non-local 'call' dependence.
  //<editor-fold defaultstate="collapsed" desc="llvm::NonLocalDepResult::getAddress">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryDependenceAnalysis.h", line = 252,
   FQN="llvm::NonLocalDepResult::getAddress", NM="_ZNK4llvm17NonLocalDepResult10getAddressEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZNK4llvm17NonLocalDepResult10getAddressEv")
  //</editor-fold>
  public Value /*P*/ getAddress() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "Entry=" + Entry // NOI18N
              + ", Address=" + Address; // NOI18N
  }
}
