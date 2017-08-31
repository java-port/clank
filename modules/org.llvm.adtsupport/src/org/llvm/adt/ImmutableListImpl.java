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
import static org.clank.support.Native.*;

/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::ImmutableListImpl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableList.h", line = 26,
 FQN="llvm::ImmutableListImpl", NM="_ZN4llvm17ImmutableListImplE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm17ImmutableListImplE")
//</editor-fold>
public class ImmutableListImpl</*typename*/ T>  extends FoldingSetImpl.NodeImpl implements /*public*/ FoldingSetImpl.Node {
  private T Head;
  private /*const*/ ImmutableListImpl<T> /*P*/ Tail;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableListImpl::ImmutableListImpl<T>">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableList.h", line = 31,
   FQN="llvm::ImmutableListImpl::ImmutableListImpl<T>", NM="_ZN4llvm17ImmutableListImplC1ERKT_PKNS_17ImmutableListImplIS1_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm17ImmutableListImplC1ERKT_PKNS_17ImmutableListImplIS1_EE")
  //</editor-fold>
  /*friend*//*private*/ ImmutableListImpl(final /*const*/ T /*&*/ head) {
    this(head, null);
  }
  /*friend*//*private*/ ImmutableListImpl(final /*const*/ T /*&*/ head, /*const*/ ImmutableListImpl<T> /*P*/ tail/*= null*/) {
    // : Head(head), Tail(tail) 
    $Node();
    //START JInit
    this.Head = /*ParenListExpr*/$tryClone(head);
    this.Tail = /*ParenListExpr*/tail;
    //END JInit
  }

  
  /*friend  class ImmutableListFactory<T>*/
  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableListImpl::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableList.h", line = 36,
   FQN="llvm::ImmutableListImpl::operator=", NM="_ZN4llvm17ImmutableListImplaSERKNS_17ImmutableListImplIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm17ImmutableListImplaSERKNS_17ImmutableListImplIT_EE")
  //</editor-fold>
  protected/*private*/ void $assign(final /*const*/ ImmutableListImpl<T> /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableListImpl::ImmutableListImpl<T>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableList.h", line = 37,
   FQN="llvm::ImmutableListImpl::ImmutableListImpl<T>", NM="_ZN4llvm17ImmutableListImplC1ERKNS_17ImmutableListImplIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm17ImmutableListImplC1ERKNS_17ImmutableListImplIT_EE")
  //</editor-fold>
  protected/*private*/ ImmutableListImpl(final /*const*/ ImmutableListImpl<T> /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableListImpl::getHead">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableList.h", line = 40,
   FQN="llvm::ImmutableListImpl::getHead", NM="_ZNK4llvm17ImmutableListImpl7getHeadEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm17ImmutableListImpl7getHeadEv")
  //</editor-fold>
  public /*const*/ T /*&*/ getHead() /*const*/ {
    return Head;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableListImpl::getTail">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableList.h", line = 41,
   FQN="llvm::ImmutableListImpl::getTail", NM="_ZNK4llvm17ImmutableListImpl7getTailEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm17ImmutableListImpl7getTailEv")
  //</editor-fold>
  public /*const*/ ImmutableListImpl<T> /*P*/ getTail() /*const*/ {
    return Tail;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableListImpl::Profile">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableList.h", line = 43,
   FQN="llvm::ImmutableListImpl::Profile", NM="_ZN4llvm17ImmutableListImpl7ProfileERNS_16FoldingSetNodeIDERKT_PKNS_17ImmutableListImplIS3_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm17ImmutableListImpl7ProfileERNS_16FoldingSetNodeIDERKT_PKNS_17ImmutableListImplIS3_EE")
  //</editor-fold>
  public static /*inline*/ </*typename*/ T> void Profile(final FoldingSetNodeID /*&*/ ID, final /*const*/ T /*&*/ H, 
         /*const*/ ImmutableListImpl<T> /*P*/ L) {
    ID.AddPointer(L);
    ID.Add((FoldingSetTrait.Profilable)H);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImmutableListImpl::Profile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableList.h", line = 49,
   FQN="llvm::ImmutableListImpl::Profile", NM="_ZN4llvm17ImmutableListImpl7ProfileERNS_16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm17ImmutableListImpl7ProfileERNS_16FoldingSetNodeIDE")
  //</editor-fold>
  public void Profile(final FoldingSetNodeID /*&*/ ID) {
    Profile(ID, Head, Tail);
  }

  
  @Override public String toString() {
    return "" + "Head=" + Head // NOI18N
              + ", Tail=" + Tail // NOI18N
              + super.toString(); // NOI18N
  }
}
