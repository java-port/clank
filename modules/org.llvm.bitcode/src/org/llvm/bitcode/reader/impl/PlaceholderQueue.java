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

package org.llvm.bitcode.reader.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.llvm.ir.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PlaceholderQueue">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 2077,
 FQN="(anonymous namespace)::PlaceholderQueue", NM="_ZN12_GLOBAL__N_116PlaceholderQueueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_116PlaceholderQueueE")
//</editor-fold>
public class PlaceholderQueue implements Destructors.ClassWithDestructor {
  // Placeholders would thrash around when moved, so store in a std::deque
  // instead of some sort of vector.
  private std.deque<DistinctMDOperandPlaceholder> PHs;
/*public:*/
  // end namespace
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PlaceholderQueue::getPlaceholderOp">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 2088,
   FQN="(anonymous namespace)::PlaceholderQueue::getPlaceholderOp", NM="_ZN12_GLOBAL__N_116PlaceholderQueue16getPlaceholderOpEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_116PlaceholderQueue16getPlaceholderOpEj")
  //</editor-fold>
  public DistinctMDOperandPlaceholder /*&*/ getPlaceholderOp(/*uint*/int ID) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PlaceholderQueue::flush">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 2093,
   FQN="(anonymous namespace)::PlaceholderQueue::flush", NM="_ZN12_GLOBAL__N_116PlaceholderQueue5flushERNS_25BitcodeReaderMetadataListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_116PlaceholderQueue5flushERNS_25BitcodeReaderMetadataListE")
  //</editor-fold>
  public void flush(BitcodeReaderMetadataList /*&*/ MetadataList) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PlaceholderQueue::~PlaceholderQueue">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 2077,
   FQN="(anonymous namespace)::PlaceholderQueue::~PlaceholderQueue", NM="_ZN12_GLOBAL__N_116PlaceholderQueueD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_116PlaceholderQueueD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PlaceholderQueue::PlaceholderQueue">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp", line = 2077,
   FQN="(anonymous namespace)::PlaceholderQueue::PlaceholderQueue", NM="_ZN12_GLOBAL__N_116PlaceholderQueueC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.bitcode/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Reader/BitcodeReader.cpp -nm=_ZN12_GLOBAL__N_116PlaceholderQueueC1Ev")
  //</editor-fold>
  public /*inline*/ PlaceholderQueue() {
    // : PHs() 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "PHs=" + PHs; // NOI18N
  }
}
