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

package org.llvm.adt;

import org.clank.support.*;


/// ilist_nextprev_traits - A fragment for template traits for intrusive list
/// that provides default next/prev implementations for common operations.
///
/*template <typename NodeTy> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::ilist_nextprev_traits">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 55,
 FQN="llvm::ilist_nextprev_traits", NM="_ZN4llvm21ilist_nextprev_traitsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN4llvm21ilist_nextprev_traitsE")
//</editor-fold>
public interface/*struct*/ ilist_nextprev_traits</*typename*/ NodeTy extends ilist_node<NodeTy>>  {
  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_nextprev_traits::getPrev">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 57,
   FQN="llvm::ilist_nextprev_traits::getPrev", NM="_ZN4llvm21ilist_nextprev_traits7getPrevEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN4llvm21ilist_nextprev_traits7getPrevEPT_")
  //</editor-fold>
  public default NodeTy /*P*/ getPrev(NodeTy /*P*/ N) {
    return N.getPrev();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_nextprev_traits::getNext">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 58,
   FQN="llvm::ilist_nextprev_traits::getNext", NM="_ZN4llvm21ilist_nextprev_traits7getNextEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN4llvm21ilist_nextprev_traits7getNextEPT_")
  //</editor-fold>
  public default NodeTy /*P*/ getNext(NodeTy /*P*/ N) {
    return N.getNext();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_nextprev_traits::getPrev">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 59,
   FQN="llvm::ilist_nextprev_traits::getPrev", NM="_ZN4llvm21ilist_nextprev_traits7getPrevEPKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp -nm=_ZN4llvm21ilist_nextprev_traits7getPrevEPKT_")
  //</editor-fold>
  public /*interface*/ default /*const*/ NodeTy /*P*/ getPrev_T$C$P(/*const*/ NodeTy /*P*/ N) {
    return N.getPrev();
  }
  
  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_nextprev_traits::getNext">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 60,
   FQN="llvm::ilist_nextprev_traits::getNext", NM="_ZN4llvm21ilist_nextprev_traits7getNextEPKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp -nm=_ZN4llvm21ilist_nextprev_traits7getNextEPKT_")
  //</editor-fold>
  public /*interface*/ default /*const*/ NodeTy /*P*/ getNext_T$C$P(/*const*/ NodeTy /*P*/ N) {
    return N.getNext();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_nextprev_traits::setPrev">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 62,
   FQN="llvm::ilist_nextprev_traits::setPrev", NM="_ZN4llvm21ilist_nextprev_traits7setPrevEPT_S2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN4llvm21ilist_nextprev_traits7setPrevEPT_S2_")
  //</editor-fold>
  public default void setPrev(NodeTy /*P*/ N, NodeTy /*P*/ Prev) {
    N.setPrev(Prev);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ilist_nextprev_traits::setNext">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION, source = "${LLVM_SRC}/llvm/include/llvm/ADT/ilist.h", line = 63,
   FQN="llvm::ilist_nextprev_traits::setNext", NM="_ZN4llvm21ilist_nextprev_traits7setNextEPT_S2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCXX.cpp -nm=_ZN4llvm21ilist_nextprev_traits7setNextEPT_S2_")
  //</editor-fold>
  public default void setNext(NodeTy /*P*/ N, NodeTy /*P*/ Next) {
    N.setNext(Next);
  }
}
