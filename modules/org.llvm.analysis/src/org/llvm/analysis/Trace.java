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

//<editor-fold defaultstate="collapsed" desc="llvm::Trace">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/Trace.h", line = 30,
 FQN="llvm::Trace", NM="_ZN4llvm5TraceE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Trace.cpp -nm=_ZN4llvm5TraceE")
//</editor-fold>
public class Trace implements Destructors.ClassWithDestructor {
  // JAVA: typedef std::vector<BasicBlock *> BasicBlockListType
//  public final class BasicBlockListType extends std.vector<BasicBlock /*P*/ >{ };
  private std.vector<BasicBlock /*P*/ > BasicBlocks;
/*public:*/
  /// Trace ctor - Make a new trace from a vector of basic blocks,
  /// residing in the function which is the parent of the first
  /// basic block in the vector.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::Trace::Trace">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/Trace.h", line = 39,
   FQN="llvm::Trace::Trace", NM="_ZN4llvm5TraceC1ERKSt6vectorIPNS_10BasicBlockESaIS3_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Trace.cpp -nm=_ZN4llvm5TraceC1ERKSt6vectorIPNS_10BasicBlockESaIS3_EE")
  //</editor-fold>
  public Trace(final /*const*/std.vector<BasicBlock /*P*/ > /*&*/ vBB) {
    // : BasicBlocks(vBB) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// getEntryBasicBlock - Return the entry basic block (first block)
  /// of the trace.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::Trace::getEntryBasicBlock">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/Trace.h", line = 44,
   FQN="llvm::Trace::getEntryBasicBlock", NM="_ZNK4llvm5Trace18getEntryBasicBlockEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Trace.cpp -nm=_ZNK4llvm5Trace18getEntryBasicBlockEv")
  //</editor-fold>
  public BasicBlock /*P*/ getEntryBasicBlock() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// operator[]/getBlock - Return basic block N in the trace.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::Trace::operator[]">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/Trace.h", line = 48,
   FQN="llvm::Trace::operator[]", NM="_ZNK4llvm5TraceixEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Trace.cpp -nm=_ZNK4llvm5TraceixEj")
  //</editor-fold>
  public BasicBlock /*P*/ $at(/*uint*/int i) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Trace::getBlock">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/Trace.h", line = 49,
   FQN="llvm::Trace::getBlock", NM="_ZNK4llvm5Trace8getBlockEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Trace.cpp -nm=_ZNK4llvm5Trace8getBlockEj")
  //</editor-fold>
  public BasicBlock /*P*/ getBlock(/*uint*/int i) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// getFunction - Return this trace's parent function.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::Trace::getFunction">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/Trace.cpp", line = 24,
   FQN="llvm::Trace::getFunction", NM="_ZNK4llvm5Trace11getFunctionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Trace.cpp -nm=_ZNK4llvm5Trace11getFunctionEv")
  //</editor-fold>
  public Function /*P*/ getFunction() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// getModule - Return this Module that contains this trace's parent
  /// function.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::Trace::getModule">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/Trace.cpp", line = 28,
   FQN="llvm::Trace::getModule", NM="_ZNK4llvm5Trace9getModuleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Trace.cpp -nm=_ZNK4llvm5Trace9getModuleEv")
  //</editor-fold>
  public Module /*P*/ getModule() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// getBlockIndex - Return the index of the specified basic block in the
  /// trace, or -1 if it is not in the trace.
  //<editor-fold defaultstate="collapsed" desc="llvm::Trace::getBlockIndex">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/Trace.h", line = 62,
   FQN="llvm::Trace::getBlockIndex", NM="_ZNK4llvm5Trace13getBlockIndexEPKNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Trace.cpp -nm=_ZNK4llvm5Trace13getBlockIndexEPKNS_10BasicBlockE")
  //</editor-fold>
  public int getBlockIndex(/*const*/ BasicBlock /*P*/ X) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// contains - Returns true if this trace contains the given basic
  /// block.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::Trace::contains">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/Trace.h", line = 72,
   FQN="llvm::Trace::contains", NM="_ZNK4llvm5Trace8containsEPKNS_10BasicBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Trace.cpp -nm=_ZNK4llvm5Trace8containsEPKNS_10BasicBlockE")
  //</editor-fold>
  public boolean contains(/*const*/ BasicBlock /*P*/ X) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Returns true if B1 occurs before B2 in the trace, or if it is the same
  /// block as B2..  Both blocks must be in the trace.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::Trace::dominates">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/Trace.h", line = 79,
   FQN="llvm::Trace::dominates", NM="_ZNK4llvm5Trace9dominatesEPKNS_10BasicBlockES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Trace.cpp -nm=_ZNK4llvm5Trace9dominatesEPKNS_10BasicBlockES3_")
  //</editor-fold>
  public boolean dominates(/*const*/ BasicBlock /*P*/ B1, /*const*/ BasicBlock /*P*/ B2) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // BasicBlock iterators...
  // JAVA: typedef BasicBlockListType::iterator iterator
//  public final class iterator extends std.vector.iterator<BasicBlock /*P*/ >{ };
  // JAVA: typedef BasicBlockListType::const_iterator const_iterator
//  public final class const_iterator extends std.vector.iterator</*const*/ BasicBlock /*P*/ >{ };
  // JAVA: typedef std::reverse_iterator<const_iterator> const_reverse_iterator
//  public final class const_reverse_iterator extends std.reverse_iterator</*const*/ BasicBlock /*&*/ >{ };
  // JAVA: typedef std::reverse_iterator<iterator> reverse_iterator
//  public final class reverse_iterator extends std.reverse_iterator<BasicBlock /*&*/ >{ };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::Trace::begin">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/Trace.h", line = 91,
   FQN="llvm::Trace::begin", NM="_ZN4llvm5Trace5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Trace.cpp -nm=_ZN4llvm5Trace5beginEv")
  //</editor-fold>
  public std.vector.iterator<BasicBlock /*P*/ > begin() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Trace::begin">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/Trace.h", line = 92,
   FQN="llvm::Trace::begin", NM="_ZNK4llvm5Trace5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Trace.cpp -nm=_ZNK4llvm5Trace5beginEv")
  //</editor-fold>
  public std.vector.iterator</*const*/ BasicBlock /*P*/ > begin$Const() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Trace::end">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/Trace.h", line = 93,
   FQN="llvm::Trace::end", NM="_ZN4llvm5Trace3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Trace.cpp -nm=_ZN4llvm5Trace3endEv")
  //</editor-fold>
  public std.vector.iterator<BasicBlock /*P*/ > end() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Trace::end">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/Trace.h", line = 94,
   FQN="llvm::Trace::end", NM="_ZNK4llvm5Trace3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Trace.cpp -nm=_ZNK4llvm5Trace3endEv")
  //</editor-fold>
  public std.vector.iterator</*const*/ BasicBlock /*P*/ > end$Const() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Trace::rbegin">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/Trace.h", line = 96,
   FQN="llvm::Trace::rbegin", NM="_ZN4llvm5Trace6rbeginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Trace.cpp -nm=_ZN4llvm5Trace6rbeginEv")
  //</editor-fold>
  public std.reverse_iterator<BasicBlock /*&*/ > rbegin() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Trace::rbegin">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/Trace.h", line = 97,
   FQN="llvm::Trace::rbegin", NM="_ZNK4llvm5Trace6rbeginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Trace.cpp -nm=_ZNK4llvm5Trace6rbeginEv")
  //</editor-fold>
  public std.reverse_iterator</*const*/ BasicBlock /*&*/ > rbegin$Const() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Trace::rend">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/Trace.h", line = 98,
   FQN="llvm::Trace::rend", NM="_ZN4llvm5Trace4rendEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Trace.cpp -nm=_ZN4llvm5Trace4rendEv")
  //</editor-fold>
  public std.reverse_iterator<BasicBlock /*&*/ > rend() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Trace::rend">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/Trace.h", line = 99,
   FQN="llvm::Trace::rend", NM="_ZNK4llvm5Trace4rendEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Trace.cpp -nm=_ZNK4llvm5Trace4rendEv")
  //</editor-fold>
  public std.reverse_iterator</*const*/ BasicBlock /*&*/ > rend$Const() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Trace::size">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/Trace.h", line = 101,
   FQN="llvm::Trace::size", NM="_ZNK4llvm5Trace4sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Trace.cpp -nm=_ZNK4llvm5Trace4sizeEv")
  //</editor-fold>
  public /*uint*/int size() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Trace::empty">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/Trace.h", line = 102,
   FQN="llvm::Trace::empty", NM="_ZNK4llvm5Trace5emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Trace.cpp -nm=_ZNK4llvm5Trace5emptyEv")
  //</editor-fold>
  public boolean empty() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Trace::erase">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/Trace.h", line = 104,
   FQN="llvm::Trace::erase", NM="_ZN4llvm5Trace5eraseEN9__gnu_cxx17__normal_iteratorIPPNS_10BasicBlockESt6vectorIS4_SaIS4_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Trace.cpp -nm=_ZN4llvm5Trace5eraseEN9__gnu_cxx17__normal_iteratorIPPNS_10BasicBlockESt6vectorIS4_SaIS4_EEEE")
  //</editor-fold>
  public std.vector.iterator<BasicBlock /*P*/ > erase(std.vector.iterator<BasicBlock /*P*/ > q) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Trace::erase">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/Trace.h", line = 105,
   FQN="llvm::Trace::erase", NM="_ZN4llvm5Trace5eraseEN9__gnu_cxx17__normal_iteratorIPPNS_10BasicBlockESt6vectorIS4_SaIS4_EEEES9_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Trace.cpp -nm=_ZN4llvm5Trace5eraseEN9__gnu_cxx17__normal_iteratorIPPNS_10BasicBlockESt6vectorIS4_SaIS4_EEEES9_")
  //</editor-fold>
  public std.vector.iterator<BasicBlock /*P*/ > erase(std.vector.iterator<BasicBlock /*P*/ > q1, std.vector.iterator<BasicBlock /*P*/ > q2) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// print - Write trace to output stream.
  ///
  
  /// print - Write trace to output stream.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::Trace::print">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/Trace.cpp", line = 34,
   FQN="llvm::Trace::print", NM="_ZNK4llvm5Trace5printERNS_11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Trace.cpp -nm=_ZNK4llvm5Trace5printERNS_11raw_ostreamE")
  //</editor-fold>
  public void print(final raw_ostream /*&*/ O) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// dump - Debugger convenience method; writes trace to standard error
  /// output stream.
  ///
  /// dump - Debugger convenience method; writes trace to standard error
  /// output stream.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::Trace::dump">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/Trace.cpp", line = 49,
   FQN="llvm::Trace::dump", NM="_ZNK4llvm5Trace4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Trace.cpp -nm=_ZNK4llvm5Trace4dumpEv")
  //</editor-fold>
  public void dump() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Trace::~Trace">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/Trace.h", line = 30,
   FQN="llvm::Trace::~Trace", NM="_ZN4llvm5TraceD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Trace.cpp -nm=_ZN4llvm5TraceD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  @Override public String toString() {
    return "" + "BasicBlocks=" + BasicBlocks; // NOI18N
  }
}
